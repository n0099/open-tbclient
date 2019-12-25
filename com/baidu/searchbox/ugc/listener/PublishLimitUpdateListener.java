package com.baidu.searchbox.ugc.listener;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.net.update.v2.UpdateAction;
import org.json.JSONException;
import org.json.JSONObject;
@UpdateAction(action = PublishLimitUpdateListener.ACTION_UGC_LIMIT, module = "ugc")
/* loaded from: classes11.dex */
public class PublishLimitUpdateListener extends JSONObjectCommandListener {
    public static final String ACTION_UGC_LIMIT = "ugc_publish_limit";
    public static final int DEFAULT_PUBLISH_LIMIT = 200;
    public static final String KEY_IMG_TXT_LEN = "img_txt_len";
    public static final String KEY_VERSION = "ugc_publish_limit_version";
    public static final String KEY_VIDEO_LEN = "video_len";

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) throws JSONException {
        if (commandPostData != null && commandPostData.getVersion() != null) {
            commandPostData.getVersion().put(ACTION_UGC_LIMIT, getLocalVersion(context, str, str2));
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<JSONObject> actionData) {
        if (actionData == null || actionData.data == null || !TextUtils.equals(str2, ACTION_UGC_LIMIT)) {
            return false;
        }
        savePublishLimitData(actionData.version, actionData.data);
        return true;
    }

    private void savePublishLimitData(String str, JSONObject jSONObject) {
        int intValue;
        int intValue2;
        if (jSONObject != null) {
            DefaultSharedPrefsWrapper.getInstance().putString(KEY_VERSION, str);
            if (TextUtils.isEmpty(jSONObject.optString(KEY_IMG_TXT_LEN))) {
                Integer num = 200;
                intValue = num.intValue();
            } else {
                intValue = Integer.valueOf(jSONObject.optString(KEY_IMG_TXT_LEN, String.valueOf(200))).intValue();
            }
            if (TextUtils.isEmpty(jSONObject.optString(KEY_VIDEO_LEN))) {
                Integer num2 = 200;
                intValue2 = num2.intValue();
            } else {
                intValue2 = Integer.valueOf(jSONObject.optString(KEY_VIDEO_LEN, String.valueOf(200))).intValue();
            }
            DefaultSharedPrefsWrapper.getInstance().putInt(KEY_IMG_TXT_LEN, intValue);
            DefaultSharedPrefsWrapper.getInstance().putInt(KEY_VIDEO_LEN, intValue2);
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        return DefaultSharedPrefsWrapper.getInstance().getString(KEY_VERSION, "0");
    }

    public static int getWordLimit(String str) {
        return DefaultSharedPrefsWrapper.getInstance().getInt(str, 200);
    }
}
