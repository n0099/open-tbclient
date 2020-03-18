package com.baidu.swan.config.c;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.config.e;
import com.baidu.swan.d.h;
import com.tencent.open.SocialOperation;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private static volatile c cfE;
    private volatile boolean cfG = false;
    private a cfF = new a();

    public static c ajh() {
        if (cfE == null) {
            synchronized (c.class) {
                if (cfE == null) {
                    cfE = new c();
                }
            }
        }
        return cfE;
    }

    private c() {
    }

    public int aji() {
        if (this.cfF.contains("version")) {
            return this.cfF.getInt("version", 0);
        }
        if (ajk()) {
            return this.cfF.getInt("version", 0);
        }
        return 0;
    }

    public String getHostName() {
        String ns = ns("hostName");
        if (TextUtils.isEmpty(ns)) {
            if (e.DEBUG) {
                throw new IllegalStateException("获取 HostName-宿主名称 失败");
            }
            return "";
        }
        return ns;
    }

    public String HN() {
        String ns = ns("schemeHead");
        if (TextUtils.isEmpty(ns)) {
            if (e.DEBUG) {
                throw new IllegalStateException("获取 SchemeHead-协议头 失败");
            }
            return "";
        }
        return ns;
    }

    public Set<String> ajj() {
        Set<String> stringSet = this.cfF.getStringSet(SocialOperation.GAME_SIGNATURE, null);
        if (stringSet == null) {
            if (ajk()) {
                return this.cfF.getStringSet(SocialOperation.GAME_SIGNATURE, null);
            }
            return null;
        }
        return stringSet;
    }

    public String h(String str, int i, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String ns = ns("shareCallBackUrl");
        if (!TextUtils.isEmpty(ns)) {
            String addParam = h.addParam(h.addParam(ns, "type", String.valueOf(i)), "appKey", str);
            if (!TextUtils.isEmpty(str2)) {
                return h.addParam(addParam, "path", str2);
            }
            return addParam;
        }
        return "";
    }

    public void d(String str, String str2, String str3, int i) {
        a(str, str2, str3, i, null);
    }

    private void a(String str, String str2, String str3, int i, Set<String> set) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && i >= 0) {
            SharedPreferences.Editor putInt = this.cfF.edit().putString("hostName", str).putString("schemeHead", str2).putString("shareCallBackUrl", str3).putInt("version", i);
            if (set != null && !set.isEmpty()) {
                putInt.putStringSet(SocialOperation.GAME_SIGNATURE, set);
            }
            putInt.apply();
        }
    }

    private String ns(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String string = this.cfF.getString(str, "");
        if (TextUtils.isEmpty(string)) {
            if (ajk()) {
                String string2 = this.cfF.getString(str, "");
                if (TextUtils.isEmpty(string2)) {
                    return null;
                }
                return string2;
            }
            return null;
        }
        return string;
    }

    private synchronized boolean ajk() {
        boolean z;
        HashSet hashSet = null;
        synchronized (this) {
            if (this.cfG) {
                z = true;
            } else {
                String readAssetData = com.baidu.swan.d.c.readAssetData(AppRuntime.getAppContext(), "config/union-cfg.json");
                if (TextUtils.isEmpty(readAssetData)) {
                    File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_config/union-cfg.json");
                    readAssetData = file.exists() ? com.baidu.swan.d.c.readFileData(file) : null;
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
                        this.cfG = true;
                        z = true;
                    } catch (JSONException e) {
                        if (e.DEBUG) {
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
    public static class a extends com.baidu.swan.d.e {
        a() {
            super("swan_host_info_config_sp_name");
        }
    }
}
