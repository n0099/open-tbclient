package com.baidu.swan.games.subpackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.p.a.a;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a bEy;
    private com.baidu.swan.games.p.a.a bEz;

    private a() {
    }

    public static a Yk() {
        if (bEy == null) {
            synchronized (a.class) {
                if (bEy == null) {
                    bEy = new a();
                }
            }
        }
        return bEy;
    }

    public void c(com.baidu.swan.games.p.a.a aVar) {
        this.bEz = aVar;
    }

    public boolean kF(String str) {
        String G = G(str, 1);
        if (TextUtils.isEmpty(G)) {
            return false;
        }
        if (this.bEz != null && this.bEz.bDo != null && this.bEz.bDo.bDv != null && this.bEz.bDo.bDv.containsKey(G)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.bEz.bDo.bDv.get(G).booleanValue();
        }
        if (DEBUG) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String Rk = com.baidu.swan.apps.ae.b.Rk();
        if (com.baidu.swan.apps.ae.b.QZ() != null) {
            String version = com.baidu.swan.apps.ae.b.QZ().getVersion();
            if (TextUtils.isEmpty(Rk) || TextUtils.isEmpty(version)) {
                return false;
            }
            boolean q = com.baidu.swan.apps.database.subpackage.a.HI().q(Rk, version, G);
            if (q) {
                w(G, true);
                return q;
            }
            return q;
        }
        return false;
    }

    public void w(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.bEz != null && this.bEz.bDo != null && this.bEz.bDo.bDv != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.bEz.bDo.bDv.put(str, Boolean.valueOf(z));
        }
    }

    public String hq(String str) {
        String G = G(str, 1);
        if (TextUtils.isEmpty(G) || this.bEz == null || this.bEz.bDp == null || this.bEz.bDp.bDw == null) {
            return null;
        }
        return this.bEz.bDp.bDw.get(G);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String G(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.bEz == null || this.bEz.bDo == null || this.bEz.bDo.bDu == null) {
            return null;
        }
        for (a.C0257a c0257a : this.bEz.bDo.bDu) {
            if (TextUtils.equals(c0257a.name, str) || TextUtils.equals(c0257a.bDs, str)) {
                switch (i) {
                    case 0:
                        return c0257a.name;
                    case 1:
                        return c0257a.bDs;
                    case 2:
                        return c0257a.path;
                    case 3:
                        return c0257a.bDt;
                    default:
                        return c0257a.bDs;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
