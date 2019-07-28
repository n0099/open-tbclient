package com.baidu.swan.apps.extcore.e;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.an.w;
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

    public long Dh() {
        return f.NX().getLong(this.awv.Dd(), 0L);
    }

    public void D(long j) {
        f.NX().putLong(this.awv.Dd(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File CV() {
        return new File(super.CV(), "remote");
    }

    @NonNull
    public ExtensionCore Di() {
        ExtensionCore extensionCore = new ExtensionCore();
        long Dh = Dh();
        extensionCore.awR = Dh;
        extensionCore.awS = com.baidu.swan.apps.extcore.f.a.E(Dh);
        extensionCore.awT = C(Dh).getPath();
        extensionCore.awQ = 1;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Z */
    public boolean b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.awU)) {
            Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            return false;
        }
        C0149a o = o(aVar.versionName, aVar.awU, aVar.sign);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + o);
        }
        ez(aVar.awU);
        return o.isOk();
    }

    private C0149a o(String str, @NonNull String str2, String str3) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long eB = com.baidu.swan.apps.extcore.f.a.eB(str);
        if (eB == 0) {
            return C0149a.eA("invalid version code : " + str);
        }
        if (!w.b(new File(str2), str3)) {
            return C0149a.eA("sign failed.");
        }
        if (!com.baidu.swan.c.a.bs(str2, C(eB).getPath())) {
            return C0149a.eA("unzip bundle failed.");
        }
        com.baidu.swan.apps.extcore.f.a.a(CV(), d(Dh(), eB));
        D(eB);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + eB);
        }
        return C0149a.Dk();
    }

    private ArrayList<Long> d(long j, long j2) {
        ExtensionCore Cj;
        ArrayList<Long> arrayList = new ArrayList<>();
        if (j != 0) {
            arrayList.add(Long.valueOf(j));
        }
        arrayList.add(Long.valueOf(j2));
        if (SwanAppMessengerService.getServiceObject() == null) {
            return arrayList;
        }
        for (a.b bVar : com.baidu.swan.apps.process.messaging.service.a.Jx().Jy()) {
            if (bVar.aHJ && bVar.aHG != null && (Cj = bVar.aHG.Cj()) != null && !arrayList.contains(Long.valueOf(Cj.awR))) {
                arrayList.add(Long.valueOf(Cj.awR));
            }
        }
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray()));
        }
        return arrayList;
    }

    private void ez(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.c.a.deleteFile(str);
        }
    }

    /* renamed from: com.baidu.swan.apps.extcore.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0149a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0149a Dk() {
            return m(0, "");
        }

        public static C0149a eA(String str) {
            return m(1, str);
        }

        public static C0149a m(int i, String str) {
            C0149a c0149a = new C0149a();
            c0149a.statusCode = i;
            c0149a.message = str;
            return c0149a;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
