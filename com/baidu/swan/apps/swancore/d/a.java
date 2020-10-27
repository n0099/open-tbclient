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

    public static C0476a c(String str, String str2, String str3, int i) {
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate start.");
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long tB = com.baidu.swan.apps.swancore.b.tB(str);
        if (tB == 0) {
            return C0476a.tC("invalid version code : " + str);
        }
        if (!ae.e(new File(str2), str3)) {
            return C0476a.tC("sign failed.");
        }
        if (!d.unzipFile(str2, k(tB, i).getPath())) {
            return C0476a.tC("unzip bundle failed.");
        }
        if (DEBUG) {
            String md5 = e.toMd5(new File(str2), false);
            if (!TextUtils.isEmpty(md5)) {
                h.aIs().putString(com.baidu.swan.apps.swancore.a.kq(i), md5);
            }
        }
        if (ProcessUtils.isMainProcess()) {
            com.baidu.swan.apps.swancore.b.b(kQ(i), l(kN(i), tB));
        }
        j(tB, i);
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate end. version = " + tB);
        }
        return C0476a.aIG();
    }

    private static ArrayList<Long> l(long j, long j2) {
        SwanCoreVersion apD;
        ArrayList<Long> arrayList = new ArrayList<>();
        if (j != 0) {
            arrayList.add(Long.valueOf(j));
        }
        arrayList.add(Long.valueOf(j2));
        for (c cVar : com.baidu.swan.apps.process.messaging.service.e.aDs().aDu()) {
            SwanAppCores aDe = cVar.aDe();
            if (cVar.aDf() && aDe != null && (apD = aDe.apD()) != null && !arrayList.contains(Long.valueOf(apD.swanCoreVersion))) {
                arrayList.add(Long.valueOf(apD.swanCoreVersion));
            }
        }
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray()));
        }
        return arrayList;
    }

    public static SwanCoreVersion k(int i, long j) {
        SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
        swanCoreVersion.swanCorePath = k(j, i).getPath();
        swanCoreVersion.swanCoreType = 1;
        swanCoreVersion.swanCoreVersion = j;
        return swanCoreVersion;
    }

    public static long kN(int i) {
        return h.aIs().getLong(kP(i), 0L);
    }

    public static void kO(int i) {
        j(0L, i);
    }

    private static String kP(int i) {
        return i == 1 ? "aigames_cur_remote_ver_key" : "aiapps_cur_remote_ver_key";
    }

    private static void j(final long j, final int i) {
        h.aIs().putLong(kP(i), j);
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.swancore.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.swancore.a.aIt().g(j, i);
                } catch (Exception e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }, "cacheSwanCoreInfo");
    }

    private static File kQ(int i) {
        return new File(com.baidu.swan.apps.swancore.b.ky(i), "remote");
    }

    private static File k(long j, int i) {
        return new File(kQ(i), String.valueOf(j));
    }

    /* renamed from: com.baidu.swan.apps.swancore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0476a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0476a aIG() {
            return aj(0, "");
        }

        public static C0476a tC(String str) {
            return aj(1, str);
        }

        public static C0476a aj(int i, String str) {
            C0476a c0476a = new C0476a();
            c0476a.statusCode = i;
            c0476a.message = str;
            return c0476a;
        }

        @NonNull
        public String toString() {
            return "RemoteCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
