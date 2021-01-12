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

    public long aum() {
        return h.aLO().getLong(this.cYR.auh(), 0L);
    }

    public void ce(long j) {
        h.aLO().putLong(this.cYR.auh(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File atW() {
        return new File(super.atW(), "remote");
    }

    @NonNull
    public ExtensionCore aun() {
        ExtensionCore extensionCore = new ExtensionCore();
        long aum = aum();
        extensionCore.extensionCoreVersionCode = aum;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.cf(aum);
        extensionCore.extensionCorePath = cd(aum).getPath();
        extensionCore.extensionCoreType = 1;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Ljava/lang/Exception; */
    public Exception b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.cZt)) {
            if (DEBUG) {
                Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            }
            return new Exception("ExtCore-RemoteControl doUpdate: failed by updateInfo.coreFilePath empty");
        }
        C0427a O = O(aVar.versionName, aVar.cZt, aVar.sign);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + O);
        }
        nx(aVar.cZt);
        if (O.isOk()) {
            return null;
        }
        return new Exception("ExtCore-RemoteControl doUpdate: failed by " + O.toString());
    }

    private C0427a O(String str, @NonNull String str2, String str3) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long nz = com.baidu.swan.apps.extcore.f.a.nz(str);
        if (nz == 0) {
            return C0427a.ny("invalid version code : " + str);
        }
        if (!ae.f(new File(str2), str3)) {
            return C0427a.ny("sign failed.");
        }
        if (!d.unzipFile(str2, cd(nz).getPath())) {
            return C0427a.ny("unzip bundle failed.");
        }
        com.baidu.swan.apps.extcore.f.a.a(atW(), aum(), nz);
        ce(nz);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + nz);
        }
        return C0427a.auo();
    }

    private void nx(String str) {
        if (!TextUtils.isEmpty(str)) {
            d.deleteFile(str);
        }
    }

    /* renamed from: com.baidu.swan.apps.extcore.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0427a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0427a auo() {
            return am(0, "");
        }

        public static C0427a ny(String str) {
            return am(1, str);
        }

        public static C0427a am(int i, String str) {
            C0427a c0427a = new C0427a();
            c0427a.statusCode = i;
            c0427a.message = str;
            return c0427a;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
