package com.baidu.swan.apps.core.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.swan.apps.install.subpackage.SubPackageAPSInfo;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes2.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d aJo;
    private HashMap<String, a> aJp = new HashMap<>();
    private HashMap<String, Set<b>> aJq = new HashMap<>();

    /* loaded from: classes2.dex */
    public interface b {
        void ek(String str);
    }

    private d() {
    }

    public static d Ea() {
        if (aJo == null) {
            synchronized (d.class) {
                if (aJo == null) {
                    aJo = new d();
                }
            }
        }
        return aJo;
    }

    public synchronized void ej(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.i("SwanAppAPSStatusSync", "swanAppPreDownloadFinish:" + str);
            }
            a aVar = new a(2, 0);
            if (this.aJp != null) {
                this.aJp.put(str, aVar);
            }
            if (this.aJq != null) {
                Set<b> set = this.aJq.get(str);
                if (set != null) {
                    for (b bVar : set) {
                        if (bVar != null) {
                            bVar.ek(str);
                        }
                    }
                }
                this.aJq.remove(str);
            }
        }
    }

    public synchronized void a(SubPackageAPSInfo subPackageAPSInfo) {
        ej(b(subPackageAPSInfo));
    }

    private String b(SubPackageAPSInfo subPackageAPSInfo) {
        if (subPackageAPSInfo == null) {
            return "";
        }
        String str = subPackageAPSInfo.mAppId;
        String str2 = subPackageAPSInfo.aSA;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2;
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
