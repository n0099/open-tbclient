package com.baidu.swan.games.bdtls.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.bdtls.e;
import com.baidu.swan.games.bdtls.model.i;
import java.io.IOException;
/* loaded from: classes9.dex */
public abstract class b {
    protected boolean egG = false;
    protected int egH = 0;
    private String mMethod;

    public abstract void X(byte[] bArr);

    public abstract void b(IOException iOException);

    public abstract void mE(int i);

    public final String Y(byte[] bArr) {
        String str = new String(bArr);
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "processResponseData encodeResponseData=" + str);
        }
        if (this.egG) {
            i a2 = com.baidu.swan.games.bdtls.d.aXR().a(e.aXS().aXT(), bArr);
            if (a2 != null) {
                if (!TextUtils.isEmpty(a2.getResponseMessage())) {
                    str = a2.getResponseMessage();
                }
                this.egH = a2.aYQ().intValue();
            } else {
                this.egH = -1;
            }
            e.aXS().aXT().mD(this.egH);
            if (this.egH == -1) {
                com.baidu.swan.games.bdtls.c.aXQ().setEnable(false);
            }
        }
        return str;
    }

    public final void wW(String str) {
        this.egH = 0;
        com.baidu.swan.games.bdtls.c.aXQ().a(str, this);
    }

    public void ic(boolean z) {
        this.egG = z;
    }

    public String getMethod() {
        return this.mMethod;
    }

    public void wX(String str) {
        this.mMethod = str;
    }
}
