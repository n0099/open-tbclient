package com.baidu.swan.gamecenter.appmanager.install;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.swan.apps.ap.v;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class b extends ActivityDelegation {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private JSONObject dph;
    private c dpy = new c();
    private String mPackageName;

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        if (DEBUG) {
            Log.d("InstallAppDelegation", "onExec mParams" + this.mParams);
        }
        this.dph = v.parseString(this.mParams.getString("ubc_params", ""));
        JSONObject parseString = v.parseString(this.mParams.getString("data", ""));
        this.mPackageName = parseString.optString("packageName");
        this.mResult.putString("packageName", this.mPackageName);
        com.baidu.swan.gamecenter.appmanager.a.b.sExecutorService.execute(new RunnableC0481b(parseString, this.dph, this.dpy));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(@NonNull JSONObject jSONObject, @NonNull com.baidu.swan.gamecenter.appmanager.b.a aVar) {
        com.baidu.swan.gamecenter.appmanager.a.aKM().a(jSONObject.optString("url"), aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
        if (bVar != null) {
            this.mResult.putString("functionType", bVar.aLo());
            this.mResult.putString("resultData", bVar.getResult());
            this.mResult.putInt("resultStatus", bVar.getStatus());
            if (!bVar.aLn()) {
                com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, "installApp", "fail", String.valueOf(bVar.getStatus()), new com.baidu.swan.gamecenter.appmanager.d.a(this.dph));
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
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, "installApp", "fail", String.valueOf(31003), new com.baidu.swan.gamecenter.appmanager.d.a(this.dph));
        release();
    }

    private void release() {
        if (this.dpy != null) {
            com.baidu.swan.gamecenter.appmanager.a.aKM().e(this.mPackageName, this.dpy);
            this.dpy = null;
        }
        this.dpy = null;
    }

    /* loaded from: classes14.dex */
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
    /* loaded from: classes14.dex */
    private static class RunnableC0481b implements Runnable {
        private com.baidu.swan.gamecenter.appmanager.b.a dpA;
        private JSONObject dph;
        private JSONObject dpz;

        private RunnableC0481b(@NonNull JSONObject jSONObject, JSONObject jSONObject2, @NonNull com.baidu.swan.gamecenter.appmanager.b.a aVar) {
            this.dpz = jSONObject;
            this.dph = jSONObject2;
            this.dpA = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.gamecenter.appmanager.a.aKM().bV(this.dph);
            com.baidu.swan.gamecenter.appmanager.d.c.a(this.dpz.optString("packageName"), "installApp", null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dph));
            b.a(this.dpz, this.dpA);
        }
    }

    /* loaded from: classes14.dex */
    private static class a implements Runnable {
        private String mFilePath;

        private a(String str) {
            this.mFilePath = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.gamecenter.appmanager.a.aKM().uA(this.mFilePath);
            com.baidu.swan.gamecenter.appmanager.a.aKM().aKQ();
        }
    }
}
