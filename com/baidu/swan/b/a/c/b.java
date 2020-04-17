package com.baidu.swan.b.a.c;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.swan.apps.as.s;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends ActivityDelegation {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private JSONObject cIm;
    private c cIy = new c();
    private com.baidu.swan.b.a.c.c cIz;
    private String mPackageName;

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        if (DEBUG) {
            Log.d("InstallAppDelegation", "onExec mParams" + this.mParams);
        }
        this.cIm = s.parseString(this.mParams.getString("ubc_params", ""));
        JSONObject parseString = s.parseString(this.mParams.getString("data", ""));
        this.mPackageName = parseString.optString("packageName");
        this.mResult.putString("packageName", this.mPackageName);
        this.cIz = new com.baidu.swan.b.a.c.c(this.cIy);
        com.baidu.swan.b.a.a.a.sExecutorService.execute(new RunnableC0343b(parseString, this.cIm, this.cIz));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(@NonNull JSONObject jSONObject, @NonNull com.baidu.swan.b.a.d.a aVar) {
        com.baidu.swan.b.a.a.ati().a(jSONObject.optString("url"), aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.b.a.e.b bVar) {
        if (bVar != null) {
            this.mResult.putString("functionType", bVar.atw());
            this.mResult.putString("resultData", bVar.getResult());
            this.mResult.putInt("resultStatus", bVar.getStatus());
            if (bVar.atv()) {
                com.baidu.swan.b.a.f.c.a(this.mPackageName, "installApp", "success", null, new com.baidu.swan.b.a.f.a(this.cIm));
            } else {
                com.baidu.swan.b.a.f.c.a(this.mPackageName, "installApp", "fail", String.valueOf(bVar.getStatus()), new com.baidu.swan.b.a.f.a(this.cIm));
            }
        }
        release();
        finish();
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onAgentDestroy() {
        if (DEBUG) {
            Log.d("InstallAppDelegation", "onAgentDestroy mPackageName:" + this.mPackageName);
        }
        release();
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onSelfFinish() {
        if (DEBUG) {
            Log.d("InstallAppDelegation", "onSelfFinish mPackageName:" + this.mPackageName);
        }
        com.baidu.swan.b.a.f.c.a(this.mPackageName, "installApp", "fail", String.valueOf(31003), new com.baidu.swan.b.a.f.a(this.cIm));
        release();
    }

    private void release() {
        if (this.cIz != null) {
            com.baidu.swan.b.a.a.ati().e(this.mPackageName, this.cIz);
            this.cIz = null;
        }
        this.cIy = null;
    }

    /* loaded from: classes11.dex */
    public class c implements com.baidu.swan.b.a.d.a {
        private String mFilePath;
        private String mPackageName;

        public c() {
        }

        @Override // com.baidu.swan.b.a.d.b
        public void b(com.baidu.swan.b.a.e.b bVar) {
            if (b.DEBUG) {
                Log.d("InstallAppDelegation", "onResult mPackageName:" + this.mPackageName);
            }
            b.this.a(bVar);
            com.baidu.swan.b.a.a.a.sExecutorService.execute(new a(this.mFilePath));
        }

        @Override // com.baidu.swan.b.a.d.a
        public void setPackageName(String str) {
            this.mPackageName = str;
        }

        @Override // com.baidu.swan.b.a.d.a
        public void setFilePath(String str) {
            this.mFilePath = str;
        }
    }

    /* renamed from: com.baidu.swan.b.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class RunnableC0343b implements Runnable {
        private JSONObject cIA;
        private com.baidu.swan.b.a.d.a cIB;
        private JSONObject cIm;

        private RunnableC0343b(@NonNull JSONObject jSONObject, JSONObject jSONObject2, @NonNull com.baidu.swan.b.a.d.a aVar) {
            this.cIA = jSONObject;
            this.cIm = jSONObject2;
            this.cIB = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.b.a.a.ati().bB(this.cIm);
            com.baidu.swan.b.a.f.c.a(this.cIA.optString("packageName"), "installApp", null, null, new com.baidu.swan.b.a.f.a(this.cIm));
            b.a(this.cIA, this.cIB);
        }
    }

    /* loaded from: classes11.dex */
    private static class a implements Runnable {
        private String mFilePath;

        private a(String str) {
            this.mFilePath = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.b.a.a.ati().pm(this.mFilePath);
            com.baidu.swan.b.a.a.ati().atk();
        }
    }
}
