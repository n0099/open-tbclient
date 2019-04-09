package com.baidu.swan.apps.extcore.f;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.an.u;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.extcore.model.b.a;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.process.messaging.service.a;
import com.baidu.swan.apps.storage.b.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class a<T extends com.baidu.swan.apps.extcore.model.b.a> extends com.baidu.swan.apps.extcore.b.a<T> {
    private static final boolean DEBUG = b.DEBUG;

    public a(@NonNull T t) {
        super(t);
    }

    public long Bw() {
        return f.KJ().getLong(this.avx.Bs(), 0L);
    }

    public void u(long j) {
        f.KJ().putLong(this.avx.Bs(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File Bj() {
        return new File(super.Bj(), "remote");
    }

    @NonNull
    public ExtensionCore Bx() {
        ExtensionCore extensionCore = new ExtensionCore();
        long Bw = Bw();
        extensionCore.avP = Bw;
        extensionCore.avQ = com.baidu.swan.apps.extcore.g.a.v(Bw);
        extensionCore.avR = t(Bw).getPath();
        extensionCore.avO = 1;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Z */
    public boolean b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.avS)) {
            Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            return false;
        }
        C0142a o = o(aVar.versionName, aVar.avS, aVar.sign);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + o);
        }
        eG(aVar.avS);
        return o.isOk();
    }

    private C0142a o(String str, @NonNull String str2, String str3) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long eI = com.baidu.swan.apps.extcore.g.a.eI(str);
        if (eI == 0) {
            return C0142a.eH("invalid version code : " + str);
        }
        if (!u.c(new File(str2), str3)) {
            return C0142a.eH("sign failed.");
        }
        if (!com.baidu.swan.c.b.bl(str2, t(eI).getPath())) {
            return C0142a.eH("unzip bundle failed.");
        }
        com.baidu.swan.apps.extcore.g.a.a(Bj(), d(Bw(), eI));
        u(eI);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + eI);
        }
        return C0142a.Bz();
    }

    private ArrayList<Long> d(long j, long j2) {
        ExtensionCore As;
        ArrayList<Long> arrayList = new ArrayList<>();
        if (j != 0) {
            arrayList.add(Long.valueOf(j));
        }
        arrayList.add(Long.valueOf(j2));
        if (SwanAppMessengerService.getServiceObject() == null) {
            return arrayList;
        }
        for (a.b bVar : com.baidu.swan.apps.process.messaging.service.a.Gu().Gv()) {
            if (bVar.aFi && bVar.aFf != null && (As = bVar.aFf.As()) != null && !arrayList.contains(Long.valueOf(As.avP))) {
                arrayList.add(Long.valueOf(As.avP));
            }
        }
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray()));
        }
        return arrayList;
    }

    private void eG(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.c.b.deleteFile(str);
        }
    }

    /* renamed from: com.baidu.swan.apps.extcore.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0142a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0142a Bz() {
            return j(0, "");
        }

        public static C0142a eH(String str) {
            return j(1, str);
        }

        public static C0142a j(int i, String str) {
            C0142a c0142a = new C0142a();
            c0142a.statusCode = i;
            c0142a.message = str;
            return c0142a;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
