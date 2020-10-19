package com.baidu.swan.games.bdtls.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.bdtls.e;
import com.baidu.swan.games.bdtls.model.i;
import java.io.IOException;
/* loaded from: classes10.dex */
public abstract class b {
    protected boolean dEd = false;
    protected int dEe = 0;
    private String dEf;

    public abstract void Y(byte[] bArr);

    public abstract void b(IOException iOException);

    public abstract void lH(int i);

    public final String Z(byte[] bArr) {
        String str = new String(bArr);
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "processResponseData encodeResponseData=" + str);
        }
        if (this.dEd) {
            i a2 = com.baidu.swan.games.bdtls.d.aOG().a(e.aOH().aOI(), bArr);
            if (a2 != null) {
                if (!TextUtils.isEmpty(a2.getResponseMessage())) {
                    str = a2.getResponseMessage();
                }
                this.dEe = a2.aPF().intValue();
            } else {
                this.dEe = -1;
            }
            e.aOH().aOI().lG(this.dEe);
            if (this.dEe == -1) {
                com.baidu.swan.games.bdtls.c.aOF().setEnable(false);
            }
        }
        return str;
    }

    public final void vO(String str) {
        this.dEe = 0;
        com.baidu.swan.games.bdtls.c.aOF().a(str, this);
    }

    public void gW(boolean z) {
        this.dEd = z;
    }

    public String getMethod() {
        return this.dEf;
    }

    public void vP(String str) {
        this.dEf = str;
    }
}
