package com.baidu.swan.apps.core.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.install.subpackage.SubPackageAPSInfo;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes2.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static volatile d aoE;
    private HashMap<String, a> aoF = new HashMap<>();
    private HashMap<String, Set<b>> aoG = new HashMap<>();

    /* loaded from: classes2.dex */
    public interface b {
        void dH(String str);
    }

    private d() {
    }

    public static d xE() {
        if (aoE == null) {
            synchronized (d.class) {
                if (aoE == null) {
                    aoE = new d();
                }
            }
        }
        return aoE;
    }

    public synchronized void dG(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.i("SwanAppAPSStatusSync", "swanAppPreDownloadFinish:" + str);
            }
            a aVar = new a(2, 0);
            if (this.aoF != null) {
                this.aoF.put(str, aVar);
            }
            if (this.aoG != null) {
                Set<b> set = this.aoG.get(str);
                if (set != null) {
                    for (b bVar : set) {
                        if (bVar != null) {
                            bVar.dH(str);
                        }
                    }
                }
                this.aoG.remove(str);
            }
        }
    }

    public synchronized void a(SubPackageAPSInfo subPackageAPSInfo) {
        dG(b(subPackageAPSInfo));
    }

    private String b(SubPackageAPSInfo subPackageAPSInfo) {
        if (subPackageAPSInfo == null) {
            return "";
        }
        String str = subPackageAPSInfo.mAppId;
        String str2 = subPackageAPSInfo.axn;
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
