package com.baidu.swan.games.bdtls.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.bdtls.e;
import com.baidu.swan.games.bdtls.model.i;
import java.io.IOException;
/* loaded from: classes8.dex */
public abstract class b {
    protected boolean dpU = false;
    protected int dpV = 0;
    private String dpW;

    public abstract void Y(byte[] bArr);

    public abstract void b(IOException iOException);

    public abstract void kZ(int i);

    public final String Z(byte[] bArr) {
        String str = new String(bArr);
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "processResponseData encodeResponseData=" + str);
        }
        if (this.dpU) {
            i a = com.baidu.swan.games.bdtls.d.aLm().a(e.aLn().aLo(), bArr);
            if (a != null) {
                if (!TextUtils.isEmpty(a.getResponseMessage())) {
                    str = a.getResponseMessage();
                }
                this.dpV = a.aMl().intValue();
            } else {
                this.dpV = -1;
            }
            e.aLn().aLo().kY(this.dpV);
            if (this.dpV == -1) {
                com.baidu.swan.games.bdtls.c.aLl().setEnable(false);
            }
        }
        return str;
    }

    public final void uI(String str) {
        this.dpV = 0;
        com.baidu.swan.games.bdtls.c.aLl().a(str, this);
    }

    public void gB(boolean z) {
        this.dpU = z;
    }

    public String getMethod() {
        return this.dpW;
    }

    public void uJ(String str) {
        this.dpW = str;
    }
}
