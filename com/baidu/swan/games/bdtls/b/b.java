package com.baidu.swan.games.bdtls.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.bdtls.e;
import com.baidu.swan.games.bdtls.model.i;
import java.io.IOException;
/* loaded from: classes7.dex */
public abstract class b {
    protected boolean dfL = false;
    protected int dfM = 0;
    private String dfN;

    public abstract void X(byte[] bArr);

    public abstract void b(IOException iOException);

    public abstract void iQ(int i);

    public final String Y(byte[] bArr) {
        String str = new String(bArr);
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "processResponseData encodeResponseData=" + str);
        }
        if (this.dfL) {
            i a = com.baidu.swan.games.bdtls.d.aCx().a(e.aCy().aCz(), bArr);
            if (a != null) {
                if (!TextUtils.isEmpty(a.getResponseMessage())) {
                    str = a.getResponseMessage();
                }
                this.dfM = a.aDw().intValue();
            } else {
                this.dfM = -1;
            }
            e.aCy().aCz().iP(this.dfM);
            if (this.dfM == -1) {
                com.baidu.swan.games.bdtls.c.aCw().setEnable(false);
            }
        }
        return str;
    }

    public final void sq(String str) {
        this.dfM = 0;
        com.baidu.swan.games.bdtls.c.aCw().a(str, this);
    }

    public void gf(boolean z) {
        this.dfL = z;
    }

    public String getMethod() {
        return this.dfN;
    }

    public void ss(String str) {
        this.dfN = str;
    }
}
