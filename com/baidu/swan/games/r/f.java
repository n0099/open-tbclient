package com.baidu.swan.games.r;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes25.dex */
public class f {
    private static volatile f edp;
    private boolean edq;
    private String edr;
    private String eds;

    public static f aYX() {
        if (edp == null) {
            synchronized (f.class) {
                if (edp == null) {
                    edp = new f();
                }
            }
        }
        return edp;
    }

    private f() {
    }

    public boolean aYY() {
        return this.edq;
    }

    public void hP(boolean z) {
        this.edq = z;
    }

    public String aYZ() {
        return TextUtils.isEmpty(this.eds) ? "" : this.eds + File.separator + "index.js";
    }

    public void xU(String str) {
        this.edr = str;
    }

    public void xV(String str) {
        this.eds = str;
    }
}
