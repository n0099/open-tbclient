package com.baidu.searchbox.download.model;

import android.net.Uri;
import android.provider.BaseColumns;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.downloads.DownloadConstants;
/* loaded from: classes3.dex */
public final class Downloads {
    public static final String ACTION_DOWNLOAD_COMPLETED;
    public static final String ACTION_NOTIFICATION_CLICKED;
    public static final String COLUMN_APP_DATA = "entity";
    public static final String COLUMN_CONTROL = "control";
    public static final String COLUMN_COOKIE_DATA = "cookiedata";
    public static final String COLUMN_CURRENT_BYTES = "current_bytes";
    public static final String COLUMN_DELETED = "deleted";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_DESTINATION = "destination";
    public static final String COLUMN_FILE_NAME_HINT = "hint";
    public static final String COLUMN_LAST_MODIFICATION = "lastmod";
    public static final String COLUMN_MIME_TYPE = "mimetype";
    public static final String COLUMN_NOTIFICATION_CLASS = "notificationclass";
    public static final String COLUMN_NOTIFICATION_EXTRAS = "notificationextras";
    public static final String COLUMN_NOTIFICATION_PACKAGE = "notificationpackage";
    public static final String COLUMN_NO_INTEGRITY = "no_integrity";
    public static final String COLUMN_OTHER_UID = "otheruid";
    public static final String COLUMN_REFERER = "referer";
    public static final String COLUMN_STATUS = "status";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_TOTAL_BYTES = "total_bytes";
    public static final String COLUMN_URI = "uri";
    public static final String COLUMN_USER_AGENT = "useragent";
    public static final String COLUMN_VISIBILITY = "visibility";
    public static final Uri CONTENT_URI = Uri.parse(DownloadConstants.LOCAL_DATA_URI_PREFIX + AppRuntime.getAppContext().getPackageName() + ".downloads/my_downloads");
    public static final int CONTROL_PAUSED = 1;
    public static final int CONTROL_RUN = 0;
    public static final String DATA = "_data";
    public static final int DESTINATION_CACHE_PARTITION = 1;
    public static final int DESTINATION_CACHE_PARTITION_NOROAMING = 3;
    public static final int DESTINATION_CACHE_PARTITION_PURGEABLE = 2;
    public static final int DESTINATION_EXTERNAL = 0;
    public static final String PERMISSION_ACCESS = "com.baidu.searchbox.permission.ACCESS_DOWNLOAD_MANAGER";
    public static final String PERMISSION_ACCESS_ADVANCED = "com.baidu.searchbox.permission.ACCESS_DOWNLOAD_MANAGER_ADVANCED";
    public static final String PERMISSION_CACHE = "com.baidu.searchbox.permission.ACCESS_CACHE_FILESYSTEM";
    public static final String PERMISSION_SEND_INTENTS = "com.baidu.searchbox.permission.SEND_DOWNLOAD_COMPLETED_INTENTS";
    public static final int STATUS_BAD_REQUEST = 400;
    public static final int STATUS_CANCELED = 490;
    public static final int STATUS_DEVICE_NOT_FOUND_ERROR = 499;
    public static final int STATUS_HTTP_EXCEPTION = 496;
    public static final int STATUS_INSUFFICIENT_SPACE_ERROR = 498;
    public static final int STATUS_LENGTH_REQUIRED = 411;
    public static final int STATUS_NOT_ACCEPTABLE = 406;
    public static final int STATUS_PENDING = 190;
    public static final int STATUS_PRECONDITION_FAILED = 412;
    public static final int STATUS_RUNNING = 192;
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_TOO_MANY_REDIRECTS = 497;
    public static final int STATUS_UNHANDLED_HTTP_CODE = 494;
    public static final int STATUS_UNHANDLED_REDIRECT = 493;
    public static final int VISIBILITY_HIDDEN = 2;
    public static final int VISIBILITY_VISIBLE = 0;
    public static final int VISIBILITY_VISIBLE_NOTIFY_COMPLETED = 1;
    public static String sDestinationDir;
    public static DestinationMode sDestinationMode;

    /* loaded from: classes3.dex */
    public static final class BusinessType {
        public static final int DEFAULT = 0;
        public static final int KERNEL_VIDEO = 1;
    }

