package com.baidu.swan.apps.swancore.d;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.ap.ae;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.messaging.service.c;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.c.d;
import com.baidu.swan.c.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static C0488a c(String str, String str2, String str3, int i) {
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate start.");
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long tP = com.baidu.swan.apps.swancore.b.tP(str);
        if (tP == 0) {
            return C0488a.tQ("invalid version code : " + str);
        }
        if (!ae.e(new File(str2), str3)) {
            return C0488a.tQ("sign failed.");
        }
        if (!d.unzipFile(str2, o(tP, i).getPath())) {
            return C0488a.tQ("unzip bundle failed.");
        }
        if (DEBUG) {
            String md5 = e.toMd5(new File(str2), false);
            if (!TextUtils.isEmpty(md5)) {
                h.aKS().putString(com.baidu.swan.apps.swancore.a.kA(i), md5);
            }
        }
        if (ProcessUtils.isMainProcess()) {
            com.baidu.swan.apps.swancore.b.b(la(i), m(kX(i), tP));
        }
        n(tP, i);
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate end. version = " + tP);
        }
        return C0488a.aLg();
    }

    private static ArrayList<Long> m(long j, long j2) {
        SwanCoreVersion asd;
        ArrayList<Long> arrayList = new ArrayList<>();
        if (j != 0) {
            arrayList.add(Long.valueOf(j));
        }
        arrayList.add(Long.valueOf(j2));
        for (c cVar : com.baidu.swan.apps.process.messaging.service.e.aFS().aFU()) {
            SwanAppCores aFE = cVar.aFE();
            if (cVar.aFF() && aFE != null && (asd = aFE.asd()) != null && !arrayList.contains(Long.valueOf(asd.swanCoreVersion))) {
                arrayList.add(Long.valueOf(asd.swanCoreVersion));
            }
        }
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray()));
        }
        return arrayList;
    }

    public static SwanCoreVersion j(int i, long j) {
        SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
        swanCoreVersion.swanCorePath = o(j, i).getPath();
        swanCoreVersion.swanCoreType = 1;
        swanCoreVersion.swanCoreVersion = j;
        return swanCoreVersion;
    }

    public static long kX(int i) {
        return h.aKS().getLong(kZ(i), 0L);
    }

    public static void kY(int i) {
        n(0L, i);
    }

    private static String kZ(int i) {
        return i == 1 ? "aigames_cur_remote_ver_key" : "aiapps_cur_remote_ver_key";
    }

    private static void n(final long j, final int i) {
        h.aKS().putLong(kZ(i), j);
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.swancore.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.swancore.a.aKT().k(j, i);
                } catch (Exception e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }, "cacheSwanCoreInfo");
    }

    private static File la(int i) {
        return new File(com.baidu.swan.apps.swancore.b.kI(i), "remote");
    }

    private static File o(long j, int i) {
        return new File(la(i), String.valueOf(j));
    }

    /* renamed from: com.baidu.swan.apps.swancore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0488a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0488a aLg() {
            return an(0, "");
        }

        public static C0488a tQ(String str) {
            return an(1, str);
        }

        public static C0488a an(int i, String str) {
            C0488a c0488a = new C0488a();
            c0488a.statusCode = i;
            c0488a.message = str;
            return c0488a;
        }

        @NonNull
        public String toString() {
            return "RemoteCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
