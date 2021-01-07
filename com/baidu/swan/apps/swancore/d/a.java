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
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static C0491a h(String str, String str2, String str3, int i) {
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate start.");
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long uo = com.baidu.swan.apps.swancore.b.uo(str);
        if (uo == 0) {
            return C0491a.up("invalid version code : " + str);
        }
        if (!ae.f(new File(str2), str3)) {
            return C0491a.up("sign failed.");
        }
        if (!d.unzipFile(str2, q(uo, i).getPath())) {
            return C0491a.up("unzip bundle failed.");
        }
        if (DEBUG) {
            String e = e.e(new File(str2), false);
            if (!TextUtils.isEmpty(e)) {
                h.aPI().putString(com.baidu.swan.apps.swancore.a.kZ(i), e);
            }
        }
        if (ProcessUtils.isMainProcess()) {
            com.baidu.swan.apps.swancore.b.b(lz(i), p(lw(i), uo));
        }
        p(uo, i);
        if (DEBUG) {
            Log.d("RemoteSwanCoreControl", "doRemoteUpdate end. version = " + uo);
        }
        return C0491a.aPW();
    }

    private static ArrayList<Long> p(long j, long j2) {
        SwanCoreVersion avW;
        ArrayList<Long> arrayList = new ArrayList<>();
        if (j != 0) {
            arrayList.add(Long.valueOf(j));
        }
        arrayList.add(Long.valueOf(j2));
        for (c cVar : com.baidu.swan.apps.process.messaging.service.e.aJM().aJO()) {
            SwanAppCores aJy = cVar.aJy();
            if (cVar.aJz() && aJy != null && (avW = aJy.avW()) != null && !arrayList.contains(Long.valueOf(avW.swanCoreVersion))) {
                arrayList.add(Long.valueOf(avW.swanCoreVersion));
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

    public static long lw(int i) {
        return h.aPI().getLong(ly(i), 0L);
    }

    public static void lx(int i) {
        p(0L, i);
    }

    private static String ly(int i) {
        return i == 1 ? "aigames_cur_remote_ver_key" : "aiapps_cur_remote_ver_key";
    }

    private static void p(final long j, final int i) {
        h.aPI().putLong(ly(i), j);
        p.a(new Runnable() { // from class: com.baidu.swan.apps.swancore.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.swancore.a.aPJ().m(j, i);
                } catch (Exception e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }, "cacheSwanCoreInfo");
    }

    private static File lz(int i) {
        return new File(com.baidu.swan.apps.swancore.b.lh(i), "remote");
    }

    private static File q(long j, int i) {
        return new File(lz(i), String.valueOf(j));
    }

    /* renamed from: com.baidu.swan.apps.swancore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0491a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0491a aPW() {
            return ap(0, "");
        }

        public static C0491a up(String str) {
            return ap(1, str);
        }

        public static C0491a ap(int i, String str) {
            C0491a c0491a = new C0491a();
            c0491a.statusCode = i;
            c0491a.message = str;
            return c0491a;
        }

        @NonNull
        public String toString() {
            return "RemoteCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
