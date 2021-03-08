package com.baidu.swan.games.r;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes8.dex */
public class f {
    private static volatile f eli;
    private boolean elj;
    private String elk;
    private String ell;

    public static f aXN() {
        if (eli == null) {
            synchronized (f.class) {
                if (eli == null) {
                    eli = new f();
                }
            }
        }
        return eli;
    }

    private f() {
    }

    public boolean aXO() {
        return this.elj;
    }

    /* renamed from: if  reason: not valid java name */
    public void m29if(boolean z) {
        this.elj = z;
    }

    public String aXP() {
        return TextUtils.isEmpty(this.ell) ? "" : this.ell + File.separator + "index.js";
    }

    public void xi(String str) {
        this.elk = str;
    }

    public void xj(String str) {
        this.ell = str;
    }
}
