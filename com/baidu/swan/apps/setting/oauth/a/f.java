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
/* loaded from: classes25.dex */
public class f extends h<c> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected String dDQ;
    public b.a dEc;
    public b dEd = new b(Looper.getMainLooper(), this);
    public Bundle dEe;
    protected JSONObject dEf;
    protected final Activity mActivity;

    public f(Activity activity, b.a aVar, Bundle bundle) {
        this.mActivity = activity;
        this.dEc = aVar;
        if (bundle != null && bundle.containsKey("__plugin__")) {
            this.dDQ = bundle.getString("__plugin__");
            bundle.remove("__plugin__");
        }
        this.dEe = bundle;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aLJ() {
        JSONObject jSONObject = new JSONObject();
        try {
            boolean isEmpty = TextUtils.isEmpty(this.dDQ);
            jSONObject.put("ma_id", isEmpty ? aMj().id : this.dDQ);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", isEmpty ? aMj().getAppKey() : this.dDQ);
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String akA = com.baidu.swan.apps.t.a.azm().akA();
            if (!TextUtils.isEmpty(akA)) {
                jSONObject2.put("host_api_key", akA);
            }
            jSONObject.put("open", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        cB("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.h
    protected HttpRequest a(h hVar) {
        return com.baidu.swan.apps.t.a.azm().e(this.mActivity, hVar.aMk());
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aLI() {
        a(aMg());
        return super.aLI();
    }

    @NonNull
    protected com.baidu.swan.apps.setting.oauth.d aMg() {
        return new a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bY */
    public c bQ(JSONObject jSONObject) throws JSONException {
        JSONObject bS = com.baidu.swan.apps.setting.oauth.c.bS(jSONObject);
        int optInt = bS.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new OAuthException(bS.optString(BaseJsonData.TAG_ERRMSG), optInt);
        }
        String str = "";
        JSONObject jSONObject2 = bS.getJSONObject("data");
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
        this.dEd.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d implements com.baidu.swan.apps.a.a {
        private a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean aLO() throws Exception {
            com.baidu.swan.apps.a.b aKh = f.this.aMj().aKh();
            boolean isLogin = aKh.isLogin(f.this.mActivity);
            if (f.DEBUG) {
                Log.d("LoginRequest", "LoginPreparation isLogin : " + isLogin + " call stack:" + Log.getStackTraceString(new Exception()));
            }
            if (!isLogin) {
                aKh.a(f.this.mActivity, f.this.dEe, this);
            } else if (f.this.dEc != null && f.this.dEc.cDb) {
                long j = f.this.dEc.cDc;
                if (f.DEBUG) {
                    Log.d("LoginRequest", "send timeout " + j + "ms msg");
                }
                f.this.dEd.sendEmptyMessageDelayed(1, j >= 0 ? j : 0L);
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
                    aLQ();
                    return;
            }
        }
    }

    /* loaded from: classes25.dex */
    public static class c {
        public final String code;

        private c(String str) {
            this.code = str == null ? "" : str;
        }

        public String toString() {
            return String.format("Result code(%s)", this.code);
        }
    }

    /* loaded from: classes25.dex */
    public static class b extends Handler {
        private WeakReference<f> dEh;

        private b(Looper looper, f fVar) {
            super(looper);
            this.dEh = new WeakReference<>(fVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f fVar = this.dEh.get();
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
