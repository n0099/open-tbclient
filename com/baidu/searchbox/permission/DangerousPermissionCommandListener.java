package com.baidu.searchbox.permission;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.net.update.v2.UpdateAction;
import org.json.JSONException;
import org.json.JSONObject;
@UpdateAction(action = DangerousPermissionCommandListener.HEADER_ACTION, module = ShareLoginStat.GetShareListStat.KEY_PERMISSION)
/* loaded from: classes3.dex */
public class DangerousPermissionCommandListener extends JSONObjectCommandListener {
    public static final String DANGEROUS_PERMISSION_MESSAGE = "message";
    public static final String DANGEROUS_PERMISSION_VERSION = "dangerous_permission_version";
    public static final String HEADER_ACTION = "permission_message";
    public static final String TAG = "DangerousPermission";

    private void putString(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            DangerousPermissionSpUtils.getInstance().putString(str, str2);
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) throws JSONException {
        if (commandPostData != null && commandPostData.getVersion() != null) {
            String localVersion = getLocalVersion(context, str, str2);
            commandPostData.getVersion().put(HEADER_ACTION, localVersion);
            if (DangerousPermissionRuntime.GLOBAL_DEBUG) {
                Log.d("DangerousPermission", "DangerousPermission dangerousPermissionVersion: " + localVersion);
            }
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<JSONObject> actionData) {
        if (actionData == null || !TextUtils.equals(str2, HEADER_ACTION)) {
            return false;
        }
        if (DangerousPermissionRuntime.GLOBAL_DEBUG) {
            Log.d("DangerousPermission", "action == " + str2 + " , json == " + actionData.data.toString());
        }
        JSONObject optJSONObject = actionData.data.optJSONObject("message");
        if (optJSONObject == null) {
            return false;
        }
        putString(DANGEROUS_PERMISSION_VERSION, actionData.version);
        putString(DangerousPermissionConstants.DANGEROUS_PERMISSION_MIC, optJSONObject.optString(DangerousPermissionConstants.DANGEROUS_PERMISSION_MIC));
        putString("camera", optJSONObject.optString("camera"));
        putString("storage", optJSONObject.optString("storage"));
        putString("phone", optJSONObject.optString("phone"));
        putString("message", optJSONObject.optString("message"));
        putString(DangerousPermissionConstants.DANGEROUS_PERMISSION_CONTACT, optJSONObject.optString(DangerousPermissionConstants.DANGEROUS_PERMISSION_CONTACT));
        putString("location", optJSONObject.optString("location"));
        return true;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        return DangerousPermissionSpUtils.getInstance().getString(DANGEROUS_PERMISSION_VERSION, "0");
    }
}
