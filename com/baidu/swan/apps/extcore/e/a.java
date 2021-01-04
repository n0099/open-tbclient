package com.baidu.swan.apps.extcore.e;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.ao.ae;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.extcore.model.b.a;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.c.d;
import java.io.File;
/* loaded from: classes9.dex */
public class a<T extends com.baidu.swan.apps.extcore.model.b.a> extends com.baidu.swan.apps.extcore.b.a<T> {
    private static final boolean DEBUG = b.DEBUG;

    public a(@NonNull T t) {
        super(t);
    }

    public long ayf() {
        return h.aPH().getLong(this.ddH.aya(), 0L);
    }

    public void ce(long j) {
        h.aPH().putLong(this.ddH.aya(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File axP() {
        return new File(super.axP(), "remote");
    }

    @NonNull
    public ExtensionCore ayg() {
        ExtensionCore extensionCore = new ExtensionCore();
        long ayf = ayf();
        extensionCore.extensionCoreVersionCode = ayf;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.cf(ayf);
        extensionCore.extensionCorePath = cd(ayf).getPath();
        extensionCore.extensionCoreType = 1;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Ljava/lang/Exception; */
    public Exception b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.dej)) {
            if (DEBUG) {
                Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            }
            return new Exception("ExtCore-RemoteControl doUpdate: failed by updateInfo.coreFilePath empty");
        }
        C0444a P = P(aVar.versionName, aVar.dej, aVar.sign);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + P);
        }
        oK(aVar.dej);
        if (P.isOk()) {
            return null;
        }
        return new Exception("ExtCore-RemoteControl doUpdate: failed by " + P.toString());
    }

    private C0444a P(String str, @NonNull String str2, String str3) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long oM = com.baidu.swan.apps.extcore.f.a.oM(str);
        if (oM == 0) {
            return C0444a.oL("invalid version code : " + str);
        }
        if (!ae.f(new File(str2), str3)) {
            return C0444a.oL("sign failed.");
        }
        if (!d.unzipFile(str2, cd(oM).getPath())) {
            return C0444a.oL("unzip bundle failed.");
        }
        com.baidu.swan.apps.extcore.f.a.a(axP(), ayf(), oM);
        ce(oM);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + oM);
        }
        return C0444a.ayh();
    }

    private void oK(String str) {
        if (!TextUtils.isEmpty(str)) {
            d.deleteFile(str);
        }
    }

    /* renamed from: com.baidu.swan.apps.extcore.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0444a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0444a ayh() {
            return al(0, "");
        }

        public static C0444a oL(String str) {
            return al(1, str);
        }

        public static C0444a al(int i, String str) {
            C0444a c0444a = new C0444a();
            c0444a.statusCode = i;
            c0444a.message = str;
            return c0444a;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
