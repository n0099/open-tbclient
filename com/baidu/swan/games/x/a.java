package com.baidu.swan.games.x;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.s.a.a;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a cRI;
    private com.baidu.swan.games.s.a.a cRJ;

    private a() {
    }

    public static a ayf() {
        if (cRI == null) {
            synchronized (a.class) {
                if (cRI == null) {
                    cRI = new a();
                }
            }
        }
        return cRI;
    }

    public void c(com.baidu.swan.games.s.a.a aVar) {
        this.cRJ = aVar;
    }

    public boolean qW(String str) {
        String W = W(str, 1);
        if (TextUtils.isEmpty(W)) {
            return false;
        }
        if (this.cRJ != null && this.cRJ.cQw != null && this.cRJ.cQw.cQE != null && this.cRJ.cQw.cQE.containsKey(W)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.cRJ.cQw.cQE.get(W).booleanValue();
        }
        if (DEBUG) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String akO = e.akO();
        if (e.akM() != null) {
            String version = e.akM().getVersion();
            if (TextUtils.isEmpty(akO) || TextUtils.isEmpty(version)) {
                return false;
            }
            boolean Q = com.baidu.swan.pms.database.a.aBI().Q(akO, version, W);
            if (Q) {
                D(W, true);
                return Q;
            }
            return Q;
        }
        return false;
    }

    public void D(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.cRJ != null && this.cRJ.cQw != null && this.cRJ.cQw.cQE != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.cRJ.cQw.cQE.put(str, Boolean.valueOf(z));
        }
    }

    public String md(String str) {
        String W = W(str, 1);
        if (TextUtils.isEmpty(W) || this.cRJ == null || this.cRJ.cQx == null || this.cRJ.cQx.cQF == null) {
            return null;
        }
        return this.cRJ.cQx.cQF.get(W);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String W(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.cRJ == null || this.cRJ.cQw == null || this.cRJ.cQw.cQD == null) {
            return null;
        }
        for (a.C0397a c0397a : this.cRJ.cQw.cQD) {
            if (TextUtils.equals(c0397a.name, str) || TextUtils.equals(c0397a.cQB, str)) {
                switch (i) {
                    case 0:
                        return c0397a.name;
                    case 1:
                        return c0397a.cQB;
                    case 2:
                        return c0397a.path;
                    case 3:
                        return c0397a.cQC;
                    default:
                        return c0397a.cQB;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
