package com.baidu.swan.games.y;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.t.a.a;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a dTJ;
    private com.baidu.swan.games.t.a.a dTK;

    private a() {
    }

    public static a aUO() {
        if (dTJ == null) {
            synchronized (a.class) {
                if (dTJ == null) {
                    dTJ = new a();
                }
            }
        }
        return dTJ;
    }

    public void c(com.baidu.swan.games.t.a.a aVar) {
        this.dTK = aVar;
    }

    public boolean xv(String str) {
        String aa = aa(str, 1);
        if (TextUtils.isEmpty(aa)) {
            return false;
        }
        if (this.dTK != null && this.dTK.dSw != null && this.dTK.dSw.dSE != null && this.dTK.dSw.dSE.containsKey(aa)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.dTK.dSw.dSE.get(aa).booleanValue();
        }
        if (DEBUG) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String aEW = e.aEW();
        if (e.aEU() != null) {
            String version = e.aEU().getVersion();
            if (TextUtils.isEmpty(aEW) || TextUtils.isEmpty(version)) {
                return false;
            }
            boolean ae = com.baidu.swan.pms.database.a.aYH().ae(aEW, version, aa);
            if (ae) {
                ab(aa, true);
                return ae;
            }
            return ae;
        }
        return false;
    }

    public void ab(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.dTK != null && this.dTK.dSw != null && this.dTK.dSw.dSE != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.dTK.dSw.dSE.put(str, Boolean.valueOf(z));
        }
    }

    public String rK(String str) {
        String aa = aa(str, 1);
        if (TextUtils.isEmpty(aa) || this.dTK == null || this.dTK.dSx == null || this.dTK.dSx.dSF == null) {
            return null;
        }
        return this.dTK.dSx.dSF.get(aa);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String aa(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.dTK == null || this.dTK.dSw == null || this.dTK.dSw.dSD == null) {
            return null;
        }
        for (a.C0533a c0533a : this.dTK.dSw.dSD) {
            if (TextUtils.equals(c0533a.name, str) || TextUtils.equals(c0533a.dSB, str)) {
                switch (i) {
                    case 0:
                        return c0533a.name;
                    case 1:
                        return c0533a.dSB;
                    case 2:
                        return c0533a.path;
                    case 3:
                        return c0533a.dSC;
                    default:
                        return c0533a.dSB;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
