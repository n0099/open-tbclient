package com.baidu.searchbox.security;

import android.text.TextUtils;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.tieba.l30;
import com.baidu.tieba.uua;
import com.baidu.ubc.UBCManager;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class WarmTipsManager {
    public static final String CLEARCACHE_SOURCE_VALUE = "clearcache";
    public static final String COMMAND_SOURCE_VALUE = "command";
    public static final String DATA = "data";
    public static final int DATA_MAX_LENGTH = 50;
    public static final String DEFAULT_EXT_VALUE = "";
    public static final String DEFAULT_SOURCE_VALUE = "other";
    public static final String EXT_DATA_KEY = "data";
    public static final String EXT_IID_KEY = "iid";
    public static final String EXT_RAND_ID_KEY = "randid";
    public static final String FILE_SOURCE_VALUE = "file";
    public static final String HAS_MAIN = "has_main";
    public static final String HAS_NOT_MAIN = "has_not_main";
    public static final String LAUNCHER_SOURCE_VALUE = "launcher";
    public static final String LAUNCHER_UBC_ID = "3145";
    public static final String PUSH_SOURCE_VALUE = "push";
    public static final String SCHEME_SOURCE_VALUE = "scheme";
    public static final String SHARE_IMAGESEARCH_EXT_VALUE = "imagesearch";
    public static final String SHARE_SOURCE_VALUE = "share";
    public static final String SHARE_UGC_EXT_VALUE = "ugc";
    public static final String SHOW_NO_TYPE = "0";
    public static final String SHOW_YES_TYPE = "1";
    public static final String START_FROM_LAUNCHER_SP = "start_from_launcher_sp";
    public static final String SWAN_SOURCE_VALUE = "swan";
    public static final String UBC_RANDID_KEY = "randid";
    public static final String UBC_TASK_EXTERNAL_INVOKE = "ubc_task_external_invoke";
    public static final String UBC_TASK_WIDGET_SCHEME_INVOKE = "ubc_task_widget_scheme_invoke";
    public static final String WARM_TIPS_SP_NAME = "com.baidu.searchbox.warmtips";
    public static final String WIDGET_CODE_EXT_VALUE = "code";
    public static final String WIDGET_FEED_EXT_VALUE = "feed";
    public static final String WIDGET_HISSUG_EXT_VALUE = "hissug";
    public static final String WIDGET_HOME_EXT_VALUE = "home";
    public static final String WIDGET_SOURCE_VALUE = "widget";
    public static final String WIDGET_SPEECH_EXT_VALUE = "speech";
    public static SharedPrefsWrapper mSpManager = new SharedPrefsWrapper("com.baidu.searchbox.warmtips");
    public static String mRandId = null;
    @Deprecated
    public static boolean mStartFromLauncher = false;
    public static boolean isStartFromLauncherForProcess = true;
    public static String mSourceValue = "other";
    public static String mExtValue = "";
    public static String mOriginalExtValue = "";
    public static String mExtData = "";

    static {
        if (ProcessUtils.isMainProcess()) {
            clearStartFromLaunchSp();
        }
    }

    public static void clearStartFromLaunchSp() {
        QuickPersistConfig.getInstance().remove(START_FROM_LAUNCHER_SP);
    }

    public static String getExt() {
        return mExtValue;
    }

    public static String getOriginalExt() {
        return mOriginalExtValue;
    }

    public static String getSource() {
        return mSourceValue;
    }

    public static boolean getStartFromLauncherFromSp() {
        return QuickPersistConfig.getInstance().getBoolean(START_FROM_LAUNCHER_SP, true);
    }

    public static String getUUID() {
        if (!TextUtils.isEmpty(mRandId)) {
            return mRandId;
        }
        String string = mSpManager.getString("randid", "");
        if (TextUtils.isEmpty(string)) {
            string = UUID.randomUUID().toString();
            mSpManager.putString("randid", string);
        }
        mRandId = string;
        return string;
    }

    public static boolean hasConfirmDialog() {
        return QuickPersistConfig.getInstance().getBoolean(QuickPersistConfigConst.KEY_INTRODUCTION_WARM, false);
    }

    @Deprecated
    public static boolean isPermissionGranted() {
        if (!hasConfirmDialog() && mStartFromLauncher) {
            return false;
        }
        return true;
    }

    public static boolean isPermissionGrantedForProcess() {
        if (ProcessUtils.isMainProcess()) {
            if (!hasConfirmDialog() && isStartFromLauncherForProcess) {
                return false;
            }
            return true;
        } else if (!hasConfirmDialog() && getStartFromLauncherFromSp()) {
            return false;
        } else {
            return true;
        }
    }

    public static void launcherHasMainBeforeAgreePrivacyUbc(String str) {
        if (hasConfirmDialog()) {
            return;
        }
        if (!TextUtils.equals(mSourceValue, "scheme") && !TextUtils.equals(mSourceValue, WIDGET_SOURCE_VALUE)) {
            return;
        }
        launcherHasMainBeforeAgreePrivacyUbc(mSourceValue, str);
    }

    @Deprecated
    public static void setLaunchState(boolean z) {
        mStartFromLauncher = z;
        if (z && TextUtils.equals(mSourceValue, "other")) {
            mSourceValue = LAUNCHER_SOURCE_VALUE;
        }
    }

    public static void setLauncherStateForProcess(boolean z) {
        isStartFromLauncherForProcess = z;
        setStartFromLauncherFromSp(z);
    }

    public static void setStartFromLauncherFromSp(boolean z) {
        QuickPersistConfig.getInstance().putBoolean(START_FROM_LAUNCHER_SP, z);
    }

    public static JSONObject wrapDataToExt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.length() > 50) {
            str = str.substring(0, 50);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static boolean canShowConfirmDialog(String str) {
        if (hasConfirmDialog()) {
            return false;
        }
        if (TextUtils.equals(str, LAUNCHER_SOURCE_VALUE)) {
            return true;
        }
        if (TextUtils.equals(str, WIDGET_SOURCE_VALUE) && TextUtils.equals(mSourceValue, "other")) {
            launcherBeforeAgreePrivacyUBC(str, "1");
            launcherHasMainBeforeAgreePrivacyUbc(str, HAS_MAIN);
        }
        PrivacyCommonParamManager.setIsAgreePrivacy(true);
        return false;
    }

    public static void launcherBeforeAgreePrivacyUBC(final String str, final String str2) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.security.WarmTipsManager.1
            @Override // java.lang.Runnable
            public void run() {
                uua uuaVar = (uua) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("source", str);
                    jSONObject.put("type", str2);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("iid", l30.f(AppRuntime.getAppContext()).e());
                    jSONObject2.put("randid", WarmTipsManager.getUUID());
                    if (!TextUtils.isEmpty(WarmTipsManager.mExtData)) {
                        jSONObject2.put("data", WarmTipsManager.mExtData);
                        String unused = WarmTipsManager.mExtData = null;
                    }
                    jSONObject.put("ext", jSONObject2);
                } catch (JSONException e) {
                    if (AppConfig.isDebug()) {
                        e.printStackTrace();
                    }
                }
                uuaVar.onEvent(WarmTipsManager.LAUNCHER_UBC_ID, jSONObject, 128);
            }
        }, UBC_TASK_EXTERNAL_INVOKE, 3);
    }

    public static void launcherHasMainBeforeAgreePrivacyUbc(final String str, final String str2) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.security.WarmTipsManager.2
            @Override // java.lang.Runnable
            public void run() {
                uua uuaVar = (uua) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("source", str);
                    jSONObject.put("value", str2);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("iid", l30.f(AppRuntime.getAppContext()).e());
                    jSONObject2.put("randid", WarmTipsManager.getUUID());
                    jSONObject.put("ext", jSONObject2);
                } catch (JSONException e) {
                    if (AppConfig.isDebug()) {
                        e.printStackTrace();
                    }
                }
                uuaVar.onEvent(WarmTipsManager.LAUNCHER_UBC_ID, jSONObject, 128);
            }
        }, UBC_TASK_WIDGET_SCHEME_INVOKE, 3);
    }

    public static void setLauncherSource(String str, String str2) {
        mExtData = str2;
        if (TextUtils.equals(mSourceValue, "other")) {
            mSourceValue = str;
            mOriginalExtValue = str2;
            JSONObject wrapDataToExt = wrapDataToExt(str2);
            if (wrapDataToExt != null) {
                mExtValue = wrapDataToExt.toString();
            }
        }
        if (hasConfirmDialog()) {
            return;
        }
        if (TextUtils.equals(str, LAUNCHER_SOURCE_VALUE)) {
            launcherBeforeAgreePrivacyUBC(str, "1");
        } else {
            launcherBeforeAgreePrivacyUBC(str, "0");
        }
    }
}
