package com.baidu.swan.apps.core.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.install.subpackage.SubPackageAPSInfo;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes2.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d aoJ;
    private HashMap<String, a> aoK = new HashMap<>();
    private HashMap<String, Set<b>> aoL = new HashMap<>();

    /* loaded from: classes2.dex */
    public interface b {
        void dJ(String str);
    }

    private d() {
    }

    public static d xD() {
        if (aoJ == null) {
            synchronized (d.class) {
                if (aoJ == null) {
                    aoJ = new d();
                }
            }
        }
        return aoJ;
    }

    public synchronized void dI(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.i("SwanAppAPSStatusSync", "swanAppPreDownloadFinish:" + str);
            }
            a aVar = new a(2, 0);
            if (this.aoK != null) {
                this.aoK.put(str, aVar);
            }
            if (this.aoL != null) {
                Set<b> set = this.aoL.get(str);
                if (set != null) {
                    for (b bVar : set) {
                        if (bVar != null) {
                            bVar.dJ(str);
                        }
                    }
                }
                this.aoL.remove(str);
            }
        }
    }

    public synchronized void a(SubPackageAPSInfo subPackageAPSInfo) {
        dI(b(subPackageAPSInfo));
    }

    private String b(SubPackageAPSInfo subPackageAPSInfo) {
        if (subPackageAPSInfo == null) {
            return "";
        }
        String str = subPackageAPSInfo.mAppId;
        String str2 = subPackageAPSInfo.axr;
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
