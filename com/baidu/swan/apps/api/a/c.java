package com.baidu.swan.apps.api.a;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.NullableCallbackHandler;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public abstract class c implements com.baidu.swan.apps.api.a.a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    private CallbackHandler mCallbackHandler;
    @NonNull
    private b mSwanApiContext;

    /* loaded from: classes11.dex */
    public interface a {
        com.baidu.swan.apps.api.b.b a(e eVar, JSONObject jSONObject, @Nullable String str);
    }

    public c(@NonNull b bVar) {
        this.mSwanApiContext = bVar;
        this.mCallbackHandler = bVar.JC();
    }

    @Override // com.baidu.swan.apps.api.a.a
    @NonNull
    public final b JE() {
        return this.mSwanApiContext;
    }

    @Override // com.baidu.swan.apps.api.a.a
    public final void a(final String str, final com.baidu.swan.apps.api.b.b bVar) {
        if (DEBUG) {
            Log.d("Api-Base", "invokeCallback: " + str);
        }
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.e("Api-Base", "invokeCallback: do callback with a empty callback");
                throw new RuntimeException("invokeCallback: do callback with a empty callback");
            }
        } else if (bVar == null) {
            if (DEBUG) {
                Log.e("Api-Base", "invokeCallback: do callback with a null result");
                throw new RuntimeException("invokeCallback: do callback with a null result");
            }
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            b(str, bVar);
        } else {
            if (DEBUG) {
                Log.d("Api-Base", "invokeCallback: other thread " + Thread.currentThread().getName());
            }
            ai.l(new Runnable() { // from class: com.baidu.swan.apps.api.a.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.b(str, bVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public final Context getContext() {
        return this.mSwanApiContext.getContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean JF() {
        e acG = e.acG();
        if (acG == null) {
            return true;
        }
        return acG.JF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void b(@NonNull String str, @NonNull com.baidu.swan.apps.api.b.b bVar) {
        if (!TextUtils.isEmpty(str) || (this.mCallbackHandler instanceof NullableCallbackHandler)) {
            if (DEBUG) {
                Log.d("Api-Base", "realInvokeCallback: invoke 【" + str + "】 with 【" + bVar + "】");
            }
            this.mCallbackHandler.handleSchemeDispatchCallback(str, bVar.toJsonString());
        } else if (DEBUG) {
            Log.e("Api-Base", "realInvokeCallback: callback check fail: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.swan.apps.api.b.b a(String str, boolean z, a aVar) {
        e acF = e.acF();
        if (acF == null) {
            return new com.baidu.swan.apps.api.b.b(1001, "swan app is null");
        }
        Pair<com.baidu.swan.apps.api.b.b, JSONObject> ar = com.baidu.swan.apps.api.c.b.ar("Api-Base", str);
        com.baidu.swan.apps.api.b.b bVar = (com.baidu.swan.apps.api.b.b) ar.first;
        if (!bVar.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Api-Base", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) ar.second;
        String str2 = null;
        if (z) {
            str2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(str2)) {
                com.baidu.swan.apps.console.c.e("Api-Base", "callback is null");
                return new com.baidu.swan.apps.api.b.b(1001, "callback is null");
            }
        }
        return aVar.a(acF, jSONObject, str2);
    }

    @Nullable
    public static JSONObject fd(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }
}
