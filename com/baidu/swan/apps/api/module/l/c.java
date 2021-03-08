package com.baidu.swan.apps.api.module.l;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.adaptation.a.q;
import com.baidu.swan.apps.ao.ab;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
import com.baidu.tbadk.TbConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends com.baidu.swan.apps.api.a.d {
    public c(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b lC(String str) {
        if (DEBUG) {
            Log.d("PreviewImageApi", "params = " + str);
        }
        if (ajS()) {
            com.baidu.swan.apps.console.c.e("PreviewImageApi", "PreviewImageApi does not supported when app is invisible.");
            return new com.baidu.swan.apps.api.c.b(1001, "PreviewImageApi does not supported when app is invisible.");
        } else if (TextUtils.isEmpty(str)) {
            return new com.baidu.swan.apps.api.c.b(202);
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optBoolean("only_support_wifi") && !SwanAppNetworkUtils.isWifiNetworkConnected(getContext())) {
                    return new com.baidu.swan.apps.api.c.b(403);
                }
                String optString = jSONObject.optString("source", "unitedscheme");
                String optString2 = jSONObject.optString("type", "0");
                JSONArray optJSONArray = jSONObject.optJSONArray("urls");
                if (optJSONArray == null || optJSONArray.length() == 0) {
                    return new com.baidu.swan.apps.api.c.b(202);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray(TbConfig.IMAGE_CACHE_DIR_NAME);
                if (optJSONArray2 != null) {
                    t(optJSONArray2);
                    jSONObject.put(TbConfig.IMAGE_CACHE_DIR_NAME, optJSONArray2);
                } else {
                    JSONArray jSONArray = new JSONArray();
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = new JSONObject();
                        String optString3 = optJSONArray.optString(i);
                        jSONObject2.put("url", optString3);
                        String aOb = ab.aOb();
                        if (ab.uf(optString3) && !TextUtils.isEmpty(aOb)) {
                            jSONObject2.put(Config.LAUNCH_REFERER, aOb);
                        }
                        String asG = com.baidu.swan.apps.core.turbo.d.ash().asG();
                        if (DEBUG) {
                            Log.d("PreviewImageApi", "userAgent: " + asG);
                        }
                        if (!TextUtils.isEmpty(asG)) {
                            jSONObject2.put("user_agent", asG);
                        }
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put(TbConfig.IMAGE_CACHE_DIR_NAME, jSONArray);
                }
                if (TextUtils.equals(optString, GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME)) {
                    optJSONArray = s(optJSONArray);
                }
                jSONObject.put("url", optJSONArray);
                jSONObject.put("type", optString2);
                int a2 = a(jSONObject, optJSONArray);
                if (a2 < 0 || a2 >= optJSONArray.length()) {
                    return new com.baidu.swan.apps.api.c.b(202);
                }
                jSONObject.put("index", String.valueOf(a2));
                ArrayMap<String, String> arrayMap = new ArrayMap<>();
                JSONArray optJSONArray3 = jSONObject.optJSONArray(TbConfig.IMAGE_CACHE_DIR_NAME);
                JSONArray optJSONArray4 = jSONObject.optJSONArray("urls");
                JSONArray optJSONArray5 = jSONObject.optJSONArray("url");
                a(arrayMap, optJSONArray3, TbConfig.IMAGE_CACHE_DIR_NAME);
                a(arrayMap, optJSONArray4, "urls");
                a(arrayMap, optJSONArray5, "url");
                if (arrayMap.keySet().size() > 0) {
                    a(jSONObject, arrayMap, optJSONArray3, optJSONArray4, optJSONArray5);
                } else {
                    com.baidu.swan.apps.t.a.axn().i(getContext(), jSONObject);
                }
                return new com.baidu.swan.apps.api.c.b(0);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                return new com.baidu.swan.apps.api.c.b(202);
            }
        }
    }

    private void a(final JSONObject jSONObject, final ArrayMap<String, String> arrayMap, final JSONArray jSONArray, final JSONArray jSONArray2, final JSONArray jSONArray3) {
        if (jSONObject != null && arrayMap != null && arrayMap.keySet().size() > 0) {
            JSONArray jSONArray4 = new JSONArray();
            for (String str : arrayMap.values()) {
                jSONArray4.put(str);
            }
            q axs = com.baidu.swan.apps.t.a.axs();
            if (axs != null) {
                axs.a(getContext(), jSONArray4, new com.baidu.swan.apps.ao.e.b<String>() { // from class: com.baidu.swan.apps.api.module.l.c.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ao.e.b
                    /* renamed from: onCallback */
                    public void N(String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            JSONArray jSONArray5 = null;
                            try {
                                jSONArray5 = new JSONArray(str2);
                            } catch (JSONException e) {
                                if (com.baidu.swan.apps.api.a.d.DEBUG) {
                                    e.printStackTrace();
                                }
                            }
                            if (jSONArray5 != null && jSONArray5.length() > 0) {
                                for (int i = 0; i < jSONArray5.length(); i++) {
                                    JSONObject optJSONObject = jSONArray5.optJSONObject(i);
                                    String optString = optJSONObject.optString("fileID");
                                    String optString2 = optJSONObject.optString("tempFileURL");
                                    if (optJSONObject.optString("status").equals("0") && !TextUtils.isEmpty(optString2)) {
                                        arrayMap.put(optString, optString2);
                                    }
                                }
                                c.this.b(arrayMap, jSONArray, TbConfig.IMAGE_CACHE_DIR_NAME);
                                c.this.b(arrayMap, jSONArray2, "urls");
                                c.this.b(arrayMap, jSONArray3, "url");
                                try {
                                    jSONObject.put(TbConfig.IMAGE_CACHE_DIR_NAME, jSONArray);
                                    jSONObject.put("urls", jSONArray2);
                                    jSONObject.put("url", jSONArray3);
                                } catch (JSONException e2) {
                                    if (com.baidu.swan.apps.api.a.d.DEBUG) {
                                        e2.printStackTrace();
                                    }
                                }
                                com.baidu.swan.apps.t.a.axn().i(c.this.getContext(), jSONObject);
                            }
                        }
                    }
                });
            }
        }
    }

    private void a(ArrayMap<String, String> arrayMap, JSONArray jSONArray, String str) {
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String a2 = a(jSONArray, str, i);
                if (!TextUtils.isEmpty(a2) && com.baidu.swan.apps.storage.b.tl(a2) == PathType.CLOUD) {
                    arrayMap.put(a2, a2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ArrayMap<String, String> arrayMap, JSONArray jSONArray, String str) {
        if (arrayMap != null && jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String str2 = arrayMap.get(a(jSONArray, str, i));
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        if (str.equals(TbConfig.IMAGE_CACHE_DIR_NAME)) {
                            jSONArray.optJSONObject(i).put("url", str2);
                        } else {
                            jSONArray.put(i, str2);
                        }
                    } catch (JSONException e) {
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private String a(JSONArray jSONArray, String str, int i) {
        if (str.equals(TbConfig.IMAGE_CACHE_DIR_NAME)) {
            return jSONArray.optJSONObject(i).optString("url");
        }
        return jSONArray.optString(i);
    }

    private int a(@NonNull JSONObject jSONObject, @NonNull JSONArray jSONArray) throws JSONException {
        int optInt = jSONObject.optInt("current", -1);
        if (optInt < 0) {
            String optString = jSONObject.optString("current");
            if (TextUtils.isEmpty(optString)) {
                return 0;
            }
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (TextUtils.equals(optString, jSONArray.getString(i))) {
                    return i;
                }
            }
            return -1;
        }
        return optInt;
    }

    private JSONArray s(JSONArray jSONArray) {
        com.baidu.swan.apps.runtime.e aIN;
        int length = jSONArray.length();
        if (jSONArray != null && length > 0 && (aIN = com.baidu.swan.apps.runtime.e.aIN()) != null && !TextUtils.isEmpty(aIN.id) && !TextUtils.isEmpty(aIN.getVersion())) {
            for (int i = 0; i < length; i++) {
                try {
                    String optString = jSONArray.optString(i);
                    PathType tl = com.baidu.swan.apps.storage.b.tl(optString);
                    if (tl == PathType.BD_FILE) {
                        optString = com.baidu.swan.apps.storage.b.cx(optString, aIN.id);
                    } else if (tl == PathType.RELATIVE) {
                        optString = com.baidu.swan.apps.storage.b.a(optString, aIN, aIN.getVersion());
                    }
                    if (!TextUtils.isEmpty(optString)) {
                        jSONArray.put(i, optString);
                        if (DEBUG) {
                            Log.e("PreviewImageApi", "convert swan path success：" + optString);
                        }
                    }
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return jSONArray;
    }

    private void t(JSONArray jSONArray) {
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            try {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("url");
                    String aOb = ab.aOb();
                    if (ab.uf(optString) && !TextUtils.isEmpty(aOb)) {
                        optJSONObject.put(Config.LAUNCH_REFERER, aOb);
                    }
                    String asG = com.baidu.swan.apps.core.turbo.d.ash().asG();
                    if (DEBUG) {
                        Log.d("PreviewImageApi", "userAgent: " + asG);
                    }
                    if (!TextUtils.isEmpty(asG)) {
                        optJSONObject.put("user_agent", asG);
                    }
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                    return;
                }
                return;
            }
        }
    }
}
