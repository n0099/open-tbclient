package com.baidu.swan.config.c;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.d.d;
import com.baidu.swan.d.g;
import com.baidu.swan.d.h;
import com.baidu.swan.d.i;
import com.tencent.open.SocialOperation;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    private static volatile c cYi;
    private volatile boolean cYk = false;
    private a cYj = new a();

    public static c ayT() {
        if (cYi == null) {
            synchronized (c.class) {
                if (cYi == null) {
                    cYi = new c();
                }
            }
        }
        return cYi;
    }

    private c() {
    }

    public String getHostName() {
        String rg = rg("hostName");
        if (TextUtils.isEmpty(rg)) {
            if (com.baidu.swan.config.c.DEBUG) {
                throw new IllegalStateException("获取 HostName-宿主名称 失败");
            }
            return "";
        }
        return rg;
    }

    public String sW() {
        String rg = rg("schemeHead");
        if (TextUtils.isEmpty(rg)) {
            if (com.baidu.swan.config.c.DEBUG) {
                throw new IllegalStateException("获取 SchemeHead-协议头 失败");
            }
            return "";
        }
        return rg;
    }

    public Set<String> ayU() {
        Set<String> stringSet = this.cYj.getStringSet(SocialOperation.GAME_SIGNATURE, null);
        if (stringSet == null) {
            if (ayV()) {
                return this.cYj.getStringSet(SocialOperation.GAME_SIGNATURE, null);
            }
            return null;
        }
        return stringSet;
    }

    public String h(String str, int i, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String rg = rg("shareCallBackUrl");
        if (!TextUtils.isEmpty(rg)) {
            String addParam = h.addParam(h.addParam(rg, "type", String.valueOf(i)), "appKey", str);
            if (!TextUtils.isEmpty(str2)) {
                return h.addParam(addParam, "path", g.df(str2));
            }
            return addParam;
        }
        return "";
    }

    private void a(String str, String str2, String str3, int i, Set<String> set) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && i >= 0) {
            SharedPreferences.Editor putInt = this.cYj.edit().putString("hostName", str).putString("schemeHead", str2).putString("shareCallBackUrl", str3).putInt("version", i);
            if (set != null && !set.isEmpty()) {
                putInt.putStringSet(SocialOperation.GAME_SIGNATURE, set);
            }
            putInt.apply();
        }
    }

    private String rg(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String string = this.cYj.getString(str, "");
        if (TextUtils.isEmpty(string)) {
            if (ayV()) {
                String string2 = this.cYj.getString(str, "");
                if (TextUtils.isEmpty(string2)) {
                    return null;
                }
                return string2;
            }
            return null;
        }
        return string;
    }

    private synchronized boolean ayV() {
        boolean z;
        HashSet hashSet = null;
        synchronized (this) {
            if (this.cYk) {
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
                        this.cYk = true;
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
    /* loaded from: classes10.dex */
    public static class a extends i {
        a() {
            super("swan_host_info_config_sp_name");
        }
    }
}
