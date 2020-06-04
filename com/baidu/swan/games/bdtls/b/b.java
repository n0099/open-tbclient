package com.baidu.swan.games.bdtls.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.bdtls.e;
import com.baidu.swan.games.bdtls.model.i;
import java.io.IOException;
/* loaded from: classes11.dex */
public abstract class b {
    protected boolean cVq = false;
    protected int cVr = 0;
    private String cVs;

    public abstract void V(byte[] bArr);

    public abstract void b(IOException iOException);

    public abstract void io(int i);

    public final String W(byte[] bArr) {
        String str = new String(bArr);
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "processResponseData encodeResponseData=" + str);
        }
        if (this.cVq) {
            i a = com.baidu.swan.games.bdtls.d.axM().a(e.axN().axO(), bArr);
            if (a != null) {
                if (!TextUtils.isEmpty(a.getResponseMessage())) {
                    str = a.getResponseMessage();
                }
                this.cVr = a.ayL().intValue();
            } else {
                this.cVr = -1;
            }
            e.axN().axO().in(this.cVr);
            if (this.cVr == -1) {
                com.baidu.swan.games.bdtls.c.axL().setEnable(false);
            }
        }
        return str;
    }

    public final void rk(String str) {
        this.cVr = 0;
        com.baidu.swan.games.bdtls.c.axL().a(str, this);
    }

    public void fJ(boolean z) {
        this.cVq = z;
    }

    public String getMethod() {
        return this.cVs;
    }

    public void rl(String str) {
        this.cVs = str;
    }
}
