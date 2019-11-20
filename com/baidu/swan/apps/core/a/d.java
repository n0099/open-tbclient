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
    private static volatile d aIW;
    private HashMap<String, a> aIX = new HashMap<>();
    private HashMap<String, Set<b>> aIY = new HashMap<>();

    /* loaded from: classes2.dex */
    public interface b {
        void ek(String str);
    }

    private d() {
    }

    public static d Eb() {
        if (aIW == null) {
            synchronized (d.class) {
                if (aIW == null) {
                    aIW = new d();
                }
            }
        }
        return aIW;
    }

    public synchronized void ej(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.i("SwanAppAPSStatusSync", "swanAppPreDownloadFinish:" + str);
            }
            a aVar = new a(2, 0);
            if (this.aIX != null) {
                this.aIX.put(str, aVar);
            }
            if (this.aIY != null) {
                Set<b> set = this.aIY.get(str);
                if (set != null) {
                    for (b bVar : set) {
                        if (bVar != null) {
                            bVar.ek(str);
                        }
                    }
                }
                this.aIY.remove(str);
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
        String str2 = subPackageAPSInfo.aSi;
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
