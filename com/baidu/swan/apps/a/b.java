package com.baidu.swan.apps.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.adaptation.a.e;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.runtime.f;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class b extends f {
    private final com.baidu.swan.apps.ap.d.c czT;
    private String czU;
    private boolean czV;

    public b(e eVar) {
        super(eVar);
        this.czT = new com.baidu.swan.apps.ap.d.c();
        this.czV = false;
    }

    private void a(a aVar) {
        this.czT.b(aVar);
    }

    public void a(final Activity activity, final Bundle bundle, com.baidu.swan.apps.a.a aVar) {
        a(new a(aVar) { // from class: com.baidu.swan.apps.a.b.1
            @Override // com.baidu.swan.apps.a.b.a
            protected void a(com.baidu.swan.apps.a.a aVar2) {
                com.baidu.swan.apps.t.a.azf().a(activity, bundle, aVar2);
            }
        });
    }

    public boolean isLogin(Context context) {
        return com.baidu.swan.apps.t.a.azf().bU(context);
    }

    public String getUid(@NonNull Context context) {
        String bV = com.baidu.swan.apps.t.a.azf().bV(context);
        setUid(bV);
        return bV;
    }

    @NonNull
    public String aiC() {
        if (this.czV) {
            return TextUtils.isEmpty(this.czU) ? "" : this.czU;
        }
        return getUid(AppRuntime.getAppContext());
    }

    public void setUid(String str) {
        this.czU = str;
        this.czV = true;
    }

    public synchronized void clear() {
        this.czT.clear();
    }

    public static void a(String str, final e.a aVar) {
        com.baidu.swan.a.c.a.bdi().getRequest().url("https://mbd.baidu.com/ma/relate2user").cookieManager(com.baidu.swan.apps.t.a.azz().akJ()).addUrlParam("app_key", str).build().executeAsyncOnUIBack(new ResponseCallback<JSONObject>() { // from class: com.baidu.swan.apps.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public JSONObject parseResponse(Response response, int i) throws Exception {
                if (response == null || response.body() == null) {
                    return null;
                }
                return new JSONObject(com.baidu.swan.c.f.streamToString(response.body().byteStream()));
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public void onSuccess(JSONObject jSONObject, int i) {
                if (jSONObject == null) {
                    com.baidu.swan.apps.console.c.e("SwanAppAccount", "Response is null");
                    e.a.this.eE(false);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null && optJSONObject.optBoolean("relate")) {
                    e.a.this.eE(true);
                } else {
                    e.a.this.eE(false);
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                e.a.this.m(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public abstract class a extends com.baidu.swan.apps.ap.d.a implements com.baidu.swan.apps.a.a {
        private final com.baidu.swan.apps.a.a czZ;

        protected abstract void a(com.baidu.swan.apps.a.a aVar);

        private a(com.baidu.swan.apps.a.a aVar) {
            this.czZ = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a(this);
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            if (this.czZ != null) {
                this.czZ.onResult(i);
            }
            finish();
        }
    }
}
