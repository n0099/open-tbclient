package com.baidu.swan.games.subpackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.p.a.a;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a bDH;
    private com.baidu.swan.games.p.a.a bDI;

    private a() {
    }

    public static a Yi() {
        if (bDH == null) {
            synchronized (a.class) {
                if (bDH == null) {
                    bDH = new a();
                }
            }
        }
        return bDH;
    }

    public void c(com.baidu.swan.games.p.a.a aVar) {
        this.bDI = aVar;
    }

    public boolean kF(String str) {
        String G = G(str, 1);
        if (TextUtils.isEmpty(G)) {
            return false;
        }
        if (this.bDI != null && this.bDI.bCx != null && this.bDI.bCx.bCE != null && this.bDI.bCx.bCE.containsKey(G)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.bDI.bCx.bCE.get(G).booleanValue();
        }
        if (DEBUG) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String Rm = com.baidu.swan.apps.ae.b.Rm();
        if (com.baidu.swan.apps.ae.b.Ra() != null) {
            String version = com.baidu.swan.apps.ae.b.Ra().getVersion();
            if (TextUtils.isEmpty(Rm) || TextUtils.isEmpty(version)) {
                return false;
            }
            boolean q = com.baidu.swan.apps.database.subpackage.a.HJ().q(Rm, version, G);
            if (q) {
                w(G, true);
                return q;
            }
            return q;
        }
        return false;
    }

    public void w(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.bDI != null && this.bDI.bCx != null && this.bDI.bCx.bCE != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.bDI.bCx.bCE.put(str, Boolean.valueOf(z));
        }
    }

    public String hq(String str) {
        String G = G(str, 1);
        if (TextUtils.isEmpty(G) || this.bDI == null || this.bDI.bCy == null || this.bDI.bCy.bCF == null) {
            return null;
        }
        return this.bDI.bCy.bCF.get(G);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String G(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.bDI == null || this.bDI.bCx == null || this.bDI.bCx.bCD == null) {
            return null;
        }
        for (a.C0257a c0257a : this.bDI.bCx.bCD) {
            if (TextUtils.equals(c0257a.name, str) || TextUtils.equals(c0257a.bCB, str)) {
                switch (i) {
                    case 0:
                        return c0257a.name;
                    case 1:
                        return c0257a.bCB;
                    case 2:
                        return c0257a.path;
                    case 3:
                        return c0257a.bCC;
                    default:
                        return c0257a.bCB;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
