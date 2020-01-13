package com.baidu.searchbox.ugc.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;
/* loaded from: classes12.dex */
public class LocalPreviewUtils {
    public static final int MIN_CLICK_DELAY_TIME = 1000;
    public static long lastClickTime = 0;

    public static boolean unFastClick() {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (timeInMillis - lastClickTime > 1000) {
            lastClickTime = timeInMillis;
            return true;
        }
        return false;
    }

    public static long getFileSize(File file) throws Exception {
        if (file.exists()) {
            return new FileInputStream(file).available();
        }
        file.createNewFile();
        return 0L;
    }
}
