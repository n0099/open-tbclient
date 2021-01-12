package com.baidu.swan.apps.swancore.d;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.ao.ae;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.messaging.service.c;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.c.d;
import com.baidu.swan.c.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static C0474a h(String str, String str2, String str3, int i) {
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate start.");
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long td = com.baidu.swan.apps.swancore.b.td(str);
        if (td == 0) {
            return C0474a.te("invalid version code : " + str);
        }
        if (!ae.f(new File(str2), str3)) {
            return C0474a.te("sign failed.");
        }
        if (!d.unzipFile(str2, q(td, i).getPath())) {
            return C0474a.te("unzip bundle failed.");
        }
        if (DEBUG) {
            String e = e.e(new File(str2), false);
            if (!TextUtils.isEmpty(e)) {
                h.aLO().putString(com.baidu.swan.apps.swancore.a.jt(i), e);
            }
        }
        if (ProcessUtils.isMainProcess()) {
            com.baidu.swan.apps.swancore.b.b(jT(i), p(jQ(i), td));
        }
        p(td, i);
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate end. version = " + td);
        }
        return C0474a.aMc();
    }

    private static ArrayList<Long> p(long j, long j2) {
        SwanCoreVersion asb;
        ArrayList<Long> arrayList = new ArrayList<>();
        if (j != 0) {
            arrayList.add(Long.valueOf(j));
        }
        arrayList.add(Long.valueOf(j2));
        for (c cVar : com.baidu.swan.apps.process.messaging.service.e.aFS().aFU()) {
            SwanAppCores aFE = cVar.aFE();
            if (cVar.aFF() && aFE != null && (asb = aFE.asb()) != null && !arrayList.contains(Long.valueOf(asb.swanCoreVersion))) {
                arrayList.add(Long.valueOf(asb.swanCoreVersion));
            }
        }
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray()));
        }
        return arrayList;
    }

    public static SwanCoreVersion j(int i, long j) {
        SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
        swanCoreVersion.swanCorePath = q(j, i).getPath();
        swanCoreVersion.swanCoreType = 1;
        swanCoreVersion.swanCoreVersion = j;
        return swanCoreVersion;
    }

    public static long jQ(int i) {
        return h.aLO().getLong(jS(i), 0L);
    }

    public static void jR(int i) {
        p(0L, i);
    }

    private static String jS(int i) {
        return i == 1 ? "aigames_cur_remote_ver_key" : "aiapps_cur_remote_ver_key";
    }

    private static void p(final long j, final int i) {
        h.aLO().putLong(jS(i), j);
        p.a(new Runnable() { // from class: com.baidu.swan.apps.swancore.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.swancore.a.aLP().m(j, i);
                } catch (Exception e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }, "cacheSwanCoreInfo");
    }

    private static File jT(int i) {
        return new File(com.baidu.swan.apps.swancore.b.jB(i), "remote");
    }

    private static File q(long j, int i) {
        return new File(jT(i), String.valueOf(j));
    }

    /* renamed from: com.baidu.swan.apps.swancore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0474a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0474a aMc() {
            return aq(0, "");
        }

        public static C0474a te(String str) {
            return aq(1, str);
        }

        public static C0474a aq(int i, String str) {
            C0474a c0474a = new C0474a();
            c0474a.statusCode = i;
            c0474a.message = str;
            return c0474a;
        }

        @NonNull
        public String toString() {
            return "RemoteCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
