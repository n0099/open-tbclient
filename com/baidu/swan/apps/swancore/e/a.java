package com.baidu.swan.apps.swancore.e;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.an.w;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.process.messaging.service.a;
import com.baidu.swan.apps.storage.b.f;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static C0186a c(String str, String str2, String str3, int i) {
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate start.");
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long hO = com.baidu.swan.apps.swancore.b.hO(str);
        if (hO == 0) {
            return C0186a.hQ("invalid version code : " + str);
        }
        if (!w.b(new File(str2), str3)) {
            return C0186a.hQ("sign failed.");
        }
        if (!com.baidu.swan.c.a.bs(str2, f(hO, i).getPath())) {
            return C0186a.hQ("unzip bundle failed.");
        }
        if (DEBUG) {
            String b = com.baidu.swan.c.b.b(new File(str2), false);
            if (!TextUtils.isEmpty(b)) {
                f.NX().putString(com.baidu.swan.apps.swancore.a.dQ(i), b);
            }
        }
        com.baidu.swan.apps.swancore.b.c(ep(i), d(en(i), hO));
        e(hO, i);
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate end. version = " + hO);
        }
        return C0186a.Oj();
    }

    private static ArrayList<Long> d(long j, long j2) {
        SwanCoreVersion Ci;
        ArrayList<Long> arrayList = new ArrayList<>();
        if (j != 0) {
            arrayList.add(Long.valueOf(j));
        }
        arrayList.add(Long.valueOf(j2));
        if (SwanAppMessengerService.getServiceObject() == null) {
            return arrayList;
        }
        for (a.b bVar : com.baidu.swan.apps.process.messaging.service.a.Jx().Jy()) {
            if (bVar.aHJ && bVar.aHG != null && (Ci = bVar.aHG.Ci()) != null && !arrayList.contains(Long.valueOf(Ci.aWG))) {
                arrayList.add(Long.valueOf(Ci.aWG));
            }
        }
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray()));
        }
        return arrayList;
    }

    public static long en(int i) {
        return f.NX().getLong(eo(i), 0L);
    }

    private static String eo(int i) {
        return i == 1 ? "aigames_cur_remote_ver_key" : "aiapps_cur_remote_ver_key";
    }

    private static void e(final long j, final int i) {
        f.NX().putLong(eo(i), j);
        j.a(new Runnable() { // from class: com.baidu.swan.apps.swancore.e.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.swancore.a.NY().b(j, i);
                } catch (Exception e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }, "cacheSwanCoreInfo");
    }

    private static File ep(int i) {
        return new File(com.baidu.swan.apps.swancore.b.dY(i), "remote");
    }

    public static File f(long j, int i) {
        return new File(ep(i), String.valueOf(j));
    }

    /* renamed from: com.baidu.swan.apps.swancore.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0186a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0186a Oj() {
            return q(0, "");
        }

        public static C0186a hQ(String str) {
            return q(1, str);
        }

        public static C0186a q(int i, String str) {
            C0186a c0186a = new C0186a();
            c0186a.statusCode = i;
            c0186a.message = str;
            return c0186a;
        }

        public String toString() {
            return "RemoteCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
