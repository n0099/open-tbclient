package com.baidu.swan.apps.swancore.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.aq.ac;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.messaging.service.c;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.e.d;
import com.baidu.swan.e.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static C0398a c(String str, String str2, String str3, int i) {
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate start.");
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long pq = com.baidu.swan.apps.swancore.b.pq(str);
        if (pq == 0) {
            return C0398a.pr("invalid version code : " + str);
        }
        if (!ac.e(new File(str2), str3)) {
            return C0398a.pr("sign failed.");
        }
        if (!d.unzipFile(str2, g(pq, i).getPath())) {
            return C0398a.pr("unzip bundle failed.");
        }
        if (DEBUG) {
            String md5 = e.toMd5(new File(str2), false);
            if (!TextUtils.isEmpty(md5)) {
                h.asV().putString(com.baidu.swan.apps.swancore.a.hh(i), md5);
            }
        }
        if (ProcessUtils.isMainProcess()) {
            com.baidu.swan.apps.swancore.b.b(hF(i), o(hD(i), pq));
        }
        f(pq, i);
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate end. version = " + pq);
        }
        return C0398a.atj();
    }

    private static ArrayList<Long> o(long j, long j2) {
        SwanCoreVersion acM;
        ArrayList<Long> arrayList = new ArrayList<>();
        if (j != 0) {
            arrayList.add(Long.valueOf(j));
        }
        arrayList.add(Long.valueOf(j2));
        for (c cVar : com.baidu.swan.apps.process.messaging.service.e.aov().aox()) {
            SwanAppCores aol = cVar.aol();
            if (cVar.aom() && aol != null && (acM = aol.acM()) != null && !arrayList.contains(Long.valueOf(acM.swanCoreVersion))) {
                arrayList.add(Long.valueOf(acM.swanCoreVersion));
            }
        }
        arrayList.addAll(com.baidu.swan.mini.a.aGp());
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray()));
        }
        return arrayList;
    }

    public static SwanCoreVersion j(int i, long j) {
        SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
        swanCoreVersion.swanCorePath = g(j, i).getPath();
        swanCoreVersion.swanCoreType = 1;
        swanCoreVersion.swanCoreVersion = j;
        return swanCoreVersion;
    }

    public static long hD(int i) {
        return h.asV().getLong(hE(i), 0L);
    }

    private static String hE(int i) {
        return i == 1 ? "aigames_cur_remote_ver_key" : "aiapps_cur_remote_ver_key";
    }

    private static void f(final long j, final int i) {
        h.asV().putLong(hE(i), j);
        n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.swancore.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.swancore.a.asW().c(j, i);
                } catch (Exception e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }, "cacheSwanCoreInfo");
    }

    private static File hF(int i) {
        return new File(com.baidu.swan.apps.swancore.b.hp(i), "remote");
    }

    public static File g(long j, int i) {
        return new File(hF(i), String.valueOf(j));
    }

    /* renamed from: com.baidu.swan.apps.swancore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0398a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0398a atj() {
            return W(0, "");
        }

        public static C0398a pr(String str) {
            return W(1, str);
        }

        public static C0398a W(int i, String str) {
            C0398a c0398a = new C0398a();
            c0398a.statusCode = i;
            c0398a.message = str;
            return c0398a;
        }

        public String toString() {
            return "RemoteCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
