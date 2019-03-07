package com.baidu.swan.games.subpackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.o.a.a;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static volatile a bfj;
    private com.baidu.swan.games.o.a.a bfk;

    private a() {
    }

    public static a Pf() {
        if (bfj == null) {
            synchronized (a.class) {
                if (bfj == null) {
                    bfj = new a();
                }
            }
        }
        return bfj;
    }

    public void c(com.baidu.swan.games.o.a.a aVar) {
        this.bfk = aVar;
    }

    public boolean gg(String str) {
        String L = L(str, 1);
        if (TextUtils.isEmpty(L)) {
            return false;
        }
        if (this.bfk != null && this.bfk.beT != null && this.bfk.beT.bfa != null && this.bfk.beT.bfa.containsKey(L)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.bfk.beT.bfa.get(L).booleanValue();
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
        if (!TextUtils.isEmpty(str) && this.bfk != null && this.bfk.beT != null && this.bfk.beT.bfa != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.bfk.beT.bfa.put(str, Boolean.valueOf(z));
        }
    }

    public String gi(String str) {
        String L = L(str, 1);
        if (TextUtils.isEmpty(L) || this.bfk == null || this.bfk.beU == null || this.bfk.beU.bfc == null) {
            return null;
        }
        return this.bfk.beU.bfc.get(L);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String L(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.bfk == null || this.bfk.beT == null || this.bfk.beT.beZ == null) {
            return null;
        }
        for (a.C0175a c0175a : this.bfk.beT.beZ) {
            if (TextUtils.equals(c0175a.name, str) || TextUtils.equals(c0175a.beX, str)) {
                switch (i) {
                    case 0:
                        return c0175a.name;
                    case 1:
                        return c0175a.beX;
                    case 2:
                        return c0175a.path;
                    case 3:
                        return c0175a.beY;
                    default:
                        return c0175a.beX;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
