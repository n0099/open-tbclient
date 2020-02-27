package com.baidu.swan.b.a.c;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.swan.apps.as.s;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends ActivityDelegation {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private JSONObject cje;
    private c cjq = new c();
    private com.baidu.swan.b.a.c.c cjr;
    private String mPackageName;

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        if (DEBUG) {
            Log.d("InstallAppDelegation", "onExec mParams" + this.mParams);
        }
        this.cje = s.parseString(this.mParams.getString("ubc_params", ""));
        JSONObject parseString = s.parseString(this.mParams.getString("data", ""));
        this.mPackageName = parseString.optString("packageName");
        this.mResult.putString("packageName", this.mPackageName);
        this.cjr = new com.baidu.swan.b.a.c.c(this.cjq);
        com.baidu.swan.b.a.a.a.sExecutorService.execute(new RunnableC0313b(parseString, this.cje, this.cjr));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(@NonNull JSONObject jSONObject, @NonNull com.baidu.swan.b.a.d.a aVar) {
        com.baidu.swan.b.a.a.akQ().a(jSONObject.optString("url"), aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.b.a.e.b bVar) {
        if (bVar != null) {
            this.mResult.putString("functionType", bVar.getFunctionType());
            this.mResult.putString("resultData", bVar.getResult());
            this.mResult.putInt("resultStatus", bVar.getStatus());
            if (bVar.ald()) {
                com.baidu.swan.b.a.f.c.a(this.mPackageName, "installApp", "success", null, new com.baidu.swan.b.a.f.a(this.cje));
            } else {
                com.baidu.swan.b.a.f.c.a(this.mPackageName, "installApp", LivenessStat.TYPE_FACE_MATCH_FAIL, String.valueOf(bVar.getStatus()), new com.baidu.swan.b.a.f.a(this.cje));
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
        com.baidu.swan.b.a.f.c.a(this.mPackageName, "installApp", LivenessStat.TYPE_FACE_MATCH_FAIL, String.valueOf(31003), new com.baidu.swan.b.a.f.a(this.cje));
        release();
    }

    private void release() {
        if (this.cjr != null) {
            com.baidu.swan.b.a.a.akQ().e(this.mPackageName, this.cjr);
            this.cjr = null;
        }
        this.cjq = null;
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
    private static class RunnableC0313b implements Runnable {
        private JSONObject cje;
        private JSONObject cjs;
        private com.baidu.swan.b.a.d.a cjt;

        private RunnableC0313b(@NonNull JSONObject jSONObject, JSONObject jSONObject2, @NonNull com.baidu.swan.b.a.d.a aVar) {
            this.cjs = jSONObject;
            this.cje = jSONObject2;
            this.cjt = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.b.a.a.akQ().bq(this.cje);
            com.baidu.swan.b.a.f.c.a(this.cjs.optString("packageName"), "installApp", null, null, new com.baidu.swan.b.a.f.a(this.cje));
            b.a(this.cjs, this.cjt);
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
            com.baidu.swan.b.a.a.akQ().nY(this.mFilePath);
            com.baidu.swan.b.a.a.akQ().akS();
        }
    }
}
