package com.baidu.swan.games.subpackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.p.a.a;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a blm;
    private com.baidu.swan.games.p.a.a bln;

    private a() {
    }

    public static a Tp() {
        if (blm == null) {
            synchronized (a.class) {
                if (blm == null) {
                    blm = new a();
                }
            }
        }
        return blm;
    }

    public void c(com.baidu.swan.games.p.a.a aVar) {
        this.bln = aVar;
    }

    public boolean kb(String str) {
        String G = G(str, 1);
        if (TextUtils.isEmpty(G)) {
            return false;
        }
        if (this.bln != null && this.bln.bkc != null && this.bln.bkc.bkj != null && this.bln.bkc.bkj.containsKey(G)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.bln.bkc.bkj.get(G).booleanValue();
        }
        if (DEBUG) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String Mo = com.baidu.swan.apps.ae.b.Mo();
        if (com.baidu.swan.apps.ae.b.Md() != null) {
            String version = com.baidu.swan.apps.ae.b.Md().getVersion();
            if (TextUtils.isEmpty(Mo) || TextUtils.isEmpty(version)) {
                return false;
            }
            boolean m = com.baidu.swan.apps.database.subpackage.a.CK().m(Mo, version, G);
            if (m) {
                t(G, true);
                return m;
            }
            return m;
        }
        return false;
    }

    public void t(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.bln != null && this.bln.bkc != null && this.bln.bkc.bkj != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.bln.bkc.bkj.put(str, Boolean.valueOf(z));
        }
    }

    public String gK(String str) {
        String G = G(str, 1);
        if (TextUtils.isEmpty(G) || this.bln == null || this.bln.bkd == null || this.bln.bkd.bkk == null) {
            return null;
        }
        return this.bln.bkd.bkk.get(G);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String G(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.bln == null || this.bln.bkc == null || this.bln.bkc.bki == null) {
            return null;
        }
        for (a.C0211a c0211a : this.bln.bkc.bki) {
            if (TextUtils.equals(c0211a.name, str) || TextUtils.equals(c0211a.bkg, str)) {
                switch (i) {
                    case 0:
                        return c0211a.name;
                    case 1:
                        return c0211a.bkg;
                    case 2:
                        return c0211a.path;
                    case 3:
                        return c0211a.bkh;
                    default:
                        return c0211a.bkg;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
