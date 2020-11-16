package com.baidu.swan.games.r;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes7.dex */
public class f {
    private static volatile f dWq;
    private boolean dWr;
    private String dWs;
    private String dWt;

    public static f aVS() {
        if (dWq == null) {
            synchronized (f.class) {
                if (dWq == null) {
                    dWq = new f();
                }
            }
        }
        return dWq;
    }

    private f() {
    }

    public boolean aVT() {
        return this.dWr;
    }

    public void hA(boolean z) {
        this.dWr = z;
    }

    public String aVU() {
        return TextUtils.isEmpty(this.dWt) ? "" : this.dWt + File.separator + "index.js";
    }

    public void xn(String str) {
        this.dWs = str;
    }

    public void xo(String str) {
        this.dWt = str;
    }
}
