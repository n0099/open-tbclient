package com.baidu.swan.games.r;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes8.dex */
public class f {
    private static volatile f dvH;
    private boolean dvI;
    private String dvJ;
    private String dvK;

    public static f aOM() {
        if (dvH == null) {
            synchronized (f.class) {
                if (dvH == null) {
                    dvH = new f();
                }
            }
        }
        return dvH;
    }

    private f() {
    }

    public boolean aON() {
        return this.dvI;
    }

    public void gH(boolean z) {
        this.dvI = z;
    }

    public String aOO() {
        return TextUtils.isEmpty(this.dvK) ? "" : this.dvK + File.separator + "index.js";
    }

    public void vG(String str) {
        this.dvJ = str;
    }

    public void vH(String str) {
        this.dvK = str;
    }
}
