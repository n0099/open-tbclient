package com.baidu.swan.games.y;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.t.a.a;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a dLm;
    private com.baidu.swan.games.t.a.a dLn;

    private a() {
    }

    public static a aSU() {
        if (dLm == null) {
            synchronized (a.class) {
                if (dLm == null) {
                    dLm = new a();
                }
            }
        }
        return dLm;
    }

    public void c(com.baidu.swan.games.t.a.a aVar) {
        this.dLn = aVar;
    }

    public boolean xc(String str) {
        String aa = aa(str, 1);
        if (TextUtils.isEmpty(aa)) {
            return false;
        }
        if (this.dLn != null && this.dLn.dJZ != null && this.dLn.dJZ.dKh != null && this.dLn.dJZ.dKh.containsKey(aa)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.dLn.dJZ.dKh.get(aa).booleanValue();
        }
        if (DEBUG) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String aDc = e.aDc();
        if (e.aDa() != null) {
            String version = e.aDa().getVersion();
            if (TextUtils.isEmpty(aDc) || TextUtils.isEmpty(version)) {
                return false;
            }
            boolean X = com.baidu.swan.pms.database.a.aWO().X(aDc, version, aa);
            if (X) {
                Z(aa, true);
                return X;
            }
            return X;
        }
        return false;
    }

    public void Z(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.dLn != null && this.dLn.dJZ != null && this.dLn.dJZ.dKh != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.dLn.dJZ.dKh.put(str, Boolean.valueOf(z));
        }
    }

    public String rr(String str) {
        String aa = aa(str, 1);
        if (TextUtils.isEmpty(aa) || this.dLn == null || this.dLn.dKa == null || this.dLn.dKa.dKi == null) {
            return null;
        }
        return this.dLn.dKa.dKi.get(aa);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String aa(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.dLn == null || this.dLn.dJZ == null || this.dLn.dJZ.dKg == null) {
            return null;
        }
        for (a.C0519a c0519a : this.dLn.dJZ.dKg) {
            if (TextUtils.equals(c0519a.name, str) || TextUtils.equals(c0519a.dKe, str)) {
                switch (i) {
                    case 0:
                        return c0519a.name;
                    case 1:
                        return c0519a.dKe;
                    case 2:
                        return c0519a.path;
                    case 3:
                        return c0519a.dKf;
                    default:
                        return c0519a.dKe;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
