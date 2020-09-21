package com.baidu.swan.games.r;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes3.dex */
public class f {
    private static volatile f dxI;
    private boolean dxJ;
    private String dxK;
    private String dxL;

    public static f aPx() {
        if (dxI == null) {
            synchronized (f.class) {
                if (dxI == null) {
                    dxI = new f();
                }
            }
        }
        return dxI;
    }

    private f() {
    }

    public boolean aPy() {
        return this.dxJ;
    }

    public void gF(boolean z) {
        this.dxJ = z;
    }

    public String aPz() {
        return TextUtils.isEmpty(this.dxL) ? "" : this.dxL + File.separator + "index.js";
    }

    public void vZ(String str) {
        this.dxK = str;
    }

    public void wa(String str) {
        this.dxL = str;
    }
}
