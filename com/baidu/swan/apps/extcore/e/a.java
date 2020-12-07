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
/* loaded from: classes25.dex */
public class a<T extends com.baidu.swan.apps.extcore.model.b.a> extends com.baidu.swan.apps.extcore.b.a<T> {
    private static final boolean DEBUG = b.DEBUG;

    public a(@NonNull T t) {
        super(t);
    }

    public long awN() {
        return h.aNr().getLong(this.cYL.awI(), 0L);
    }

    public void cd(long j) {
        h.aNr().putLong(this.cYL.awI(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File awx() {
        return new File(super.awx(), "remote");
    }

    @NonNull
    public ExtensionCore awO() {
        ExtensionCore extensionCore = new ExtensionCore();
        long awN = awN();
        extensionCore.extensionCoreVersionCode = awN;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.ce(awN);
        extensionCore.extensionCorePath = cc(awN).getPath();
        extensionCore.extensionCoreType = 1;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Ljava/lang/Exception; */
    public Exception b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.cZn)) {
            if (DEBUG) {
                Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            }
            return new Exception("ExtCore-RemoteControl doUpdate: failed by updateInfo.coreFilePath empty");
        }
        C0452a M = M(aVar.versionName, aVar.cZn, aVar.sign);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + M);
        }
        oR(aVar.cZn);
        if (M.isOk()) {
            return null;
        }
        return new Exception("ExtCore-RemoteControl doUpdate: failed by " + M.toString());
    }

    private C0452a M(String str, @NonNull String str2, String str3) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long oT = com.baidu.swan.apps.extcore.f.a.oT(str);
        if (oT == 0) {
            return C0452a.oS("invalid version code : " + str);
        }
        if (!ae.e(new File(str2), str3)) {
            return C0452a.oS("sign failed.");
        }
        if (!d.unzipFile(str2, cc(oT).getPath())) {
            return C0452a.oS("unzip bundle failed.");
        }
        com.baidu.swan.apps.extcore.f.a.a(awx(), awN(), oT);
        cd(oT);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + oT);
        }
        return C0452a.awP();
    }

    private void oR(String str) {
        if (!TextUtils.isEmpty(str)) {
            d.deleteFile(str);
        }
    }

    /* renamed from: com.baidu.swan.apps.extcore.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0452a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0452a awP() {
            return aj(0, "");
        }

        public static C0452a oS(String str) {
            return aj(1, str);
        }

        public static C0452a aj(int i, String str) {
            C0452a c0452a = new C0452a();
            c0452a.statusCode = i;
            c0452a.message = str;
            return c0452a;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
