package com.baidu.searchbox.ng.ai.apps.safe.webview;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.io.AiAppsFile;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rx.d;
import rx.j;
import rx.schedulers.Schedulers;
/* loaded from: classes2.dex */
public class WebSafeWhiteListMgr {
    public static final String AIAPPS_FILE_DIR = "aiapps_folder/cloud_config";
    public static final boolean DEBUG = false;
    public static final String KEY_DATA = "data";
    public static final String KEY_TOKEN = "token";
    public static final String TAG = "WebSafeWhiteListMgr";
    public static final String WEB_ACTIONS_FILE_NAME = "global_web_actions.json";
    public static final String WEB_DOMAINS_FILE_NAME = "web_domains.json";

    public static void getWebDomains(boolean z, String str, @NonNull final WebSafeData webSafeData) {
        if (!TextUtils.isEmpty(str)) {
            if (webSafeData == null) {
            }
            final String str2 = AppRuntime.getAppContext().getFilesDir().getPath() + "/" + AIAPPS_FILE_DIR + "/" + str + BaseRequestAction.SPLITE + WEB_DOMAINS_FILE_NAME;
            if (z) {
                d.create(new d.a<String>() { // from class: com.baidu.searchbox.ng.ai.apps.safe.webview.WebSafeWhiteListMgr.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    public void call(j<? super String> jVar) {
                        WebSafeWhiteListMgr.loadWebSafeDataFromFile(str2, webSafeData);
                    }
                }).subscribeOn(Schedulers.io()).subscribe((j) new j<String>() { // from class: com.baidu.searchbox.ng.ai.apps.safe.webview.WebSafeWhiteListMgr.1
                    @Override // rx.e
                    public void onCompleted() {
                    }

                    @Override // rx.e
                    public void onError(Throwable th) {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.e
                    public void onNext(String str3) {
                    }
                });
            } else {
                loadWebSafeDataFromFile(str2, webSafeData);
            }
        }
    }

    public static void getWebActions(boolean z, @NonNull final WebSafeData webSafeData) {
        if (webSafeData == null) {
        }
        final String str = AppRuntime.getAppContext().getFilesDir().getPath() + "/" + AIAPPS_FILE_DIR + "/" + WEB_ACTIONS_FILE_NAME;
        if (z) {
            d.create(new d.a<String>() { // from class: com.baidu.searchbox.ng.ai.apps.safe.webview.WebSafeWhiteListMgr.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(j<? super String> jVar) {
                    WebSafeWhiteListMgr.loadWebSafeDataFromFile(str, webSafeData);
                }
            }).subscribeOn(Schedulers.io()).subscribe((j) new j<String>() { // from class: com.baidu.searchbox.ng.ai.apps.safe.webview.WebSafeWhiteListMgr.3
                @Override // rx.e
                public void onCompleted() {
                }

                @Override // rx.e
                public void onError(Throwable th) {
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.e
                public void onNext(String str2) {
                }
            });
        } else {
            loadWebSafeDataFromFile(str, webSafeData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void loadWebSafeDataFromFile(String str, WebSafeData webSafeData) {
        String readFile = AiAppsFile.readFile(str);
        if (!TextUtils.isEmpty(readFile)) {
            try {
                webSafeData.parseFromJSON(new JSONObject(readFile));
            } catch (JSONException e) {
            }
        }
    }

    public static boolean saveWebDomains(String str, String str2, JSONArray jSONArray) {
        if (TextUtils.isEmpty(str) || jSONArray == null) {
            return false;
        }
        String str3 = AppRuntime.getAppContext().getFilesDir().getPath() + "/" + AIAPPS_FILE_DIR + "/" + str + BaseRequestAction.SPLITE + WEB_DOMAINS_FILE_NAME;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("token", str2);
            }
            jSONObject.put("data", jSONArray);
            return AiAppsFile.writeFile(str3, jSONObject.toString(), false);
        } catch (JSONException e) {
            return false;
        }
    }

    public static boolean saveWebActions(String str, JSONArray jSONArray) {
        if (jSONArray == null) {
            return false;
        }
        String str2 = AppRuntime.getAppContext().getFilesDir().getPath() + "/" + AIAPPS_FILE_DIR + "/" + WEB_ACTIONS_FILE_NAME;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("token", str);
            }
            jSONObject.put("data", jSONArray);
            new AiAppsFile();
            return AiAppsFile.writeFile(str2, jSONObject.toString(), false);
        } catch (JSONException e) {
            return false;
        }
    }

    public static void getAdLandingWebActions(WebSafeData webSafeData) {
        if (webSafeData == null) {
        }
        webSafeData.data = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class WebSafeData {
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
                        }
                    }
                }
            }
        }
    }
}
