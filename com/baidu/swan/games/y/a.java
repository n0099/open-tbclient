package com.baidu.swan.games.y;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.t.a.a;
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a dxk;
    private com.baidu.swan.games.t.a.a dxl;

    private a() {
    }

    public static a aPA() {
        if (dxk == null) {
            synchronized (a.class) {
                if (dxk == null) {
                    dxk = new a();
                }
            }
        }
        return dxk;
    }

    public void c(com.baidu.swan.games.t.a.a aVar) {
        this.dxl = aVar;
    }

    public boolean vX(String str) {
        String Z = Z(str, 1);
        if (TextUtils.isEmpty(Z)) {
            return false;
        }
        if (this.dxl != null && this.dxl.dvX != null && this.dxl.dvX.dwf != null && this.dxl.dvX.dwf.containsKey(Z)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.dxl.dvX.dwf.get(Z).booleanValue();
        }
        if (DEBUG) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String azK = e.azK();
        if (e.azI() != null) {
            String version = e.azI().getVersion();
            if (TextUtils.isEmpty(azK) || TextUtils.isEmpty(version)) {
                return false;
            }
            boolean W = com.baidu.swan.pms.database.a.aTt().W(azK, version, Z);
            if (W) {
                V(Z, true);
                return W;
            }
            return W;
        }
        return false;
    }

    public void V(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.dxl != null && this.dxl.dvX != null && this.dxl.dvX.dwf != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.dxl.dvX.dwf.put(str, Boolean.valueOf(z));
        }
    }

    public String qm(String str) {
        String Z = Z(str, 1);
        if (TextUtils.isEmpty(Z) || this.dxl == null || this.dxl.dvY == null || this.dxl.dvY.dwg == null) {
            return null;
        }
        return this.dxl.dvY.dwg.get(Z);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String Z(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.dxl == null || this.dxl.dvX == null || this.dxl.dvX.dwe == null) {
            return null;
        }
        for (a.C0507a c0507a : this.dxl.dvX.dwe) {
            if (TextUtils.equals(c0507a.name, str) || TextUtils.equals(c0507a.dwc, str)) {
                switch (i) {
                    case 0:
                        return c0507a.name;
                    case 1:
                        return c0507a.dwc;
                    case 2:
                        return c0507a.path;
                    case 3:
                        return c0507a.dwd;
                    default:
                        return c0507a.dwc;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
