package com.baidu.swan.games.x;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.s.a.a;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a csv;
    private com.baidu.swan.games.s.a.a csw;

    private a() {
    }

    public static a apO() {
        if (csv == null) {
            synchronized (a.class) {
                if (csv == null) {
                    csv = new a();
                }
            }
        }
        return csv;
    }

    public void c(com.baidu.swan.games.s.a.a aVar) {
        this.csw = aVar;
    }

    public boolean pK(String str) {
        String O = O(str, 1);
        if (TextUtils.isEmpty(O)) {
            return false;
        }
        if (this.csw != null && this.csw.crj != null && this.csw.crj.crr != null && this.csw.crj.crr.containsKey(O)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.csw.crj.crr.get(O).booleanValue();
        }
        if (DEBUG) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String acF = e.acF();
        if (e.acD() != null) {
            String version = e.acD().getVersion();
            if (TextUtils.isEmpty(acF) || TextUtils.isEmpty(version)) {
                return false;
            }
            boolean Q = com.baidu.swan.pms.database.a.att().Q(acF, version, O);
            if (Q) {
                y(O, true);
                return Q;
            }
            return Q;
        }
        return false;
    }

    public void y(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.csw != null && this.csw.crj != null && this.csw.crj.crr != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.csw.crj.crr.put(str, Boolean.valueOf(z));
        }
    }

    public String kR(String str) {
        String O = O(str, 1);
        if (TextUtils.isEmpty(O) || this.csw == null || this.csw.crk == null || this.csw.crk.crs == null) {
            return null;
        }
        return this.csw.crk.crs.get(O);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String O(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.csw == null || this.csw.crj == null || this.csw.crj.crq == null) {
            return null;
        }
        for (a.C0346a c0346a : this.csw.crj.crq) {
            if (TextUtils.equals(c0346a.name, str) || TextUtils.equals(c0346a.cro, str)) {
                switch (i) {
                    case 0:
                        return c0346a.name;
                    case 1:
                        return c0346a.cro;
                    case 2:
                        return c0346a.path;
                    case 3:
                        return c0346a.crp;
                    default:
                        return c0346a.cro;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
