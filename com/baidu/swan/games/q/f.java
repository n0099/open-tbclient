package com.baidu.swan.games.q;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes11.dex */
public class f {
    private static volatile f cqS;
    private boolean cqT;
    private String cqU;
    private String cqV;

    public static f apb() {
        if (cqS == null) {
            synchronized (f.class) {
                if (cqS == null) {
                    cqS = new f();
                }
            }
        }
        return cqS;
    }

    private f() {
    }

    public boolean apc() {
        return this.cqT;
    }

    public void eF(boolean z) {
        this.cqT = z;
    }

    public String apd() {
        return TextUtils.isEmpty(this.cqV) ? "" : this.cqV + File.separator + "index.js";
    }

    public void pt(String str) {
        this.cqU = str;
    }

    public void pu(String str) {
        this.cqV = str;
    }
}
