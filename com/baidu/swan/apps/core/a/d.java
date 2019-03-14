package com.baidu.swan.apps.core.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.install.subpackage.SubPackageAPSInfo;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes2.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d aoF;
    private HashMap<String, a> aoG = new HashMap<>();
    private HashMap<String, Set<b>> aoH = new HashMap<>();

    /* loaded from: classes2.dex */
    public interface b {
        void dH(String str);
    }

    private d() {
    }

    public static d xE() {
        if (aoF == null) {
            synchronized (d.class) {
                if (aoF == null) {
                    aoF = new d();
                }
            }
        }
        return aoF;
    }

    public synchronized void dG(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.i("SwanAppAPSStatusSync", "swanAppPreDownloadFinish:" + str);
            }
            a aVar = new a(2, 0);
            if (this.aoG != null) {
                this.aoG.put(str, aVar);
            }
            if (this.aoH != null) {
                Set<b> set = this.aoH.get(str);
                if (set != null) {
                    for (b bVar : set) {
                        if (bVar != null) {
                            bVar.dH(str);
                        }
                    }
                }
                this.aoH.remove(str);
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
        String str2 = subPackageAPSInfo.axo;
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
