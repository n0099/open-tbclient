package com.baidu.searchbox.download.center.clearcache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.net.update.v2.UpdateAction;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@UpdateAction(action = UserSettingForceListListener.FORCE_LIST_ACTION, module = "usersetting")
/* loaded from: classes3.dex */
public class UserSettingForceListListener extends JSONObjectCommandListener {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String DEFAULT_VERSION = "0";
    public static final String FORCE_LIST_ACTION = "force_list";
    public static final String FORCE_LIST_DATA_KEY = "force_list_data";
    public static final String FORCE_LIST_ITEM_ID_KEY = "ID";
    public static final String FORCE_LIST_ITEM_SHOW_KEY = "isShow";
    public static final String FORCE_LIST_ITEM_SHOW_TRUE = "1";
    public static final String FORCE_LIST_VERSION_KEY = "force_list_version";
    public static final String TAG = "ForceListListener";

    public static JSONArray getForceList(String str) {
        String string = new SharedPrefsWrapper("").getString(FORCE_LIST_DATA_KEY, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return new JSONObject(string).optJSONArray(str);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return null;
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) throws JSONException {
        String localVersion = getLocalVersion(context, str, str2);
        if (commandPostData != null && commandPostData.getVersion() != null) {
            commandPostData.getVersion().put(FORCE_LIST_ACTION, localVersion);
            if (DEBUG) {
                Log.d(TAG, "post data version: " + localVersion);
            }
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<JSONObject> actionData) {
        String str3;
        if (DEBUG) {
            Log.d(TAG, "execute command action: " + str2);
        }
        if (actionData != null && TextUtils.equals(str2, FORCE_LIST_ACTION)) {
            JSONObject jSONObject = actionData.data;
            if (jSONObject == null) {
                str3 = "";
            } else {
                str3 = jSONObject.toString();
            }
            new SharedPrefsWrapper("").putString(FORCE_LIST_DATA_KEY, str3);
            new SharedPrefsWrapper("").putString(FORCE_LIST_VERSION_KEY, actionData.version);
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        return new SharedPrefsWrapper("").getString(FORCE_LIST_VERSION_KEY, "0");
    }
}
