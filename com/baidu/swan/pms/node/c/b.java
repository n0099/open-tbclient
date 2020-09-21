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
/* loaded from: classes24.dex */
public class b {
    private static volatile b dIZ;
    private volatile boolean djz = false;
    private a dJa = new a();

    public static b aVt() {
        if (dIZ == null) {
            synchronized (b.class) {
                if (dIZ == null) {
                    dIZ = new b();
                }
            }
        }
        return dIZ;
    }

    private b() {
    }

    public String aVu() {
        if (this.dJa.contains("version")) {
            return this.dJa.getString("version", "0");
        }
        if (aHO()) {
            return this.dJa.getString("version", "0");
        }
        return "0";
    }

    public void a(com.baidu.swan.pms.node.c.a aVar) {
        if (aVar != null) {
            if (com.baidu.swan.pms.d.DEBUG) {
                Log.d(Node.TAG, "update host data version " + aVar.mVersion);
            }
            SharedPreferences.Editor putString = this.dJa.edit().putString("hostName", aVar.dcC).putString("schemeHead", aVar.dIY).putString("shareCallbackUrl", aVar.dIW).putString(CameraActivityConfig.KEY_CONTENT_TYPE, aVar.mContentType).putInt("containerNo", aVar.dIV).putInt("officialNo", aVar.dIU).putString("version", aVar.mVersion);
            if (aVar.dIX != null && !aVar.dIX.isEmpty()) {
                putString.putStringSet(SocialOperation.GAME_SIGNATURE, aVar.dIX);
            }
            putString.apply();
        }
    }

    private void a(String str, String str2, String str3, String str4, Set<String> set) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str4)) {
            SharedPreferences.Editor putString = this.dJa.edit().putString("hostName", str).putString("schemeHead", str2).putString("shareCallbackUrl", str3).putString("version", str4);
            if (set != null && !set.isEmpty()) {
                putString.putStringSet(SocialOperation.GAME_SIGNATURE, set);
            }
            putString.apply();
        }
    }

    private synchronized boolean aHO() {
        boolean z;
        HashSet hashSet;
        synchronized (this) {
            if (this.djz) {
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
                        this.djz = true;
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
    /* loaded from: classes24.dex */
    public static class a extends i {
        a() {
            super("updatecore_node_host");
        }
    }
}
