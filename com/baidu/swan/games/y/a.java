package com.baidu.swan.games.y;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.t.a.a;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a elm;
    private com.baidu.swan.games.t.a.a eln;

    private a() {
    }

    public static a aYy() {
        if (elm == null) {
            synchronized (a.class) {
                if (elm == null) {
                    elm = new a();
                }
            }
        }
        return elm;
    }

    public void c(com.baidu.swan.games.t.a.a aVar) {
        this.eln = aVar;
    }

    public boolean xs(String str) {
        String ah = ah(str, 1);
        if (TextUtils.isEmpty(ah)) {
            return false;
        }
        if (this.eln != null && this.eln.ejX != null && this.eln.ejX.ekf != null && this.eln.ejX.ekf.containsKey(ah)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.eln.ejX.ekf.get(ah).booleanValue();
        }
        if (DEBUG) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String aIM = e.aIM();
        if (e.aIK() != null) {
            String version = e.aIK().getVersion();
            if (TextUtils.isEmpty(aIM) || TextUtils.isEmpty(version)) {
                return false;
            }
            boolean ak = com.baidu.swan.pms.database.a.bcv().ak(aIM, version, ah);
            if (ak) {
                ab(ah, true);
                return ak;
            }
            return ak;
        }
        return false;
    }

    public void ab(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.eln != null && this.eln.ejX != null && this.eln.ejX.ekf != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.eln.ejX.ekf.put(str, Boolean.valueOf(z));
        }
    }

    public String rE(String str) {
        String ah = ah(str, 1);
        if (TextUtils.isEmpty(ah) || this.eln == null || this.eln.ejY == null || this.eln.ejY.ekg == null) {
            return null;
        }
        return this.eln.ejY.ekg.get(ah);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String ah(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.eln == null || this.eln.ejX == null || this.eln.ejX.eke == null) {
            return null;
        }
        for (a.C0528a c0528a : this.eln.ejX.eke) {
            if (TextUtils.equals(c0528a.name, str) || TextUtils.equals(c0528a.ekc, str)) {
                switch (i) {
                    case 0:
                        return c0528a.name;
                    case 1:
                        return c0528a.ekc;
                    case 2:
                        return c0528a.path;
                    case 3:
                        return c0528a.ekd;
                    default:
                        return c0528a.ekc;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
