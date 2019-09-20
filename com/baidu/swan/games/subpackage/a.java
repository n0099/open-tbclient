package com.baidu.swan.games.subpackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.p.a.a;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a blK;
    private com.baidu.swan.games.p.a.a blL;

    private a() {
    }

    public static a Tt() {
        if (blK == null) {
            synchronized (a.class) {
                if (blK == null) {
                    blK = new a();
                }
            }
        }
        return blK;
    }

    public void c(com.baidu.swan.games.p.a.a aVar) {
        this.blL = aVar;
    }

    public boolean kd(String str) {
        String G = G(str, 1);
        if (TextUtils.isEmpty(G)) {
            return false;
        }
        if (this.blL != null && this.blL.bkA != null && this.blL.bkA.bkH != null && this.blL.bkA.bkH.containsKey(G)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.blL.bkA.bkH.get(G).booleanValue();
        }
        if (DEBUG) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String Ms = com.baidu.swan.apps.ae.b.Ms();
        if (com.baidu.swan.apps.ae.b.Mh() != null) {
            String version = com.baidu.swan.apps.ae.b.Mh().getVersion();
            if (TextUtils.isEmpty(Ms) || TextUtils.isEmpty(version)) {
                return false;
            }
            boolean m = com.baidu.swan.apps.database.subpackage.a.CO().m(Ms, version, G);
            if (m) {
                t(G, true);
                return m;
            }
            return m;
        }
        return false;
    }

    public void t(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.blL != null && this.blL.bkA != null && this.blL.bkA.bkH != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.blL.bkA.bkH.put(str, Boolean.valueOf(z));
        }
    }

    public String gM(String str) {
        String G = G(str, 1);
        if (TextUtils.isEmpty(G) || this.blL == null || this.blL.bkB == null || this.blL.bkB.bkI == null) {
            return null;
        }
        return this.blL.bkB.bkI.get(G);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String G(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.blL == null || this.blL.bkA == null || this.blL.bkA.bkG == null) {
            return null;
        }
        for (a.C0225a c0225a : this.blL.bkA.bkG) {
            if (TextUtils.equals(c0225a.name, str) || TextUtils.equals(c0225a.bkE, str)) {
                switch (i) {
                    case 0:
                        return c0225a.name;
                    case 1:
                        return c0225a.bkE;
                    case 2:
                        return c0225a.path;
                    case 3:
                        return c0225a.bkF;
                    default:
                        return c0225a.bkE;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
