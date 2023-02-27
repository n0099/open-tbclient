package com.baidu.searchbox.aideviceperformance.data;

import java.util.List;
/* loaded from: classes2.dex */
public class DBTableConfig {

    /* loaded from: classes2.dex */
    public static class LaunchTimeDBTable {
        public static final String APP_LUNCH_TIME_COLUMN = "app_launch_time";
        public static final String CREATE_TABLE_SQL = "create table app_launch_time (event_time long default 0,app_launch_time long default 0);";
        public static final String DB_NAME = "device_info.db";
        public static final boolean ENABLE_COUNT_RESTRICTION_FLAG = true;
        public static final String EVENT_TIME_COLUMN = "event_time";
        public static final int ONE_TIME_DELETE_NUM = 50;
        public static final int RESTRICT_NUM = 150;
        public static final String TABLE_NAME = "app_launch_time";
        public static final int VERSION = 1;
    }

    /* loaded from: classes2.dex */
    public static class UserStickinessDBTable {
        public static final String DB_NAME = "behavior_info.db";
        public static final boolean ENABLE_COUNT_RESTRICTION_FLAG = true;
        public static final String EVENT_TIME_COLUMN = "event_time";
        public static final int ONE_TIME_DELETE_NUM = 50;
        public static final int RESTRICT_NUM = 150;
        public static final String TABLE_NAME = "user_stickiness";
        public static final int VERSION = 3;
        public static List<String> sRegisterIds;

        public static String getCreateTableSql() {
            return "create table user_stickiness (event_time long default 0," + getRegisteredIdSql() + ");";
        }

        public static String getRegisteredIdSql() {
            if (sRegisterIds == null) {
                return null;
            }
            String str = "";
            for (int i = 0; i < sRegisterIds.size(); i++) {
                String str2 = sRegisterIds.get(i);
                if (i == sRegisterIds.size() - 1) {
                    str = str + UserStickinessSQLiteOpenHelper.COUNT_PREFIX + str2 + " long default 0,first_time_" + str2 + " long default 0";
                } else {
                    str = str + UserStickinessSQLiteOpenHelper.COUNT_PREFIX + str2 + " long default 0,first_time_" + str2 + " long default 0,";
                }
            }
            return str;
        }

        public static void setRegisterIds(List<String> list) {
            sRegisterIds = list;
        }
    }
}
