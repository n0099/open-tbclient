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

    public long arM() {
        return h.aIs().getLong(this.cNJ.arH(), 0L);
    }

    public void bi(long j) {
        h.aIs().putLong(this.cNJ.arH(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File arw() {
        return new File(super.arw(), "remote");
    }

    @NonNull
    public ExtensionCore arN() {
        ExtensionCore extensionCore = new ExtensionCore();
        long arM = arM();
        extensionCore.extensionCoreVersionCode = arM;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.bj(arM);
        extensionCore.extensionCorePath = bh(arM).getPath();
        extensionCore.extensionCoreType = 1;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Ljava/lang/Exception; */
    public Exception b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.cOl)) {
            if (DEBUG) {
                Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            }
            return new Exception("ExtCore-RemoteControl doUpdate: failed by updateInfo.coreFilePath empty");
        }
        C0430a J = J(aVar.versionName, aVar.cOl, aVar.sign);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + J);
        }
        oa(aVar.cOl);
        if (J.isOk()) {
            return null;
        }
        return new Exception("ExtCore-RemoteControl doUpdate: failed by " + J.toString());
    }

    private C0430a J(String str, @NonNull String str2, String str3) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long oc = com.baidu.swan.apps.extcore.f.a.oc(str);
        if (oc == 0) {
            return C0430a.ob("invalid version code : " + str);
        }
        if (!ae.e(new File(str2), str3)) {
            return C0430a.ob("sign failed.");
        }
        if (!d.unzipFile(str2, bh(oc).getPath())) {
            return C0430a.ob("unzip bundle failed.");
        }
        com.baidu.swan.apps.extcore.f.a.a(arw(), arM(), oc);
        bi(oc);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + oc);
        }
        return C0430a.arO();
    }

    private void oa(String str) {
        if (!TextUtils.isEmpty(str)) {
            d.deleteFile(str);
        }
    }

    /* renamed from: com.baidu.swan.apps.extcore.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0430a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0430a arO() {
            return af(0, "");
        }

        public static C0430a ob(String str) {
            return af(1, str);
        }

        public static C0430a af(int i, String str) {
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
