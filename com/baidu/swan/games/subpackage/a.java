package com.baidu.swan.games.subpackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.o.a.a;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a bfn;
    private com.baidu.swan.games.o.a.a bfo;

    private a() {
    }

    public static a Pd() {
        if (bfn == null) {
            synchronized (a.class) {
                if (bfn == null) {
                    bfn = new a();
                }
            }
        }
        return bfn;
    }

    public void c(com.baidu.swan.games.o.a.a aVar) {
        this.bfo = aVar;
    }

    public boolean gh(String str) {
        String L = L(str, 1);
        if (TextUtils.isEmpty(L)) {
            return false;
        }
        if (this.bfo != null && this.bfo.beX != null && this.bfo.beX.bff != null && this.bfo.beX.bff.containsKey(L)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.bfo.beX.bff.get(L).booleanValue();
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
        if (!TextUtils.isEmpty(str) && this.bfo != null && this.bfo.beX != null && this.bfo.beX.bff != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.bfo.beX.bff.put(str, Boolean.valueOf(z));
        }
    }

    public String gj(String str) {
        String L = L(str, 1);
        if (TextUtils.isEmpty(L) || this.bfo == null || this.bfo.beY == null || this.bfo.beY.bfg == null) {
            return null;
        }
        return this.bfo.beY.bfg.get(L);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String L(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.bfo == null || this.bfo.beX == null || this.bfo.beX.bfe == null) {
            return null;
        }
        for (a.C0204a c0204a : this.bfo.beX.bfe) {
            if (TextUtils.equals(c0204a.name, str) || TextUtils.equals(c0204a.bfc, str)) {
                switch (i) {
                    case 0:
                        return c0204a.name;
                    case 1:
                        return c0204a.bfc;
                    case 2:
                        return c0204a.path;
                    case 3:
                        return c0204a.bfd;
                    default:
                        return c0204a.bfc;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
