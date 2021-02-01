package com.baidu.swan.games.r;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes9.dex */
public class f {
    private static volatile f ejH;
    private boolean ejI;
    private String ejJ;
    private String ejK;

    public static f aXK() {
        if (ejH == null) {
            synchronized (f.class) {
                if (ejH == null) {
                    ejH = new f();
                }
            }
        }
        return ejH;
    }

    private f() {
    }

    public boolean aXL() {
        return this.ejI;
    }

    /* renamed from: if  reason: not valid java name */
    public void m28if(boolean z) {
        this.ejI = z;
    }

    public String aXM() {
        return TextUtils.isEmpty(this.ejK) ? "" : this.ejK + File.separator + "index.js";
    }

    public void xb(String str) {
        this.ejJ = str;
    }

    public void xc(String str) {
        this.ejK = str;
    }
}
