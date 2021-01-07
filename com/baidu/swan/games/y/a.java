package com.baidu.swan.games.y;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.t.a.a;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a enT;
    private com.baidu.swan.games.t.a.a enU;

    private a() {
    }

    public static a bcg() {
        if (enT == null) {
            synchronized (a.class) {
                if (enT == null) {
                    enT = new a();
                }
            }
        }
        return enT;
    }

    public void c(com.baidu.swan.games.t.a.a aVar) {
        this.enU = aVar;
    }

    public boolean yk(String str) {
        String af = af(str, 1);
        if (TextUtils.isEmpty(af)) {
            return false;
        }
        if (this.enU != null && this.enU.emC != null && this.enU.emC.emK != null && this.enU.emC.emK.containsKey(af)) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.enU.emC.emK.get(af).booleanValue();
        }
        if (DEBUG) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String aMn = e.aMn();
        if (e.aMl() != null) {
            String version = e.aMl().getVersion();
            if (TextUtils.isEmpty(aMn) || TextUtils.isEmpty(version)) {
                return false;
            }
            boolean ak = com.baidu.swan.pms.database.a.bgc().ak(aMn, version, af);
            if (ak) {
                ac(af, true);
                return ak;
            }
            return ak;
        }
        return false;
    }

    public void ac(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.enU != null && this.enU.emC != null && this.enU.emC.emK != null) {
            if (DEBUG) {
                Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
            }
            this.enU.emC.emK.put(str, Boolean.valueOf(z));
        }
    }

    public String sx(String str) {
        String af = af(str, 1);
        if (TextUtils.isEmpty(af) || this.enU == null || this.enU.emD == null || this.enU.emD.emL == null) {
            return null;
        }
        return this.enU.emD.emL.get(af);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String af(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.enU == null || this.enU.emC == null || this.enU.emC.emJ == null) {
            return null;
        }
        for (a.C0548a c0548a : this.enU.emC.emJ) {
            if (TextUtils.equals(c0548a.name, str) || TextUtils.equals(c0548a.emH, str)) {
                switch (i) {
                    case 0:
                        return c0548a.name;
                    case 1:
                        return c0548a.emH;
                    case 2:
                        return c0548a.path;
                    case 3:
                        return c0548a.emI;
                    default:
                        return c0548a.emH;
                }
            }
            while (r2.hasNext()) {
            }
        }
        return null;
    }
}
