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

    public static C0195a c(String str, String str2, String str3, int i) {
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate start.");
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long hQ = com.baidu.swan.apps.swancore.b.hQ(str);
        if (hQ == 0) {
            return C0195a.hS("invalid version code : " + str);
        }
        if (!w.b(new File(str2), str3)) {
            return C0195a.hS("sign failed.");
        }
        if (!com.baidu.swan.c.a.bs(str2, f(hQ, i).getPath())) {
            return C0195a.hS("unzip bundle failed.");
        }
        if (DEBUG) {
            String b = com.baidu.swan.c.b.b(new File(str2), false);
            if (!TextUtils.isEmpty(b)) {
                f.Ob().putString(com.baidu.swan.apps.swancore.a.dR(i), b);
            }
        }
        com.baidu.swan.apps.swancore.b.c(eq(i), d(eo(i), hQ));
        e(hQ, i);
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate end. version = " + hQ);
        }
        return C0195a.On();
    }

    private static ArrayList<Long> d(long j, long j2) {
        SwanCoreVersion Cm;
        ArrayList<Long> arrayList = new ArrayList<>();
        if (j != 0) {
            arrayList.add(Long.valueOf(j));
        }
        arrayList.add(Long.valueOf(j2));
        if (SwanAppMessengerService.getServiceObject() == null) {
            return arrayList;
        }
        for (a.b bVar : com.baidu.swan.apps.process.messaging.service.a.JB().JC()) {
            if (bVar.aIh && bVar.aIe != null && (Cm = bVar.aIe.Cm()) != null && !arrayList.contains(Long.valueOf(Cm.aXe))) {
                arrayList.add(Long.valueOf(Cm.aXe));
            }
        }
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray()));
        }
        return arrayList;
    }

    public static long eo(int i) {
        return f.Ob().getLong(ep(i), 0L);
    }

    private static String ep(int i) {
        return i == 1 ? "aigames_cur_remote_ver_key" : "aiapps_cur_remote_ver_key";
    }

    private static void e(final long j, final int i) {
        f.Ob().putLong(ep(i), j);
        j.a(new Runnable() { // from class: com.baidu.swan.apps.swancore.e.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.swancore.a.Oc().b(j, i);
                } catch (Exception e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }, "cacheSwanCoreInfo");
    }

    private static File eq(int i) {
        return new File(com.baidu.swan.apps.swancore.b.dZ(i), "remote");
    }

    public static File f(long j, int i) {
        return new File(eq(i), String.valueOf(j));
    }

    /* renamed from: com.baidu.swan.apps.swancore.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0195a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0195a On() {
            return q(0, "");
        }

        public static C0195a hS(String str) {
            return q(1, str);
        }

        public static C0195a q(int i, String str) {
            C0195a c0195a = new C0195a();
            c0195a.statusCode = i;
            c0195a.message = str;
            return c0195a;
        }

        public String toString() {
            return "RemoteCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
