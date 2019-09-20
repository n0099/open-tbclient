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

    public long Dl() {
        return f.Ob().getLong(this.awT.Dh(), 0L);
    }

    public void D(long j) {
        f.Ob().putLong(this.awT.Dh(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File CZ() {
        return new File(super.CZ(), "remote");
    }

    @NonNull
    public ExtensionCore Dm() {
        ExtensionCore extensionCore = new ExtensionCore();
        long Dl = Dl();
        extensionCore.axp = Dl;
        extensionCore.axq = com.baidu.swan.apps.extcore.f.a.E(Dl);
        extensionCore.axr = C(Dl).getPath();
        extensionCore.axo = 1;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Z */
    public boolean b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.axs)) {
            Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            return false;
        }
        C0158a o = o(aVar.versionName, aVar.axs, aVar.sign);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + o);
        }
        eB(aVar.axs);
        return o.isOk();
    }

    private C0158a o(String str, @NonNull String str2, String str3) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long eD = com.baidu.swan.apps.extcore.f.a.eD(str);
        if (eD == 0) {
            return C0158a.eC("invalid version code : " + str);
        }
        if (!w.b(new File(str2), str3)) {
            return C0158a.eC("sign failed.");
        }
        if (!com.baidu.swan.c.a.bs(str2, C(eD).getPath())) {
            return C0158a.eC("unzip bundle failed.");
        }
        com.baidu.swan.apps.extcore.f.a.a(CZ(), d(Dl(), eD));
        D(eD);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + eD);
        }
        return C0158a.Do();
    }

    private ArrayList<Long> d(long j, long j2) {
        ExtensionCore Cn;
        ArrayList<Long> arrayList = new ArrayList<>();
        if (j != 0) {
            arrayList.add(Long.valueOf(j));
        }
        arrayList.add(Long.valueOf(j2));
        if (SwanAppMessengerService.getServiceObject() == null) {
            return arrayList;
        }
        for (a.b bVar : com.baidu.swan.apps.process.messaging.service.a.JB().JC()) {
            if (bVar.aIh && bVar.aIe != null && (Cn = bVar.aIe.Cn()) != null && !arrayList.contains(Long.valueOf(Cn.axp))) {
                arrayList.add(Long.valueOf(Cn.axp));
            }
        }
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray()));
        }
        return arrayList;
    }

    private void eB(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.c.a.deleteFile(str);
        }
    }

    /* renamed from: com.baidu.swan.apps.extcore.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0158a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0158a Do() {
            return m(0, "");
        }

        public static C0158a eC(String str) {
            return m(1, str);
        }

        public static C0158a m(int i, String str) {
            C0158a c0158a = new C0158a();
            c0158a.statusCode = i;
            c0158a.message = str;
            return c0158a;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
