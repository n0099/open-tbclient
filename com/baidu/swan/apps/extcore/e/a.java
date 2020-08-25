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
/* loaded from: classes8.dex */
public class a<T extends com.baidu.swan.apps.extcore.model.b.a> extends com.baidu.swan.apps.extcore.b.a<T> {
    private static final boolean DEBUG = b.DEBUG;

    public a(@NonNull T t) {
        super(t);
    }

    public long amw() {
        return h.aDf().getLong(this.cqV.amr(), 0L);
    }

    public void aX(long j) {
        h.aDf().putLong(this.cqV.amr(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File amg() {
        return new File(super.amg(), "remote");
    }

    @NonNull
    public ExtensionCore amx() {
        ExtensionCore extensionCore = new ExtensionCore();
        long amw = amw();
        extensionCore.extensionCoreVersionCode = amw;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.aY(amw);
        extensionCore.extensionCorePath = aW(amw).getPath();
        extensionCore.extensionCoreType = 1;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Ljava/lang/Exception; */
    public Exception b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.cry)) {
            if (DEBUG) {
                Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            }
            return new Exception("ExtCore-RemoteControl doUpdate: failed by updateInfo.coreFilePath empty");
        }
        C0404a B = B(aVar.versionName, aVar.cry, aVar.sign);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + B);
        }
        mB(aVar.cry);
        if (B.isOk()) {
            return null;
        }
        return new Exception("ExtCore-RemoteControl doUpdate: failed by " + B.toString());
    }

    private C0404a B(String str, @NonNull String str2, String str3) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long mD = com.baidu.swan.apps.extcore.f.a.mD(str);
        if (mD == 0) {
            return C0404a.mC("invalid version code : " + str);
        }
        if (!ae.e(new File(str2), str3)) {
            return C0404a.mC("sign failed.");
        }
        if (!d.unzipFile(str2, aW(mD).getPath())) {
            return C0404a.mC("unzip bundle failed.");
        }
        com.baidu.swan.apps.extcore.f.a.a(amg(), amw(), mD);
        aX(mD);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + mD);
        }
        return C0404a.amy();
    }

    private void mB(String str) {
        if (!TextUtils.isEmpty(str)) {
            d.deleteFile(str);
        }
    }

    /* renamed from: com.baidu.swan.apps.extcore.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0404a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0404a amy() {
            return R(0, "");
        }

        public static C0404a mC(String str) {
            return R(1, str);
        }

        public static C0404a R(int i, String str) {
            C0404a c0404a = new C0404a();
            c0404a.statusCode = i;
            c0404a.message = str;
            return c0404a;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
