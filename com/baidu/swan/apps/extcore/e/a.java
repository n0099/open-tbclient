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

    public long auK() {
        return h.aMh().getLong(this.dbd.auF(), 0L);
    }

    public void ck(long j) {
        h.aMh().putLong(this.dbd.auF(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File auu() {
        return new File(super.auu(), "remote");
    }

    @NonNull
    public ExtensionCore auL() {
        ExtensionCore extensionCore = new ExtensionCore();
        long auK = auK();
        extensionCore.extensionCoreVersionCode = auK;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.cl(auK);
        extensionCore.extensionCorePath = cj(auK).getPath();
        extensionCore.extensionCoreType = 1;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Ljava/lang/Exception; */
    public Exception b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.dbF)) {
            if (DEBUG) {
                Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            }
            return new Exception("ExtCore-RemoteControl doUpdate: failed by updateInfo.coreFilePath empty");
        }
        C0424a P = P(aVar.versionName, aVar.dbF, aVar.sign);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + P);
        }
        nP(aVar.dbF);
        if (P.isOk()) {
            return null;
        }
        return new Exception("ExtCore-RemoteControl doUpdate: failed by " + P.toString());
    }

    private C0424a P(String str, @NonNull String str2, String str3) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long nR = com.baidu.swan.apps.extcore.f.a.nR(str);
        if (nR == 0) {
            return C0424a.nQ("invalid version code : " + str);
        }
        if (!ae.e(new File(str2), str3)) {
            return C0424a.nQ("sign failed.");
        }
        if (!d.unzipFile(str2, cj(nR).getPath())) {
            return C0424a.nQ("unzip bundle failed.");
        }
        com.baidu.swan.apps.extcore.f.a.a(auu(), auK(), nR);
        ck(nR);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + nR);
        }
        return C0424a.auM();
    }

    private void nP(String str) {
        if (!TextUtils.isEmpty(str)) {
            d.deleteFile(str);
        }
    }

    /* renamed from: com.baidu.swan.apps.extcore.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0424a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0424a auM() {
            return aq(0, "");
        }

        public static C0424a nQ(String str) {
            return aq(1, str);
        }

        public static C0424a aq(int i, String str) {
            C0424a c0424a = new C0424a();
            c0424a.statusCode = i;
            c0424a.message = str;
            return c0424a;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
