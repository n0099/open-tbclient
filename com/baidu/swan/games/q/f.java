package com.baidu.swan.games.q;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes11.dex */
public class f {
    private static volatile f cqR;
    private boolean cqS;
    private String cqT;
    private String cqU;

    public static f aoZ() {
        if (cqR == null) {
            synchronized (f.class) {
                if (cqR == null) {
                    cqR = new f();
                }
            }
        }
        return cqR;
    }

    private f() {
    }

    public boolean apa() {
        return this.cqS;
    }

    public void eF(boolean z) {
        this.cqS = z;
    }

    public String apb() {
        return TextUtils.isEmpty(this.cqU) ? "" : this.cqU + File.separator + "index.js";
    }

    public void pt(String str) {
        this.cqT = str;
    }

    public void pu(String str) {
        this.cqU = str;
    }
}
