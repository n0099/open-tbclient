package com.baidu.swan.games.bdtls.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.bdtls.e;
import com.baidu.swan.games.bdtls.model.i;
import java.io.IOException;
/* loaded from: classes3.dex */
public abstract class b {
    protected boolean dsa = false;
    protected int dsb = 0;
    private String dsc;

    public abstract void Y(byte[] bArr);

    public abstract void b(IOException iOException);

    public abstract void lk(int i);

    public final String Z(byte[] bArr) {
        String str = new String(bArr);
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "processResponseData encodeResponseData=" + str);
        }
        if (this.dsa) {
            i a = com.baidu.swan.games.bdtls.d.aLX().a(e.aLY().aLZ(), bArr);
            if (a != null) {
                if (!TextUtils.isEmpty(a.getResponseMessage())) {
                    str = a.getResponseMessage();
                }
                this.dsb = a.aMW().intValue();
            } else {
                this.dsb = -1;
            }
            e.aLY().aLZ().lj(this.dsb);
            if (this.dsb == -1) {
                com.baidu.swan.games.bdtls.c.aLW().setEnable(false);
            }
        }
        return str;
    }

    public final void vc(String str) {
        this.dsb = 0;
        com.baidu.swan.games.bdtls.c.aLW().a(str, this);
    }

    public void gA(boolean z) {
        this.dsa = z;
    }

    public String getMethod() {
        return this.dsc;
    }

    public void vd(String str) {
        this.dsc = str;
    }
}
