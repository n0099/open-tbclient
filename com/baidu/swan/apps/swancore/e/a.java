package com.baidu.swan.apps.swancore.e;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.an.u;
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

    public static C0177a c(String str, String str2, String str3, int i) {
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate start.");
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long hh = com.baidu.swan.apps.swancore.b.hh(str);
        if (hh == 0) {
            return C0177a.hj("invalid version code : " + str);
        }
        if (!u.c(new File(str2), str3)) {
            return C0177a.hj("sign failed.");
        }
        if (!com.baidu.swan.c.b.bl(str2, h(hh, i).getPath())) {
            return C0177a.hj("unzip bundle failed.");
        }
        if (DEBUG) {
            String c = com.baidu.swan.c.c.c(new File(str2), false);
            if (!TextUtils.isEmpty(c)) {
                f.KJ().putString(com.baidu.swan.apps.swancore.a.dC(i), c);
            }
        }
        com.baidu.swan.apps.swancore.b.c(eb(i), d(dZ(i), hh));
        g(hh, i);
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate end. version = " + hh);
        }
        return C0177a.KV();
    }

    private static ArrayList<Long> d(long j, long j2) {
        SwanCoreVersion Ar;
        ArrayList<Long> arrayList = new ArrayList<>();
        if (j != 0) {
            arrayList.add(Long.valueOf(j));
        }
        arrayList.add(Long.valueOf(j2));
        if (SwanAppMessengerService.getServiceObject() == null) {
            return arrayList;
        }
        for (a.b bVar : com.baidu.swan.apps.process.messaging.service.a.Gu().Gv()) {
            if (bVar.aFh && bVar.aFe != null && (Ar = bVar.aFe.Ar()) != null && !arrayList.contains(Long.valueOf(Ar.aTg))) {
                arrayList.add(Long.valueOf(Ar.aTg));
            }
        }
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray()));
        }
        return arrayList;
    }

    public static long dZ(int i) {
        return f.KJ().getLong(ea(i), 0L);
    }

    private static String ea(int i) {
        return i == 1 ? "aigames_cur_remote_ver_key" : "aiapps_cur_remote_ver_key";
    }

    private static void g(final long j, final int i) {
        f.KJ().putLong(ea(i), j);
        j.a(new Runnable() { // from class: com.baidu.swan.apps.swancore.e.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.swancore.a.KK().d(j, i);
                } catch (Exception e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }, "cacheSwanCoreInfo");
    }

    private static File eb(int i) {
        return new File(com.baidu.swan.apps.swancore.b.dK(i), "remote");
    }

    public static File h(long j, int i) {
        return new File(eb(i), String.valueOf(j));
    }

    /* renamed from: com.baidu.swan.apps.swancore.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0177a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0177a KV() {
            return p(0, "");
        }

        public static C0177a hj(String str) {
            return p(1, str);
        }

        public static C0177a p(int i, String str) {
            C0177a c0177a = new C0177a();
            c0177a.statusCode = i;
            c0177a.message = str;
            return c0177a;
        }

        public String toString() {
            return "RemoteCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
