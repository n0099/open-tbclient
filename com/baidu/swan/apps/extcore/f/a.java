package com.baidu.swan.apps.extcore.f;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.an.u;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.extcore.model.b.a;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.process.messaging.service.a;
import com.baidu.swan.apps.storage.b.f;
import com.baidu.swan.c.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class a<T extends com.baidu.swan.apps.extcore.model.b.a> extends com.baidu.swan.apps.extcore.b.a<T> {
    private static final boolean DEBUG = c.DEBUG;

    public a(@NonNull T t) {
        super(t);
    }

    public long By() {
        return f.KL().getLong(this.avs.Bu(), 0L);
    }

    public void u(long j) {
        f.KL().putLong(this.avs.Bu(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File Bl() {
        return new File(super.Bl(), "remote");
    }

    @NonNull
    public ExtensionCore Bz() {
        ExtensionCore extensionCore = new ExtensionCore();
        long By = By();
        extensionCore.avK = By;
        extensionCore.avL = com.baidu.swan.apps.extcore.g.a.v(By);
        extensionCore.avM = t(By).getPath();
        extensionCore.avJ = 1;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Z */
    public boolean b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.avN)) {
            Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            return false;
        }
        C0113a o = o(aVar.versionName, aVar.avN, aVar.sign);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + o);
        }
        eF(aVar.avN);
        return o.isOk();
    }

    private C0113a o(String str, @NonNull String str2, String str3) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long eH = com.baidu.swan.apps.extcore.g.a.eH(str);
        if (eH == 0) {
            return C0113a.eG("invalid version code : " + str);
        }
        if (!u.c(new File(str2), str3)) {
            return C0113a.eG("sign failed.");
        }
        if (!b.bl(str2, t(eH).getPath())) {
            return C0113a.eG("unzip bundle failed.");
        }
        com.baidu.swan.apps.extcore.g.a.a(Bl(), d(By(), eH));
        u(eH);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + eH);
        }
        return C0113a.BB();
    }

    private ArrayList<Long> d(long j, long j2) {
        ExtensionCore At;
        ArrayList<Long> arrayList = new ArrayList<>();
        if (j != 0) {
            arrayList.add(Long.valueOf(j));
        }
        arrayList.add(Long.valueOf(j2));
        if (SwanAppMessengerService.getServiceObject() == null) {
            return arrayList;
        }
        for (a.b bVar : com.baidu.swan.apps.process.messaging.service.a.Gw().Gx()) {
            if (bVar.aFd && bVar.aFa != null && (At = bVar.aFa.At()) != null && !arrayList.contains(Long.valueOf(At.avK))) {
                arrayList.add(Long.valueOf(At.avK));
            }
        }
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray()));
        }
        return arrayList;
    }

    private void eF(String str) {
        if (!TextUtils.isEmpty(str)) {
            b.deleteFile(str);
        }
    }

    /* renamed from: com.baidu.swan.apps.extcore.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0113a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0113a BB() {
            return j(0, "");
        }

        public static C0113a eG(String str) {
            return j(1, str);
        }

        public static C0113a j(int i, String str) {
            C0113a c0113a = new C0113a();
            c0113a.statusCode = i;
            c0113a.message = str;
            return c0113a;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
