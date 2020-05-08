package com.baidu.swan.apps.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.adaptation.a.e;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.runtime.f;
import com.baidu.swan.apps.x.b.b;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends f {
    private static final String TAG = b.class.getSimpleName();
    private final com.baidu.swan.apps.as.c.c bzH;
    private String bzI;

    public b(e eVar) {
        super(eVar);
        b.a Ov;
        this.bzH = new com.baidu.swan.apps.as.c.c();
        String str = "";
        if (eVar != null && (Ov = eVar.Ov()) != null) {
            str = Ov.adG().getString("extra_data_uid_key", "");
        }
        setUid(str);
    }

    private void a(a aVar) {
        this.bzH.b(aVar);
    }

    public void a(final Activity activity, final Bundle bundle, com.baidu.swan.apps.a.a aVar) {
        a(new a(aVar) { // from class: com.baidu.swan.apps.a.b.1
            @Override // com.baidu.swan.apps.a.b.a
            protected void a(com.baidu.swan.apps.a.a aVar2) {
                com.baidu.swan.apps.w.a.abS().a(activity, bundle, aVar2);
            }
        });
    }

    public boolean isLogin(Context context) {
        return com.baidu.swan.apps.w.a.abS().aQ(context);
    }

    public String getUid(@NonNull Context context) {
        String aR = com.baidu.swan.apps.w.a.abS().aR(context);
        setUid(aR);
        return aR;
    }

    @NonNull
    public String OL() {
        return TextUtils.isEmpty(this.bzI) ? "" : this.bzI;
    }

    public void setUid(String str) {
        this.bzI = str;
    }

    public synchronized void clear() {
        this.bzH.clear();
    }

    public static void a(String str, final e.a aVar) {
        HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url("https://mbd.baidu.com/ma/relate2user").cookieManager(com.baidu.swan.apps.w.a.acl().Qi()).addUrlParam("app_key", str).build().executeAsyncOnUIBack(new ResponseCallback<JSONObject>() { // from class: com.baidu.swan.apps.a.b.2
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
                    e.a.this.cS(false);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null && optJSONObject.optBoolean("relate")) {
                    e.a.this.cS(true);
                } else {
                    e.a.this.cS(false);
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                e.a.this.k(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public abstract class a extends com.baidu.swan.apps.as.c.a implements com.baidu.swan.apps.a.a {
        private final com.baidu.swan.apps.a.a bzM;

        protected abstract void a(com.baidu.swan.apps.a.a aVar);

        private a(com.baidu.swan.apps.a.a aVar) {
            this.bzM = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a(this);
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            if (this.bzM != null) {
                this.bzM.onResult(i);
            }
            finish();
        }
    }
}
