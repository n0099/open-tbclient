package com.baidu.android.imsdk.db;

import android.provider.BaseColumns;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class DBTableDefine {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DB_NAME_PREFIX = "bd_imsdk_";
    public static final String DB_TABLE_GROUP_INFO = "groupinfo";
    public static final String DB_TABLE_GROUP_LOCALMESSAGE = "grouplocalmessage";
    public static final String DB_TABLE_GROUP_MEMBER = "groupmember";
    public static final String DB_TABLE_GROUP_MESSAGE = "groupmessage";
    public static final String SQL_CREATE_TABLE_GROUPINFO = "CREATE TABLE groupinfo (group_id TEXT NOT NULL PRIMARY KEY, bduid LONG DEFALUT '0', uk LONG DEFALUT '0', group_name NOT NULL DEFAULT \"\", group_type INTEGER DEFAULT '0', group_size INTEGER DEFAULT '0', group_verify INTEGER DEFAULT 0, create_time LONG DEFAULT '0', delete_time LONG DEFAULT '9223372036854775807', members_version LONG DEFAULT '0', local_members_version LONG DEFAULT '0', groupinfo_version LONG DEFAULT '0', local_groupinfo_version LONG DEFAULT '0', active_state INTEGER DEFAULT '0', user_num INTEGER DEFAULT '0', state INTEGER DEFAULT '0', disturb INTEGER, table_exist INTEGER DEFAULT '0', description TEXT, marktop INTEGER DEFAULT 1, marktoptime LONG, group_notice TEXT, group_desc TEXT, brief INTEGER DEFAULT '0')";
    public static final String SQL_CREATE_TABLE_GROUP_MEMBER = "CREATE TABLE groupmember (group_id TEXT NOT NULL, bduid LONG, uk LONG, name TEXT, nickname TEXT, join_time LONG, last_active_time LONG, msg_set INTEGER, status INTEGER, role INTEGER ,avatar TEXT,  PRIMARY KEY (group_id,bduid));";
    public static final String SQL_CREATE_TABLE_GROUP_MESSAGE = " (_id INTEGER PRIMARY KEY AUTOINCREMENT, msgid LONG UNIQUE, sendid TEXT DEFALUT '', groupid LONG, from_uk LONG, from_buid TEXT, type INTEGER, content TEXT, time LONG, is_read INTEGER, local_url TEXT, isclicked INTEGER,device_flag INTEGER,cmd INTEGER, status INTEGER DEFAULT0, msg_key TEXT);";
    public static final String SQL_CREATE_TABLE_LOCALMESSAGE = "CREATE TABLE grouplocalmessage (_id INTEGER PRIMARY KEY AUTOINCREMENT, msgid LONG, sendid TEXT DEFALUT '', groupid LONG, from_uk LONG, from_buid TEXT, type INTEGER, content TEXT, time LONG, is_read INTEGER, local_url TEXT, isclicked INTEGER,device_flag INTEGER,cmd INTEGER, status INTEGER DEFAULT0, msg_key TEXT);";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static final class GroupInfoColumns implements BaseColumns {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String COLUMN_ACTIVE_STATE = "active_state";
        public static final String COLUMN_BD_UID = "bduid";
        public static final String COLUMN_BRIEF = "brief";
        public static final String COLUMN_CREATE_TIME = "create_time";
        public static final String COLUMN_DELETE_TIEM = "delete_time";
        public static final String COLUMN_DISTURB = "disturb";
        public static final String COLUMN_GROUP_DESC = "group_desc";
        public static final String COLUMN_GROUP_ID = "group_id";
        public static final String COLUMN_GROUP_IMAGE = "description";
        public static final String COLUMN_GROUP_INFO_LOCAL_VERSION = "local_groupinfo_version";
        public static final String COLUMN_GROUP_INFO_VERSION = "groupinfo_version";
        public static final String COLUMN_GROUP_NAME = "group_name";
        public static final String COLUMN_GROUP_NOTICE = "group_notice";
        public static final String COLUMN_GROUP_SIZE = "group_size";
        public static final String COLUMN_GROUP_TYPE = "group_type";
        public static final String COLUMN_GROUP_VERIFY = "group_verify";
        public static final String COLUMN_MARKTOP = "marktop";
        public static final String COLUMN_MESSAGETABLE_EXIST = "table_exist";
        public static final String COLUMN_STATE = "state";
        public static final String COLUMN_TOPTIME = "marktoptime";
        public static final String COLUMN_UK = "uk";
        public static final String COLUMN_USER_MEMBER_LOCAL_VERSION = "local_members_version";
        public static final String COLUMN_USER_MEMBER_VERSION = "members_version";
        public static final String COLUMN_USER_NUM = "user_num";
        public transient /* synthetic */ FieldHolder $fh;

        public GroupInfoColumns() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class GroupMemberColumns implements BaseColumns {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String COLUMN_AVATAR = "avatar";
        public static final String COLUMN_BD_UID = "bduid";
        public static final String COLUMN_GROUP_ID = "group_id";
        public static final String COLUMN_JOIN_TIME = "join_time";
        public static final String COLUMN_LAST_ACTIVE_TIME = "last_active_time";
        public static final String COLUMN_MSG_SET = "msg_set";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_NICKNAME = "nickname";
        public static final String COLUMN_ROLE = "role";
        public static final String COLUMN_STATUS = "status";
        public static final String COLUMN_UK = "uk";
        public transient /* synthetic */ FieldHolder $fh;

        public GroupMemberColumns() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class GroupMessageColumns implements BaseColumns {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String COLUMN_CMD = "cmd";
        public static final String COLUMN_CONTENT = "content";
        public static final String COLUMN_DEVICE_FLAG = "device_flag";
        public static final String COLUMN_FROM_BUID = "from_buid";
        public static final String COLUMN_FROM_USER = "from_uk";
        public static final String COLUMN_GROUPID = "groupid";
        public static final String COLUMN_IS_CLICKED = "isclicked";
        public static final String COLUMN_IS_READ = "is_read";
        public static final String COLUMN_LOCAL_URL = "local_url";
        public static final String COLUMN_MSGID = "msgid";
        public static final String COLUMN_MSGKEY = "msg_key";
        public static final String COLUMN_SEND_MSGID = "sendid";
        public static final String COLUMN_STATUS = "status";
        public static final String COLUMN_TIME = "time";
        public static final String COLUMN_TYPE = "type";
        public transient /* synthetic */ FieldHolder $fh;

        public GroupMessageColumns() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public DBTableDefine() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getGroupMessageTableName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return "groupmessage_" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String getSqlCreateTableGroupMessage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + getGroupMessageTableName(str) + SQL_CREATE_TABLE_GROUP_MESSAGE;
        }
        return (String) invokeL.objValue;
    }
}
