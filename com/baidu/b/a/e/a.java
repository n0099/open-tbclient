package com.baidu.b.a.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.b.a.a;
import com.baidu.b.a.b.c.c;
import com.baidu.b.a.h.b;
import com.baidu.b.a.h.e;
import com.baidu.b.a.h.g;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.ng.ai.apps.install.subpackage.SubPackageAPSInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static boolean ZI = false;
    private static Context sContext;

    public static synchronized void a(Context context, CookieManager cookieManager) {
        synchronized (a.class) {
            a(context, cookieManager, true);
        }
    }

    public static synchronized void a(Context context, CookieManager cookieManager, boolean z) {
        synchronized (a.class) {
            if (!ZI) {
                ZI = true;
                if (context == null) {
                    throw new RuntimeException("DynamicManager|execute|parameter context should not be null.");
                }
                if (cookieManager == null) {
                    throw new RuntimeException("DynamicManager|execute|parameter cookieManager should not be null.");
                }
                sContext = context;
                com.baidu.b.a.f.e.a.a(HttpManager.newHttpManager(sContext), cookieManager);
                b.aL(z);
            }
        }
    }

    public static synchronized void c(final List<com.baidu.b.a.b.a.a> list, final boolean z) {
        synchronized (a.class) {
            if (!ZI) {
                throw new RuntimeException("DynamicManager has not been init.");
            }
            if (list == null) {
                throw new RuntimeException("DynamicManager|execute|parameter callbacks should not be null.");
            }
            if (list.size() != 0) {
                new Thread(new Runnable() { // from class: com.baidu.b.a.e.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        HashMap hashMap = new HashMap();
                        for (com.baidu.b.a.b.a.a aVar : list) {
                            String str = com.baidu.b.a.a.YM.get(aVar.getChannelId());
                            if (!TextUtils.isEmpty(str)) {
                                if (!hashMap.containsKey(str)) {
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(aVar);
                                    hashMap.put(str, arrayList);
                                } else {
                                    ((List) hashMap.get(str)).add(aVar);
                                }
                            }
                        }
                        for (String str2 : hashMap.keySet()) {
                            com.baidu.b.a.f.e.a.a(str2, a.n(a.p((List) hashMap.get(str2))), a.o(a.p((List) hashMap.get(str2))), a.a(a.p((List) hashMap.get(str2)), a.rG(), z), a.s((List) hashMap.get(str2)));
                        }
                    }
                }).start();
            }
        }
    }

    public static void ad(String str, String str2) {
        com.baidu.b.a.c.b.b.ac(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String rG() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cpu_model", e.sg());
            jSONObject.put("cpu_feature", e.sh());
            jSONObject.put("free_space", e.si());
            jSONObject.put("whole_space", e.sj());
        } catch (JSONException e) {
            Log.e("lib-dynamic", "getEnvStr, e=" + e.getLocalizedMessage());
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, String> n(List<c> list) {
        HashMap hashMap = new HashMap();
        for (c cVar : list) {
            Map<String, String> urlParams = cVar.getUrlParams();
            if (urlParams != null) {
                hashMap.putAll(urlParams);
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, String> o(List<c> list) {
        HashMap hashMap = new HashMap();
        for (c cVar : list) {
            Map<String, String> headerParams = cVar.getHeaderParams();
            if (headerParams != null) {
                hashMap.putAll(headerParams);
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, String> a(List<c> list, String str, boolean z) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("product_id", "1");
            jSONObject.put(com.baidu.fsg.face.base.b.c.c, e.sf());
            jSONObject.put("env", new JSONObject(str));
            StringBuilder sb = new StringBuilder();
            for (c cVar : list) {
                if (!TextUtils.isEmpty(cVar.getChannelId())) {
                    sb.append(cVar.getChannelId()).append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            jSONObject.put("channel_ids", sb.toString());
            JSONObject jSONObject2 = new JSONObject();
            for (c cVar2 : list) {
                if (!TextUtils.isEmpty(cVar2.getChannelName())) {
                    jSONObject2.put(cVar2.getChannelName(), cVar2.getUploadParam() == null ? new JSONArray() : cVar2.getUploadParam());
                }
            }
            jSONObject.put("items", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            for (c cVar3 : list) {
                Map<String, String> commonParams = cVar3.getCommonParams();
                if (commonParams != null) {
                    for (Map.Entry<String, String> entry : commonParams.entrySet()) {
                        if (!TextUtils.isEmpty(entry.getValue())) {
                            jSONObject.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
                Map<String, String> extParams = cVar3.getExtParams();
                if (extParams != null) {
                    for (Map.Entry<String, String> entry2 : extParams.entrySet()) {
                        if (!TextUtils.isEmpty(entry2.getValue())) {
                            jSONObject3.put(entry2.getKey(), entry2.getValue());
                        }
                    }
                }
            }
            jSONObject.put("ext", jSONObject3);
            if (z) {
                jSONObject.put("force", "1");
            }
        } catch (JSONException e) {
            Log.e("lib-dynamic", "composeUploadBodyParamMap, e=" + e.getLocalizedMessage());
        }
        hashMap.put("data", jSONObject.toString());
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<c> p(List<com.baidu.b.a.b.a.a> list) {
        ArrayList arrayList = new ArrayList();
        for (final com.baidu.b.a.b.a.a aVar : list) {
            arrayList.add(new c() { // from class: com.baidu.b.a.e.a.2
                @Override // com.baidu.b.a.b.c.c
                public String getChannelName() {
                    return com.baidu.b.a.b.a.a.this.getChannelName();
                }

                @Override // com.baidu.b.a.b.c.c
                public String getChannelId() {
                    return com.baidu.b.a.b.a.a.this.getChannelId();
                }

                @Override // com.baidu.b.a.b.c.c
                public Map<String, String> getUrlParams() {
                    return com.baidu.b.a.b.a.a.this.getUrlParams();
                }

                @Override // com.baidu.b.a.b.c.c
                public Map<String, String> getHeaderParams() {
                    return com.baidu.b.a.b.a.a.this.getHeaderParams();
                }

                @Override // com.baidu.b.a.b.c.c
                public Map<String, String> getCommonParams() {
                    return com.baidu.b.a.b.a.a.this.getCommonParams();
                }

                @Override // com.baidu.b.a.b.c.c
                public Map<String, String> getExtParams() {
                    return com.baidu.b.a.b.a.a.this.getExtParams();
                }

                @Override // com.baidu.b.a.b.c.c
                public JSONArray getUploadParam() {
                    return com.baidu.b.a.b.a.a.this.getUploadParam();
                }
            });
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<com.baidu.b.a.b.c.b> q(List<com.baidu.b.a.b.a.a> list) {
        ArrayList arrayList = new ArrayList();
        for (final com.baidu.b.a.b.a.a aVar : list) {
            arrayList.add(new com.baidu.b.a.b.c.b() { // from class: com.baidu.b.a.e.a.3
                @Override // com.baidu.b.a.b.c.b
                public String getChannelId() {
                    return com.baidu.b.a.b.a.a.this.getChannelId();
                }

                @Override // com.baidu.b.a.b.c.b
                public String getPackageName() {
                    return com.baidu.b.a.b.a.a.this.getPackageName();
                }

                @Override // com.baidu.b.a.b.c.b
                public int getDownloadOptions() {
                    return com.baidu.b.a.b.a.a.this.getDownloadOptions();
                }

                @Override // com.baidu.b.a.b.c.b
                public Map<String, Integer> getOptions() {
                    return com.baidu.b.a.b.a.a.this.getOptions();
                }

                @Override // com.baidu.b.a.b.c.b
                public String getDownloadPath() {
                    return com.baidu.b.a.b.a.a.this.getDownloadPath();
                }

                @Override // com.baidu.b.a.b.c.b
                public List<com.baidu.b.a.c.a.a> getDownloadItems() {
                    return com.baidu.b.a.b.a.a.this.getDownloadItems();
                }

                @Override // com.baidu.b.a.b.c.b
                public void onDownloading(com.baidu.b.a.b.b.a aVar2) {
                    com.baidu.b.a.b.a.a.this.onDownloading(aVar2);
                }

                @Override // com.baidu.b.a.b.c.b
                public void onDownloadStart(String str) {
                    com.baidu.b.a.b.a.a.this.onDownloadStart(str);
                }

                @Override // com.baidu.b.a.b.c.b
                public void onFileProgress(String str, long j, long j2) {
                    com.baidu.b.a.b.a.a.this.onFileProgress(str, j, j2);
                }

                @Override // com.baidu.b.a.b.c.b
                public void onFilePause(com.baidu.b.a.b.b.a aVar2) {
                    com.baidu.b.a.b.a.a.this.onFilePause(aVar2);
                }

                @Override // com.baidu.b.a.b.c.b
                public void onFileCancel(com.baidu.b.a.b.b.a aVar2) {
                    com.baidu.b.a.b.a.a.this.onFileCancel(aVar2);
                }

                @Override // com.baidu.b.a.b.c.b
                public void onDownloadError(com.baidu.b.a.b.b.a aVar2) {
                    com.baidu.b.a.b.a.a.this.onDownloadError(aVar2);
                }

                @Override // com.baidu.b.a.b.c.b
                public void onFileDownloaded(com.baidu.b.a.b.b.a aVar2, com.baidu.b.a.c.a.a aVar3) {
                    com.baidu.b.a.b.a.a.this.onFileDownloaded(aVar2, aVar3);
                }

                @Override // com.baidu.b.a.b.c.b
                public void onBulkDownloaded(List<com.baidu.b.a.c.a.a> list2, List<com.baidu.b.a.c.a.a> list3, List<com.baidu.b.a.c.a.a> list4) {
                    com.baidu.b.a.b.a.a.this.onBulkDownloaded(list2, list3, list4);
                }
            });
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<com.baidu.b.a.b.c.a> r(List<com.baidu.b.a.b.a.a> list) {
        ArrayList arrayList = new ArrayList();
        for (final com.baidu.b.a.b.a.a aVar : list) {
            arrayList.add(new com.baidu.b.a.b.c.a() { // from class: com.baidu.b.a.e.a.4
                @Override // com.baidu.b.a.b.c.a
                public String getChannelName() {
                    return com.baidu.b.a.b.a.a.this.getChannelName();
                }

                @Override // com.baidu.b.a.b.c.a
                public void onReceiveItems(JSONArray jSONArray, JSONArray jSONArray2) {
                    com.baidu.b.a.b.a.a.this.onReceiveItems(jSONArray, jSONArray2);
                }
            });
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ResponseCallback<String> s(final List<com.baidu.b.a.b.a.a> list) {
        return new ResponseCallback<String>() { // from class: com.baidu.b.a.e.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public String parseResponse(Response response, int i) throws Exception {
                return (response == null || response.body() == null) ? "" : response.body().string();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: v */
            public void onSuccess(String str, int i) {
                Iterator it;
                JSONObject jSONObject;
                Iterator it2;
                Iterator it3;
                if (i == 200) {
                    com.baidu.b.a.f.a.a cS = a.cS(str);
                    if (cS != null) {
                        if (!a.a(cS)) {
                            int errorCode = cS.getErrorCode();
                            String errorMessage = cS.getErrorMessage();
                            if (errorCode != 0) {
                                for (com.baidu.b.a.b.a.a aVar : list) {
                                    aVar.onFetchError(new com.baidu.b.a.b.b.a(SubPackageAPSInfo.RESULT_APS_NO_PACKAGE, errorMessage, a.C0056a.C0057a.YP));
                                }
                                String str2 = "";
                                while (true) {
                                    String str3 = str2;
                                    if (list.iterator().hasNext()) {
                                        str2 = str3 + ((com.baidu.b.a.b.a.a) it.next()).getChannelId() + ",";
                                    } else {
                                        g.sk().b(SubPackageAPSInfo.RESULT_APS_NO_PACKAGE, errorMessage, str3);
                                        return;
                                    }
                                }
                            }
                        }
                        com.baidu.b.a.c.c.a.a(cS, a.r(list));
                        com.baidu.b.a.f.b.a.w(a.q(list));
                        return;
                    }
                    try {
                        new JSONObject().put("response", str);
                    } catch (Exception e) {
                        Log.e("lib-dynamic", "createResponseCallback.onSuccess, e=" + e.getLocalizedMessage());
                    }
                    for (com.baidu.b.a.b.a.a aVar2 : list) {
                        aVar2.onFetchError(new com.baidu.b.a.b.b.a(SubPackageAPSInfo.RESULT_APS_DOWNLOAD_ERROR, "metadata : parse response error - ,errmsg:" + jSONObject.toString(), a.C0056a.C0057a.YQ));
                    }
                    String str4 = "";
                    while (true) {
                        String str5 = str4;
                        if (list.iterator().hasNext()) {
                            str4 = str5 + ((com.baidu.b.a.b.a.a) it2.next()).getChannelId() + ",";
                        } else {
                            g.sk().b(SubPackageAPSInfo.RESULT_APS_DOWNLOAD_ERROR, "metadata : parse response error - ,errmsg:" + jSONObject.toString(), str5);
                            return;
                        }
                    }
                } else {
                    for (com.baidu.b.a.b.a.a aVar3 : list) {
                        aVar3.onFetchError(new com.baidu.b.a.b.b.a(2105, "metadata : network error. http code=" + i, a.C0056a.C0057a.YO));
                    }
                    String str6 = "";
                    while (true) {
                        String str7 = str6;
                        if (list.iterator().hasNext()) {
                            str6 = str7 + ((com.baidu.b.a.b.a.a) it3.next()).getChannelId() + ",";
                        } else {
                            g.sk().b(2105, "metadata : network error. http code=" + i, str7);
                            return;
                        }
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                Iterator it;
                for (com.baidu.b.a.b.a.a aVar : list) {
                    aVar.onFetchError(new com.baidu.b.a.b.b.a(2101, exc.getMessage(), a.C0056a.C0057a.YN));
                }
                String str = "";
                while (true) {
                    String str2 = str;
                    if (list.iterator().hasNext()) {
                        str = str2 + ((com.baidu.b.a.b.a.a) it.next()).getChannelId() + ",";
                    } else {
                        g.sk().b(2101, exc.getMessage(), str2);
                        return;
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.baidu.b.a.f.a.a cS(String str) {
        com.baidu.b.a.f.a.a cU;
        if (TextUtils.isEmpty(str) || (cU = com.baidu.b.a.f.a.a.cU(str)) == null) {
            return null;
        }
        if (a(cU) && (cU.rH() == null || cU.rI() == null)) {
            return null;
        }
        return cU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(com.baidu.b.a.f.a.a aVar) {
        return aVar.getErrorCode() == 0;
    }
}
