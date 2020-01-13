package com.baidu.swan.games.x;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.s.a.a;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a cou;
    private com.baidu.swan.games.s.a.a cov;

    private a() {
    }

    public static a anA() {
        if (cou == null) {
            synchronized (a.class) {
                if (cou == null) {
                    cou = new a();
                }
            }
        }
        return cou;
    }

    public void c(com.baidu.swan.games.s.a.a aVar) {
        this.cov = aVar;
    }

    public boolean pv(String str) {
        String Q = Q(str, 1);
        if (TextUtils.isEmpty(Q)) {
            return false;
        }
        if (this.cov != null && this.cov.cng != null && this.cov.cng.cno != null && this.cov.cng.cno.containsKey(Q)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.cov.cng.cno.get(Q).booleanValue();
        }
        if (DEBUG) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String aar = e.aar();
        if (e.aap() != null) {
            String version = e.aap().getVersion();
            if (TextUtils.isEmpty(aar) || TextUtils.isEmpty(version)) {
                return false;
            }
            boolean P = com.baidu.swan.pms.database.a.arf().P(aar, version, Q);
            if (P) {
                y(Q, true);
                return P;
            }
            return P;
        }
        return false;
    }

    public void y(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.cov != null && this.cov.cng != null && this.cov.cng.cno != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.cov.cng.cno.put(str, Boolean.valueOf(z));
        }
    }

    public String kC(String str) {
        String Q = Q(str, 1);
        if (TextUtils.isEmpty(Q) || this.cov == null || this.cov.cnh == null || this.cov.cnh.cnp == null) {
            return null;
        }
        return this.cov.cnh.cnp.get(Q);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String Q(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.cov == null || this.cov.cng == null || this.cov.cng.cnn == null) {
            return null;
        }
        for (a.C0336a c0336a : this.cov.cng.cnn) {
            if (TextUtils.equals(c0336a.name, str) || TextUtils.equals(c0336a.cnl, str)) {
                switch (i) {
                    case 0:
                        return c0336a.name;
                    case 1:
                        return c0336a.cnl;
                    case 2:
                        return c0336a.path;
                    case 3:
                        return c0336a.cnm;
                    default:
                        return c0336a.cnl;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