    /* loaded from: classes3.dex */
    public enum DestinationMode {
        AUTO,
        INTERNAL_ONLY,
        EXTERNAL_ONLY,
        CUSTOM
    }

    public static boolean isStatusClientError(int i) {
        return i >= 400 && i < 500;
    }

    public static boolean isStatusCompleted(int i) {
        return (i >= 200 && i < 300) || (i >= 400 && i < 600);
    }

    public static boolean isStatusError(int i) {
        return i >= 400 && i < 600;
    }

    public static boolean isStatusInformational(int i) {
        return i >= 100 && i < 200;
    }

    public static boolean isStatusServerError(int i) {
        return i >= 500 && i < 600;
    }

    public static boolean isStatusSuccess(int i) {
        return i >= 200 && i < 300;
    }

    /* loaded from: classes3.dex */
    public static final class Impl implements BaseColumns {
        public static final String ACTION_DOWNLOAD_COMPLETED;
        public static final String ACTION_NOTIFICATION_CLICKED;
        public static final String COLUMN_ALLOWED_NETWORK_TYPES = "allowed_network_types";
        public static final String COLUMN_ALLOW_ROAMING = "allow_roaming";
        public static final String COLUMN_APP_DATA = "entity";
        public static final String COLUMN_BOUNDARY = "boundary";
        public static final String COLUMN_BUSINESS_ID = "business_id";
        public static final String COLUMN_BUSINESS_TYPE = "business_type";
        public static final String COLUMN_BYPASS_RECOMMENDED_SIZE_LIMIT = "bypass_recommended_size_limit";
        public static final String COLUMN_CONTROL = "control";
        public static final String COLUMN_COOKIE_DATA = "cookiedata";
        public static final String COLUMN_CREATE_TIME = "create_time";
        public static final String COLUMN_CURRENT_BYTES = "current_bytes";
        public static final String COLUMN_DELETED = "deleted";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_DESTINATION = "destination";
        public static final String COLUMN_DOWNLOAD_MOD = "downloadMod";
        public static final String COLUMN_EXTRA_INFO = "extra_info";
        public static final String COLUMN_EXTRA_INFO_CLOSE_AUTO_INSTALL = "close_auto_install";
        public static final String COLUMN_EXTRA_INFO_ETAG = "etag";
        public static final String COLUMN_EXTRA_INFO_HIGHT_LIGHT = "high_light";
        public static final String COLUMN_EXTRA_INFO_ICON = "icon";
        public static final String COLUMN_EXTRA_INFO_NAME = "name";
        public static final String COLUMN_EXTRA_INFO_OPEN_TIME = "open_time";
        public static final String COLUMN_EXTRA_INFO_ORIGINAL_URI = "originalUri";
        public static final String COLUMN_EXTRA_INFO_PACKAGE = "package";
        public static final String COLUMN_EXTRA_INFO_PREREFERER = "prereferer";
        public static final String COLUMN_EXTRA_INFO_REFER = "refer";
        public static final String COLUMN_EXTRA_INFO_SOURCE = "source";
        public static final String COLUMN_EXTRA_INFO_VERSIONCODE = "versioncode";
        public static final String COLUMN_EXTRA_INFO_VERSIONNAME = "versioname";
        public static final String COLUMN_FILE_NAME_HINT = "hint";
        public static final String COLUMN_IS_PUBLIC_API = "is_public_api";
        public static final String COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI = "is_visible_in_downloads_ui";
        public static final String COLUMN_LAST_MODIFICATION = "lastmod";
        public static final String COLUMN_MEDIAPROVIDER_URI = "mediaprovider_uri";
        public static final String COLUMN_MIME_TYPE = "mimetype";
        public static final String COLUMN_NEED_CHECK_APK = "need_check_apk";
        public static final String COLUMN_NETDISK_UPLOAD_INFO = "netdisk_upload_info";
        public static final String COLUMN_NOTIFICATION_CLASS = "notificationclass";
        public static final String COLUMN_NOTIFICATION_EXTRAS = "notificationextras";
        public static final String COLUMN_NOTIFICATION_PACKAGE = "notificationpackage";
        public static final String COLUMN_NO_INTEGRITY = "no_integrity";
        public static final String COLUMN_OPEN_READ = "open_read";
        public static final String COLUMN_OPEN_TIME = "time_open";
        public static final String COLUMN_OTHER_UID = "otheruid";
        public static final String COLUMN_PROGRESS = "progress";
        public static final String COLUMN_RANGE = "range_byte";
        public static final String COLUMN_RANGE_END_BYTE = "range_end_byte";
        public static final String COLUMN_RANGE_START_BYTE = "range_start_byte";
        public static final String COLUMN_REFERER = "referer";
        public static final String COLUMN_SOURCE = "source";
        public static final String COLUMN_STATUS = "status";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_TOTAL_BYTES = "total_bytes";
        public static final String COLUMN_URI = "uri";
        public static final String COLUMN_USER_AGENT = "useragent";
        public static final String COLUMN_VISIBILITY = "visibility";
        public static final int CONTROL_PAUSED = 1;
        public static final int CONTROL_RUN = 0;
        public static final String DATA = "_data";
        public static final int DESTINATION_CACHE_PARTITION = 1;
        public static final int DESTINATION_CACHE_PARTITION_NOROAMING = 3;
        public static final int DESTINATION_CACHE_PARTITION_PURGEABLE = 2;
        public static final int DESTINATION_EXTERNAL = 0;
        public static final int DESTINATION_EXTERNAL_PUBLIC = 5;
        public static final int DESTINATION_FILE_URI = 4;
        public static final int MIN_ARTIFICIAL_ERROR_STATUS = 488;
        public static final String PERMISSION_ACCESS = "com.baidu.searchbox.permission.ACCESS_DOWNLOAD_MANAGER";
        public static final String PERMISSION_ACCESS_ADVANCED = "com.baidu.searchbox.permission.ACCESS_DOWNLOAD_MANAGER_ADVANCED";
        public static final String PERMISSION_ACCESS_ALL = "com.baidu.searchbox.permission.ACCESS_ALL_DOWNLOADS";
        public static final String PERMISSION_CACHE = "com.baidu.searchbox.permission.ACCESS_CACHE_FILESYSTEM";
        public static final String PERMISSION_CACHE_NON_PURGEABLE = "com.baidu.searchbox.permission.DOWNLOAD_CACHE_NON_PURGEABLE";
        public static final String PERMISSION_NO_NOTIFICATION = "com.baidu.searchbox.permission.DOWNLOAD_WITHOUT_NOTIFICATION";
        public static final String PERMISSION_SEND_INTENTS = "com.baidu.searchbox.permission.SEND_DOWNLOAD_COMPLETED_INTENTS";
        public static final int STATUS_BAD_REQUEST = 400;
        public static final int STATUS_CANCELED = 490;
        public static final int STATUS_CANNOT_RESUME = 489;
        public static final int STATUS_CYBER_DEFAULT = 101;
        public static final int STATUS_DEFAULT = 100;
        public static final int STATUS_DEVICE_NOT_FOUND_ERROR = 499;
        public static final int STATUS_FILE_ALREADY_EXISTS_ERROR = 488;
        public static final int STATUS_FILE_ERROR = 492;
        public static final int STATUS_FILE_ERROR_1 = 4921;
        public static final int STATUS_FILE_ERROR_10 = 49210;
        public static final int STATUS_FILE_ERROR_11 = 49211;
        public static final int STATUS_FILE_ERROR_12 = 49212;
        public static final int STATUS_FILE_ERROR_2 = 4922;
        public static final int STATUS_FILE_ERROR_3 = 4923;
        public static final int STATUS_FILE_ERROR_4 = 4924;
        public static final int STATUS_FILE_ERROR_5 = 4925;
        public static final int STATUS_FILE_ERROR_6 = 4926;
        public static final int STATUS_FILE_ERROR_7 = 4927;
        public static final int STATUS_FILE_ERROR_8 = 4928;
        public static final int STATUS_FILE_ERROR_9 = 4929;
        public static final int STATUS_HTTP_DATA_ERROR = 495;
        public static final int STATUS_HTTP_DATA_ERROR_1 = 4951;
        public static final int STATUS_HTTP_DATA_ERROR_2 = 4952;
        public static final int STATUS_HTTP_DATA_ERROR_3 = 4953;
        public static final int STATUS_HTTP_EXCEPTION = 496;
        public static final int STATUS_INSUFFICIENT_SPACE_ERROR = 498;
        public static final int STATUS_LENGTH_REQUIRED = 411;
        public static final int STATUS_NOT_ACCEPTABLE = 406;
        public static final int STATUS_PAUSED_BY_APP = 193;
        public static final int STATUS_PENDING = 190;
        public static final int STATUS_PRECONDITION_FAILED = 412;
        public static final int STATUS_QUEUED_FOR_WIFI = 196;
        public static final int STATUS_RUNNING = 192;
        public static final int STATUS_SUCCESS = 200;
        public static final int STATUS_TOO_MANY_REDIRECTS = 497;
        public static final int STATUS_UNHANDLED_HTTP_CODE = 494;
        public static final int STATUS_UNHANDLED_REDIRECT = 493;
        public static final int STATUS_UNKNOWN_ERROR = 491;
        public static final int STATUS_WAITING_FOR_NETWORK = 195;
        public static final int STATUS_WAITING_TO_RETRY = 194;
        public static final int VISIBILITY_HIDDEN = 2;
        public static final int VISIBILITY_VISIBLE = 0;
        public static final int VISIBILITY_VISIBLE_NOTIFY_COMPLETED = 1;
        public static final Uri CONTENT_URI = Uri.parse(DownloadConstants.LOCAL_DATA_URI_PREFIX + AppRuntime.getAppContext().getPackageName() + ".downloads/my_downloads");
        public static final Uri ALL_DOWNLOADS_CONTENT_URI = Uri.parse(DownloadConstants.LOCAL_DATA_URI_PREFIX + AppRuntime.getAppContext().getPackageName() + ".downloads/all_downloads");

