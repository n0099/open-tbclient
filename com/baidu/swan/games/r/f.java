package com.baidu.swan.games.r;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes8.dex */
public class f {
    private static volatile f ehA;
    private boolean ehB;
    private String ehC;
    private String ehD;

    public static f aXy() {
        if (ehA == null) {
            synchronized (f.class) {
                if (ehA == null) {
                    ehA = new f();
                }
            }
        }
        return ehA;
    }

    private f() {
    }

    public boolean aXz() {
        return this.ehB;
    }

    public void id(boolean z) {
        this.ehB = z;
    }

    public String aXA() {
        return TextUtils.isEmpty(this.ehD) ? "" : this.ehD + File.separator + "index.js";
    }

    public void wI(String str) {
        this.ehC = str;
    }

    public void wJ(String str) {
        this.ehD = str;
    }
}
