package com.baidu.searchbox.ng.ai.apps.runtime.config;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class PageConfigData {
    private static final String CONFIG_JSON_SUFFIX = ".json";
    private static final boolean DEBUG = false;
    private static final String TAG = "PageConfigData";
    private Map<String, WindowConfig> mPagesConfig = null;

    public WindowConfig obtainWindowConfig(String str, String str2, @NonNull WindowConfig windowConfig) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return windowConfig;
        }
        if (this.mPagesConfig == null) {
            this.mPagesConfig = new TreeMap();
        }
        WindowConfig windowConfig2 = this.mPagesConfig.get(str2);
        if (windowConfig2 == null) {
            WindowConfig parseConfigFile = parseConfigFile(str, str2, windowConfig);
            this.mPagesConfig.put(str2, parseConfigFile);
            return parseConfigFile;
        }
        return windowConfig2;
    }

    private WindowConfig parseConfigFile(String str, String str2, @NonNull WindowConfig windowConfig) {
        String str3;
        if (str.endsWith(File.separator)) {
            str3 = str + str2 + CONFIG_JSON_SUFFIX;
        } else {
            str3 = str + File.separator + str2 + CONFIG_JSON_SUFFIX;
        }
        File file = new File(str3);
        if (file.exists()) {
            String readFileData = AiAppsFileUtils.readFileData(file);
            return !TextUtils.isEmpty(readFileData) ? WindowConfig.buildWindowConfig(readFileData, windowConfig) : windowConfig;
        }
        return windowConfig;
    }
}
