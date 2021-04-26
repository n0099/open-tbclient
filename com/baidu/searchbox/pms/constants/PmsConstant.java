package com.baidu.searchbox.pms.constants;
/* loaded from: classes2.dex */
public final class PmsConstant {
    public static boolean DEBUG = false;

    /* loaded from: classes2.dex */
    public static final class DynamicDBVersion {
        public static final int DB_VERSION_10_6_0 = 1;
        public static final int DB_VERSION_12_12_0 = 2;
        public static final int DB_VERSION_12_14_0 = 3;
    }

    /* loaded from: classes2.dex */
    public static final class EnvParam {

        /* loaded from: classes2.dex */
        public static final class Key {
            public static final String CPU_ABI = "cpu_abi";
            public static final String CPU_FEATURE = "cpu_feature";
            public static final String FREE_SPACE = "free_space";
            public static final String WHOLE_SPACE = "whole_space";
        }
    }

    /* loaded from: classes2.dex */
    public static final class Statistic {
        public static final String STATISTIC_CHANNELID = "channel_id";
        public static final String STATISTIC_CHANNELIDS = "channel_ids";
        public static final String STATISTIC_DEGRADE = "degrade";
        public static final String STATISTIC_ERRCODE = "err_code";
        public static final String STATISTIC_ERRMSG = "err_msg";
        public static final String STATISTIC_IP = "ip_address";
        public static final String STATISTIC_NETWORK = "network_type";
        public static final String STATISTIC_PKGNAME = "package_name";
        public static final String STATISTIC_RETRY_COUNT = "retry_count";
        public static final String STATISTIC_URL = "url";
        public static final String STATISTIC_VERSION = "version";

        /* loaded from: classes2.dex */
        public static final class Key {
            public static final String REV_DETAIL = "detail";
            public static final String REV_EXT = "ext";
            public static final String REV_FROM = "from";
            public static final String REV_ITEM_PRODUCT = "product";
            public static final String REV_ITEM_VALID = "valid";
            public static final String REV_ITEM_VERSION = "version";
            public static final String REV_SOURCE = "source";
            public static final String REV_SUCCESS_COUNT = "successCount";
            public static final String REV_TIMESTAMP = "timeStamp";
            public static final String REV_TOTAL_COUNT = "totalCount";
            public static final String REV_VERSION_FILTER_COUNT = "versionFilterCount";
        }

        /* loaded from: classes2.dex */
        public static final class UBC {
            public static final String UBC_REV_ID = "645";
        }

        /* loaded from: classes2.dex */
        public static final class Value {
            public static final String REV_FROM = "research";
            public static final String REV_ITEM_VALID = "1";
            public static final String REV_SOURCE_APS = "aps";
            public static final String REV_SOURCE_APS_LC = "aps_lc";
            public static final int REV_VERSION_FILTER_COUNT = 0;
        }
    }
}
