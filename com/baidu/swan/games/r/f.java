package com.baidu.swan.games.r;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes11.dex */
public class f {
    private static volatile f dbc;
    private boolean dbd;
    private String dbe;
    private String dbf;

    public static f aBi() {
        if (dbc == null) {
            synchronized (f.class) {
                if (dbc == null) {
                    dbc = new f();
                }
            }
        }
        return dbc;
    }

    private f() {
    }

    public boolean aBj() {
        return this.dbd;
    }

    public void fO(boolean z) {
        this.dbd = z;
    }

    public String aBk() {
        return TextUtils.isEmpty(this.dbf) ? "" : this.dbf + File.separator + "index.js";
    }

    public void si(String str) {
        this.dbe = str;
    }

    public void sj(String str) {
        this.dbf = str;
    }
}
