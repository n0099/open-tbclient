package com.baidu.swan.games.q;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes11.dex */
public class f {
    private static volatile f cQa;
    private boolean cQb;
    private String cQc;
    private String cQd;

    public static f axr() {
        if (cQa == null) {
            synchronized (f.class) {
                if (cQa == null) {
                    cQa = new f();
                }
            }
        }
        return cQa;
    }

    private f() {
    }

    public boolean axs() {
        return this.cQb;
    }

    public void fD(boolean z) {
        this.cQb = z;
    }

    public String axt() {
        return TextUtils.isEmpty(this.cQd) ? "" : this.cQd + File.separator + "index.js";
    }

    public void qF(String str) {
        this.cQc = str;
    }

    public void qG(String str) {
        this.cQd = str;
    }
}
