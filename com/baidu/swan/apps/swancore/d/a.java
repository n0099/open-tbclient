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

    public static C0392a c(String str, String str2, String str3, int i) {
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate start.");
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long pi = com.baidu.swan.apps.swancore.b.pi(str);
        if (pi == 0) {
            return C0392a.pj("invalid version code : " + str);
        }
        if (!ac.e(new File(str2), str3)) {
            return C0392a.pj("sign failed.");
        }
        if (!d.unzipFile(str2, g(pi, i).getPath())) {
            return C0392a.pj("unzip bundle failed.");
        }
        if (DEBUG) {
            String md5 = e.toMd5(new File(str2), false);
            if (!TextUtils.isEmpty(md5)) {
                h.arO().putString(com.baidu.swan.apps.swancore.a.gU(i), md5);
            }
        }
        if (ProcessUtils.isMainProcess()) {
            com.baidu.swan.apps.swancore.b.b(hs(i), o(hq(i), pi));
        }
        f(pi, i);
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate end. version = " + pi);
        }
        return C0392a.asc();
    }

    private static ArrayList<Long> o(long j, long j2) {
        SwanCoreVersion abG;
        ArrayList<Long> arrayList = new ArrayList<>();
        if (j != 0) {
            arrayList.add(Long.valueOf(j));
        }
        arrayList.add(Long.valueOf(j2));
        for (c cVar : com.baidu.swan.apps.process.messaging.service.e.anp().anr()) {
            SwanAppCores anf = cVar.anf();
            if (cVar.ang() && anf != null && (abG = anf.abG()) != null && !arrayList.contains(Long.valueOf(abG.swanCoreVersion))) {
                arrayList.add(Long.valueOf(abG.swanCoreVersion));
            }
        }
        arrayList.addAll(com.baidu.swan.mini.a.aFj());
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray()));
        }
        return arrayList;
    }

    public static SwanCoreVersion i(int i, long j) {
        SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
        swanCoreVersion.swanCorePath = g(j, i).getPath();
        swanCoreVersion.swanCoreType = 1;
        swanCoreVersion.swanCoreVersion = j;
        return swanCoreVersion;
    }

    public static long hq(int i) {
        return h.arO().getLong(hr(i), 0L);
    }

    private static String hr(int i) {
        return i == 1 ? "aigames_cur_remote_ver_key" : "aiapps_cur_remote_ver_key";
    }

    private static void f(final long j, final int i) {
        h.arO().putLong(hr(i), j);
        n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.swancore.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.swancore.a.arP().c(j, i);
                } catch (Exception e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }, "cacheSwanCoreInfo");
    }

    private static File hs(int i) {
        return new File(com.baidu.swan.apps.swancore.b.hc(i), "remote");
    }

    public static File g(long j, int i) {
        return new File(hs(i), String.valueOf(j));
    }

    /* renamed from: com.baidu.swan.apps.swancore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0392a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0392a asc() {
            return U(0, "");
        }

        public static C0392a pj(String str) {
            return U(1, str);
        }

        public static C0392a U(int i, String str) {
            C0392a c0392a = new C0392a();
            c0392a.statusCode = i;
            c0392a.message = str;
            return c0392a;
        }

        public String toString() {
            return "RemoteCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
