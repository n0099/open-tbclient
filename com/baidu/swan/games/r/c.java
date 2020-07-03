package com.baidu.swan.games.r;

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
    private com.baidu.swan.games.f.b dfD;

    public c(@NonNull com.baidu.swan.games.f.b bVar) {
        this.dfD = bVar;
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        final com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e != null) {
            JSONArray jSONArray = new JSONArray();
            try {
                String[] rw = e.rw("swanIdList");
                if (rw != null && rw.length > 0) {
                    for (String str : rw) {
                        jSONArray.put(str);
                    }
                }
            } catch (JSTypeMismatchException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            i(jsObject);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", com.baidu.swan.apps.runtime.e.apO());
                jSONObject.put("swanid_list", jSONArray);
            } catch (JSONException e3) {
                if (DEBUG) {
                    e3.printStackTrace();
                }
            }
            String iF = iF(1);
            final com.baidu.swan.games.r.a.c cVar = new com.baidu.swan.games.r.a.c();
            c(iF, jSONObject.toString(), new ResponseCallback<JSONObject>() { // from class: com.baidu.swan.games.r.c.1
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
                    jSONObject3.put("errMsg", com.baidu.swan.games.utils.b.cC("getUserInfo", "ok"));
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
                    c.this.dfD.r(new Runnable() { // from class: com.baidu.swan.games.r.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.games.utils.b.a(e, true, jSONObject2);
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
                    c.this.dfD.r(new Runnable() { // from class: com.baidu.swan.games.r.c.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.games.utils.b.a(e, false, cVar);
                        }
                    });
                }
            });
        }
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        final com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e != null) {
            final com.baidu.swan.games.r.a.c cVar = new com.baidu.swan.games.r.a.c();
            if (!isLogin()) {
                cVar.errNo = "400";
                cVar.errMsg = com.baidu.swan.games.utils.b.cC("removeUserCloudStorage", "fail must login before calling");
                com.baidu.swan.games.utils.b.a(e, false, cVar);
                i(jsObject);
                return;
            }
            try {
                String[] rw = e.rw("keyList");
                i(jsObject);
                a(2, rw, new ResponseCallback<com.baidu.swan.games.r.a.c>() { // from class: com.baidu.swan.games.r.c.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    /* renamed from: d */
                    public com.baidu.swan.games.r.a.c parseResponse(Response response, int i) throws Exception {
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
                        cVar.errMsg = com.baidu.swan.games.utils.b.cC("removeUserCloudStorage", "ok");
                        return cVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    /* renamed from: a */
                    public void onSuccess(final com.baidu.swan.games.r.a.c cVar2, int i) {
                        if (a.DEBUG) {
                            Log.d("OpenDataApi", "on success ");
                        }
                        c.this.dfD.r(new Runnable() { // from class: com.baidu.swan.games.r.c.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.swan.games.utils.b.a(e, true, cVar2);
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
                        c.this.dfD.r(new Runnable() { // from class: com.baidu.swan.games.r.c.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.swan.games.utils.b.a(e, false, cVar);
                            }
                        });
                    }
                });
            } catch (JSTypeMismatchException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
                cVar.errNo = "400";
                cVar.errMsg = com.baidu.swan.games.utils.b.cC("removeUserCloudStorage", "fail invalid keyList");
                com.baidu.swan.games.utils.b.a(e, false, cVar);
                i(jsObject);
            }
        }
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        final com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e != null) {
            final com.baidu.swan.games.r.a.c cVar = new com.baidu.swan.games.r.a.c();
            if (!isLogin()) {
                cVar.errNo = "400";
                cVar.errMsg = com.baidu.swan.games.utils.b.cC("getUserCloudStorage", "fail must login before calling");
                com.baidu.swan.games.utils.b.a(e, false, cVar);
                i(jsObject);
                return;
            }
            try {
                String[] rw = e.rw("keyList");
                i(jsObject);
                a(3, rw, new ResponseCallback<JSONObject>() { // from class: com.baidu.swan.games.r.c.3
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
                        jSONObject2.put("errMsg", com.baidu.swan.games.utils.b.cC("getUserCloudStorage", "ok"));
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
                        c.this.dfD.r(new Runnable() { // from class: com.baidu.swan.games.r.c.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.swan.games.utils.b.a(e, true, jSONObject);
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
                        c.this.dfD.r(new Runnable() { // from class: com.baidu.swan.games.r.c.3.2
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.swan.games.utils.b.a(e, false, cVar);
                            }
                        });
                    }
                });
            } catch (JSTypeMismatchException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
                cVar.errNo = "400";
                cVar.errMsg = com.baidu.swan.games.utils.b.cC("getUserCloudStorage", "fail invalid keyList");
                com.baidu.swan.games.utils.b.a(e, false, cVar);
                i(jsObject);
            }
        }
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        final com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e != null) {
            final com.baidu.swan.games.r.a.c cVar = new com.baidu.swan.games.r.a.c();
            if (!isLogin()) {
                cVar.errNo = "400";
                cVar.errMsg = com.baidu.swan.games.utils.b.cC("setUserCloudStorage", "fail must login before calling");
                com.baidu.swan.games.utils.b.a(e, false, cVar);
                b(e.rz("KVDataList"));
                i(jsObject);
                return;
            }
            try {
                JsObject[] ry = e.ry("KVDataList");
                i(jsObject);
                com.baidu.swan.games.r.a.b[] a = a(e, ry, cVar);
                b(ry);
                if (a != null) {
                    c(iF(4), a(a).toString(), new ResponseCallback<com.baidu.swan.games.r.a.c>() { // from class: com.baidu.swan.games.r.c.4
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.searchbox.http.callback.ResponseCallback
                        /* renamed from: d */
                        public com.baidu.swan.games.r.a.c parseResponse(Response response, int i) throws Exception {
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
                            cVar.errMsg = com.baidu.swan.games.utils.b.cC("setUserCloudStorage", "ok");
                            return cVar;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.searchbox.http.callback.ResponseCallback
                        /* renamed from: a */
                        public void onSuccess(final com.baidu.swan.games.r.a.c cVar2, int i) {
                            if (a.DEBUG) {
                                Log.d("OpenDataApi", "on success");
                            }
                            c.this.dfD.r(new Runnable() { // from class: com.baidu.swan.games.r.c.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.swan.games.utils.b.a(e, true, cVar2);
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
                            c.this.dfD.r(new Runnable() { // from class: com.baidu.swan.games.r.c.4.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.swan.games.utils.b.a(e, false, cVar);
                                }
                            });
                        }
                    });
                }
            } catch (JSTypeMismatchException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
                cVar.errNo = "400";
                cVar.errMsg = com.baidu.swan.games.utils.b.cC("setUserCloudStorage", "fail KVDataList must be an Array");
                com.baidu.swan.games.utils.b.a(e, false, cVar);
                i(jsObject);
            }
        }
    }

    private boolean isLogin() {
        com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
        if (apM == null) {
            return false;
        }
        return apM.apZ().isLogin(AppRuntime.getAppContext());
    }

    private JSONObject a(com.baidu.swan.games.r.a.b[] bVarArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", com.baidu.swan.apps.runtime.e.apO());
            JSONArray jSONArray = new JSONArray();
            for (com.baidu.swan.games.r.a.b bVar : bVarArr) {
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

    private com.baidu.swan.games.r.a.b[] a(com.baidu.swan.games.binding.model.c cVar, JsObject[] jsObjectArr, com.baidu.swan.games.r.a.c cVar2) {
        int length = jsObjectArr.length;
        if (length < 1) {
            cVar2.errMsg = com.baidu.swan.games.utils.b.cC("setUserCloudStorage", "fail KVDataList.length must greater than 0");
            com.baidu.swan.games.utils.b.a(cVar, false, cVar2);
            return null;
        } else if (length > 128) {
            cVar2.errMsg = com.baidu.swan.games.utils.b.cC("setUserCloudStorage", "fail user has stored too much keys. delete some keys and try again");
            com.baidu.swan.games.utils.b.a(cVar, false, cVar2);
            return null;
        } else {
            com.baidu.swan.games.r.a.b[] bVarArr = new com.baidu.swan.games.r.a.b[length];
            for (int i = 0; i < length; i++) {
                com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObjectArr[i]);
                if (e == null || e.length() != 2 || TextUtils.isEmpty(e.optString("key")) || TextUtils.isEmpty(e.optString("value"))) {
                    cVar2.errMsg = com.baidu.swan.games.utils.b.cC("setUserCloudStorage", "fail invalid KVData item");
                    com.baidu.swan.games.utils.b.a(cVar, false, cVar2);
                    return null;
                }
                bVarArr[i] = new com.baidu.swan.games.r.a.b();
                bVarArr[i].key = e.optString("key");
                bVarArr[i].value = e.optString("value");
                if (!bVarArr[i].aCr()) {
                    cVar2.errMsg = com.baidu.swan.games.utils.b.cC("setUserCloudStorage", "fail some keys in list meet length exceed");
                    com.baidu.swan.games.utils.b.a(cVar, false, cVar2);
                    return null;
                } else if (!bVarArr[i].aCs()) {
                    cVar2.errMsg = com.baidu.swan.games.utils.b.cC("setUserCloudStorage", "fail some key-value in list meet length exceed");
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
        final com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e != null) {
            if (i != 5) {
                i(jsObject);
                return;
            }
            final com.baidu.swan.games.r.a.c cVar = new com.baidu.swan.games.r.a.c();
            if (!isLogin()) {
                cVar.errNo = "400";
                cVar.errMsg = com.baidu.swan.games.utils.b.cC("getFriendCloudStorage", "fail must login before calling");
                com.baidu.swan.games.utils.b.a(e, false, cVar);
                i(jsObject);
                return;
            }
            try {
                String[] rw = e.rw("keyList");
                i(jsObject);
                a(i, rw, new ResponseCallback<JSONObject>() { // from class: com.baidu.swan.games.r.c.5
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
                        jSONObject2.put("errMsg", com.baidu.swan.games.utils.b.cC(r3, "ok"));
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
                        c.this.dfD.r(new Runnable() { // from class: com.baidu.swan.games.r.c.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.swan.games.utils.b.a(e, true, jSONObject);
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
                        c.this.dfD.r(new Runnable() { // from class: com.baidu.swan.games.r.c.5.2
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.swan.games.utils.b.a(e, false, cVar);
                            }
                        });
                    }
                });
            } catch (JSTypeMismatchException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
                cVar.errNo = "400";
                cVar.errMsg = com.baidu.swan.games.utils.b.cC("getFriendCloudStorage", "fail invalid keyList");
                com.baidu.swan.games.utils.b.a(e, false, cVar);
                i(jsObject);
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
            jSONObject.put("ma_id", com.baidu.swan.apps.runtime.e.apO());
            jSONObject.put("key_list", jSONArray);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        c(iF(i), jSONObject.toString(), responseCallback);
    }

    private String iF(int i) {
        String SZ;
        switch (i) {
            case 1:
                SZ = com.baidu.swan.apps.u.a.agj().SY();
                break;
            case 2:
                SZ = com.baidu.swan.apps.u.a.agj().SZ();
                break;
            case 3:
                SZ = com.baidu.swan.apps.u.a.agj().Ta();
                break;
            case 4:
                SZ = com.baidu.swan.apps.u.a.agj().Tb();
                break;
            case 5:
                SZ = com.baidu.swan.apps.u.a.agj().Tc();
                break;
            default:
                SZ = "";
                break;
        }
        if (TextUtils.isEmpty(SZ) && DEBUG) {
            Log.e("OpenDataApi", "getUrlByType（）meet empty url !");
        }
        return SZ;
    }

    private void i(JsObject jsObject) {
        if (jsObject != null) {
            jsObject.release();
        }
    }

    private void b(JsObject[] jsObjectArr) {
        if (jsObjectArr != null) {
            for (JsObject jsObject : jsObjectArr) {
                i(jsObject);
            }
        }
    }
}
