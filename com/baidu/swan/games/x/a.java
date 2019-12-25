package com.baidu.swan.games.x;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.s.a.a;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a coh;
    private com.baidu.swan.games.s.a.a coi;

    private a() {
    }

    public static a anh() {
        if (coh == null) {
            synchronized (a.class) {
                if (coh == null) {
                    coh = new a();
                }
            }
        }
        return coh;
    }

    public void c(com.baidu.swan.games.s.a.a aVar) {
        this.coi = aVar;
    }

    public boolean ps(String str) {
        String Q = Q(str, 1);
        if (TextUtils.isEmpty(Q)) {
            return false;
        }
        if (this.coi != null && this.coi.cmT != null && this.coi.cmT.cnb != null && this.coi.cmT.cnb.containsKey(Q)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.coi.cmT.cnb.get(Q).booleanValue();
        }
        if (DEBUG) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String ZU = e.ZU();
        if (e.ZS() != null) {
            String version = e.ZS().getVersion();
            if (TextUtils.isEmpty(ZU) || TextUtils.isEmpty(version)) {
                return false;
            }
            boolean P = com.baidu.swan.pms.database.a.aqM().P(ZU, version, Q);
            if (P) {
                y(Q, true);
                return P;
            }
            return P;
        }
        return false;
    }

    public void y(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.coi != null && this.coi.cmT != null && this.coi.cmT.cnb != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.coi.cmT.cnb.put(str, Boolean.valueOf(z));
        }
    }

    public String kz(String str) {
        String Q = Q(str, 1);
        if (TextUtils.isEmpty(Q) || this.coi == null || this.coi.cmU == null || this.coi.cmU.cnc == null) {
            return null;
        }
        return this.coi.cmU.cnc.get(Q);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String Q(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.coi == null || this.coi.cmT == null || this.coi.cmT.cna == null) {
            return null;
        }
        for (a.C0334a c0334a : this.coi.cmT.cna) {
            if (TextUtils.equals(c0334a.name, str) || TextUtils.equals(c0334a.cmY, str)) {
                switch (i) {
                    case 0:
                        return c0334a.name;
                    case 1:
                        return c0334a.cmY;
                    case 2:
                        return c0334a.path;
                    case 3:
                        return c0334a.cmZ;
                    default:
                        return c0334a.cmY;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
