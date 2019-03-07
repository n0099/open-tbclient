package com.baidu.swan.apps.af.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rx.d;
import rx.j;
import rx.schedulers.Schedulers;
/* loaded from: classes2.dex */
public class c {
    public static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;

    public static void a(boolean z, String str, @NonNull final a aVar) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.w("WebSafeWhiteListMgr", "getWebDomains: appId is empty");
            }
        } else if (aVar == null) {
            if (DEBUG) {
                throw new RuntimeException("Please init webSafeData first!");
            }
        } else {
            final String r = r(str, "aiapps_folder/cloud_config", "web_domains.json");
            if (z) {
                d.a((d.a) new d.a<String>() { // from class: com.baidu.swan.apps.af.a.c.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    public void call(j<? super String> jVar) {
                        if (c.DEBUG) {
                            Log.d("WebSafeWhiteListMgr", "read webdomains from file async");
                        }
                        c.a(aVar, c.gw(r));
                    }
                }).b(Schedulers.io()).b(new j<String>() { // from class: com.baidu.swan.apps.af.a.c.1
                    @Override // rx.e
                    public void onCompleted() {
                        if (c.DEBUG) {
                            Log.d("WebSafeWhiteListMgr", "read webdomains from file async: onCompleted");
                        }
                    }

                    @Override // rx.e
                    public void onError(Throwable th) {
                        if (c.DEBUG) {
                            throw new RuntimeException(th);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.e
                    /* renamed from: gy */
                    public void onNext(String str2) {
                    }
                });
            } else {
                a(aVar, gw(r));
            }
        }
    }

    public static void a(boolean z, String str, final String str2, @NonNull final a aVar) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.w("WebSafeWhiteListMgr", "get serverDomains: appId is empty");
            }
        } else if (aVar == null) {
            if (DEBUG) {
                throw new RuntimeException("Please init webSafeData first!");
            }
        } else {
            final String r = r(str, "aiapps_folder/cloud_config", "server_domains.json");
            if (z) {
                d.a((d.a) new d.a<String>() { // from class: com.baidu.swan.apps.af.a.c.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    public void call(j<? super String> jVar) {
                        if (c.DEBUG) {
                            Log.d("WebSafeWhiteListMgr", "read serverDomains from file async");
                        }
                        c.a(aVar, c.gw(r), str2);
                    }
                }).b(Schedulers.io()).b(new j<String>() { // from class: com.baidu.swan.apps.af.a.c.3
                    @Override // rx.e
                    public void onCompleted() {
                        if (c.DEBUG) {
                            Log.d("WebSafeWhiteListMgr", "read serverDomains from file async: onCompleted");
                        }
                    }

                    @Override // rx.e
                    public void onError(Throwable th) {
                        if (c.DEBUG) {
                            throw new RuntimeException(th);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.e
                    /* renamed from: gy */
                    public void onNext(String str3) {
                    }
                });
            } else {
                a(aVar, gw(r), str2);
            }
        }
    }

    public static void a(boolean z, @NonNull final a aVar) {
        if (aVar == null) {
            if (DEBUG) {
                throw new RuntimeException("Please init webSafeData first!");
            }
            return;
        }
        final String r = r("", "aiapps_folder/cloud_config", "global_web_actions.json");
        if (z) {
            d.a((d.a) new d.a<String>() { // from class: com.baidu.swan.apps.af.a.c.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super String> jVar) {
                    if (c.DEBUG) {
                        Log.d("WebSafeWhiteListMgr", "read web actions from file async");
                    }
                    c.a(aVar, c.gw(r));
                }
            }).b(Schedulers.io()).b(new j<String>() { // from class: com.baidu.swan.apps.af.a.c.5
                @Override // rx.e
                public void onCompleted() {
                    if (c.DEBUG) {
                        Log.d("WebSafeWhiteListMgr", "read web actions from file async: onCompleted");
                    }
                }

                @Override // rx.e
                public void onError(Throwable th) {
                    if (c.DEBUG) {
                        throw new RuntimeException(th);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.e
                /* renamed from: gy */
                public void onNext(String str) {
                }
            });
        } else {
            a(aVar, gw(r));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String gw(String str) {
        if (DEBUG) {
            Log.d("WebSafeWhiteListMgr", "the request webSafeData file path:" + str);
        }
        return com.baidu.swan.apps.t.a.eL(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(a aVar, String str) {
        if (aVar == null) {
            if (DEBUG) {
                throw new RuntimeException("Please init webSafeData first!");
            }
            return;
        }
        try {
            aVar.parseFromJSON(new JSONObject(str));
            if (DEBUG) {
                Log.e("WebSafeWhiteListMgr", "read WebSafeData by loading file: token=" + aVar.token + ", data=" + aVar.data);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("WebSafeWhiteListMgr", Log.getStackTraceString(e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(a aVar, String str, String str2) {
        if (aVar == null) {
            if (DEBUG) {
                throw new RuntimeException("Please init webSafeData first!");
            }
            return;
        }
        try {
            aVar.l(new JSONObject(str), str2);
            if (DEBUG) {
                Log.e("WebSafeWhiteListMgr", "read WebSafeData by loading file:token=" + aVar.token + ", data=" + aVar.data);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("WebSafeWhiteListMgr", Log.getStackTraceString(e));
            }
        }
    }

    public static boolean a(String str, String str2, JSONArray jSONArray) {
        boolean z = false;
        if (TextUtils.isEmpty(str) || jSONArray == null) {
            if (DEBUG) {
                Log.w("WebSafeWhiteListMgr", "saveWebDomains: appId or data is empty");
            }
        } else {
            String r = r(str, "aiapps_folder/cloud_config", "web_domains.json");
            if (DEBUG) {
                Log.d("WebSafeWhiteListMgr", "WebDomains file path: " + r);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("token", str2);
                }
                jSONObject.put("data", jSONArray);
                z = com.baidu.swan.apps.t.a.e(r, jSONObject.toString(), false);
                if (DEBUG) {
                    Log.d("WebSafeWhiteListMgr", "save WebDomains done: appId= " + str + ", token=" + str2 + ", data=" + jSONArray);
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("WebSafeWhiteListMgr", Log.getStackTraceString(e));
                }
            }
        }
        return z;
    }

    public static boolean g(String str, JSONObject jSONObject) {
        boolean z = false;
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            if (DEBUG) {
                Log.d("WebSafeWhiteListMgr", "save serverDomains: appId or data is empty");
            }
        } else {
            String r = r(str, "aiapps_folder/cloud_config", "server_domains.json");
            if (DEBUG) {
                Log.d("WebSafeWhiteListMgr", "serverDomains file path: " + r);
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("data", jSONObject);
                z = com.baidu.swan.apps.t.a.e(r, jSONObject2.toString(), false);
                if (DEBUG) {
                    Log.d("WebSafeWhiteListMgr", "save Server Domains done: data = " + jSONObject);
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("WebSafeWhiteListMgr", Log.getStackTraceString(e));
                }
            }
        }
        return z;
    }

    public static boolean b(String str, JSONArray jSONArray) {
        boolean z = false;
        if (jSONArray == null) {
            if (DEBUG) {
                Log.w("WebSafeWhiteListMgr", "saveWebActions: data is empty");
            }
        } else {
            String r = r("", "aiapps_folder/cloud_config", "global_web_actions.json");
            if (DEBUG) {
                Log.d("WebSafeWhiteListMgr", "WebActions file path: " + r);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("token", str);
                }
                jSONObject.put("data", jSONArray);
                z = com.baidu.swan.apps.t.a.e(r, jSONObject.toString(), false);
                if (DEBUG) {
                    Log.d("WebSafeWhiteListMgr", "save WebActions done: token=" + str + ", data=" + jSONArray);
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("WebSafeWhiteListMgr", Log.getStackTraceString(e));
                }
            }
        }
        return z;
    }

    public static String r(String str, String str2, String str3) {
        String path = AppRuntime.getAppContext().getFilesDir().getPath();
        if (TextUtils.isEmpty(str)) {
            return path + File.separator + str2 + File.separator + str3;
        }
        return path + File.separator + str2 + File.separator + str + "_" + str3;
    }

    public static void a(a aVar) {
        if (aVar == null) {
            if (DEBUG) {
                throw new RuntimeException("Please init webSafeData first!");
            }
            return;
        }
        aVar.data = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        public ArrayList<String> data = new ArrayList<>();
        public String token;

        public void parseFromJSON(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.token = jSONObject.optString("token");
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        try {
                            this.data.add((String) optJSONArray.get(i));
                        } catch (JSONException e) {
                            if (c.DEBUG) {
                                Log.w("WebSafeWhiteListMgr", Log.getStackTraceString(e));
                            }
                        }
                    }
                }
            }
        }

        public void l(JSONObject jSONObject, String str) {
            JSONArray optJSONArray;
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONObject("data").optJSONArray(str)) != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    try {
                        this.data.add((String) optJSONArray.get(i));
                    } catch (JSONException e) {
                        if (c.DEBUG) {
                            Log.w("WebSafeWhiteListMgr", Log.getStackTraceString(e));
                        }
                    }
                }
            }
        }
    }
}
