package com.baidu.tbadk.a;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.compatible.EditorHelper;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private static b eIJ;
    private final HashMap<String, a> mSwitchs = new HashMap<>();

    public b() {
        HashMap<String, a> bmo = bmo();
        this.mSwitchs.clear();
        this.mSwitchs.putAll(bmo);
    }

    public static b bmm() {
        if (eIJ == null) {
            synchronized (b.class) {
                if (eIJ == null) {
                    eIJ = new b();
                }
            }
        }
        return eIJ;
    }

    private static String bmn() {
        return "pref_name_abtest_" + TbadkCoreApplication.getCurrentAccount();
    }

    private static SharedPreferences getSharedPreferences() {
        return TbadkCoreApplication.getInst().getSharedPreferences(bmn(), 0);
    }

    public synchronized a Ah(String str) {
        return this.mSwitchs.get(str);
    }

    private String dH(String str, String str2) {
        a Ah = Ah(str);
        if (Ah != null && !TextUtils.isEmpty(Ah.eIH)) {
            return Ah.eIH;
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

    public void N(JSONArray jSONArray) {
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
            com.baidu.tbadk.core.sharedPref.b.bvq().putInt("perf_start_open", Ai("performance_start_small_flow") ? 1 : 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private HashMap<String, a> bmo() {
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

    public static boolean Ai(String str) {
        return "a".equalsIgnoreCase(bmm().dH(str, ""));
    }
}
