package com.baidu.swan.games.bdtls.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.bdtls.e;
import com.baidu.swan.games.bdtls.model.i;
import java.io.IOException;
/* loaded from: classes9.dex */
public abstract class b {
    protected boolean eea = false;
    protected int eeb = 0;
    private String mMethod;

    public abstract void V(byte[] bArr);

    public abstract void b(IOException iOException);

    public abstract void lb(int i);

    public final String W(byte[] bArr) {
        String str = new String(bArr);
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "processResponseData encodeResponseData=" + str);
        }
        if (this.eea) {
            i a2 = com.baidu.swan.games.bdtls.d.aUk().a(e.aUl().aUm(), bArr);
            if (a2 != null) {
                if (!TextUtils.isEmpty(a2.getResponseMessage())) {
                    str = a2.getResponseMessage();
                }
                this.eeb = a2.aVj().intValue();
            } else {
                this.eeb = -1;
            }
            e.aUl().aUm().la(this.eeb);
            if (this.eeb == -1) {
                com.baidu.swan.games.bdtls.c.aUj().setEnable(false);
            }
        }
        return str;
    }

    public final void we(String str) {
        this.eeb = 0;
        com.baidu.swan.games.bdtls.c.aUj().a(str, this);
    }

    public void ia(boolean z) {
        this.eea = z;
    }

    public String getMethod() {
        return this.mMethod;
    }

    public void wf(String str) {
        this.mMethod = str;
    }
}
