package com.baidu.swan.games.q;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes9.dex */
public class f {
    private static volatile f cmC;
    private boolean cmD;
    private String cmE;
    private String cmF;

    public static f amt() {
        if (cmC == null) {
            synchronized (f.class) {
                if (cmC == null) {
                    cmC = new f();
                }
            }
        }
        return cmC;
    }

    private f() {
    }

    public boolean amu() {
        return this.cmD;
    }

    public void et(boolean z) {
        this.cmD = z;
    }

    public String amv() {
        return TextUtils.isEmpty(this.cmF) ? "" : this.cmF + File.separator + "index.js";
    }

    public void pb(String str) {
        this.cmE = str;
    }

    public void pc(String str) {
        this.cmF = str;
    }
}
