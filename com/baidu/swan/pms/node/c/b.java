package com.baidu.swan.pms.node.c;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.e.j;
import com.baidu.swan.pms.node.Node;
import com.tencent.open.SocialOperation;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private static volatile b drU;
    private volatile boolean cTH = false;
    private a drV = new a();

    public static b aIq() {
        if (drU == null) {
            synchronized (b.class) {
                if (drU == null) {
                    drU = new b();
                }
            }
        }
        return drU;
    }

    private b() {
    }

    public String aIr() {
        if (this.drV.contains("version")) {
            return this.drV.getString("version", "0");
        }
        if (awh()) {
            return this.drV.getString("version", "0");
        }
        return "0";
    }

    public void a(com.baidu.swan.pms.node.c.a aVar) {
        if (aVar != null) {
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.d(Node.TAG, "update host data version " + aVar.mVersion);
            }
            SharedPreferences.Editor putString = this.drV.edit().putString("host_name", aVar.cNZ).putString("scheme_head", aVar.drT).putString("share_callback_url", aVar.drR).putString("content_type", aVar.mContentType).putInt("container_no", aVar.drQ).putInt("official_no", aVar.drP).putString("version", aVar.mVersion);
            if (aVar.drS != null && !aVar.drS.isEmpty()) {
                putString.putStringSet(SocialOperation.GAME_SIGNATURE, aVar.drS);
            }
            putString.apply();
        }
    }

    private void a(String str, String str2, String str3, String str4, Set<String> set) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str4)) {
            SharedPreferences.Editor putString = this.drV.edit().putString("host_name", str).putString("scheme_head", str2).putString("share_callback_url", str3).putString("version", str4);
            if (set != null && !set.isEmpty()) {
                putString.putStringSet(SocialOperation.GAME_SIGNATURE, set);
            }
            putString.apply();
        }
    }

    private synchronized boolean awh() {
        boolean z;
        HashSet hashSet;
        synchronized (this) {
            if (this.cTH) {
                z = true;
            } else {
                String readAssetData = com.baidu.swan.e.d.readAssetData(AppRuntime.getAppContext(), "config/union-cfg.json");
                if (TextUtils.isEmpty(readAssetData)) {
                    File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_config/union-cfg.json");
                    readAssetData = file.exists() ? com.baidu.swan.e.d.readFileData(file) : null;
                }
                if (TextUtils.isEmpty(readAssetData)) {
                    z = false;
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject(readAssetData);
                        String optString = jSONObject.optString("host_name");
                        String optString2 = jSONObject.optString("scheme_head");
                        String optString3 = jSONObject.optString("share_callback_url");
                        int optInt = jSONObject.optInt("version");
                        JSONArray optJSONArray = jSONObject.optJSONArray(SocialOperation.GAME_SIGNATURE);
                        if (optJSONArray == null || optJSONArray.length() <= 0) {
                            hashSet = null;
                        } else {
                            HashSet hashSet2 = new HashSet();
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                hashSet2.add(optJSONArray.optString(i));
                            }
                            hashSet = hashSet2;
                        }
                        a(optString, optString2, optString3, String.valueOf(optInt), hashSet);
                        this.cTH = true;
                        z = true;
                    } catch (JSONException e) {
                        if (com.baidu.swan.pms.d.DEBUG) {
                            e.printStackTrace();
                        }
                        z = false;
                    }
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a extends j {
        a() {
            super("updatecore_node_host");
        }
    }
}
