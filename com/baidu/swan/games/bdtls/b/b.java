package com.baidu.swan.games.bdtls.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.bdtls.d;
import com.baidu.swan.games.bdtls.e;
import com.baidu.swan.games.bdtls.model.i;
/* loaded from: classes11.dex */
public abstract class b {
    protected boolean cKJ = false;
    protected int cKK = 0;

    public abstract void O(byte[] bArr);

    public abstract void hV(int i);

    public final String P(byte[] bArr) {
        String str = new String(bArr);
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "processResponseData encodeResponseData=" + str);
        }
        if (this.cKJ) {
            i a = d.atZ().a(e.aua().aub(), bArr);
            if (a != null) {
                if (!TextUtils.isEmpty(a.getResponseMessage())) {
                    str = a.getResponseMessage();
                }
                this.cKK = a.auY().intValue();
            } else {
                this.cKK = -1;
            }
            e.aua().aub().hU(this.cKK);
            if (this.cKK == -1) {
                com.baidu.swan.games.bdtls.c.atY().setEnable(false);
            }
        }
        return str;
    }

    public final void pJ(String str) {
        this.cKK = 0;
        com.baidu.swan.games.bdtls.c.atY().a(str, this);
    }

    public void fy(boolean z) {
        this.cKJ = z;
    }
}
