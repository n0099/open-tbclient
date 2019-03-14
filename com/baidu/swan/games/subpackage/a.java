package com.baidu.swan.games.subpackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.o.a.a;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a bfk;
    private com.baidu.swan.games.o.a.a bfl;

    private a() {
    }

    public static a Pf() {
        if (bfk == null) {
            synchronized (a.class) {
                if (bfk == null) {
                    bfk = new a();
                }
            }
        }
        return bfk;
    }

    public void c(com.baidu.swan.games.o.a.a aVar) {
        this.bfl = aVar;
    }

    public boolean gg(String str) {
        String L = L(str, 1);
        if (TextUtils.isEmpty(L)) {
            return false;
        }
        if (this.bfl != null && this.bfl.beU != null && this.bfl.beU.bfc != null && this.bfl.beU.bfc.containsKey(L)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.bfl.beU.bfc.get(L).booleanValue();
        }
        if (DEBUG) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String Ji = com.baidu.swan.apps.ae.b.Ji();
        if (com.baidu.swan.apps.ae.b.IX() != null) {
            String version = com.baidu.swan.apps.ae.b.IX().getVersion();
            if (TextUtils.isEmpty(Ji) || TextUtils.isEmpty(version)) {
                return false;
            }
            boolean m = com.baidu.swan.apps.database.subpackage.a.AV().m(Ji, version, L);
            if (m) {
                D(L, true);
                return m;
            }
            return m;
        }
        return false;
    }

    public void D(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.bfl != null && this.bfl.beU != null && this.bfl.beU.bfc != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.bfl.beU.bfc.put(str, Boolean.valueOf(z));
        }
    }

    public String gi(String str) {
        String L = L(str, 1);
        if (TextUtils.isEmpty(L) || this.bfl == null || this.bfl.beV == null || this.bfl.beV.bfd == null) {
            return null;
        }
        return this.bfl.beV.bfd.get(L);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String L(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.bfl == null || this.bfl.beU == null || this.bfl.beU.bfa == null) {
            return null;
        }
        for (a.C0204a c0204a : this.bfl.beU.bfa) {
            if (TextUtils.equals(c0204a.name, str) || TextUtils.equals(c0204a.beY, str)) {
                switch (i) {
                    case 0:
                        return c0204a.name;
                    case 1:
                        return c0204a.beY;
                    case 2:
                        return c0204a.path;
                    case 3:
                        return c0204a.beZ;
                    default:
                        return c0204a.beY;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
