package com.baidu.swan.config.c;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.e.d;
import com.baidu.swan.e.i;
import com.baidu.swan.e.j;
import com.tencent.open.SocialOperation;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private static volatile c cOV;
    private volatile boolean cOX = false;
    private a cOW = new a();

    public static c auZ() {
        if (cOV == null) {
            synchronized (c.class) {
                if (cOV == null) {
                    cOV = new c();
                }
            }
        }
        return cOV;
    }

    private c() {
    }

    public String getHostName() {
        String qf = qf("hostName");
        if (TextUtils.isEmpty(qf)) {
            if (com.baidu.swan.config.c.DEBUG) {
                throw new IllegalStateException("获取 HostName-宿主名称 失败");
            }
            return "";
        }
        return qf;
    }

    public String sz() {
        String qf = qf("schemeHead");
        if (TextUtils.isEmpty(qf)) {
            if (com.baidu.swan.config.c.DEBUG) {
                throw new IllegalStateException("获取 SchemeHead-协议头 失败");
            }
            return "";
        }
        return qf;
    }

    public Set<String> ava() {
        Set<String> stringSet = this.cOW.getStringSet(SocialOperation.GAME_SIGNATURE, null);
        if (stringSet == null) {
            if (avb()) {
                return this.cOW.getStringSet(SocialOperation.GAME_SIGNATURE, null);
            }
            return null;
        }
        return stringSet;
    }

    public String h(String str, int i, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String qf = qf("shareCallBackUrl");
        if (!TextUtils.isEmpty(qf)) {
            String addParam = i.addParam(i.addParam(qf, "type", String.valueOf(i)), "appKey", str);
            if (!TextUtils.isEmpty(str2)) {
                return i.addParam(addParam, "path", str2);
            }
            return addParam;
        }
        return "";
    }

    private void a(String str, String str2, String str3, int i, Set<String> set) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && i >= 0) {
            SharedPreferences.Editor putInt = this.cOW.edit().putString("hostName", str).putString("schemeHead", str2).putString("shareCallBackUrl", str3).putInt("version", i);
            if (set != null && !set.isEmpty()) {
                putInt.putStringSet(SocialOperation.GAME_SIGNATURE, set);
            }
            putInt.apply();
        }
    }

    private String qf(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String string = this.cOW.getString(str, "");
        if (TextUtils.isEmpty(string)) {
            if (avb()) {
                String string2 = this.cOW.getString(str, "");
                if (TextUtils.isEmpty(string2)) {
                    return null;
                }
                return string2;
            }
            return null;
        }
        return string;
    }

    private synchronized boolean avb() {
        boolean z;
        HashSet hashSet = null;
        synchronized (this) {
            if (this.cOX) {
                z = true;
            } else {
                String readAssetData = d.readAssetData(AppRuntime.getAppContext(), "config/union-cfg.json");
                if (TextUtils.isEmpty(readAssetData)) {
                    File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_config/union-cfg.json");
                    readAssetData = file.exists() ? d.readFileData(file) : null;
                }
                if (TextUtils.isEmpty(readAssetData)) {
                    z = false;
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject(readAssetData);
                        String optString = jSONObject.optString("hostName");
                        String optString2 = jSONObject.optString("schemeHead");
                        String optString3 = jSONObject.optString("shareCallBackUrl");
                        int optInt = jSONObject.optInt("version");
                        JSONArray optJSONArray = jSONObject.optJSONArray(SocialOperation.GAME_SIGNATURE);
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            hashSet = new HashSet();
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                hashSet.add(optJSONArray.optString(i));
                            }
                        }
                        a(optString, optString2, optString3, optInt, hashSet);
                        this.cOX = true;
                        z = true;
                    } catch (JSONException e) {
                        if (com.baidu.swan.config.c.DEBUG) {
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
            super("swan_host_info_config_sp_name");
        }
    }
}
