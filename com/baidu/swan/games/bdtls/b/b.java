package com.baidu.swan.games.bdtls.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.bdtls.d;
import com.baidu.swan.games.bdtls.e;
import com.baidu.swan.games.bdtls.model.i;
/* loaded from: classes11.dex */
public abstract class b {
    protected boolean clv = false;
    protected int clw = 0;

    public abstract void M(byte[] bArr);

    public abstract void hO(int i);

    public final String N(byte[] bArr) {
        String str = new String(bArr);
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "processResponseData encodeResponseData=" + str);
        }
        if (this.clv) {
            i a = d.alI().a(e.alJ().alK(), bArr);
            if (a != null) {
                if (!TextUtils.isEmpty(a.amH())) {
                    str = a.amH();
                }
                this.clw = a.amI().intValue();
            } else {
                this.clw = -1;
            }
            e.alJ().alK().hN(this.clw);
            if (this.clw == -1) {
                com.baidu.swan.games.bdtls.c.alH().setEnable(false);
            }
        }
        return str;
    }

    public final void ox(String str) {
        this.clw = 0;
        com.baidu.swan.games.bdtls.c.alH().a(str, this);
    }

    public void eA(boolean z) {
        this.clv = z;
    }
}
