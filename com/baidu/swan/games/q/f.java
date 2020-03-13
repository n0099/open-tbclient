package com.baidu.swan.games.q;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes11.dex */
public class f {
    private static volatile f cqT;
    private boolean cqU;
    private String cqV;
    private String cqW;

    public static f apb() {
        if (cqT == null) {
            synchronized (f.class) {
                if (cqT == null) {
                    cqT = new f();
                }
            }
        }
        return cqT;
    }

    private f() {
    }

    public boolean apc() {
        return this.cqU;
    }

    public void eF(boolean z) {
        this.cqU = z;
    }

    public String apd() {
        return TextUtils.isEmpty(this.cqW) ? "" : this.cqW + File.separator + "index.js";
    }

    public void pt(String str) {
        this.cqV = str;
    }

    public void pu(String str) {
        this.cqW = str;
    }
}
