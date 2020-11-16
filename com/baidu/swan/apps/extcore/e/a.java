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
/* loaded from: classes7.dex */
public class a<T extends com.baidu.swan.apps.extcore.model.b.a> extends com.baidu.swan.apps.extcore.b.a<T> {
    private static final boolean DEBUG = b.DEBUG;

    public a(@NonNull T t) {
        super(t);
    }

    public long atF() {
        return h.aKk().getLong(this.cRS.atA(), 0L);
    }

    public void bE(long j) {
        h.aKk().putLong(this.cRS.atA(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File atp() {
        return new File(super.atp(), "remote");
    }

    @NonNull
    public ExtensionCore atG() {
        ExtensionCore extensionCore = new ExtensionCore();
        long atF = atF();
        extensionCore.extensionCoreVersionCode = atF;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.bF(atF);
        extensionCore.extensionCorePath = bD(atF).getPath();
        extensionCore.extensionCoreType = 1;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Ljava/lang/Exception; */
    public Exception b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.cSu)) {
            if (DEBUG) {
                Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            }
            return new Exception("ExtCore-RemoteControl doUpdate: failed by updateInfo.coreFilePath empty");
        }
        C0440a J = J(aVar.versionName, aVar.cSu, aVar.sign);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + J);
        }
        oj(aVar.cSu);
        if (J.isOk()) {
            return null;
        }
        return new Exception("ExtCore-RemoteControl doUpdate: failed by " + J.toString());
    }

    private C0440a J(String str, @NonNull String str2, String str3) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long ol = com.baidu.swan.apps.extcore.f.a.ol(str);
        if (ol == 0) {
            return C0440a.ok("invalid version code : " + str);
        }
        if (!ae.e(new File(str2), str3)) {
            return C0440a.ok("sign failed.");
        }
        if (!d.unzipFile(str2, bD(ol).getPath())) {
            return C0440a.ok("unzip bundle failed.");
        }
        com.baidu.swan.apps.extcore.f.a.a(atp(), atF(), ol);
        bE(ol);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + ol);
        }
        return C0440a.atH();
    }

    private void oj(String str) {
        if (!TextUtils.isEmpty(str)) {
            d.deleteFile(str);
        }
    }

    /* renamed from: com.baidu.swan.apps.extcore.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0440a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0440a atH() {
            return aj(0, "");
        }

        public static C0440a ok(String str) {
            return aj(1, str);
        }

        public static C0440a aj(int i, String str) {
            C0440a c0440a = new C0440a();
            c0440a.statusCode = i;
            c0440a.message = str;
            return c0440a;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
