package com.baidu.swan.games.y;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.t.a.a;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a dhs;
    private com.baidu.swan.games.t.a.a dht;

    private a() {
    }

    public static a aDc() {
        if (dhs == null) {
            synchronized (a.class) {
                if (dhs == null) {
                    dhs = new a();
                }
            }
        }
        return dhs;
    }

    public void c(com.baidu.swan.games.t.a.a aVar) {
        this.dht = aVar;
    }

    public boolean sI(String str) {
        String X = X(str, 1);
        if (TextUtils.isEmpty(X)) {
            return false;
        }
        if (this.dht != null && this.dht.dgf != null && this.dht.dgf.dgn != null && this.dht.dgf.dgn.containsKey(X)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.dht.dgf.dgn.get(X).booleanValue();
        }
        if (DEBUG) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String apO = e.apO();
        if (e.apM() != null) {
            String version = e.apM().getVersion();
            if (TextUtils.isEmpty(apO) || TextUtils.isEmpty(version)) {
                return false;
            }
            boolean W = com.baidu.swan.pms.database.a.aHb().W(apO, version, X);
            if (W) {
                R(X, true);
                return W;
            }
            return W;
        }
        return false;
    }

    public void R(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.dht != null && this.dht.dgf != null && this.dht.dgf.dgn != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.dht.dgf.dgn.put(str, Boolean.valueOf(z));
        }
    }

    public String nG(String str) {
        String X = X(str, 1);
        if (TextUtils.isEmpty(X) || this.dht == null || this.dht.dgg == null || this.dht.dgg.dgo == null) {
            return null;
        }
        return this.dht.dgg.dgo.get(X);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String X(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.dht == null || this.dht.dgf == null || this.dht.dgf.dgm == null) {
            return null;
        }
        for (a.C0446a c0446a : this.dht.dgf.dgm) {
            if (TextUtils.equals(c0446a.name, str) || TextUtils.equals(c0446a.dgk, str)) {
                switch (i) {
                    case 0:
                        return c0446a.name;
                    case 1:
                        return c0446a.dgk;
                    case 2:
                        return c0446a.path;
                    case 3:
                        return c0446a.dgl;
                    default:
                        return c0446a.dgk;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
