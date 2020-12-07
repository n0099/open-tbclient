package com.baidu.swan.games.bdtls.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.bdtls.e;
import com.baidu.swan.games.bdtls.model.i;
import java.io.IOException;
/* loaded from: classes25.dex */
public abstract class b {
    protected boolean dXI = false;
    protected int dXJ = 0;
    private String dXK;

    public abstract void aa(byte[] bArr);

    public abstract void b(IOException iOException);

    public abstract void mw(int i);

    public final String ab(byte[] bArr) {
        String str = new String(bArr);
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "processResponseData encodeResponseData=" + str);
        }
        if (this.dXI) {
            i a2 = com.baidu.swan.games.bdtls.d.aVx().a(e.aVy().aVz(), bArr);
            if (a2 != null) {
                if (!TextUtils.isEmpty(a2.getResponseMessage())) {
                    str = a2.getResponseMessage();
                }
                this.dXJ = a2.aWw().intValue();
            } else {
                this.dXJ = -1;
            }
            e.aVy().aVz().mv(this.dXJ);
            if (this.dXJ == -1) {
                com.baidu.swan.games.bdtls.c.aVw().setEnable(false);
            }
        }
        return str;
    }

    public final void wX(String str) {
        this.dXJ = 0;
        com.baidu.swan.games.bdtls.c.aVw().a(str, this);
    }

    public void hK(boolean z) {
        this.dXI = z;
    }

    public String getMethod() {
        return this.dXK;
    }

    public void wY(String str) {
        this.dXK = str;
    }
}
