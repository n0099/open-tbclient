package com.baidu.swan.apps.ag.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

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
            final String M = M(str, "aiapps_folder/cloud_config", "web_domains.json");
            if (z) {
                ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.ag.a.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.DEBUG) {
                            Log.d("WebSafeWhiteListMgr", "read webdomains from file async");
                        }
                        c.a(aVar, c.rQ(M));
                    }
                }, "load-WebDomains", 2);
            } else {
                a(aVar, rQ(M));
            }
        }
    }

    public static boolean rP(String str) {
        return new File(M(str, "aiapps_folder/cloud_config", "web_domains.json")).exists();
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
            final String M = M(str, "aiapps_folder/cloud_config", "server_domains.json");
            if (z) {
                ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.ag.a.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.DEBUG) {
                            Log.d("WebSafeWhiteListMgr", "read serverDomains from file async");
                        }
                        c.a(aVar, c.rQ(M), str2);
                    }
                }, "load-ServerDomains", 2);
            } else {
                a(aVar, rQ(M), str2);
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
        final String M = M("", "aiapps_folder/cloud_config", "global_web_actions.json");
        if (z) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.ag.a.c.3
                @Override // java.lang.Runnable
                public void run() {
                    if (c.DEBUG) {
                        Log.d("WebSafeWhiteListMgr", "read web actions from file async");
                    }
                    c.a(aVar, c.rQ(M));
                }
            }, "load-WebActions", 2);
        } else {
            a(aVar, rQ(M));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String rQ(String str) {
        if (DEBUG) {
            Log.d("WebSafeWhiteListMgr", "the request webSafeData file path:" + str);
        }
        return com.baidu.swan.apps.s.a.op(str);
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
            aVar.v(new JSONObject(str), str2);
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
            String M = M(str, "aiapps_folder/cloud_config", "web_domains.json");
            if (DEBUG) {
                Log.d("WebSafeWhiteListMgr", "WebDomains file path: " + M);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("token", str2);
                }
                jSONObject.put("data", jSONArray);
                z = com.baidu.swan.apps.s.a.l(M, jSONObject.toString(), false);
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
            String M = M(str, "aiapps_folder/cloud_config", "server_domains.json");
            if (DEBUG) {
                Log.d("WebSafeWhiteListMgr", "serverDomains file path: " + M);
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("data", jSONObject);
                z = com.baidu.swan.apps.s.a.l(M, jSONObject2.toString(), false);
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

    public static boolean a(String str, JSONArray jSONArray) {
        boolean z = false;
        if (jSONArray == null) {
            if (DEBUG) {
                Log.w("WebSafeWhiteListMgr", "saveWebActions: data is empty");
            }
        } else {
            String M = M("", "aiapps_folder/cloud_config", "global_web_actions.json");
            if (DEBUG) {
                Log.d("WebSafeWhiteListMgr", "WebActions file path: " + M);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("token", str);
                }
                jSONObject.put("data", jSONArray);
                z = com.baidu.swan.apps.s.a.l(M, jSONObject.toString(), false);
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

    public static String M(String str, String str2, String str3) {
        String path = AppRuntime.getAppContext().getFilesDir().getPath();
        if (TextUtils.isEmpty(str)) {
            return path + File.separator + str2 + File.separator + str3;
        }
        return path + File.separator + str2 + File.separator + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3;
    }

    public static void a(a aVar) {
        if (aVar == null) {
            if (DEBUG) {
                throw new RuntimeException("Please init webSafeData first!");
            }
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("swanAPI/installApp4Ad");
        arrayList.add("swanAPI/openApp4Ad");
        arrayList.add("swanAPI/checkAppInstalled");
        aVar.data = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
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

        public void v(JSONObject jSONObject, String str) {
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
