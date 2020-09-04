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
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static C0450a c(String str, String str2, String str3, int i) {
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate start.");
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long sc = com.baidu.swan.apps.swancore.b.sc(str);
        if (sc == 0) {
            return C0450a.sd("invalid version code : " + str);
        }
        if (!ae.e(new File(str2), str3)) {
            return C0450a.sd("sign failed.");
        }
        if (!d.unzipFile(str2, g(sc, i).getPath())) {
            return C0450a.sd("unzip bundle failed.");
        }
        if (DEBUG) {
            String md5 = e.toMd5(new File(str2), false);
            if (!TextUtils.isEmpty(md5)) {
                h.aDf().putString(com.baidu.swan.apps.swancore.a.jx(i), md5);
            }
        }
        if (ProcessUtils.isMainProcess()) {
            com.baidu.swan.apps.swancore.b.b(jX(i), p(jU(i), sc));
        }
        f(sc, i);
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate end. version = " + sc);
        }
        return C0450a.aDt();
    }

    private static ArrayList<Long> p(long j, long j2) {
        SwanCoreVersion akn;
        ArrayList<Long> arrayList = new ArrayList<>();
        if (j != 0) {
            arrayList.add(Long.valueOf(j));
        }
        arrayList.add(Long.valueOf(j2));
        for (c cVar : com.baidu.swan.apps.process.messaging.service.e.ayg().ayi()) {
            SwanAppCores axS = cVar.axS();
            if (cVar.axT() && axS != null && (akn = axS.akn()) != null && !arrayList.contains(Long.valueOf(akn.swanCoreVersion))) {
                arrayList.add(Long.valueOf(akn.swanCoreVersion));
            }
        }
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

    public static long jU(int i) {
        return h.aDf().getLong(jW(i), 0L);
    }

    public static void jV(int i) {
        f(0L, i);
    }

    private static String jW(int i) {
        return i == 1 ? "aigames_cur_remote_ver_key" : "aiapps_cur_remote_ver_key";
    }

    private static void f(final long j, final int i) {
        h.aDf().putLong(jW(i), j);
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.swancore.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.swancore.a.aDg().c(j, i);
                } catch (Exception e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }, "cacheSwanCoreInfo");
    }

    private static File jX(int i) {
        return new File(com.baidu.swan.apps.swancore.b.jF(i), "remote");
    }

    private static File g(long j, int i) {
        return new File(jX(i), String.valueOf(j));
    }

    /* renamed from: com.baidu.swan.apps.swancore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0450a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0450a aDt() {
            return V(0, "");
        }

        public static C0450a sd(String str) {
            return V(1, str);
        }

        public static C0450a V(int i, String str) {
            C0450a c0450a = new C0450a();
            c0450a.statusCode = i;
            c0450a.message = str;
            return c0450a;
        }

        @NonNull
        public String toString() {
            return "RemoteCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
