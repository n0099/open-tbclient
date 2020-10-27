package com.baidu.swan.games.bdtls.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.bdtls.e;
import com.baidu.swan.games.bdtls.model.i;
import java.io.IOException;
/* loaded from: classes10.dex */
public abstract class b {
    protected boolean dMA = false;
    protected int dMB = 0;
    private String dMC;

    public abstract void Y(byte[] bArr);

    public abstract void b(IOException iOException);

    public abstract void lS(int i);

    public final String Z(byte[] bArr) {
        String str = new String(bArr);
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "processResponseData encodeResponseData=" + str);
        }
        if (this.dMA) {
            i a2 = com.baidu.swan.games.bdtls.d.aQA().a(e.aQB().aQC(), bArr);
            if (a2 != null) {
                if (!TextUtils.isEmpty(a2.getResponseMessage())) {
                    str = a2.getResponseMessage();
                }
                this.dMB = a2.aRz().intValue();
            } else {
                this.dMB = -1;
            }
            e.aQB().aQC().lR(this.dMB);
            if (this.dMB == -1) {
                com.baidu.swan.games.bdtls.c.aQz().setEnable(false);
            }
        }
        return str;
    }

    public final void wh(String str) {
        this.dMB = 0;
        com.baidu.swan.games.bdtls.c.aQz().a(str, this);
    }

    public void hj(boolean z) {
        this.dMA = z;
    }

    public String getMethod() {
        return this.dMC;
    }

    public void wi(String str) {
        this.dMC = str;
    }
}
