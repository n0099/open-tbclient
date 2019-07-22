package com.baidu.swan.apps.core.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.install.subpackage.SubPackageAPSInfo;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes2.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d apA;
    private HashMap<String, a> apB = new HashMap<>();
    private HashMap<String, Set<b>> apC = new HashMap<>();

    /* loaded from: classes2.dex */
    public interface b {
        void dA(String str);
    }

    private d() {
    }

    public static d zb() {
        if (apA == null) {
            synchronized (d.class) {
                if (apA == null) {
                    apA = new d();
                }
            }
        }
        return apA;
    }

    public synchronized void dz(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.i("SwanAppAPSStatusSync", "swanAppPreDownloadFinish:" + str);
            }
            a aVar = new a(2, 0);
            if (this.apB != null) {
                this.apB.put(str, aVar);
            }
            if (this.apC != null) {
                Set<b> set = this.apC.get(str);
                if (set != null) {
                    for (b bVar : set) {
                        if (bVar != null) {
                            bVar.dA(str);
                        }
                    }
                }
                this.apC.remove(str);
            }
        }
    }

    public synchronized void a(SubPackageAPSInfo subPackageAPSInfo) {
        dz(b(subPackageAPSInfo));
    }

    private String b(SubPackageAPSInfo subPackageAPSInfo) {
        if (subPackageAPSInfo == null) {
            return "";
        }
        String str = subPackageAPSInfo.mAppId;
        String str2 = subPackageAPSInfo.ayM;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        return str + "_" + str2;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public int mStatus;
        public int mType;

        public a(int i, int i2) {
            this.mType = i;
            this.mStatus = i2;
        }
    }
}
