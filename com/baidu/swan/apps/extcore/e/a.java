package com.baidu.swan.apps.extcore.e;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.ac;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.extcore.model.b.a;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.e.d;
import java.io.File;
/* loaded from: classes11.dex */
public class a<T extends com.baidu.swan.apps.extcore.model.b.a> extends com.baidu.swan.apps.extcore.b.a<T> {
    private static final boolean DEBUG = b.DEBUG;

    public a(@NonNull T t) {
        super(t);
    }

    public long adY() {
        return h.asV().getLong(this.chJ.adT(), 0L);
    }

    public void aR(long j) {
        h.asV().putLong(this.chJ.adT(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File adK() {
        return new File(super.adK(), "remote");
    }

    @NonNull
    public ExtensionCore adZ() {
        ExtensionCore extensionCore = new ExtensionCore();
        long adY = adY();
        extensionCore.extensionCoreVersionCode = adY;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.aS(adY);
        extensionCore.extensionCorePath = aQ(adY).getPath();
        extensionCore.extensionCoreType = 1;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Ljava/lang/Exception; */
    public Exception b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.cio)) {
            if (DEBUG) {
                Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            }
            return new Exception("ExtCore-RemoteControl doUpdate: failed by updateInfo.coreFilePath empty");
        }
        C0357a z = z(aVar.versionName, aVar.cio, aVar.sign);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + z);
        }
        kq(aVar.cio);
        if (z.isOk()) {
            return null;
        }
        return new Exception("ExtCore-RemoteControl doUpdate: failed by " + z.toString());
    }

    private C0357a z(String str, @NonNull String str2, String str3) {
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long ks = com.baidu.swan.apps.extcore.f.a.ks(str);
        if (ks == 0) {
            return C0357a.kr("invalid version code : " + str);
        }
        if (!ac.e(new File(str2), str3)) {
            return C0357a.kr("sign failed.");
        }
        if (!d.unzipFile(str2, aQ(ks).getPath())) {
            return C0357a.kr("unzip bundle failed.");
        }
        com.baidu.swan.apps.extcore.f.a.a(adK(), adY(), ks);
        aR(ks);
        if (DEBUG) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + ks);
        }
        return C0357a.aea();
    }

    private void kq(String str) {
        if (!TextUtils.isEmpty(str)) {
            d.deleteFile(str);
        }
    }

    /* renamed from: com.baidu.swan.apps.extcore.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0357a {
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static C0357a aea() {
            return S(0, "");
        }

        public static C0357a kr(String str) {
            return S(1, str);
        }

        public static C0357a S(int i, String str) {
            C0357a c0357a = new C0357a();
            c0357a.statusCode = i;
            c0357a.message = str;
            return c0357a;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
