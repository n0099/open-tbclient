package com.baidu.searchbox.ng.ai.apps.swancore.preset;

import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.data.AiAppsSpHelper;
import com.baidu.searchbox.ng.ai.apps.swancore.AiAppsSwanCoreManager;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class PresetSwanCoreControl {
    private static final boolean DEBUG = false;
    private static final String PREF_CUR_PRESET_VERSION = "aiapps_cur_preset_ver_key";
    private static final String PREF_PRESET_UPDATE = "aiapps_preset_update_key";
    private static final String PRESET_SWAN_CONFIG_FILE_PATH = "aiapps/swan-config.json";
    private static final String PRESET_SWAN_CORE_DIR_NAME = "preset";
    private static final String PRESET_SWAN_CORE_FILE_PATH = "aiapps/swan-core.zip";
    private static final String TAG = "PresetSwanCoreControl";
    private static PresetSwanConfig sGlobalConfig;

    public static void setNeedUpdateFlag(boolean z) {
        AiAppsSpHelper.getsInstance().putBoolean(PREF_PRESET_UPDATE, z);
    }

    public static boolean isNeedUpdateStatus() {
        return AiAppsSpHelper.getsInstance().getBoolean(PREF_PRESET_UPDATE, false);
    }

    public static long getCurPresetVersion() {
        return AiAppsSpHelper.getsInstance().getLong(PREF_CUR_PRESET_VERSION, 0L);
    }

    public static PresetSwanConfig getPresetConfig() {
        if (sGlobalConfig == null) {
            sGlobalConfig = PresetSwanConfig.parseFromJSON(readPresetConfig());
        }
        return sGlobalConfig;
    }

    public static void onPresetUpdate() {
        if (isNeedUpdateStatus()) {
            PresetSwanConfig presetConfig = getPresetConfig();
            long j = AiAppsSpHelper.getsInstance().getLong(PREF_CUR_PRESET_VERSION, 0L);
            long version = AiAppsSwanCoreManager.getVersion(presetConfig.swanCoreVer);
            if (j < version) {
                doPresetUpdate(version);
            }
        }
    }

    public static void doPresetUpdate(long j) {
        if (AiAppsFileUtils.unzipFileFromAsset(PRESET_SWAN_CORE_FILE_PATH, getPresetDirFile(j).getPath())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(j));
            AiAppsSwanCoreManager.deleteOldSwanCores(getPresetBaseDir(), arrayList);
            AiAppsSpHelper.getsInstance().putLong(PREF_CUR_PRESET_VERSION, j);
            setNeedUpdateFlag(false);
        }
    }

    private static File getPresetBaseDir() {
        return new File(AiAppsSwanCoreManager.getSwanCoreBaseDir(), PRESET_SWAN_CORE_DIR_NAME);
    }

    public static File getPresetDirFile(long j) {
        return new File(getPresetBaseDir(), String.valueOf(j));
    }

    public static JSONObject readPresetConfig() {
        String readAssetData = AiAppsFileUtils.readAssetData(AppRuntime.getAppContext(), PRESET_SWAN_CONFIG_FILE_PATH);
        if (TextUtils.isEmpty(readAssetData)) {
            return null;
        }
        try {
            return new JSONObject(readAssetData);
        } catch (JSONException e) {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static class PresetSwanConfig {
        private static final String JSON_SWAN_CORE_VER_KEY = "swan-core-version";
        public String swanCoreVer;

        public static PresetSwanConfig parseFromJSON(JSONObject jSONObject) {
            PresetSwanConfig presetSwanConfig = new PresetSwanConfig();
            if (jSONObject != null) {
                presetSwanConfig.swanCoreVer = jSONObject.optString(JSON_SWAN_CORE_VER_KEY);
            }
            return presetSwanConfig;
        }
    }
}
