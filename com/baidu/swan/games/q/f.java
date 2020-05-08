package com.baidu.swan.games.q;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes11.dex */
public class f {
    private static volatile f cQf;
    private boolean cQg;
    private String cQh;
    private String cQi;

    public static f axr() {
        if (cQf == null) {
            synchronized (f.class) {
                if (cQf == null) {
                    cQf = new f();
                }
            }
        }
        return cQf;
    }

    private f() {
    }

    public boolean axs() {
        return this.cQg;
    }

    public void fD(boolean z) {
        this.cQg = z;
    }

    public String axt() {
        return TextUtils.isEmpty(this.cQi) ? "" : this.cQi + File.separator + "index.js";
    }

    public void qF(String str) {
        this.cQh = str;
    }

    public void qG(String str) {
        this.cQi = str;
    }
}
