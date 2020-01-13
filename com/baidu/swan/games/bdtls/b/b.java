package com.baidu.swan.games.bdtls.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.bdtls.d;
import com.baidu.swan.games.bdtls.e;
import com.baidu.swan.games.bdtls.model.i;
/* loaded from: classes10.dex */
public abstract class b {
    protected boolean chp = false;
    protected int chq = 0;

    public abstract void H(byte[] bArr);

    public abstract void hx(int i);

    public final String I(byte[] bArr) {
        String str = new String(bArr);
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "processResponseData encodeResponseData=" + str);
        }
        if (this.chp) {
            i a = d.ajs().a(e.ajt().aju(), bArr);
            if (a != null) {
                if (!TextUtils.isEmpty(a.akr())) {
                    str = a.akr();
                }
                this.chq = a.aks().intValue();
            } else {
                this.chq = -1;
            }
            e.ajt().aju().hw(this.chq);
            if (this.chq == -1) {
                com.baidu.swan.games.bdtls.c.ajr().setEnable(false);
            }
        }
        return str;
    }

    public final void oh(String str) {
        this.chq = 0;
        com.baidu.swan.games.bdtls.c.ajr().a(str, this);
    }

    public void et(boolean z) {
        this.chp = z;
    }
}