        /* loaded from: classes3.dex */
        public static class RequestHeaders {
            public static final String COLUMN_DOWNLOAD_ID = "download_id";
            public static final String COLUMN_HEADER = "header";
            public static final String COLUMN_VALUE = "value";
            public static final String HEADERS_DB_TABLE = "request_headers";
            public static final String INSERT_KEY_PREFIX = "http_header_";
            public static final String URI_SEGMENT = "headers";
        }

        public static boolean isStatusClientError(int i) {
            return i >= 400 && i < 500;
        }

        public static boolean isStatusCompleted(int i) {
            return (i >= 200 && i < 300) || (i >= 400 && i < 600);
        }

        public static boolean isStatusError(int i) {
            return i >= 400 && i < 600;
        }

        public static boolean isStatusInformational(int i) {
            return i >= 100 && i < 200;
        }

        public static boolean isStatusServerError(int i) {
            return i >= 500 && i < 600;
        }

        public static boolean isStatusSuccess(int i) {
            return i >= 200 && i < 300;
        }

        static {
            StringBuilder sb = new StringBuilder();
            sb.append(AppRuntime.getAppContext().getPackageName());
            sb.append(".intent.action.DOWNLOAD_COMPLETED");
            ACTION_DOWNLOAD_COMPLETED = sb.toString();
            ACTION_NOTIFICATION_CLICKED = AppRuntime.getAppContext().getPackageName() + ".intent.action.DOWNLOAD_NOTIFICATION_CLICKED";
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(AppRuntime.getAppContext().getPackageName());
        sb.append(".intent.action.DOWNLOAD_COMPLETED");
        ACTION_DOWNLOAD_COMPLETED = sb.toString();
        ACTION_NOTIFICATION_CLICKED = AppRuntime.getAppContext().getPackageName() + ".intent.action.DOWNLOAD_NOTIFICATION_CLICKED";
    }

    public static String getDestinationDir() {
        if (sDestinationDir == null) {
            sDestinationDir = AppConfig.Downloads.getDestinationDir();
        }
        return sDestinationDir;
    }

    public static DestinationMode getDestinationMode() {
        if (sDestinationMode == null) {
            String destinationMode = AppConfig.Downloads.getDestinationMode();
            if (!TextUtils.isEmpty(destinationMode)) {
                try {
                    sDestinationMode = DestinationMode.valueOf(destinationMode);
                } catch (Exception unused) {
                    sDestinationMode = null;
                }
            }
        }
        DestinationMode destinationMode2 = sDestinationMode;
        if (destinationMode2 != null) {
            return destinationMode2;
        }
        return DestinationMode.AUTO;
    }
}
