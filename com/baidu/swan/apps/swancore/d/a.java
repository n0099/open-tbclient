package com.baidu.swan.apps.swancore.d;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.ao.ae;
import com.baidu.swan.apps.ao.p;
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

    public static C0477a h(String str, String str2, String str3, int i) {
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate start.");
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long tD = com.baidu.swan.apps.swancore.b.tD(str);
        if (tD == 0) {
            return C0477a.tE("invalid version code : " + str);
        }
        if (!ae.e(new File(str2), str3)) {
            return C0477a.tE("sign failed.");
        }
        if (!d.unzipFile(str2, q(tD, i).getPath())) {
            return C0477a.tE("unzip bundle failed.");
        }
        if (DEBUG) {
            String e = e.e(new File(str2), false);
            if (!TextUtils.isEmpty(e)) {
                h.aMk().putString(com.baidu.swan.apps.swancore.a.jx(i), e);
            }
        }
        if (ProcessUtils.isMainProcess()) {
            com.baidu.swan.apps.swancore.b.b(jX(i), t(jU(i), tD));
        }
        p(tD, i);
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate end. version = " + tD);
        }
        return C0477a.aMy();
    }

    private static ArrayList<Long> t(long j, long j2) {
        SwanCoreVersion asD;
        ArrayList<Long> arrayList = new ArrayList<>();
        if (j != 0) {
            arrayList.add(Long.valueOf(j));
        }
        arrayList.add(Long.valueOf(j2));
        for (c cVar : com.baidu.swan.apps.process.messaging.service.e.aGq().aGs()) {
            SwanAppCores aGc = cVar.aGc();
            if (cVar.aGd() && aGc != null && (asD = aGc.asD()) != null && !arrayList.contains(Long.valueOf(asD.swanCoreVersion))) {
                arrayList.add(Long.valueOf(asD.swanCoreVersion));
            }
        }
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray()));
        }
        return arrayList;
    }

    public static SwanCoreVersion k(int i, long j) {
        SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
        swanCoreVersion.swanCorePath = q(j, i).getPath();
        swanCoreVersion.swanCoreType = 1;
        swanCoreVersion.swanCoreVersion = j;
        return swanCoreVersion;
    }

    public static long jU(int i) {
        return h.aMk().getLong(jW(i), 0L);
    }

    public static void jV(int i) {
        p(0L, i);
    }

    private static String jW(int i) {
        return i == 1 ? "aigames_cur_remote_ver_key" : "aiapps_cur_remote_ver_key";
    }

    private static void p(final long j, final int i) {
        h.aMk().putLong(jW(i), j);
        p.a(new Runnable() { // from class: com.baidu.swan.apps.swancore.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.swancore.a.aMl().m(j, i);
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

    private static File q(long j, int i) {
        return new File(jX(i), String.valueOf(j));
    }

    /* renamed from: com.baidu.swan.apps.swancore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0477a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0477a aMy() {
            return au(0, "");
        }

        public static C0477a tE(String str) {
            return au(1, str);
        }

        public static C0477a au(int i, String str) {
            C0477a c0477a = new C0477a();
            c0477a.statusCode = i;
            c0477a.message = str;
            return c0477a;
        }

        @NonNull
        public String toString() {
            return "RemoteCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
