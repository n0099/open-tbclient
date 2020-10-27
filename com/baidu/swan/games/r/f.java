package com.baidu.swan.games.r;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes10.dex */
public class f {
    private static volatile f dSg;
    private boolean dSh;
    private String dSi;
    private String dSj;

    public static f aUa() {
        if (dSg == null) {
            synchronized (f.class) {
                if (dSg == null) {
                    dSg = new f();
                }
            }
        }
        return dSg;
    }

    private f() {
    }

    public boolean aUb() {
        return this.dSh;
    }

    public void ho(boolean z) {
        this.dSh = z;
    }

    public String aUc() {
        return TextUtils.isEmpty(this.dSj) ? "" : this.dSj + File.separator + "index.js";
    }

    public void xe(String str) {
        this.dSi = str;
    }

    public void xf(String str) {
        this.dSj = str;
    }
}
