package com.baidu.searchbox.ng.ai.apps.swancore.debug;

import com.baidu.searchbox.ng.ai.apps.util.AiAppStorageUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import java.io.File;
/* loaded from: classes2.dex */
public final class DebugSwanCoreControl {
    private static final String DEBUG_SWAN_CORE_PATH = "baidu/aiapps_debug_swan_core/";
    private static final String DEBUG_SWAN_CORE_ZIP = "debugSwanCore.zip";

    public static File getDebugDirFile() {
        return new File(AiAppStorageUtils.getStorageList().get(0).mPath, DEBUG_SWAN_CORE_PATH);
    }

    public static void clearDownloadDir() {
        File debugDirFile = getDebugDirFile();
        if (debugDirFile.exists()) {
            AiAppsFileUtils.deleteFile(debugDirFile);
        }
    }

    public static File getDownloadTargetFilePath() {
        File debugDirFile = getDebugDirFile();
        if (!debugDirFile.exists()) {
            debugDirFile.mkdirs();
        }
        return new File(debugDirFile, DEBUG_SWAN_CORE_ZIP);
    }
}
