package com.baidu.swan.games.x;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.s.a.a;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a csx;
    private com.baidu.swan.games.s.a.a csy;

    private a() {
    }

    public static a apQ() {
        if (csx == null) {
            synchronized (a.class) {
                if (csx == null) {
                    csx = new a();
                }
            }
        }
        return csx;
    }

    public void c(com.baidu.swan.games.s.a.a aVar) {
        this.csy = aVar;
    }

    public boolean pK(String str) {
        String O = O(str, 1);
        if (TextUtils.isEmpty(O)) {
            return false;
        }
        if (this.csy != null && this.csy.crl != null && this.csy.crl.crt != null && this.csy.crl.crt.containsKey(O)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.csy.crl.crt.get(O).booleanValue();
        }
        if (DEBUG) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String acH = e.acH();
        if (e.acF() != null) {
            String version = e.acF().getVersion();
            if (TextUtils.isEmpty(acH) || TextUtils.isEmpty(version)) {
                return false;
            }
            boolean Q = com.baidu.swan.pms.database.a.atv().Q(acH, version, O);
            if (Q) {
                y(O, true);
                return Q;
            }
            return Q;
        }
        return false;
    }

    public void y(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.csy != null && this.csy.crl != null && this.csy.crl.crt != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.csy.crl.crt.put(str, Boolean.valueOf(z));
        }
    }

    public String kR(String str) {
        String O = O(str, 1);
        if (TextUtils.isEmpty(O) || this.csy == null || this.csy.crm == null || this.csy.crm.cru == null) {
            return null;
        }
        return this.csy.crm.cru.get(O);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String O(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.csy == null || this.csy.crl == null || this.csy.crl.crs == null) {
            return null;
        }
        for (a.C0346a c0346a : this.csy.crl.crs) {
            if (TextUtils.equals(c0346a.name, str) || TextUtils.equals(c0346a.crq, str)) {
                switch (i) {
                    case 0:
                        return c0346a.name;
                    case 1:
                        return c0346a.crq;
                    case 2:
                        return c0346a.path;
                    case 3:
                        return c0346a.crr;
                    default:
                        return c0346a.crq;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
