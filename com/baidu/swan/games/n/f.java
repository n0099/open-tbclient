package com.baidu.swan.games.n;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes2.dex */
public class f {
    private static volatile f beM;
    private boolean beN;
    private String beO;

    public static f OM() {
        if (beM == null) {
            synchronized (f.class) {
                if (beM == null) {
                    beM = new f();
                }
            }
        }
        return beM;
    }

    private f() {
    }

    public boolean ON() {
        return this.beN;
    }

    public void cy(boolean z) {
        this.beN = z;
    }

    public String OO() {
        return this.beO;
    }

    public String OP() {
        if (TextUtils.isEmpty(OO())) {
            return "";
        }
        return new File(OO()).getName() + File.separator + "index.js";
    }

    public void iT(String str) {
        this.beO = str;
    }
}
