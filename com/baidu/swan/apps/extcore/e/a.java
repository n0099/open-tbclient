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

    public long Cy() {
        return f.Ni().getLong(this.avQ.Cu(), 0L);
    }

    public void D(long j) {
        f.Ni().putLong(this.avQ.Cu(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File Cm() {
        return new File(super.Cm(), "remote");
    }

    @NonNull
    public ExtensionCore Cz() {
        ExtensionCore extensionCore = new ExtensionCore();
        long Cy = Cy();
        extensionCore.awm = Cy;
        extensionCore.awn = com.baidu.swan.apps.extcore.f.a.E(Cy);
        extensionCore.awo = C(Cy).getPath();
        extensionCore.awl = 1;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Z */
    public boolean b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.awp)) {
            Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            return false;
        }
        C0147a o = o(aVar.versionName, aVar.awp, aVar.sign);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + o);
        }
        ev(aVar.awp);
        return o.isOk();
    }

    private C0147a o(String str, @NonNull String str2, String str3) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long ex = com.baidu.swan.apps.extcore.f.a.ex(str);
        if (ex == 0) {
            return C0147a.ew("invalid version code : " + str);
        }
        if (!w.b(new File(str2), str3)) {
            return C0147a.ew("sign failed.");
        }
        if (!com.baidu.swan.c.a.bs(str2, C(ex).getPath())) {
            return C0147a.ew("unzip bundle failed.");
        }
        com.baidu.swan.apps.extcore.f.a.a(Cm(), d(Cy(), ex));
        D(ex);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + ex);
        }
        return C0147a.CB();
    }

    private ArrayList<Long> d(long j, long j2) {
        ExtensionCore BB;
        ArrayList<Long> arrayList = new ArrayList<>();
        if (j != 0) {
            arrayList.add(Long.valueOf(j));
        }
        arrayList.add(Long.valueOf(j2));
        if (SwanAppMessengerService.getServiceObject() == null) {
            return arrayList;
        }
        for (a.b bVar : com.baidu.swan.apps.process.messaging.service.a.IK().IL()) {
            if (bVar.aHb && bVar.aGY != null && (BB = bVar.aGY.BB()) != null && !arrayList.contains(Long.valueOf(BB.awm))) {
                arrayList.add(Long.valueOf(BB.awm));
            }
        }
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray()));
        }
        return arrayList;
    }

    private void ev(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.c.a.deleteFile(str);
        }
    }

    /* renamed from: com.baidu.swan.apps.extcore.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0147a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0147a CB() {
            return m(0, "");
        }

        public static C0147a ew(String str) {
            return m(1, str);
        }

        public static C0147a m(int i, String str) {
            C0147a c0147a = new C0147a();
            c0147a.statusCode = i;
            c0147a.message = str;
            return c0147a;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
