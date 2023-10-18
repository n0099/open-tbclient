package com.baidu.searchbox.abtest;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.net.update.v2.UpdateAction;
import com.baidu.tieba.s3;
import org.json.JSONException;
import org.json.JSONObject;
@UpdateAction(action = "abtest", module = "abtest")
/* loaded from: classes3.dex */
public class AbTestCommandListener extends JSONObjectCommandListener {
    public static final String ACTION_ABTEST = "abtest";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "AbTestCommandListener";
    public s3 mExperimentManager = s3.n(AppRuntime.getAppContext());

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) throws JSONException {
        String localVersion = getLocalVersion(context, null, null);
        if (commandPostData != null && commandPostData.getVersion() != null) {
            commandPostData.getVersion().put("abtest", localVersion);
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<JSONObject> actionData) {
        JSONObject jSONObject;
        if (actionData == null || (jSONObject = actionData.data) == null) {
            return false;
        }
        this.mExperimentManager.x(jSONObject, false);
        if (DEBUG) {
            Log.d(TAG, actionData.data.toString());
        }
        return true;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        return this.mExperimentManager.r();
    }
}
