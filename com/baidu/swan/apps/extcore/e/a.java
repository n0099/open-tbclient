package com.baidu.swan.apps.extcore.e;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.ac;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.extcore.model.b.a;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.e.d;
import java.io.File;
/* loaded from: classes11.dex */
public class a<T extends com.baidu.swan.apps.extcore.model.b.a> extends com.baidu.swan.apps.extcore.b.a<T> {
    private static final boolean DEBUG = b.DEBUG;

    public a(@NonNull T t) {
        super(t);
    }

    public long acS() {
        return h.arO().getLong(this.ccV.acN(), 0L);
    }

    public void aR(long j) {
        h.arO().putLong(this.ccV.acN(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File acE() {
        return new File(super.acE(), "remote");
    }

    @NonNull
    public ExtensionCore acT() {
        ExtensionCore extensionCore = new ExtensionCore();
        long acS = acS();
        extensionCore.extensionCoreVersionCode = acS;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.aS(acS);
        extensionCore.extensionCorePath = aQ(acS).getPath();
        extensionCore.extensionCoreType = 1;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Ljava/lang/Exception; */
    public Exception b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.cdA)) {
            if (DEBUG) {
                Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            }
            return new Exception("ExtCore-RemoteControl doUpdate: failed by updateInfo.coreFilePath empty");
        }
        C0351a y = y(aVar.versionName, aVar.cdA, aVar.sign);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + y);
        }
        ki(aVar.cdA);
        if (y.isOk()) {
            return null;
        }
        return new Exception("ExtCore-RemoteControl doUpdate: failed by " + y.toString());
    }

    private C0351a y(String str, @NonNull String str2, String str3) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long kk = com.baidu.swan.apps.extcore.f.a.kk(str);
        if (kk == 0) {
            return C0351a.kj("invalid version code : " + str);
        }
        if (!ac.e(new File(str2), str3)) {
            return C0351a.kj("sign failed.");
        }
        if (!d.unzipFile(str2, aQ(kk).getPath())) {
            return C0351a.kj("unzip bundle failed.");
        }
        com.baidu.swan.apps.extcore.f.a.a(acE(), acS(), kk);
        aR(kk);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + kk);
        }
        return C0351a.acU();
    }

    private void ki(String str) {
        if (!TextUtils.isEmpty(str)) {
            d.deleteFile(str);
        }
    }

    /* renamed from: com.baidu.swan.apps.extcore.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0351a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0351a acU() {
            return Q(0, "");
        }

        public static C0351a kj(String str) {
            return Q(1, str);
        }

        public static C0351a Q(int i, String str) {
            C0351a c0351a = new C0351a();
            c0351a.statusCode = i;
            c0351a.message = str;
            return c0351a;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
