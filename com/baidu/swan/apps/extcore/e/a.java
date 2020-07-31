package com.baidu.swan.apps.extcore.e;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.ae;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.extcore.model.b.a;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.d.d;
import java.io.File;
/* loaded from: classes7.dex */
public class a<T extends com.baidu.swan.apps.extcore.model.b.a> extends com.baidu.swan.apps.extcore.b.a<T> {
    private static final boolean DEBUG = b.DEBUG;

    public a(@NonNull T t) {
        super(t);
    }

    public long afp() {
        return h.auW().getLong(this.cjI.afk(), 0L);
    }

    public void aU(long j) {
        h.auW().putLong(this.cjI.afk(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File afa() {
        return new File(super.afa(), "remote");
    }

    @NonNull
    public ExtensionCore afq() {
        ExtensionCore extensionCore = new ExtensionCore();
        long afp = afp();
        extensionCore.extensionCoreVersionCode = afp;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.aV(afp);
        extensionCore.extensionCorePath = aT(afp).getPath();
        extensionCore.extensionCoreType = 1;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Ljava/lang/Exception; */
    public Exception b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.ckm)) {
            if (DEBUG) {
                Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            }
            return new Exception("ExtCore-RemoteControl doUpdate: failed by updateInfo.coreFilePath empty");
        }
        C0359a z = z(aVar.versionName, aVar.ckm, aVar.sign);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + z);
        }
        kM(aVar.ckm);
        if (z.isOk()) {
            return null;
        }
        return new Exception("ExtCore-RemoteControl doUpdate: failed by " + z.toString());
    }

    private C0359a z(String str, @NonNull String str2, String str3) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long kO = com.baidu.swan.apps.extcore.f.a.kO(str);
        if (kO == 0) {
            return C0359a.kN("invalid version code : " + str);
        }
        if (!ae.e(new File(str2), str3)) {
            return C0359a.kN("sign failed.");
        }
        if (!d.unzipFile(str2, aT(kO).getPath())) {
            return C0359a.kN("unzip bundle failed.");
        }
        com.baidu.swan.apps.extcore.f.a.a(afa(), afp(), kO);
        aU(kO);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + kO);
        }
        return C0359a.afr();
    }

    private void kM(String str) {
        if (!TextUtils.isEmpty(str)) {
            d.deleteFile(str);
        }
    }

    /* renamed from: com.baidu.swan.apps.extcore.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0359a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0359a afr() {
            return S(0, "");
        }

        public static C0359a kN(String str) {
            return S(1, str);
        }

        public static C0359a S(int i, String str) {
            C0359a c0359a = new C0359a();
            c0359a.statusCode = i;
            c0359a.message = str;
            return c0359a;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
