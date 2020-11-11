package com.baidu.swan.games.bdtls.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.bdtls.e;
import com.baidu.swan.games.bdtls.model.i;
import java.io.IOException;
/* loaded from: classes10.dex */
public abstract class b {
    protected boolean dSs = false;
    protected int dSt = 0;
    private String dSu;

    public abstract void Y(byte[] bArr);

    public abstract void b(IOException iOException);

    public abstract void mc(int i);

    public final String Z(byte[] bArr) {
        String str = new String(bArr);
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "processResponseData encodeResponseData=" + str);
        }
        if (this.dSs) {
            i a2 = com.baidu.swan.games.bdtls.d.aTa().a(e.aTb().aTc(), bArr);
            if (a2 != null) {
                if (!TextUtils.isEmpty(a2.getResponseMessage())) {
                    str = a2.getResponseMessage();
                }
                this.dSt = a2.aTZ().intValue();
            } else {
                this.dSt = -1;
            }
            e.aTb().aTc().mb(this.dSt);
            if (this.dSt == -1) {
                com.baidu.swan.games.bdtls.c.aSZ().setEnable(false);
            }
        }
        return str;
    }

    public final void wv(String str) {
        this.dSt = 0;
        com.baidu.swan.games.bdtls.c.aSZ().a(str, this);
    }

    public void hs(boolean z) {
        this.dSs = z;
    }

    public String getMethod() {
        return this.dSu;
    }

    public void ww(String str) {
        this.dSu = str;
    }
}
