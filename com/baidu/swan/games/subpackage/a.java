package com.baidu.swan.games.subpackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.o.a.a;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a bfo;
    private com.baidu.swan.games.o.a.a bfp;

    private a() {
    }

    public static a Pd() {
        if (bfo == null) {
            synchronized (a.class) {
                if (bfo == null) {
                    bfo = new a();
                }
            }
        }
        return bfo;
    }

    public void c(com.baidu.swan.games.o.a.a aVar) {
        this.bfp = aVar;
    }

    public boolean gh(String str) {
        String L = L(str, 1);
        if (TextUtils.isEmpty(L)) {
            return false;
        }
        if (this.bfp != null && this.bfp.beY != null && this.bfp.beY.bfg != null && this.bfp.beY.bfg.containsKey(L)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.bfp.beY.bfg.get(L).booleanValue();
        }
        if (DEBUG) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String Jg = com.baidu.swan.apps.ae.b.Jg();
        if (com.baidu.swan.apps.ae.b.IV() != null) {
            String version = com.baidu.swan.apps.ae.b.IV().getVersion();
            if (TextUtils.isEmpty(Jg) || TextUtils.isEmpty(version)) {
                return false;
            }
            boolean m = com.baidu.swan.apps.database.subpackage.a.AT().m(Jg, version, L);
            if (m) {
                D(L, true);
                return m;
            }
            return m;
        }
        return false;
    }

    public void D(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.bfp != null && this.bfp.beY != null && this.bfp.beY.bfg != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.bfp.beY.bfg.put(str, Boolean.valueOf(z));
        }
    }

    public String gj(String str) {
        String L = L(str, 1);
        if (TextUtils.isEmpty(L) || this.bfp == null || this.bfp.beZ == null || this.bfp.beZ.bfh == null) {
            return null;
        }
        return this.bfp.beZ.bfh.get(L);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String L(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.bfp == null || this.bfp.beY == null || this.bfp.beY.bff == null) {
            return null;
        }
        for (a.C0204a c0204a : this.bfp.beY.bff) {
            if (TextUtils.equals(c0204a.name, str) || TextUtils.equals(c0204a.bfd, str)) {
                switch (i) {
                    case 0:
                        return c0204a.name;
                    case 1:
                        return c0204a.bfd;
                    case 2:
                        return c0204a.path;
                    case 3:
                        return c0204a.bfe;
                    default:
                        return c0204a.bfd;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
