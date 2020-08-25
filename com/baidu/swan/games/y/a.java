package com.baidu.swan.games.y;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.t.a.a;
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a dxg;
    private com.baidu.swan.games.t.a.a dxh;

    private a() {
    }

    public static a aPA() {
        if (dxg == null) {
            synchronized (a.class) {
                if (dxg == null) {
                    dxg = new a();
                }
            }
        }
        return dxg;
    }

    public void c(com.baidu.swan.games.t.a.a aVar) {
        this.dxh = aVar;
    }

    public boolean vW(String str) {
        String Z = Z(str, 1);
        if (TextUtils.isEmpty(Z)) {
            return false;
        }
        if (this.dxh != null && this.dxh.dvT != null && this.dxh.dvT.dwb != null && this.dxh.dvT.dwb.containsKey(Z)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.dxh.dvT.dwb.get(Z).booleanValue();
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
        if (!TextUtils.isEmpty(str) && this.dxh != null && this.dxh.dvT != null && this.dxh.dvT.dwb != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.dxh.dvT.dwb.put(str, Boolean.valueOf(z));
        }
    }

    public String ql(String str) {
        String Z = Z(str, 1);
        if (TextUtils.isEmpty(Z) || this.dxh == null || this.dxh.dvU == null || this.dxh.dvU.dwc == null) {
            return null;
        }
        return this.dxh.dvU.dwc.get(Z);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String Z(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.dxh == null || this.dxh.dvT == null || this.dxh.dvT.dwa == null) {
            return null;
        }
        for (a.C0507a c0507a : this.dxh.dvT.dwa) {
            if (TextUtils.equals(c0507a.name, str) || TextUtils.equals(c0507a.dvY, str)) {
                switch (i) {
                    case 0:
                        return c0507a.name;
                    case 1:
                        return c0507a.dvY;
                    case 2:
                        return c0507a.path;
                    case 3:
                        return c0507a.dvZ;
                    default:
                        return c0507a.dvY;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
