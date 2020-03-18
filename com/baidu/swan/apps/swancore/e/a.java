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

    public static C0300a c(String str, String str2, String str3, int i) {
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate start.");
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long mo = com.baidu.swan.apps.swancore.b.mo(str);
        if (mo == 0) {
            return C0300a.mp("invalid version code : " + str);
        }
        if (!ab.d(new File(str2), str3)) {
            return C0300a.mp("sign failed.");
        }
        if (!c.unzipFile(str2, g(mo, i).getPath())) {
            return C0300a.mp("unzip bundle failed.");
        }
        if (DEBUG) {
            String md5 = d.toMd5(new File(str2), false);
            if (!TextUtils.isEmpty(md5)) {
                h.afu().putString(com.baidu.swan.apps.swancore.a.gt(i), md5);
            }
        }
        com.baidu.swan.apps.swancore.b.b(gS(i), l(gQ(i), mo));
        f(mo, i);
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate end. version = " + mo);
        }
        return C0300a.afH();
    }

    private static ArrayList<Long> l(long j, long j2) {
        SwanCoreVersion QT;
        ArrayList<Long> arrayList = new ArrayList<>();
        if (j != 0) {
            arrayList.add(Long.valueOf(j));
        }
        arrayList.add(Long.valueOf(j2));
        for (com.baidu.swan.apps.process.messaging.service.c cVar : e.abx().abz()) {
            SwanAppCores abn = cVar.abn();
            if (cVar.abo() && abn != null && (QT = abn.QT()) != null && !arrayList.contains(Long.valueOf(QT.swanCoreVersion))) {
                arrayList.add(Long.valueOf(QT.swanCoreVersion));
            }
        }
        arrayList.addAll(com.baidu.swan.mini.a.ath());
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

    public static long gQ(int i) {
        return h.afu().getLong(gR(i), 0L);
    }

    private static String gR(int i) {
        return i == 1 ? "aigames_cur_remote_ver_key" : "aiapps_cur_remote_ver_key";
    }

    private static void f(final long j, final int i) {
        h.afu().putLong(gR(i), j);
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.swancore.e.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.swancore.a.afv().c(j, i);
                } catch (Exception e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }, "cacheSwanCoreInfo");
    }

    private static File gS(int i) {
        return new File(com.baidu.swan.apps.swancore.b.gB(i), "remote");
    }

    public static File g(long j, int i) {
        return new File(gS(i), String.valueOf(j));
    }

    /* renamed from: com.baidu.swan.apps.swancore.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0300a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0300a afH() {
            return C(0, "");
        }

        public static C0300a mp(String str) {
            return C(1, str);
        }

        public static C0300a C(int i, String str) {
            C0300a c0300a = new C0300a();
            c0300a.statusCode = i;
            c0300a.message = str;
            return c0300a;
        }

        public String toString() {
            return "RemoteCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
