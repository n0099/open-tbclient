package com.baidu.swan.gamecenter.appmanager.install;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.swan.apps.ap.v;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends ActivityDelegation {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private JSONObject dPA;
    private c dPR = new c();
    private String mPackageName;

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        if (DEBUG) {
            Log.d("InstallAppDelegation", "onExec mParams" + this.mParams);
        }
        this.dPA = v.parseString(this.mParams.getString("ubc_params", ""));
        JSONObject parseString = v.parseString(this.mParams.getString("data", ""));
        this.mPackageName = parseString.optString("packageName");
        this.mResult.putString("packageName", this.mPackageName);
        com.baidu.swan.gamecenter.appmanager.a.b.sExecutorService.execute(new RunnableC0524b(parseString, this.dPA, this.dPR));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(@NonNull JSONObject jSONObject, @NonNull com.baidu.swan.gamecenter.appmanager.b.a aVar) {
        com.baidu.swan.gamecenter.appmanager.a.aRP().a(jSONObject.optString("url"), aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
        if (bVar != null) {
            this.mResult.putString("functionType", bVar.aSr());
            this.mResult.putString("resultData", bVar.getResult());
            this.mResult.putInt("resultStatus", bVar.getStatus());
            if (!bVar.aSq()) {
                com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, "installApp", "fail", String.valueOf(bVar.getStatus()), new com.baidu.swan.gamecenter.appmanager.d.a(this.dPA));
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
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, "installApp", "fail", String.valueOf(31003), new com.baidu.swan.gamecenter.appmanager.d.a(this.dPA));
        release();
    }

    private void release() {
        if (this.dPR != null) {
            com.baidu.swan.gamecenter.appmanager.a.aRP().e(this.mPackageName, this.dPR);
            this.dPR = null;
        }
        this.dPR = null;
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
    private static class RunnableC0524b implements Runnable {
        private JSONObject dPA;
        private JSONObject dPS;
        private com.baidu.swan.gamecenter.appmanager.b.a dPT;

        private RunnableC0524b(@NonNull JSONObject jSONObject, JSONObject jSONObject2, @NonNull com.baidu.swan.gamecenter.appmanager.b.a aVar) {
            this.dPS = jSONObject;
            this.dPA = jSONObject2;
            this.dPT = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.gamecenter.appmanager.a.aRP().cl(this.dPA);
            com.baidu.swan.gamecenter.appmanager.d.c.a(this.dPS.optString("packageName"), "installApp", null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dPA));
            b.a(this.dPS, this.dPT);
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
            com.baidu.swan.gamecenter.appmanager.a.aRP().vT(this.mFilePath);
            com.baidu.swan.gamecenter.appmanager.a.aRP().aRT();
        }
    }
}
