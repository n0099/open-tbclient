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
        long hg = com.baidu.swan.apps.swancore.b.hg(str);
        if (hg == 0) {
            return C0177a.hi("invalid version code : " + str);
        }
        if (!u.c(new File(str2), str3)) {
            return C0177a.hi("sign failed.");
        }
        if (!com.baidu.swan.c.b.bl(str2, h(hg, i).getPath())) {
            return C0177a.hi("unzip bundle failed.");
        }
        if (DEBUG) {
            String c = com.baidu.swan.c.c.c(new File(str2), false);
            if (!TextUtils.isEmpty(c)) {
                f.KL().putString(com.baidu.swan.apps.swancore.a.dD(i), c);
            }
        }
        com.baidu.swan.apps.swancore.b.c(ec(i), d(ea(i), hg));
        g(hg, i);
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate end. version = " + hg);
        }
        return C0177a.KX();
    }

    private static ArrayList<Long> d(long j, long j2) {
        SwanCoreVersion As;
        ArrayList<Long> arrayList = new ArrayList<>();
        if (j != 0) {
            arrayList.add(Long.valueOf(j));
        }
        arrayList.add(Long.valueOf(j2));
        if (SwanAppMessengerService.getServiceObject() == null) {
            return arrayList;
        }
        for (a.b bVar : com.baidu.swan.apps.process.messaging.service.a.Gw().Gx()) {
            if (bVar.aFe && bVar.aFb != null && (As = bVar.aFb.As()) != null && !arrayList.contains(Long.valueOf(As.aTd))) {
                arrayList.add(Long.valueOf(As.aTd));
            }
        }
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray()));
        }
        return arrayList;
    }

    public static long ea(int i) {
        return f.KL().getLong(eb(i), 0L);
    }

    private static String eb(int i) {
        return i == 1 ? "aigames_cur_remote_ver_key" : "aiapps_cur_remote_ver_key";
    }

    private static void g(final long j, final int i) {
        f.KL().putLong(eb(i), j);
        j.a(new Runnable() { // from class: com.baidu.swan.apps.swancore.e.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.swancore.a.KM().d(j, i);
                } catch (Exception e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }, "cacheSwanCoreInfo");
    }

    private static File ec(int i) {
        return new File(com.baidu.swan.apps.swancore.b.dL(i), "remote");
    }

    public static File h(long j, int i) {
        return new File(ec(i), String.valueOf(j));
    }

    /* renamed from: com.baidu.swan.apps.swancore.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0177a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0177a KX() {
            return p(0, "");
        }

        public static C0177a hi(String str) {
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
