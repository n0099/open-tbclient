package com.baidu.swan.games.bdtls.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.bdtls.d;
import com.baidu.swan.games.bdtls.e;
import com.baidu.swan.games.bdtls.model.i;
/* loaded from: classes11.dex */
public abstract class b {
    protected boolean clt = false;
    protected int clu = 0;

    public abstract void M(byte[] bArr);

    public abstract void hO(int i);

    public final String N(byte[] bArr) {
        String str = new String(bArr);
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "processResponseData encodeResponseData=" + str);
        }
        if (this.clt) {
            i a = d.alG().a(e.alH().alI(), bArr);
            if (a != null) {
                if (!TextUtils.isEmpty(a.amF())) {
                    str = a.amF();
                }
                this.clu = a.amG().intValue();
            } else {
                this.clu = -1;
            }
            e.alH().alI().hN(this.clu);
            if (this.clu == -1) {
                com.baidu.swan.games.bdtls.c.alF().setEnable(false);
            }
        }
        return str;
    }

    public final void ox(String str) {
        this.clu = 0;
        com.baidu.swan.games.bdtls.c.alF().a(str, this);
    }

    public void eA(boolean z) {
        this.clt = z;
    }
}
