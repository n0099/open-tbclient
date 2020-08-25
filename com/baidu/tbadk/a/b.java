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
/* loaded from: classes2.dex */
public class b {
    private static b dRh;
    private final HashMap<String, a> mSwitchs = new HashMap<>();

    public b() {
        HashMap<String, a> aZL = aZL();
        this.mSwitchs.clear();
        this.mSwitchs.putAll(aZL);
    }

    public static b aZJ() {
        if (dRh == null) {
            synchronized (b.class) {
                if (dRh == null) {
                    dRh = new b();
                }
            }
        }
        return dRh;
    }

    private static String aZK() {
        return "pref_name_abtest_" + TbadkCoreApplication.getCurrentAccount();
    }

    private static SharedPreferences getSharedPreferences() {
        return TbadkCoreApplication.getInst().getSharedPreferences(aZK(), 0);
    }

    public synchronized a xX(String str) {
        return this.mSwitchs.get(str);
    }

    private String dq(String str, String str2) {
        a xX = xX(str);
        if (xX != null && !TextUtils.isEmpty(xX.dRf)) {
            return xX.dRf;
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

    public void M(JSONArray jSONArray) {
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
            com.baidu.tbadk.core.sharedPref.b.bik().putInt("static_opt_open", xY("static_opt_open_test") ? 1 : 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private HashMap<String, a> aZL() {
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

    public static boolean xY(String str) {
        return "a".equalsIgnoreCase(aZJ().dq(str, ""));
    }
}
