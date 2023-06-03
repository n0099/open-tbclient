package com.baidu.android.imsdk.group.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.conversation.ConversationManagerImpl;
import com.baidu.android.imsdk.db.CursorWrapper;
import com.baidu.android.imsdk.db.DBGroupTableManager;
import com.baidu.android.imsdk.db.DBOperation;
import com.baidu.android.imsdk.db.DBOperationFactory;
import com.baidu.android.imsdk.db.DBResponseCode;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.db.IResultParse;
import com.baidu.android.imsdk.db.ITransaction;
import com.baidu.android.imsdk.group.GroupInfo;
import com.baidu.android.imsdk.group.GroupMember;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class GroupInfoDAOImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "GroupInfoDAOImpl";
    public static GroupInfoParse sGroupInfoParse;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class GroupInfoParse implements IResultParse<GroupInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public GroupInfoParse() {
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

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.android.imsdk.db.IResultParse
        public GroupInfo onParse(Cursor cursor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cursor)) == null) {
                if (cursor == null) {
                    return null;
                }
                String string = CursorWrapper.getString(cursor, "group_id");
                String string2 = CursorWrapper.getString(cursor, "group_name");
                int i = CursorWrapper.getInt(cursor, "group_type");
                int i2 = CursorWrapper.getInt(cursor, "state");
                long j = CursorWrapper.getLong(cursor, "create_time");
                long j2 = CursorWrapper.getLong(cursor, "bduid");
                long j3 = CursorWrapper.getLong(cursor, "uk");
                int i3 = CursorWrapper.getInt(cursor, DBTableDefine.GroupInfoColumns.COLUMN_USER_NUM);
                long j4 = CursorWrapper.getLong(cursor, DBTableDefine.GroupInfoColumns.COLUMN_USER_MEMBER_VERSION);
                int i4 = CursorWrapper.getInt(cursor, "disturb");
                int i5 = CursorWrapper.getInt(cursor, DBTableDefine.GroupInfoColumns.COLUMN_BRIEF);
                String string3 = CursorWrapper.getString(cursor, "description");
                int i6 = CursorWrapper.getInt(cursor, "marktop");
                long j5 = CursorWrapper.getLong(cursor, "marktoptime");
                String string4 = CursorWrapper.getString(cursor, DBTableDefine.GroupInfoColumns.COLUMN_GROUP_NOTICE);
                int i7 = CursorWrapper.getInt(cursor, DBTableDefine.GroupInfoColumns.COLUMN_GROUP_SIZE);
                int i8 = CursorWrapper.getInt(cursor, DBTableDefine.GroupInfoColumns.COLUMN_GROUP_VERIFY);
                String string5 = CursorWrapper.getString(cursor, DBTableDefine.GroupInfoColumns.COLUMN_GROUP_DESC);
                long j6 = CursorWrapper.getLong(cursor, DBTableDefine.GroupInfoColumns.COLUMN_USER_MEMBER_LOCAL_VERSION);
                long j7 = CursorWrapper.getLong(cursor, DBTableDefine.GroupInfoColumns.COLUMN_GROUP_INFO_LOCAL_VERSION);
                long j8 = CursorWrapper.getLong(cursor, DBTableDefine.GroupInfoColumns.COLUMN_GROUP_INFO_VERSION);
                int i9 = CursorWrapper.getInt(cursor, DBTableDefine.GroupInfoColumns.COLUMN_GROUP_ADMIN_SIZE_LIMIT);
                int i10 = CursorWrapper.getInt(cursor, DBTableDefine.GroupInfoColumns.COLUMN_GROUP_SUB_TYPE);
                String string6 = CursorWrapper.getString(cursor, DBTableDefine.GroupInfoColumns.COLUMN_GROUP_SETTING_INFO);
                String string7 = CursorWrapper.getString(cursor, DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE);
                int i11 = CursorWrapper.getInt(cursor, DBTableDefine.GroupInfoColumns.COLUMN_GROUP_AUDIT_STATE);
                int i12 = CursorWrapper.getInt(cursor, DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HAS_NOTICE);
                String string8 = CursorWrapper.getString(cursor, DBTableDefine.GroupInfoColumns.COLUMN_GROUP_NOTICE_EXT);
                String string9 = CursorWrapper.getString(cursor, DBTableDefine.GroupInfoColumns.COLUMN_GROUP_WELCOME_JSON_TEXT);
                GroupInfo groupInfo = new GroupInfo(string);
                groupInfo.setGroupName(string2);
                groupInfo.setType(i);
                groupInfo.setState(i2);
                groupInfo.setCreateTime(j);
                groupInfo.setBuid(j2);
                groupInfo.setUk(j3);
                groupInfo.setNum(i3);
                groupInfo.setMembersVersion(j4);
                groupInfo.setDisturb(i4);
                groupInfo.setBrief(i5);
                groupInfo.setHeadUrl(string3);
                groupInfo.setMarkTopTime(j5);
                groupInfo.setMarkTop(i6);
                groupInfo.setGroupNotice(string4);
                groupInfo.setGroupCapacity(i7);
                groupInfo.setGroupVerify(i8);
                groupInfo.setDescription(string5);
                groupInfo.setLocalMembersVersion(j6);
                groupInfo.setLocalInfoVersion(j7);
                groupInfo.setInfoVersion(j8);
                groupInfo.setMaxAdminCount(i9);
                groupInfo.setSubType(i10);
                groupInfo.setSettingInfo(string6);
                groupInfo.setHomePage(string7);
                groupInfo.setAuditState(i11);
                groupInfo.setHasNotice(i12);
                groupInfo.setNoticeExt(string8);
                groupInfo.setWelcomeJsonTxt(string9);
                return groupInfo;
            }
            return (GroupInfo) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class GroupMemberParser implements IResultParse<GroupMember> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public GroupMemberParser() {
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

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.android.imsdk.db.IResultParse
        public GroupMember onParse(Cursor cursor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cursor)) == null) {
                String string = CursorWrapper.getString(cursor, "group_id");
                long j = CursorWrapper.getLong(cursor, DBTableDefine.GroupMemberColumns.COLUMN_JOIN_TIME);
                int i = CursorWrapper.getInt(cursor, "role");
                String string2 = CursorWrapper.getString(cursor, "name");
                String string3 = CursorWrapper.getString(cursor, "nickname");
                long j2 = CursorWrapper.getLong(cursor, "bduid");
                long j3 = CursorWrapper.getLong(cursor, "uk");
                int i2 = CursorWrapper.getInt(cursor, "status");
                String string4 = CursorWrapper.getString(cursor, "avatar");
                String string5 = CursorWrapper.getString(cursor, DBTableDefine.GroupMemberColumns.COLUMN_AVATAR_EXT);
                String string6 = CursorWrapper.getString(cursor, DBTableDefine.GroupMemberColumns.COLUMN_ROLE_DISPLAY_NAME);
                String string7 = CursorWrapper.getString(cursor, DBTableDefine.GroupMemberColumns.COLUMN_ROLE_DECORATION);
                GroupMember groupMember = new GroupMember(string, j3, string2, j2, i, j);
                groupMember.setValid(i2);
                groupMember.setNickName(string3);
                groupMember.setPortrait(string4);
                groupMember.setAvatarExt(string5);
                groupMember.setRoleDisplayName(string6);
                groupMember.setRoleDecoration(string7);
                return groupMember;
            }
            return (GroupMember) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-699340676, "Lcom/baidu/android/imsdk/group/db/GroupInfoDAOImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-699340676, "Lcom/baidu/android/imsdk/group/db/GroupInfoDAOImpl;");
                return;
            }
        }
        sGroupInfoParse = new GroupInfoParse();
    }

    public GroupInfoDAOImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int activeGroupState(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                DBGroupTableManager dBGroupTableManager = (DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY);
                if (dBGroupTableManager.isExistGroupTable(context, str)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_ACTIVE_STATE, (Integer) 1);
                    int intValue = newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
                    if (intValue > 0) {
                        dBGroupTableManager.activeGroup(str);
                        return intValue;
                    }
                    return intValue;
                }
                return DBResponseCode.ERROR_GROUP_NOT_EXIST;
            }
            return DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeLL.intValue;
    }

    public static ArrayList<String> getExpiredFansGroupMemberList(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65549, null, context, j)) == null) {
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                return newDb.query(new IResultParse<String>() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.android.imsdk.db.IResultParse
                    public String onParse(Cursor cursor) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor)) == null) {
                            return CursorWrapper.getString(cursor, "group_id");
                        }
                        return (String) invokeL.objValue;
                    }
                }, "groupinfo", new String[]{"group_id"}, "state = 0 AND group_type = 3 AND local_members_version < " + j + " AND " + DBTableDefine.GroupInfoColumns.COLUMN_USER_MEMBER_LOCAL_VERSION + " > 0 ", null, null, null, "create_time DESC", null);
            }
            return null;
        }
        return (ArrayList) invokeLJ.objValue;
    }

    public static boolean isExistGroup(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, context, str)) == null) {
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            LogUtils.e(TAG, "operation : " + newDb);
            if (newDb != null) {
                DBGroupTableManager dBGroupTableManager = (DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY);
                if (dBGroupTableManager == null) {
                    dBGroupTableManager = new DBGroupTableManager();
                    newDb.setTag(DBGroupTableManager.KEY, dBGroupTableManager);
                }
                return dBGroupTableManager.isExistGroupTable(context, str);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static int quitGroup(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65567, null, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                DBOperation newDb = DBOperationFactory.getNewDb(context);
                int i = DBResponseCode.ERROR_DB_OPEN;
                if (newDb != null) {
                    i = newDb.execTransaction(new ITransaction(str) { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.11
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ String val$groupid;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {str};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$groupid = str;
                        }

                        @Override // com.baidu.android.imsdk.db.ITransaction
                        public void execTransaction(SQLiteDatabase sQLiteDatabase) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, sQLiteDatabase) == null) {
                                sQLiteDatabase.delete("groupinfo", "group_id = ? ", new String[]{this.val$groupid});
                                sQLiteDatabase.delete("groupmember", "group_id = ? ", new String[]{this.val$groupid});
                                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DBTableDefine.getGroupMessageTableName(this.val$groupid));
                            }
                        }
                    }).intValue();
                    DBGroupTableManager dBGroupTableManager = (DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY);
                    if (dBGroupTableManager != null) {
                        String groupMessageTableName = DBTableDefine.getGroupMessageTableName(str);
                        LogUtils.d(TAG, "STAR quit group");
                        dBGroupTableManager.quitGroupTable(groupMessageTableName);
                        dBGroupTableManager.deactiveGroup(str);
                    }
                }
                return i;
            }
            return DBResponseCode.ERROR_PARAMETER;
        }
        return invokeLL.intValue;
    }

    public static int updateGroupInfo(Context context, GroupInfo groupInfo) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65574, null, context, groupInfo)) == null) {
            if (context != null && groupInfo != null) {
                DBOperation newDb = DBOperationFactory.getNewDb(context);
                if (newDb == null) {
                    return DBResponseCode.ERROR_DB_OPEN;
                }
                if (!((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, groupInfo.getGroupId())) {
                    i = createGroup(context, groupInfo.getGroupId());
                } else {
                    i = 0;
                }
                if (i < 0) {
                    return DBResponseCode.ERROR_DB_OPEN;
                }
                return newDb.update("groupinfo", getGroupInfoCv(groupInfo), "group_id = ? ", new String[]{groupInfo.getGroupId()}).intValue();
            }
            return DBResponseCode.ERROR_PARAMETER;
        }
        return invokeLL.intValue;
    }

    public static long addMemberToGroup(Context context, String str, List<GroupMember> list) {
        InterceptResult invokeLLL;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, list)) == null) {
            if (context == null || TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
                return -7001L;
            }
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb == null) {
                return -70003L;
            }
            if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str)) {
                ArrayList arrayList = new ArrayList();
                for (GroupMember groupMember : list) {
                    ContentValues groupMemberCv = getGroupMemberCv(groupMember);
                    if (groupMemberCv != null) {
                        arrayList.add(groupMemberCv);
                    }
                }
                List<Long> insert = newDb.insert("groupmember", arrayList);
                if (insert != null && insert.size() > 0) {
                    j = insert.get(0).longValue();
                } else {
                    j = -7100;
                }
                return j;
            }
            return -7008L;
        }
        return invokeLLL.longValue;
    }

    public static int updateGroupInfoDoNotDisturb(Context context, long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65575, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i)})) == null) {
            if (context == null) {
                return DBResponseCode.ERROR_PARAMETER;
            }
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb == null) {
                return DBResponseCode.ERROR_DB_OPEN;
            }
            if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, String.valueOf(j))) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("disturb", Integer.valueOf(i));
                return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{String.valueOf(j)}).intValue();
            }
            return DBResponseCode.ERROR_GROUP_NOT_EXIST;
        }
        return invokeCommon.intValue;
    }

    public static void clearGroupMarkTop(Context context) {
        DBOperation newDb;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) && context != null && (newDb = DBOperationFactory.getNewDb(context)) != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("marktop", (Integer) 0);
            newDb.update("groupinfo", contentValues, "marktop = ? ", new String[]{String.valueOf(1)});
        }
    }

    public static ArrayList<String> getStarGroupList(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) {
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                return newDb.query(new IResultParse<String>() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.android.imsdk.db.IResultParse
                    public String onParse(Cursor cursor) {
                        InterceptResult invokeL2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor)) == null) {
                            return CursorWrapper.getString(cursor, "group_id");
                        }
                        return (String) invokeL2.objValue;
                    }
                }, "groupinfo", new String[]{"group_id"}, "group_type != 3", null, null, null, "create_time DESC", null);
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static int setAllStarDisturbDefault(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            if (context == null) {
                return DBResponseCode.ERROR_PARAMETER;
            }
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb == null) {
                return DBResponseCode.ERROR_DB_OPEN;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("disturb", (Integer) 1);
            return newDb.update("groupinfo", contentValues, "group_type = ? ", new String[]{"2"}).intValue();
        }
        return invokeL.intValue;
    }

    public static int createGroup(Context context, String str) {
        InterceptResult invokeLL;
        DBGroupTableManager dBGroupTableManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                String sqlCreateTableGroupMessage = DBTableDefine.getSqlCreateTableGroupMessage(str);
                ContentValues contentValues = new ContentValues();
                contentValues.put("group_id", str);
                int intValue = newDb.execTransaction(new ITransaction(sqlCreateTableGroupMessage, contentValues) { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String val$createGroupSql;
                    public final /* synthetic */ ContentValues val$cv;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {sqlCreateTableGroupMessage, contentValues};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$createGroupSql = sqlCreateTableGroupMessage;
                        this.val$cv = contentValues;
                    }

                    @Override // com.baidu.android.imsdk.db.ITransaction
                    public void execTransaction(SQLiteDatabase sQLiteDatabase) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, sQLiteDatabase) == null) {
                            sQLiteDatabase.execSQL(this.val$createGroupSql);
                            long insert = sQLiteDatabase.insert("groupinfo", null, this.val$cv);
                            LogUtils.d(GroupInfoDAOImpl.TAG, "insertret : " + insert);
                        }
                    }
                }).intValue();
                LogUtils.d(TAG, "STAR create star group " + intValue + " " + str);
                if (intValue == 0 && (dBGroupTableManager = (DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)) != null) {
                    String groupMessageTableName = DBTableDefine.getGroupMessageTableName(str);
                    LogUtils.d(TAG, "STAR add group table " + groupMessageTableName);
                    dBGroupTableManager.addGroupTable(groupMessageTableName);
                    return intValue;
                }
                return intValue;
            }
            return DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeLL.intValue;
    }

    public static ArrayList<GroupInfo> getGroupInfo(Context context, ArrayList<String> arrayList) {
        InterceptResult invokeLL;
        DBOperation newDb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, context, arrayList)) == null) {
            if (context == null || arrayList == null || arrayList.size() == 0 || (newDb = DBOperationFactory.getNewDb(context)) == null) {
                return null;
            }
            String str = " ( " + arrayList.get(0);
            for (int i = 1; i < arrayList.size(); i++) {
                str = str + StringUtil.ARRAY_ELEMENT_SEPARATOR + arrayList.get(i);
            }
            String str2 = str + " ) ";
            return newDb.query(sGroupInfoParse, "groupinfo", null, "group_id in " + str2, null, null, null, null, null);
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static ArrayList<Long> getGroupMemberId(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return null;
            }
            String str2 = (" AND ( role != 1") + " ) ";
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb == null) {
                return null;
            }
            return newDb.query(new IResultParse<Long>() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.android.imsdk.db.IResultParse
                public Long onParse(Cursor cursor) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, cursor)) == null) {
                        return Long.valueOf(CursorWrapper.getLong(cursor, "bduid"));
                    }
                    return (Long) invokeL.objValue;
                }
            }, "groupmember", new String[]{"bduid"}, "group_id = ? " + str2, new String[]{str}, null, null, null, null);
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static List<GroupMember> getGroupNormalRoleMembers(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, context, str)) == null) {
            boolean z = true;
            if (context != null && !TextUtils.isEmpty(str)) {
                DBOperation newDb = DBOperationFactory.getNewDb(context);
                if (newDb == null) {
                    return null;
                }
                return newDb.query(new GroupMemberParser(), "groupmember", null, "group_id = ? AND (role != 1 AND role != 2) ", new String[]{str}, null, null, null, null);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getGroupNormalRoleMembers failed, context null:");
            if (context != null) {
                z = false;
            }
            sb.append(z);
            sb.append(";groupId empty:");
            sb.append(TextUtils.isEmpty(str));
            LogUtils.d(TAG, sb.toString());
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public static List<GroupMember> getGroupOwnerAndAdmins(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, context, str)) == null) {
            boolean z = true;
            if (context != null && !TextUtils.isEmpty(str)) {
                DBOperation newDb = DBOperationFactory.getNewDb(context);
                if (newDb == null) {
                    return null;
                }
                return newDb.query(new GroupMemberParser(), "groupmember", null, "group_id = ? AND (role = 1 OR role = 2) ", new String[]{str}, null, null, null, null);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getGroupOwner failed, context null:");
            if (context != null) {
                z = false;
            }
            sb.append(z);
            sb.append(";groupId empty:");
            sb.append(TextUtils.isEmpty(str));
            LogUtils.d(TAG, sb.toString());
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public static int delAllGroupMember(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                DBOperation newDb = DBOperationFactory.getNewDb(context);
                if (newDb == null) {
                    return DBResponseCode.ERROR_DB_OPEN;
                }
                return newDb.delete("groupmember", "group_id = ?", new String[]{str}).intValue();
            }
            return DBResponseCode.ERROR_PARAMETER;
        }
        return invokeLL.intValue;
    }

    public static int deletedGroupMember(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) {
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("state", (Integer) 1);
                return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
            }
            return DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeLL.intValue;
    }

    public static ArrayList<String> getExpiredFansGroupInfoList(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65548, null, context, j)) == null) {
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                return newDb.query(new IResultParse<String>() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.android.imsdk.db.IResultParse
                    public String onParse(Cursor cursor) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor)) == null) {
                            return CursorWrapper.getString(cursor, "group_id");
                        }
                        return (String) invokeL.objValue;
                    }
                }, "groupinfo", new String[]{"group_id"}, "state = 0 AND group_type = 3 AND local_groupinfo_version < " + j, null, null, null, "create_time DESC", null);
            }
            return null;
        }
        return (ArrayList) invokeLJ.objValue;
    }

    public static ArrayList<GroupMember> getMemberNickname(Context context, String str) {
        InterceptResult invokeLL;
        DBOperation newDb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str) || (newDb = DBOperationFactory.getNewDb(context)) == null) {
                return null;
            }
            return newDb.query(new IResultParse<GroupMember>() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.android.imsdk.db.IResultParse
                public GroupMember onParse(Cursor cursor) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, cursor)) == null) {
                        String string = CursorWrapper.getString(cursor, "group_id");
                        long j = CursorWrapper.getLong(cursor, DBTableDefine.GroupMemberColumns.COLUMN_JOIN_TIME);
                        int i = CursorWrapper.getInt(cursor, "role");
                        String string2 = CursorWrapper.getString(cursor, "name");
                        String string3 = CursorWrapper.getString(cursor, "nickname");
                        long j2 = CursorWrapper.getLong(cursor, "bduid");
                        long j3 = CursorWrapper.getLong(cursor, "uk");
                        int i2 = CursorWrapper.getInt(cursor, "status");
                        String string4 = CursorWrapper.getString(cursor, "avatar");
                        String string5 = CursorWrapper.getString(cursor, DBTableDefine.GroupMemberColumns.COLUMN_ROLE_DISPLAY_NAME);
                        String string6 = CursorWrapper.getString(cursor, DBTableDefine.GroupMemberColumns.COLUMN_ROLE_DECORATION);
                        GroupMember groupMember = new GroupMember(string, j3, string2, j2, i, j);
                        groupMember.setValid(i2);
                        groupMember.setNickName(string3);
                        groupMember.setPortrait(string4);
                        groupMember.setRoleDisplayName(string5);
                        groupMember.setRoleDecoration(string6);
                        return groupMember;
                    }
                    return (GroupMember) invokeL.objValue;
                }
            }, "groupmember", null, "group_id = ? ", new String[]{str}, null, null, null, null);
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static void updateGroupListMarkTop(Context context, List<ChatSession> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65578, null, context, list) == null) {
            clearGroupMarkTop(context);
            if (list != null) {
                for (ChatSession chatSession : list) {
                    updateGroupMarkTop(context, chatSession.getContacter(), chatSession.getMarkTop(), chatSession.getMarkTopTime());
                }
            }
        }
    }

    public static int delGroupMember(Context context, String str, ArrayList<String> arrayList) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, context, str, arrayList)) == null) {
            if (context != null && arrayList != null && arrayList.size() != 0) {
                LogUtils.d("GroupInfoDAOIMPL", "delGroupMember " + arrayList.toString());
                DBOperation newDb = DBOperationFactory.getNewDb(context);
                if (newDb == null) {
                    return DBResponseCode.ERROR_DB_OPEN;
                }
                String str2 = " ( " + arrayList.get(0);
                for (int i = 1; i < arrayList.size(); i++) {
                    str2 = str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + arrayList.get(i);
                }
                return newDb.delete("groupmember", "group_id = ? AND bduid in " + (str2 + " ) "), new String[]{str}).intValue();
            }
            return DBResponseCode.ERROR_PARAMETER;
        }
        return invokeLLL.intValue;
    }

    public static ArrayList<GroupInfo> getAllFansGroupList(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                return newDb.query(sGroupInfoParse, "groupinfo", null, "state = 0 AND group_type = 3", null, null, null, "create_time DESC", null);
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static ArrayList<GroupInfo> getAllGroupInfo(Context context) {
        InterceptResult invokeL;
        DBOperation newDb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            if (context == null || (newDb = DBOperationFactory.getNewDb(context)) == null) {
                return null;
            }
            return newDb.query(sGroupInfoParse, "groupinfo", null, null, null, null, null, null, null);
        }
        return (ArrayList) invokeL.objValue;
    }

    public static ArrayList<String> getAllGroupList(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                return newDb.query(new IResultParse<String>() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.android.imsdk.db.IResultParse
                    public String onParse(Cursor cursor) {
                        InterceptResult invokeL2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor)) == null) {
                            return CursorWrapper.getString(cursor, "group_id");
                        }
                        return (String) invokeL2.objValue;
                    }
                }, "groupinfo", new String[]{"group_id"}, "state = 0 AND group_type != 2 AND state != 1", null, null, null, "create_time DESC", null);
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static ContentValues getGroupInfoCv(GroupInfo groupInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, groupInfo)) == null) {
            if (groupInfo == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("bduid", Long.valueOf(groupInfo.getBuid()));
            contentValues.put("uk", Long.valueOf(groupInfo.getUk()));
            contentValues.put("group_id", groupInfo.getGroupId());
            contentValues.put("group_name", groupInfo.getGroupName());
            contentValues.put("create_time", Long.valueOf(groupInfo.getCreateTime()));
            contentValues.put("group_type", Integer.valueOf(groupInfo.getType()));
            contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_USER_NUM, Integer.valueOf(groupInfo.getNum()));
            contentValues.put("state", Integer.valueOf(groupInfo.getState()));
            contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF, Integer.valueOf(groupInfo.getBrief()));
            contentValues.put("description", groupInfo.getHeadUrl());
            contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_SIZE, Integer.valueOf(groupInfo.getGroupCapacity()));
            contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_VERIFY, Integer.valueOf(groupInfo.getGroupVerify()));
            contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_NOTICE, groupInfo.getGroupNotice());
            contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_DESC, groupInfo.getDescription());
            if (groupInfo.getMembersVersion() > 0) {
                contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_USER_MEMBER_VERSION, Long.valueOf(groupInfo.getMembersVersion()));
            }
            if (groupInfo.getLocalMembersVersion() > 0) {
                contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_USER_MEMBER_LOCAL_VERSION, Long.valueOf(groupInfo.getLocalMembersVersion()));
            }
            if (groupInfo.getInfoVersion() > 0) {
                contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_INFO_VERSION, Long.valueOf(groupInfo.getInfoVersion()));
            }
            if (groupInfo.getLocalInfoVersion() > 0) {
                contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_INFO_LOCAL_VERSION, Long.valueOf(groupInfo.getLocalInfoVersion()));
            }
            contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_SUB_TYPE, Integer.valueOf(groupInfo.getSubType()));
            contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_SETTING_INFO, groupInfo.getSettingInfo());
            contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_ADMIN_SIZE_LIMIT, Integer.valueOf(groupInfo.getMaxAdminCount()));
            String homePage = groupInfo.getHomePage();
            if (!TextUtils.isEmpty(homePage)) {
                contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, homePage);
            }
            contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_AUDIT_STATE, Integer.valueOf(groupInfo.getAuditState()));
            contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HAS_NOTICE, Integer.valueOf(groupInfo.getHasGroupNotice()));
            contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_NOTICE_EXT, groupInfo.getNoticeExt());
            contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_WELCOME_JSON_TEXT, groupInfo.getWelcomeJsonTxt());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public static ArrayList<String> getGroupList(Context context, boolean z, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            String str = null;
            if (newDb == null) {
                return null;
            }
            String str2 = "active_state = 1";
            if (z) {
                str2 = "active_state = 1 AND state = 0";
            }
            String str3 = str2 + " AND group_type != 2";
            if (i > 0) {
                str = String.valueOf(i);
                if (i2 > 0) {
                    str = str + " offset " + i2;
                }
            }
            return newDb.query(new IResultParse<String>() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.android.imsdk.db.IResultParse
                public String onParse(Cursor cursor) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor)) == null) {
                        return CursorWrapper.getString(cursor, "group_id");
                    }
                    return (String) invokeL.objValue;
                }
            }, "groupinfo", new String[]{"group_id"}, str3, null, null, null, "create_time DESC", str);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public static int modifyGroupInfoVersion(Context context, String str, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65563, null, new Object[]{context, str, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (context != null && !TextUtils.isEmpty(str) && j >= 0) {
                DBOperation newDb = DBOperationFactory.getNewDb(context);
                if (newDb == null) {
                    return DBResponseCode.ERROR_DB_OPEN;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_INFO_VERSION, Long.valueOf(j));
                contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_INFO_LOCAL_VERSION, Long.valueOf(j2));
                return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
            }
            return DBResponseCode.ERROR_PARAMETER;
        }
        return invokeCommon.intValue;
    }

    public static int modifyGroupMemberVersion(Context context, String str, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65565, null, new Object[]{context, str, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (context != null && !TextUtils.isEmpty(str) && j >= 0) {
                DBOperation newDb = DBOperationFactory.getNewDb(context);
                if (newDb == null) {
                    return DBResponseCode.ERROR_DB_OPEN;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_USER_MEMBER_VERSION, Long.valueOf(j));
                contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_USER_MEMBER_LOCAL_VERSION, Long.valueOf(j2));
                return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
            }
            return DBResponseCode.ERROR_PARAMETER;
        }
        return invokeCommon.intValue;
    }

    public static int updateGroupInfoMarkTop(Context context, long j, int i, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65576, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2)})) == null) {
            if (context == null) {
                return DBResponseCode.ERROR_PARAMETER;
            }
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb == null) {
                return DBResponseCode.ERROR_DB_OPEN;
            }
            if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, String.valueOf(j))) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("marktop", Integer.valueOf(i));
                contentValues.put("marktoptime", Long.valueOf(j2));
                return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{String.valueOf(j)}).intValue();
            }
            return DBResponseCode.ERROR_GROUP_NOT_EXIST;
        }
        return invokeCommon.intValue;
    }

    public static int updateGroupMembersRole(Context context, String str, List<Long> list, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65581, null, context, str, list, i)) == null) {
            if (!TextUtils.isEmpty(str) && list != null && list.size() != 0) {
                DBOperation newDb = DBOperationFactory.getNewDb(context);
                if (newDb == null) {
                    return DBResponseCode.ERROR_DB_OPEN;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("role", Integer.valueOf(i));
                StringBuilder sb = new StringBuilder(" in (");
                sb.append(list.get(0));
                for (int i2 = 1; i2 < list.size(); i2++) {
                    sb.append(",");
                    sb.append(list.get(i2));
                }
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                return newDb.update("groupmember", contentValues, "group_id = ? AND bduid" + sb.toString(), new String[]{str}).intValue();
            }
            return DBResponseCode.ERROR_PARAMETER;
        }
        return invokeLLLI.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x008f, code lost:
        if (r15 == 0) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<GroupMember> getGroupMember(Context context, String str, ArrayList<String> arrayList, int i) {
        InterceptResult invokeLLLI;
        ArrayList<GroupMember> arrayList2;
        String str2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65553, null, context, str, arrayList, i)) == null) {
            GroupMember groupMember = null;
            if (context == null || TextUtils.isEmpty(str)) {
                return null;
            }
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                String str5 = "";
                if (arrayList == null || arrayList.size() <= 0) {
                    str2 = "";
                } else {
                    String str6 = " AND ( bduid = " + arrayList.get(0);
                    for (int i2 = 1; i2 < arrayList.size(); i2++) {
                        str6 = str6 + " OR bduid = " + arrayList.get(i2);
                    }
                    str2 = str6 + " ) ";
                }
                if (i < 0) {
                    str5 = "join_time DESC ";
                    str3 = String.valueOf(Math.abs(i));
                } else {
                    if (i > 0) {
                        str3 = String.valueOf(i);
                    } else {
                        str3 = null;
                    }
                    str4 = "join_time ASC  ";
                    arrayList2 = newDb.query(new GroupMemberParser(), "groupmember", null, "group_id = ? " + str2, new String[]{str}, null, null, str4, str3);
                }
                str4 = str5;
                arrayList2 = newDb.query(new GroupMemberParser(), "groupmember", null, "group_id = ? " + str2, new String[]{str}, null, null, str4, str3);
            } else {
                arrayList2 = null;
            }
            if (arrayList2 != null) {
                int i3 = 0;
                while (true) {
                    if (i3 >= arrayList2.size()) {
                        break;
                    }
                    GroupMember groupMember2 = arrayList2.get(i3);
                    if (1 == groupMember2.getRole()) {
                        arrayList2.remove(i3);
                        groupMember = groupMember2;
                        break;
                    }
                    i3++;
                }
                if (groupMember != null) {
                    arrayList2.add(0, groupMember);
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeLLLI.objValue;
    }

    public static ContentValues getGroupMemberCv(GroupMember groupMember) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, groupMember)) == null) {
            if (groupMember == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("group_id", groupMember.getGroupid());
            contentValues.put(DBTableDefine.GroupMemberColumns.COLUMN_JOIN_TIME, Long.valueOf(groupMember.getJointime()));
            contentValues.put("role", Integer.valueOf(groupMember.getRole()));
            contentValues.put("bduid", Long.valueOf(groupMember.getBduid()));
            contentValues.put("uk", Long.valueOf(groupMember.getUk()));
            contentValues.put("nickname", groupMember.getNickName());
            contentValues.put("status", Integer.valueOf(groupMember.getValid()));
            contentValues.put("name", groupMember.getName());
            contentValues.put("avatar", groupMember.getPortrait());
            contentValues.put(DBTableDefine.GroupMemberColumns.COLUMN_AVATAR_EXT, groupMember.getAvatarExt());
            contentValues.put(DBTableDefine.GroupMemberColumns.COLUMN_ROLE_DISPLAY_NAME, groupMember.getRoleDisplayName());
            contentValues.put(DBTableDefine.GroupMemberColumns.COLUMN_ROLE_DECORATION, groupMember.getRoleDecoration());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public static String getNickName(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65559, null, context, str, str2)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                DBOperation newDb = DBOperationFactory.getNewDb(context);
                if (newDb != null) {
                    arrayList = newDb.query(new IResultParse<String>() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.9
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                }
                            }
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.android.imsdk.db.IResultParse
                        public String onParse(Cursor cursor) {
                            InterceptResult invokeL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor)) == null) {
                                return CursorWrapper.getString(cursor, "nickname");
                            }
                            return (String) invokeL.objValue;
                        }
                    }, "groupmember", new String[]{"nickname"}, "group_id = ?  AND bduid = ? ", new String[]{str, str2}, null, null, null, null);
                } else {
                    arrayList = null;
                }
                if (arrayList != null && arrayList.size() > 0) {
                    return (String) arrayList.get(0);
                }
            }
            return null;
        }
        return (String) invokeLLL.objValue;
    }

    public static int getRole(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65560, null, context, str, str2)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                ArrayList arrayList = null;
                DBOperation newDb = DBOperationFactory.getNewDb(context);
                if (newDb != null) {
                    arrayList = newDb.query(new IResultParse<Integer>() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.10
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                }
                            }
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.android.imsdk.db.IResultParse
                        public Integer onParse(Cursor cursor) {
                            InterceptResult invokeL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, cursor)) == null) {
                                return Integer.valueOf(cursor.getInt(cursor.getColumnIndex("role")));
                            }
                            return (Integer) invokeL.objValue;
                        }
                    }, "groupmember", new String[]{"role"}, "group_id = ?  AND bduid = ? ", new String[]{str, str2}, null, null, null, null);
                }
                if (arrayList != null && arrayList.size() > 0) {
                    return ((Integer) arrayList.get(0)).intValue();
                }
            }
            return -1;
        }
        return invokeLLL.intValue;
    }

    public static int modifyGroupMemberNumber(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65564, null, context, str, i)) == null) {
            if (context != null && !TextUtils.isEmpty(str) && i >= 0) {
                DBOperation newDb = DBOperationFactory.getNewDb(context);
                if (newDb == null) {
                    return DBResponseCode.ERROR_DB_OPEN;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_USER_NUM, Integer.valueOf(i));
                return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
            }
            return DBResponseCode.ERROR_PARAMETER;
        }
        return invokeLLI.intValue;
    }

    public static int modifyGroupName(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65566, null, context, str, str2)) == null) {
            if (context != null && !TextUtils.isEmpty(str) && str2 != null) {
                ConversationManagerImpl.getInstance(context).updateConversationName(str2, 1, String.valueOf(str));
                DBOperation newDb = DBOperationFactory.getNewDb(context);
                if (newDb == null) {
                    return DBResponseCode.ERROR_DB_OPEN;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("group_name", str2);
                return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
            }
            return DBResponseCode.ERROR_PARAMETER;
        }
        return invokeLLL.intValue;
    }

    public static int setGroupDisturb(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65569, null, context, str, i)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                DBOperation newDb = DBOperationFactory.getNewDb(context);
                if (newDb == null) {
                    return DBResponseCode.ERROR_DB_OPEN;
                }
                if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("disturb", Integer.valueOf(i));
                    return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
                }
                return DBResponseCode.ERROR_GROUP_NOT_EXIST;
            }
            return DBResponseCode.ERROR_PARAMETER;
        }
        return invokeLLI.intValue;
    }

    public static int setGroupPermit(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65570, null, context, str, i)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                DBOperation newDb = DBOperationFactory.getNewDb(context);
                if (newDb == null) {
                    return DBResponseCode.ERROR_DB_OPEN;
                }
                if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF, Integer.valueOf(i));
                    return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
                }
                return DBResponseCode.ERROR_GROUP_NOT_EXIST;
            }
            return DBResponseCode.ERROR_PARAMETER;
        }
        return invokeLLI.intValue;
    }

    public static int setGroupState(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65571, null, context, str, i)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                DBOperation newDb = DBOperationFactory.getNewDb(context);
                if (newDb == null) {
                    return DBResponseCode.ERROR_DB_OPEN;
                }
                if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("state", Integer.valueOf(i));
                    return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
                }
                return DBResponseCode.ERROR_GROUP_NOT_EXIST;
            }
            return DBResponseCode.ERROR_PARAMETER;
        }
        return invokeLLI.intValue;
    }

    public static int setGroupType(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65572, null, context, str, i)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                DBOperation newDb = DBOperationFactory.getNewDb(context);
                if (newDb == null) {
                    return DBResponseCode.ERROR_DB_OPEN;
                }
                if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("group_type", Integer.valueOf(i));
                    return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
                }
                return DBResponseCode.ERROR_GROUP_NOT_EXIST;
            }
            return DBResponseCode.ERROR_PARAMETER;
        }
        return invokeLLI.intValue;
    }

    public static int updateMemberToGroup(Context context, String str, GroupMember groupMember) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65584, null, context, str, groupMember)) == null) {
            if (context != null && !TextUtils.isEmpty(str) && groupMember != null) {
                DBOperation newDb = DBOperationFactory.getNewDb(context);
                if (newDb == null) {
                    return DBResponseCode.ERROR_DB_OPEN;
                }
                if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str)) {
                    return newDb.update(DBTableDefine.getGroupMessageTableName(str), getGroupMemberCv(groupMember), "group_id = ? AND bduid = ?", new String[]{groupMember.getGroupid(), String.valueOf(groupMember.getBduid())}).intValue();
                }
                return DBResponseCode.ERROR_GROUP_NOT_EXIST;
            }
            return DBResponseCode.ERROR_PARAMETER;
        }
        return invokeLLL.intValue;
    }

    public static void updateGroupDoNotDisturb(Context context, long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65573, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i)}) == null) {
            updateGroupInfoDoNotDisturb(context, j, i);
            ChatMessageDBManager.getInstance(context).updateSessionDisturb(1, j, i);
        }
    }

    public static int updateMasterAsCommon(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65582, null, context, str, i)) == null) {
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("role", Integer.valueOf(i));
                return newDb.update("groupmember", contentValues, "group_id = ? AND role = 2 ", new String[]{str}).intValue();
            }
            return DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeLLI.intValue;
    }

    public static void updateGroupListDoNotDisturb(Context context, List<ChatSession> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65577, null, context, list) == null) && list != null) {
            for (ChatSession chatSession : list) {
                updateGroupDoNotDisturb(context, chatSession.getContacter(), chatSession.getDisturb());
            }
        }
    }

    public static void updateGroupMarkTop(Context context, long j, int i, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65579, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2)}) == null) {
            updateGroupInfoMarkTop(context, j, i, j2);
            ChatMessageDBManager.getInstance(context).updateChatSessionMarkTop(1, j, i, j2);
        }
    }

    public static int updateGroupMemberRole(Context context, String str, String str2, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65580, null, context, str, str2, i)) == null) {
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("role", Integer.valueOf(i));
                return newDb.update("groupmember", contentValues, "group_id = ? AND bduid = ? ", new String[]{str, str2}).intValue();
            }
            return DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeLLLI.intValue;
    }

    public static int updateMemberNickName(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65583, null, context, str, str2, str3)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                DBOperation newDb = DBOperationFactory.getNewDb(context);
                if (newDb == null) {
                    return DBResponseCode.ERROR_DB_OPEN;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("nickname", str3);
                return newDb.update("groupmember", contentValues, "group_id = ? AND bduid = ?", new String[]{str, str2}).intValue();
            }
            return DBResponseCode.ERROR_PARAMETER;
        }
        return invokeLLLL.intValue;
    }
}
