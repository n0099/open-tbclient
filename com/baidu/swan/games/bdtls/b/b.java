package com.baidu.swan.games.bdtls.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.bdtls.d;
import com.baidu.swan.games.bdtls.e;
import com.baidu.swan.games.bdtls.model.i;
/* loaded from: classes11.dex */
public abstract class b {
    protected boolean clG = false;
    protected int clH = 0;

    public abstract void M(byte[] bArr);

    public abstract void hO(int i);

    public final String N(byte[] bArr) {
        String str = new String(bArr);
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "processResponseData encodeResponseData=" + str);
        }
        if (this.clG) {
            i a = d.alL().a(e.alM().alN(), bArr);
            if (a != null) {
                if (!TextUtils.isEmpty(a.amK())) {
                    str = a.amK();
                }
                this.clH = a.amL().intValue();
            } else {
                this.clH = -1;
            }
            e.alM().alN().hN(this.clH);
            if (this.clH == -1) {
                com.baidu.swan.games.bdtls.c.alK().setEnable(false);
            }
        }
        return str;
    }

    public final void ow(String str) {
        this.clH = 0;
        com.baidu.swan.games.bdtls.c.alK().a(str, this);
    }

    public void eB(boolean z) {
        this.clG = z;
    }
}
