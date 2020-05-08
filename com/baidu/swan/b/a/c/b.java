package com.baidu.swan.b.a.c;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.swan.apps.as.s;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends ActivityDelegation {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c cIE = new c();
    private com.baidu.swan.b.a.c.c cIF;
    private JSONObject cIs;
    private String mPackageName;

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        if (DEBUG) {
            Log.d("InstallAppDelegation", "onExec mParams" + this.mParams);
        }
        this.cIs = s.parseString(this.mParams.getString("ubc_params", ""));
        JSONObject parseString = s.parseString(this.mParams.getString("data", ""));
        this.mPackageName = parseString.optString("packageName");
        this.mResult.putString("packageName", this.mPackageName);
        this.cIF = new com.baidu.swan.b.a.c.c(this.cIE);
        com.baidu.swan.b.a.a.a.sExecutorService.execute(new RunnableC0364b(parseString, this.cIs, this.cIF));
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
                com.baidu.swan.b.a.f.c.a(this.mPackageName, "installApp", "success", null, new com.baidu.swan.b.a.f.a(this.cIs));
            } else {
                com.baidu.swan.b.a.f.c.a(this.mPackageName, "installApp", "fail", String.valueOf(bVar.getStatus()), new com.baidu.swan.b.a.f.a(this.cIs));
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
        com.baidu.swan.b.a.f.c.a(this.mPackageName, "installApp", "fail", String.valueOf(31003), new com.baidu.swan.b.a.f.a(this.cIs));
        release();
    }

    private void release() {
        if (this.cIF != null) {
            com.baidu.swan.b.a.a.ati().e(this.mPackageName, this.cIF);
            this.cIF = null;
        }
        this.cIE = null;
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
    private static class RunnableC0364b implements Runnable {
        private JSONObject cIG;
        private com.baidu.swan.b.a.d.a cIH;
        private JSONObject cIs;

        private RunnableC0364b(@NonNull JSONObject jSONObject, JSONObject jSONObject2, @NonNull com.baidu.swan.b.a.d.a aVar) {
            this.cIG = jSONObject;
            this.cIs = jSONObject2;
            this.cIH = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.b.a.a.ati().bB(this.cIs);
            com.baidu.swan.b.a.f.c.a(this.cIG.optString("packageName"), "installApp", null, null, new com.baidu.swan.b.a.f.a(this.cIs));
            b.a(this.cIG, this.cIH);
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
