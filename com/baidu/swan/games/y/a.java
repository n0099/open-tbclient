package com.baidu.swan.games.y;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.t.a.a;
/* loaded from: classes3.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a dzl;
    private com.baidu.swan.games.t.a.a dzm;

    private a() {
    }

    public static a aQl() {
        if (dzl == null) {
            synchronized (a.class) {
                if (dzl == null) {
                    dzl = new a();
                }
            }
        }
        return dzl;
    }

    public void c(com.baidu.swan.games.t.a.a aVar) {
        this.dzm = aVar;
    }

    public boolean wq(String str) {
        String Z = Z(str, 1);
        if (TextUtils.isEmpty(Z)) {
            return false;
        }
        if (this.dzm != null && this.dzm.dxY != null && this.dzm.dxY.dyg != null && this.dzm.dxY.dyg.containsKey(Z)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.dzm.dxY.dyg.get(Z).booleanValue();
        }
        if (DEBUG) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String aAt = e.aAt();
        if (e.aAr() != null) {
            String version = e.aAr().getVersion();
            if (TextUtils.isEmpty(aAt) || TextUtils.isEmpty(version)) {
                return false;
            }
            boolean W = com.baidu.swan.pms.database.a.aUf().W(aAt, version, Z);
            if (W) {
                V(Z, true);
                return W;
            }
            return W;
        }
        return false;
    }

    public void V(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.dzm != null && this.dzm.dxY != null && this.dzm.dxY.dyg != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.dzm.dxY.dyg.put(str, Boolean.valueOf(z));
        }
    }

    public String qF(String str) {
        String Z = Z(str, 1);
        if (TextUtils.isEmpty(Z) || this.dzm == null || this.dzm.dxZ == null || this.dzm.dxZ.dyh == null) {
            return null;
        }
        return this.dzm.dxZ.dyh.get(Z);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String Z(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.dzm == null || this.dzm.dxY == null || this.dzm.dxY.dyf == null) {
            return null;
        }
        for (a.C0502a c0502a : this.dzm.dxY.dyf) {
            if (TextUtils.equals(c0502a.name, str) || TextUtils.equals(c0502a.dyd, str)) {
                switch (i) {
                    case 0:
                        return c0502a.name;
                    case 1:
                        return c0502a.dyd;
                    case 2:
                        return c0502a.path;
                    case 3:
                        return c0502a.dye;
                    default:
                        return c0502a.dyd;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
