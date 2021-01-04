package com.baidu.swan.games.r;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes9.dex */
public class f {
    private static volatile f emm;
    private boolean emn;
    private String emo;
    private String emp;

    public static f bbr() {
        if (emm == null) {
            synchronized (f.class) {
                if (emm == null) {
                    emm = new f();
                }
            }
        }
        return emm;
    }

    private f() {
    }

    public boolean bbs() {
        return this.emn;
    }

    public void ih(boolean z) {
        this.emn = z;
    }

    public String bbt() {
        return TextUtils.isEmpty(this.emp) ? "" : this.emp + File.separator + "index.js";
    }

    public void xT(String str) {
        this.emo = str;
    }

    public void xU(String str) {
        this.emp = str;
    }
}
