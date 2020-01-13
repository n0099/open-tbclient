package com.baidu.swan.games.q;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes10.dex */
public class f {
    private static volatile f cmP;
    private boolean cmQ;
    private String cmR;
    private String cmS;

    public static f amM() {
        if (cmP == null) {
            synchronized (f.class) {
                if (cmP == null) {
                    cmP = new f();
                }
            }
        }
        return cmP;
    }

    private f() {
    }

    public boolean amN() {
        return this.cmQ;
    }

    public void ey(boolean z) {
        this.cmQ = z;
    }

    public String amO() {
        return TextUtils.isEmpty(this.cmS) ? "" : this.cmS + File.separator + "index.js";
    }

    public void pe(String str) {
        this.cmR = str;
    }

    public void pf(String str) {
        this.cmS = str;
    }
}
