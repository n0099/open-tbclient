package com.baidu.swan.games.bdtls.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.bdtls.e;
import com.baidu.swan.games.bdtls.model.i;
import java.io.IOException;
/* loaded from: classes8.dex */
public abstract class b {
    protected boolean dpY = false;
    protected int dpZ = 0;
    private String dqa;

    public abstract void Y(byte[] bArr);

    public abstract void b(IOException iOException);

    public abstract void kZ(int i);

    public final String Z(byte[] bArr) {
        String str = new String(bArr);
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "processResponseData encodeResponseData=" + str);
        }
        if (this.dpY) {
            i a = com.baidu.swan.games.bdtls.d.aLm().a(e.aLn().aLo(), bArr);
            if (a != null) {
                if (!TextUtils.isEmpty(a.getResponseMessage())) {
                    str = a.getResponseMessage();
                }
                this.dpZ = a.aMl().intValue();
            } else {
                this.dpZ = -1;
            }
            e.aLn().aLo().kY(this.dpZ);
            if (this.dpZ == -1) {
                com.baidu.swan.games.bdtls.c.aLl().setEnable(false);
            }
        }
        return str;
    }

    public final void uJ(String str) {
        this.dpZ = 0;
        com.baidu.swan.games.bdtls.c.aLl().a(str, this);
    }

    public void gC(boolean z) {
        this.dpY = z;
    }

    public String getMethod() {
        return this.dqa;
    }

    public void uK(String str) {
        this.dqa = str;
    }
}
