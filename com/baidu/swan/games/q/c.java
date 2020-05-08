package com.baidu.swan.games.q;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends a {
    private com.baidu.swan.games.e.b cPT;

    public c(@NonNull com.baidu.swan.games.e.b bVar) {
        this.cPT = bVar;
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        final com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c != null) {
            JSONArray jSONArray = new JSONArray();
            try {
                String[] pM = c.pM("swanIdList");
                if (pM != null && pM.length > 0) {
                    for (String str : pM) {
                        jSONArray.put(str);
                    }
                }
            } catch (JSTypeMismatchException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            g(jsObject);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", com.baidu.swan.apps.runtime.e.akO());
                jSONObject.put("swanid_list", jSONArray);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            String ib = ib(1);
            final com.baidu.swan.games.q.a.c cVar = new com.baidu.swan.games.q.a.c();
            b(ib, jSONObject.toString(), new ResponseCallback<JSONObject>() { // from class: com.baidu.swan.games.q.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: a */
                public JSONObject parseResponse(Response response, int i) throws Exception {
                    ResponseBody body = response.body();
                    if (body == null) {
                        return null;
                    }
                    String string = body.string();
                    if (a.DEBUG) {
                        Log.d("OpenDataApi", "parse response: " + string);
                    }
                    JSONObject jSONObject2 = new JSONObject(string);
                    String optString = jSONObject2.optString(BaseJsonData.TAG_ERRNO);
                    if (!TextUtils.equals(optString, "0")) {
                        if (a.DEBUG) {
                            Log.d("OpenDataApi", "errno = " + optString);
                        }
                        cVar.errNo = optString;
                        cVar.errMsg = String.format("%s: fail Error: %s", "getUserInfo", jSONObject2.optString(BaseJsonData.TAG_ERRMSG));
                        return null;
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("errNo", "0");
                    jSONObject3.put("errMsg", com.baidu.swan.games.utils.b.cf("getUserInfo", "ok"));
                    jSONObject3.put("data", jSONObject2.optJSONArray("data"));
                    return jSONObject3;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: b */
                public void onSuccess(final JSONObject jSONObject2, int i) {
                    if (a.DEBUG) {
                        Log.d("OpenDataApi", "on success");
                    }
                    c.this.cPT.p(new Runnable() { // from class: com.baidu.swan.games.q.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.games.utils.b.a(c, true, jSONObject2);
                        }
                    });
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                    if (a.DEBUG) {
                        Log.e("OpenDataApi", "on fail");
                        exc.printStackTrace();
                    }
                    if (TextUtils.isEmpty(cVar.errMsg)) {
                        cVar.errNo = "100";
                        cVar.errMsg = String.format("%s: fail Error: %s", "getUserInfo", exc.getMessage());
                    }
                    c.this.cPT.p(new Runnable() { // from class: com.baidu.swan.games.q.c.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.games.utils.b.a(c, false, cVar);
                        }
                    });
                }
            });
        }
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        final com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c != null) {
            final com.baidu.swan.games.q.a.c cVar = new com.baidu.swan.games.q.a.c();
            if (!isLogin()) {
                cVar.errNo = "400";
                cVar.errMsg = com.baidu.swan.games.utils.b.cf("removeUserCloudStorage", "fail must login before calling");
                com.baidu.swan.games.utils.b.a(c, false, cVar);
                g(jsObject);
                return;
            }
            try {
                String[] pM = c.pM("keyList");
                g(jsObject);
                a(2, pM, new ResponseCallback<com.baidu.swan.games.q.a.c>() { // from class: com.baidu.swan.games.q.c.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    /* renamed from: e */
                    public com.baidu.swan.games.q.a.c parseResponse(Response response, int i) throws Exception {
                        ResponseBody body = response.body();
                        if (body == null) {
                            return null;
                        }
                        String string = body.string();
                        if (a.DEBUG) {
                            Log.d("OpenDataApi", "parse response: " + string);
                        }
                        JSONObject jSONObject = new JSONObject(string);
                        String optString = jSONObject.optString(BaseJsonData.TAG_ERRNO);
                        if (!TextUtils.equals(optString, "0")) {
                            if (a.DEBUG) {
                                Log.d("OpenDataApi", "errno = " + optString);
                            }
                            cVar.errNo = optString;
                            cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                            return null;
                        }
                        cVar.errNo = "0";
                        cVar.errMsg = com.baidu.swan.games.utils.b.cf("removeUserCloudStorage", "ok");
                        return cVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    /* renamed from: a */
                    public void onSuccess(final com.baidu.swan.games.q.a.c cVar2, int i) {
                        if (a.DEBUG) {
                            Log.d("OpenDataApi", "on success ");
                        }
                        c.this.cPT.p(new Runnable() { // from class: com.baidu.swan.games.q.c.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.swan.games.utils.b.a(c, true, cVar2);
                            }
                        });
                    }

                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    public void onFail(Exception exc) {
                        if (a.DEBUG) {
                            Log.d("OpenDataApi", "on fail");
                            exc.printStackTrace();
                        }
                        if (TextUtils.isEmpty(cVar.errMsg)) {
                            cVar.errNo = "100";
                            cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", exc.getMessage());
                        }
                        c.this.cPT.p(new Runnable() { // from class: com.baidu.swan.games.q.c.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.swan.games.utils.b.a(c, false, cVar);
                            }
                        });
                    }
                });
            } catch (JSTypeMismatchException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                cVar.errNo = "400";
                cVar.errMsg = com.baidu.swan.games.utils.b.cf("removeUserCloudStorage", "fail invalid keyList");
                com.baidu.swan.games.utils.b.a(c, false, cVar);
                g(jsObject);
            }
        }
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        final com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c != null) {
            final com.baidu.swan.games.q.a.c cVar = new com.baidu.swan.games.q.a.c();
            if (!isLogin()) {
                cVar.errNo = "400";
                cVar.errMsg = com.baidu.swan.games.utils.b.cf("getUserCloudStorage", "fail must login before calling");
                com.baidu.swan.games.utils.b.a(c, false, cVar);
                g(jsObject);
                return;
            }
            try {
                String[] pM = c.pM("keyList");
                g(jsObject);
                a(3, pM, new ResponseCallback<JSONObject>() { // from class: com.baidu.swan.games.q.c.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    /* renamed from: a */
                    public JSONObject parseResponse(Response response, int i) throws Exception {
                        ResponseBody body = response.body();
                        if (body == null) {
                            return null;
                        }
                        String string = body.string();
                        if (a.DEBUG) {
                            Log.d("OpenDataApi", "parse response: " + string);
                        }
                        JSONObject jSONObject = new JSONObject(string);
                        String optString = jSONObject.optString(BaseJsonData.TAG_ERRNO);
                        if (!TextUtils.equals(optString, "0")) {
                            if (a.DEBUG) {
                                Log.d("OpenDataApi", "errno = " + optString);
                            }
                            cVar.errNo = optString;
                            cVar.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                            return null;
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("errNo", "0");
                        jSONObject2.put("errMsg", com.baidu.swan.games.utils.b.cf("getUserCloudStorage", "ok"));
                        jSONObject2.put("KVDataList", jSONObject.optJSONArray("data"));
                        return jSONObject2;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    /* renamed from: b */
                    public void onSuccess(final JSONObject jSONObject, int i) {
                        if (a.DEBUG) {
                            Log.d("OpenDataApi", "on success");
                        }
                        c.this.cPT.p(new Runnable() { // from class: com.baidu.swan.games.q.c.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.swan.games.utils.b.a(c, true, jSONObject);
                            }
                        });
                    }

                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    public void onFail(Exception exc) {
                        if (a.DEBUG) {
                            Log.e("OpenDataApi", "on fail");
                        }
                        if (TextUtils.isEmpty(cVar.errMsg)) {
                            cVar.errNo = "100";
                            cVar.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", exc.getMessage());
                        }
                        c.this.cPT.p(new Runnable() { // from class: com.baidu.swan.games.q.c.3.2
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.swan.games.utils.b.a(c, false, cVar);
                            }
                        });
                    }
                });
            } catch (JSTypeMismatchException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                cVar.errNo = "400";
                cVar.errMsg = com.baidu.swan.games.utils.b.cf("getUserCloudStorage", "fail invalid keyList");
                com.baidu.swan.games.utils.b.a(c, false, cVar);
                g(jsObject);
            }
        }
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        final com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c != null) {
            final com.baidu.swan.games.q.a.c cVar = new com.baidu.swan.games.q.a.c();
            if (!isLogin()) {
                cVar.errNo = "400";
                cVar.errMsg = com.baidu.swan.games.utils.b.cf("setUserCloudStorage", "fail must login before calling");
                com.baidu.swan.games.utils.b.a(c, false, cVar);
                a(c.pP("KVDataList"));
                g(jsObject);
                return;
            }
            try {
                JsObject[] pO = c.pO("KVDataList");
                g(jsObject);
                com.baidu.swan.games.q.a.b[] a = a(c, pO, cVar);
                a(pO);
                if (a != null) {
                    b(ib(4), a(a).toString(), new ResponseCallback<com.baidu.swan.games.q.a.c>() { // from class: com.baidu.swan.games.q.c.4
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.searchbox.http.callback.ResponseCallback
                        /* renamed from: e */
                        public com.baidu.swan.games.q.a.c parseResponse(Response response, int i) throws Exception {
                            ResponseBody body = response.body();
                            if (body == null) {
                                return null;
                            }
                            String string = body.string();
                            if (a.DEBUG) {
                                Log.d("OpenDataApi", "parse response: " + string);
                            }
                            JSONObject jSONObject = new JSONObject(string);
                            String optString = jSONObject.optString(BaseJsonData.TAG_ERRNO);
                            if (!TextUtils.equals(optString, "0")) {
                                if (a.DEBUG) {
                                    Log.d("OpenDataApi", "errno = " + optString);
                                }
                                cVar.errNo = optString;
                                cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                                return null;
                            }
                            cVar.errNo = "0";
                            cVar.errMsg = com.baidu.swan.games.utils.b.cf("setUserCloudStorage", "ok");
                            return cVar;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.searchbox.http.callback.ResponseCallback
                        /* renamed from: a */
                        public void onSuccess(final com.baidu.swan.games.q.a.c cVar2, int i) {
                            if (a.DEBUG) {
                                Log.d("OpenDataApi", "on success");
                            }
                            c.this.cPT.p(new Runnable() { // from class: com.baidu.swan.games.q.c.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.swan.games.utils.b.a(c, true, cVar2);
                                }
                            });
                        }

                        @Override // com.baidu.searchbox.http.callback.ResponseCallback
                        public void onFail(Exception exc) {
                            if (a.DEBUG) {
                                Log.e("OpenDataApi", "on fail");
                            }
                            if (TextUtils.isEmpty(cVar.errMsg)) {
                                cVar.errNo = "100";
                                cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", exc.getMessage());
                            }
                            c.this.cPT.p(new Runnable() { // from class: com.baidu.swan.games.q.c.4.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.swan.games.utils.b.a(c, false, cVar);
                                }
                            });
                        }
                    });
                }
            } catch (JSTypeMismatchException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                cVar.errNo = "400";
                cVar.errMsg = com.baidu.swan.games.utils.b.cf("setUserCloudStorage", "fail KVDataList must be an Array");
                com.baidu.swan.games.utils.b.a(c, false, cVar);
                g(jsObject);
            }
        }
    }

    private boolean isLogin() {
        com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
        if (akM == null) {
            return false;
        }
        return akM.akX().isLogin(AppRuntime.getAppContext());
    }

    private JSONObject a(com.baidu.swan.games.q.a.b[] bVarArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", com.baidu.swan.apps.runtime.e.akO());
            JSONArray jSONArray = new JSONArray();
            for (com.baidu.swan.games.q.a.b bVar : bVarArr) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("key", bVar.key);
                jSONObject2.put("value", bVar.value);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("data", jSONArray);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    private com.baidu.swan.games.q.a.b[] a(com.baidu.swan.games.binding.model.c cVar, JsObject[] jsObjectArr, com.baidu.swan.games.q.a.c cVar2) {
        int length = jsObjectArr.length;
        if (length < 1) {
            cVar2.errMsg = com.baidu.swan.games.utils.b.cf("setUserCloudStorage", "fail KVDataList.length must greater than 0");
            com.baidu.swan.games.utils.b.a(cVar, false, cVar2);
            return null;
        } else if (length > 128) {
            cVar2.errMsg = com.baidu.swan.games.utils.b.cf("setUserCloudStorage", "fail user has stored too much keys. delete some keys and try again");
            com.baidu.swan.games.utils.b.a(cVar, false, cVar2);
            return null;
        } else {
            com.baidu.swan.games.q.a.b[] bVarArr = new com.baidu.swan.games.q.a.b[length];
            for (int i = 0; i < length; i++) {
                com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObjectArr[i]);
                if (c == null || c.length() != 2 || TextUtils.isEmpty(c.optString("key")) || TextUtils.isEmpty(c.optString("value"))) {
                    cVar2.errMsg = com.baidu.swan.games.utils.b.cf("setUserCloudStorage", "fail invalid KVData item");
                    com.baidu.swan.games.utils.b.a(cVar, false, cVar2);
                    return null;
                }
                bVarArr[i] = new com.baidu.swan.games.q.a.b();
                bVarArr[i].key = c.optString("key");
                bVarArr[i].value = c.optString("value");
                if (!bVarArr[i].axu()) {
                    cVar2.errMsg = com.baidu.swan.games.utils.b.cf("setUserCloudStorage", "fail some keys in list meet length exceed");
                    com.baidu.swan.games.utils.b.a(cVar, false, cVar2);
                    return null;
                } else if (!bVarArr[i].axv()) {
                    cVar2.errMsg = com.baidu.swan.games.utils.b.cf("setUserCloudStorage", "fail some key-value in list meet length exceed");
                    com.baidu.swan.games.utils.b.a(cVar, false, cVar2);
                    return null;
                }
            }
            return bVarArr;
        }
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        a(jsObject, 5);
    }

    private void a(JsObject jsObject, int i) {
        final com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c != null) {
            if (i != 5) {
                g(jsObject);
                return;
            }
            final com.baidu.swan.games.q.a.c cVar = new com.baidu.swan.games.q.a.c();
            if (!isLogin()) {
                cVar.errNo = "400";
                cVar.errMsg = com.baidu.swan.games.utils.b.cf("getFriendCloudStorage", "fail must login before calling");
                com.baidu.swan.games.utils.b.a(c, false, cVar);
                g(jsObject);
                return;
            }
            try {
                String[] pM = c.pM("keyList");
                g(jsObject);
                a(i, pM, new ResponseCallback<JSONObject>() { // from class: com.baidu.swan.games.q.c.5
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    /* renamed from: a */
                    public JSONObject parseResponse(Response response, int i2) throws Exception {
                        ResponseBody body = response.body();
                        if (body == null) {
                            return null;
                        }
                        String string = body.string();
                        if (a.DEBUG) {
                            Log.d("OpenDataApi", "parse response: " + string);
                        }
                        JSONObject jSONObject = new JSONObject(string);
                        String optString = jSONObject.optString(BaseJsonData.TAG_ERRNO);
                        if (!TextUtils.equals(optString, "0")) {
                            if (a.DEBUG) {
                                Log.d("OpenDataApi", "errno = " + optString);
                            }
                            cVar.errNo = optString;
                            cVar.errMsg = String.format("%s: fail Error: %s", r3, jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                            return null;
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("errNo", "0");
                        jSONObject2.put("errMsg", com.baidu.swan.games.utils.b.cf(r3, "ok"));
                        jSONObject2.put("data", jSONObject.optJSONArray("data"));
                        return jSONObject2;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    /* renamed from: b */
                    public void onSuccess(final JSONObject jSONObject, int i2) {
                        if (a.DEBUG) {
                            Log.d("OpenDataApi", "on success");
                        }
                        c.this.cPT.p(new Runnable() { // from class: com.baidu.swan.games.q.c.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.swan.games.utils.b.a(c, true, jSONObject);
                            }
                        });
                    }

                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    public void onFail(Exception exc) {
                        if (a.DEBUG) {
                            Log.e("OpenDataApi", "on fail");
                            exc.printStackTrace();
                        }
                        if (TextUtils.isEmpty(cVar.errMsg)) {
                            cVar.errNo = "100";
                            cVar.errMsg = String.format("%s: fail Error: %s", r3, exc.getMessage());
                        }
                        c.this.cPT.p(new Runnable() { // from class: com.baidu.swan.games.q.c.5.2
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.swan.games.utils.b.a(c, false, cVar);
                            }
                        });
                    }
                });
            } catch (JSTypeMismatchException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                cVar.errNo = "400";
                cVar.errMsg = com.baidu.swan.games.utils.b.cf("getFriendCloudStorage", "fail invalid keyList");
                com.baidu.swan.games.utils.b.a(c, false, cVar);
                g(jsObject);
            }
        }
    }

    private <T> void a(int i, @NonNull String[] strArr, ResponseCallback<T> responseCallback) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (strArr.length > 0) {
            for (String str : strArr) {
                jSONArray.put(str);
            }
        }
        try {
            jSONObject.put("ma_id", com.baidu.swan.apps.runtime.e.akO());
            jSONObject.put("key_list", jSONArray);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        b(ib(i), jSONObject.toString(), responseCallback);
    }

    private String ib(int i) {
        String PV;
        switch (i) {
            case 1:
                PV = com.baidu.swan.apps.w.a.abZ().PU();
                break;
            case 2:
                PV = com.baidu.swan.apps.w.a.abZ().PV();
                break;
            case 3:
                PV = com.baidu.swan.apps.w.a.abZ().PW();
                break;
            case 4:
                PV = com.baidu.swan.apps.w.a.abZ().PX();
                break;
            case 5:
                PV = com.baidu.swan.apps.w.a.abZ().PY();
                break;
            default:
                PV = "";
                break;
        }
        if (TextUtils.isEmpty(PV) && DEBUG) {
            Log.e("OpenDataApi", "getUrlByType（）meet empty url !");
        }
        return PV;
    }

    private void g(JsObject jsObject) {
        if (jsObject != null) {
            jsObject.release();
        }
    }

    private void a(JsObject[] jsObjectArr) {
        if (jsObjectArr != null) {
            for (JsObject jsObject : jsObjectArr) {
                g(jsObject);
            }
        }
    }
}
