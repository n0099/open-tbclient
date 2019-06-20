package com.baidu.swan.games.subpackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.p.a.a;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a bkz;
    private com.baidu.swan.games.p.a.a bkA;

    private a() {
    }

    public static a Sw() {
        if (bkz == null) {
            synchronized (a.class) {
                if (bkz == null) {
                    bkz = new a();
                }
            }
        }
        return bkz;
    }

    public void c(com.baidu.swan.games.p.a.a aVar) {
        this.bkA = aVar;
    }

    public boolean jT(String str) {
        String G = G(str, 1);
        if (TextUtils.isEmpty(G)) {
            return false;
        }
        if (this.bkA != null && this.bkA.bjp != null && this.bkA.bjp.bjw != null && this.bkA.bjp.bjw.containsKey(G)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.bkA.bjp.bjw.get(G).booleanValue();
        }
        if (DEBUG) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String LB = com.baidu.swan.apps.ae.b.LB();
        if (com.baidu.swan.apps.ae.b.Lq() != null) {
            String version = com.baidu.swan.apps.ae.b.Lq().getVersion();
            if (TextUtils.isEmpty(LB) || TextUtils.isEmpty(version)) {
                return false;
            }
            boolean m = com.baidu.swan.apps.database.subpackage.a.Cb().m(LB, version, G);
            if (m) {
                s(G, true);
                return m;
            }
            return m;
        }
        return false;
    }

    public void s(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.bkA != null && this.bkA.bjp != null && this.bkA.bjp.bjw != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.bkA.bjp.bjw.put(str, Boolean.valueOf(z));
        }
    }

    public String gD(String str) {
        String G = G(str, 1);
        if (TextUtils.isEmpty(G) || this.bkA == null || this.bkA.bjq == null || this.bkA.bjq.bjx == null) {
            return null;
        }
        return this.bkA.bjq.bjx.get(G);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String G(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.bkA == null || this.bkA.bjp == null || this.bkA.bjp.bjv == null) {
            return null;
        }
        for (a.C0214a c0214a : this.bkA.bjp.bjv) {
            if (TextUtils.equals(c0214a.name, str) || TextUtils.equals(c0214a.bjt, str)) {
                switch (i) {
                    case 0:
                        return c0214a.name;
                    case 1:
                        return c0214a.bjt;
                    case 2:
                        return c0214a.path;
                    case 3:
                        return c0214a.bju;
                    default:
                        return c0214a.bjt;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
