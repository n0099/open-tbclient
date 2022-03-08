package com.baidu.searchbox.aideviceperformance.data;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class DBTableConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class LaunchTimeDBTable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String APP_LUNCH_TIME_COLUMN = "app_launch_time";
        public static final String CREATE_TABLE_SQL = "create table app_launch_time (event_time long default 0,app_launch_time long default 0);";
        public static final String DB_NAME = "device_info.db";
        public static final boolean ENABLE_COUNT_RESTRICTION_FLAG = true;
        public static final String EVENT_TIME_COLUMN = "event_time";
        public static final int ONE_TIME_DELETE_NUM = 50;
        public static final int RESTRICT_NUM = 150;
        public static final String TABLE_NAME = "app_launch_time";
        public static final int VERSION = 1;
        public transient /* synthetic */ FieldHolder $fh;

        public LaunchTimeDBTable() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class UserStickinessDBTable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String DB_NAME = "behavior_info.db";
        public static final boolean ENABLE_COUNT_RESTRICTION_FLAG = true;
        public static final String EVENT_TIME_COLUMN = "event_time";
        public static final int ONE_TIME_DELETE_NUM = 50;
        public static final int RESTRICT_NUM = 150;
        public static final String TABLE_NAME = "user_stickiness";
        public static final int VERSION = 3;
        public static List<String> sRegisterIds;
        public transient /* synthetic */ FieldHolder $fh;

        public UserStickinessDBTable() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static String getCreateTableSql() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                return "create table user_stickiness (event_time long default 0," + getRegisteredIdSql() + ");";
            }
            return (String) invokeV.objValue;
        }

        public static String getRegisteredIdSql() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                if (sRegisterIds == null) {
                    return null;
                }
                String str = "";
                for (int i2 = 0; i2 < sRegisterIds.size(); i2++) {
                    String str2 = sRegisterIds.get(i2);
                    str = i2 == sRegisterIds.size() - 1 ? str + UserStickinessSQLiteOpenHelper.COUNT_PREFIX + str2 + " long default 0,first_time_" + str2 + " long default 0" : str + UserStickinessSQLiteOpenHelper.COUNT_PREFIX + str2 + " long default 0,first_time_" + str2 + " long default 0,";
                }
                return str;
            }
            return (String) invokeV.objValue;
        }

        public static void setRegisterIds(List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, null, list) == null) {
                sRegisterIds = list;
            }
        }
    }

    public DBTableConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
