package com.baidu.swan.apps.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.adaptation.a.e;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.runtime.f;
import com.baidu.swan.apps.v.b.b;
import com.baidu.swan.e.g;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends f {
    private static final String TAG = b.class.getSimpleName();
    private final com.baidu.swan.apps.aq.d.c bLZ;
    private String bMa;

    public b(e eVar) {
        super(eVar);
        b.a RP;
        this.bLZ = new com.baidu.swan.apps.aq.d.c();
        String str = "";
        if (eVar != null && (RP = eVar.RP()) != null) {
            str = RP.ahW().getString("extra_data_uid_key", "");
        }
        setUid(str);
    }

    private void a(a aVar) {
        this.bLZ.b(aVar);
    }

    public void a(final Activity activity, final Bundle bundle, com.baidu.swan.apps.a.a aVar) {
        a(new a(aVar) { // from class: com.baidu.swan.apps.a.b.1
            @Override // com.baidu.swan.apps.a.b.a
            protected void a(com.baidu.swan.apps.a.a aVar2) {
                com.baidu.swan.apps.u.a.agc().a(activity, bundle, aVar2);
            }
        });
    }

    public boolean isLogin(Context context) {
        return com.baidu.swan.apps.u.a.agc().bb(context);
    }

    public String getUid(@NonNull Context context) {
        String bc = com.baidu.swan.apps.u.a.agc().bc(context);
        setUid(bc);
        return bc;
    }

    @NonNull
    public String Sd() {
        return TextUtils.isEmpty(this.bMa) ? "" : this.bMa;
    }

    public void setUid(String str) {
        this.bMa = str;
    }

    public synchronized void clear() {
        this.bLZ.clear();
    }

    public static void a(String str, final e.a aVar) {
        com.baidu.swan.c.c.a.aGD().getRequest().url("https://mbd.baidu.com/ma/relate2user").cookieManager(com.baidu.swan.apps.u.a.agu().TS()).addUrlParam("app_key", str).build().executeAsyncOnUIBack(new ResponseCallback<JSONObject>() { // from class: com.baidu.swan.apps.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public JSONObject parseResponse(Response response, int i) throws Exception {
                if (response == null || response.body() == null) {
                    return null;
                }
                return new JSONObject(g.streamToString(response.body().byteStream()));
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public void onSuccess(JSONObject jSONObject, int i) {
                if (jSONObject == null) {
                    com.baidu.swan.apps.console.c.e(b.TAG, "Response is null");
                    e.a.this.dk(false);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null && optJSONObject.optBoolean("relate")) {
                    e.a.this.dk(true);
                } else {
                    e.a.this.dk(false);
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                e.a.this.m(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public abstract class a extends com.baidu.swan.apps.aq.d.a implements com.baidu.swan.apps.a.a {
        private final com.baidu.swan.apps.a.a bMe;

        protected abstract void a(com.baidu.swan.apps.a.a aVar);

        private a(com.baidu.swan.apps.a.a aVar) {
            this.bMe = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a(this);
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            if (this.bMe != null) {
                this.bMe.onResult(i);
            }
            finish();
        }
    }
}
