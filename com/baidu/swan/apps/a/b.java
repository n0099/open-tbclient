package com.baidu.swan.apps.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.adaptation.a.e;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.runtime.f;
import com.baidu.swan.apps.u.c.b;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends f {
    private static final String TAG = b.class.getSimpleName();
    private Boolean bMA;
    private boolean bMB;
    private final com.baidu.swan.apps.aq.d.c bMy;
    private String bMz;

    public b(e eVar) {
        super(eVar);
        b.a Se;
        this.bMy = new com.baidu.swan.apps.aq.d.c();
        this.bMB = false;
        if (!com.baidu.swan.apps.performance.b.b.aoo()) {
            String str = "";
            if (eVar != null && (Se = eVar.Se()) != null) {
                str = Se.ajm().getString("extra_data_uid_key", "");
            }
            setUid(str);
        }
    }

    private void a(a aVar) {
        this.bMy.b(aVar);
    }

    public void a(final Activity activity, final Bundle bundle, com.baidu.swan.apps.a.a aVar) {
        a(new a(aVar) { // from class: com.baidu.swan.apps.a.b.1
            @Override // com.baidu.swan.apps.a.b.a
            protected void a(com.baidu.swan.apps.a.a aVar2) {
                com.baidu.swan.apps.t.a.aho().a(activity, bundle, aVar2);
            }
        });
    }

    public boolean isLogin(Context context) {
        if (!com.baidu.swan.apps.performance.b.b.aon()) {
            return com.baidu.swan.apps.t.a.aho().bd(context);
        }
        if (this.bMA == null) {
            this.bMA = Boolean.valueOf(com.baidu.swan.apps.t.a.aho().bd(context));
        }
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d(TAG, "isLogin hit cache");
        }
        return this.bMA.booleanValue();
    }

    public void bb(Context context) {
        if (com.baidu.swan.apps.performance.b.b.aon()) {
            this.bMA = Boolean.valueOf(com.baidu.swan.apps.t.a.aho().bd(context));
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.d(TAG, "syncLoginStatus by login status changed");
            }
        }
    }

    public String getUid(@NonNull Context context) {
        String be = com.baidu.swan.apps.t.a.aho().be(context);
        setUid(be);
        return be;
    }

    @NonNull
    public String Ss() {
        if (!com.baidu.swan.apps.performance.b.b.aoo() || this.bMB) {
            return TextUtils.isEmpty(this.bMz) ? "" : this.bMz;
        }
        return getUid(AppRuntime.getAppContext());
    }

    public void setUid(String str) {
        this.bMz = str;
        this.bMB = true;
    }

    public synchronized void clear() {
        this.bMy.clear();
    }

    public static void a(String str, final e.a aVar) {
        com.baidu.swan.b.c.a.aKu().getRequest().url("https://mbd.baidu.com/ma/relate2user").cookieManager(com.baidu.swan.apps.t.a.ahH().Us()).addUrlParam("app_key", str).build().executeAsyncOnUIBack(new ResponseCallback<JSONObject>() { // from class: com.baidu.swan.apps.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public JSONObject parseResponse(Response response, int i) throws Exception {
                if (response == null || response.body() == null) {
                    return null;
                }
                return new JSONObject(com.baidu.swan.d.f.streamToString(response.body().byteStream()));
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public void onSuccess(JSONObject jSONObject, int i) {
                if (jSONObject == null) {
                    com.baidu.swan.apps.console.c.e(b.TAG, "Response is null");
                    e.a.this.dn(false);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null && optJSONObject.optBoolean("relate")) {
                    e.a.this.dn(true);
                } else {
                    e.a.this.dn(false);
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                e.a.this.m(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public abstract class a extends com.baidu.swan.apps.aq.d.a implements com.baidu.swan.apps.a.a {
        private final com.baidu.swan.apps.a.a bMF;

        protected abstract void a(com.baidu.swan.apps.a.a aVar);

        private a(com.baidu.swan.apps.a.a aVar) {
            this.bMF = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a(this);
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            if (this.bMF != null) {
                this.bMF.onResult(i);
            }
            finish();
        }
    }
}
