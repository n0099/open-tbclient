package com.baidu.swan.games.bdtls.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.bdtls.e;
import com.baidu.swan.games.bdtls.model.i;
import java.io.IOException;
/* loaded from: classes8.dex */
public abstract class b {
    protected boolean ebT = false;
    protected int ebU = 0;
    private String mMethod;

    public abstract void W(byte[] bArr);

    public abstract void b(IOException iOException);

    public abstract void kY(int i);

    public final String X(byte[] bArr) {
        String str = new String(bArr);
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "processResponseData encodeResponseData=" + str);
        }
        if (this.ebT) {
            i a2 = com.baidu.swan.games.bdtls.d.aTY().a(e.aTZ().aUa(), bArr);
            if (a2 != null) {
                if (!TextUtils.isEmpty(a2.getResponseMessage())) {
                    str = a2.getResponseMessage();
                }
                this.ebU = a2.aUX().intValue();
            } else {
                this.ebU = -1;
            }
            e.aTZ().aUa().kX(this.ebU);
            if (this.ebU == -1) {
                com.baidu.swan.games.bdtls.c.aTX().setEnable(false);
            }
        }
        return str;
    }

    public final void vL(String str) {
        this.ebU = 0;
        com.baidu.swan.games.bdtls.c.aTX().a(str, this);
    }

    public void hY(boolean z) {
        this.ebT = z;
    }

    public String getMethod() {
        return this.mMethod;
    }

    public void vM(String str) {
        this.mMethod = str;
    }
}
