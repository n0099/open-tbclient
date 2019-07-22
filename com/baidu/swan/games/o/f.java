package com.baidu.swan.games.o;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes2.dex */
public class f {
    private static volatile f bjT;
    private boolean bjU;
    private String bjV;
    private String bjW;

    public static f SI() {
        if (bjT == null) {
            synchronized (f.class) {
                if (bjT == null) {
                    bjT = new f();
                }
            }
        }
        return bjT;
    }

    private f() {
    }

    public boolean SJ() {
        return this.bjU;
    }

    public void cS(boolean z) {
        this.bjU = z;
    }

    public String SK() {
        return TextUtils.isEmpty(this.bjW) ? "" : this.bjW + File.separator + "index.js";
    }

    public void jO(String str) {
        this.bjV = str;
    }

    public void jP(String str) {
        this.bjW = str;
    }
}
