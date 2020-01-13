package com.baidu.swan.b.a.c;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.swan.apps.as.s;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends ActivityDelegation {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private JSONObject cfa;
    private c cfm = new c();
    private com.baidu.swan.b.a.c.c cfn;
    private String mPackageName;

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        if (DEBUG) {
            Log.d("InstallAppDelegation", "onExec mParams" + this.mParams);
        }
        this.cfa = s.parseString(this.mParams.getString("ubc_params", ""));
        JSONObject parseString = s.parseString(this.mParams.getString("data", ""));
        this.mPackageName = parseString.optString("packageName");
        this.mResult.putString("packageName", this.mPackageName);
        this.cfn = new com.baidu.swan.b.a.c.c(this.cfm);
        com.baidu.swan.b.a.a.a.sExecutorService.execute(new RunnableC0303b(parseString, this.cfa, this.cfn));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(@NonNull JSONObject jSONObject, @NonNull com.baidu.swan.b.a.d.a aVar) {
        com.baidu.swan.b.a.a.aiC().a(jSONObject.optString("url"), aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.b.a.e.b bVar) {
        if (bVar != null) {
            this.mResult.putString("functionType", bVar.getFunctionType());
            this.mResult.putString("resultData", bVar.getResult());
            this.mResult.putInt("resultStatus", bVar.getStatus());
            if (bVar.aiP()) {
                com.baidu.swan.b.a.f.c.a(this.mPackageName, "installApp", "success", null, new com.baidu.swan.b.a.f.a(this.cfa));
            } else {
                com.baidu.swan.b.a.f.c.a(this.mPackageName, "installApp", LivenessStat.TYPE_FACE_MATCH_FAIL, String.valueOf(bVar.getStatus()), new com.baidu.swan.b.a.f.a(this.cfa));
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
        com.baidu.swan.b.a.f.c.a(this.mPackageName, "installApp", LivenessStat.TYPE_FACE_MATCH_FAIL, String.valueOf(31003), new com.baidu.swan.b.a.f.a(this.cfa));
        release();
    }

    private void release() {
        if (this.cfn != null) {
            com.baidu.swan.b.a.a.aiC().e(this.mPackageName, this.cfn);
            this.cfn = null;
        }
        this.cfm = null;
    }

    /* loaded from: classes10.dex */
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
    /* loaded from: classes10.dex */
    private static class RunnableC0303b implements Runnable {
        private JSONObject cfa;
        private JSONObject cfo;
        private com.baidu.swan.b.a.d.a cfp;

        private RunnableC0303b(@NonNull JSONObject jSONObject, JSONObject jSONObject2, @NonNull com.baidu.swan.b.a.d.a aVar) {
            this.cfo = jSONObject;
            this.cfa = jSONObject2;
            this.cfp = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.b.a.a.aiC().bq(this.cfa);
            com.baidu.swan.b.a.f.c.a(this.cfo.optString("packageName"), "installApp", null, null, new com.baidu.swan.b.a.f.a(this.cfa));
            b.a(this.cfo, this.cfp);
        }
    }

    /* loaded from: classes10.dex */
    private static class a implements Runnable {
        private String mFilePath;

        private a(String str) {
            this.mFilePath = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.b.a.a.aiC().nJ(this.mFilePath);
            com.baidu.swan.b.a.a.aiC().aiE();
        }
    }
}
