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
/* loaded from: classes7.dex */
public class e extends g<c> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected String cMU;
    public b.a cNg;
    public b cNh = new b(Looper.getMainLooper(), this);
    public Bundle cNi;
    protected JSONObject cNj;
    protected final Activity mActivity;

    public e(Activity activity, b.a aVar, Bundle bundle) {
        this.mActivity = activity;
        this.cNg = aVar;
        if (bundle != null && bundle.containsKey("__plugin__")) {
            this.cMU = bundle.getString("__plugin__");
            bundle.remove("__plugin__");
        }
        this.cNi = bundle;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean ato() {
        JSONObject jSONObject = new JSONObject();
        try {
            boolean isEmpty = TextUtils.isEmpty(this.cMU);
            jSONObject.put("ma_id", isEmpty ? atN().id : this.cMU);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", isEmpty ? atN().getAppKey() : this.cMU);
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String Uj = com.baidu.swan.apps.t.a.ahv().Uj();
            if (!TextUtils.isEmpty(Uj)) {
                jSONObject2.put("host_api_key", Uj);
            }
            jSONObject.put("open", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bS("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected HttpRequest a(g gVar) {
        return com.baidu.swan.apps.t.a.ahv().d(this.mActivity, gVar.atO());
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean atn() {
        a(atK());
        return super.atn();
    }

    @NonNull
    protected com.baidu.swan.apps.setting.oauth.d atK() {
        return new a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bB */
    public c bt(JSONObject jSONObject) throws JSONException {
        JSONObject bv = com.baidu.swan.apps.setting.oauth.c.bv(jSONObject);
        int optInt = bv.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new OAuthException(bv.optString(BaseJsonData.TAG_ERRMSG), optInt);
        }
        String str = "";
        JSONObject jSONObject2 = bv.getJSONObject("data");
        if (jSONObject2 != null) {
            str = jSONObject2.optString("code", "");
        }
        return new c(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    public void s(@Nullable Exception exc) {
        super.s(exc);
        if (DEBUG) {
            Log.d("LoginRequest", "finish: remove timeout msg");
        }
        this.cNh.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d implements com.baidu.swan.apps.a.a {
        private a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean att() throws Exception {
            com.baidu.swan.apps.a.b arI = e.this.atN().arI();
            boolean isLogin = arI.isLogin(e.this.mActivity);
            if (e.DEBUG) {
                Log.d("LoginRequest", "LoginPreparation isLogin : " + isLogin + " call stack:" + Log.getStackTraceString(new Exception()));
            }
            if (!isLogin) {
                arI.a(e.this.mActivity, e.this.cNi, this);
            } else if (e.this.cNg != null && e.this.cNg.bPB) {
                long j = e.this.cNg.bPC;
                if (e.DEBUG) {
                    Log.d("LoginRequest", "send timeout " + j + "ms msg");
                }
                e.this.cNh.sendEmptyMessageDelayed(1, j >= 0 ? j : 0L);
            }
            return isLogin;
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
            switch (i) {
                case -2:
                    com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                    t(new OAuthException(10004));
                    return;
                case -1:
                default:
                    com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                    t(new OAuthException(10004));
                    return;
                case 0:
                    com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                    atv();
                    return;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public final String code;

        private c(String str) {
            this.code = str == null ? "" : str;
        }

        public String toString() {
            return String.format("Result code(%s)", this.code);
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends Handler {
        private WeakReference<e> cNl;

        private b(Looper looper, e eVar) {
            super(looper);
            this.cNl = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar = this.cNl.get();
            if (eVar != null) {
                switch (message.what) {
                    case 1:
                        if (e.DEBUG) {
                            Log.d("LoginRequest", "handleMessage: timeout");
                        }
                        com.baidu.swan.apps.setting.oauth.c.c("request timeout", true);
                        eVar.s(new OAuthException(10002));
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
