package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.utils.SapiGIDEvent;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.a.g;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import java.lang.ref.WeakReference;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends g<c> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public g.a aVD;
    public b aVE = new b(Looper.getMainLooper(), this);
    public Bundle aVF;
    protected final Activity mActivity;

    public e(Activity activity, g.a aVar, Bundle bundle) {
        this.mActivity = activity;
        this.aVD = aVar;
        this.aVF = bundle;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean DS() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", My().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", My().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String wW = com.baidu.swan.apps.u.a.EA().wW();
            if (!TextUtils.isEmpty(wW)) {
                jSONObject2.put("host_api_key", wW);
            }
            jSONObject.put("open", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aA("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected Request a(g gVar) {
        return com.baidu.swan.apps.u.a.EA().d(this.mActivity, gVar.NC());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    public boolean DR() {
        a(DV());
        return super.DR();
    }

    @NonNull
    protected com.baidu.swan.apps.setting.oauth.d DV() {
        return new a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: ai */
    public c z(JSONObject jSONObject) throws JSONException {
        JSONObject af = com.baidu.swan.apps.setting.oauth.c.af(jSONObject);
        int optInt = af.optInt("errno", SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE);
        if (optInt != 0) {
            if (11001 == optInt) {
                com.baidu.swan.apps.setting.oauth.c.ae(af);
                com.baidu.swan.apps.setting.oauth.c.az("LoginRequest", af.toString());
            }
            throw new JSONException("Illegal errno=" + optInt + " errms=" + af.optString("errms"));
        }
        String str = "";
        JSONObject jSONObject2 = af.getJSONObject("data");
        if (jSONObject2 != null) {
            str = jSONObject2.optString("code", "");
        }
        return new c(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    public void l(@Nullable Exception exc) {
        super.l(exc);
        if (DEBUG) {
            Log.d("LoginRequest", "finish: remove timeout msg");
        }
        this.aVE.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d implements com.baidu.swan.apps.a.a {
        private a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean DU() throws Exception {
            com.baidu.swan.apps.a.b Mm = e.this.My().Mm();
            boolean aD = Mm.aD(e.this.mActivity);
            if (e.DEBUG) {
                Log.d("LoginRequest", "LoginPreparation isLogin : " + aD + " call stack:" + Log.getStackTraceString(new Exception()));
            }
            if (!aD) {
                Mm.a(e.this.mActivity, e.this.aVF, this);
            }
            return aD;
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            com.baidu.swan.apps.setting.oauth.c.a("onResult :: " + i, (Boolean) false);
            switch (i) {
                case -2:
                    com.baidu.swan.apps.setting.oauth.c.a("login error ERR_BY_UESR_REFUSE", (Boolean) true);
                    m(new OAuthException("login cancel by user", 10004));
                    return;
                case -1:
                default:
                    com.baidu.swan.apps.setting.oauth.c.a("login error ERR_BY_LOGIN", (Boolean) true);
                    m(new OAuthException("system login error", 10004));
                    return;
                case 0:
                    com.baidu.swan.apps.setting.oauth.c.a("Login Preparation ok, is already login", (Boolean) false);
                    Nx();
                    return;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public final String code;

        private c(String str) {
            this.code = str == null ? "" : str;
        }

        public String toString() {
            return String.format("Result code(%s)", this.code);
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends Handler {
        private WeakReference<e> aVH;

        private b(Looper looper, e eVar) {
            super(looper);
            this.aVH = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar = this.aVH.get();
            if (eVar != null) {
                switch (message.what) {
                    case 1:
                        if (e.DEBUG) {
                            Log.d("LoginRequest", "handleMessage: timeout");
                        }
                        eVar.l(new OAuthException("request timeout", 10007));
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
