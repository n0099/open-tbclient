package com.baidu.swan.games.o;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes2.dex */
public class f {
    private static volatile f bDf;
    private boolean bDg;
    private String bDh;
    private String bDi;

    public static f XD() {
        if (bDf == null) {
            synchronized (f.class) {
                if (bDf == null) {
                    bDf = new f();
                }
            }
        }
        return bDf;
    }

    private f() {
    }

    public boolean XE() {
        return this.bDg;
    }

    public void dj(boolean z) {
        this.bDg = z;
    }

    public String XF() {
        return TextUtils.isEmpty(this.bDi) ? "" : this.bDi + File.separator + "index.js";
    }

    public void ks(String str) {
        this.bDh = str;
    }

    public void kt(String str) {
        this.bDi = str;
    }
}
