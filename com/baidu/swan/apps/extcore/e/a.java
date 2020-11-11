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

    public long aun() {
        return h.aKS().getLong(this.cTC.aui(), 0L);
    }

    public void bE(long j) {
        h.aKS().putLong(this.cTC.aui(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File atX() {
        return new File(super.atX(), "remote");
    }

    @NonNull
    public ExtensionCore auo() {
        ExtensionCore extensionCore = new ExtensionCore();
        long aun = aun();
        extensionCore.extensionCoreVersionCode = aun;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.bF(aun);
        extensionCore.extensionCorePath = bD(aun).getPath();
        extensionCore.extensionCoreType = 1;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Ljava/lang/Exception; */
    public Exception b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.cUe)) {
            if (DEBUG) {
                Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            }
            return new Exception("ExtCore-RemoteControl doUpdate: failed by updateInfo.coreFilePath empty");
        }
        C0442a J = J(aVar.versionName, aVar.cUe, aVar.sign);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + J);
        }
        oq(aVar.cUe);
        if (J.isOk()) {
            return null;
        }
        return new Exception("ExtCore-RemoteControl doUpdate: failed by " + J.toString());
    }

    private C0442a J(String str, @NonNull String str2, String str3) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long os = com.baidu.swan.apps.extcore.f.a.os(str);
        if (os == 0) {
            return C0442a.or("invalid version code : " + str);
        }
        if (!ae.e(new File(str2), str3)) {
            return C0442a.or("sign failed.");
        }
        if (!d.unzipFile(str2, bD(os).getPath())) {
            return C0442a.or("unzip bundle failed.");
        }
        com.baidu.swan.apps.extcore.f.a.a(atX(), aun(), os);
        bE(os);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + os);
        }
        return C0442a.aup();
    }

    private void oq(String str) {
        if (!TextUtils.isEmpty(str)) {
            d.deleteFile(str);
        }
    }

    /* renamed from: com.baidu.swan.apps.extcore.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0442a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0442a aup() {
            return aj(0, "");
        }

        public static C0442a or(String str) {
            return aj(1, str);
        }

        public static C0442a aj(int i, String str) {
            C0442a c0442a = new C0442a();
            c0442a.statusCode = i;
            c0442a.message = str;
            return c0442a;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
