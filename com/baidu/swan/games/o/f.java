package com.baidu.swan.games.o;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes2.dex */
public class f {
    private static volatile f bjg;
    private boolean bjh;
    private String bji;
    private String bjj;

    public static f RP() {
        if (bjg == null) {
            synchronized (f.class) {
                if (bjg == null) {
                    bjg = new f();
                }
            }
        }
        return bjg;
    }

    private f() {
    }

    public boolean RQ() {
        return this.bjh;
    }

    public void cP(boolean z) {
        this.bjh = z;
    }

    public String RR() {
        return TextUtils.isEmpty(this.bjj) ? "" : this.bjj + File.separator + "index.js";
    }

    public void jG(String str) {
        this.bji = str;
    }

    public void jH(String str) {
        this.bjj = str;
    }
}
