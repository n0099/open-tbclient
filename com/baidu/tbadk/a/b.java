package com.baidu.tbadk.a;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.compatible.EditorHelper;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private static b dCe;
    private final HashMap<String, a> mSwitchs = new HashMap<>();

    public b() {
        HashMap<String, a> aNG = aNG();
        this.mSwitchs.clear();
        this.mSwitchs.putAll(aNG);
    }

    public static b aNE() {
        if (dCe == null) {
            synchronized (b.class) {
                if (dCe == null) {
                    dCe = new b();
                }
            }
        }
        return dCe;
    }

    private static String aNF() {
        return "pref_name_abtest_" + TbadkCoreApplication.getCurrentAccount();
    }

    private static SharedPreferences getSharedPreferences() {
        return TbadkCoreApplication.getInst().getSharedPreferences(aNF(), 0);
    }

    public synchronized a uJ(String str) {
        return this.mSwitchs.get(str);
    }

    private String cX(String str, String str2) {
        a uJ = uJ(str);
        if (uJ != null && !TextUtils.isEmpty(uJ.dCc)) {
            return uJ.dCc;
        }
        return str2;
    }

    private void clearAll() {
        try {
            synchronized (this.mSwitchs) {
                this.mSwitchs.clear();
            }
            SharedPreferences.Editor edit = getSharedPreferences().edit();
            edit.clear();
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void J(JSONArray jSONArray) {
        try {
            if (jSONArray == null) {
                clearAll();
                return;
            }
            HashMap hashMap = new HashMap();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    String optString = jSONObject.optString("name");
                    hashMap.put(optString, new a(optString, jSONObject.optString("branch"), jSONObject.optString(TbConfig.TMP_LOG_DIR_NAME)));
                }
            }
            synchronized (this.mSwitchs) {
                this.mSwitchs.clear();
                this.mSwitchs.putAll(hashMap);
            }
            EditorHelper.putString(getSharedPreferences(), "pref_key_abtest_switchs", jSONArray.toString());
            if ((uL("cyber_player_test") || uK("cyber_player_test")) && !CyberPlayerManager.isCoreLoaded(1)) {
                CyberPlayerManager.install(TbadkCoreApplication.getInst().getContext(), TbadkCoreApplication.getInst().getCuidGalaxy2(), null, 1, null, null, null);
            }
            com.baidu.tbadk.core.sharedPref.b.aVP().putInt("static_opt_open", uL("static_opt_open_test") ? 1 : 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private HashMap<String, a> aNG() {
        HashMap<String, a> hashMap = new HashMap<>();
        try {
            JSONArray jSONArray = new JSONArray(getSharedPreferences().getString("pref_key_abtest_switchs", "[]"));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    String optString = jSONObject.optString("name");
                    hashMap.put(optString, new a(optString, jSONObject.optString("branch"), jSONObject.optString(TbConfig.TMP_LOG_DIR_NAME)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    public static boolean uK(String str) {
        return TextUtils.isEmpty(aNE().cX(str, ""));
    }

    public static boolean uL(String str) {
        return Config.APP_VERSION_CODE.equalsIgnoreCase(aNE().cX(str, ""));
    }
}
