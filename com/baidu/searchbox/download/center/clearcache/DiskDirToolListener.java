package com.baidu.searchbox.download.center.clearcache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.net.update.v2.UpdateAction;
import org.json.JSONException;
import org.json.JSONObject;
@UpdateAction(action = DiskDirToolListener.DISK_DIR_TOOL_ACTION, module = "disk_dir")
/* loaded from: classes2.dex */
public class DiskDirToolListener extends JSONObjectCommandListener {
    public static final String DISK_DIR_TOOL_ACTION = "disk_dir_tool";
    public static final String DISK_DIR_TOOL_DATA = "disk_dir_tool_data";
    public static final String DISK_DIR_TOOL_VERSION = "disk_dir_tool_version";
    public static final String TAG = "DiskDirToolListener";

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) throws JSONException {
        String localVersion = getLocalVersion(context, str, str2);
        if (commandPostData != null && commandPostData.getVersion() != null) {
            commandPostData.getVersion().put(DISK_DIR_TOOL_ACTION, localVersion);
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<JSONObject> actionData) {
        JSONObject jSONObject;
        try {
            String localVersion = getLocalVersion(context, str, str2);
            if (actionData == null || actionData.version == null || TextUtils.equals(actionData.version, localVersion) || (jSONObject = actionData.data) == null) {
                return false;
            }
            PreferenceUtils.setString(DISK_DIR_TOOL_VERSION, actionData.version);
            PreferenceUtils.setString(DISK_DIR_TOOL_DATA, jSONObject.toString());
            if (AppConfig.isDebug()) {
                Log.d(TAG, "target file data: " + jSONObject.toString());
                return true;
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        return PreferenceUtils.getString(DISK_DIR_TOOL_VERSION, "0");
    }
}
