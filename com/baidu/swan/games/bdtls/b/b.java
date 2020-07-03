package com.baidu.swan.games.bdtls.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.bdtls.e;
import com.baidu.swan.games.bdtls.model.i;
import java.io.IOException;
/* loaded from: classes11.dex */
public abstract class b {
    protected boolean daa = false;
    protected int dab = 0;
    private String dac;

    public abstract void X(byte[] bArr);

    public abstract void b(IOException iOException);

    public abstract void iz(int i);

    public final String Y(byte[] bArr) {
        String str = new String(bArr);
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "processResponseData encodeResponseData=" + str);
        }
        if (this.daa) {
            i a = com.baidu.swan.games.bdtls.d.ayS().a(e.ayT().ayU(), bArr);
            if (a != null) {
                if (!TextUtils.isEmpty(a.getResponseMessage())) {
                    str = a.getResponseMessage();
                }
                this.dab = a.azR().intValue();
            } else {
                this.dab = -1;
            }
            e.ayT().ayU().iy(this.dab);
            if (this.dab == -1) {
                com.baidu.swan.games.bdtls.c.ayR().setEnable(false);
            }
        }
        return str;
    }

    public final void rs(String str) {
        this.dab = 0;
        com.baidu.swan.games.bdtls.c.ayR().a(str, this);
    }

    public void fO(boolean z) {
        this.daa = z;
    }

    public String getMethod() {
        return this.dac;
    }

    public void rt(String str) {
        this.dac = str;
    }
}
