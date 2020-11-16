package com.baidu.swan.games.y;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.t.a.a;
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a dXT;
    private com.baidu.swan.games.t.a.a dXU;

    private a() {
    }

    public static a aWG() {
        if (dXT == null) {
            synchronized (a.class) {
                if (dXT == null) {
                    dXT = new a();
                }
            }
        }
        return dXT;
    }

    public void c(com.baidu.swan.games.t.a.a aVar) {
        this.dXU = aVar;
    }

    public boolean xE(String str) {
        String ac = ac(str, 1);
        if (TextUtils.isEmpty(ac)) {
            return false;
        }
        if (this.dXU != null && this.dXU.dWG != null && this.dXU.dWG.dWO != null && this.dXU.dWG.dWO.containsKey(ac)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.dXU.dWG.dWO.get(ac).booleanValue();
        }
        if (DEBUG) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String aGO = e.aGO();
        if (e.aGM() != null) {
            String version = e.aGM().getVersion();
            if (TextUtils.isEmpty(aGO) || TextUtils.isEmpty(version)) {
                return false;
            }
            boolean ae = com.baidu.swan.pms.database.a.baA().ae(aGO, version, ac);
            if (ae) {
                ab(ac, true);
                return ae;
            }
            return ae;
        }
        return false;
    }

    public void ab(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.dXU != null && this.dXU.dWG != null && this.dXU.dWG.dWO != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.dXU.dWG.dWO.put(str, Boolean.valueOf(z));
        }
    }

    public String rS(String str) {
        String ac = ac(str, 1);
        if (TextUtils.isEmpty(ac) || this.dXU == null || this.dXU.dWH == null || this.dXU.dWH.dWP == null) {
            return null;
        }
        return this.dXU.dWH.dWP.get(ac);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String ac(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.dXU == null || this.dXU.dWG == null || this.dXU.dWG.dWN == null) {
            return null;
        }
        for (a.C0543a c0543a : this.dXU.dWG.dWN) {
            if (TextUtils.equals(c0543a.name, str) || TextUtils.equals(c0543a.dWL, str)) {
                switch (i) {
                    case 0:
                        return c0543a.name;
                    case 1:
                        return c0543a.dWL;
                    case 2:
                        return c0543a.path;
                    case 3:
                        return c0543a.dWM;
                    default:
                        return c0543a.dWL;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
