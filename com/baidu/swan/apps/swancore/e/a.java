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
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static C0330a c(String str, String str2, String str3, int i) {
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate start.");
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long nB = com.baidu.swan.apps.swancore.b.nB(str);
        if (nB == 0) {
            return C0330a.nC("invalid version code : " + str);
        }
        if (!ab.e(new File(str2), str3)) {
            return C0330a.nC("sign failed.");
        }
        if (!c.unzipFile(str2, g(nB, i).getPath())) {
            return C0330a.nC("unzip bundle failed.");
        }
        if (DEBUG) {
            String md5 = d.toMd5(new File(str2), false);
            if (!TextUtils.isEmpty(md5)) {
                h.anz().putString(com.baidu.swan.apps.swancore.a.gA(i), md5);
            }
        }
        com.baidu.swan.apps.swancore.b.b(gZ(i), m(gX(i), nB));
        f(nB, i);
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate end. version = " + nB);
        }
        return C0330a.anM();
    }

    private static ArrayList<Long> m(long j, long j2) {
        SwanCoreVersion YI;
        ArrayList<Long> arrayList = new ArrayList<>();
        if (j != 0) {
            arrayList.add(Long.valueOf(j));
        }
        arrayList.add(Long.valueOf(j2));
        for (com.baidu.swan.apps.process.messaging.service.c cVar : e.ajC().ajE()) {
            SwanAppCores ajs = cVar.ajs();
            if (cVar.ajt() && ajs != null && (YI = ajs.YI()) != null && !arrayList.contains(Long.valueOf(YI.swanCoreVersion))) {
                arrayList.add(Long.valueOf(YI.swanCoreVersion));
            }
        }
        arrayList.addAll(com.baidu.swan.mini.a.aBr());
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

    public static long gX(int i) {
        return h.anz().getLong(gY(i), 0L);
    }

    private static String gY(int i) {
        return i == 1 ? "aigames_cur_remote_ver_key" : "aiapps_cur_remote_ver_key";
    }

    private static void f(final long j, final int i) {
        h.anz().putLong(gY(i), j);
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.swancore.e.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.swancore.a.anA().c(j, i);
                } catch (Exception e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }, "cacheSwanCoreInfo");
    }

    private static File gZ(int i) {
        return new File(com.baidu.swan.apps.swancore.b.gI(i), "remote");
    }

    public static File g(long j, int i) {
        return new File(gZ(i), String.valueOf(j));
    }

    /* renamed from: com.baidu.swan.apps.swancore.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0330a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0330a anM() {
            return T(0, "");
        }

        public static C0330a nC(String str) {
            return T(1, str);
        }

        public static C0330a T(int i, String str) {
            C0330a c0330a = new C0330a();
            c0330a.statusCode = i;
            c0330a.message = str;
            return c0330a;
        }

        public String toString() {
            return "RemoteCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
