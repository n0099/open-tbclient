package com.baidu.swan.apps.swancore.e;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.ab;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.messaging.service.e;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.d.c;
import com.baidu.swan.d.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static C0290a c(String str, String str2, String str3, int i) {
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate start.");
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long ma = com.baidu.swan.apps.swancore.b.ma(str);
        if (ma == 0) {
            return C0290a.mb("invalid version code : " + str);
        }
        if (!ab.d(new File(str2), str3)) {
            return C0290a.mb("sign failed.");
        }
        if (!c.unzipFile(str2, g(ma, i).getPath())) {
            return C0290a.mb("unzip bundle failed.");
        }
        if (DEBUG) {
            String md5 = d.toMd5(new File(str2), false);
            if (!TextUtils.isEmpty(md5)) {
                h.adb().putString(com.baidu.swan.apps.swancore.a.gc(i), md5);
            }
        }
        com.baidu.swan.apps.swancore.b.b(gB(i), l(gz(i), ma));
        f(ma, i);
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate end. version = " + ma);
        }
        return C0290a.ado();
    }

    private static ArrayList<Long> l(long j, long j2) {
        SwanCoreVersion OA;
        ArrayList<Long> arrayList = new ArrayList<>();
        if (j != 0) {
            arrayList.add(Long.valueOf(j));
        }
        arrayList.add(Long.valueOf(j2));
        for (com.baidu.swan.apps.process.messaging.service.c cVar : e.Ze().Zg()) {
            SwanAppCores YU = cVar.YU();
            if (cVar.YV() && YU != null && (OA = YU.OA()) != null && !arrayList.contains(Long.valueOf(OA.swanCoreVersion))) {
                arrayList.add(Long.valueOf(OA.swanCoreVersion));
            }
        }
        arrayList.addAll(com.baidu.swan.mini.a.aqO());
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

    public static long gz(int i) {
        return h.adb().getLong(gA(i), 0L);
    }

    private static String gA(int i) {
        return i == 1 ? "aigames_cur_remote_ver_key" : "aiapps_cur_remote_ver_key";
    }

    private static void f(final long j, final int i) {
        h.adb().putLong(gA(i), j);
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.swancore.e.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.swancore.a.adc().c(j, i);
                } catch (Exception e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }, "cacheSwanCoreInfo");
    }

    private static File gB(int i) {
        return new File(com.baidu.swan.apps.swancore.b.gk(i), "remote");
    }

    public static File g(long j, int i) {
        return new File(gB(i), String.valueOf(j));
    }

    /* renamed from: com.baidu.swan.apps.swancore.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0290a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0290a ado() {
            return A(0, "");
        }

        public static C0290a mb(String str) {
            return A(1, str);
        }

        public static C0290a A(int i, String str) {
            C0290a c0290a = new C0290a();
            c0290a.statusCode = i;
            c0290a.message = str;
            return c0290a;
        }

        public String toString() {
            return "RemoteCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
