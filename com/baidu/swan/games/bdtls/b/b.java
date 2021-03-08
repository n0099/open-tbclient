package com.baidu.swan.games.bdtls.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.bdtls.e;
import com.baidu.swan.games.bdtls.model.i;
import java.io.IOException;
/* loaded from: classes8.dex */
public abstract class b {
    protected boolean efB = false;
    protected int efC = 0;
    private String mMethod;

    public abstract void X(byte[] bArr);

    public abstract void b(IOException iOException);

    public abstract void lc(int i);

    public final String Y(byte[] bArr) {
        String str = new String(bArr);
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "processResponseData encodeResponseData=" + str);
        }
        if (this.efB) {
            i a2 = com.baidu.swan.games.bdtls.d.aUn().a(e.aUo().aUp(), bArr);
            if (a2 != null) {
                if (!TextUtils.isEmpty(a2.getResponseMessage())) {
                    str = a2.getResponseMessage();
                }
                this.efC = a2.aVm().intValue();
            } else {
                this.efC = -1;
            }
            e.aUo().aUp().lb(this.efC);
            if (this.efC == -1) {
                com.baidu.swan.games.bdtls.c.aUm().setEnable(false);
            }
        }
        return str;
    }

    public final void wl(String str) {
        this.efC = 0;
        com.baidu.swan.games.bdtls.c.aUm().a(str, this);
    }

    public void ia(boolean z) {
        this.efB = z;
    }

    public String getMethod() {
        return this.mMethod;
    }

    public void wm(String str) {
        this.mMethod = str;
    }
}
