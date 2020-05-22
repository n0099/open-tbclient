package com.baidu.swan.games.y;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.t.a.a;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a dcG;
    private com.baidu.swan.games.t.a.a dcH;

    private a() {
    }

    public static a aBW() {
        if (dcG == null) {
            synchronized (a.class) {
                if (dcG == null) {
                    dcG = new a();
                }
            }
        }
        return dcG;
    }

    public void c(com.baidu.swan.games.t.a.a aVar) {
        this.dcH = aVar;
    }

    public boolean sA(String str) {
        String X = X(str, 1);
        if (TextUtils.isEmpty(X)) {
            return false;
        }
        if (this.dcH != null && this.dcH.dbs != null && this.dcH.dbs.dbA != null && this.dcH.dbs.dbA.containsKey(X)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.dcH.dbs.dbA.get(X).booleanValue();
        }
        if (DEBUG) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String aoH = e.aoH();
        if (e.aoF() != null) {
            String version = e.aoF().getVersion();
            if (TextUtils.isEmpty(aoH) || TextUtils.isEmpty(version)) {
                return false;
            }
            boolean V = com.baidu.swan.pms.database.a.aFV().V(aoH, version, X);
            if (V) {
                P(X, true);
                return V;
            }
            return V;
        }
        return false;
    }

    public void P(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.dcH != null && this.dcH.dbs != null && this.dcH.dbs.dbA != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.dcH.dbs.dbA.put(str, Boolean.valueOf(z));
        }
    }

    public String ny(String str) {
        String X = X(str, 1);
        if (TextUtils.isEmpty(X) || this.dcH == null || this.dcH.dbt == null || this.dcH.dbt.dbB == null) {
            return null;
        }
        return this.dcH.dbt.dbB.get(X);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String X(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.dcH == null || this.dcH.dbs == null || this.dcH.dbs.dbz == null) {
            return null;
        }
        for (a.C0440a c0440a : this.dcH.dbs.dbz) {
            if (TextUtils.equals(c0440a.name, str) || TextUtils.equals(c0440a.dbx, str)) {
                switch (i) {
                    case 0:
                        return c0440a.name;
                    case 1:
                        return c0440a.dbx;
                    case 2:
                        return c0440a.path;
                    case 3:
                        return c0440a.dby;
                    default:
                        return c0440a.dbx;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
