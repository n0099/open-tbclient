package com.baidu.tbadk.a;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.compatible.EditorHelper;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private static b bsB;
    private final HashMap<String, a> mSwitchs = new HashMap<>();

    public b() {
        HashMap<String, a> UF = UF();
        this.mSwitchs.clear();
        this.mSwitchs.putAll(UF);
    }

    public static b UD() {
        if (bsB == null) {
            synchronized (b.class) {
                if (bsB == null) {
                    bsB = new b();
                }
            }
        }
        return bsB;
    }

    private static String UE() {
        return "pref_name_abtest_" + TbadkCoreApplication.getCurrentAccount();
    }

    private static SharedPreferences getSharedPreferences() {
        return TbadkCoreApplication.getInst().getSharedPreferences(UE(), 0);
    }

    public synchronized a kk(String str) {
        return this.mSwitchs.get(str);
    }

    private String bq(String str, String str2) {
        a kk = kk(str);
        if (kk != null && !TextUtils.isEmpty(kk.bsA)) {
            return kk.bsA;
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

    public void v(JSONArray jSONArray) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private HashMap<String, a> UF() {
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

    public static boolean kl(String str) {
        return Config.APP_VERSION_CODE.equalsIgnoreCase(UD().bq(str, ""));
    }
}
