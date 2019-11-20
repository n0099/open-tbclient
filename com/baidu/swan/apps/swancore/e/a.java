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

    public static C0227a d(String str, String str2, String str3, int i) {
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate start.");
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long iu = com.baidu.swan.apps.swancore.b.iu(str);
        if (iu == 0) {
            return C0227a.iw("invalid version code : " + str);
        }
        if (!w.b(new File(str2), str3)) {
            return C0227a.iw("sign failed.");
        }
        if (!com.baidu.swan.c.a.bz(str2, g(iu, i).getPath())) {
            return C0227a.iw("unzip bundle failed.");
        }
        if (DEBUG) {
            String b = com.baidu.swan.c.b.b(new File(str2), false);
            if (!TextUtils.isEmpty(b)) {
                f.ST().putString(com.baidu.swan.apps.swancore.a.eM(i), b);
            }
        }
        com.baidu.swan.apps.swancore.b.c(fl(i), j(fj(i), iu));
        f(iu, i);
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate end. version = " + iu);
        }
        return C0227a.Tf();
    }

    private static ArrayList<Long> j(long j, long j2) {
        SwanCoreVersion Hh;
        ArrayList<Long> arrayList = new ArrayList<>();
        if (j != 0) {
            arrayList.add(Long.valueOf(j));
        }
        arrayList.add(Long.valueOf(j2));
        if (SwanAppMessengerService.getServiceObject() == null) {
            return arrayList;
        }
        for (a.b bVar : com.baidu.swan.apps.process.messaging.service.a.Ow().Ox()) {
            if (bVar.bbd && bVar.bba != null && (Hh = bVar.bba.Hh()) != null && !arrayList.contains(Long.valueOf(Hh.bpQ))) {
                arrayList.add(Long.valueOf(Hh.bpQ));
            }
        }
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray()));
        }
        return arrayList;
    }

    public static long fj(int i) {
        return f.ST().getLong(fk(i), 0L);
    }

    private static String fk(int i) {
        return i == 1 ? "aigames_cur_remote_ver_key" : "aiapps_cur_remote_ver_key";
    }

    private static void f(final long j, final int i) {
        f.ST().putLong(fk(i), j);
        j.a(new Runnable() { // from class: com.baidu.swan.apps.swancore.e.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.swancore.a.SU().c(j, i);
                } catch (Exception e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }, "cacheSwanCoreInfo");
    }

    private static File fl(int i) {
        return new File(com.baidu.swan.apps.swancore.b.eU(i), "remote");
    }

    public static File g(long j, int i) {
        return new File(fl(i), String.valueOf(j));
    }

    /* renamed from: com.baidu.swan.apps.swancore.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0227a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0227a Tf() {
            return u(0, "");
        }

        public static C0227a iw(String str) {
            return u(1, str);
        }

        public static C0227a u(int i, String str) {
            C0227a c0227a = new C0227a();
            c0227a.statusCode = i;
            c0227a.message = str;
            return c0227a;
        }

        public String toString() {
            return "RemoteCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
