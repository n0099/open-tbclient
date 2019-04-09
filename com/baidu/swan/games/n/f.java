package com.baidu.swan.games.n;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes2.dex */
public class f {
    private static volatile f beQ;
    private boolean beR;
    private String beS;

    public static f OK() {
        if (beQ == null) {
            synchronized (f.class) {
                if (beQ == null) {
                    beQ = new f();
                }
            }
        }
        return beQ;
    }

    private f() {
    }

    public boolean OL() {
        return this.beR;
    }

    public void cy(boolean z) {
        this.beR = z;
    }

    public String OM() {
        return this.beS;
    }

    public String ON() {
        if (TextUtils.isEmpty(OM())) {
            return "";
        }
        return new File(OM()).getName() + File.separator + "index.js";
    }

    public void iU(String str) {
        this.beS = str;
    }
}
