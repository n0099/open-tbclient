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

    public long ZS() {
        return h.any().getLong(this.bTc.ZN(), 0L);
    }

    public void aK(long j) {
        h.any().putLong(this.bTc.ZN(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File ZE() {
        return new File(super.ZE(), "remote");
    }

    @NonNull
    public ExtensionCore ZT() {
        ExtensionCore extensionCore = new ExtensionCore();
        long ZS = ZS();
        extensionCore.extensionCoreVersionCode = ZS;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.g.a.aL(ZS);
        extensionCore.extensionCorePath = aJ(ZS).getPath();
        extensionCore.extensionCoreType = 1;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Z */
    public boolean b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.bTG)) {
            if (DEBUG) {
                Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            }
            return false;
        }
        C0311a t = t(aVar.versionName, aVar.bTG, aVar.sign);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + t);
        }
        jb(aVar.bTG);
        return t.isOk();
    }

    private C0311a t(String str, @NonNull String str2, String str3) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long jd = com.baidu.swan.apps.extcore.g.a.jd(str);
        if (jd == 0) {
            return C0311a.jc("invalid version code : " + str);
        }
        if (!ab.e(new File(str2), str3)) {
            return C0311a.jc("sign failed.");
        }
        if (!c.unzipFile(str2, aJ(jd).getPath())) {
            return C0311a.jc("unzip bundle failed.");
        }
        com.baidu.swan.apps.extcore.g.a.a(ZE(), ZS(), jd);
        aK(jd);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + jd);
        }
        return C0311a.ZU();
    }

    private void jb(String str) {
        if (!TextUtils.isEmpty(str)) {
            c.deleteFile(str);
        }
    }

    /* renamed from: com.baidu.swan.apps.extcore.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0311a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0311a ZU() {
            return P(0, "");
        }

        public static C0311a jc(String str) {
            return P(1, str);
        }

        public static C0311a P(int i, String str) {
            C0311a c0311a = new C0311a();
            c0311a.statusCode = i;
            c0311a.message = str;
            return c0311a;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
