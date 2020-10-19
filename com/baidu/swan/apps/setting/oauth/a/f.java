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
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.api.module.a.b;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class f extends h<c> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected String dke;
    public b.a dkq;
    public b dkr = new b(Looper.getMainLooper(), this);
    public Bundle dks;
    protected JSONObject dkt;
    protected final Activity mActivity;

    public f(Activity activity, b.a aVar, Bundle bundle) {
        this.mActivity = activity;
        this.dkq = aVar;
        if (bundle != null && bundle.containsKey("__plugin__")) {
            this.dke = bundle.getString("__plugin__");
            bundle.remove("__plugin__");
        }
        this.dks = bundle;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aEP() {
        JSONObject jSONObject = new JSONObject();
        try {
            boolean isEmpty = TextUtils.isEmpty(this.dke);
            jSONObject.put("ma_id", isEmpty ? aFp().id : this.dke);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", isEmpty ? aFp().getAppKey() : this.dke);
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String adG = com.baidu.swan.apps.t.a.ass().adG();
            if (!TextUtils.isEmpty(adG)) {
                jSONObject2.put("host_api_key", adG);
            }
            jSONObject.put("open", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        co("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.h
    protected HttpRequest a(h hVar) {
        return com.baidu.swan.apps.t.a.ass().e(this.mActivity, hVar.aFq());
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aEO() {
        a(aFm());
        return super.aEO();
    }

    @NonNull
    protected com.baidu.swan.apps.setting.oauth.d aFm() {
        return new a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bT */
    public c bL(JSONObject jSONObject) throws JSONException {
        JSONObject bN = com.baidu.swan.apps.setting.oauth.c.bN(jSONObject);
        int optInt = bN.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new OAuthException(bN.optString(BaseJsonData.TAG_ERRMSG), optInt);
        }
        String str = "";
        JSONObject jSONObject2 = bN.getJSONObject("data");
        if (jSONObject2 != null) {
            str = jSONObject2.optString("code", "");
        }
        return new c(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    public void v(@Nullable Exception exc) {
        super.v(exc);
        if (DEBUG) {
            Log.d("LoginRequest", "finish: remove timeout msg");
        }
        this.dkr.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d implements com.baidu.swan.apps.a.a {
        private a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aEU() throws Exception {
            com.baidu.swan.apps.a.b aDn = f.this.aFp().aDn();
            boolean isLogin = aDn.isLogin(f.this.mActivity);
            if (f.DEBUG) {
                Log.d("LoginRequest", "LoginPreparation isLogin : " + isLogin + " call stack:" + Log.getStackTraceString(new Exception()));
            }
            if (!isLogin) {
                aDn.a(f.this.mActivity, f.this.dks, this);
            } else if (f.this.dkq != null && f.this.dkq.cjv) {
                long j = f.this.dkq.cjw;
                if (f.DEBUG) {
                    Log.d("LoginRequest", "send timeout " + j + "ms msg");
                }
                f.this.dkr.sendEmptyMessageDelayed(1, j >= 0 ? j : 0L);
            }
            return isLogin;
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
            switch (i) {
                case -2:
                    com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                    w(new OAuthException(10004));
                    return;
                case -1:
                default:
                    com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                    w(new OAuthException(10004));
                    return;
                case 0:
                    com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                    aEW();
                    return;
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class c {
        public final String code;

        private c(String str) {
            this.code = str == null ? "" : str;
        }

        public String toString() {
            return String.format("Result code(%s)", this.code);
        }
    }

    /* loaded from: classes10.dex */
    public static class b extends Handler {
        private WeakReference<f> dkv;

        private b(Looper looper, f fVar) {
            super(looper);
            this.dkv = new WeakReference<>(fVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f fVar = this.dkv.get();
            if (fVar != null) {
                switch (message.what) {
                    case 1:
                        if (f.DEBUG) {
                            Log.d("LoginRequest", "handleMessage: timeout");
                        }
                        com.baidu.swan.apps.setting.oauth.c.c("request timeout", true);
                        fVar.v(new OAuthException(10002));
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
