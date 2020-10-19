package com.baidu.swan.apps.extcore.e;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.ae;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.extcore.model.b.a;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.c.d;
import java.io.File;
/* loaded from: classes10.dex */
public class a<T extends com.baidu.swan.apps.extcore.model.b.a> extends com.baidu.swan.apps.extcore.b.a<T> {
    private static final boolean DEBUG = b.DEBUG;

    public a(@NonNull T t) {
        super(t);
    }

    public long apS() {
        return h.aGy().getLong(this.cFn.apN(), 0L);
    }

    public void bg(long j) {
        h.aGy().putLong(this.cFn.apN(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File apC() {
        return new File(super.apC(), "remote");
    }

    @NonNull
    public ExtensionCore apT() {
        ExtensionCore extensionCore = new ExtensionCore();
        long apS = apS();
        extensionCore.extensionCoreVersionCode = apS;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.bh(apS);
        extensionCore.extensionCorePath = bf(apS).getPath();
        extensionCore.extensionCoreType = 1;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Ljava/lang/Exception; */
    public Exception b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.cFP)) {
            if (DEBUG) {
                Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            }
            return new Exception("ExtCore-RemoteControl doUpdate: failed by updateInfo.coreFilePath empty");
        }
        C0416a C = C(aVar.versionName, aVar.cFP, aVar.sign);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + C);
        }
        nH(aVar.cFP);
        if (C.isOk()) {
            return null;
        }
        return new Exception("ExtCore-RemoteControl doUpdate: failed by " + C.toString());
    }

    private C0416a C(String str, @NonNull String str2, String str3) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long nJ = com.baidu.swan.apps.extcore.f.a.nJ(str);
        if (nJ == 0) {
            return C0416a.nI("invalid version code : " + str);
        }
        if (!ae.e(new File(str2), str3)) {
            return C0416a.nI("sign failed.");
        }
        if (!d.unzipFile(str2, bf(nJ).getPath())) {
            return C0416a.nI("unzip bundle failed.");
        }
        com.baidu.swan.apps.extcore.f.a.a(apC(), apS(), nJ);
        bg(nJ);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + nJ);
        }
        return C0416a.apU();
    }

    private void nH(String str) {
        if (!TextUtils.isEmpty(str)) {
            d.deleteFile(str);
        }
    }

    /* renamed from: com.baidu.swan.apps.extcore.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0416a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0416a apU() {
            return ad(0, "");
        }

        public static C0416a nI(String str) {
            return ad(1, str);
        }

        public static C0416a ad(int i, String str) {
            C0416a c0416a = new C0416a();
            c0416a.statusCode = i;
            c0416a.message = str;
            return c0416a;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
