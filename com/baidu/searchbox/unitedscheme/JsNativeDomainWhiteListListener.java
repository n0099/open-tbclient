package com.baidu.searchbox.unitedscheme;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.net.update.v2.UpdateAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@UpdateAction(action = JsNativeDomainWhiteListListener.JSNATIVE_DOMAIN_WLIST_ACTION, module = "scheme")
/* loaded from: classes2.dex */
public class JsNativeDomainWhiteListListener extends JSONObjectCommandListener {
    public static final String JSNATIVE_DOMAIN_WLIST_ACTION = "jsnative_domain_wlist";
    public static final String JSNATIVE_DOMAIN_WLIST_VERSION = "jsnative_domain_wlist_v";
    public static final String KEY_JSNATIVE_DOMAIN_WHITE_LIST = "jsnative_domain_white_list";
    public static final String WHITELIST = "whiteList";
    public static final String WHITELIST_ENABLE = "whiteListEnable";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = JsNativeDomainWhiteListListener.class.getSimpleName();
    public static List<String> domainWhiteList = new ArrayList();
    public static String[] localDomainList = {"baidu.com", "nuomi.com", "hao123.com", "baifubao.com", "dxmpay.com", "duxiaoman.com", "mipcdn.com", "wejianzhan.com"};
    public static final String KEY_JSNATIVE_DOMAIN_WHITE_ENABLE = "jsnative_domain_white_list_enable";
    public static boolean whiteListEnable = PreferenceManager.getDefaultSharedPreferences(SchemeConfig.getAppContext()).getBoolean(KEY_JSNATIVE_DOMAIN_WHITE_ENABLE, true);

    public static List<String> getDomainWhiteList() {
        if (domainWhiteList.size() == 0) {
            try {
                setDomainWhiteList(new JSONArray(PreferenceManager.getDefaultSharedPreferences(SchemeConfig.getAppContext()).getString(KEY_JSNATIVE_DOMAIN_WHITE_LIST, "")));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        domainWhiteList.addAll(Arrays.asList(localDomainList));
        return domainWhiteList;
    }

    public static void setDomainWhiteList(JSONArray jSONArray) {
        String str;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        domainWhiteList.clear();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                str = jSONArray.get(i2).toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
                str = "";
            }
            domainWhiteList.add(str);
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) throws JSONException {
        if (commandPostData == null || commandPostData.getVersion() == null) {
            return;
        }
        commandPostData.getVersion().put(JSNATIVE_DOMAIN_WLIST_ACTION, getLocalVersion(context, str, str2));
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<JSONObject> actionData) {
        if (actionData == null || !TextUtils.equals(str2, JSNATIVE_DOMAIN_WLIST_ACTION) || TextUtils.isEmpty(actionData.version)) {
            return false;
        }
        if (!TextUtils.equals(actionData.version, getLocalVersion(context, str, str2)) && actionData.data != null) {
            if (DEBUG) {
                String str3 = TAG;
                Log.d(str3, "value.data " + actionData.data);
            }
            setDomainWhiteList(actionData.data.optJSONArray(WHITELIST));
            whiteListEnable = actionData.data.optBoolean(WHITELIST_ENABLE, true);
            PreferenceManager.getDefaultSharedPreferences(SchemeConfig.getAppContext()).edit().putString(JSNATIVE_DOMAIN_WLIST_VERSION, actionData.version).putBoolean(KEY_JSNATIVE_DOMAIN_WHITE_ENABLE, whiteListEnable).putString(KEY_JSNATIVE_DOMAIN_WHITE_LIST, actionData.data.toString()).apply();
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        return PreferenceManager.getDefaultSharedPreferences(SchemeConfig.getAppContext()).getString(JSNATIVE_DOMAIN_WLIST_VERSION, "0");
    }
}
