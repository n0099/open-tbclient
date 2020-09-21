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
/* loaded from: classes3.dex */
public class a<T extends com.baidu.swan.apps.extcore.model.b.a> extends com.baidu.swan.apps.extcore.b.a<T> {
    private static final boolean DEBUG = b.DEBUG;

    public a(@NonNull T t) {
        super(t);
    }

    public long ang() {
        return h.aDP().getLong(this.ctc.anb(), 0L);
    }

    public void aY(long j) {
        h.aDP().putLong(this.ctc.anb(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File amQ() {
        return new File(super.amQ(), "remote");
    }

    @NonNull
    public ExtensionCore anh() {
        ExtensionCore extensionCore = new ExtensionCore();
        long ang = ang();
        extensionCore.extensionCoreVersionCode = ang;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.aZ(ang);
        extensionCore.extensionCorePath = aX(ang).getPath();
        extensionCore.extensionCoreType = 1;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Ljava/lang/Exception; */
    public Exception b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.ctG)) {
            if (DEBUG) {
                Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            }
            return new Exception("ExtCore-RemoteControl doUpdate: failed by updateInfo.coreFilePath empty");
        }
        C0399a B = B(aVar.versionName, aVar.ctG, aVar.sign);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + B);
        }
        mV(aVar.ctG);
        if (B.isOk()) {
            return null;
        }
        return new Exception("ExtCore-RemoteControl doUpdate: failed by " + B.toString());
    }

    private C0399a B(String str, @NonNull String str2, String str3) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long mX = com.baidu.swan.apps.extcore.f.a.mX(str);
        if (mX == 0) {
            return C0399a.mW("invalid version code : " + str);
        }
        if (!ae.e(new File(str2), str3)) {
            return C0399a.mW("sign failed.");
        }
        if (!d.unzipFile(str2, aX(mX).getPath())) {
            return C0399a.mW("unzip bundle failed.");
        }
        com.baidu.swan.apps.extcore.f.a.a(amQ(), ang(), mX);
        aY(mX);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + mX);
        }
        return C0399a.ani();
    }

    private void mV(String str) {
        if (!TextUtils.isEmpty(str)) {
            d.deleteFile(str);
        }
    }

    /* renamed from: com.baidu.swan.apps.extcore.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0399a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0399a ani() {
            return S(0, "");
        }

        public static C0399a mW(String str) {
            return S(1, str);
        }

        public static C0399a S(int i, String str) {
            C0399a c0399a = new C0399a();
            c0399a.statusCode = i;
            c0399a.message = str;
            return c0399a;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
