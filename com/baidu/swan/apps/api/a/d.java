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
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public abstract class d implements com.baidu.swan.apps.api.a.a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    private CallbackHandler mCallbackHandler;
    @NonNull
    private b mSwanApiContext;

    /* loaded from: classes25.dex */
    public interface a {
        com.baidu.swan.apps.api.c.b a(e eVar, JSONObject jSONObject, @Nullable String str);
    }

    public d(@NonNull b bVar) {
        this.mSwanApiContext = bVar;
        this.mCallbackHandler = bVar.alW();
    }

    @Override // com.baidu.swan.apps.api.a.a
    @NonNull
    public final b alY() {
        return this.mSwanApiContext;
    }

    @Override // com.baidu.swan.apps.api.a.a
    public final void a(final String str, final com.baidu.swan.apps.api.c.b bVar) {
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
            ak.m(new Runnable() { // from class: com.baidu.swan.apps.api.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.b(str, bVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public final Context getContext() {
        return this.mSwanApiContext.getContext();
    }

    @NonNull
    public static Pair<com.baidu.swan.apps.api.c.a, JSONObject> ld(String str) {
        if (DEBUG) {
            Log.d("Api-Base", "parseParams(String): String");
        }
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.e("Api-Base", "parseParams(String): json string cannot be empty");
            }
            return new Pair<>(new com.baidu.swan.apps.api.c.b(202, "parseParams(String): json string cannot be empty"), null);
        }
        try {
            return new Pair<>(new com.baidu.swan.apps.api.c.b(0), new JSONObject(str));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
                Log.e("Api-Base", "parseParams(String): with json exception ", e);
            }
            return new Pair<>(new com.baidu.swan.apps.api.c.b(202, "parseParams(String): with json exception "), null);
        }
    }

    @NonNull
    public static Pair<com.baidu.swan.apps.api.c.a, JSONObject> a(JsObject jsObject) {
        if (DEBUG) {
            Log.d("Api-Base", "parseParams(JsObject): JsObject");
        }
        if (jsObject == null) {
            if (DEBUG) {
                throw new RuntimeException("parseParams(JsObject): jsObject cannot be null");
            }
            return new Pair<>(new com.baidu.swan.apps.api.c.b(202, "parseParams(JsObject): jsObject cannot be null"), null);
        }
        int type = jsObject.getType();
        int length = jsObject.length();
        if (type != 9) {
            String str = "parseParams(JsObject): jsObject cannot be " + JsObject.typeToString(type) + " ,length " + length;
            if (DEBUG) {
                throw new RuntimeException(str);
            }
            jsObject.release();
            return new Pair<>(new com.baidu.swan.apps.api.c.b(202, str), null);
        }
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < length; i++) {
            try {
                int propertyType = jsObject.getPropertyType(i);
                String propertyName = jsObject.getPropertyName(i);
                switch (propertyType) {
                    case 1:
                        jSONObject.put(propertyName, jsObject.toBoolean(i));
                        break;
                    case 2:
                        jSONObject.put(propertyName, jsObject.toInteger(i));
                        break;
                    case 3:
                        jSONObject.put(propertyName, jsObject.toLong(i));
                        break;
                    case 5:
                        try {
                            jSONObject.put(propertyName, jsObject.toDouble(i));
                            break;
                        } catch (JSONException e) {
                            if (DEBUG) {
                                e.printStackTrace();
                                Log.e("Api-Base", "parseParams(JsObject) JDOUBLE : with json exception ", e);
                                break;
                            } else {
                                break;
                            }
                        }
                    case 6:
                        JsObject[] objectArray = jsObject.toObjectArray(i);
                        if (objectArray == null) {
                            if (DEBUG) {
                                throw new RuntimeException("parseParams(JsObject): jsObjects cannot be null");
                            }
                            break;
                        } else {
                            jSONObject.put(propertyName, a(objectArray));
                            break;
                        }
                    case 7:
                        jSONObject.put(propertyName, jsObject.toString(i));
                        break;
                    case 8:
                        jSONObject.put(propertyName, jsObject.toJsFunction(i));
                        break;
                    case 9:
                        jSONObject.put(propertyName, a(jsObject.toJsObject(i)).second);
                        break;
                    case 10:
                        jSONObject.put(propertyName, jsObject.toJsArrayBuffer(i));
                        break;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                String str2 = "parseParams(JsObject): with exception " + e2.getMessage();
                if (DEBUG) {
                    throw new RuntimeException(str2, e2);
                }
                jsObject.release();
                return new Pair<>(new com.baidu.swan.apps.api.c.b(202, str2), null);
            }
        }
        jsObject.release();
        return new Pair<>(new com.baidu.swan.apps.api.c.b(0), jSONObject);
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x002c, code lost:
        continue;
     */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static JSONArray a(@NonNull JsObject[] jsObjectArr) {
        if (DEBUG) {
            Log.d("Api-Base", "parseParams(JsObject[]): JsObject[]");
        }
        JSONArray jSONArray = new JSONArray();
        for (JsObject jsObject : jsObjectArr) {
            if (jsObject == null) {
                if (DEBUG) {
                    throw new RuntimeException("parseParams(JsObject[]): jsObject cannot be null");
                }
                jSONArray.put((Object) null);
            } else {
                switch (jsObject.getType()) {
                    case 0:
                        if (DEBUG) {
                            throw new RuntimeException("parseParams(JsObject[]): jsObject cannot be JNONSUPPORT");
                        }
                        jSONArray.put((Object) null);
                        continue;
                    case 1:
                        jSONArray.put(jsObject.toBoolean(0));
                        continue;
                    case 2:
                        jSONArray.put(jsObject.toInteger(0));
                        continue;
                    case 3:
                        jSONArray.put(jsObject.toLong(0));
                        continue;
                    case 5:
                        try {
                            jSONArray.put(jsObject.toDouble(0));
                            continue;
                        } catch (JSONException e) {
                            if (DEBUG) {
                                e.printStackTrace();
                                Log.e("Api-Base", "parseParams(JsObject[]) JDOUBLE : with json exception ", e);
                            }
                            jSONArray.put((Object) null);
                            break;
                        }
                    case 6:
                        JsObject[] objectArray = jsObject.toObjectArray(0);
                        if (objectArray == null) {
                            if (DEBUG) {
                                throw new RuntimeException("parseParams(JsObject[]): objects is null");
                            }
                            jSONArray.put((Object) null);
                            continue;
                        } else {
                            jSONArray.put(a(objectArray));
                            break;
                        }
                    case 7:
                        jSONArray.put(jsObject.toString(0));
                        continue;
                    case 8:
                        jSONArray.put(jsObject.toJsFunction(0));
                        continue;
                    case 9:
                        jSONArray.put(a(jsObject).second);
                        continue;
                    case 10:
                        jSONArray.put(jsObject.toJsArrayBuffer(0));
                        continue;
                    case 11:
                        jSONArray.put((Object) null);
                        continue;
                    case 12:
                        jSONArray.put((Object) null);
                        continue;
                }
            }
        }
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean ama() {
        e aJV = e.aJV();
        if (aJV == null) {
            return true;
        }
        return aJV.ama();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void b(@NonNull String str, @NonNull com.baidu.swan.apps.api.c.b bVar) {
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
    public com.baidu.swan.apps.api.c.b a(@Nullable String str, @NonNull c cVar) {
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bp = com.baidu.swan.apps.api.d.b.bp("Api-Base", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bp.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-Base", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bp.second;
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("Api-Base", "cb is required");
            return new com.baidu.swan.apps.api.c.b(202, "cb is required");
        }
        return cVar.a(jSONObject, optString, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.swan.apps.api.c.b a(String str, boolean z, a aVar) {
        e aJU = e.aJU();
        if (aJU == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "swan app is null");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bp = com.baidu.swan.apps.api.d.b.bp("Api-Base", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bp.first;
        if (!bVar.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Api-Base", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bp.second;
        String str2 = null;
        if (z) {
            str2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(str2)) {
                com.baidu.swan.apps.console.c.e("Api-Base", "callback is null");
                return new com.baidu.swan.apps.api.c.b(202, "callback is null");
            }
        }
        return aVar.a(aJU, jSONObject, str2);
    }

    @Nullable
    public static JSONObject le(String str) {
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
