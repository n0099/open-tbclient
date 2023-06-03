package com.baidu.searchbox.download.unified;

import android.net.Uri;
/* loaded from: classes3.dex */
public interface EventCallback {
    public static final int TYPE_ERROR = 2;
    public static final int TYPE_INFO = 3;
    public static final int TYPE_SUCCESS = 1;

    /* loaded from: classes3.dex */
    public static class Error {
        public static final int ERROR_DUPLICATE_CLICK_NO = 108;
        public static final int ERROR_INSET_DB_NOT = 111;
        public static final int ERROR_NET_CHECK_CLICK_NO = 107;
        public static final int ERROR_NO_PARAMS = 102;
        public static final int ERROR_NO_PATH_HINT = 105;
        public static final int ERROR_NO_SOURCE = 101;
        public static final int ERROR_NO_URI = 104;
        public static final int ERROR_NO_URL = 103;
        public static final int ERROR_PATH_HINT_ERROR = 106;
        public static final int ERROR_PERMISSION_GUIDE_CLICK_NO = 109;
        public static final int ERROR_PERMISSION_SYSTEM_GRANT_NOT = 110;
        public static final int ERROR_TEENAGER = 113;
        public static final int ERROR_UPDATE_DB_NOT = 112;
    }

    /* loaded from: classes3.dex */
    public static class Info {
        public static int INFO_DUPLICATE_CLICK_YES = 504;
        public static int INFO_DUPLICATE_SHOW = 503;
        public static int INFO_NET_CHECK_CLICK_YES = 502;
        public static int INFO_NET_CHECK_SHOW = 501;
        public static int INFO_PERMISSION_GUIDE_CLICK_YES = 509;
        public static int INFO_PERMISSION_GUIDE_SHOW = 508;
        public static int INFO_PERMISSION_SETTINGS_CLICK_NO = 507;
        public static int INFO_PERMISSION_SETTINGS_CLICK_YES = 506;
        public static int INFO_PERMISSION_SETTINGS_SHOW = 505;
        public static int INFO_PERMISSION_SYSTEM_GRANTED = 510;
    }

    void callBack(int i, EventBackInfo eventBackInfo);

    /* loaded from: classes3.dex */
    public static class EventBackInfo {
        public int detailInfoCode;
        public Uri uri;

        public EventBackInfo(int i) {
            this.detailInfoCode = i;
        }

        public EventBackInfo(Uri uri) {
            this.uri = uri;
        }
    }
}
