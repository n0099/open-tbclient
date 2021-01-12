package com.baidu.swan.apps.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.adaptation.a.e;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.runtime.f;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends f {
    private final com.baidu.swan.apps.ao.d.c czX;
    private String czY;
    private boolean czZ;

    public b(e eVar) {
        super(eVar);
        this.czX = new com.baidu.swan.apps.ao.d.c();
        this.czZ = false;
    }

    private void a(a aVar) {
        this.czX.b(aVar);
    }

    public void a(final Activity activity, final Bundle bundle, com.baidu.swan.apps.a.a aVar) {
        a(new a(aVar) { // from class: com.baidu.swan.apps.a.b.1
            @Override // com.baidu.swan.apps.a.b.a
            protected void a(com.baidu.swan.apps.a.a aVar2) {
                com.baidu.swan.apps.t.a.awD().a(activity, bundle, aVar2);
            }
        });
    }

    public boolean isLogin(Context context) {
        return com.baidu.swan.apps.t.a.awD().ca(context);
    }

    public String getUid(@NonNull Context context) {
        String cb = com.baidu.swan.apps.t.a.awD().cb(context);
        setUid(cb);
        return cb;
    }

    @NonNull
    public String afQ() {
        if (this.czZ) {
            return TextUtils.isEmpty(this.czY) ? "" : this.czY;
        }
        return getUid(AppRuntime.getAppContext());
    }

    public void setUid(String str) {
        this.czY = str;
        this.czZ = true;
    }

    public synchronized void clear() {
        this.czX.clear();
    }

    public static void a(String str, final e.a aVar) {
        com.baidu.swan.a.c.a.bbL().getRequest().url("https://mbd.baidu.com/ma/relate2user").cookieManager(com.baidu.swan.apps.t.a.awX().aia()).addUrlParam("app_key", str).build().executeAsyncOnUIBack(new ResponseCallback<JSONObject>() { // from class: com.baidu.swan.apps.a.b.2
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
                    e.a.this.eJ(false);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null && optJSONObject.optBoolean("relate")) {
                    e.a.this.eJ(true);
                } else {
                    e.a.this.eJ(false);
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                e.a.this.n(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public abstract class a extends com.baidu.swan.apps.ao.d.a implements com.baidu.swan.apps.a.a {
        private final com.baidu.swan.apps.a.a cAd;

        protected abstract void a(com.baidu.swan.apps.a.a aVar);

        private a(com.baidu.swan.apps.a.a aVar) {
            this.cAd = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a(this);
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            if (this.cAd != null) {
                this.cAd.onResult(i);
            }
            finish();
        }
    }
}
