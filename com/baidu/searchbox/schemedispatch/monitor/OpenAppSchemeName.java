package com.baidu.searchbox.schemedispatch.monitor;

import android.text.TextUtils;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.utils.CheckListUtils;
import com.baidu.tieba.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class OpenAppSchemeName extends OpenAppBaseCheck implements ISchemeName {
    public static final String SCHEME_NAME_FILENAME = "scheme_name_filename";
    public static final String SCHEME_NAME_KEY = "alert_title_list";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static Map<String, String> mSchemeNameMap = new HashMap();

    @Override // com.baidu.searchbox.schemedispatch.monitor.OpenAppBaseCheck
    public void loadWhiteListAsync() {
        String readCacheData = FileUtils.readCacheData(AppRuntime.getAppContext(), "scheme_name_filename");
        try {
            if (!TextUtils.isEmpty(readCacheData)) {
                loadData(new JSONObject(readCacheData));
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void loadData(JSONObject jSONObject) {
        mSchemeNameMap.clear();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            mSchemeNameMap.put(next, jSONObject.optString(next));
        }
    }

    @Override // com.baidu.searchbox.schemedispatch.monitor.OpenAppBaseCheck
    public boolean saveWhiteListDispatch(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(SCHEME_NAME_KEY);
        if (optJSONObject == null || !FileUtils.cache(AppRuntime.getAppContext(), "scheme_name_filename", optJSONObject.toString(), 0)) {
            return false;
        }
        loadData(optJSONObject);
        return true;
    }

    @Override // com.baidu.searchbox.schemedispatch.monitor.ISchemeName
    public synchronized String getSchemeName(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int indexOf = str.indexOf("?");
        int indexOf2 = str.indexOf("#");
        if (indexOf >= str.length()) {
            indexOf = 0;
        }
        if (indexOf2 >= str.length()) {
            indexOf2 = 0;
        }
        if (indexOf2 > 0 && indexOf2 < indexOf) {
            indexOf = 0;
        }
        if (indexOf > 0) {
            String substring = str.substring(0, indexOf);
            if (indexOf2 > 0) {
                String substring2 = str.substring(indexOf + 1, indexOf2);
                String substring3 = str.substring(indexOf2 + 1);
                str3 = substring2;
                str2 = substring3;
            } else {
                str3 = str.substring(indexOf + 1);
                str2 = null;
            }
            str = substring;
        } else if (indexOf2 > 0) {
            String substring4 = str.substring(0, indexOf2);
            String substring5 = str.substring(indexOf2 + 1);
            str3 = null;
            str2 = substring5;
            str = substring4;
        } else {
            str2 = null;
            str3 = null;
        }
        for (String str7 : mSchemeNameMap.keySet()) {
            int indexOf3 = str7.indexOf("?");
            int indexOf4 = str7.indexOf("#");
            if (indexOf3 >= str7.length()) {
                indexOf3 = 0;
            }
            if (indexOf4 >= str7.length()) {
                indexOf4 = 0;
            }
            if (indexOf4 > 0 && indexOf4 < indexOf3) {
                indexOf3 = 0;
            }
            if (indexOf3 > 0) {
                str6 = str7.substring(0, indexOf3);
                if (indexOf4 > 0) {
                    str4 = str7.substring(indexOf3 + 1, indexOf4);
                    str5 = str7.substring(indexOf4 + 1);
                } else {
                    str4 = str7.substring(indexOf3 + 1);
                    str5 = null;
                }
            } else if (indexOf4 > 0) {
                str6 = str7.substring(0, indexOf4);
                str5 = str7.substring(indexOf4 + 1);
                str4 = null;
            } else {
                str4 = null;
                str5 = null;
                str6 = str7;
            }
            if (str.startsWith(str6)) {
                if (TextUtils.isEmpty(str4) && TextUtils.isEmpty(str5)) {
                    return mSchemeNameMap.get(str7);
                } else if (TextUtils.isEmpty(str4) || (!TextUtils.isEmpty(str3) && CheckListUtils.compare(str3.split("&"), str4.split("&")))) {
                    if (TextUtils.equals(str2, str5)) {
                        return mSchemeNameMap.get(str7);
                    }
                }
            }
        }
        return AppRuntime.getAppContext().getString(R.string.third_party_visit_dialog_app_default_name);
    }
}
