package com.baidu.swan.games.n;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes2.dex */
public class f {
    private static volatile f beL;
    private boolean beM;
    private String beN;

    public static f OM() {
        if (beL == null) {
            synchronized (f.class) {
                if (beL == null) {
                    beL = new f();
                }
            }
        }
        return beL;
    }

    private f() {
    }

    public boolean ON() {
        return this.beM;
    }

    public void cy(boolean z) {
        this.beM = z;
    }

    public String OO() {
        return this.beN;
    }

    public String OP() {
        if (TextUtils.isEmpty(OO())) {
            return "";
        }
        return new File(OO()).getName() + File.separator + "index.js";
    }

    public void iT(String str) {
        this.beN = str;
    }
}
