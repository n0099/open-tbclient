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
import com.baidu.swan.apps.api.module.a.b;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import java.lang.ref.WeakReference;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e extends g<c> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected String csX;
    public b.a ctj;
    public b ctk = new b(Looper.getMainLooper(), this);
    public Bundle ctl;
    protected JSONObject ctm;
    protected final Activity mActivity;

    public e(Activity activity, b.a aVar, Bundle bundle) {
        this.mActivity = activity;
        this.ctj = aVar;
        if (bundle != null && bundle.containsKey("__plugin__")) {
            this.csX = bundle.getString("__plugin__");
            bundle.remove("__plugin__");
        }
        this.ctl = bundle;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean amn() {
        JSONObject jSONObject = new JSONObject();
        try {
            boolean isEmpty = TextUtils.isEmpty(this.csX);
            jSONObject.put("ma_id", isEmpty ? ali().id : this.csX);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", isEmpty ? ali().getAppKey() : this.csX);
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String PQ = com.baidu.swan.apps.w.a.abZ().PQ();
            if (!TextUtils.isEmpty(PQ)) {
                jSONObject2.put("host_api_key", PQ);
            }
            jSONObject.put("open", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bu("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected Request a(g gVar) {
        return com.baidu.swan.apps.w.a.abZ().d(this.mActivity, gVar.amI());
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean amm() {
        a(amG());
        return super.amm();
    }

    @NonNull
    protected com.baidu.swan.apps.setting.oauth.d amG() {
        return new a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bg */
    public c aY(JSONObject jSONObject) throws JSONException {
        JSONObject ba = com.baidu.swan.apps.setting.oauth.c.ba(jSONObject);
        int optInt = ba.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new OAuthException(ba.optString(BaseJsonData.TAG_ERRMSG), optInt);
        }
        String str = "";
        JSONObject jSONObject2 = ba.getJSONObject("data");
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
        this.ctk.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d implements com.baidu.swan.apps.a.a {
        private a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean ams() throws Exception {
            com.baidu.swan.apps.a.b akX = e.this.ali().akX();
            boolean isLogin = akX.isLogin(e.this.mActivity);
            if (e.DEBUG) {
                Log.d("LoginRequest", "LoginPreparation isLogin : " + isLogin + " call stack:" + Log.getStackTraceString(new Exception()));
            }
            if (!isLogin) {
                akX.a(e.this.mActivity, e.this.ctl, this);
            }
            return isLogin;
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
            switch (i) {
                case -2:
                    com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                    m(new OAuthException(10004));
                    return;
                case -1:
                default:
                    com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                    m(new OAuthException(10004));
                    return;
                case 0:
                    com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                    amu();
                    return;
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class c {
        public final String code;

        private c(String str) {
            this.code = str == null ? "" : str;
        }

        public String toString() {
            return String.format("Result code(%s)", this.code);
        }
    }

    /* loaded from: classes11.dex */
    public static class b extends Handler {
        private WeakReference<e> cto;

        private b(Looper looper, e eVar) {
            super(looper);
            this.cto = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar = this.cto.get();
            if (eVar != null) {
                switch (message.what) {
                    case 1:
                        if (e.DEBUG) {
                            Log.d("LoginRequest", "handleMessage: timeout");
                        }
                        com.baidu.swan.apps.setting.oauth.c.c("request timeout", true);
                        eVar.l(new OAuthException(10002));
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
