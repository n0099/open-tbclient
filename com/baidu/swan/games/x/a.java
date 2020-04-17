package com.baidu.swan.games.x;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.s.a.a;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a cRD;
    private com.baidu.swan.games.s.a.a cRE;

    private a() {
    }

    public static a ayf() {
        if (cRD == null) {
            synchronized (a.class) {
                if (cRD == null) {
                    cRD = new a();
                }
            }
        }
        return cRD;
    }

    public void c(com.baidu.swan.games.s.a.a aVar) {
        this.cRE = aVar;
    }

    public boolean qW(String str) {
        String W = W(str, 1);
        if (TextUtils.isEmpty(W)) {
            return false;
        }
        if (this.cRE != null && this.cRE.cQr != null && this.cRE.cQr.cQz != null && this.cRE.cQr.cQz.containsKey(W)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.cRE.cQr.cQz.get(W).booleanValue();
        }
        if (DEBUG) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String akP = e.akP();
        if (e.akN() != null) {
            String version = e.akN().getVersion();
            if (TextUtils.isEmpty(akP) || TextUtils.isEmpty(version)) {
                return false;
            }
            boolean Q = com.baidu.swan.pms.database.a.aBI().Q(akP, version, W);
            if (Q) {
                D(W, true);
                return Q;
            }
            return Q;
        }
        return false;
    }

    public void D(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.cRE != null && this.cRE.cQr != null && this.cRE.cQr.cQz != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.cRE.cQr.cQz.put(str, Boolean.valueOf(z));
        }
    }

    public String md(String str) {
        String W = W(str, 1);
        if (TextUtils.isEmpty(W) || this.cRE == null || this.cRE.cQs == null || this.cRE.cQs.cQA == null) {
            return null;
        }
        return this.cRE.cQs.cQA.get(W);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String W(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.cRE == null || this.cRE.cQr == null || this.cRE.cQr.cQy == null) {
            return null;
        }
        for (a.C0376a c0376a : this.cRE.cQr.cQy) {
            if (TextUtils.equals(c0376a.name, str) || TextUtils.equals(c0376a.cQw, str)) {
                switch (i) {
                    case 0:
                        return c0376a.name;
                    case 1:
                        return c0376a.cQw;
                    case 2:
                        return c0376a.path;
                    case 3:
                        return c0376a.cQx;
                    default:
                        return c0376a.cQw;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
