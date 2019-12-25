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
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static C0288a c(String str, String str2, String str3, int i) {
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate start.");
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long lX = com.baidu.swan.apps.swancore.b.lX(str);
        if (lX == 0) {
            return C0288a.lY("invalid version code : " + str);
        }
        if (!ab.d(new File(str2), str3)) {
            return C0288a.lY("sign failed.");
        }
        if (!c.unzipFile(str2, g(lX, i).getPath())) {
            return C0288a.lY("unzip bundle failed.");
        }
        if (DEBUG) {
            String md5 = d.toMd5(new File(str2), false);
            if (!TextUtils.isEmpty(md5)) {
                h.acE().putString(com.baidu.swan.apps.swancore.a.gb(i), md5);
            }
        }
        com.baidu.swan.apps.swancore.b.b(gA(i), l(gy(i), lX));
        f(lX, i);
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate end. version = " + lX);
        }
        return C0288a.acR();
    }

    private static ArrayList<Long> l(long j, long j2) {
        SwanCoreVersion Oe;
        ArrayList<Long> arrayList = new ArrayList<>();
        if (j != 0) {
            arrayList.add(Long.valueOf(j));
        }
        arrayList.add(Long.valueOf(j2));
        for (com.baidu.swan.apps.process.messaging.service.c cVar : e.YH().YJ()) {
            SwanAppCores Yx = cVar.Yx();
            if (cVar.Yy() && Yx != null && (Oe = Yx.Oe()) != null && !arrayList.contains(Long.valueOf(Oe.swanCoreVersion))) {
                arrayList.add(Long.valueOf(Oe.swanCoreVersion));
            }
        }
        arrayList.addAll(com.baidu.swan.mini.a.aqv());
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

    public static long gy(int i) {
        return h.acE().getLong(gz(i), 0L);
    }

    private static String gz(int i) {
        return i == 1 ? "aigames_cur_remote_ver_key" : "aiapps_cur_remote_ver_key";
    }

    private static void f(final long j, final int i) {
        h.acE().putLong(gz(i), j);
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.swancore.e.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.swancore.a.acF().c(j, i);
                } catch (Exception e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }, "cacheSwanCoreInfo");
    }

    private static File gA(int i) {
        return new File(com.baidu.swan.apps.swancore.b.gj(i), "remote");
    }

    public static File g(long j, int i) {
        return new File(gA(i), String.valueOf(j));
    }

    /* renamed from: com.baidu.swan.apps.swancore.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0288a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0288a acR() {
            return x(0, "");
        }

        public static C0288a lY(String str) {
            return x(1, str);
        }

        public static C0288a x(int i, String str) {
            C0288a c0288a = new C0288a();
            c0288a.statusCode = i;
            c0288a.message = str;
            return c0288a;
        }

        public String toString() {
            return "RemoteCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
