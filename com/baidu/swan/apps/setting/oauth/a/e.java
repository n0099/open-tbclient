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
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
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
    public g.a aUv;
    public b aUw = new b(Looper.getMainLooper(), this);
    public Bundle aUx;
    protected final Activity mActivity;

    public e(Activity activity, g.a aVar, Bundle bundle) {
        this.mActivity = activity;
        this.aUv = aVar;
        this.aUx = bundle;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean Df() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", LG().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", LG().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String wr = com.baidu.swan.apps.u.a.DN().wr();
            if (!TextUtils.isEmpty(wr)) {
                jSONObject2.put("host_api_key", wr);
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
        return com.baidu.swan.apps.u.a.DN().d(this.mActivity, gVar.MJ());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    public boolean De() {
        a(Di());
        return super.De();
    }

    @NonNull
    protected com.baidu.swan.apps.setting.oauth.d Di() {
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
        this.aUw.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends com.baidu.swan.apps.setting.oauth.d implements com.baidu.swan.apps.a.a {
        private a() {
        }

        @Override // com.baidu.swan.apps.setting.oauth.d
        protected boolean Dh() throws Exception {
            com.baidu.swan.apps.a.b Lv = e.this.LG().Lv();
            boolean aD = Lv.aD(e.this.mActivity);
            if (e.DEBUG) {
                Log.d("LoginRequest", "LoginPreparation isLogin : " + aD + " call stack:" + Log.getStackTraceString(new Exception()));
            }
            if (!aD) {
                Lv.a(e.this.mActivity, e.this.aUx, this);
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
                    ME();
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
        private WeakReference<e> aUz;

        private b(Looper looper, e eVar) {
            super(looper);
            this.aUz = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar = this.aUz.get();
            if (eVar != null) {
                switch (message.what) {
                    case 1:
                        if (e.DEBUG) {
                            Log.d("LoginRequest", "handleMessage: timeout");
                        }
                        eVar.l(new OAuthException("request timeout", (int) HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_BAIDUMAP_NULL));
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
