package com.baidu.swan.games.r;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes11.dex */
public class f {
    private static volatile f dfP;
    private boolean dfQ;
    private String dfR;
    private String dfS;

    public static f aCo() {
        if (dfP == null) {
            synchronized (f.class) {
                if (dfP == null) {
                    dfP = new f();
                }
            }
        }
        return dfP;
    }

    private f() {
    }

    public boolean aCp() {
        return this.dfQ;
    }

    public void fT(boolean z) {
        this.dfQ = z;
    }

    public String aCq() {
        return TextUtils.isEmpty(this.dfS) ? "" : this.dfS + File.separator + "index.js";
    }

    public void sq(String str) {
        this.dfR = str;
    }

    public void ss(String str) {
        this.dfS = str;
    }
}
