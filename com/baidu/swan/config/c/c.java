package com.baidu.swan.config.c;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.c.d;
import com.baidu.swan.c.g;
import com.baidu.swan.c.h;
import com.baidu.swan.c.i;
import com.tencent.open.SocialOperation;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {
    private static volatile c dJS;
    private volatile boolean dJU = false;
    private a dJT = new a();

    public static c aOP() {
        if (dJS == null) {
            synchronized (c.class) {
                if (dJS == null) {
                    dJS = new c();
                }
            }
        }
        return dJS;
    }

    private c() {
    }

    public String getHostName() {
        String vb = vb("hostName");
        if (TextUtils.isEmpty(vb)) {
            if (com.baidu.swan.config.c.DEBUG) {
                throw new IllegalStateException("获取 HostName-宿主名称 失败");
            }
            return "";
        }
        return vb;
    }

    public String vb() {
        String vb = vb("schemeHead");
        if (TextUtils.isEmpty(vb)) {
            if (com.baidu.swan.config.c.DEBUG) {
                throw new IllegalStateException("获取 SchemeHead-协议头 失败");
            }
            return "";
        }
        return vb;
    }

    public String ahK() {
        String vb = vb("appKey");
        if (TextUtils.isEmpty(vb)) {
            if (com.baidu.swan.config.c.DEBUG) {
                throw new IllegalStateException("获取 host app key 失败");
            }
            return "";
        }
        return vb;
    }

    public Set<String> aOQ() {
        Set<String> stringSet = this.dJT.getStringSet(SocialOperation.GAME_SIGNATURE, null);
        if (stringSet == null) {
            if (aOR()) {
                return this.dJT.getStringSet(SocialOperation.GAME_SIGNATURE, null);
            }
            return null;
        }
        return stringSet;
    }

    public String k(String str, int i, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String vb = vb("shareCallBackUrl");
        if (!TextUtils.isEmpty(vb)) {
            String addParam = h.addParam(h.addParam(vb, "type", String.valueOf(i)), "appKey", str);
            if (!TextUtils.isEmpty(str2)) {
                return h.addParam(addParam, "path", g.dy(str2));
            }
            return addParam;
        }
        return "";
    }

    private void a(String str, String str2, String str3, String str4, int i, Set<String> set) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && i >= 0) {
            SharedPreferences.Editor putInt = this.dJT.edit().putString("hostName", str).putString("schemeHead", str2).putString("appKey", str3).putString("shareCallBackUrl", str4).putInt("version", i);
            if (set != null && !set.isEmpty()) {
                putInt.putStringSet(SocialOperation.GAME_SIGNATURE, set);
            }
            putInt.apply();
        }
    }

    private String vb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String string = this.dJT.getString(str, "");
        if (TextUtils.isEmpty(string)) {
            if (aOR()) {
                String string2 = this.dJT.getString(str, "");
                if (TextUtils.isEmpty(string2)) {
                    return null;
                }
                return string2;
            }
            return null;
        }
        return string;
    }

    private synchronized boolean aOR() {
        boolean z;
        HashSet hashSet = null;
        synchronized (this) {
            if (this.dJU) {
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
                        String optString3 = jSONObject.optString("appKey");
                        String optString4 = jSONObject.optString("shareCallBackUrl");
                        int optInt = jSONObject.optInt("version");
                        JSONArray optJSONArray = jSONObject.optJSONArray(SocialOperation.GAME_SIGNATURE);
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            hashSet = new HashSet();
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                hashSet.add(optJSONArray.optString(i));
                            }
                        }
                        a(optString, optString2, optString3, optString4, optInt, hashSet);
                        this.dJU = true;
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
    /* loaded from: classes5.dex */
    public static class a extends i {
        a() {
            super("swan_host_info_config_sp_name");
        }
    }
}
