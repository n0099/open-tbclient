package com.baidu.swan.games.r;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes10.dex */
public class f {
    private static volatile f dJJ;
    private boolean dJK;
    private String dJL;
    private String dJM;

    public static f aSg() {
        if (dJJ == null) {
            synchronized (f.class) {
                if (dJJ == null) {
                    dJJ = new f();
                }
            }
        }
        return dJJ;
    }

    private f() {
    }

    public boolean aSh() {
        return this.dJK;
    }

    public void hb(boolean z) {
        this.dJK = z;
    }

    public String aSi() {
        return TextUtils.isEmpty(this.dJM) ? "" : this.dJM + File.separator + "index.js";
    }

    public void wL(String str) {
        this.dJL = str;
    }

    public void wM(String str) {
        this.dJM = str;
    }
}
