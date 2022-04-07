package com.baidu.android.imsdk.group.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsgFactory;
import com.baidu.android.imsdk.chatmessage.messages.FansGroupAtMsg;
import com.baidu.android.imsdk.db.DBGroupTableManager;
import com.baidu.android.imsdk.db.DBOperation;
import com.baidu.android.imsdk.db.DBOperationFactory;
import com.baidu.android.imsdk.db.DBResponseCode;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.db.IResultParse;
import com.baidu.android.imsdk.db.ITransaction;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class GroupMessageDAOImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "GroupMessageDAOImpl";
    public static ChatMsgParse sGroupChatMsgParse;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.imsdk.group.db.GroupMessageDAOImpl$4  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$android$imsdk$group$db$GroupMessageDAOImpl$MSGTYPEEXPLAN;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(798224923, "Lcom/baidu/android/imsdk/group/db/GroupMessageDAOImpl$4;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(798224923, "Lcom/baidu/android/imsdk/group/db/GroupMessageDAOImpl$4;");
                    return;
                }
            }
            int[] iArr = new int[MSGTYPEEXPLAN.values().length];
            $SwitchMap$com$baidu$android$imsdk$group$db$GroupMessageDAOImpl$MSGTYPEEXPLAN = iArr;
            try {
                iArr[MSGTYPEEXPLAN.UNEQUAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$android$imsdk$group$db$GroupMessageDAOImpl$MSGTYPEEXPLAN[MSGTYPEEXPLAN.EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ChatMsgParse implements IResultParse<ChatMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context mContext;

        public void setContext(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
                this.mContext = context;
            }
        }

        public ChatMsgParse() {
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
        public ChatMsg onParse(Cursor cursor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cursor)) == null) {
                if (cursor == null) {
                    return null;
                }
                return GroupMessageDAOImpl.construGroupChatMsg(this.mContext, cursor);
            }
            return (ChatMsg) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class GroupChatMsgParse implements IResultParse<ChatMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context mContext;

        public GroupChatMsgParse(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mContext = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.android.imsdk.db.IResultParse
        public ChatMsg onParse(Cursor cursor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cursor)) == null) {
                if (cursor == null) {
                    return null;
                }
                return GroupMessageDAOImpl.construGroupChatMsg(this.mContext, cursor);
            }
            return (ChatMsg) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class LocalChatMsgParse implements IResultParse<ChatMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context mContext;

        public LocalChatMsgParse(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mContext = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.android.imsdk.db.IResultParse
        public ChatMsg onParse(Cursor cursor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cursor)) == null) {
                if (cursor == null) {
                    return null;
                }
                return GroupMessageDAOImpl.construGroupChatMsg(this.mContext, cursor);
            }
            return (ChatMsg) invokeL.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class MSGTYPEEXPLAN {
        public static final /* synthetic */ MSGTYPEEXPLAN[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final MSGTYPEEXPLAN EQUAL;
        public static final MSGTYPEEXPLAN UNEQUAL;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-156573576, "Lcom/baidu/android/imsdk/group/db/GroupMessageDAOImpl$MSGTYPEEXPLAN;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-156573576, "Lcom/baidu/android/imsdk/group/db/GroupMessageDAOImpl$MSGTYPEEXPLAN;");
                    return;
                }
            }
            EQUAL = new MSGTYPEEXPLAN("EQUAL", 0);
            MSGTYPEEXPLAN msgtypeexplan = new MSGTYPEEXPLAN("UNEQUAL", 1);
            UNEQUAL = msgtypeexplan;
            $VALUES = new MSGTYPEEXPLAN[]{EQUAL, msgtypeexplan};
        }

        public MSGTYPEEXPLAN(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static MSGTYPEEXPLAN valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (MSGTYPEEXPLAN) Enum.valueOf(MSGTYPEEXPLAN.class, str) : (MSGTYPEEXPLAN) invokeL.objValue;
        }

        public static MSGTYPEEXPLAN[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (MSGTYPEEXPLAN[]) $VALUES.clone() : (MSGTYPEEXPLAN[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class MessageType {
        public static final /* synthetic */ MessageType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final MessageType DRAFT2SENDING;
        public static final MessageType SENDING2FAIL;
        public static final MessageType SENDING2SUCCESS;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-726914258, "Lcom/baidu/android/imsdk/group/db/GroupMessageDAOImpl$MessageType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-726914258, "Lcom/baidu/android/imsdk/group/db/GroupMessageDAOImpl$MessageType;");
                    return;
                }
            }
            DRAFT2SENDING = new MessageType("DRAFT2SENDING", 0);
            SENDING2FAIL = new MessageType("SENDING2FAIL", 1);
            MessageType messageType = new MessageType("SENDING2SUCCESS", 2);
            SENDING2SUCCESS = messageType;
            $VALUES = new MessageType[]{DRAFT2SENDING, SENDING2FAIL, messageType};
        }

        public MessageType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static MessageType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (MessageType) Enum.valueOf(MessageType.class, str) : (MessageType) invokeL.objValue;
        }

        public static MessageType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (MessageType[]) $VALUES.clone() : (MessageType[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1761722539, "Lcom/baidu/android/imsdk/group/db/GroupMessageDAOImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1761722539, "Lcom/baidu/android/imsdk/group/db/GroupMessageDAOImpl;");
                return;
            }
        }
        sGroupChatMsgParse = new ChatMsgParse();
    }

    public GroupMessageDAOImpl() {
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

    public static ArrayList<Long> addChatMsg(Context context, String str, ArrayList<ChatMsg> arrayList) {
        InterceptResult invokeLLL;
        ContentValues constructionGroupMessageContentValues;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, arrayList)) == null) {
            ArrayList<Long> arrayList2 = new ArrayList<>();
            if (context != null && arrayList != null && arrayList.size() > 0) {
                DBOperation newDb = DBOperationFactory.getNewDb(context);
                if (newDb != null) {
                    if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str)) {
                        ArrayList arrayList3 = new ArrayList();
                        Iterator<ChatMsg> it = arrayList.iterator();
                        while (it.hasNext()) {
                            ChatMsg next = it.next();
                            if (next.getMsgType() != 1012 && next.getMsgType() != 1014 && (constructionGroupMessageContentValues = constructionGroupMessageContentValues(next)) != null) {
                                arrayList3.add(constructionGroupMessageContentValues);
                            }
                        }
                        List<Long> insert = newDb.insert(DBTableDefine.getGroupMessageTableName(str), arrayList3);
                        if (insert != null && insert.size() > 0) {
                            return (ArrayList) insert;
                        }
                        arrayList2.add(-7100L);
                        return arrayList2;
                    }
                    arrayList2.add(-7008L);
                    return arrayList2;
                }
                arrayList2.add(-70003L);
                return arrayList2;
            }
            arrayList2.add(-7001L);
            return arrayList2;
        }
        return (ArrayList) invokeLLL.objValue;
    }

    public static long addLocalChatMsg(Context context, ChatMsg chatMsg, String str) {
        InterceptResult invokeLLL;
        int createGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, chatMsg, str)) == null) {
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb == null) {
                LogUtils.e(TAG, " operation is null");
                return -70003L;
            } else if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str) || (createGroup = GroupInfoDAOImpl.createGroup(context, str)) >= 0) {
                long longValue = newDb.insert(DBTableDefine.DB_TABLE_GROUP_LOCALMESSAGE, constructionGroupMessageContentValues(chatMsg)).longValue();
                chatMsg.setRowId(longValue);
                return longValue;
            } else {
                return createGroup;
            }
        }
        return invokeLLL.longValue;
    }

    public static long addSingleChatMsg(Context context, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, chatMsg)) == null) {
            if (chatMsg != null && context != null) {
                if (1 != chatMsg.getCategory()) {
                    LogUtils.e(TAG, "The msg is not group msg!");
                    return -7001L;
                }
                String contacterId = chatMsg.getContacterId();
                if (TextUtils.isEmpty(contacterId)) {
                    LogUtils.e(TAG, "groupid should not be null or \"\"!");
                    return -7001L;
                }
                int status = chatMsg.getStatus();
                if (status != 0) {
                    if (status == 1 || status == 2 || status == 3) {
                        return addLocalChatMsg(context, chatMsg, contacterId);
                    }
                    return -1L;
                }
                return addSuccessChatMsg(context, chatMsg, contacterId);
            }
            LogUtils.e(TAG, "parameter should not be null!");
            return -7001L;
        }
        return invokeLL.longValue;
    }

    public static long addSuccessChatMsg(Context context, ChatMsg chatMsg, String str) {
        InterceptResult invokeLLL;
        int createGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, context, chatMsg, str)) == null) {
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb == null) {
                LogUtils.e(TAG, " operation is null");
                return -70003L;
            } else if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str) || (createGroup = GroupInfoDAOImpl.createGroup(context, str)) >= 0) {
                long longValue = newDb.insert(DBTableDefine.getGroupMessageTableName(str), constructionGroupMessageContentValues(chatMsg)).longValue();
                chatMsg.setRowId(longValue);
                return longValue;
            } else {
                return createGroup;
            }
        }
        return invokeLLL.longValue;
    }

    public static ChatMsg construGroupChatMsg(Context context, Cursor cursor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, cursor)) == null) {
            int i = cursor.getInt(cursor.getColumnIndex("_id"));
            int i2 = cursor.getInt(cursor.getColumnIndex("type"));
            long j = cursor.getLong(cursor.getColumnIndex(DBTableDefine.GroupMessageColumns.COLUMN_FROM_USER));
            long j2 = cursor.getLong(cursor.getColumnIndex("msgid"));
            long j3 = cursor.getLong(cursor.getColumnIndex("time"));
            int i3 = cursor.getInt(cursor.getColumnIndex("is_read"));
            int i4 = cursor.getInt(cursor.getColumnIndex("status"));
            String string = cursor.getString(cursor.getColumnIndex("content"));
            long j4 = cursor.getLong(cursor.getColumnIndex("groupid"));
            int i5 = cursor.getInt(cursor.getColumnIndex("cmd"));
            String string2 = cursor.getString(cursor.getColumnIndex("local_url"));
            boolean z = cursor.getInt(cursor.getColumnIndex("isclicked")) == 1;
            int i6 = cursor.getInt(cursor.getColumnIndex("device_flag"));
            String string3 = cursor.getString(cursor.getColumnIndex("sendid"));
            String string4 = cursor.getString(cursor.getColumnIndex(DBTableDefine.GroupMessageColumns.COLUMN_FROM_BUID));
            ChatMsg newChatMsg = ChatMsgFactory.getInstance().newChatMsg(context, 1, i2, i5);
            if (newChatMsg == null) {
                return null;
            }
            newChatMsg.setCategory(1);
            newChatMsg.setContacter(j4);
            newChatMsg.setFromUser(j);
            newChatMsg.setMsgContent(string);
            newChatMsg.setRowId(i);
            newChatMsg.setMsgId(j2);
            newChatMsg.setMsgTime(j3);
            newChatMsg.setMsgReaded(i3);
            newChatMsg.setStatus(i4);
            newChatMsg.setNotifyCmd(i5);
            newChatMsg.setLocalUrl(string2);
            newChatMsg.setIsZhida(false);
            newChatMsg.setIsClicked(z);
            newChatMsg.setPaid(-1L);
            newChatMsg.setMsgType(i2);
            newChatMsg.setDeviceFlag(i6);
            newChatMsg.setSendMsgId(string3);
            newChatMsg.setSenderUid(string4);
            return newChatMsg;
        }
        return (ChatMsg) invokeLL.objValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v19, types: [int] */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    public static ContentValues constructionGroupMessageContentValues(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, chatMsg)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("groupid", Long.valueOf(chatMsg.getContacter()));
            contentValues.put(DBTableDefine.GroupMessageColumns.COLUMN_FROM_USER, Long.valueOf(chatMsg.getFromUser()));
            contentValues.put(DBTableDefine.GroupMessageColumns.COLUMN_FROM_BUID, chatMsg.getSenderUid());
            contentValues.put("msgid", Long.valueOf(chatMsg.getMsgId()));
            contentValues.put("sendid", chatMsg.getSendMsgId());
            contentValues.put("content", chatMsg.getMsgContent());
            contentValues.put("type", Integer.valueOf(chatMsg.getRealMsgType()));
            contentValues.put("time", Long.valueOf(chatMsg.getMsgTime()));
            contentValues.put("status", Integer.valueOf(chatMsg.getStatus()));
            boolean isMsgRead = chatMsg.isMsgRead();
            ?? r1 = isMsgRead;
            if (chatMsg.isStarMessage()) {
                r1 = isMsgRead;
                if (chatMsg.isNotifyMessage()) {
                    r1 = 1;
                }
            }
            contentValues.put("is_read", Integer.valueOf((int) r1));
            contentValues.put("cmd", Integer.valueOf(chatMsg.getNotifyCmd()));
            contentValues.put("local_url", chatMsg.getLocalUrl());
            contentValues.put("isclicked", Integer.valueOf(chatMsg.isClicked() ? 1 : 0));
            contentValues.put("device_flag", Integer.valueOf(chatMsg.getDeviceFlag()));
            contentValues.put("msg_key", chatMsg.getMsgKey());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public static int delMsgsOfCertainContacter(Context context, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{context, str, Long.valueOf(j)})) == null) {
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                if (-1 == j) {
                    return newDb.delete(DBTableDefine.getGroupMessageTableName(str), null, null).intValue();
                }
                return newDb.delete(DBTableDefine.getGroupMessageTableName(str), "msgid <= ? ", new String[]{String.valueOf(j)}).intValue();
            }
            return DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeCommon.intValue;
    }

    public static int deleteChatMsg(Context context, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, chatMsg)) == null) {
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            return newDb != null ? newDb.delete(DBTableDefine.getGroupMessageTableName(String.valueOf(chatMsg.getContacter())), "msgid = ? ", new String[]{String.valueOf(chatMsg.getMsgId())}).intValue() : DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeLL.intValue;
    }

    public static int deleteDraftMsg(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, str)) == null) {
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            return newDb != null ? newDb.delete(DBTableDefine.DB_TABLE_GROUP_LOCALMESSAGE, "groupid = ? AND status = ?", new String[]{str, String.valueOf(3)}).intValue() : DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeLL.intValue;
    }

    public static int deleteMsgs(Context context, String str, long[] jArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, null, context, str, jArr)) == null) {
            if (jArr == null || jArr.length <= 0) {
                return DBResponseCode.ERROR_PARAMETER;
            }
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                String str2 = " ( " + jArr[0];
                for (int i = 1; i < jArr.length; i++) {
                    str2 = str2 + "," + jArr[i];
                }
                String str3 = str2 + " )";
                return newDb.delete(DBTableDefine.getGroupMessageTableName(str), "msgid in " + str3, null).intValue();
            }
            return DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeLLL.intValue;
    }

    public static ArrayList<ChatMsg> fetchAllChatMsg(Context context, String str, ChatMsg chatMsg, long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{context, str, chatMsg, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            if (chatMsg != null) {
                return fetchChatMsgInteranl(context, str, 1, chatMsg.getMsgId(), j, chatMsg.getRowId(), z, null, MSGTYPEEXPLAN.EQUAL);
            }
            return fetchChatMsgInteranl(context, str, 1, Long.MAX_VALUE, -Math.abs(j), -1L, z, null, MSGTYPEEXPLAN.UNEQUAL);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public static ArrayList<ChatMsg> fetchChatMsgExceptGroupSystem(Context context, String str, ChatMsg chatMsg, long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{context, str, chatMsg, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            if (chatMsg != null) {
                return fetchChatMsgInteranl(context, str, 1, chatMsg.getMsgId(), j, chatMsg.getRowId(), z, getGroupSystemMessageType(), MSGTYPEEXPLAN.UNEQUAL);
            }
            return fetchChatMsgInteranl(context, str, 1, Long.MAX_VALUE, -Math.abs(j), -1L, z, getGroupSystemMessageType(), MSGTYPEEXPLAN.UNEQUAL);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public static ArrayList<ChatMsg> fetchChatMsgInteranl(Context context, String str, int i, long j, long j2, long j3, boolean z, long[] jArr, MSGTYPEEXPLAN msgtypeexplan) {
        InterceptResult invokeCommon;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{context, str, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z), jArr, msgtypeexplan})) == null) {
            String str4 = "msgid ASC , _id ASC";
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 < 0) {
                str2 = " < ? ";
                str4 = "msgid DESC , _id DESC";
            } else {
                str2 = 0 == j2 ? " = ? " : " > ? ";
            }
            String str5 = str4;
            String str6 = "msgid" + str2;
            String[] strArr = {String.valueOf(j)};
            if (jArr == null || jArr.length <= 0) {
                str3 = str6;
            } else {
                String str7 = AnonymousClass4.$SwitchMap$com$baidu$android$imsdk$group$db$GroupMessageDAOImpl$MSGTYPEEXPLAN[msgtypeexplan.ordinal()] != 1 ? " in " : " not in ";
                String str8 = " ( " + jArr[0];
                for (int i3 = 1; i3 < jArr.length; i3++) {
                    str8 = str8 + "," + jArr[i3];
                }
                str3 = str6 + " AND type" + str7 + (str8 + " )");
            }
            sGroupChatMsgParse.setContext(context);
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            ArrayList<ChatMsg> arrayList = null;
            if (newDb != null) {
                DBGroupTableManager dBGroupTableManager = (DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY);
                if (dBGroupTableManager != null && !dBGroupTableManager.isExistGroupTable(context, str)) {
                    return null;
                }
                arrayList = newDb.query(sGroupChatMsgParse, "(select * from " + DBTableDefine.getGroupMessageTableName(str) + " union all select * from " + DBTableDefine.DB_TABLE_GROUP_LOCALMESSAGE + " where groupid = " + str + " AND status != 3 )", null, str3, strArr, null, null, str5, String.valueOf(Math.abs(j2)));
                if (arrayList != null && arrayList.size() > 0) {
                    Iterator<ChatMsg> it = arrayList.iterator();
                    while (it.hasNext()) {
                        LogUtils.e(TAG, it.next().toString());
                    }
                    if ((z && i2 < 0) || (!z && i2 > 0)) {
                        Collections.reverse(arrayList);
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public static ArrayList<ChatMsg> fetchGroupSystemMsg(Context context, String str, ChatMsg chatMsg, long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{context, str, chatMsg, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            if (chatMsg != null) {
                return fetchChatMsgInteranl(context, str, 1, chatMsg.getMsgId(), j, chatMsg.getRowId(), z, getGroupSystemMessageType(), MSGTYPEEXPLAN.EQUAL);
            }
            return fetchChatMsgInteranl(context, str, 1, Long.MAX_VALUE, -Math.abs(j), -1L, z, getGroupSystemMessageType(), MSGTYPEEXPLAN.EQUAL);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public static ArrayList<ChatMsg> fetchLastChatMsg(Context context, String str, ChatMsg chatMsg, long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{context, str, chatMsg, Long.valueOf(j), Boolean.valueOf(z)})) == null) ? fetchChatMsgInteranl(context, str, 1, Long.MAX_VALUE, -Math.abs(j), -1L, z, getStarGroupSystemMessageType(), MSGTYPEEXPLAN.UNEQUAL) : (ArrayList) invokeCommon.objValue;
    }

    public static ChatMsg getDraftMsg(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, context, str)) == null) {
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                sGroupChatMsgParse.setContext(context);
                ArrayList query = newDb.query(sGroupChatMsgParse, DBTableDefine.DB_TABLE_GROUP_LOCALMESSAGE, null, "groupid = ? AND status = ?", new String[]{str, String.valueOf(3)}, null, null, null, null);
                if (query != null && query.size() > 0) {
                    return (ChatMsg) query.get(0);
                }
            }
            return null;
        }
        return (ChatMsg) invokeLL.objValue;
    }

    public static ArrayList<ChatMsg> getFansGroupAtUnread(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        DBOperation newDb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65556, null, context, str, str2)) == null) {
            if (context == null || TextUtils.isEmpty(str) || (newDb = DBOperationFactory.getNewDb(context)) == null || ((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)) == null) {
                return null;
            }
            sGroupChatMsgParse.setContext(context);
            ArrayList<ChatMsg> query = newDb.query(sGroupChatMsgParse, DBTableDefine.getGroupMessageTableName(str) + " where type = 40 AND is_read = 0", null, null, null, null, null, "time ASC , _id ASC", null);
            if (query != null && query.size() != 0) {
                FansGroupAtMsg fansGroupAtMsg = new FansGroupAtMsg();
                Iterator<ChatMsg> it = query.iterator();
                while (it.hasNext()) {
                    fansGroupAtMsg.setMsgContent(it.next().getJsonContent());
                    if (!fansGroupAtMsg.isGroupAtUserById(str2)) {
                        it.remove();
                    }
                    LogUtils.d(TAG, "msg: " + fansGroupAtMsg.toString());
                }
                LogUtils.d(TAG, "fansGroupAtUnread groupId: " + str + ", userId: " + str2 + ", size: " + query.size());
                return query;
            }
            LogUtils.d(TAG, "fansGroupAtUnread has no data, groupId: " + str + ", userId: " + str2);
            return null;
        }
        return (ArrayList) invokeLLL.objValue;
    }

    public static long[] getGroupSystemMessageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? new long[]{101, 1006, 1001, 1002, 1004, 1003, 1005, 1007, 1008, 1009, 1010, 1011, 2001, 2010, 1013, 1014} : (long[]) invokeV.objValue;
    }

    public static long getMaxMsgid(Context context, String str) {
        InterceptResult invokeLL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, context, str)) == null) {
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                DBGroupTableManager dBGroupTableManager = (DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY);
                if (dBGroupTableManager != null && !dBGroupTableManager.isExistGroupTable(context, str)) {
                    return 0L;
                }
                arrayList = newDb.query(new IResultParse<Long>() { // from class: com.baidu.android.imsdk.group.db.GroupMessageDAOImpl.2
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
                            return Long.valueOf(cursor != null ? cursor.getLong(cursor.getColumnIndex("msgid")) : -1L);
                        }
                        return (Long) invokeL.objValue;
                    }
                }, DBTableDefine.getGroupMessageTableName(str), new String[]{"msgid"}, null, null, null, null, "msgid DESC", String.valueOf(1));
            } else {
                arrayList = null;
            }
            if (arrayList == null || arrayList.size() <= 0) {
                return -1L;
            }
            return ((Long) arrayList.get(0)).longValue();
        }
        return invokeLL.longValue;
    }

    public static long[] getStarGroupSystemMessageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? new long[]{1001, 1002, 1004, 1003, 1005, 1007, 1008, 1009, 1010, 1011, 2010} : (long[]) invokeV.objValue;
    }

    public static int getUnReadCount(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return DBResponseCode.ERROR_PARAMETER;
            }
            String groupMessageTableName = DBTableDefine.getGroupMessageTableName(str);
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                if (((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isExistGroupTable(context, str)) {
                    ArrayList query = newDb.query(new IResultParse<Integer>() { // from class: com.baidu.android.imsdk.group.db.GroupMessageDAOImpl.1
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
                            return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, cursor)) == null) ? Integer.valueOf(cursor.getInt(0)) : (Integer) invokeL.objValue;
                        }
                    }, groupMessageTableName, new String[]{"count(*) "}, "is_read = ?", new String[]{String.valueOf(0)}, "is_read", null, null, null);
                    LogUtils.e(TAG, "rets " + query + ",groupid: " + str);
                    if (query == null || query.size() <= 0) {
                        return 0;
                    }
                    return ((Integer) query.get(0)).intValue();
                }
                return DBResponseCode.ERROR_GROUP_NOT_EXIST;
            }
            return DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeLL.intValue;
    }

    public static boolean isActiveGroup(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, context, str)) == null) {
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                return ((DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY)).isActive(context, str);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static int markMsgClicked(Context context, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, context, chatMsg)) == null) {
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            String valueOf = String.valueOf(chatMsg.getContacter());
            if (newDb != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("isclicked", (Integer) 1);
                i = newDb.update(DBTableDefine.getGroupMessageTableName(valueOf), contentValues, "msgid = ? ", new String[]{String.valueOf(chatMsg.getMsgId())}).intValue();
            } else {
                i = DBResponseCode.ERROR_DB_OPEN;
            }
            ArrayList<ChatMsg> fetchAllChatMsg = fetchAllChatMsg(context, valueOf, null, -1L, true);
            if (fetchAllChatMsg == null || fetchAllChatMsg.size() == 0) {
                return DBResponseCode.ERROR_DB_OPEN;
            }
            if (chatMsg.getMsgId() == fetchAllChatMsg.get(0).getMsgId()) {
                ChatMessageDBManager.getInstance(context).updateChatSession(chatMsg);
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public static int setAllMsgRead(Context context, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65563, null, new Object[]{context, str, Long.valueOf(j)})) == null) {
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                DBGroupTableManager dBGroupTableManager = (DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY);
                if (dBGroupTableManager == null || dBGroupTableManager.isExistGroupTable(context, str)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("is_read", (Integer) 1);
                    return newDb.update(DBTableDefine.getGroupMessageTableName(str), contentValues, "is_read = ? AND msgid <= ? ", new String[]{String.valueOf(0), String.valueOf(j)}).intValue();
                }
                return DBResponseCode.ERROR_GROUP_NOT_EXIST;
            }
            return DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeCommon.intValue;
    }

    public static int setMsgReaded(Context context, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65564, null, new Object[]{context, str, Long.valueOf(j)})) == null) {
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                DBGroupTableManager dBGroupTableManager = (DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY);
                if (dBGroupTableManager != null && !dBGroupTableManager.isExistGroupTable(context, str)) {
                    GroupInfoDAOImpl.createGroup(context, str);
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("is_read", (Integer) 1);
                return newDb.update(DBTableDefine.getGroupMessageTableName(str), contentValues, "msgid = ? ", new String[]{String.valueOf(j)}).intValue();
            }
            return DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeCommon.intValue;
    }

    public static int updateDraftMsg(Context context, String str, ChatMsg chatMsg) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65565, null, context, str, chatMsg)) == null) {
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            int intValue = newDb != null ? newDb.update(DBTableDefine.DB_TABLE_GROUP_LOCALMESSAGE, constructionGroupMessageContentValues(chatMsg), "groupid = ? AND status = ?", new String[]{str, String.valueOf(3)}).intValue() : DBResponseCode.ERROR_DB_OPEN;
            ChatMessageDBManager.getInstance(context).updateChatSession(chatMsg);
            return intValue;
        }
        return invokeLLL.intValue;
    }

    public static int updateMsgStatus(Context context, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, context, chatMsg)) == null) {
            if (context == null || chatMsg == null) {
                return DBResponseCode.ERROR_PARAMETER;
            }
            DBOperation newDb = DBOperationFactory.getNewDb(context);
            if (newDb != null) {
                if (chatMsg.getStatus() != 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("msgid", Long.valueOf(chatMsg.getMsgId()));
                    contentValues.put("status", Integer.valueOf(chatMsg.getStatus()));
                    contentValues.put("content", chatMsg.getJsonContent());
                    contentValues.put("time", Long.valueOf(chatMsg.getMsgTime()));
                    return newDb.update(DBTableDefine.DB_TABLE_GROUP_LOCALMESSAGE, contentValues, "_id = ? ", new String[]{String.valueOf(chatMsg.getRowId())}).intValue();
                }
                return newDb.execTransaction(new ITransaction(chatMsg, constructionGroupMessageContentValues(chatMsg), chatMsg.getRowId()) { // from class: com.baidu.android.imsdk.group.db.GroupMessageDAOImpl.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ContentValues val$cv;
                    public final /* synthetic */ long val$localmsgRowid;
                    public final /* synthetic */ ChatMsg val$msg;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {chatMsg, r7, Long.valueOf(r8)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$msg = chatMsg;
                        this.val$cv = r7;
                        this.val$localmsgRowid = r8;
                    }

                    @Override // com.baidu.android.imsdk.db.ITransaction
                    public void execTransaction(SQLiteDatabase sQLiteDatabase) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, sQLiteDatabase) == null) {
                            sQLiteDatabase.insert(DBTableDefine.getGroupMessageTableName(String.valueOf(this.val$msg.getContacter())), null, this.val$cv);
                            sQLiteDatabase.delete(DBTableDefine.DB_TABLE_GROUP_LOCALMESSAGE, "_id = ? ", new String[]{String.valueOf(this.val$localmsgRowid)});
                        }
                    }
                }).intValue();
            }
            return DBResponseCode.ERROR_DB_OPEN;
        }
        return invokeLL.intValue;
    }

    public static ArrayList<ChatMsg> fetchAllChatMsg(Context context, String str, ChatMsg chatMsg, long j, boolean z, long[] jArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{context, str, chatMsg, Long.valueOf(j), Boolean.valueOf(z), jArr})) == null) {
            if (chatMsg != null) {
                return fetchChatMsgInteranl(context, str, 1, chatMsg.getMsgId(), j, chatMsg.getRowId(), z, jArr, MSGTYPEEXPLAN.UNEQUAL);
            }
            return fetchChatMsgInteranl(context, str, 1, Long.MAX_VALUE, -Math.abs(j), -1L, z, jArr, MSGTYPEEXPLAN.UNEQUAL);
        }
        return (ArrayList) invokeCommon.objValue;
    }
}
