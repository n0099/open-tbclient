package com.baidu.swan.games.r;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes7.dex */
public class f {
    private static volatile f dly;
    private String dlA;
    private String dlB;
    private boolean dlz;

    public static f aFV() {
        if (dly == null) {
            synchronized (f.class) {
                if (dly == null) {
                    dly = new f();
                }
            }
        }
        return dly;
    }

    private f() {
    }

    public boolean aFW() {
        return this.dlz;
    }

    public void gk(boolean z) {
        this.dlz = z;
    }

    public String aFX() {
        return TextUtils.isEmpty(this.dlB) ? "" : this.dlB + File.separator + "index.js";
    }

    public void tp(String str) {
        this.dlA = str;
    }

    public void tq(String str) {
        this.dlB = str;
    }
}
