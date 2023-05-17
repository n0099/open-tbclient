package com.baidu.searchbox.security;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import java.io.File;
import java.io.IOException;
/* loaded from: classes4.dex */
public class PrivacyCommonParamManager {
    public static final String AGREE_PRIVACY_FILE = "agree_privacy";
    public static volatile boolean sIsAgreePrivacy;

    public static void createAgreePrivacyFile() {
        File parentFile;
        File filesDir = AppRuntime.getAppContext().getFilesDir();
        if (filesDir != null && (parentFile = filesDir.getParentFile()) != null) {
            File file = new File(parentFile, AGREE_PRIVACY_FILE);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean hasAgreePrivacyFile() {
        File parentFile;
        File filesDir = AppRuntime.getAppContext().getFilesDir();
        if (filesDir != null && (parentFile = filesDir.getParentFile()) != null) {
            return new File(parentFile, AGREE_PRIVACY_FILE).exists();
        }
        return false;
    }

    public static boolean isAgreePrivacy() {
        if (sIsAgreePrivacy) {
            return true;
        }
        sIsAgreePrivacy = WarmTipsManager.isPermissionGranted();
        if (sIsAgreePrivacy) {
            return true;
        }
        if (!ProcessUtils.isMainProcess()) {
            sIsAgreePrivacy = hasAgreePrivacyFile();
        }
        return sIsAgreePrivacy;
    }

    public static void setIsAgreePrivacy(boolean z) {
        sIsAgreePrivacy = z;
    }
}
