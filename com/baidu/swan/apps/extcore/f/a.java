package com.baidu.swan.apps.extcore.f;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.ab;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.extcore.model.b.a;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.d.c;
import java.io.File;
/* loaded from: classes9.dex */
public class a<T extends com.baidu.swan.apps.extcore.model.b.a> extends com.baidu.swan.apps.extcore.b.a<T> {
    private static final boolean DEBUG = b.DEBUG;

    public a(@NonNull T t) {
        super(t);
    }

    public long Pp() {
        return h.acE().getLong(this.bpE.Pk(), 0L);
    }

    public void Z(long j) {
        h.acE().putLong(this.bpE.Pk(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File Pb() {
        return new File(super.Pb(), "remote");
    }

    @NonNull
    public ExtensionCore Pq() {
        ExtensionCore extensionCore = new ExtensionCore();
        long Pp = Pp();
        extensionCore.extensionCoreVersionCode = Pp;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.g.a.aa(Pp);
        extensionCore.extensionCorePath = Y(Pp).getPath();
        extensionCore.extensionCoreType = 1;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Z */
    public boolean b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.bqi)) {
            if (DEBUG) {
                Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            }
            return false;
        }
        C0248a s = s(aVar.versionName, aVar.bqi, aVar.sign);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + s);
        }
        hw(aVar.bqi);
        return s.isOk();
    }

    private C0248a s(String str, @NonNull String str2, String str3) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long hy = com.baidu.swan.apps.extcore.g.a.hy(str);
        if (hy == 0) {
            return C0248a.hx("invalid version code : " + str);
        }
        if (!ab.d(new File(str2), str3)) {
            return C0248a.hx("sign failed.");
        }
        if (!c.unzipFile(str2, Y(hy).getPath())) {
            return C0248a.hx("unzip bundle failed.");
        }
        com.baidu.swan.apps.extcore.g.a.a(Pb(), Pp(), hy);
        Z(hy);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + hy);
        }
        return C0248a.Pr();
    }

    private void hw(String str) {
        if (!TextUtils.isEmpty(str)) {
            c.deleteFile(str);
        }
    }

    /* renamed from: com.baidu.swan.apps.extcore.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0248a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0248a Pr() {
            return t(0, "");
        }

        public static C0248a hx(String str) {
            return t(1, str);
        }

        public static C0248a t(int i, String str) {
            C0248a c0248a = new C0248a();
            c0248a.statusCode = i;
            c0248a.message = str;
            return c0248a;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
