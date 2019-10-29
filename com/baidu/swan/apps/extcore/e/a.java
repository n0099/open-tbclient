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

    public long If() {
        return f.SR().getLong(this.aQi.Ib(), 0L);
    }

    public void W(long j) {
        f.SR().putLong(this.aQi.Ib(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File HT() {
        return new File(super.HT(), "remote");
    }

    @NonNull
    public ExtensionCore Ig() {
        ExtensionCore extensionCore = new ExtensionCore();
        long If = If();
        extensionCore.aQE = If;
        extensionCore.aQF = com.baidu.swan.apps.extcore.f.a.X(If);
        extensionCore.aQG = V(If).getPath();
        extensionCore.aQD = 1;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Z */
    public boolean b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.aQH)) {
            Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            return false;
        }
        C0190a s = s(aVar.versionName, aVar.aQH, aVar.sign);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + s);
        }
        fi(aVar.aQH);
        return s.isOk();
    }

    private C0190a s(String str, @NonNull String str2, String str3) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long fk = com.baidu.swan.apps.extcore.f.a.fk(str);
        if (fk == 0) {
            return C0190a.fj("invalid version code : " + str);
        }
        if (!w.b(new File(str2), str3)) {
            return C0190a.fj("sign failed.");
        }
        if (!com.baidu.swan.c.a.bz(str2, V(fk).getPath())) {
            return C0190a.fj("unzip bundle failed.");
        }
        com.baidu.swan.apps.extcore.f.a.a(HT(), j(If(), fk));
        W(fk);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + fk);
        }
        return C0190a.Ii();
    }

    private ArrayList<Long> j(long j, long j2) {
        ExtensionCore Hh;
        ArrayList<Long> arrayList = new ArrayList<>();
        if (j != 0) {
            arrayList.add(Long.valueOf(j));
        }
        arrayList.add(Long.valueOf(j2));
        if (SwanAppMessengerService.getServiceObject() == null) {
            return arrayList;
        }
        for (a.b bVar : com.baidu.swan.apps.process.messaging.service.a.Ov().Ow()) {
            if (bVar.bbv && bVar.bbs != null && (Hh = bVar.bbs.Hh()) != null && !arrayList.contains(Long.valueOf(Hh.aQE))) {
                arrayList.add(Long.valueOf(Hh.aQE));
            }
        }
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray()));
        }
        return arrayList;
    }

    private void fi(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.c.a.deleteFile(str);
        }
    }

    /* renamed from: com.baidu.swan.apps.extcore.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0190a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0190a Ii() {
            return q(0, "");
        }

        public static C0190a fj(String str) {
            return q(1, str);
        }

        public static C0190a q(int i, String str) {
            C0190a c0190a = new C0190a();
            c0190a.statusCode = i;
            c0190a.message = str;
            return c0190a;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
