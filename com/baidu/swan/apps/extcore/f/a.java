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
/* loaded from: classes11.dex */
public class a<T extends com.baidu.swan.apps.extcore.model.b.a> extends com.baidu.swan.apps.extcore.b.a<T> {
    private static final boolean DEBUG = b.DEBUG;

    public a(@NonNull T t) {
        super(t);
    }

    public long Sb() {
        return h.afr().getLong(this.buD.RW(), 0L);
    }

    public void ag(long j) {
        h.afr().putLong(this.buD.RW(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File RN() {
        return new File(super.RN(), "remote");
    }

    @NonNull
    public ExtensionCore Sc() {
        ExtensionCore extensionCore = new ExtensionCore();
        long Sb = Sb();
        extensionCore.extensionCoreVersionCode = Sb;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.g.a.ah(Sb);
        extensionCore.extensionCorePath = af(Sb).getPath();
        extensionCore.extensionCoreType = 1;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Z */
    public boolean b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.bvh)) {
            if (DEBUG) {
                Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            }
            return false;
        }
        C0260a t = t(aVar.versionName, aVar.bvh, aVar.sign);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + t);
        }
        hO(aVar.bvh);
        return t.isOk();
    }

    private C0260a t(String str, @NonNull String str2, String str3) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long hQ = com.baidu.swan.apps.extcore.g.a.hQ(str);
        if (hQ == 0) {
            return C0260a.hP("invalid version code : " + str);
        }
        if (!ab.d(new File(str2), str3)) {
            return C0260a.hP("sign failed.");
        }
        if (!c.unzipFile(str2, af(hQ).getPath())) {
            return C0260a.hP("unzip bundle failed.");
        }
        com.baidu.swan.apps.extcore.g.a.a(RN(), Sb(), hQ);
        ag(hQ);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + hQ);
        }
        return C0260a.Sd();
    }

    private void hO(String str) {
        if (!TextUtils.isEmpty(str)) {
            c.deleteFile(str);
        }
    }

    /* renamed from: com.baidu.swan.apps.extcore.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0260a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0260a Sd() {
            return y(0, "");
        }

        public static C0260a hP(String str) {
            return y(1, str);
        }

        public static C0260a y(int i, String str) {
            C0260a c0260a = new C0260a();
            c0260a.statusCode = i;
            c0260a.message = str;
            return c0260a;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
