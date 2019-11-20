package com.baidu.swan.games.o;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes2.dex */
public class f {
    private static volatile f bCo;
    private boolean bCp;
    private String bCq;
    private String bCr;

    public static f XB() {
        if (bCo == null) {
            synchronized (f.class) {
                if (bCo == null) {
                    bCo = new f();
                }
            }
        }
        return bCo;
    }

    private f() {
    }

    public boolean XC() {
        return this.bCp;
    }

    public void dj(boolean z) {
        this.bCp = z;
    }

    public String XD() {
        return TextUtils.isEmpty(this.bCr) ? "" : this.bCr + File.separator + "index.js";
    }

    public void ks(String str) {
        this.bCq = str;
    }

    public void kt(String str) {
        this.bCr = str;
    }
}
