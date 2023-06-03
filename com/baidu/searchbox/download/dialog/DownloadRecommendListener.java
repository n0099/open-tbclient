package com.baidu.searchbox.download.dialog;

import android.content.Context;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.searchbox.download.center.clearcache.UserSettingForceListListener;
import com.baidu.searchbox.download.constants.DownloadRecommendConstants;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.net.update.v2.UpdateAction;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@UpdateAction(action = DownloadRecommendListener.ACTION, module = "download")
/* loaded from: classes3.dex */
public class DownloadRecommendListener extends JSONObjectCommandListener {
    public static final String ACTION = "download_alert";
    public static final String DEFAULT_VERSION = "0";
    public static final String VERSION = "download_alert_v";

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) throws JSONException {
        String localVersion = getLocalVersion(context, str, str2);
        if (commandPostData != null && commandPostData.getVersion() != null) {
            commandPostData.getVersion().put(ACTION, localVersion);
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<JSONObject> actionData) {
        JSONObject jSONObject;
        if (actionData != null && (jSONObject = actionData.data) != null) {
            String optString = jSONObject.optString(UserSettingForceListListener.FORCE_LIST_ITEM_SHOW_KEY);
            String optString2 = actionData.data.optString("supportOpenH5");
            JSONArray optJSONArray = actionData.data.optJSONArray(TableDefine.UserInfoColumns.COLUMN_BLACKLIST);
            HashSet hashSet = new HashSet();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    hashSet.add(optJSONArray.optString(i));
                }
            }
            DownloadSharedPrefsUtils.getInstance().putString(DownloadRecommendConstants.DOWNLOAD_RECOMMEND_DIALOG_IS_SHOW, optString);
            DownloadSharedPrefsUtils.getInstance().putString(DownloadRecommendConstants.DOWNLOAD_RECOMMEND_DIALOG_SUPPORT_OPEN_H5, optString2);
            DownloadSharedPrefsUtils.getInstance().putStringSet(DownloadRecommendConstants.DOWNLOAD_RECOMMEND_DIALOG_BLACKLIST, hashSet);
            return true;
        }
        return true;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        return DownloadSharedPrefsUtils.getInstance().getString(VERSION, "0");
    }
}
