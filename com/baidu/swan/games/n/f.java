package com.baidu.swan.games.n;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes2.dex */
public class f {
    private static volatile f beP;
    private boolean beQ;
    private String beR;

    public static f OK() {
        if (beP == null) {
            synchronized (f.class) {
                if (beP == null) {
                    beP = new f();
                }
            }
        }
        return beP;
    }

    private f() {
    }

    public boolean OL() {
        return this.beQ;
    }

    public void cy(boolean z) {
        this.beQ = z;
    }

    public String OM() {
        return this.beR;
    }

    public String ON() {
        if (TextUtils.isEmpty(OM())) {
            return "";
        }
        return new File(OM()).getName() + File.separator + "index.js";
    }

    public void iU(String str) {
        this.beR = str;
    }
}
