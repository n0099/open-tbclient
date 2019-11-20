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
    public g.a bop;
    public b boq = new b(Looper.getMainLooper(), this);
    public Bundle bor;
    protected final Activity mActivity;

    public e(Activity activity, g.a aVar, Bundle bundle) {
        this.mActivity = activity;
        this.bop = aVar;
        this.bor = bundle;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean IN() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", Rs().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", Rs().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String BR = com.baidu.swan.apps.u.a.Jv().BR();
            if (!TextUtils.isEmpty(BR)) {
                jSONObject2.put("host_api_key", BR);
            }
            jSONObject.put("open", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aI("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected Request a(g gVar) {
        return com.baidu.swan.apps.u.a.Jv().d(this.mActivity, gVar.Su());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    public boolean IM() {
        a(IQ());
        return super.IM();
    }

    @NonNull
    protected com.baidu.swan.apps.setting.oauth.d IQ() {
        return new a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: aH */
    public c Y(JSONObject jSONObject) throws JSONException {
        JSONObject aE = com.baidu.swan.apps.setting.oauth.c.aE(jSONObject);
        int optInt = aE.optInt("errno", 11001);
        if (optInt != 0) {
            if (11001 == optInt) {
                com.baidu.swan.apps.setting.oauth.c.aD(aE);
                com.baidu.swan.apps.setting.oauth.c.aH("LoginRequest", aE.toString());
            }
            throw new JSONException("Illegal errno=" + optInt + " errms=" + aE.optString("errms"));
        }
        String str = "";
        JSONObject jSONObject2 = aE.getJSONObject("data");
        if (jSONObject2 != null) {
            str = jSONObject2.optString("code", "");
        }
        return new c(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    public void k(@Nullable Exception exc) {
        super.k(exc);
        if (DEBUG) {
            Log.d("LoginRequest", "finish: remove timeout msg");
        }
        this.boq.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d implements com.baidu.swan.apps.a.a {
        private a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean IP() throws Exception {
            com.baidu.swan.apps.a.b Rg = e.this.Rs().Rg();
            boolean isLogin = Rg.isLogin(e.this.mActivity);
            if (e.DEBUG) {
                Log.d("LoginRequest", "LoginPreparation isLogin : " + isLogin + " call stack:" + Log.getStackTraceString(new Exception()));
            }
            if (!isLogin) {
                Rg.a(e.this.mActivity, e.this.bor, this);
            }
            return isLogin;
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            com.baidu.swan.apps.setting.oauth.c.a("onResult :: " + i, (Boolean) false);
            switch (i) {
                case -2:
                    com.baidu.swan.apps.setting.oauth.c.a("login error ERR_BY_UESR_REFUSE", (Boolean) true);
                    l(new OAuthException("login cancel by user", 10004));
                    return;
                case -1:
                default:
                    com.baidu.swan.apps.setting.oauth.c.a("login error ERR_BY_LOGIN", (Boolean) true);
                    l(new OAuthException("system login error", 10004));
                    return;
                case 0:
                    com.baidu.swan.apps.setting.oauth.c.a("Login Preparation ok, is already login", (Boolean) false);
                    Sp();
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
        private WeakReference<e> bot;

        private b(Looper looper, e eVar) {
            super(looper);
            this.bot = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar = this.bot.get();
            if (eVar != null) {
                switch (message.what) {
                    case 1:
                        if (e.DEBUG) {
                            Log.d("LoginRequest", "handleMessage: timeout");
                        }
                        eVar.k(new OAuthException("request timeout", 10007));
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
