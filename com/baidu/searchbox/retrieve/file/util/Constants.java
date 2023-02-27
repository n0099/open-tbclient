package com.baidu.searchbox.retrieve.file.util;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class Constants {
    public static final String PATH_EXTERNAL = "external:";
    public static final String PATH_INTERNAL = "internal:";
    public static final String PATH_PARENT = "../";
    public static final String UPLOAD_WIFI_TYPE = "1";

    /* loaded from: classes2.dex */
    public static final class MetaError {
        public static final String ERROR_COPY = "2";
        public static final String ERROR_EXIST = "1";
        public static final String ERROR_NON = "0";
        public static final String ERROR_PATH = "4";
        public static final String ERROR_SIZE = "3";
    }

    /* loaded from: classes2.dex */
    public static final class FetchType {
        public static final String FETCH_FILE_TYPE = "file";
        public static final String FETCH_FLOW_TYPE = "flow";
        public static final String FETCH_TIMER_CANCEL_TYPE = "cancel_job";
        public static final String FETCH_TIMER_TYPE = "timer_upload_yalog";

        public static boolean isCancelType(String str) {
            return TextUtils.equals(FETCH_TIMER_CANCEL_TYPE, str);
        }

        public static boolean isTimerType(String str) {
            return TextUtils.equals(FETCH_TIMER_TYPE, str);
        }
    }
}
