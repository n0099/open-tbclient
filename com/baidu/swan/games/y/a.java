package com.baidu.swan.games.y;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.t.a.a;
/* loaded from: classes25.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a eeS;
    private com.baidu.swan.games.t.a.a eeT;

    private a() {
    }

    public static a aZL() {
        if (eeS == null) {
            synchronized (a.class) {
                if (eeS == null) {
                    eeS = new a();
                }
            }
        }
        return eeS;
    }

    public void c(com.baidu.swan.games.t.a.a aVar) {
        this.eeT = aVar;
    }

    public boolean yl(String str) {
        String ad = ad(str, 1);
        if (TextUtils.isEmpty(ad)) {
            return false;
        }
        if (this.eeT != null && this.eeT.edF != null && this.eeT.edF.edN != null && this.eeT.edF.edN.containsKey(ad)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.eeT.edF.edN.get(ad).booleanValue();
        }
        if (DEBUG) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String aJW = e.aJW();
        if (e.aJU() != null) {
            String version = e.aJU().getVersion();
            if (TextUtils.isEmpty(aJW) || TextUtils.isEmpty(version)) {
                return false;
            }
            boolean ah = com.baidu.swan.pms.database.a.bdF().ah(aJW, version, ad);
            if (ah) {
                ac(ad, true);
                return ah;
            }
            return ah;
        }
        return false;
    }

    public void ac(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.eeT != null && this.eeT.edF != null && this.eeT.edF.edN != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.eeT.edF.edN.put(str, Boolean.valueOf(z));
        }
    }

    public String sA(String str) {
        String ad = ad(str, 1);
        if (TextUtils.isEmpty(ad) || this.eeT == null || this.eeT.edG == null || this.eeT.edG.edO == null) {
            return null;
        }
        return this.eeT.edG.edO.get(ad);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String ad(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.eeT == null || this.eeT.edF == null || this.eeT.edF.edM == null) {
            return null;
        }
        for (a.C0555a c0555a : this.eeT.edF.edM) {
            if (TextUtils.equals(c0555a.name, str) || TextUtils.equals(c0555a.edK, str)) {
                switch (i) {
                    case 0:
                        return c0555a.name;
                    case 1:
                        return c0555a.edK;
                    case 2:
                        return c0555a.path;
                    case 3:
                        return c0555a.edL;
                    default:
                        return c0555a.edK;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
