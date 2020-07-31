package com.baidu.swan.games.y;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.t.a.a;
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a dnb;
    private com.baidu.swan.games.t.a.a dnc;

    private a() {
    }

    public static a aGJ() {
        if (dnb == null) {
            synchronized (a.class) {
                if (dnb == null) {
                    dnb = new a();
                }
            }
        }
        return dnb;
    }

    public void c(com.baidu.swan.games.t.a.a aVar) {
        this.dnc = aVar;
    }

    public boolean tG(String str) {
        String X = X(str, 1);
        if (TextUtils.isEmpty(X)) {
            return false;
        }
        if (this.dnc != null && this.dnc.dlO != null && this.dnc.dlO.dlW != null && this.dnc.dlO.dlW.containsKey(X)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.dnc.dlO.dlW.get(X).booleanValue();
        }
        if (DEBUG) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String arx = e.arx();
        if (e.arv() != null) {
            String version = e.arv().getVersion();
            if (TextUtils.isEmpty(arx) || TextUtils.isEmpty(version)) {
                return false;
            }
            boolean W = com.baidu.swan.pms.database.a.aKS().W(arx, version, X);
            if (W) {
                Q(X, true);
                return W;
            }
            return W;
        }
        return false;
    }

    public void Q(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.dnc != null && this.dnc.dlO != null && this.dnc.dlO.dlW != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.dnc.dlO.dlW.put(str, Boolean.valueOf(z));
        }
    }

    public String oo(String str) {
        String X = X(str, 1);
        if (TextUtils.isEmpty(X) || this.dnc == null || this.dnc.dlP == null || this.dnc.dlP.dlX == null) {
            return null;
        }
        return this.dnc.dlP.dlX.get(X);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String X(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.dnc == null || this.dnc.dlO == null || this.dnc.dlO.dlV == null) {
            return null;
        }
        for (a.C0459a c0459a : this.dnc.dlO.dlV) {
            if (TextUtils.equals(c0459a.name, str) || TextUtils.equals(c0459a.dlT, str)) {
                switch (i) {
                    case 0:
                        return c0459a.name;
                    case 1:
                        return c0459a.dlT;
                    case 2:
                        return c0459a.path;
                    case 3:
                        return c0459a.dlU;
                    default:
                        return c0459a.dlT;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
