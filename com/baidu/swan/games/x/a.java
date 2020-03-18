package com.baidu.swan.games.x;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.s.a.a;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a csI;
    private com.baidu.swan.games.s.a.a csJ;

    private a() {
    }

    public static a apT() {
        if (csI == null) {
            synchronized (a.class) {
                if (csI == null) {
                    csI = new a();
                }
            }
        }
        return csI;
    }

    public void c(com.baidu.swan.games.s.a.a aVar) {
        this.csJ = aVar;
    }

    public boolean pJ(String str) {
        String O = O(str, 1);
        if (TextUtils.isEmpty(O)) {
            return false;
        }
        if (this.csJ != null && this.csJ.crw != null && this.csJ.crw.crE != null && this.csJ.crw.crE.containsKey(O)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.csJ.crw.crE.get(O).booleanValue();
        }
        if (DEBUG) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String acK = e.acK();
        if (e.acI() != null) {
            String version = e.acI().getVersion();
            if (TextUtils.isEmpty(acK) || TextUtils.isEmpty(version)) {
                return false;
            }
            boolean Q = com.baidu.swan.pms.database.a.aty().Q(acK, version, O);
            if (Q) {
                y(O, true);
                return Q;
            }
            return Q;
        }
        return false;
    }

    public void y(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.csJ != null && this.csJ.crw != null && this.csJ.crw.crE != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.csJ.crw.crE.put(str, Boolean.valueOf(z));
        }
    }

    public String kQ(String str) {
        String O = O(str, 1);
        if (TextUtils.isEmpty(O) || this.csJ == null || this.csJ.crx == null || this.csJ.crx.crF == null) {
            return null;
        }
        return this.csJ.crx.crF.get(O);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String O(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.csJ == null || this.csJ.crw == null || this.csJ.crw.crD == null) {
            return null;
        }
        for (a.C0346a c0346a : this.csJ.crw.crD) {
            if (TextUtils.equals(c0346a.name, str) || TextUtils.equals(c0346a.crB, str)) {
                switch (i) {
                    case 0:
                        return c0346a.name;
                    case 1:
                        return c0346a.crB;
                    case 2:
                        return c0346a.path;
                    case 3:
                        return c0346a.crC;
                    default:
                        return c0346a.crB;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
