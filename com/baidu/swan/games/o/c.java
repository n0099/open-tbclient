package com.baidu.swan.games.o;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import com.baidu.ubc.UBC;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends a {
    private com.baidu.swan.games.e.b bjG;

    public c(@NonNull com.baidu.swan.games.e.b bVar) {
        this.bjG = bVar;
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        final com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c != null) {
            JSONArray jSONArray = new JSONArray();
            try {
                String[] iU = c.iU("swanIdList");
                if (iU != null && iU.length > 0) {
                    for (String str : iU) {
                        jSONArray.put(str);
                    }
                }
            } catch (JSTypeMismatchException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", bjF);
                jSONObject.put("swanid_list", jSONArray);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            String fa = fa(1);
            final com.baidu.swan.games.o.a.c cVar = new com.baidu.swan.games.o.a.c();
            a(fa, jSONObject.toString(), new ResponseCallback<JSONObject>() { // from class: com.baidu.swan.games.o.c.1
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
                    String optString = jSONObject2.optString("errno");
                    if (!TextUtils.equals(optString, "0")) {
                        if (a.DEBUG) {
                            Log.d("OpenDataApi", "errno = " + optString);
                        }
                        cVar.errNo = optString;
                        cVar.errMsg = String.format("%s: fail Error: %s", "getUserInfo", jSONObject2.optString("errmsg"));
                        return null;
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("errNo", "0");
                    jSONObject3.put("errMsg", com.baidu.swan.games.utils.a.bj("getUserInfo", "ok"));
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
                    c.this.bjG.l(new Runnable() { // from class: com.baidu.swan.games.o.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.games.utils.a.a(c, true, jSONObject2);
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
                    c.this.bjG.l(new Runnable() { // from class: com.baidu.swan.games.o.c.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.games.utils.a.a(c, false, cVar);
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
            final com.baidu.swan.games.o.a.c cVar = new com.baidu.swan.games.o.a.c();
            if (!isLogin()) {
                cVar.errNo = "400";
                cVar.errMsg = com.baidu.swan.games.utils.a.bj("removeUserCloudStorage", "fail must login before calling");
                com.baidu.swan.games.utils.a.a(c, false, cVar);
                return;
            }
            try {
                a(2, c.iU("keyList"), new ResponseCallback<com.baidu.swan.games.o.a.c>() { // from class: com.baidu.swan.games.o.c.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    /* renamed from: d */
                    public com.baidu.swan.games.o.a.c parseResponse(Response response, int i) throws Exception {
                        ResponseBody body = response.body();
                        if (body == null) {
                            return null;
                        }
                        String string = body.string();
                        if (a.DEBUG) {
                            Log.d("OpenDataApi", "parse response: " + string);
                        }
                        JSONObject jSONObject = new JSONObject(string);
                        String optString = jSONObject.optString("errno");
                        if (!TextUtils.equals(optString, "0")) {
                            if (a.DEBUG) {
                                Log.d("OpenDataApi", "errno = " + optString);
                            }
                            cVar.errNo = optString;
                            cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", jSONObject.optString("errmsg"));
                            return null;
                        }
                        cVar.errNo = "0";
                        cVar.errMsg = com.baidu.swan.games.utils.a.bj("removeUserCloudStorage", "ok");
                        return cVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    /* renamed from: a */
                    public void onSuccess(final com.baidu.swan.games.o.a.c cVar2, int i) {
                        if (a.DEBUG) {
                            Log.d("OpenDataApi", "on success ");
                        }
                        c.this.bjG.l(new Runnable() { // from class: com.baidu.swan.games.o.c.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.swan.games.utils.a.a(c, true, cVar2);
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
                        c.this.bjG.l(new Runnable() { // from class: com.baidu.swan.games.o.c.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.swan.games.utils.a.a(c, false, cVar);
                            }
                        });
                    }
                });
            } catch (JSTypeMismatchException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                cVar.errNo = "400";
                cVar.errMsg = com.baidu.swan.games.utils.a.bj("removeUserCloudStorage", "fail invalid keyList");
                com.baidu.swan.games.utils.a.a(c, false, cVar);
            }
        }
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        final com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c != null) {
            final com.baidu.swan.games.o.a.c cVar = new com.baidu.swan.games.o.a.c();
            if (!isLogin()) {
                cVar.errNo = "400";
                cVar.errMsg = com.baidu.swan.games.utils.a.bj("getUserCloudStorage", "fail must login before calling");
                com.baidu.swan.games.utils.a.a(c, false, cVar);
                return;
            }
            try {
                a(3, c.iU("keyList"), new ResponseCallback<JSONObject>() { // from class: com.baidu.swan.games.o.c.3
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
                        String optString = jSONObject.optString("errno");
                        if (!TextUtils.equals(optString, "0")) {
                            if (a.DEBUG) {
                                Log.d("OpenDataApi", "errno = " + optString);
                            }
                            cVar.errNo = optString;
                            cVar.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", jSONObject.optString("errmsg"));
                            return null;
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("errNo", "0");
                        jSONObject2.put("errMsg", com.baidu.swan.games.utils.a.bj("getUserCloudStorage", "ok"));
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
                        c.this.bjG.l(new Runnable() { // from class: com.baidu.swan.games.o.c.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.swan.games.utils.a.a(c, true, jSONObject);
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
                        c.this.bjG.l(new Runnable() { // from class: com.baidu.swan.games.o.c.3.2
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.swan.games.utils.a.a(c, false, cVar);
                            }
                        });
                    }
                });
            } catch (JSTypeMismatchException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                cVar.errNo = "400";
                cVar.errMsg = com.baidu.swan.games.utils.a.bj("getUserCloudStorage", "fail invalid keyList");
                com.baidu.swan.games.utils.a.a(c, false, cVar);
            }
        }
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        final com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c != null) {
            final com.baidu.swan.games.o.a.c cVar = new com.baidu.swan.games.o.a.c();
            if (!isLogin()) {
                cVar.errNo = "400";
                cVar.errMsg = com.baidu.swan.games.utils.a.bj("setUserCloudStorage", "fail must login before calling");
                com.baidu.swan.games.utils.a.a(c, false, cVar);
                return;
            }
            try {
                com.baidu.swan.games.o.a.b[] a = a(c, c.iW("KVDataList"), cVar);
                if (a != null) {
                    a(fa(4), a(a).toString(), new ResponseCallback<com.baidu.swan.games.o.a.c>() { // from class: com.baidu.swan.games.o.c.4
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.searchbox.http.callback.ResponseCallback
                        /* renamed from: d */
                        public com.baidu.swan.games.o.a.c parseResponse(Response response, int i) throws Exception {
                            ResponseBody body = response.body();
                            if (body == null) {
                                return null;
                            }
                            String string = body.string();
                            if (a.DEBUG) {
                                Log.d("OpenDataApi", "parse response: " + string);
                            }
                            JSONObject jSONObject = new JSONObject(string);
                            String optString = jSONObject.optString("errno");
                            if (!TextUtils.equals(optString, "0")) {
                                if (a.DEBUG) {
                                    Log.d("OpenDataApi", "errno = " + optString);
                                }
                                cVar.errNo = optString;
                                cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", jSONObject.optString("errmsg"));
                                return null;
                            }
                            cVar.errNo = "0";
                            cVar.errMsg = com.baidu.swan.games.utils.a.bj("setUserCloudStorage", "ok");
                            return cVar;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.searchbox.http.callback.ResponseCallback
                        /* renamed from: a */
                        public void onSuccess(final com.baidu.swan.games.o.a.c cVar2, int i) {
                            if (a.DEBUG) {
                                Log.d("OpenDataApi", "on success");
                            }
                            c.this.bjG.l(new Runnable() { // from class: com.baidu.swan.games.o.c.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.swan.games.utils.a.a(c, true, cVar2);
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
                            c.this.bjG.l(new Runnable() { // from class: com.baidu.swan.games.o.c.4.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.swan.games.utils.a.a(c, false, cVar);
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
                cVar.errMsg = com.baidu.swan.games.utils.a.bj("setUserCloudStorage", "fail KVDataList must be an Array");
                com.baidu.swan.games.utils.a.a(c, false, cVar);
            }
        }
    }

    private boolean isLogin() {
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        if (Md == null) {
            return false;
        }
        return Md.Mi().aD(AppRuntime.getAppContext());
    }

    private JSONObject a(com.baidu.swan.games.o.a.b[] bVarArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", bjF);
            JSONArray jSONArray = new JSONArray();
            for (com.baidu.swan.games.o.a.b bVar : bVarArr) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("key", bVar.key);
                jSONObject2.put(UBC.CONTENT_KEY_VALUE, bVar.value);
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

    private com.baidu.swan.games.o.a.b[] a(com.baidu.swan.games.binding.model.c cVar, JsObject[] jsObjectArr, com.baidu.swan.games.o.a.c cVar2) {
        int length = jsObjectArr.length;
        if (length < 1) {
            cVar2.errMsg = com.baidu.swan.games.utils.a.bj("setUserCloudStorage", "fail KVDataList.length must greater than 0");
            com.baidu.swan.games.utils.a.a(cVar, false, cVar2);
            return null;
        } else if (length > 128) {
            cVar2.errMsg = com.baidu.swan.games.utils.a.bj("setUserCloudStorage", "fail user has stored too much keys. delete some keys and try again");
            com.baidu.swan.games.utils.a.a(cVar, false, cVar2);
            return null;
        } else {
            com.baidu.swan.games.o.a.b[] bVarArr = new com.baidu.swan.games.o.a.b[length];
            for (int i = 0; i < length; i++) {
                com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObjectArr[i]);
                if (c == null || c.length() != 2 || TextUtils.isEmpty(c.optString("key")) || TextUtils.isEmpty(c.optString(UBC.CONTENT_KEY_VALUE))) {
                    cVar2.errMsg = com.baidu.swan.games.utils.a.bj("setUserCloudStorage", "fail invalid KVData item");
                    com.baidu.swan.games.utils.a.a(cVar, false, cVar2);
                    return null;
                }
                bVarArr[i] = new com.baidu.swan.games.o.a.b();
                bVarArr[i].key = c.optString("key");
                bVarArr[i].value = c.optString(UBC.CONTENT_KEY_VALUE);
                if (!bVarArr[i].SL()) {
                    cVar2.errMsg = com.baidu.swan.games.utils.a.bj("setUserCloudStorage", "fail some keys in list meet length exceed");
                    com.baidu.swan.games.utils.a.a(cVar, false, cVar2);
                    return null;
                } else if (!bVarArr[i].SM()) {
                    cVar2.errMsg = com.baidu.swan.games.utils.a.bj("setUserCloudStorage", "fail some key-value in list meet length exceed");
                    com.baidu.swan.games.utils.a.a(cVar, false, cVar2);
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

    @JavascriptInterface
    public void getFollowCloudStorage(JsObject jsObject) {
        a(jsObject, 6);
    }

    private void a(JsObject jsObject, int i) {
        final String str;
        final com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c != null) {
            if (i == 6) {
                str = "getFollowCloudStorage";
            } else if (i == 5) {
                str = "getFriendCloudStorage";
            } else {
                return;
            }
            final com.baidu.swan.games.o.a.c cVar = new com.baidu.swan.games.o.a.c();
            if (!isLogin()) {
                cVar.errNo = "400";
                cVar.errMsg = com.baidu.swan.games.utils.a.bj(str, "fail must login before calling");
                com.baidu.swan.games.utils.a.a(c, false, cVar);
                return;
            }
            try {
                a(i, c.iU("keyList"), new ResponseCallback<JSONObject>() { // from class: com.baidu.swan.games.o.c.5
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
                        String optString = jSONObject.optString("errno");
                        if (!TextUtils.equals(optString, "0")) {
                            if (a.DEBUG) {
                                Log.d("OpenDataApi", "errno = " + optString);
                            }
                            cVar.errNo = optString;
                            cVar.errMsg = String.format("%s: fail Error: %s", str, jSONObject.optString("errmsg"));
                            return null;
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("errNo", "0");
                        jSONObject2.put("errMsg", com.baidu.swan.games.utils.a.bj(str, "ok"));
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
                        c.this.bjG.l(new Runnable() { // from class: com.baidu.swan.games.o.c.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.swan.games.utils.a.a(c, true, jSONObject);
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
                            cVar.errMsg = String.format("%s: fail Error: %s", str, exc.getMessage());
                        }
                        c.this.bjG.l(new Runnable() { // from class: com.baidu.swan.games.o.c.5.2
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.swan.games.utils.a.a(c, false, cVar);
                            }
                        });
                    }
                });
            } catch (JSTypeMismatchException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                cVar.errNo = "400";
                cVar.errMsg = com.baidu.swan.games.utils.a.bj(str, "fail invalid keyList");
                com.baidu.swan.games.utils.a.a(c, false, cVar);
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
            jSONObject.put("ma_id", bjF);
            jSONObject.put("key_list", jSONArray);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        a(fa(i), jSONObject.toString(), responseCallback);
    }

    private String fa(int i) {
        String xc;
        switch (i) {
            case 1:
                xc = com.baidu.swan.apps.u.a.Ew().wX();
                break;
            case 2:
                xc = com.baidu.swan.apps.u.a.Ew().wY();
                break;
            case 3:
                xc = com.baidu.swan.apps.u.a.Ew().wZ();
                break;
            case 4:
                xc = com.baidu.swan.apps.u.a.Ew().xa();
                break;
            case 5:
                xc = com.baidu.swan.apps.u.a.Ew().xb();
                break;
            case 6:
                xc = com.baidu.swan.apps.u.a.Ew().xc();
                break;
            default:
                xc = "";
                break;
        }
        if (TextUtils.isEmpty(xc)) {
            Log.e("OpenDataApi", "getUrlByType（）meet empty url !");
        }
        return xc;
    }
}
