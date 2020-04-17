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
    private final com.baidu.swan.apps.as.c.c bzC;
    private String bzD;

    public b(e eVar) {
        super(eVar);
        b.a Ow;
        this.bzC = new com.baidu.swan.apps.as.c.c();
        String str = "";
        if (eVar != null && (Ow = eVar.Ow()) != null) {
            str = Ow.adH().getString("extra_data_uid_key", "");
        }
        setUid(str);
    }

    private void a(a aVar) {
        this.bzC.b(aVar);
    }

    public void a(final Activity activity, final Bundle bundle, com.baidu.swan.apps.a.a aVar) {
        a(new a(aVar) { // from class: com.baidu.swan.apps.a.b.1
            @Override // com.baidu.swan.apps.a.b.a
            protected void a(com.baidu.swan.apps.a.a aVar2) {
                com.baidu.swan.apps.w.a.abT().a(activity, bundle, aVar2);
            }
        });
    }

    public boolean isLogin(Context context) {
        return com.baidu.swan.apps.w.a.abT().bc(context);
    }

    public String getUid(@NonNull Context context) {
        String bd = com.baidu.swan.apps.w.a.abT().bd(context);
        setUid(bd);
        return bd;
    }

    @NonNull
    public String OM() {
        return TextUtils.isEmpty(this.bzD) ? "" : this.bzD;
    }

    public void setUid(String str) {
        this.bzD = str;
    }

    public synchronized void clear() {
        this.bzC.clear();
    }

    public static void a(String str, final e.a aVar) {
        HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url("https://mbd.baidu.com/ma/relate2user").cookieManager(com.baidu.swan.apps.w.a.acm().Qj()).addUrlParam("app_key", str).build().executeAsyncOnUIBack(new ResponseCallback<JSONObject>() { // from class: com.baidu.swan.apps.a.b.2
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
                e.a.this.j(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public abstract class a extends com.baidu.swan.apps.as.c.a implements com.baidu.swan.apps.a.a {
        private final com.baidu.swan.apps.a.a bzH;

        protected abstract void a(com.baidu.swan.apps.a.a aVar);

        private a(com.baidu.swan.apps.a.a aVar) {
            this.bzH = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a(this);
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            if (this.bzH != null) {
                this.bzH.onResult(i);
            }
            finish();
        }
    }
}
