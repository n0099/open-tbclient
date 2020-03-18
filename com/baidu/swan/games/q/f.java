package com.baidu.swan.games.q;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes11.dex */
public class f {
    private static volatile f crf;
    private boolean crg;
    private String crh;
    private String cri;

    public static f ape() {
        if (crf == null) {
            synchronized (f.class) {
                if (crf == null) {
                    crf = new f();
                }
            }
        }
        return crf;
    }

    private f() {
    }

    public boolean apf() {
        return this.crg;
    }

    public void eG(boolean z) {
        this.crg = z;
    }

    public String apg() {
        return TextUtils.isEmpty(this.cri) ? "" : this.cri + File.separator + "index.js";
    }

    public void ps(String str) {
        this.crh = str;
    }

    public void pt(String str) {
        this.cri = str;
    }
}
