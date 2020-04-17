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

    public long ZT() {
        return h.anz().getLong(this.bSW.ZO(), 0L);
    }

    public void aK(long j) {
        h.anz().putLong(this.bSW.ZO(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File ZF() {
        return new File(super.ZF(), "remote");
    }

    @NonNull
    public ExtensionCore ZU() {
        ExtensionCore extensionCore = new ExtensionCore();
        long ZT = ZT();
        extensionCore.extensionCoreVersionCode = ZT;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.g.a.aL(ZT);
        extensionCore.extensionCorePath = aJ(ZT).getPath();
        extensionCore.extensionCoreType = 1;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Z */
    public boolean b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.bTA)) {
            if (DEBUG) {
                Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            }
            return false;
        }
        C0290a t = t(aVar.versionName, aVar.bTA, aVar.sign);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + t);
        }
        jb(aVar.bTA);
        return t.isOk();
    }

    private C0290a t(String str, @NonNull String str2, String str3) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long jd = com.baidu.swan.apps.extcore.g.a.jd(str);
        if (jd == 0) {
            return C0290a.jc("invalid version code : " + str);
        }
        if (!ab.e(new File(str2), str3)) {
            return C0290a.jc("sign failed.");
        }
        if (!c.unzipFile(str2, aJ(jd).getPath())) {
            return C0290a.jc("unzip bundle failed.");
        }
        com.baidu.swan.apps.extcore.g.a.a(ZF(), ZT(), jd);
        aK(jd);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + jd);
        }
        return C0290a.ZV();
    }

    private void jb(String str) {
        if (!TextUtils.isEmpty(str)) {
            c.deleteFile(str);
        }
    }

    /* renamed from: com.baidu.swan.apps.extcore.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0290a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0290a ZV() {
            return P(0, "");
        }

        public static C0290a jc(String str) {
            return P(1, str);
        }

        public static C0290a P(int i, String str) {
            C0290a c0290a = new C0290a();
            c0290a.statusCode = i;
            c0290a.message = str;
            return c0290a;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
