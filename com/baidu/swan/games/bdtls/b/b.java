package com.baidu.swan.games.bdtls.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.bdtls.d;
import com.baidu.swan.games.bdtls.e;
import com.baidu.swan.games.bdtls.model.i;
/* loaded from: classes9.dex */
public abstract class b {
    protected boolean chc = false;
    protected int chd = 0;

    public abstract void I(byte[] bArr);

    public abstract void hx(int i);

    public final String J(byte[] bArr) {
        String str = new String(bArr);
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "processResponseData encodeResponseData=" + str);
        }
        if (this.chc) {
            i a = d.aiZ().a(e.aja().ajb(), bArr);
            if (a != null) {
                if (!TextUtils.isEmpty(a.ajY())) {
                    str = a.ajY();
                }
                this.chd = a.ajZ().intValue();
            } else {
                this.chd = -1;
            }
            e.aja().ajb().hw(this.chd);
            if (this.chd == -1) {
                com.baidu.swan.games.bdtls.c.aiY().setEnable(false);
            }
        }
        return str;
    }

    public final void od(String str) {
        this.chd = 0;
        com.baidu.swan.games.bdtls.c.aiY().a(str, this);
    }

    public void eo(boolean z) {
        this.chc = z;
    }
}
