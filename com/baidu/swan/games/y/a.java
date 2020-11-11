package com.baidu.swan.games.y;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.t.a.a;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a dZB;
    private com.baidu.swan.games.t.a.a dZC;

    private a() {
    }

    public static a aXo() {
        if (dZB == null) {
            synchronized (a.class) {
                if (dZB == null) {
                    dZB = new a();
                }
            }
        }
        return dZB;
    }

    public void c(com.baidu.swan.games.t.a.a aVar) {
        this.dZC = aVar;
    }

    public boolean xJ(String str) {
        String ac = ac(str, 1);
        if (TextUtils.isEmpty(ac)) {
            return false;
        }
        if (this.dZC != null && this.dZC.dYo != null && this.dZC.dYo.dYw != null && this.dZC.dYo.dYw.containsKey(ac)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.dZC.dYo.dYw.get(ac).booleanValue();
        }
        if (DEBUG) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String aHw = e.aHw();
        if (e.aHu() != null) {
            String version = e.aHu().getVersion();
            if (TextUtils.isEmpty(aHw) || TextUtils.isEmpty(version)) {
                return false;
            }
            boolean ae = com.baidu.swan.pms.database.a.bbh().ae(aHw, version, ac);
            if (ae) {
                ab(ac, true);
                return ae;
            }
            return ae;
        }
        return false;
    }

    public void ab(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.dZC != null && this.dZC.dYo != null && this.dZC.dYo.dYw != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.dZC.dYo.dYw.put(str, Boolean.valueOf(z));
        }
    }

    public String rY(String str) {
        String ac = ac(str, 1);
        if (TextUtils.isEmpty(ac) || this.dZC == null || this.dZC.dYp == null || this.dZC.dYp.dYx == null) {
            return null;
        }
        return this.dZC.dYp.dYx.get(ac);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String ac(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.dZC == null || this.dZC.dYo == null || this.dZC.dYo.dYv == null) {
            return null;
        }
        for (a.C0545a c0545a : this.dZC.dYo.dYv) {
            if (TextUtils.equals(c0545a.name, str) || TextUtils.equals(c0545a.dYt, str)) {
                switch (i) {
                    case 0:
                        return c0545a.name;
                    case 1:
                        return c0545a.dYt;
                    case 2:
                        return c0545a.path;
                    case 3:
                        return c0545a.dYu;
                    default:
                        return c0545a.dYt;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
