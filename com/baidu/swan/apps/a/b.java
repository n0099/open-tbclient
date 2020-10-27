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
/* loaded from: classes10.dex */
public class b extends f {
    private final com.baidu.swan.apps.ap.d.c coM;
    private String coN;
    private boolean coO;

    public b(e eVar) {
        super(eVar);
        this.coM = new com.baidu.swan.apps.ap.d.c();
        this.coO = false;
    }

    private void a(a aVar) {
        this.coM.b(aVar);
    }

    public void a(final Activity activity, final Bundle bundle, com.baidu.swan.apps.a.a aVar) {
        a(new a(aVar) { // from class: com.baidu.swan.apps.a.b.1
            @Override // com.baidu.swan.apps.a.b.a
            protected void a(com.baidu.swan.apps.a.a aVar2) {
                com.baidu.swan.apps.t.a.auf().a(activity, bundle, aVar2);
            }
        });
    }

    public boolean isLogin(Context context) {
        return com.baidu.swan.apps.t.a.auf().bo(context);
    }

    public String getUid(@NonNull Context context) {
        String bp = com.baidu.swan.apps.t.a.auf().bp(context);
        setUid(bp);
        return bp;
    }

    @NonNull
    public String adC() {
        if (this.coO) {
            return TextUtils.isEmpty(this.coN) ? "" : this.coN;
        }
        return getUid(AppRuntime.getAppContext());
    }

    public void setUid(String str) {
        this.coN = str;
        this.coO = true;
    }

    public synchronized void clear() {
        this.coM.clear();
    }

    public static void a(String str, final e.a aVar) {
        com.baidu.swan.a.c.a.aYk().getRequest().url("https://mbd.baidu.com/ma/relate2user").cookieManager(com.baidu.swan.apps.t.a.auz().afJ()).addUrlParam("app_key", str).build().executeAsyncOnUIBack(new ResponseCallback<JSONObject>() { // from class: com.baidu.swan.apps.a.b.2
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
                    e.a.this.ed(false);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null && optJSONObject.optBoolean("relate")) {
                    e.a.this.ed(true);
                } else {
                    e.a.this.ed(false);
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                e.a.this.m(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public abstract class a extends com.baidu.swan.apps.ap.d.a implements com.baidu.swan.apps.a.a {
        private final com.baidu.swan.apps.a.a coS;

        protected abstract void a(com.baidu.swan.apps.a.a aVar);

        private a(com.baidu.swan.apps.a.a aVar) {
            this.coS = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a(this);
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            if (this.coS != null) {
                this.coS.onResult(i);
            }
            finish();
        }
    }
}
