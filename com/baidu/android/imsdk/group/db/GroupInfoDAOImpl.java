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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class GroupInfoDAOImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "GroupInfoDAOImpl";
    public static GroupInfoParse sGroupInfoParse;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class GroupInfoParse implements IResultParse<GroupInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public GroupInfoParse() {
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
                String string = cursor.getString(cursor.getColumnIndex("group_id"));
                String string2 = cursor.getString(cursor.getColumnIndex("group_name"));
                int i2 = cursor.getInt(cursor.getColumnIndex("group_type"));
                int i3 = cursor.getInt(cursor.getColumnIndex("state"));
                long j = cursor.getLong(cursor.getColumnIndex("create_time"));
                long j2 = cursor.getLong(cursor.getColumnIndex("bduid"));
                long j3 = cursor.getLong(cursor.getColumnIndex("uk"));
                int i4 = cursor.getInt(cursor.getColumnIndex(DBTableDefine.GroupInfoColumns.COLUMN_USER_NUM));
                long j4 = cursor.getLong(cursor.getColumnIndex(DBTableDefine.GroupInfoColumns.COLUMN_USER_MEMBER_VERSION));
                int i5 = cursor.getInt(cursor.getColumnIndex("disturb"));
                int i6 = cursor.getInt(cursor.getColumnIndex(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF));
                String string3 = cursor.getString(cursor.getColumnIndex("description"));
                int i7 = cursor.getInt(cursor.getColumnIndex("marktop"));
                long j5 = cursor.getLong(cursor.getColumnIndex("marktoptime"));
                String string4 = cursor.getString(cursor.getColumnIndex(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_NOTICE));
                int i8 = cursor.getInt(cursor.getColumnIndex(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_SIZE));
                int i9 = cursor.getInt(cursor.getColumnIndex(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_VERIFY));
                String string5 = cursor.getString(cursor.getColumnIndex(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_DESC));
                long j6 = cursor.getLong(cursor.getColumnIndex(DBTableDefine.GroupInfoColumns.COLUMN_USER_MEMBER_LOCAL_VERSION));
                long j7 = cursor.getLong(cursor.getColumnIndex(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_INFO_VERSION));
                long j8 = cursor.getLong(cursor.getColumnIndex(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_INFO_LOCAL_VERSION));
                GroupInfo groupInfo = new GroupInfo(string);
                groupInfo.setGroupName(string2);
                groupInfo.setType(i2);
                groupInfo.setState(i3);
                groupInfo.setCreateTime(j);
                groupInfo.setBuid(j2);
                groupInfo.setUk(j3);
                groupInfo.setNum(i4);
                groupInfo.setMembersVersion(j4);
                groupInfo.setDisturb(i5);
                groupInfo.setBrief(i6);
                groupInfo.setHeadUrl(string3);
                groupInfo.setMarkTopTime(j5);
                groupInfo.setMarkTop(i7);
                groupInfo.setGroupNotice(string4);
                groupInfo.setGroupCapacity(i8);
                groupInfo.setGroupVerify(i9);
                groupInfo.setDescription(string5);
                groupInfo.setLocalMembersVersion(j6);
                groupInfo.setLocalInfoVersion(j7);
                groupInfo.setInfoVersion(j8);
                return groupInfo;
            }
            return (GroupInfo) invokeL.objValue;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public static long addMemberToGroup(Context context, String str, List<GroupMember> list) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, list)) == null) {
            if (context == null || TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
                return -7001L;
            }
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str)) {
                    ArrayList arrayList = new ArrayList();
                    for (GroupMember groupMember : list) {
                        ContentValues groupMemberCv = getGroupMemberCv(groupMember);
                        if (groupMemberCv != null) {
                            arrayList.add(groupMemberCv);
                        }
                    }
                    List<Long> insert = newDb.insert("groupmember", arrayList);
                    return (insert == null || insert.size() <= 0) ? -7100L : insert.get(0).longValue();
                }
                return -7008L;
            }
            return -70003L;
        }
        return invokeLLL.longValue;
    }

    public static void clearGroupMarkTop(Context context) {
        DBOperation newDb;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) || context == null || (newDb = DBOperationFactory.getNewDb(context)) == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("marktop", (Integer) 0);
        newDb.update("groupinfo", contentValues, "marktop = ? ", new String[]{String.valueOf(1)});
    }

    public static int createGroup(Context context, String str) {
        InterceptResult invokeLL;
        DBGroupTableManager dBGroupTableManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, str)) == null) {
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                String sqlCreateTableGroupMessage = DBTableDefine.getSqlCreateTableGroupMessage(str);
                ContentValues contentValues = new ContentValues();
                contentValues.put("group_id", str);
                int intValue = newDb.execTransaction(new ITransaction(sqlCreateTableGroupMessage, contentValues) { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String val$creatgroup;
                    public final /* synthetic */ ContentValues val$cv;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {sqlCreateTableGroupMessage, contentValues};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$creatgroup = sqlCreateTableGroupMessage;
                        this.val$cv = contentValues;
                    }

                    @Override // com.baidu.android.imsdk.db.ITransaction
                    public void execTransaction(SQLiteDatabase sQLiteDatabase) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, sQLiteDatabase) == null) {
                            sQLiteDatabase.execSQL(this.val$creatgroup);
                            long insert = sQLiteDatabase.insert("groupinfo", null, this.val$cv);
                            LogUtils.d(GroupInfoDAOImpl.TAG, "insertret : " + insert);
                        }
                    }
                }).intValue();
                LogUtils.d(TAG, "STAR create star group " + intValue + " " + str);
                if (intValue != 0 || (dBGroupTableManager = (DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)) == null) {
                    return intValue;
                }
                String groupMessageTableName = DBTableDefine.getGroupMessageTableName(str);
                LogUtils.d(TAG, "STAR add group table " + groupMessageTableName);
                dBGroupTableManager.addGroupTable(groupMessageTableName);
                return intValue;
            }
            return DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeLL.intValue;
    }

    public static int delAllGroupMember(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return DBResponseCode.ERROR_PARAMETER;
            }
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            return newDb != null ? newDb.delete("groupmember", "group_id = ?", new String[]{str}).intValue() : DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeLL.intValue;
    }

    public static int delGroupMember(Context context, String str, ArrayList<String> arrayList) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, context, str, arrayList)) == null) {
            if (context == null || arrayList == null || arrayList.size() == 0) {
                return DBResponseCode.ERROR_PARAMETER;
            }
            LogUtils.d("GroupInfoDAOIMPL", "delGroupMember " + arrayList.toString());
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                String str2 = " ( " + arrayList.get(0);
                for (int i2 = 1; i2 < arrayList.size(); i2++) {
                    str2 = str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + arrayList.get(i2);
                }
                return newDb.delete("groupmember", "group_id = ? AND bduid in " + (str2 + " ) "), new String[]{str}).intValue();
            }
            return DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeLLL.intValue;
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
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
                        return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor)) == null) ? cursor.getString(cursor.getColumnIndex("group_id")) : (String) invokeL2.objValue;
                    }
                }, "groupinfo", new String[]{"group_id"}, "state = 0 AND group_type != 2 AND state != 1", null, null, null, "create_time DESC", null);
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
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
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor)) == null) ? cursor.getString(cursor.getColumnIndex("group_id")) : (String) invokeL.objValue;
                    }
                }, "groupinfo", new String[]{"group_id"}, "state = 0 AND group_type = 3 AND local_groupinfo_version < " + j, null, null, null, "create_time DESC", null);
            }
            return null;
        }
        return (ArrayList) invokeLJ.objValue;
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
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
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor)) == null) ? cursor.getString(cursor.getColumnIndex("group_id")) : (String) invokeL.objValue;
                    }
                }, "groupinfo", new String[]{"group_id"}, "state = 0 AND group_type = 3 AND local_members_version < " + j + " AND " + DBTableDefine.GroupInfoColumns.COLUMN_USER_MEMBER_LOCAL_VERSION + " > 0 ", null, null, null, "create_time DESC", null);
            }
            return null;
        }
        return (ArrayList) invokeLJ.objValue;
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
            for (int i2 = 1; i2 < arrayList.size(); i2++) {
                str = str + StringUtil.ARRAY_ELEMENT_SEPARATOR + arrayList.get(i2);
            }
            String str2 = str + " ) ";
            return newDb.query(sGroupInfoParse, "groupinfo", null, "group_id in " + str2, null, null, null, null, null);
        }
        return (ArrayList) invokeLL.objValue;
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
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public static ArrayList<String> getGroupList(Context context, boolean z, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            String str = null;
            if (newDb != null) {
                String str2 = "active_state = 1";
                if (z) {
                    str2 = "active_state = 1 AND state = 0";
                }
                String str3 = str2 + " AND group_type != 2";
                if (i2 > 0) {
                    str = String.valueOf(i2);
                    if (i3 > 0) {
                        str = str + " offset " + i3;
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
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
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
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor)) == null) ? cursor.getString(cursor.getColumnIndex("group_id")) : (String) invokeL.objValue;
                    }
                }, "groupinfo", new String[]{"group_id"}, str3, null, null, null, "create_time DESC", str);
            }
            return null;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x008f, code lost:
        if (r15 == 0) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<GroupMember> getGroupMember(Context context, String str, ArrayList<String> arrayList, int i2) {
        InterceptResult invokeLLLI;
        ArrayList<GroupMember> arrayList2;
        String str2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65553, null, context, str, arrayList, i2)) == null) {
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
                    for (int i3 = 1; i3 < arrayList.size(); i3++) {
                        str6 = str6 + " OR bduid = " + arrayList.get(i3);
                    }
                    str2 = str6 + " ) ";
                }
                if (i2 < 0) {
                    str5 = "join_time DESC ";
                    str3 = String.valueOf(Math.abs(i2));
                } else {
                    if (i2 > 0) {
                        str3 = String.valueOf(i2);
                    } else {
                        str3 = null;
                    }
                    str4 = "join_time ASC  ";
                    arrayList2 = newDb.query(new IResultParse<GroupMember>() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
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
                                String string = cursor.getString(cursor.getColumnIndex("group_id"));
                                long j = cursor.getLong(cursor.getColumnIndex(DBTableDefine.GroupMemberColumns.COLUMN_JOIN_TIME));
                                int i4 = cursor.getInt(cursor.getColumnIndex("role"));
                                String string2 = cursor.getString(cursor.getColumnIndex("name"));
                                String string3 = cursor.getString(cursor.getColumnIndex("nickname"));
                                long j2 = cursor.getLong(cursor.getColumnIndex("bduid"));
                                long j3 = cursor.getLong(cursor.getColumnIndex("uk"));
                                int i5 = cursor.getInt(cursor.getColumnIndex("status"));
                                String string4 = cursor.getString(cursor.getColumnIndex("avatar"));
                                GroupMember groupMember2 = new GroupMember(string, j3, string2, j2, i4, j);
                                groupMember2.setValid(i5);
                                groupMember2.setNickName(string3);
                                groupMember2.setPortrait(string4);
                                return groupMember2;
                            }
                            return (GroupMember) invokeL.objValue;
                        }
                    }, "groupmember", null, "group_id = ? " + str2, new String[]{str}, null, null, str4, str3);
                }
                str4 = str5;
                arrayList2 = newDb.query(new IResultParse<GroupMember>() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
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
                            String string = cursor.getString(cursor.getColumnIndex("group_id"));
                            long j = cursor.getLong(cursor.getColumnIndex(DBTableDefine.GroupMemberColumns.COLUMN_JOIN_TIME));
                            int i4 = cursor.getInt(cursor.getColumnIndex("role"));
                            String string2 = cursor.getString(cursor.getColumnIndex("name"));
                            String string3 = cursor.getString(cursor.getColumnIndex("nickname"));
                            long j2 = cursor.getLong(cursor.getColumnIndex("bduid"));
                            long j3 = cursor.getLong(cursor.getColumnIndex("uk"));
                            int i5 = cursor.getInt(cursor.getColumnIndex("status"));
                            String string4 = cursor.getString(cursor.getColumnIndex("avatar"));
                            GroupMember groupMember2 = new GroupMember(string, j3, string2, j2, i4, j);
                            groupMember2.setValid(i5);
                            groupMember2.setNickName(string3);
                            groupMember2.setPortrait(string4);
                            return groupMember2;
                        }
                        return (GroupMember) invokeL.objValue;
                    }
                }, "groupmember", null, "group_id = ? " + str2, new String[]{str}, null, null, str4, str3);
            } else {
                arrayList2 = null;
            }
            if (arrayList2 != null) {
                int i4 = 0;
                while (true) {
                    if (i4 >= arrayList2.size()) {
                        break;
                    }
                    GroupMember groupMember2 = arrayList2.get(i4);
                    if (1 == groupMember2.getRole()) {
                        arrayList2.remove(i4);
                        groupMember = groupMember2;
                        break;
                    }
                    i4++;
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
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
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
            if (newDb != null) {
                return newDb.query(new IResultParse<Long>() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
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
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, cursor)) == null) ? Long.valueOf(cursor.getLong(cursor.getColumnIndex("bduid"))) : (Long) invokeL.objValue;
                    }
                }, "groupmember", new String[]{"bduid"}, "group_id = ? " + str2, new String[]{str}, null, null, null, null);
            }
            return null;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static ArrayList<GroupMember> getMemberNickname(Context context, String str) {
        InterceptResult invokeLL;
        DBOperation newDb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str) || (newDb = DBOperationFactory.getNewDb(context)) == null) {
                return null;
            }
            return newDb.query(new IResultParse<GroupMember>() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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
                        String string = cursor.getString(cursor.getColumnIndex("group_id"));
                        long j = cursor.getLong(cursor.getColumnIndex(DBTableDefine.GroupMemberColumns.COLUMN_JOIN_TIME));
                        int i2 = cursor.getInt(cursor.getColumnIndex("role"));
                        String string2 = cursor.getString(cursor.getColumnIndex("name"));
                        String string3 = cursor.getString(cursor.getColumnIndex("nickname"));
                        long j2 = cursor.getLong(cursor.getColumnIndex("bduid"));
                        long j3 = cursor.getLong(cursor.getColumnIndex("uk"));
                        int i3 = cursor.getInt(cursor.getColumnIndex("status"));
                        String string4 = cursor.getString(cursor.getColumnIndex("avatar"));
                        GroupMember groupMember = new GroupMember(string, j3, string2, j2, i2, j);
                        groupMember.setValid(i3);
                        groupMember.setNickName(string3);
                        groupMember.setPortrait(string4);
                        return groupMember;
                    }
                    return (GroupMember) invokeL.objValue;
                }
            }, "groupmember", null, "group_id = ? ", new String[]{str}, null, null, null, null);
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static String getNickName(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65557, null, context, str, str2)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                DBOperation newDb = DBOperationFactory.getNewDb(context);
                ArrayList query = newDb != null ? newDb.query(new IResultParse<String>() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
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
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor)) == null) ? cursor.getString(cursor.getColumnIndex("nickname")) : (String) invokeL.objValue;
                    }
                }, "groupmember", new String[]{"nickname"}, "group_id = ?  AND bduid = ? ", new String[]{str, str2}, null, null, null, null) : null;
                if (query != null && query.size() > 0) {
                    return (String) query.get(0);
                }
            }
            return null;
        }
        return (String) invokeLLL.objValue;
    }

    public static ArrayList<String> getStarGroupList(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) {
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
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
                        return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor)) == null) ? cursor.getString(cursor.getColumnIndex("group_id")) : (String) invokeL2.objValue;
                    }
                }, "groupinfo", new String[]{"group_id"}, "group_type != 3", null, null, null, "create_time DESC", null);
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static int hasMemberInGroup(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                DBOperation newDb = DBOperationFactory.getNewDb(context);
                ArrayList query = newDb != null ? newDb.query(new IResultParse<Long>() { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
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
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, cursor)) == null) ? Long.valueOf(cursor.getLong(cursor.getColumnIndex("bduid"))) : (Long) invokeL.objValue;
                    }
                }, "groupmember", new String[]{"bduid"}, "group_id = ? ", new String[]{str}, null, null, null, null) : null;
                if (query != null) {
                    return query.size();
                }
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public static boolean isExistGroup(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, context, str)) == null) {
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

    public static int modifyGroupInfoVersion(Context context, String str, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65561, null, new Object[]{context, str, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (context == null || TextUtils.isEmpty(str) || j < 0) {
                return DBResponseCode.ERROR_PARAMETER;
            }
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_INFO_VERSION, Long.valueOf(j));
                contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_INFO_LOCAL_VERSION, Long.valueOf(j2));
                return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
            }
            return DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeCommon.intValue;
    }

    public static int modifyGroupMemberNumber(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65562, null, context, str, i2)) == null) {
            if (context == null || TextUtils.isEmpty(str) || i2 < 0) {
                return DBResponseCode.ERROR_PARAMETER;
            }
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_USER_NUM, Integer.valueOf(i2));
                return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
            }
            return DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeLLI.intValue;
    }

    public static int modifyGroupMemberVersion(Context context, String str, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65563, null, new Object[]{context, str, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (context == null || TextUtils.isEmpty(str) || j < 0) {
                return DBResponseCode.ERROR_PARAMETER;
            }
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_USER_MEMBER_VERSION, Long.valueOf(j));
                contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_USER_MEMBER_LOCAL_VERSION, Long.valueOf(j2));
                return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
            }
            return DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeCommon.intValue;
    }

    public static int modifyGroupName(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65564, null, context, str, str2)) == null) {
            if (context == null || TextUtils.isEmpty(str) || str2 == null) {
                return DBResponseCode.ERROR_PARAMETER;
            }
            ConversationManagerImpl.getInstance(context).updateConversationName(str2, 1, String.valueOf(str));
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("group_name", str2);
                return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
            }
            return DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeLLL.intValue;
    }

    public static int quitGroup(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return DBResponseCode.ERROR_PARAMETER;
            }
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            int i2 = DBResponseCode.ERROR_DB_OPEN;
            if (newDb != null) {
                i2 = newDb.execTransaction(new ITransaction(str) { // from class: com.baidu.android.imsdk.group.db.GroupInfoDAOImpl.12
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
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
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
            return i2;
        }
        return invokeLL.intValue;
    }

    public static int setAllStarDisturbDefault(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            if (context == null) {
                return DBResponseCode.ERROR_PARAMETER;
            }
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("disturb", (Integer) 1);
                return newDb.update("groupinfo", contentValues, "group_type = ? ", new String[]{"2"}).intValue();
            }
            return DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeL.intValue;
    }

    public static int setGroupDisturb(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65567, null, context, str, i2)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return DBResponseCode.ERROR_PARAMETER;
            }
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("disturb", Integer.valueOf(i2));
                    return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
                }
                return DBResponseCode.ERROR_GROUP_NOT_EXIST;
            }
            return DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeLLI.intValue;
    }

    public static int setGroupPermit(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65568, null, context, str, i2)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return DBResponseCode.ERROR_PARAMETER;
            }
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF, Integer.valueOf(i2));
                    return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
                }
                return DBResponseCode.ERROR_GROUP_NOT_EXIST;
            }
            return DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeLLI.intValue;
    }

    public static int setGroupState(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65569, null, context, str, i2)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return DBResponseCode.ERROR_PARAMETER;
            }
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("state", Integer.valueOf(i2));
                    return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
                }
                return DBResponseCode.ERROR_GROUP_NOT_EXIST;
            }
            return DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeLLI.intValue;
    }

    public static int setGroupType(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65570, null, context, str, i2)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return DBResponseCode.ERROR_PARAMETER;
            }
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("group_type", Integer.valueOf(i2));
                    return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{str}).intValue();
                }
                return DBResponseCode.ERROR_GROUP_NOT_EXIST;
            }
            return DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeLLI.intValue;
    }

    public static int updateGroupInfo(Context context, GroupInfo groupInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65571, null, context, groupInfo)) == null) {
            if (context == null || groupInfo == null) {
                return DBResponseCode.ERROR_PARAMETER;
            }
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                return (!((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, groupInfo.getGroupId()) ? createGroup(context, groupInfo.getGroupId()) : 0) >= 0 ? newDb.update("groupinfo", getGroupInfoCv(groupInfo), "group_id = ? ", new String[]{groupInfo.getGroupId()}).intValue() : DBResponseCode.ERROR_DB_OPEN;
            }
            return DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeLL.intValue;
    }

    public static int updateGroupInfoMarkTop(Context context, long j, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65572, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            if (context == null) {
                return DBResponseCode.ERROR_PARAMETER;
            }
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, String.valueOf(j))) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("marktop", Integer.valueOf(i2));
                    contentValues.put("marktoptime", Long.valueOf(j2));
                    return newDb.update("groupinfo", contentValues, "group_id = ? ", new String[]{String.valueOf(j)}).intValue();
                }
                return DBResponseCode.ERROR_GROUP_NOT_EXIST;
            }
            return DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeCommon.intValue;
    }

    public static void updateGroupListMarkTop(Context context, List<ChatSession> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65573, null, context, list) == null) {
            clearGroupMarkTop(context);
            if (list != null) {
                for (ChatSession chatSession : list) {
                    updateGroupMarkTop(context, chatSession.getContacter(), chatSession.getMarkTop(), chatSession.getMarkTopTime());
                }
            }
        }
    }

    public static void updateGroupMarkTop(Context context, long j, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65574, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            updateGroupInfoMarkTop(context, j, i2, j2);
            ContentValues contentValues = new ContentValues();
            contentValues.put("marktop", Integer.valueOf(i2));
            contentValues.put("marktoptime", Long.valueOf(j2));
            ChatMessageDBManager.getInstance(context).updateChatSession("contacter=?", new String[]{String.valueOf(j)}, contentValues);
        }
    }

    public static int updateGroupMemberRole(Context context, String str, String str2, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65575, null, context, str, str2, i2)) == null) {
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("role", Integer.valueOf(i2));
                return newDb.update("groupmember", contentValues, "group_id = ? AND bduid = ? ", new String[]{str, str2}).intValue();
            }
            return DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeLLLI.intValue;
    }

    public static int updateMasterAsCommon(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65576, null, context, str, i2)) == null) {
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("role", Integer.valueOf(i2));
                return newDb.update("groupmember", contentValues, "group_id = ? AND role = 2 ", new String[]{str}).intValue();
            }
            return DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeLLI.intValue;
    }

    public static int updateMemberNickName(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65577, null, context, str, str2, str3)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return DBResponseCode.ERROR_PARAMETER;
            }
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("nickname", str3);
                return newDb.update("groupmember", contentValues, "group_id = ? AND bduid = ?", new String[]{str, str2}).intValue();
            }
            return DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeLLLL.intValue;
    }

    public static int updateMemberToGroup(Context context, String str, GroupMember groupMember) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65578, null, context, str, groupMember)) == null) {
            if (context == null || TextUtils.isEmpty(str) || groupMember == null) {
                return DBResponseCode.ERROR_PARAMETER;
            }
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            return newDb != null ? ((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str) ? newDb.update(DBTableDefine.getGroupMessageTableName(str), getGroupMemberCv(groupMember), "group_id = ? AND bduid = ?", new String[]{groupMember.getGroupid(), String.valueOf(groupMember.getBduid())}).intValue() : DBResponseCode.ERROR_GROUP_NOT_EXIST : DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeLLL.intValue;
    }
}
