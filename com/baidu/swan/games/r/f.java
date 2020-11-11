package com.baidu.swan.games.r;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes10.dex */
public class f {
    private static volatile f dXY;
    private boolean dXZ;
    private String dYa;
    private String dYb;

    public static f aWA() {
        if (dXY == null) {
            synchronized (f.class) {
                if (dXY == null) {
                    dXY = new f();
                }
            }
        }
        return dXY;
    }

    private f() {
    }

    public boolean aWB() {
        return this.dXZ;
    }

    public void hx(boolean z) {
        this.dXZ = z;
    }

    public String aWC() {
        return TextUtils.isEmpty(this.dYb) ? "" : this.dYb + File.separator + "index.js";
    }

    public void xs(String str) {
        this.dYa = str;
    }

    public void xt(String str) {
        this.dYb = str;
    }
}
