package com.baidu.swan.games.r;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes8.dex */
public class f {
    private static volatile f dvD;
    private boolean dvE;
    private String dvF;
    private String dvG;

    public static f aOM() {
        if (dvD == null) {
            synchronized (f.class) {
                if (dvD == null) {
                    dvD = new f();
                }
            }
        }
        return dvD;
    }

    private f() {
    }

    public boolean aON() {
        return this.dvE;
    }

    public void gG(boolean z) {
        this.dvE = z;
    }

    public String aOO() {
        return TextUtils.isEmpty(this.dvG) ? "" : this.dvG + File.separator + "index.js";
    }

    public void vF(String str) {
        this.dvF = str;
    }

    public void vG(String str) {
        this.dvG = str;
    }
}
