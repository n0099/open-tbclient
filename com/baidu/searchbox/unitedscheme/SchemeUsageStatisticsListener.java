package com.baidu.searchbox.unitedscheme;

import android.content.Context;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.net.update.v2.UpdateAction;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@UpdateAction(action = SchemeUsageStatisticsListener.STATISTIC_SWITCH_ACTION, module = "scheme")
/* loaded from: classes2.dex */
public class SchemeUsageStatisticsListener extends JSONObjectCommandListener {
    public static final String JSINTERFACE_SWITCH_LIST = "jsinterface_switch_list";
    public static final String SCHEME_SWITCH_LIST = "scheme_switch_list";
    public static final String STATISTIC_SWITCH_ACTION = "statistic_switch";
    public static final String STATISTIC_SWITCH_VERSION = "statistic_switch_v";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = SchemeUsageStatisticsListener.class.getSimpleName();
    public static ArrayList<String> schemeList = new ArrayList<>();
    public static ArrayList<String> jsinterfaceList = new ArrayList<>();

    public static ArrayList<String> getStatisticJsinterfaceList() {
        if (jsinterfaceList.size() == 0) {
            String string = PreferenceManager.getDefaultSharedPreferences(SchemeConfig.getAppContext()).getString(JSINTERFACE_SWITCH_LIST, "");
            try {
                if (!TextUtils.isEmpty(string)) {
                    JSONArray jSONArray = new JSONArray(string);
                    if (jSONArray.length() > 0) {
                        setDataList(jSONArray, jsinterfaceList);
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jsinterfaceList;
    }

    public static ArrayList<String> getStatisticSchemeList() {
        if (schemeList.size() == 0) {
            String string = PreferenceManager.getDefaultSharedPreferences(SchemeConfig.getAppContext()).getString(SCHEME_SWITCH_LIST, "");
            try {
                if (!TextUtils.isEmpty(string)) {
                    JSONArray jSONArray = new JSONArray(string);
                    if (jSONArray.length() > 0) {
                        setDataList(jSONArray, schemeList);
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return schemeList;
    }

    public static String getUrlWithoutQuery(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            Uri parse = Uri.parse(str);
            return parse.getScheme() + "://" + parse.getAuthority() + parse.getPath();
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
                return "";
            }
            return "";
        }
    }

    public static void setDataList(JSONArray jSONArray, List<String> list) {
        String str;
        if (jSONArray != null) {
            list.clear();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    str = jSONArray.get(i2).toString();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    str = "";
                }
                list.add(str);
            }
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) throws JSONException {
        if (commandPostData == null || commandPostData.getVersion() == null) {
            return;
        }
        commandPostData.getVersion().put(STATISTIC_SWITCH_ACTION, getLocalVersion(context, str, str2));
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<JSONObject> actionData) {
        if (actionData == null || !TextUtils.equals(str2, STATISTIC_SWITCH_ACTION) || TextUtils.isEmpty(actionData.version)) {
            return false;
        }
        if (!TextUtils.equals(actionData.version, getLocalVersion(context, str, str2)) && actionData.data != null) {
            if (DEBUG) {
                String str3 = TAG;
                Log.d(str3, "value.data " + actionData.data);
            }
            JSONArray optJSONArray = actionData.data.optJSONArray(SCHEME_SWITCH_LIST);
            setDataList(optJSONArray, schemeList);
            JSONArray optJSONArray2 = actionData.data.optJSONArray(JSINTERFACE_SWITCH_LIST);
            setDataList(optJSONArray2, jsinterfaceList);
            PreferenceManager.getDefaultSharedPreferences(SchemeConfig.getAppContext()).edit().putString(STATISTIC_SWITCH_VERSION, actionData.version).putString(SCHEME_SWITCH_LIST, optJSONArray == null ? "" : optJSONArray.toString()).putString(JSINTERFACE_SWITCH_LIST, optJSONArray2 != null ? optJSONArray2.toString() : "").apply();
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        return PreferenceManager.getDefaultSharedPreferences(SchemeConfig.getAppContext()).getString(STATISTIC_SWITCH_VERSION, "0");
    }
}
