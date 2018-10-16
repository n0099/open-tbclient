package com.baidu.searchbox.ng.ai.apps.util;

import android.support.annotation.Nullable;
import com.baidu.searchbox.ng.ai.apps.util.AiAppStorageUtils;
import java.io.File;
import java.util.List;
/* loaded from: classes2.dex */
public class AiAppDebugFileUtils {
    private static final boolean DEBUG = false;
    private static final String DEBUG_BASE_PATH = "baidu/aiapps/debug/";
    public static final String DEBUG_ERROR_DIALOG_FILE_NAME = "error_dialog_info.txt";
    private static final String TAG = "AiAppDebugFileUtils";

    @Nullable
    public static File getDebugFolder() {
        List<AiAppStorageUtils.StorageInfo> storageList = AiAppStorageUtils.getStorageList();
        if (storageList == null || storageList.size() <= 0) {
            return null;
        }
        File file = new File(storageList.get(0).mPath, DEBUG_BASE_PATH);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
