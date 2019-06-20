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

    public static C0184a c(String str, String str2, String str3, int i) {
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate start.");
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long hH = com.baidu.swan.apps.swancore.b.hH(str);
        if (hH == 0) {
            return C0184a.hJ("invalid version code : " + str);
        }
        if (!w.b(new File(str2), str3)) {
            return C0184a.hJ("sign failed.");
        }
        if (!com.baidu.swan.c.a.bs(str2, f(hH, i).getPath())) {
            return C0184a.hJ("unzip bundle failed.");
        }
        if (DEBUG) {
            String b = com.baidu.swan.c.b.b(new File(str2), false);
            if (!TextUtils.isEmpty(b)) {
                f.Ni().putString(com.baidu.swan.apps.swancore.a.dN(i), b);
            }
        }
        com.baidu.swan.apps.swancore.b.c(em(i), d(ek(i), hH));
        e(hH, i);
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate end. version = " + hH);
        }
        return C0184a.Nu();
    }

    private static ArrayList<Long> d(long j, long j2) {
        SwanCoreVersion BA;
        ArrayList<Long> arrayList = new ArrayList<>();
        if (j != 0) {
            arrayList.add(Long.valueOf(j));
        }
        arrayList.add(Long.valueOf(j2));
        if (SwanAppMessengerService.getServiceObject() == null) {
            return arrayList;
        }
        for (a.b bVar : com.baidu.swan.apps.process.messaging.service.a.IK().IL()) {
            if (bVar.aHb && bVar.aGY != null && (BA = bVar.aGY.BA()) != null && !arrayList.contains(Long.valueOf(BA.aVW))) {
                arrayList.add(Long.valueOf(BA.aVW));
            }
        }
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray()));
        }
        return arrayList;
    }

    public static long ek(int i) {
        return f.Ni().getLong(el(i), 0L);
    }

    private static String el(int i) {
        return i == 1 ? "aigames_cur_remote_ver_key" : "aiapps_cur_remote_ver_key";
    }

    private static void e(final long j, final int i) {
        f.Ni().putLong(el(i), j);
        j.a(new Runnable() { // from class: com.baidu.swan.apps.swancore.e.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.swancore.a.Nj().b(j, i);
                } catch (Exception e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }, "cacheSwanCoreInfo");
    }

    private static File em(int i) {
        return new File(com.baidu.swan.apps.swancore.b.dV(i), "remote");
    }

    public static File f(long j, int i) {
        return new File(em(i), String.valueOf(j));
    }

    /* renamed from: com.baidu.swan.apps.swancore.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0184a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0184a Nu() {
            return q(0, "");
        }

        public static C0184a hJ(String str) {
            return q(1, str);
        }

        public static C0184a q(int i, String str) {
            C0184a c0184a = new C0184a();
            c0184a.statusCode = i;
            c0184a.message = str;
            return c0184a;
        }

        public String toString() {
            return "RemoteCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
