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
/* loaded from: classes8.dex */
public class a<T extends com.baidu.swan.apps.extcore.model.b.a> extends com.baidu.swan.apps.extcore.b.a<T> {
    private static final boolean DEBUG = b.DEBUG;

    public a(@NonNull T t) {
        super(t);
    }

    public long auN() {
        return h.aMk().getLong(this.dcF.auI(), 0L);
    }

    public void ck(long j) {
        h.aMk().putLong(this.dcF.auI(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File aux() {
        return new File(super.aux(), "remote");
    }

    @NonNull
    public ExtensionCore auO() {
        ExtensionCore extensionCore = new ExtensionCore();
        long auN = auN();
        extensionCore.extensionCoreVersionCode = auN;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.cl(auN);
        extensionCore.extensionCorePath = cj(auN).getPath();
        extensionCore.extensionCoreType = 1;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Ljava/lang/Exception; */
    public Exception b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.ddh)) {
            if (DEBUG) {
                Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            }
            return new Exception("ExtCore-RemoteControl doUpdate: failed by updateInfo.coreFilePath empty");
        }
        C0430a P = P(aVar.versionName, aVar.ddh, aVar.sign);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + P);
        }
        nW(aVar.ddh);
        if (P.isOk()) {
            return null;
        }
        return new Exception("ExtCore-RemoteControl doUpdate: failed by " + P.toString());
    }

    private C0430a P(String str, @NonNull String str2, String str3) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long nY = com.baidu.swan.apps.extcore.f.a.nY(str);
        if (nY == 0) {
            return C0430a.nX("invalid version code : " + str);
        }
        if (!ae.e(new File(str2), str3)) {
            return C0430a.nX("sign failed.");
        }
        if (!d.unzipFile(str2, cj(nY).getPath())) {
            return C0430a.nX("unzip bundle failed.");
        }
        com.baidu.swan.apps.extcore.f.a.a(aux(), auN(), nY);
        ck(nY);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + nY);
        }
        return C0430a.auP();
    }

    private void nW(String str) {
        if (!TextUtils.isEmpty(str)) {
            d.deleteFile(str);
        }
    }

    /* renamed from: com.baidu.swan.apps.extcore.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0430a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0430a auP() {
            return aq(0, "");
        }

        public static C0430a nX(String str) {
            return aq(1, str);
        }

        public static C0430a aq(int i, String str) {
            C0430a c0430a = new C0430a();
            c0430a.statusCode = i;
            c0430a.message = str;
            return c0430a;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
