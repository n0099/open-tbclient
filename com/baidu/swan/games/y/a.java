package com.baidu.swan.games.y;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.t.a.a;
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a emN;
    private com.baidu.swan.games.t.a.a emO;

    private a() {
    }

    public static a aYB() {
        if (emN == null) {
            synchronized (a.class) {
                if (emN == null) {
                    emN = new a();
                }
            }
        }
        return emN;
    }

    public void c(com.baidu.swan.games.t.a.a aVar) {
        this.emO = aVar;
    }

    public boolean xz(String str) {
        String ai = ai(str, 1);
        if (TextUtils.isEmpty(ai)) {
            return false;
        }
        if (this.emO != null && this.emO.ely != null && this.emO.ely.elG != null && this.emO.ely.elG.containsKey(ai)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.emO.ely.elG.get(ai).booleanValue();
        }
        if (DEBUG) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String aIP = e.aIP();
        if (e.aIN() != null) {
            String version = e.aIN().getVersion();
            if (TextUtils.isEmpty(aIP) || TextUtils.isEmpty(version)) {
                return false;
            }
            boolean ak = com.baidu.swan.pms.database.a.bcx().ak(aIP, version, ai);
            if (ak) {
                ab(ai, true);
                return ak;
            }
            return ak;
        }
        return false;
    }

    public void ab(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.emO != null && this.emO.ely != null && this.emO.ely.elG != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.emO.ely.elG.put(str, Boolean.valueOf(z));
        }
    }

    public String rL(String str) {
        String ai = ai(str, 1);
        if (TextUtils.isEmpty(ai) || this.emO == null || this.emO.elz == null || this.emO.elz.elH == null) {
            return null;
        }
        return this.emO.elz.elH.get(ai);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String ai(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.emO == null || this.emO.ely == null || this.emO.ely.elF == null) {
            return null;
        }
        for (a.C0534a c0534a : this.emO.ely.elF) {
            if (TextUtils.equals(c0534a.name, str) || TextUtils.equals(c0534a.elD, str)) {
                switch (i) {
                    case 0:
                        return c0534a.name;
                    case 1:
                        return c0534a.elD;
                    case 2:
                        return c0534a.path;
                    case 3:
                        return c0534a.elE;
                    default:
                        return c0534a.elD;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
