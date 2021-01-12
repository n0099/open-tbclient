package com.baidu.swan.games.y;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.t.a.a;
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a ejf;
    private com.baidu.swan.games.t.a.a ejg;

    private a() {
    }

    public static a aYm() {
        if (ejf == null) {
            synchronized (a.class) {
                if (ejf == null) {
                    ejf = new a();
                }
            }
        }
        return ejf;
    }

    public void c(com.baidu.swan.games.t.a.a aVar) {
        this.ejg = aVar;
    }

    public boolean wZ(String str) {
        String af = af(str, 1);
        if (TextUtils.isEmpty(af)) {
            return false;
        }
        if (this.ejg != null && this.ejg.ehQ != null && this.ejg.ehQ.ehY != null && this.ejg.ehQ.ehY.containsKey(af)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.ejg.ehQ.ehY.get(af).booleanValue();
        }
        if (DEBUG) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String aIt = e.aIt();
        if (e.aIr() != null) {
            String version = e.aIr().getVersion();
            if (TextUtils.isEmpty(aIt) || TextUtils.isEmpty(version)) {
                return false;
            }
            boolean aj = com.baidu.swan.pms.database.a.bci().aj(aIt, version, af);
            if (aj) {
                ac(af, true);
                return aj;
            }
            return aj;
        }
        return false;
    }

    public void ac(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.ejg != null && this.ejg.ehQ != null && this.ejg.ehQ.ehY != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.ejg.ehQ.ehY.put(str, Boolean.valueOf(z));
        }
    }

    public String rl(String str) {
        String af = af(str, 1);
        if (TextUtils.isEmpty(af) || this.ejg == null || this.ejg.ehR == null || this.ejg.ehR.ehZ == null) {
            return null;
        }
        return this.ejg.ehR.ehZ.get(af);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String af(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.ejg == null || this.ejg.ehQ == null || this.ejg.ehQ.ehX == null) {
            return null;
        }
        for (a.C0531a c0531a : this.ejg.ehQ.ehX) {
            if (TextUtils.equals(c0531a.name, str) || TextUtils.equals(c0531a.ehV, str)) {
                switch (i) {
                    case 0:
                        return c0531a.name;
                    case 1:
                        return c0531a.ehV;
                    case 2:
                        return c0531a.path;
                    case 3:
                        return c0531a.ehW;
                    default:
                        return c0531a.ehV;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
