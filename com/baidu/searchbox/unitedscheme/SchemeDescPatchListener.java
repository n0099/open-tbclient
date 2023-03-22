package com.baidu.searchbox.unitedscheme;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.android.VersionUtils;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.net.update.v2.UpdateAction;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@UpdateAction(action = SchemeDescPatchListener.DESC_PATCH_ACTION, module = "scheme")
/* loaded from: classes2.dex */
public class SchemeDescPatchListener extends JSONObjectCommandListener {
    public static final String DESC_PATCH_ACTION = "desc_patch";
    public static final String DESC_PATCH_VERSION = "desc_patch_v";
    public static final String END_VERSION = "endVersion";
    public static final String KEY_DESC_PATCH_DATA = "desc_patch_data";
    public static final String PATCH = "patch";
    public static final String START_VERSION = "startVersion";
    public static String endVersion;
    public static String startVersion;
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = SchemeDescPatchListener.class.getSimpleName();
    public static String amendDes = "";

    public static boolean SavePatchToFile(String str) {
        File file;
        try {
            file = new File(SchemeConfig.getAppContext().getFilesDir(), KEY_DESC_PATCH_DATA);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (!file.exists()) {
            if (FileUtils.createNewFileSafely(file)) {
                return FileUtils.saveToFileWithReturn(str, file, false);
            }
            return false;
        }
        return FileUtils.saveToFileWithReturn(str, file, false);
    }

    public static boolean checkVersionIsValid(String str, String str2) {
        String versionName = VersionUtils.getVersionName();
        if (compareVersion(versionName, str) >= 0 && compareVersion(versionName, str2) <= 0) {
            return true;
        }
        return false;
    }

    public static int compareVersion(String str, String str2) {
        if (str == null && str2 == null) {
            return 0;
        }
        if (str != null && str2 == null) {
            return 1;
        }
        if (str == null && str2 != null) {
            return -1;
        }
        String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
        String[] split2 = str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
        int i = 0;
        while (i < split.length && i < split2.length) {
            try {
                int parseInt = Integer.parseInt(split[i]);
                int parseInt2 = Integer.parseInt(split2[i]);
                if (parseInt < parseInt2) {
                    return -1;
                }
                if (parseInt > parseInt2) {
                    return 1;
                }
                i++;
            } catch (NumberFormatException unused) {
                return str.compareTo(str2);
            }
        }
        if (split.length > i) {
            return 1;
        }
        if (split2.length <= i) {
            return 0;
        }
        return -1;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) throws JSONException {
        if (commandPostData != null && commandPostData.getVersion() != null) {
            commandPostData.getVersion().put(DESC_PATCH_ACTION, getLocalVersion(context, str, str2));
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<JSONObject> actionData) {
        if (actionData == null || !TextUtils.equals(str2, DESC_PATCH_ACTION) || TextUtils.isEmpty(actionData.version)) {
            return false;
        }
        if (!TextUtils.equals(actionData.version, getLocalVersion(context, str, str2)) && actionData.data != null) {
            if (DEBUG) {
                String str3 = TAG;
                Log.d(str3, "value.data " + actionData.data);
            }
            if (SavePatchToFile(actionData.data.toString())) {
                PreferenceManager.getDefaultSharedPreferences(SchemeConfig.getAppContext()).edit().putString(DESC_PATCH_VERSION, actionData.version).apply();
                JSONArray optJSONArray = actionData.data.optJSONArray(PATCH);
                if (optJSONArray != null) {
                    startVersion = actionData.data.optString(START_VERSION);
                    endVersion = actionData.data.optString(END_VERSION);
                    amendDes = optJSONArray.toString();
                    SchemeCollecter.finalDesPatch = SchemeCollecter.getAmendDes();
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        return PreferenceManager.getDefaultSharedPreferences(SchemeConfig.getAppContext()).getString(DESC_PATCH_VERSION, "0");
    }
}
