package com.baidu.swan.pms.node.c;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.c.i;
import com.baidu.swan.pms.node.Node;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.tencent.open.SocialOperation;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    private static volatile b eoJ;
    private volatile boolean dPk = false;
    private a eoK = new a();

    public static b beT() {
        if (eoJ == null) {
            synchronized (b.class) {
                if (eoJ == null) {
                    eoJ = new b();
                }
            }
        }
        return eoJ;
    }

    private b() {
    }

    public String beU() {
        if (this.eoK.contains("version")) {
            return this.eoK.getString("version", "0");
        }
        if (aRo()) {
            return this.eoK.getString("version", "0");
        }
        return "0";
    }

    public void a(com.baidu.swan.pms.node.c.a aVar) {
        if (aVar != null) {
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.d(Node.TAG, "update host data version " + aVar.mVersion);
            }
            SharedPreferences.Editor putString = this.eoK.edit().putString("hostName", aVar.dIu).putString("schemeHead", aVar.eoI).putString("shareCallbackUrl", aVar.eoG).putString(CameraActivityConfig.KEY_CONTENT_TYPE, aVar.mContentType).putInt("containerNo", aVar.eoF).putInt("officialNo", aVar.eoE).putString("version", aVar.mVersion);
            if (aVar.eoH != null && !aVar.eoH.isEmpty()) {
                putString.putStringSet(SocialOperation.GAME_SIGNATURE, aVar.eoH);
            }
            putString.apply();
        }
    }

    private void a(String str, String str2, String str3, String str4, Set<String> set) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str4)) {
            SharedPreferences.Editor putString = this.eoK.edit().putString("hostName", str).putString("schemeHead", str2).putString("shareCallbackUrl", str3).putString("version", str4);
            if (set != null && !set.isEmpty()) {
                putString.putStringSet(SocialOperation.GAME_SIGNATURE, set);
            }
            putString.apply();
        }
    }

    private synchronized boolean aRo() {
        boolean z;
        HashSet hashSet;
        synchronized (this) {
            if (this.dPk) {
                z = true;
            } else {
                String readAssetData = com.baidu.swan.c.d.readAssetData(AppRuntime.getAppContext(), "config/union-cfg.json");
                if (TextUtils.isEmpty(readAssetData)) {
                    File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_config/union-cfg.json");
                    readAssetData = file.exists() ? com.baidu.swan.c.d.readFileData(file) : null;
                }
                if (TextUtils.isEmpty(readAssetData)) {
                    z = false;
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject(readAssetData);
                        String optString = jSONObject.optString("hostName");
                        String optString2 = jSONObject.optString("schemeHead");
                        String optString3 = jSONObject.optString("shareCallbackUrl");
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
                        this.dPk = true;
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
    /* loaded from: classes6.dex */
    public static class a extends i {
        a() {
            super("updatecore_node_host");
        }
    }
}
