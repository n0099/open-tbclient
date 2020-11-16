package com.baidu.swan.games.bdtls.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.bdtls.e;
import com.baidu.swan.games.bdtls.model.i;
import java.io.IOException;
/* loaded from: classes7.dex */
public abstract class b {
    protected boolean dQK = false;
    protected int dQL = 0;
    private String dQM;

    public abstract void Y(byte[] bArr);

    public abstract void b(IOException iOException);

    public abstract void lY(int i);

    public final String Z(byte[] bArr) {
        String str = new String(bArr);
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "processResponseData encodeResponseData=" + str);
        }
        if (this.dQK) {
            i a2 = com.baidu.swan.games.bdtls.d.aSs().a(e.aSt().aSu(), bArr);
            if (a2 != null) {
                if (!TextUtils.isEmpty(a2.getResponseMessage())) {
                    str = a2.getResponseMessage();
                }
                this.dQL = a2.aTr().intValue();
            } else {
                this.dQL = -1;
            }
            e.aSt().aSu().lX(this.dQL);
            if (this.dQL == -1) {
                com.baidu.swan.games.bdtls.c.aSr().setEnable(false);
            }
        }
        return str;
    }

    public final void wq(String str) {
        this.dQL = 0;
        com.baidu.swan.games.bdtls.c.aSr().a(str, this);
    }

    public void hv(boolean z) {
        this.dQK = z;
    }

    public String getMethod() {
        return this.dQM;
    }

    public void wr(String str) {
        this.dQM = str;
    }
}
