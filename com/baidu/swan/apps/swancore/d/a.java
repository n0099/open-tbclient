package com.baidu.swan.apps.swancore.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.aq.ae;
import com.baidu.swan.apps.aq.p;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.messaging.service.c;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.d.d;
import com.baidu.swan.d.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static C0404a c(String str, String str2, String str3, int i) {
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate start.");
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long qb = com.baidu.swan.apps.swancore.b.qb(str);
        if (qb == 0) {
            return C0404a.qc("invalid version code : " + str);
        }
        if (!ae.e(new File(str2), str3)) {
            return C0404a.qc("sign failed.");
        }
        if (!d.unzipFile(str2, g(qb, i).getPath())) {
            return C0404a.qc("unzip bundle failed.");
        }
        if (DEBUG) {
            String md5 = e.toMd5(new File(str2), false);
            if (!TextUtils.isEmpty(md5)) {
                h.auW().putString(com.baidu.swan.apps.swancore.a.hq(i), md5);
            }
        }
        if (ProcessUtils.isMainProcess()) {
            com.baidu.swan.apps.swancore.b.b(hO(i), p(hM(i), qb));
        }
        f(qb, i);
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate end. version = " + qb);
        }
        return C0404a.avk();
    }

    private static ArrayList<Long> p(long j, long j2) {
        SwanCoreVersion adQ;
        ArrayList<Long> arrayList = new ArrayList<>();
        if (j != 0) {
            arrayList.add(Long.valueOf(j));
        }
        arrayList.add(Long.valueOf(j2));
        for (c cVar : com.baidu.swan.apps.process.messaging.service.e.aqf().aqh()) {
            SwanAppCores apV = cVar.apV();
            if (cVar.apW() && apV != null && (adQ = apV.adQ()) != null && !arrayList.contains(Long.valueOf(adQ.swanCoreVersion))) {
                arrayList.add(Long.valueOf(adQ.swanCoreVersion));
            }
        }
        arrayList.addAll(com.baidu.swan.mini.a.aKg());
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

    public static long hM(int i) {
        return h.auW().getLong(hN(i), 0L);
    }

    private static String hN(int i) {
        return i == 1 ? "aigames_cur_remote_ver_key" : "aiapps_cur_remote_ver_key";
    }

    private static void f(final long j, final int i) {
        h.auW().putLong(hN(i), j);
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.swancore.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.swancore.a.auX().c(j, i);
                } catch (Exception e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }, "cacheSwanCoreInfo");
    }

    private static File hO(int i) {
        return new File(com.baidu.swan.apps.swancore.b.hy(i), "remote");
    }

    public static File g(long j, int i) {
        return new File(hO(i), String.valueOf(j));
    }

    /* renamed from: com.baidu.swan.apps.swancore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0404a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0404a avk() {
            return W(0, "");
        }

        public static C0404a qc(String str) {
            return W(1, str);
        }

        public static C0404a W(int i, String str) {
            C0404a c0404a = new C0404a();
            c0404a.statusCode = i;
            c0404a.message = str;
            return c0404a;
        }

        public String toString() {
            return "RemoteCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
