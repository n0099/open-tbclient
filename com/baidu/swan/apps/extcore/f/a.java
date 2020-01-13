package com.baidu.swan.apps.extcore.f;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.ab;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.extcore.model.b.a;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.d.c;
import java.io.File;
/* loaded from: classes10.dex */
public class a<T extends com.baidu.swan.apps.extcore.model.b.a> extends com.baidu.swan.apps.extcore.b.a<T> {
    private static final boolean DEBUG = b.DEBUG;

    public a(@NonNull T t) {
        super(t);
    }

    public long PL() {
        return h.adb().getLong(this.bqs.PG(), 0L);
    }

    public void ac(long j) {
        h.adb().putLong(this.bqs.PG(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File Px() {
        return new File(super.Px(), "remote");
    }

    @NonNull
    public ExtensionCore PM() {
        ExtensionCore extensionCore = new ExtensionCore();
        long PL = PL();
        extensionCore.extensionCoreVersionCode = PL;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.g.a.ad(PL);
        extensionCore.extensionCorePath = ab(PL).getPath();
        extensionCore.extensionCoreType = 1;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Z */
    public boolean b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.bqW)) {
            if (DEBUG) {
                Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            }
            return false;
        }
        C0250a s = s(aVar.versionName, aVar.bqW, aVar.sign);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + s);
        }
        hz(aVar.bqW);
        return s.isOk();
    }

    private C0250a s(String str, @NonNull String str2, String str3) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long hB = com.baidu.swan.apps.extcore.g.a.hB(str);
        if (hB == 0) {
            return C0250a.hA("invalid version code : " + str);
        }
        if (!ab.d(new File(str2), str3)) {
            return C0250a.hA("sign failed.");
        }
        if (!c.unzipFile(str2, ab(hB).getPath())) {
            return C0250a.hA("unzip bundle failed.");
        }
        com.baidu.swan.apps.extcore.g.a.a(Px(), PL(), hB);
        ac(hB);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + hB);
        }
        return C0250a.PN();
    }

    private void hz(String str) {
        if (!TextUtils.isEmpty(str)) {
            c.deleteFile(str);
        }
    }

    /* renamed from: com.baidu.swan.apps.extcore.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0250a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0250a PN() {
            return w(0, "");
        }

        public static C0250a hA(String str) {
            return w(1, str);
        }

        public static C0250a w(int i, String str) {
            C0250a c0250a = new C0250a();
            c0250a.statusCode = i;
            c0250a.message = str;
            return c0250a;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
