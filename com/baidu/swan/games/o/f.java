package com.baidu.swan.games.o;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes2.dex */
public class f {
    private static volatile f bkr;
    private boolean bks;
    private String bkt;
    private String bku;

    public static f SM() {
        if (bkr == null) {
            synchronized (f.class) {
                if (bkr == null) {
                    bkr = new f();
                }
            }
        }
        return bkr;
    }

    private f() {
    }

    public boolean SN() {
        return this.bks;
    }

    public void cS(boolean z) {
        this.bks = z;
    }

    public String SO() {
        return TextUtils.isEmpty(this.bku) ? "" : this.bku + File.separator + "index.js";
    }

    public void jQ(String str) {
        this.bkt = str;
    }

    public void jR(String str) {
        this.bku = str;
    }
}
