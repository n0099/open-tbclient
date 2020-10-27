package com.baidu.swan.gamecenter.appmanager.install;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.swan.apps.ap.v;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends ActivityDelegation {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private JSONObject dJI;
    private c dJZ = new c();
    private String mPackageName;

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        if (DEBUG) {
            Log.d("InstallAppDelegation", "onExec mParams" + this.mParams);
        }
        this.dJI = v.parseString(this.mParams.getString("ubc_params", ""));
        JSONObject parseString = v.parseString(this.mParams.getString("data", ""));
        this.mPackageName = parseString.optString("packageName");
        this.mResult.putString("packageName", this.mPackageName);
        com.baidu.swan.gamecenter.appmanager.a.b.sExecutorService.execute(new RunnableC0512b(parseString, this.dJI, this.dJZ));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(@NonNull JSONObject jSONObject, @NonNull com.baidu.swan.gamecenter.appmanager.b.a aVar) {
        com.baidu.swan.gamecenter.appmanager.a.aPp().a(jSONObject.optString("url"), aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
        if (bVar != null) {
            this.mResult.putString("functionType", bVar.aPR());
            this.mResult.putString("resultData", bVar.getResult());
            this.mResult.putInt("resultStatus", bVar.getStatus());
            if (!bVar.aPQ()) {
                com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, "installApp", "fail", String.valueOf(bVar.getStatus()), new com.baidu.swan.gamecenter.appmanager.d.a(this.dJI));
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
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, "installApp", "fail", String.valueOf(31003), new com.baidu.swan.gamecenter.appmanager.d.a(this.dJI));
        release();
    }

    private void release() {
        if (this.dJZ != null) {
            com.baidu.swan.gamecenter.appmanager.a.aPp().e(this.mPackageName, this.dJZ);
            this.dJZ = null;
        }
        this.dJZ = null;
    }

    /* loaded from: classes6.dex */
    public class c implements com.baidu.swan.gamecenter.appmanager.b.a {
        private String mFilePath;
        private String mPackageName;

        public c() {
        }

        @Override // com.baidu.swan.gamecenter.appmanager.b.b
        public void a(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
            if (b.DEBUG) {
                Log.d("InstallAppDelegation", "onResult mPackageName:" + this.mPackageName);
            }
            b.this.b(bVar);
            com.baidu.swan.gamecenter.appmanager.a.b.sExecutorService.execute(new a(this.mFilePath));
        }

        @Override // com.baidu.swan.gamecenter.appmanager.b.a
        public void setPackageName(String str) {
            this.mPackageName = str;
        }

        @Override // com.baidu.swan.gamecenter.appmanager.b.a
        public void setFilePath(String str) {
            this.mFilePath = str;
        }
    }

    /* renamed from: com.baidu.swan.gamecenter.appmanager.install.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private static class RunnableC0512b implements Runnable {
        private JSONObject dJI;
        private JSONObject dKa;
        private com.baidu.swan.gamecenter.appmanager.b.a dKb;

        private RunnableC0512b(@NonNull JSONObject jSONObject, JSONObject jSONObject2, @NonNull com.baidu.swan.gamecenter.appmanager.b.a aVar) {
            this.dKa = jSONObject;
            this.dJI = jSONObject2;
            this.dKb = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.gamecenter.appmanager.a.aPp().cf(this.dJI);
            com.baidu.swan.gamecenter.appmanager.d.c.a(this.dKa.optString("packageName"), "installApp", null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dJI));
            b.a(this.dKa, this.dKb);
        }
    }

    /* loaded from: classes6.dex */
    private static class a implements Runnable {
        private String mFilePath;

        private a(String str) {
            this.mFilePath = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.gamecenter.appmanager.a.aPp().vF(this.mFilePath);
            com.baidu.swan.gamecenter.appmanager.a.aPp().aPt();
        }
    }
}
