package com.baidu.android.imsdk.media.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.MediaChatMessageManager;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsgFactory;
import com.baidu.android.imsdk.chatmessage.messages.HtmlMsg;
import com.baidu.android.imsdk.chatmessage.messages.MsgRepliedData;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.db.ChatUserDBManager;
import com.baidu.android.imsdk.db.CursorParse;
import com.baidu.android.imsdk.db.CursorWrapper;
import com.baidu.android.imsdk.db.DBBase;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.group.db.GroupMessageDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.DataUtil;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.MsgUtility;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class MediaMessageDBManager extends DBBase implements IMessageDBOperation, IMediaSessionDBOperation {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MEDIA_DRAFT_MSG_INSERT_SQL = "REPLACE INTO media_draft_msg(category,contacter,type,content) VALUES(?, ?, ?, ?)";
    public static final String MEDIA_MSG_REPLACE_SQL = "REPLACE INTO media_message(msgid,from_user,category,contacter,type,content,time,is_read,status,local_url,msg_key,sendid,buid,tips_code,tips,contacter_uk,origin_pa,template_type) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String MEDIA_SESSION_INSERT_SQL = "INSERT INTO media_session(category,contacter,contacter_bduid,name,last_msg,last_msg_time,new_msg_sum,chat_type,icon_url,msg_state,paid,isclicked,classtype,classtitle,classavatar,classshow,marktoptime,marktop,nickname,v_portrait,certification,shield,shield_time,vip_id,last_msg_bduid,last_msg_name,sort_update_time,fetch_mode,is_stranger,disturb,last_msgid,business,imuk,remind_type,remind_msgid,remind_uid,remind_role_display_name,extra,highlight_desc,highlight_priority,last_msgid_from_me,highlight_data_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String MEDIA_SESSION_REPLACE_SQL = "REPLACE INTO media_session(category,contacter,contacter_bduid,name,last_msg,last_msg_time,new_msg_sum,chat_type,icon_url,msg_state,paid,isclicked,classtype,classtitle,classavatar,classshow,marktoptime,marktop,nickname,v_portrait,certification,shield,shield_time,vip_id,last_msg_bduid,last_msg_name,sort_update_time,fetch_mode,is_stranger,disturb,last_msgid,business,imuk,remind_type,remind_msgid,remind_uid,remind_role_display_name,extra,highlight_desc,highlight_priority,last_msgid_from_me,highlight_data_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String TAG = "MediaMessageDBManager";
    public static final List<Integer> UNUPDATE_SESSION_MSG_TYPES;
    @SuppressLint({"StaticFieldLeak"})
    public static MediaMessageDBManager mInstance;
    public transient /* synthetic */ FieldHolder $fh;

    private String getSessionQuerySql() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, this)) == null) ? "category = ? AND contacter = ? " : (String) invokeV.objValue;
    }

    /* loaded from: classes.dex */
    public class ChatSessionListParse implements CursorParse {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<ChatSession> sessions;
        public final /* synthetic */ MediaMessageDBManager this$0;

        public ChatSessionListParse(MediaMessageDBManager mediaMessageDBManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaMessageDBManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mediaMessageDBManager;
            this.sessions = new ArrayList();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.android.imsdk.db.CursorParse
        public List<ChatSession> getResult() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.sessions;
            }
            return (List) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.db.CursorParse
        public void parseCursor(Cursor cursor) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cursor) == null) && cursor != null) {
                while (cursor.moveToNext()) {
                    ChatSession parseMediaSession = this.this$0.parseMediaSession(cursor);
                    if (parseMediaSession != null) {
                        this.sessions.add(parseMediaSession);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class DraftMessageParse implements CursorParse {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ChatMsg draftMsg;
        public final /* synthetic */ MediaMessageDBManager this$0;

        public DraftMessageParse(MediaMessageDBManager mediaMessageDBManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaMessageDBManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mediaMessageDBManager;
            this.draftMsg = null;
        }

        @Override // com.baidu.android.imsdk.db.CursorParse
        public void parseCursor(Cursor cursor) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cursor) == null) && cursor != null && cursor.moveToNext()) {
                this.draftMsg = this.this$0.parseDraftMsg(cursor);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.android.imsdk.db.CursorParse
        public ChatMsg getResult() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.draftMsg;
            }
            return (ChatMsg) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class SingleChatMsgParse implements CursorParse {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ChatMsg msg;
        public final /* synthetic */ MediaMessageDBManager this$0;

        public SingleChatMsgParse(MediaMessageDBManager mediaMessageDBManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaMessageDBManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mediaMessageDBManager;
            this.msg = null;
        }

        @Override // com.baidu.android.imsdk.db.CursorParse
        public void parseCursor(Cursor cursor) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cursor) == null) && cursor != null && cursor.moveToNext()) {
                this.msg = this.this$0.parseMediaChatMsg(cursor);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.android.imsdk.db.CursorParse
        public ChatMsg getResult() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.msg;
            }
            return (ChatMsg) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class SingleChatSessionParse implements CursorParse {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ChatSession session;
        public final /* synthetic */ MediaMessageDBManager this$0;

        public SingleChatSessionParse(MediaMessageDBManager mediaMessageDBManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaMessageDBManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mediaMessageDBManager;
            this.session = null;
        }

        @Override // com.baidu.android.imsdk.db.CursorParse
        public void parseCursor(Cursor cursor) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cursor) == null) && cursor != null && cursor.moveToNext()) {
                this.session = this.this$0.parseMediaSession(cursor);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.android.imsdk.db.CursorParse
        public ChatSession getResult() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.session;
            }
            return (ChatSession) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1512142222, "Lcom/baidu/android/imsdk/media/db/MediaMessageDBManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1512142222, "Lcom/baidu/android/imsdk/media/db/MediaMessageDBManager;");
                return;
            }
        }
        UNUPDATE_SESSION_MSG_TYPES = Arrays.asList(2012, 2014, 2001, 36);
    }

    public MediaMessageDBManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setContext(context.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChatMsg parseDraftMsg(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, this, cursor)) == null) {
            if (cursor == null) {
                return null;
            }
            int i = CursorWrapper.getInt(cursor, "category");
            long j = CursorWrapper.getLong(cursor, "category");
            int i2 = CursorWrapper.getInt(cursor, "type");
            String string = CursorWrapper.getString(cursor, "content");
            ChatMsg newChatMsg = ChatMsgFactory.getInstance().newChatMsg(this.mContext, i, i2, -1);
            newChatMsg.setContacter(j);
            newChatMsg.setMsgContent(string);
            return newChatMsg;
        }
        return (ChatMsg) invokeL.objValue;
    }

    public long getChatRecordUnReadNum(ChatObject chatObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, chatObject)) == null) {
            if (1 == chatObject.getCategory()) {
                return GroupMessageDAOImpl.getUnReadCount(this.mContext, String.valueOf(chatObject.getContacter()));
            }
            ChatSession chatRecord = getChatRecord(chatObject.getCategory(), chatObject.getContacter());
            if (chatRecord == null) {
                return -1L;
            }
            return chatRecord.getNewMsgSum();
        }
        return invokeL.longValue;
    }

    public int markMsgClicked(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, chatMsg)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("isclicked", (Integer) 1);
            return updateChatMsgInternal(contentValues, "_id=?", new String[]{"" + chatMsg.getRowId()});
        }
        return invokeL.intValue;
    }

    public int updateStrangerFolderUnreadNum(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048625, this, i)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("new_msg_sum", Integer.valueOf(i));
            return updateChatRecordAndNotifyInternal(contentValues, "is_stranger = ? AND fetch_mode = ?", new String[]{String.valueOf(1), String.valueOf(1)}, 3, false);
        }
        return invokeI.intValue;
    }

    private int delChatMsgInternal(String str, String[] strArr) {
        InterceptResult invokeLL;
        int delete;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, str, strArr)) == null) {
            synchronized (DBBase.mSyncLock) {
                delete = delete(TableDefine.DB_TABLE_MEDIA_MESSAGE, str, strArr);
            }
            return delete;
        }
        return invokeLL.intValue;
    }

    private int delChatRecordInternal(String str, String[] strArr) {
        InterceptResult invokeLL;
        int delete;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, this, str, strArr)) == null) {
            synchronized (DBBase.mSyncLock) {
                delete = delete(TableDefine.DB_TABLE_MEDIA_SESSION, str, strArr);
            }
            return delete;
        }
        return invokeLL.intValue;
    }

    private int delDraftMsgInternal(String str, String[] strArr) {
        InterceptResult invokeLL;
        int delete;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, this, str, strArr)) == null) {
            synchronized (DBBase.mSyncLock) {
                delete = delete(TableDefine.DB_TABLE_MEDIA_DRAFT_MESSAGE, str, strArr);
            }
            return delete;
        }
        return invokeLL.intValue;
    }

    private ChatSession getChatRecordInternal(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, this, str, strArr)) == null) {
            SingleChatSessionParse singleChatSessionParse = new SingleChatSessionParse();
            synchronized (DBBase.mSyncLock) {
                query(TableDefine.DB_TABLE_MEDIA_SESSION, null, str, strArr, null, null, null, singleChatSessionParse);
            }
            return singleChatSessionParse.getResult();
        }
        return (ChatSession) invokeLL.objValue;
    }

    private void notifyDbChange(int i, ChatSession chatSession) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(65561, this, i, chatSession) != null) || chatSession == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(chatSession);
        super.notifyDbChange(1, i, arrayList, true);
    }

    @Override // com.baidu.android.imsdk.media.db.IMessageDBOperation
    public ChatMsg getChatMsg(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, strArr)) == null) {
            SingleChatMsgParse singleChatMsgParse = new SingleChatMsgParse();
            synchronized (DBBase.mSyncLock) {
                query(TableDefine.DB_TABLE_MEDIA_MESSAGE, null, str, strArr, null, null, null, singleChatMsgParse);
            }
            return singleChatMsgParse.getResult();
        }
        return (ChatMsg) invokeLL.objValue;
    }

    public long updateSessionList(List<ChatSession> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048620, this, list, i)) == null) {
            LogUtils.d(TAG, "updateSessionList");
            return updateSessionListInternal(list, i, false, 0, true);
        }
        return invokeLI.longValue;
    }

    private SQLiteStatement buildChatMsgStatement(SQLiteStatement sQLiteStatement, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, sQLiteStatement, chatMsg)) == null) {
            if (sQLiteStatement != null && chatMsg != null) {
                sQLiteStatement.bindLong(1, chatMsg.getMsgId());
                sQLiteStatement.bindLong(2, chatMsg.getFromUser());
                sQLiteStatement.bindLong(3, chatMsg.getCategory());
                sQLiteStatement.bindLong(4, chatMsg.getContacter());
                sQLiteStatement.bindLong(5, chatMsg.getMsgType());
                sQLiteStatement.bindString(6, Utility.getNonEmptyString(chatMsg.getMsgContent(), ""));
                sQLiteStatement.bindLong(7, chatMsg.getMsgTime());
                if (chatMsg.isMsgRead()) {
                    j = 1;
                } else {
                    j = 0;
                }
                sQLiteStatement.bindLong(8, j);
                sQLiteStatement.bindLong(9, chatMsg.getStatus());
                sQLiteStatement.bindString(10, Utility.getNonEmptyString(chatMsg.getLocalUrl(), ""));
                sQLiteStatement.bindString(11, Utility.getNonEmptyString(chatMsg.getMsgKey(), ""));
                sQLiteStatement.bindString(12, Utility.getNonEmptyString(chatMsg.getSendMsgId(), ""));
                sQLiteStatement.bindString(13, Utility.getNonEmptyString(chatMsg.getSenderUid(), ""));
                sQLiteStatement.bindLong(14, chatMsg.getTipsCode());
                sQLiteStatement.bindString(15, Utility.getNonEmptyString(chatMsg.getTips(), ""));
                sQLiteStatement.bindLong(16, chatMsg.getContacterUk());
                sQLiteStatement.bindString(17, chatMsg.getOriginPa());
                sQLiteStatement.bindLong(18, chatMsg.getTemplateType());
            }
            return sQLiteStatement;
        }
        return (SQLiteStatement) invokeLL.objValue;
    }

    private ChatSession buildPaChatSession(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            PaInfo queryPaInfo = PaInfoDBManager.getInstance(this.mContext).queryPaInfo(j);
            if (queryPaInfo == null) {
                return null;
            }
            ChatSession chatSession = new ChatSession(i, queryPaInfo.getPaId(), queryPaInfo.getBduid(), queryPaInfo.getNickName());
            chatSession.setPaid(j);
            chatSession.setDisturb(queryPaInfo.getDisturb());
            chatSession.setChatType(queryPaInfo.getSubtype());
            int businessType = queryPaInfo.getBusinessType();
            if (businessType <= 0) {
                businessType = Utility.getBusinessType(queryPaInfo.getSubtype(), queryPaInfo.getSubsetType());
            }
            chatSession.setBusinessType(businessType);
            int i2 = 0;
            chatSession.setMarkTop(0);
            chatSession.setIconUrl(queryPaInfo.getAvatar());
            chatSession.setShield(queryPaInfo.getShield());
            chatSession.setVipId(queryPaInfo.getVipId());
            chatSession.setVPortrait(queryPaInfo.getVPortrait());
            chatSession.setCertification(queryPaInfo.getIdentity());
            chatSession.setIsStranger(queryPaInfo.getSubscribe());
            chatSession.setClassType(Math.max(queryPaInfo.getClassType(), 0));
            chatSession.setClassShow(queryPaInfo.getClassshow());
            chatSession.setContacterImuk(queryPaInfo.getImUk());
            if (queryPaInfo.getHasIdentity() == 0 && queryPaInfo.getSubscribe() != 1 && queryPaInfo.getSubscribe() != 3) {
                i2 = 1;
            }
            chatSession.setIsStranger(i2);
            return chatSession;
        }
        return (ChatSession) invokeCommon.objValue;
    }

    private SQLiteStatement buildDraftMsgStatement(SQLiteStatement sQLiteStatement, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, sQLiteStatement, chatMsg)) == null) {
            if (sQLiteStatement != null && chatMsg != null) {
                sQLiteStatement.bindLong(1, chatMsg.getCategory());
                sQLiteStatement.bindLong(2, chatMsg.getContacter());
                sQLiteStatement.bindLong(3, chatMsg.getMsgType());
                sQLiteStatement.bindString(4, Utility.getNonEmptyString(chatMsg.getMsgContent(), ""));
            }
            return sQLiteStatement;
        }
        return (SQLiteStatement) invokeLL.objValue;
    }

    private void fillCursorDataToArray(List<ChatMsg> list, Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, this, list, cursor) == null) {
            if (list != null && cursor != null) {
                ChatMsg parseMediaChatMsg = parseMediaChatMsg(cursor);
                if (parseMediaChatMsg != null) {
                    LogUtils.d(TAG, "msgid : " + parseMediaChatMsg.getMsgId());
                    list.add(parseMediaChatMsg);
                    return;
                }
                LogUtils.d(TAG, "construChatMsg msg is null ");
                return;
            }
            LogUtils.d(TAG, "fillCursorDataToArray failed, list or cursor null");
        }
    }

    private String[] getSessionQueryArgs(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65559, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) ? new String[]{String.valueOf(i), String.valueOf(j)} : (String[]) invokeCommon.objValue;
    }

    private ChatMsg queryDraftMsgInternal(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65567, this, str, strArr)) == null) {
            DraftMessageParse draftMessageParse = new DraftMessageParse();
            synchronized (DBBase.mSyncLock) {
                query(TableDefine.DB_TABLE_MEDIA_DRAFT_MESSAGE, null, str, strArr, null, null, null, "1", draftMessageParse);
            }
            return draftMessageParse.getResult();
        }
        return (ChatMsg) invokeLL.objValue;
    }

    public int delChatRecord(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            String sessionQuerySql = getSessionQuerySql();
            String[] sessionQueryArgs = getSessionQueryArgs(i, j);
            ChatSession chatRecordInternal = getChatRecordInternal(sessionQuerySql, sessionQueryArgs);
            int delChatRecordInternal = delChatRecordInternal(sessionQuerySql, sessionQueryArgs);
            if (delChatRecordInternal > 0 && chatRecordInternal != null) {
                notifyDbChange(2, chatRecordInternal);
            }
            return delChatRecordInternal;
        }
        return invokeCommon.intValue;
    }

    @Override // com.baidu.android.imsdk.media.db.IMessageDBOperation
    public int deleteAllMsgs(ChatObject chatObject, int i) {
        InterceptResult invokeLI;
        int deleteAllMsgsWithoutNotify;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, chatObject, i)) == null) {
            synchronized (DBBase.mSyncLock) {
                if (i == 1) {
                    deleteAllMsgsWithoutNotify = deleteAllMsgsExcludeDraftWithoutNotify(chatObject);
                } else {
                    deleteAllMsgsWithoutNotify = deleteAllMsgsWithoutNotify(chatObject);
                }
                updateSession(true, getChatRecord(chatObject.getCategory(), chatObject.getContacter()), null, i);
            }
            return deleteAllMsgsWithoutNotify;
        }
        return invokeLI.intValue;
    }

    @Override // com.baidu.android.imsdk.media.db.IMediaSessionDBOperation
    public ChatSession getChatRecord(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return getChatRecordInternal(getSessionQuerySql(), getSessionQueryArgs(i, j));
        }
        return (ChatSession) invokeCommon.objValue;
    }

    public ChatMsg queryDraftMessage(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return queryDraftMsgInternal("category = ? AND contacter = ?", new String[]{String.valueOf(i), String.valueOf(j)});
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    private SQLiteStatement buildSessionStatement(SQLiteStatement sQLiteStatement, ChatSession chatSession, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, this, sQLiteStatement, chatSession, i)) == null) {
            if (sQLiteStatement != null && chatSession != null) {
                sQLiteStatement.bindLong(1, chatSession.getCategory());
                sQLiteStatement.bindLong(2, chatSession.getContacter());
                sQLiteStatement.bindLong(3, chatSession.getContacterId());
                sQLiteStatement.bindString(4, Utility.getNonEmptyString(chatSession.getName(), ""));
                sQLiteStatement.bindString(5, Utility.getNonEmptyString(chatSession.getLastMsg(), ""));
                sQLiteStatement.bindLong(6, chatSession.getLastMsgTime());
                sQLiteStatement.bindLong(7, chatSession.getNewMsgSum());
                sQLiteStatement.bindLong(8, chatSession.getChatType());
                sQLiteStatement.bindString(9, Utility.getNonEmptyString(chatSession.getIconUrl(), ""));
                sQLiteStatement.bindLong(10, chatSession.getState());
                sQLiteStatement.bindLong(11, chatSession.getPaid());
                sQLiteStatement.bindLong(12, chatSession.getIsClicked());
                sQLiteStatement.bindLong(13, chatSession.getClassType());
                sQLiteStatement.bindString(14, Utility.getNonEmptyString(chatSession.getClassTitle(), ""));
                sQLiteStatement.bindString(15, Utility.getNonEmptyString(chatSession.getClassAvatar(), ""));
                sQLiteStatement.bindLong(16, chatSession.getClassShow());
                sQLiteStatement.bindLong(17, chatSession.getMarkTopTime());
                sQLiteStatement.bindLong(18, chatSession.getMarkTop());
                sQLiteStatement.bindString(19, Utility.getNonEmptyString(chatSession.getNickName(), ""));
                sQLiteStatement.bindString(20, Utility.getNonEmptyString(chatSession.getVPortrait(), ""));
                sQLiteStatement.bindString(21, Utility.getNonEmptyString(chatSession.getCertification(), ""));
                sQLiteStatement.bindLong(22, chatSession.getShield());
                sQLiteStatement.bindLong(23, chatSession.getShieldTime());
                sQLiteStatement.bindString(24, Utility.getNonEmptyString(chatSession.getVipId(), ""));
                sQLiteStatement.bindLong(25, chatSession.getLastMsgUid());
                sQLiteStatement.bindString(26, Utility.getNonEmptyString(chatSession.getLastMsgName(), ""));
                sQLiteStatement.bindLong(27, chatSession.getSortTime());
                sQLiteStatement.bindLong(28, i);
                sQLiteStatement.bindLong(29, chatSession.getIsStranger());
                sQLiteStatement.bindLong(30, chatSession.getDisturb());
                sQLiteStatement.bindLong(31, chatSession.getLastMsgId());
                sQLiteStatement.bindLong(32, chatSession.getBusinessType());
                sQLiteStatement.bindLong(33, chatSession.getContacterImuk());
                sQLiteStatement.bindLong(34, chatSession.getRemindType());
                sQLiteStatement.bindLong(35, chatSession.getRemindMsgid());
                sQLiteStatement.bindLong(36, chatSession.getRemindUid());
                sQLiteStatement.bindString(37, Utility.getNonEmptyString(chatSession.getRemindRoleDisplayName(), ""));
                sQLiteStatement.bindString(38, Utility.getNonEmptyString(chatSession.getExt(), ""));
            }
            return sQLiteStatement;
        }
        return (SQLiteStatement) invokeLLI.objValue;
    }

    private ChatSession buildUserChatSession(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            ChatUser chatUser = ChatUserDBManager.getInstance(this.mContext).getChatUser(j);
            if (chatUser == null) {
                return null;
            }
            ChatSession chatSession = new ChatSession(i, j, chatUser.getBuid(), chatUser.getUserName());
            chatSession.setDisturb(chatUser.getDisturb());
            int i2 = 0;
            chatSession.setChatType(0);
            chatSession.setBusinessType(1);
            chatSession.setMarkTop(0);
            chatSession.setIconUrl(chatUser.getIconUrl());
            chatSession.setShield(chatUser.getShield());
            chatSession.setVipId(chatUser.getVipId());
            chatSession.setVPortrait(chatUser.getVPortrait());
            chatSession.setCertification(chatUser.getIdentity());
            chatSession.setClassType(0);
            chatSession.setContacterImuk(j);
            if (chatUser.getHasSpecialIdentity() == 0 && chatUser.getSubscribe() != 1 && chatUser.getSubscribe() != 3) {
                i2 = 1;
            }
            chatSession.setIsStranger(i2);
            return chatSession;
        }
        return (ChatSession) invokeCommon.objValue;
    }

    private ContentValues contructChatMsgValues(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, chatMsg)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("msgid", Long.valueOf(chatMsg.getMsgId()));
            contentValues.put("from_user", Long.valueOf(chatMsg.getFromUser()));
            contentValues.put("category", Integer.valueOf(chatMsg.getCategory()));
            contentValues.put("contacter", Long.valueOf(chatMsg.getContacter()));
            contentValues.put("type", Integer.valueOf(chatMsg.getMsgType()));
            contentValues.put("content", chatMsg.getMsgContent());
            contentValues.put("time", Long.valueOf(chatMsg.getMsgTime()));
            contentValues.put("is_read", Integer.valueOf(chatMsg.isMsgRead() ? 1 : 0));
            contentValues.put("status", Integer.valueOf(chatMsg.getStatus()));
            if (chatMsg instanceof HtmlMsg) {
                contentValues.put("local_url", chatMsg.getRecommendDescription());
            } else {
                contentValues.put("local_url", chatMsg.getLocalUrl());
            }
            contentValues.put("isclicked", Integer.valueOf(chatMsg.isClicked() ? 1 : 0));
            contentValues.put("msg_key", chatMsg.getMsgKey());
            contentValues.put("sendid", chatMsg.getSendMsgId());
            contentValues.put("buid", chatMsg.getSenderUid());
            contentValues.put("tips_code", Integer.valueOf(chatMsg.getTipsCode()));
            contentValues.put("tips", chatMsg.getTips());
            contentValues.put("contacter_uk", Long.valueOf(chatMsg.getContacterUk()));
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChatMsg parseMediaChatMsg(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, this, cursor)) == null) {
            if (cursor == null) {
                return null;
            }
            int i = CursorWrapper.getInt(cursor, "_id");
            long j = CursorWrapper.getLong(cursor, "msgid");
            int i2 = CursorWrapper.getInt(cursor, "auto_risk_control_status");
            long j2 = CursorWrapper.getLong(cursor, "from_user");
            int i3 = CursorWrapper.getInt(cursor, "category");
            long j3 = CursorWrapper.getLong(cursor, "contacter");
            int i4 = CursorWrapper.getInt(cursor, "type");
            String string = CursorWrapper.getString(cursor, "content");
            long j4 = CursorWrapper.getLong(cursor, "time");
            int i5 = CursorWrapper.getInt(cursor, "is_read");
            int i6 = CursorWrapper.getInt(cursor, "status");
            String string2 = CursorWrapper.getString(cursor, "local_url");
            boolean z = true;
            if (CursorWrapper.getInt(cursor, "isclicked") != 1) {
                z = false;
            }
            String string3 = CursorWrapper.getString(cursor, "msg_key");
            String string4 = CursorWrapper.getString(cursor, "sendid");
            String string5 = CursorWrapper.getString(cursor, "buid");
            int i7 = CursorWrapper.getInt(cursor, "tips_code");
            String string6 = CursorWrapper.getString(cursor, "tips");
            String string7 = CursorWrapper.getString(cursor, "origin_pa");
            int i8 = CursorWrapper.getInt(cursor, "template_type");
            boolean z2 = z;
            ChatMsg newChatMsg = ChatMsgFactory.getInstance().newChatMsg(this.mContext, i3, i4, -1);
            if (newChatMsg == null) {
                return null;
            }
            newChatMsg.setCategory(i3);
            newChatMsg.setContacter(j3);
            newChatMsg.setFromUser(j2);
            newChatMsg.setMsgContent(string);
            newChatMsg.setRowId(i);
            newChatMsg.setMsgId(j);
            newChatMsg.setAutoRiskControlStatus(i2);
            newChatMsg.setMsgTime(j4);
            newChatMsg.setMsgReaded(i5);
            newChatMsg.setStatus(i6);
            newChatMsg.setLocalUrl(string2);
            newChatMsg.setIsClicked(z2);
            newChatMsg.setMsgType(i4);
            newChatMsg.setSendMsgId(string4);
            newChatMsg.setSenderUid(string5);
            newChatMsg.setMsgKey(string3);
            newChatMsg.setTipsCode(i7);
            newChatMsg.setTips(string6);
            newChatMsg.setOriginPa(string7);
            newChatMsg.setTemplateType(i8);
            return newChatMsg;
        }
        return (ChatMsg) invokeL.objValue;
    }

    @Override // com.baidu.android.imsdk.media.db.IMessageDBOperation
    public long insertMsg(ChatMsg chatMsg) {
        int i;
        long insert;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, chatMsg)) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("msgid", Long.valueOf(chatMsg.getMsgId()));
                contentValues.put("auto_risk_control_status", Integer.valueOf(chatMsg.getAutoRiskControlStatus()));
                contentValues.put("from_user", Long.valueOf(chatMsg.getFromUser()));
                contentValues.put("category", Integer.valueOf(chatMsg.getCategory()));
                contentValues.put("contacter", Long.valueOf(chatMsg.getContacter()));
                contentValues.put("type", Integer.valueOf(chatMsg.getMsgType()));
                contentValues.put("content", chatMsg.getMsgContent());
                contentValues.put("time", Long.valueOf(chatMsg.getMsgTime()));
                int i2 = 1;
                if (chatMsg.isMsgRead()) {
                    i = 1;
                } else {
                    i = 0;
                }
                contentValues.put("is_read", Integer.valueOf(i));
                contentValues.put("status", Integer.valueOf(chatMsg.getStatus()));
                if (chatMsg instanceof HtmlMsg) {
                    contentValues.put("local_url", chatMsg.getRecommendDescription());
                } else {
                    contentValues.put("local_url", chatMsg.getLocalUrl());
                }
                if (!chatMsg.isClicked()) {
                    i2 = 0;
                }
                contentValues.put("isclicked", Integer.valueOf(i2));
                contentValues.put("msg_key", chatMsg.getMsgKey());
                contentValues.put("sendid", chatMsg.getSendMsgId());
                contentValues.put("buid", chatMsg.getSenderUid());
                contentValues.put("tips_code", Integer.valueOf(chatMsg.getTipsCode()));
                contentValues.put("tips", chatMsg.getTips());
                contentValues.put("contacter_uk", Long.valueOf(chatMsg.getContacterUk()));
                SQLiteDatabase openDatabase = openDatabase();
                synchronized (DBBase.mSyncLock) {
                    insert = openDatabase.insert(TableDefine.DB_TABLE_MEDIA_MESSAGE, null, contentValues);
                }
                return insert;
            } catch (Exception e) {
                LogUtils.e(TAG, "addMsg:", e);
                return -1L;
            }
        }
        return invokeL.longValue;
    }

    private long createChatSession(int i, long j, int i2) {
        InterceptResult invokeCommon;
        ChatSession buildPaChatSession;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)})) == null) {
            if (getInstance(this.mContext).getChatRecord(i, j) != null) {
                return 0L;
            }
            if (i2 == 0) {
                buildPaChatSession = buildUserChatSession(i, j);
            } else {
                buildPaChatSession = buildPaChatSession(i, j);
            }
            if (buildPaChatSession == null) {
                return 0L;
            }
            ChatMsg queryDraftMessage = queryDraftMessage(i, j);
            ChatObject chatObject = new ChatObject(this.mContext, i, j);
            if (queryDraftMessage == null) {
                ArrayList<ChatMsg> fetchMsgExcludeTypes = getInstance(this.mContext).fetchMsgExcludeTypes(chatObject, 0L, 1L, UNUPDATE_SESSION_MSG_TYPES);
                if (fetchMsgExcludeTypes == null) {
                    LogUtils.e(TAG, "updateChatRecordName fetchmsg error! ");
                    return -1L;
                } else if (fetchMsgExcludeTypes.size() == 0) {
                    LogUtils.e(TAG, "updateChatRecordName  msgs.size() = 0! ");
                    return 0L;
                } else {
                    queryDraftMessage = fetchMsgExcludeTypes.get(0);
                }
            }
            buildPaChatSession.setNewMsgSum(Math.max(getInstance(this.mContext).getUnReadMsgCount(chatObject), 0));
            String recommendDescription = queryDraftMessage.getRecommendDescription();
            buildPaChatSession.setLastMsgTime(queryDraftMessage.getMsgTime());
            buildPaChatSession.setLastMsg(recommendDescription);
            buildPaChatSession.setSortTime(queryDraftMessage.getMsgId());
            buildPaChatSession.setState(queryDraftMessage.getStatus());
            buildPaChatSession.setIsClicked(Utility.getClickState(queryDraftMessage));
            ArrayList arrayList = new ArrayList();
            arrayList.add(buildPaChatSession);
            int isStranger = buildPaChatSession.getIsStranger();
            int i3 = 1;
            if (isStranger == 1) {
                i3 = 2;
            }
            return updateSessionListWithNotify(arrayList, i3, 0);
        }
        return invokeCommon.longValue;
    }

    @Override // com.baidu.android.imsdk.media.db.IMessageDBOperation
    public int delMsgs(int i, long j, long[] jArr) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), jArr})) == null) {
            if (DataUtil.isArrayEmpty(jArr)) {
                return -1;
            }
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    LogUtils.d(TAG, "getWritableDb fail!");
                    return -1;
                }
                int i3 = 0;
                try {
                    String[] strArr = new String[2];
                    strArr[1] = String.valueOf(0);
                    openDatabase.beginTransaction();
                    int length = jArr.length;
                    int i4 = 0;
                    i2 = 0;
                    while (i4 < length) {
                        try {
                            strArr[0] = String.valueOf(jArr[i4]);
                            i2 = (int) (i2 + delChatMsgInternal("msgid = ? AND status=?", strArr));
                            i4++;
                            strArr = strArr;
                        } catch (Exception e) {
                            e = e;
                            i3 = i2;
                            LogUtils.e(TAG, "delMsg:", e);
                            if (openDatabase != null) {
                                openDatabase.endTransaction();
                            }
                            i2 = i3;
                            return i2;
                        }
                    }
                    for (long j2 : jArr) {
                        long j3 = j2 + 1;
                        delChatMsgInternal("msgid=? and type in (?, ?, ?)", new String[]{String.valueOf(j3), String.valueOf(2012), String.valueOf(2001), String.valueOf(2014)});
                        LogUtils.e(TAG, "delete notSendButShowTipMsg :msgid=? and type in (?, ?, ?), msgId :" + j3);
                    }
                    if (i2 > 0) {
                        ArrayList<ChatMsg> fetchMsgExcludeTypes = fetchMsgExcludeTypes(new ChatObject(this.mContext, i, j), 0L, 1L, UNUPDATE_SESSION_MSG_TYPES);
                        if (fetchMsgExcludeTypes != null && fetchMsgExcludeTypes.size() > 0) {
                            updateChatSession(fetchMsgExcludeTypes.get(0));
                        } else {
                            updateSessionAfterClearAllMsg(getChatRecord(i, j));
                        }
                    }
                    openDatabase.setTransactionSuccessful();
                    if (openDatabase != null) {
                        openDatabase.endTransaction();
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                return i2;
            }
        }
        return invokeCommon.intValue;
    }

    public void updateSessionByClassAndNotify(int i, int i2, ChatSession chatSession) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048619, this, i, i2, chatSession) == null) {
            synchronized (DBBase.mSyncLock) {
                if (getMediaChatSessionByClassType(i) == null) {
                    return;
                }
                ArrayList<ChatSession> chatRecordsByClass = ChatMessageDBManager.getInstance(this.mContext).getChatRecordsByClass(1L, Collections.singletonList(Integer.valueOf(i)));
                if (chatRecordsByClass != null && chatRecordsByClass.size() != 0) {
                    chatRecordsByClass.get(0).setSessionFrom(2);
                    chatRecordsByClass.get(0).setLastMsgName(chatRecordsByClass.get(0).getLastMsgName());
                    chatRecordsByClass.get(0).setNewMsgSum(ChatMessageDBManager.getInstance(this.mContext).getNewMsgCountOfClass(i));
                    long maxMsgid = ChatMessageDBManager.getInstance(this.mContext).getMaxMsgid(new ChatObject(this.mContext, 0, chatRecordsByClass.get(0).getPaid()));
                    chatRecordsByClass.get(0).setLastMsgId(maxMsgid);
                    chatRecordsByClass.get(0).setSortTime(maxMsgid);
                    PaInfo queryPaInfo = PaInfoDBManager.getInstance(this.mContext).queryPaInfo(chatRecordsByClass.get(0).getContacter());
                    if (queryPaInfo != null) {
                        chatRecordsByClass.get(0).setBusinessType(Utility.getBusinessType(queryPaInfo.getSubtype(), queryPaInfo.getSubsetType()));
                    }
                    updateSessionListWithNotify(chatRecordsByClass, 1, i2);
                    return;
                }
                if (BIMManager.hudongTop && chatSession.getClassType() == 11) {
                    if (chatRecordsByClass == null) {
                        chatRecordsByClass = new ArrayList<>();
                    }
                    chatRecordsByClass.add(chatSession);
                    updateSessionListWithNotify(chatRecordsByClass, 1, i2);
                    return;
                }
                delChatRecordByClassType(i);
            }
        }
    }

    private int delStrangerFolderSession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            LogUtils.d(TAG, "delStrangerFolderSession");
            int delChatRecordInternal = delChatRecordInternal("is_stranger = ? AND fetch_mode = ?", new String[]{String.valueOf(1), String.valueOf(1)});
            LogUtils.d(TAG, "delStrangerFolderSession ret = " + delChatRecordInternal);
            return delChatRecordInternal;
        }
        return invokeV.intValue;
    }

    public ChatSession getMediaStrangerFolderSession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            LogUtils.d(TAG, "getMediaStrangerFolderSession");
            ChatSession chatRecordInternal = getChatRecordInternal("is_stranger = ? AND fetch_mode = ?", new String[]{String.valueOf(1), String.valueOf(1)});
            LogUtils.d(TAG, "getMediaChatSession session = " + chatRecordInternal);
            return chatRecordInternal;
        }
        return (ChatSession) invokeV.objValue;
    }

    private int deleteAllMsgsExcludeDraftWithoutNotify(ChatObject chatObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, chatObject)) == null) {
            return delChatMsgInternal("category = ? AND contacter = ? ", new String[]{String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter())});
        }
        return invokeL.intValue;
    }

    public static MediaMessageDBManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) {
            if (mInstance == null) {
                synchronized (MediaMessageDBManager.class) {
                    if (mInstance == null) {
                        mInstance = new MediaMessageDBManager(context);
                    }
                }
            }
            return mInstance;
        }
        return (MediaMessageDBManager) invokeL.objValue;
    }

    public int delChatRecordByClassType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            String[] strArr = {String.valueOf(i)};
            ChatSession chatRecordInternal = getChatRecordInternal("classtype = ?", strArr);
            int delChatRecordInternal = delChatRecordInternal("classtype = ?", strArr);
            if (delChatRecordInternal > 0 && chatRecordInternal != null) {
                notifyDbChange(2, chatRecordInternal);
            }
            return delChatRecordInternal;
        }
        return invokeI.intValue;
    }

    public ChatSession getMediaChatSessionByClassType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            return getChatRecordInternal("classtype = ? ", new String[]{String.valueOf(i)});
        }
        return (ChatSession) invokeI.objValue;
    }

    public long saveChatMsg(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, chatMsg)) == null) {
            synchronized (DBBase.mSyncLock) {
                long insertMsg = insertMsg(chatMsg);
                if (insertMsg < 0) {
                    return insertMsg;
                }
                chatMsg.setRowId(insertMsg);
                updateChatSession(chatMsg);
                return insertMsg;
            }
        }
        return invokeL.longValue;
    }

    public void updateSessionAfterClearAllMsg(ChatObject chatObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, chatObject) == null) {
            updateSessionAfterClearAllMsg(getChatRecord(chatObject.getCategory(), chatObject.getContacter()));
        }
    }

    private int deleteAllMsgsWithoutNotify(ChatObject chatObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, chatObject)) == null) {
            int delChatMsgInternal = delChatMsgInternal("category = ? AND contacter = ? ", new String[]{String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter())});
            delDraftMsgInternal("category = ? AND contacter = ?", new String[]{String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter())});
            return delChatMsgInternal;
        }
        return invokeL.intValue;
    }

    private List<ChatSession> getMediaSessionListWithTop(long j, long j2, int i, int i2) {
        InterceptResult invokeCommon;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            String str = ("sort_update_time >= " + j + " AND " + TableDefine.MediaSessionColumns.COLUMN_SORT_UPDATE_TIME + " <= " + j2 + " AND " + TableDefine.MediaSessionColumns.COLUMN_SESSION_MODE + " = " + i2) + " AND marktop = 1";
            String str2 = "marktop != 1 AND fetch_mode = " + i2;
            String valueOf = String.valueOf(Math.abs(i));
            synchronized (DBBase.mSyncLock) {
                List<ChatSession> sessionListInternal = getSessionListInternal(str, null, null, null, "marktop, sort_update_time DESC ", valueOf);
                if (sessionListInternal != null && sessionListInternal.size() == Math.abs(i)) {
                    return sessionListInternal;
                }
                int abs = Math.abs(i);
                if (sessionListInternal == null) {
                    size = 0;
                } else {
                    size = sessionListInternal.size();
                }
                String valueOf2 = String.valueOf(abs - size);
                ArrayList arrayList = new ArrayList();
                List<ChatSession> sessionListInternal2 = getSessionListInternal(str2, null, null, null, "marktop, sort_update_time DESC ", valueOf2);
                if (sessionListInternal != null) {
                    arrayList.addAll(sessionListInternal);
                }
                if (sessionListInternal2 != null) {
                    arrayList.addAll(sessionListInternal2);
                }
                return arrayList;
            }
        }
        return (List) invokeCommon.objValue;
    }

    private List<ChatSession> getSessionListInternal(String str, String[] strArr, String str2, String str3, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, this, new Object[]{str, strArr, str2, str3, str4, str5})) == null) {
            ChatSessionListParse chatSessionListParse = new ChatSessionListParse();
            synchronized (DBBase.mSyncLock) {
                query(TableDefine.DB_TABLE_MEDIA_SESSION, null, str, strArr, str2, str3, str4, str5, chatSessionListParse);
            }
            return chatSessionListParse.getResult();
        }
        return (List) invokeCommon.objValue;
    }

    @Override // com.baidu.android.imsdk.media.db.IMessageDBOperation
    public ChatMsg getChatMsg(String str, String[] strArr, String str2, String str3, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{str, strArr, str2, str3, str4, str5})) == null) {
            SingleChatMsgParse singleChatMsgParse = new SingleChatMsgParse();
            synchronized (DBBase.mSyncLock) {
                query(TableDefine.DB_TABLE_MEDIA_MESSAGE, null, str, strArr, str2, str3, str4, str5, singleChatMsgParse);
            }
            return singleChatMsgParse.getResult();
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    private void notifyDbChange(int i, List<ChatSession> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65562, this, i, list) == null) {
            notifyDbChange(i, list, true);
        }
    }

    private void notifyDbChange(int i, List<ChatSession> list, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65563, this, new Object[]{Integer.valueOf(i), list, Boolean.valueOf(z)}) == null) && list != null && list.size() != 0) {
            super.notifyDbChange(1, i, list, z);
        }
    }

    private int updateChatMsgInternal(ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65568, this, contentValues, str, strArr)) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    return -1;
                }
                try {
                    return openDatabase.update(TableDefine.DB_TABLE_MEDIA_MESSAGE, contentValues, str, strArr);
                } catch (Exception e) {
                    LogUtils.e(TAG, "updateChatMsgInternal:", e);
                    return -1;
                }
            }
        }
        return invokeLLL.intValue;
    }

    private int updateChatRecordInternal(ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65570, this, contentValues, str, strArr)) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    return -1;
                }
                try {
                    return openDatabase.update(TableDefine.DB_TABLE_MEDIA_SESSION, contentValues, str, strArr);
                } catch (Exception e) {
                    LogUtils.e(TAG, "updateChatRecordInternal:", e);
                    return -1;
                }
            }
        }
        return invokeLLL.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChatSession parseMediaSession(Cursor cursor) {
        InterceptResult invokeL;
        long j;
        long j2;
        long newMsgSum;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, this, cursor)) == null) {
            if (cursor == null) {
                return null;
            }
            int i = CursorWrapper.getInt(cursor, "category");
            long j3 = CursorWrapper.getLong(cursor, "contacter");
            long j4 = CursorWrapper.getLong(cursor, "contacter_bduid");
            String string = CursorWrapper.getString(cursor, "name");
            String string2 = CursorWrapper.getString(cursor, "last_msg");
            long j5 = CursorWrapper.getLong(cursor, "last_msg_time");
            long j6 = CursorWrapper.getLong(cursor, "new_msg_sum");
            int i2 = CursorWrapper.getInt(cursor, "chat_type");
            String string3 = CursorWrapper.getString(cursor, "icon_url");
            int i3 = CursorWrapper.getInt(cursor, "msg_state");
            long j7 = CursorWrapper.getLong(cursor, "paid");
            int i4 = CursorWrapper.getInt(cursor, "isclicked");
            int i5 = CursorWrapper.getInt(cursor, "classtype");
            int i6 = CursorWrapper.getInt(cursor, "classshow");
            String string4 = CursorWrapper.getString(cursor, "classtitle");
            String string5 = CursorWrapper.getString(cursor, "classavatar");
            long j8 = CursorWrapper.getLong(cursor, "marktoptime");
            int i7 = CursorWrapper.getInt(cursor, "marktop");
            String string6 = CursorWrapper.getString(cursor, "nickname");
            String string7 = CursorWrapper.getString(cursor, "v_portrait");
            String string8 = CursorWrapper.getString(cursor, "certification");
            int i8 = CursorWrapper.getInt(cursor, "shield");
            long j9 = CursorWrapper.getLong(cursor, "shield_time");
            String string9 = CursorWrapper.getString(cursor, "vip_id");
            long j10 = CursorWrapper.getLong(cursor, "last_msg_bduid");
            String string10 = CursorWrapper.getString(cursor, "last_msg_name");
            long j11 = CursorWrapper.getLong(cursor, TableDefine.MediaSessionColumns.COLUMN_SORT_UPDATE_TIME);
            int i9 = CursorWrapper.getInt(cursor, "is_stranger");
            int i10 = CursorWrapper.getInt(cursor, "disturb");
            long j12 = CursorWrapper.getLong(cursor, TableDefine.MediaSessionColumns.COLUMN_LAST_MSGID);
            int i11 = CursorWrapper.getInt(cursor, "business");
            int i12 = CursorWrapper.getInt(cursor, TableDefine.MediaSessionColumns.COLUMN_SESSION_MODE);
            long j13 = CursorWrapper.getLong(cursor, TableDefine.MediaSessionColumns.COLUMN_CONTACTER_IMUK);
            int i13 = CursorWrapper.getInt(cursor, "remind_type");
            long j14 = CursorWrapper.getLong(cursor, "remind_msgid");
            long j15 = CursorWrapper.getLong(cursor, "remind_uid");
            String string11 = CursorWrapper.getString(cursor, "remind_role_display_name");
            String string12 = CursorWrapper.getString(cursor, "extra");
            String string13 = CursorWrapper.getString(cursor, "highlight_desc");
            int i14 = CursorWrapper.getInt(cursor, "highlight_priority");
            long j16 = CursorWrapper.getLong(cursor, "last_msgid_from_me");
            int i15 = CursorWrapper.getInt(cursor, "highlight_data_id");
            if (j4 > 0 && i2 == 0 && i == 0) {
                j = j4;
            } else {
                j = j3;
            }
            ChatSession chatSession = new ChatSession(i, j3, j, string);
            chatSession.setState(i3);
            chatSession.setPaid(j7);
            chatSession.setIsClicked(i4);
            chatSession.setMarkTop(i7);
            chatSession.setMarkTopTime(j8);
            chatSession.setNickName(string6);
            chatSession.setCertification(string8);
            chatSession.setShield(i8);
            chatSession.setShieldTime(j9);
            chatSession.setVipId(string9);
            chatSession.setLastMsgUid(j10);
            chatSession.setLastMsgName(string10);
            chatSession.setLastMsg(string2);
            chatSession.setLastMsgTime(j5);
            chatSession.setIconUrl(string3);
            chatSession.setChatType(i2);
            chatSession.setVPortrait(string7);
            chatSession.setClassTitle(string4);
            chatSession.setClassAvatar(string5);
            chatSession.setClassShow(i6);
            chatSession.setClassType(i5);
            chatSession.setSortTime(j11);
            chatSession.setIsStranger(i9);
            chatSession.setDisturb(i10);
            chatSession.setLastMsgId(j12);
            chatSession.setBusinessType(i11);
            chatSession.setContacterImuk(j13);
            chatSession.setExt(string12);
            if (!Utility.isValidAggSession(i5, i6) && (i12 != 1 || chatSession.getIsStranger() != 1)) {
                chatSession.setSessionFrom(1);
            } else {
                chatSession.setSessionFrom(2);
            }
            if (i2 == 57) {
                ChatSession chatRecord = ChatMessageDBManager.getInstance(this.mContext).getChatRecord(new ChatObject(this.mContext, 1, j3));
                if (chatRecord == null) {
                    newMsgSum = 0;
                } else {
                    newMsgSum = chatRecord.getNewMsgSum();
                }
                j2 = newMsgSum;
            } else if (Utility.isValidAggSession(i5, i6) && chatSession.getCategory() != 9 && chatSession.getIsStranger() != 1) {
                j2 = ChatMessageDBManager.getInstance(this.mContext).getNewMsgCountOfClass(i5);
            } else {
                j2 = j6;
            }
            chatSession.setNewMsgSum(j2);
            if (j2 > 0 && (System.currentTimeMillis() * 1000) - j14 < IMConstants.NANOSECOND_24_HOUR) {
                chatSession.setRemindType(i13);
                chatSession.setRemindMsgId(j14);
                chatSession.setRemindUid(j15);
                chatSession.setRemindRoleDisplayName(string11);
            }
            chatSession.setHighlightDesc(string13);
            chatSession.setHighlightPriority(i14);
            chatSession.setLastMsgidFromMe(j16);
            chatSession.setHighlightDataId(i15);
            return chatSession;
        }
        return (ChatSession) invokeL.objValue;
    }

    private int updateChatRecordAndNotifyInternal(ContentValues contentValues, String str, String[] strArr, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65569, this, new Object[]{contentValues, str, strArr, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            int updateChatRecordInternal = updateChatRecordInternal(contentValues, str, strArr);
            if (updateChatRecordInternal > 0) {
                notifyDbChange(i, getSessionListInternal(str, strArr, null, null, null, null), z);
            }
            return updateChatRecordInternal;
        }
        return invokeCommon.intValue;
    }

    private void updateSession(boolean z, ChatSession chatSession, ChatMsg chatMsg, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65571, this, new Object[]{Boolean.valueOf(z), chatSession, chatMsg, Integer.valueOf(i)}) != null) || !z) {
            return;
        }
        if (chatSession == null) {
            if (chatMsg != null && chatMsg.getContacter() != -1) {
                createChatSession(chatMsg.getCategory(), chatMsg.getContacter(), chatMsg.getChatType());
                return;
            }
            return;
        }
        int i2 = 1;
        if (chatMsg == null) {
            if (i == 1) {
                updateSessionAfterClearAllMsg(chatSession);
                return;
            } else {
                delChatRecord(chatSession.getCategory(), chatSession.getContacter());
                return;
            }
        }
        String recommendDescription = chatMsg.getRecommendDescription();
        if (!TextUtils.isEmpty(chatMsg.getPreviewDesc())) {
            recommendDescription = chatMsg.getPreviewDesc();
        }
        chatSession.setState(chatMsg.getStatus());
        chatSession.setLastMsg(recommendDescription);
        chatSession.setLastMsgTime(chatMsg.getMsgTime());
        chatSession.setIsClicked(Utility.getClickState(chatMsg));
        if (chatMsg.getStatus() != 3) {
            chatSession.setLastMsgId(chatMsg.getMsgId());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(chatSession);
        if (chatSession.getIsStranger() == 1 && chatSession.getSessionFrom() != 2) {
            i2 = 2;
        }
        updateSessionListWithNotify(arrayList, i2, 4);
    }

    private void updateSessionAfterClearAllMsg(ChatSession chatSession) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65572, this, chatSession) != null) || chatSession == null) {
            return;
        }
        ChatMsg draftMsg = MediaChatMessageManager.getInstance(this.mContext).getDraftMsg(chatSession.getCategory(), chatSession.getContacterImuk());
        if (chatSession.getState() != 3 || draftMsg == null) {
            chatSession.setLastMsg("");
            chatSession.setLastMsgName("");
            chatSession.setState(0);
            chatSession.setRemindMsgId(0L);
            chatSession.setRemindRoleDisplayName("");
            chatSession.setRemindType(0);
            chatSession.setRemindUid(0L);
            chatSession.setNewMsgSum(0L);
            chatSession.setHighlightDataId(0);
            chatSession.setHighlightDesc("");
            chatSession.setHighlightPriority(0);
            chatSession.setLastMsgidFromMe(0L);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(chatSession);
        int i = 2;
        updateSessionListWithNotify(arrayList, (chatSession.getIsStranger() != 1 || chatSession.getSessionFrom() == 2) ? 1 : 1, 4);
    }

    public long insertDraftMsg(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, chatMsg)) == null) {
            long j = 0;
            if (chatMsg == null) {
                return 0L;
            }
            LogUtils.d(TAG, "insertDraftMsg msg = " + chatMsg);
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    return 0L;
                }
                try {
                    buildDraftMsgStatement(openDatabase.compileStatement(MEDIA_DRAFT_MSG_INSERT_SQL), chatMsg).execute();
                    j = 1;
                    updateChatSession(chatMsg);
                } catch (Exception e) {
                    LogUtils.e(TAG, "insertDraftMsg Exception", e);
                }
                LogUtils.d(TAG, "insertDraftMsg result = " + j);
                return j;
            }
        }
        return invokeL.longValue;
    }

    public void updateChatSession(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048611, this, chatMsg) != null) || chatMsg == null) {
            return;
        }
        ChatSession chatRecord = getChatRecord(chatMsg.getCategory(), chatMsg.getContacter());
        boolean z = false;
        if (!MsgUtility.isDraftMsg(chatMsg)) {
            ChatObject chatObject = new ChatObject(this.mContext, chatMsg.getCategory(), chatMsg.getContacter(), chatMsg.getPaid(), chatMsg.getChatType());
            if (chatRecord == null || chatRecord.getState() != 3 || chatMsg.getStatus() != 3) {
                ArrayList<ChatMsg> fetchMsgExcludeTypes = getInstance(this.mContext).fetchMsgExcludeTypes(chatObject, 0L, 1L, UNUPDATE_SESSION_MSG_TYPES);
                if (fetchMsgExcludeTypes != null && fetchMsgExcludeTypes.size() > 0) {
                    int chatType = chatMsg.getChatType();
                    ChatMsg chatMsg2 = fetchMsgExcludeTypes.get(0);
                    chatMsg2.setChatType(chatType);
                    chatMsg = chatMsg2;
                }
            }
            updateSession(z, chatRecord, chatMsg, 1);
        }
        z = true;
        updateSession(z, chatRecord, chatMsg, 1);
    }

    @Override // com.baidu.android.imsdk.media.db.IMessageDBOperation
    public int updateMsgStatus(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, chatMsg)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("msgid", Long.valueOf(chatMsg.getMsgId()));
            contentValues.put("auto_risk_control_status", Integer.valueOf(chatMsg.getAutoRiskControlStatus()));
            contentValues.put("status", Integer.valueOf(chatMsg.getStatus()));
            contentValues.put("content", chatMsg.getJsonContent());
            contentValues.put("time", Long.valueOf(chatMsg.getMsgTime()));
            contentValues.put("tips_code", Integer.valueOf(chatMsg.getTipsCode()));
            contentValues.put("tips", chatMsg.getTips());
            int updateChatMsgInternal = updateChatMsgInternal(contentValues, "_id = ?", new String[]{String.valueOf(chatMsg.getRowId())});
            if (updateChatMsgInternal > 0) {
                updateChatSession(chatMsg);
            }
            return updateChatMsgInternal;
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x00d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ee A[Catch: all -> 0x019c, Exception -> 0x01a1, TryCatch #6 {Exception -> 0x01a1, all -> 0x019c, blocks: (B:41:0x00d6, B:43:0x00e4, B:46:0x00ee, B:48:0x0102, B:50:0x0107, B:52:0x010e, B:38:0x00c9), top: B:116:0x00d6 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01d8 A[Catch: all -> 0x021a, TryCatch #2 {, blocks: (B:11:0x0046, B:13:0x004c, B:82:0x01d2, B:84:0x01d8, B:86:0x01dd, B:97:0x0210, B:99:0x0216, B:100:0x0219, B:71:0x01ae, B:73:0x01b4), top: B:112:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0216 A[Catch: all -> 0x021a, TryCatch #2 {, blocks: (B:11:0x0046, B:13:0x004c, B:82:0x01d2, B:84:0x01d8, B:86:0x01dd, B:97:0x0210, B:99:0x0216, B:100:0x0219, B:71:0x01ae, B:73:0x01b4), top: B:112:0x0046 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long updateSessionListInternal(List<ChatSession> list, int i, boolean z, int i2, boolean z2) {
        InterceptResult invokeCommon;
        SQLiteDatabase sQLiteDatabase;
        ArrayList arrayList;
        long j;
        SQLiteDatabase sQLiteDatabase2;
        ChatSession mediaChatSession;
        int delChatRecordInternal;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65573, this, new Object[]{list, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2)})) == null) {
            if (list == null || list.size() == 0) {
                return 0L;
            }
            LogUtils.d(TAG, "updateSessionListInternal size = " + list.size() + " mode = " + i);
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    return 0L;
                }
                try {
                    SQLiteStatement compileStatement = openDatabase.compileStatement(MEDIA_SESSION_INSERT_SQL);
                    SQLiteStatement compileStatement2 = openDatabase.compileStatement(MEDIA_SESSION_REPLACE_SQL);
                    openDatabase.beginTransaction();
                    long j2 = 0;
                    for (ChatSession chatSession : list) {
                        if (chatSession == null) {
                            sQLiteDatabase2 = openDatabase;
                        } else if (i == 1 && chatSession.getIsStranger() == 1) {
                            chatSession.setSessionFrom(2);
                            mediaChatSession = getMediaStrangerFolderSession();
                            if (mediaChatSession != null) {
                                delChatRecordInternal = delStrangerFolderSession();
                                SQLiteDatabase sQLiteDatabase3 = openDatabase;
                                i3 = delChatRecordInternal;
                                sQLiteDatabase2 = sQLiteDatabase3;
                                if (mediaChatSession == null) {
                                }
                            }
                            sQLiteDatabase2 = openDatabase;
                            i3 = 0;
                            if (mediaChatSession == null) {
                            }
                        } else if (Utility.isValidAggSession(chatSession.getClassType(), chatSession.getClassShow())) {
                            chatSession.setSessionFrom(2);
                            mediaChatSession = getMediaChatSessionByClassType(chatSession.getClassType());
                            if (mediaChatSession != null) {
                                delChatRecordInternal = delChatRecordInternal("classtype = ?", new String[]{String.valueOf(chatSession.getClassType())});
                                SQLiteDatabase sQLiteDatabase32 = openDatabase;
                                i3 = delChatRecordInternal;
                                sQLiteDatabase2 = sQLiteDatabase32;
                                if (mediaChatSession == null) {
                                    try {
                                        if (buildSessionStatement(compileStatement, chatSession, i).executeInsert() >= 0) {
                                            arrayList2.add(chatSession);
                                            j2++;
                                        }
                                    } catch (Exception e) {
                                        e = e;
                                        sQLiteDatabase = sQLiteDatabase2;
                                        arrayList = arrayList2;
                                        arrayList.clear();
                                        arrayList3.clear();
                                        LogUtils.e(TAG, "updateSessionListInternal exception", e);
                                        if (sQLiteDatabase.inTransaction()) {
                                        }
                                        j = 0;
                                        if (z) {
                                        }
                                        LogUtils.d(TAG, "updateSessionList result = " + j);
                                        return j;
                                    } catch (Throwable th) {
                                        th = th;
                                        sQLiteDatabase = sQLiteDatabase2;
                                        if (sQLiteDatabase.inTransaction()) {
                                        }
                                        throw th;
                                    }
                                } else {
                                    SQLiteStatement sQLiteStatement = compileStatement;
                                    long lastMsgTime = chatSession.getLastMsgTime() * 1000 * 1000;
                                    if (chatSession.getSortTime() <= lastMsgTime) {
                                        chatSession.setSortTime(lastMsgTime);
                                    }
                                    if (i3 <= 0) {
                                        if (mediaChatSession.getState() == 3) {
                                            sQLiteDatabase = sQLiteDatabase2;
                                            arrayList = arrayList2;
                                            try {
                                                try {
                                                    ChatMsg draftMsg = BIMManager.getDraftMsg(this.mContext, mediaChatSession.getCategory(), mediaChatSession.getContacter());
                                                    if (draftMsg instanceof TextMsg) {
                                                        chatSession.setState(3);
                                                        chatSession.setLastMsg(draftMsg.getRecommendDescription());
                                                        chatSession.setIsClicked(mediaChatSession.getIsClicked());
                                                        if (mediaChatSession.getLastMsgTime() > chatSession.getLastMsgTime()) {
                                                            chatSession.setLastMsgTime(mediaChatSession.getLastMsgTime());
                                                        }
                                                    }
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    arrayList.clear();
                                                    arrayList3.clear();
                                                    LogUtils.e(TAG, "updateSessionListInternal exception", e);
                                                    if (sQLiteDatabase.inTransaction()) {
                                                        sQLiteDatabase.endTransaction();
                                                    }
                                                    j = 0;
                                                    if (z) {
                                                    }
                                                    LogUtils.d(TAG, "updateSessionList result = " + j);
                                                    return j;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                if (sQLiteDatabase.inTransaction()) {
                                                    sQLiteDatabase.endTransaction();
                                                }
                                                throw th;
                                            }
                                        } else {
                                            sQLiteDatabase = sQLiteDatabase2;
                                            arrayList = arrayList2;
                                            if (mediaChatSession.getState() == 6 && mediaChatSession.getLastMsgTime() > chatSession.getLastMsgTime()) {
                                                chatSession.setIsClicked(mediaChatSession.getIsClicked());
                                                chatSession.setLastMsgTime(mediaChatSession.getLastMsgTime());
                                                chatSession.setLastMsg(mediaChatSession.getLastMsg());
                                                chatSession.setState(mediaChatSession.getState());
                                                chatSession.setLastMsgId(mediaChatSession.getLastMsgId());
                                            }
                                        }
                                    } else {
                                        sQLiteDatabase = sQLiteDatabase2;
                                        arrayList = arrayList2;
                                    }
                                    buildSessionStatement(compileStatement2, chatSession, i).execute();
                                    arrayList3.add(chatSession);
                                    j2++;
                                    openDatabase = sQLiteDatabase;
                                    arrayList2 = arrayList;
                                    compileStatement = sQLiteStatement;
                                }
                            }
                            sQLiteDatabase2 = openDatabase;
                            i3 = 0;
                            if (mediaChatSession == null) {
                            }
                        } else {
                            sQLiteDatabase2 = openDatabase;
                            mediaChatSession = getMediaChatSession(chatSession.getCategory(), chatSession.getContacter());
                            i3 = 0;
                            if (mediaChatSession == null) {
                            }
                        }
                        openDatabase = sQLiteDatabase2;
                    }
                    arrayList = arrayList2;
                    sQLiteDatabase = openDatabase;
                    sQLiteDatabase.setTransactionSuccessful();
                    if (sQLiteDatabase.inTransaction()) {
                        sQLiteDatabase.endTransaction();
                    }
                    j = j2;
                } catch (Exception e3) {
                    e = e3;
                    arrayList = arrayList2;
                    sQLiteDatabase = openDatabase;
                } catch (Throwable th3) {
                    th = th3;
                    sQLiteDatabase = openDatabase;
                }
                if (z) {
                    if (arrayList.size() > 0) {
                        notifyDbChange(0, arrayList, z2);
                    }
                    if (arrayList3.size() > 0) {
                        notifyDbChange(i2, arrayList3, z2);
                    }
                }
                LogUtils.d(TAG, "updateSessionList result = " + j);
                return j;
            }
        }
        return invokeCommon.longValue;
    }

    public int clearChatSessionMarkTop(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("marktop", (Integer) 0);
            return updateChatRecordInternal(contentValues, "marktop = ?  AND sort_update_time >= ? AND sort_update_time <= ? ", new String[]{String.valueOf(1), String.valueOf(j), String.valueOf(j2)});
        }
        return invokeCommon.intValue;
    }

    public int delAllStrangerSession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            LogUtils.d(TAG, "delAllStrangerSession");
            List<ChatSession> sessionListInternal = getSessionListInternal("is_stranger = ? AND fetch_mode = ? ", new String[]{String.valueOf(1), String.valueOf(2)}, null, null, null, null);
            if (sessionListInternal != null && sessionListInternal.size() > 0) {
                for (ChatSession chatSession : sessionListInternal) {
                    deleteAllMsgsWithoutNotify(new ChatObject(this.mContext, chatSession.getCategory(), chatSession.getContacter()));
                }
            }
            String[] strArr = {String.valueOf(1)};
            List<ChatSession> sessionListInternal2 = getSessionListInternal("is_stranger = ? ", strArr, null, null, null, null);
            int delChatRecordInternal = delChatRecordInternal("is_stranger = ? ", strArr);
            LogUtils.d(TAG, "delAllStrangerSession ret = " + delChatRecordInternal);
            if (delChatRecordInternal > 0 && sessionListInternal2.size() > 0) {
                notifyDbChange(2, sessionListInternal2, false);
            }
            return delChatRecordInternal;
        }
        return invokeV.intValue;
    }

    public int setAllStrangersRead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            List<ChatSession> sessionListInternal = getSessionListInternal("is_stranger = ? AND fetch_mode = ? AND new_msg_sum > ?", new String[]{String.valueOf(1), String.valueOf(2), String.valueOf(0)}, null, null, null, null);
            if (sessionListInternal != null && sessionListInternal.size() > 0) {
                for (ChatSession chatSession : sessionListInternal) {
                    setAllMsgRead(chatSession.getCategory(), chatSession.getContacter(), 0L);
                }
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("new_msg_sum", (Integer) 0);
            String[] strArr = {String.valueOf(1), String.valueOf(0)};
            List<ChatSession> sessionListInternal2 = getSessionListInternal("is_stranger = ? AND new_msg_sum > ?", strArr, null, null, null, null);
            int updateChatRecordInternal = updateChatRecordInternal(contentValues, "is_stranger = ? AND new_msg_sum > ?", strArr);
            if (updateChatRecordInternal > 0 && sessionListInternal2 != null && sessionListInternal2.size() > 0) {
                for (ChatSession chatSession2 : sessionListInternal2) {
                    chatSession2.setNewMsgSum(0L);
                }
                notifyDbChange(3, sessionListInternal2, false);
            }
            return updateChatRecordInternal;
        }
        return invokeV.intValue;
    }

    public int delDraftMsg(int i, long j) {
        InterceptResult invokeCommon;
        int delDraftMsgInternal;
        ArrayList<ChatMsg> fetchMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            LogUtils.d(TAG, "delDraftMsg category = " + i + " contacter = " + j);
            String[] strArr = {String.valueOf(i), String.valueOf(j)};
            synchronized (DBBase.mSyncLock) {
                delDraftMsgInternal = delDraftMsgInternal("category = ? AND contacter = ?", strArr);
                if (delDraftMsgInternal > 0 && (fetchMsg = fetchMsg(new ChatObject(this.mContext, i, j), 0L, 1L, -1L, false, null)) != null && fetchMsg.size() > 0) {
                    updateSession(true, getChatRecord(i, j), fetchMsg.get(0), 1);
                }
            }
            return delDraftMsgInternal;
        }
        return invokeCommon.intValue;
    }

    public ChatSession getMediaChatSession(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            LogUtils.d(TAG, "getMediaChatSession category = " + i + " contacter = " + j);
            ChatSession chatRecordInternal = getChatRecordInternal(getSessionQuerySql(), getSessionQueryArgs(i, j));
            StringBuilder sb = new StringBuilder();
            sb.append("getMediaChatSession session = ");
            sb.append(chatRecordInternal);
            LogUtils.d(TAG, sb.toString());
            return chatRecordInternal;
        }
        return (ChatSession) invokeCommon.objValue;
    }

    public int delUselessChatSession(long j, long j2, List<Long> list, List<Integer> list2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), list, list2, Integer.valueOf(i)})) == null) {
            String str = "sort_update_time >= ? AND sort_update_time <= ? AND fetch_mode = ? AND marktop = ?";
            if (list != null && list.size() > 0) {
                str = "sort_update_time >= ? AND sort_update_time <= ? AND fetch_mode = ? AND marktop = ? AND contacter NOT " + buildINStatement(list);
            }
            if (list2 != null && list2.size() > 0) {
                str = str + " AND classtype NOT " + buildINStatement(list2);
            }
            LogUtils.d(TAG, "delUselessChatSession query = " + str);
            return delChatRecordInternal(str, new String[]{String.valueOf(j), String.valueOf(j2), String.valueOf(i), String.valueOf(0)});
        }
        return invokeCommon.intValue;
    }

    public List<ChatSession> getMediaSessionList(long j, long j2, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            LogUtils.d(TAG, "getMediaSessionList begin = " + j + " end = " + j2 + " count = " + i + " mode = " + i2);
            if (i3 == 1) {
                return getMediaSessionListWithTop(j, j2, i, i2);
            }
            return getSessionListInternal("sort_update_time >= ? AND sort_update_time <= ? AND marktop != ? AND fetch_mode = ?", new String[]{String.valueOf(j), String.valueOf(j2), String.valueOf(1), String.valueOf(i2)}, null, null, "sort_update_time DESC ", String.valueOf(Math.abs(i)));
        }
        return (List) invokeCommon.objValue;
    }

    @Override // com.baidu.android.imsdk.media.db.IMessageDBOperation
    public int deleteChatMsg(ChatMsg chatMsg) {
        InterceptResult invokeL;
        int delChatMsgInternal;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, chatMsg)) == null) {
            if (chatMsg == null) {
                return 0;
            }
            synchronized (DBBase.mSyncLock) {
                long rowId = chatMsg.getRowId();
                delChatMsgInternal = delChatMsgInternal("_id = ? ", new String[]{String.valueOf(rowId)});
                delChatMsgInternal("_id=? AND type in (?, ?, ?)", new String[]{String.valueOf(rowId + 1), String.valueOf(2012), String.valueOf(2001), String.valueOf(2014)});
                if (delChatMsgInternal > 0) {
                    ArrayList<ChatMsg> fetchMsgExcludeTypes = getInstance(this.mContext).fetchMsgExcludeTypes(new ChatObject(this.mContext, chatMsg.getCategory(), chatMsg.getContacter()), 0L, 1L, UNUPDATE_SESSION_MSG_TYPES);
                    if (fetchMsgExcludeTypes != null && fetchMsgExcludeTypes.size() > 0) {
                        updateChatSession(fetchMsgExcludeTypes.get(0));
                    } else {
                        updateSessionAfterClearAllMsg(getChatRecord(chatMsg.getCategory(), chatMsg.getContacter()));
                    }
                }
            }
            return delChatMsgInternal;
        }
        return invokeL.intValue;
    }

    public int getUnReadMsgCount(ChatObject chatObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, chatObject)) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                Cursor cursor = null;
                if (openDatabase == null) {
                    return -1;
                }
                try {
                    String str = "category=? AND contacter=? AND is_read=?";
                    String[] strArr = {String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter()), String.valueOf(0)};
                    if (1 == chatObject.getCategory()) {
                        str = "category=? AND contacter=? AND is_read=? AND type != 101";
                    }
                    cursor = openDatabase.query(TableDefine.DB_TABLE_MEDIA_MESSAGE, new String[]{"_id"}, str, strArr, null, null, null);
                    LogUtils.d(TAG, "getUnReadMsgCount> COLUMN_CATEGORY=" + chatObject.getCategory() + ", COLUMN_CONTACTER=" + chatObject.getContacter() + ", count = " + cursor.getCount());
                    int count = cursor.getCount();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return count;
                } catch (Exception e) {
                    LogUtils.e(TAG, " getUnReadMsgCount:", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return -1;
                }
            }
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.android.imsdk.media.db.IMessageDBOperation
    public boolean isMsgExist(ChatMsg chatMsg) {
        InterceptResult invokeL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, chatMsg)) == null) {
            long msgId = chatMsg.getMsgId();
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append("msgid");
            sb.append(" = ? AND ");
            sb.append("status");
            sb.append(" = ?)");
            boolean z = false;
            if (TextUtils.isEmpty(chatMsg.getMsgKey())) {
                strArr = new String[]{String.valueOf(msgId), String.valueOf(0), String.valueOf(chatMsg.getContacter())};
            } else {
                sb.append(" OR ");
                sb.append("msg_key");
                sb.append(" = ?");
                strArr = new String[]{String.valueOf(msgId), String.valueOf(0), String.valueOf(chatMsg.getMsgKey()), String.valueOf(chatMsg.getContacter())};
            }
            StringBuilder insert = sb.insert(0, "((");
            insert.append(") AND ");
            insert.append("contacter");
            insert.append(" = ?)");
            if (getChatMsg(sb.toString(), strArr) != null) {
                z = true;
            }
            if (z && chatMsg.getFetchTriggerReason() == 1) {
                TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable(this, chatMsg) { // from class: com.baidu.android.imsdk.media.db.MediaMessageDBManager.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaMessageDBManager this$0;
                    public final /* synthetic */ ChatMsg val$msg;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, chatMsg};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$msg = chatMsg;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.updateSingleMsg(this.val$msg);
                        }
                    }
                });
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.android.imsdk.media.db.IMessageDBOperation
    public long replaceChatMsgList(List<ChatMsg> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, list)) == null) {
            long j = 0;
            if (DataUtil.isListEmpty(list)) {
                return 0L;
            }
            LogUtils.d(TAG, "insertMediaChatMsgList size = " + list.size());
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    return 0L;
                }
                try {
                    SQLiteStatement compileStatement = openDatabase.compileStatement(MEDIA_MSG_REPLACE_SQL);
                    openDatabase.beginTransaction();
                    long j2 = 0;
                    for (ChatMsg chatMsg : list) {
                        if (chatMsg != null && chatMsg.getMsgType() != 27 && !isMsgExist(chatMsg) && buildChatMsgStatement(compileStatement, chatMsg).executeInsert() >= 0) {
                            j2++;
                        }
                    }
                    openDatabase.setTransactionSuccessful();
                    if (openDatabase.inTransaction()) {
                        openDatabase.endTransaction();
                    }
                    j = j2;
                } catch (Exception e) {
                    LogUtils.e(TAG, "insertMediaChatMsgList Exception", e);
                    if (openDatabase.inTransaction()) {
                        openDatabase.endTransaction();
                    }
                }
                LogUtils.d(TAG, "insertMediaChatMsgList result = " + j);
                return j;
            }
        }
        return invokeL.longValue;
    }

    public void updateSingleMsg(ChatMsg chatMsg) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, chatMsg) == null) {
            ContentValues contructChatMsgValues = contructChatMsgValues(chatMsg);
            long msgId = chatMsg.getMsgId();
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append("msgid");
            sb.append(" = ? AND ");
            sb.append("status");
            sb.append(" = ?)");
            if (TextUtils.isEmpty(chatMsg.getMsgKey())) {
                strArr = new String[]{String.valueOf(msgId), String.valueOf(0), String.valueOf(chatMsg.getContacter())};
            } else {
                sb.append(" OR ");
                sb.append("msg_key");
                sb.append(" = ?");
                strArr = new String[]{String.valueOf(msgId), String.valueOf(0), String.valueOf(chatMsg.getMsgKey()), String.valueOf(chatMsg.getContacter())};
            }
            StringBuilder insert = sb.insert(0, "((");
            insert.append(") AND ");
            insert.append("contacter");
            insert.append(" = ?)");
            int updateChatMsgInternal = updateChatMsgInternal(contructChatMsgValues, sb.toString(), strArr);
            LogUtils.d(TAG, "b update 单条消息结果： " + updateChatMsgInternal);
            if (updateChatMsgInternal > 0) {
                updateChatSession(chatMsg);
            }
        }
    }

    @Override // com.baidu.android.imsdk.media.db.IMessageDBOperation
    public ArrayList<ChatMsg> fetchMsg(ChatObject chatObject, long j, long j2, long j3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{chatObject, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)})) == null) {
            return fetchMsg(chatObject, j, j2, j3, z, null);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:94:0x01fd */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01f2, code lost:
        r2.close();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x012a A[Catch: all -> 0x00a4, Exception -> 0x00a7, TryCatch #6 {Exception -> 0x00a7, all -> 0x00a4, blocks: (B:43:0x00de, B:45:0x012a, B:46:0x012d, B:48:0x0133, B:57:0x014e, B:58:0x01ab, B:41:0x00c5), top: B:112:0x00c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0133 A[Catch: all -> 0x00a4, Exception -> 0x00a7, TryCatch #6 {Exception -> 0x00a7, all -> 0x00a4, blocks: (B:43:0x00de, B:45:0x012a, B:46:0x012d, B:48:0x0133, B:57:0x014e, B:58:0x01ab, B:41:0x00c5), top: B:112:0x00c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0207  */
    /* JADX WARN: Type inference failed for: r13v1, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r23v0, types: [com.baidu.android.imsdk.db.DBBase, com.baidu.android.imsdk.media.db.MediaMessageDBManager, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v22, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v6, types: [long] */
    /* JADX WARN: Type inference failed for: r2v7, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.lang.StringBuilder] */
    @Override // com.baidu.android.imsdk.media.db.IMessageDBOperation
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<ChatMsg> fetchMsg(ChatObject chatObject, long j, long j2, long j3, boolean z, String str) {
        InterceptResult invokeCommon;
        String str2;
        String str3;
        String str4;
        ?? r2;
        Exception e;
        String str5;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{chatObject, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z), str})) == null) {
            long j4 = j;
            long j5 = j2;
            long j6 = j3;
            LogUtils.d(TAG, "fetchMsg param category " + chatObject.getCategory() + " contacter = " + chatObject.getContacter() + " msgid = " + j4 + " count = " + j5 + " rowid = " + j6 + " asc = " + z + " addtionClause = " + str);
            int i = (j4 > Long.MAX_VALUE ? 1 : (j4 == Long.MAX_VALUE ? 0 : -1));
            ?? r22 = j4;
            if (i == 0) {
                r22 = 0;
            }
            ?? openDatabase = openDatabase();
            ArrayList<ChatMsg> arrayList = new ArrayList<>();
            if (openDatabase == 0) {
                LogUtils.d(TAG, "getReadableDb fail!");
                return arrayList;
            }
            int i2 = (r22 > 0L ? 1 : (r22 == 0L ? 0 : -1));
            if (i2 <= 0 && j5 >= 0) {
                j5 = -j5;
            }
            Cursor cursor = null;
            try {
                try {
                    try {
                        if (0 == r22 && j6 == -1) {
                            str4 = " >= ";
                        } else {
                            int i3 = (j5 > 0L ? 1 : (j5 == 0L ? 0 : -1));
                            if (i3 == 0) {
                                str2 = " = ";
                                j6 = -2;
                            } else if (i3 > 0) {
                                if (j6 == Long.MAX_VALUE) {
                                    j6 = 0;
                                }
                                str2 = " > ";
                            } else {
                                if (j6 == -1) {
                                    j6 = Long.MAX_VALUE;
                                }
                                str2 = " < ";
                            }
                            if (j6 != -2) {
                                try {
                                    str3 = " AND _id" + str2 + j6;
                                    str4 = str2;
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("contacter");
                                    boolean z3 = false;
                                    String[] strArr = {String.valueOf(chatObject.getContacter()), String.valueOf((long) r22), String.valueOf(chatObject.getCategory())};
                                    sb.append(" = ? AND ");
                                    sb.append("msgid");
                                    sb.append(str4);
                                    sb.append("? AND ");
                                    sb.append("category");
                                    sb.append(" = ? ");
                                    if (!TextUtils.isEmpty(str3)) {
                                        sb.append(str3);
                                    }
                                    if (!TextUtils.isEmpty(str)) {
                                        sb.append(" AND ");
                                        sb.append(str);
                                    }
                                    if (j5 == 0) {
                                        j5 = 1;
                                    }
                                    if (i2 <= 0 && j5 > 0) {
                                        str5 = " asc ";
                                    } else {
                                        str5 = " desc ";
                                    }
                                    r2 = "select * from " + TableDefine.DB_TABLE_MEDIA_MESSAGE + " where " + sb.toString() + " ORDER BY msgid" + str5 + ",_id" + str5 + " limit " + Math.abs(j5);
                                    LogUtils.d(TAG, "query chatmsg sql = " + r2);
                                    synchronized (DBBase.mSyncLock) {
                                        try {
                                            Cursor rawQuery = openDatabase.rawQuery(r2, strArr);
                                            if (rawQuery != null && rawQuery.getCount() > 0) {
                                                if (i2 > 0 && j5 > 0) {
                                                    z2 = true;
                                                } else {
                                                    z2 = false;
                                                }
                                                if (z2 == z) {
                                                    z3 = true;
                                                }
                                                if (z3) {
                                                    rawQuery.moveToFirst();
                                                    fillCursorDataToArray(arrayList, rawQuery);
                                                    while (rawQuery.moveToNext()) {
                                                        fillCursorDataToArray(arrayList, rawQuery);
                                                    }
                                                } else {
                                                    rawQuery.moveToLast();
                                                    fillCursorDataToArray(arrayList, rawQuery);
                                                    while (rawQuery.moveToPrevious()) {
                                                        fillCursorDataToArray(arrayList, rawQuery);
                                                    }
                                                }
                                                if (rawQuery != null) {
                                                    rawQuery.close();
                                                }
                                                return arrayList;
                                            }
                                            return arrayList;
                                        } catch (Throwable th) {
                                            th = th;
                                            throw th;
                                        }
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    r2 = 0;
                                    LogUtils.e(TAG, "fetchMsg:", e);
                                    if (r2 != 0) {
                                    }
                                    return null;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    throw th;
                                }
                            }
                            str4 = str2;
                        }
                        synchronized (DBBase.mSyncLock) {
                        }
                    } catch (Exception e3) {
                        e = e3;
                        LogUtils.e(TAG, "fetchMsg:", e);
                        if (r2 != 0) {
                            r2.close();
                        }
                        return null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
                str3 = null;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("contacter");
                boolean z32 = false;
                String[] strArr2 = {String.valueOf(chatObject.getContacter()), String.valueOf((long) r22), String.valueOf(chatObject.getCategory())};
                sb2.append(" = ? AND ");
                sb2.append("msgid");
                sb2.append(str4);
                sb2.append("? AND ");
                sb2.append("category");
                sb2.append(" = ? ");
                if (!TextUtils.isEmpty(str3)) {
                }
                if (!TextUtils.isEmpty(str)) {
                }
                if (j5 == 0) {
                }
                if (i2 <= 0) {
                }
                str5 = " desc ";
                r2 = "select * from " + TableDefine.DB_TABLE_MEDIA_MESSAGE + " where " + sb2.toString() + " ORDER BY msgid" + str5 + ",_id" + str5 + " limit " + Math.abs(j5);
                LogUtils.d(TAG, "query chatmsg sql = " + r2);
            } catch (Throwable th4) {
                th = th4;
                cursor = r22;
            }
        } else {
            return (ArrayList) invokeCommon.objValue;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    @Override // com.baidu.android.imsdk.media.db.IMessageDBOperation
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<ChatMsg> fetchMsgExcludeTypes(ChatObject chatObject, long j, long j2, List<Integer> list) {
        InterceptResult invokeCommon;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{chatObject, Long.valueOf(j), Long.valueOf(j2), list})) == null) {
            synchronized (DBBase.mSyncLock) {
                String str = null;
                try {
                    if (list != null) {
                        try {
                            if (list.size() > 0) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("type NOT ");
                                sb.append(buildINStatement(list));
                                str = sb.toString();
                                String str2 = str;
                                if (j != 0) {
                                    j3 = -1;
                                } else {
                                    j3 = Long.MAX_VALUE;
                                }
                                return fetchMsg(chatObject, j, j2, j3, false, str2);
                            }
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                    String str22 = str;
                    if (j != 0) {
                    }
                    return fetchMsg(chatObject, j, j2, j3, false, str22);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } else {
            return (ArrayList) invokeCommon.objValue;
        }
    }

    @Override // com.baidu.android.imsdk.media.db.IMessageDBOperation
    public long getMaxMsgid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ChatMsg chatMsg = getChatMsg(null, null, null, null, "msgid desc ", String.valueOf(1));
            if (chatMsg == null) {
                return 0L;
            }
            return chatMsg.getMsgId();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.android.imsdk.media.db.IMessageDBOperation
    public ChatMsg getMsg(int i, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)})) == null) {
            LogUtils.d(TAG, "getMediaChatMsg category = " + i + " contacter = " + j + " msgid = " + j2);
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                ChatMsg chatMsg = null;
                if (openDatabase == null) {
                    return null;
                }
                try {
                    Cursor query = openDatabase.query(TableDefine.DB_TABLE_MEDIA_MESSAGE, null, "category = ? AND contacter = ? AND msgid = ?", new String[]{String.valueOf(i), String.valueOf(j), String.valueOf(j2)}, null, null, null);
                    if (query != null) {
                        while (query.moveToNext()) {
                            chatMsg = parseMediaChatMsg(query);
                        }
                    }
                } catch (Exception e) {
                    LogUtils.e(TAG, "getMediaChatMsg exception", e);
                }
                LogUtils.d(TAG, "getMediaChatMsg chatmsg = " + chatMsg);
                return chatMsg;
            }
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    public ChatMsg updateReplyChatMsgQuoteData(long j, int i, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048617, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str})) == null) {
            synchronized (DBBase.mSyncLock) {
                boolean z = false;
                String[] strArr = {String.valueOf(j), String.valueOf(0)};
                ChatMsg chatMsg = getChatMsg("msgid=? AND status=?", strArr);
                if (chatMsg != null && !TextUtils.isEmpty(chatMsg.getMsgContent())) {
                    String updatedMsgContent = MsgRepliedData.getUpdatedMsgContent(chatMsg.getMsgContent(), i, str);
                    if (TextUtils.isEmpty(updatedMsgContent)) {
                        return null;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("content", updatedMsgContent);
                    if (updateChatMsgInternal(contentValues, "msgid=? AND status=?", strArr) <= 0) {
                        return null;
                    }
                    chatMsg.setMsgContent(updatedMsgContent);
                    return chatMsg;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("updateReplyChatMsgQuoteData chat msg invalid:");
                if (chatMsg == null) {
                    z = true;
                }
                sb.append(z);
                LogUtils.d(TAG, sb.toString());
                return null;
            }
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    @Override // com.baidu.android.imsdk.media.db.IMessageDBOperation
    public int setAllMsgRead(int i, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_read", (Integer) 1);
            String str = "is_read=? AND category = ? AND (contacter = ? OR from_user = ?)";
            if (j2 > 0) {
                str = "is_read=? AND category = ? AND (contacter = ? OR from_user = ?) AND msgid<=" + j2;
            }
            return updateChatMsgInternal(contentValues, str, new String[]{String.valueOf(0), String.valueOf(i), String.valueOf(j), String.valueOf(j)});
        }
        return invokeCommon.intValue;
    }

    public int setAllMsgReadWithMsgid(int i, long j, long j2) {
        InterceptResult invokeCommon;
        int unReadMsgCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)})) == null) {
            synchronized (DBBase.mSyncLock) {
                setAllMsgRead(i, j, j2);
                unReadMsgCount = getInstance(this.mContext).getUnReadMsgCount(new ChatObject(this.mContext, i, j));
                ContentValues contentValues = new ContentValues();
                contentValues.put("new_msg_sum", Integer.valueOf(unReadMsgCount));
                updateChatRecordAndNotifyInternal(contentValues, getSessionQuerySql(), getSessionQueryArgs(i, j), 3, false);
            }
            return unReadMsgCount;
        }
        return invokeCommon.intValue;
    }

    @Override // com.baidu.android.imsdk.media.db.IMessageDBOperation
    public int setMsgRead(int i, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_read", (Integer) 1);
            String str = "is_read=? AND category = ? AND (contacter = ? OR from_user = ?)";
            if (j2 > 0) {
                str = "is_read=? AND category = ? AND (contacter = ? OR from_user = ?) AND msgid=" + j2;
            }
            return updateChatMsgInternal(contentValues, str, new String[]{String.valueOf(0), String.valueOf(i), String.valueOf(j), String.valueOf(j)});
        }
        return invokeCommon.intValue;
    }

    public void updateAllSessionRead() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            synchronized (DBBase.mSyncLock) {
                String[] strArr = {String.valueOf(0)};
                List<ChatSession> sessionListInternal = getSessionListInternal("new_msg_sum > ?", strArr, null, null, null, null);
                ContentValues contentValues = new ContentValues();
                contentValues.put("new_msg_sum", (Integer) 0);
                updateChatRecordInternal(contentValues, "new_msg_sum > ?", strArr);
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("is_read", (Integer) 1);
                updateChatMsgInternal(contentValues2, "is_read = ?", new String[]{String.valueOf(0)});
                if (sessionListInternal != null) {
                    for (ChatSession chatSession : sessionListInternal) {
                        chatSession.setNewMsgSum(0L);
                    }
                    notifyDbChange(3, sessionListInternal);
                }
            }
        }
    }

    public int updateChatSessionDisturb(int i, long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048612, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("disturb", Integer.valueOf(i2));
            return updateChatRecordAndNotifyInternal(contentValues, getSessionQuerySql(), getSessionQueryArgs(i, j), 7, false);
        }
        return invokeCommon.intValue;
    }

    public int updateSessionStranger(int i, long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048623, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_stranger", Integer.valueOf(i2));
            int i3 = 1;
            if (i2 == 1) {
                i3 = 2;
            }
            contentValues.put(TableDefine.MediaSessionColumns.COLUMN_SESSION_MODE, Integer.valueOf(i3));
            return updateChatRecordAndNotifyInternal(contentValues, getSessionQuerySql(), getSessionQueryArgs(i, j), 8, true);
        }
        return invokeCommon.intValue;
    }

    public int updateChatSessionMarkTop(int i, long j, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048613, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("marktop", Integer.valueOf(i2));
            contentValues.put("marktoptime", Long.valueOf(j2));
            return updateChatRecordAndNotifyInternal(contentValues, getSessionQuerySql(), getSessionQueryArgs(i, j), 5, false);
        }
        return invokeCommon.intValue;
    }

    public int updateChatSessionMarkTopBybduid(int i, long j, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048614, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("marktop", Integer.valueOf(i2));
            contentValues.put("marktoptime", Long.valueOf(j2));
            return updateChatRecordAndNotifyInternal(contentValues, "category = ? AND contacter_bduid = ? ", getSessionQueryArgs(i, j), 5, false);
        }
        return invokeCommon.intValue;
    }

    public int updateChatSessionShield(int i, long j, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048615, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("shield", Integer.valueOf(i2));
            contentValues.put("shield_time", Long.valueOf(j2));
            return updateChatRecordAndNotifyInternal(contentValues, getSessionQuerySql(), getSessionQueryArgs(i, j), 6, false);
        }
        return invokeCommon.intValue;
    }

    public long updateSessionListFromServer(List<ChatSession> list, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048621, this, list, i, i2)) == null) {
            LogUtils.d(TAG, "updateSessionListFromServer");
            return updateSessionListInternal(list, i, true, i2, false);
        }
        return invokeLII.longValue;
    }

    public long updateSessionListWithNotify(List<ChatSession> list, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048622, this, list, i, i2)) == null) {
            LogUtils.d(TAG, "updateSessionListWithNotify");
            return updateSessionListInternal(list, i, true, i2, true);
        }
        return invokeLII.longValue;
    }
}
