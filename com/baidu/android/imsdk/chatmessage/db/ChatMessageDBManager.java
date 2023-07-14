package com.baidu.android.imsdk.chatmessage.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.GetChatObjectInfoForRecordManager;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.SessionClass;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsgFactory;
import com.baidu.android.imsdk.chatmessage.messages.HtmlMsg;
import com.baidu.android.imsdk.chatmessage.messages.MsgRepliedData;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.db.IMUserManager;
import com.baidu.android.imsdk.db.CursorParse;
import com.baidu.android.imsdk.db.CursorWrapper;
import com.baidu.android.imsdk.db.DBBase;
import com.baidu.android.imsdk.db.DBResponseCode;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.GroupMember;
import com.baidu.android.imsdk.group.GroupMessageManagerImpl;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.group.db.GroupMessageDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.media.bean.SessionParam;
import com.baidu.android.imsdk.media.db.MediaMessageDBManager;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.retrieve.util.RetrieveUtil;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.MsgUtility;
import com.baidu.android.imsdk.utils.MultiplePair;
import com.baidu.android.imsdk.utils.TimeUtil;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.searchbox.player.utils.BasicVideoParserKt;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ChatMessageDBManager extends DBBase {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long CAST_RELIABLE_MSG_EXPIRED_TIME = 172800;
    public static final String TAG = "ChatMessageDBManager";
    public static final List<Integer> UNUPDATE_SESSION_MSG_TYPES;
    public static ChatMessageDBManager mInstance;
    public transient /* synthetic */ FieldHolder $fh;

    private boolean getCursorMoveDirection(boolean z, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65563, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2)})) == null) ? (j <= 0 || j2 <= 0) ? !z : z : invokeCommon.booleanValue;
    }

    /* loaded from: classes.dex */
    public class ChatMsgListParse implements CursorParse {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ArrayList<ChatMsg> msgs;
        public final /* synthetic */ ChatMessageDBManager this$0;

        public ChatMsgListParse(ChatMessageDBManager chatMessageDBManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatMessageDBManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = chatMessageDBManager;
            this.msgs = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.android.imsdk.db.CursorParse
        public ArrayList<ChatMsg> getResult() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.msgs;
            }
            return (ArrayList) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.db.CursorParse
        public void parseCursor(Cursor cursor) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cursor) == null) && cursor != null) {
                while (cursor.moveToNext()) {
                    ChatMsg constructChatMsg = this.this$0.constructChatMsg(cursor);
                    if (constructChatMsg != null) {
                        this.msgs.add(constructChatMsg);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class ChatSessionListParse implements CursorParse {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<ChatSession> sessions;
        public final /* synthetic */ ChatMessageDBManager this$0;

        public ChatSessionListParse(ChatMessageDBManager chatMessageDBManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatMessageDBManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = chatMessageDBManager;
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
                    ChatSession constructChatRecord = this.this$0.constructChatRecord(cursor);
                    if (constructChatRecord != null) {
                        this.sessions.add(constructChatRecord);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class SingleChatMsgParse implements CursorParse {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ChatMsg msg;
        public final /* synthetic */ ChatMessageDBManager this$0;

        public SingleChatMsgParse(ChatMessageDBManager chatMessageDBManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatMessageDBManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = chatMessageDBManager;
            this.msg = null;
        }

        @Override // com.baidu.android.imsdk.db.CursorParse
        public void parseCursor(Cursor cursor) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cursor) == null) && cursor != null && cursor.moveToNext()) {
                this.msg = this.this$0.constructChatMsg(cursor);
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
        public final /* synthetic */ ChatMessageDBManager this$0;

        public SingleChatSessionParse(ChatMessageDBManager chatMessageDBManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatMessageDBManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = chatMessageDBManager;
            this.session = null;
        }

        @Override // com.baidu.android.imsdk.db.CursorParse
        public void parseCursor(Cursor cursor) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cursor) == null) && cursor != null && cursor.moveToNext()) {
                this.session = this.this$0.constructChatRecord(cursor);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(310143505, "Lcom/baidu/android/imsdk/chatmessage/db/ChatMessageDBManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(310143505, "Lcom/baidu/android/imsdk/chatmessage/db/ChatMessageDBManager;");
                return;
            }
        }
        UNUPDATE_SESSION_MSG_TYPES = Arrays.asList(2012, 2014, 2001, 36);
    }

    private ChatSession creatTopAndNullHudongSession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            ChatSession chatSession = new ChatSession(0, -1L, -1L, "互动消息");
            chatSession.setMarkTop(1);
            chatSession.setMarkTopTime(9223372036854765807L);
            chatSession.setChatType(19);
            chatSession.setClassType(11);
            chatSession.setLastMsg("暂无互动消息，快和朋友互动起来吧>");
            chatSession.setIsClicked(1);
            TaskManager.getInstance(this.mContext).submitForLocalOperation(new Runnable(this, chatSession) { // from class: com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChatMessageDBManager this$0;
                public final /* synthetic */ ChatSession val$hudongSession;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, chatSession};
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
                    this.val$hudongSession = chatSession;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.updateChatSession(0, this.val$hudongSession);
                    }
                }
            });
            return chatSession;
        }
        return (ChatSession) invokeV.objValue;
    }

    public long deleteExpiredDupMsgs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    LogUtils.e(TAG, "deleteExpiredDupMsgs db is null!");
                    return -1L;
                }
                try {
                    return openDatabase.delete(TableDefine.DB_TABLE_NO_DUPLICATE_MESSAGE, "input_time < ?", new String[]{String.valueOf(System.currentTimeMillis() - 259200)});
                } catch (Exception e) {
                    LogUtils.e(TAG, "deleteExpiredDupMsgs :", e);
                    return -1L;
                }
            }
        }
        return invokeV.longValue;
    }

    public long deleteExpiredReliableMsgs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    LogUtils.e(TAG, "deleteExpiredReliableMsgs db is null!");
                    return -1L;
                }
                try {
                    return openDatabase.delete(TableDefine.DB_TABLE_RELIABLE_MESSAGE, "create_time < ?", new String[]{String.valueOf((System.currentTimeMillis() / 1000) - CAST_RELIABLE_MSG_EXPIRED_TIME)});
                } catch (Exception e) {
                    LogUtils.e(TAG, "deleteExpiredReliableMsgs :", e);
                    return -1L;
                }
            }
        }
        return invokeV.longValue;
    }

    public long deleteStudioUsePaMsgs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    LogUtils.e(TAG, "deleteStudioUsePaMsgs db is null!");
                    return -1L;
                }
                try {
                    return openDatabase.delete(TableDefine.DB_TABLE_STUDIO_USE_PA_MESSAGE, "input_time < ?", new String[]{String.valueOf(System.currentTimeMillis() - 172800000)});
                } catch (Exception e) {
                    LogUtils.e(TAG, "deleteStudioUsePaMsgs :", e);
                    return -1L;
                }
            }
        }
        return invokeV.longValue;
    }

    public ArrayList<SessionClass> getAllClassType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            ArrayList<SessionClass> arrayList = new ArrayList<>();
            List<ChatSession> sessionListInternal = getSessionListInternal("classtype > 1 ", null, "classtype", null, null, null);
            if (sessionListInternal != null && sessionListInternal.size() > 0) {
                for (ChatSession chatSession : sessionListInternal) {
                    SessionClass sessionClass = new SessionClass();
                    sessionClass.setType(chatSession.getClassType());
                    sessionClass.setTitle(chatSession.getClassTitle());
                    sessionClass.setAvatarurl(chatSession.getClassAvatar());
                    sessionClass.setShow(chatSession.getShow());
                    arrayList.add(sessionClass);
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ChatMessageDBManager(Context context) {
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
        setContext(context);
    }

    private long getContacter(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, this, chatMsg)) == null) {
            if (chatMsg == null) {
                return -1L;
            }
            return chatMsg.getContacter();
        }
        return invokeL.longValue;
    }

    public static ChatMessageDBManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            if (mInstance == null) {
                synchronized (ChatMessageDBManager.class) {
                    if (mInstance == null) {
                        mInstance = new ChatMessageDBManager(context);
                    }
                }
            }
            return mInstance;
        }
        return (ChatMessageDBManager) invokeL.objValue;
    }

    private int setMsgRead(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65586, this, j)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_read", (Integer) 1);
            return updateChatMsgInternal(contentValues, "msgid = ?", new String[]{String.valueOf(j)});
        }
        return invokeJ.intValue;
    }

    public ChatMsg getChatMsgByMsgId(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048616, this, j)) == null) {
            return getChatMsgInternal("msgid=? AND status=?", new String[]{String.valueOf(j), String.valueOf(0)});
        }
        return (ChatMsg) invokeJ.objValue;
    }

    public ChatMsg getMsgByMsgId(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048630, this, j)) == null) {
            return getChatMsgInternal("msgid = ?", new String[]{String.valueOf(j)}, null, null, null, String.valueOf(1));
        }
        return (ChatMsg) invokeJ.objValue;
    }

    public int getNewMsgCountOfClass(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048632, this, i)) == null) {
            return getNewMsgCount("classtype = " + i);
        }
        return invokeI.intValue;
    }

    public int markMsgClicked(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, chatMsg)) == null) {
            if (1 == chatMsg.getCategory()) {
                return GroupMessageDAOImpl.markMsgClicked(this.mContext, chatMsg);
            }
            return markChatMsgClicked(chatMsg);
        }
        return invokeL.intValue;
    }

    public void updateSessionClass(PaInfo paInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, paInfo) == null) {
            updateChatRecordInternal(setSessionClassParam(paInfo, getChatRecord(new ChatObject(this.mContext, 0, paInfo.getPaId(), -1L, -1))));
        }
    }

    private int delChatMsgInternal(String str, String[] strArr) {
        InterceptResult invokeLL;
        int delete;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, str, strArr)) == null) {
            synchronized (DBBase.mSyncLock) {
                delete = delete("message", str, strArr);
                if (delete > 0) {
                    delete(TableDefine.DB_TABLE_MESSAGE_WITH_TAG, str, strArr);
                }
            }
            return delete;
        }
        return invokeLL.intValue;
    }

    private int delChatRecordInternal(String str, String[] strArr) {
        InterceptResult invokeLL;
        int delete;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, str, strArr)) == null) {
            synchronized (DBBase.mSyncLock) {
                delete = delete(TableDefine.DB_TABLE_CHAT_SESSION, str, strArr);
            }
            return delete;
        }
        return invokeLL.intValue;
    }

    private ChatMsg getChatMsgInternal(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, this, str, strArr)) == null) {
            SingleChatMsgParse singleChatMsgParse = new SingleChatMsgParse();
            synchronized (DBBase.mSyncLock) {
                query("message", null, str, strArr, null, null, null, singleChatMsgParse);
            }
            return singleChatMsgParse.getResult();
        }
        return (ChatMsg) invokeLL.objValue;
    }

    private ChatSession getChatRecordInternal(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, this, str, strArr)) == null) {
            SingleChatSessionParse singleChatSessionParse = new SingleChatSessionParse();
            synchronized (DBBase.mSyncLock) {
                query(TableDefine.DB_TABLE_CHAT_SESSION, null, str, strArr, null, null, null, singleChatSessionParse);
            }
            return singleChatSessionParse.getResult();
        }
        return (ChatSession) invokeLL.objValue;
    }

    private List<ChatSession> getSessionListInternal(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65569, this, str, strArr)) == null) {
            ChatSessionListParse chatSessionListParse = new ChatSessionListParse();
            synchronized (DBBase.mSyncLock) {
                query(TableDefine.DB_TABLE_CHAT_SESSION, null, str, strArr, null, null, null, chatSessionListParse);
            }
            return chatSessionListParse.getResult();
        }
        return (List) invokeLL.objValue;
    }

    private void notifyDbChange(int i, ChatSession chatSession) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(65582, this, i, chatSession) != null) || chatSession == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(chatSession);
        super.notifyDbChange(0, i, arrayList, true);
    }

    public ChatMsg fetchMsg(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, str, str2)) == null) {
            return getChatMsgInternal("contacter = ? AND _id = ?  AND status = ?", new String[]{str2, str, String.valueOf(2)});
        }
        return (ChatMsg) invokeLL.objValue;
    }

    public ArrayList<ChatMsg> getUnreadMinNotificationMsg(SparseArray<List<Integer>> sparseArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048645, this, sparseArray, i)) == null) {
            return fetchPaUnreadMsgByPaids(new ArrayList(PaInfoDBManager.getInstance(this.mContext).getPaidListByPainfos(sparseArray)), i);
        }
        return (ArrayList) invokeLI.objValue;
    }

    public boolean isRecordExist(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048647, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (getChatRecord(i, j) != null) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public int setMsgContent(long j, String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048654, this, j, str)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("content", str);
            return updateChatMsgInternal(contentValues, "msgid = ?", new String[]{String.valueOf(j)});
        }
        return invokeJL.intValue;
    }

    private long addMsg(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, chatMsg)) == null) {
            if (chatMsg == null) {
                return -1L;
            }
            if (chatMsg.getCategory() != 0 && 1 != chatMsg.getCategory() && 2 != chatMsg.getCategory()) {
                return -1L;
            }
            int status = chatMsg.getStatus();
            if (status == 1 && chatMsg.getRowId() != -1) {
                LogUtils.d(TAG, "tiaoshi not insert for: status=sending rowid != -1");
                return -1L;
            } else if (status != 1 && status != 3 && isMsgExist(chatMsg)) {
                LogUtils.d(TAG, "tiaoshi not exception path!");
                return -2L;
            } else {
                return insertChatMsgInternal(contructChatMsgValues(chatMsg), Utility.getSeekUpdateMsgValueWithKey(chatMsg, IMConstants.MSG_TOPIC_SOURCE));
            }
        }
        return invokeL.longValue;
    }

    private int deleteDraftMsgForSingle(ChatObject chatObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, chatObject)) == null) {
            synchronized (DBBase.mSyncLock) {
                int delChatMsgInternal = delChatMsgInternal("category=? AND contacter=? AND status=?", new String[]{String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter()), String.valueOf(3)});
                if (delChatMsgInternal <= 0) {
                    return delChatMsgInternal;
                }
                ArrayList<ChatMsg> fetchMsg = getInstance(this.mContext).fetchMsg(chatObject, 0L, 2L);
                ChatMsg chatMsg = null;
                if (fetchMsg != null && fetchMsg.size() > 0) {
                    chatMsg = fetchMsg.get(0);
                }
                updateSession(true, getChatRecord(chatObject), chatMsg);
                return delChatMsgInternal;
            }
        }
        return invokeL.intValue;
    }

    private ChatMsg generateStudioUsePaMsg(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, this, cursor)) == null) {
            long j = CursorWrapper.getLong(cursor, "msgid");
            int i = CursorWrapper.getInt(cursor, "type");
            long j2 = CursorWrapper.getLong(cursor, "from_user");
            long j3 = CursorWrapper.getLong(cursor, "input_time");
            int i2 = CursorWrapper.getInt(cursor, "category");
            long j4 = CursorWrapper.getLong(cursor, "contacter");
            String string = CursorWrapper.getString(cursor, "msg_key");
            String string2 = CursorWrapper.getString(cursor, "content");
            int i3 = CursorWrapper.getInt(cursor, "is_read");
            ChatMsg newChatMsg = ChatMsgFactory.getInstance().newChatMsg(this.mContext, i2, i, -1);
            if (newChatMsg == null) {
                return null;
            }
            newChatMsg.setCategory(i2);
            newChatMsg.setContacter(j4);
            newChatMsg.setFromUser(j2);
            newChatMsg.setMsgContent(string2);
            newChatMsg.setMsgId(j);
            newChatMsg.setMsgKey(string);
            newChatMsg.setMsgTime(j3);
            newChatMsg.setMsgReaded(i3);
            return newChatMsg;
        }
        return (ChatMsg) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
        if (r3 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004e, code lost:
        if (r3 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0052, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int getNewMsgCount(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, this, str)) == null) {
            synchronized (DBBase.mSyncLock) {
                int i = -1;
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    return -1;
                }
                Cursor cursor = null;
                try {
                    String str2 = "select sum(new_msg_sum) from chatrecord";
                    if (!TextUtils.isEmpty(str)) {
                        str2 = "select sum(new_msg_sum) from chatrecord where " + str;
                    }
                    cursor = openDatabase.rawQuery(str2, null);
                    if (cursor != null && cursor.moveToNext()) {
                        i = cursor.getInt(0);
                    }
                } catch (Exception e) {
                    LogUtils.e(TAG, " getNewMsgCount:", e);
                }
            }
        } else {
            return invokeL.intValue;
        }
    }

    private List<Long> getUnreadContacterByChatTypes(List<Integer> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                List<ChatSession> sessionListInternal = getSessionListInternal("chat_type" + buildINStatement(list) + " AND new_msg_sum>0", null);
                if (sessionListInternal != null) {
                    for (ChatSession chatSession : sessionListInternal) {
                        arrayList.add(Long.valueOf(chatSession.getContacter()));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    private int updateMsgStatusForSingle(ChatMsg chatMsg) {
        InterceptResult invokeL;
        int updateChatMsgInternal;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65592, this, chatMsg)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("msgid", Long.valueOf(chatMsg.getMsgId()));
            contentValues.put("status", Integer.valueOf(chatMsg.getStatus()));
            contentValues.put("auto_risk_control_status", Integer.valueOf(chatMsg.getAutoRiskControlStatus()));
            contentValues.put("content", chatMsg.getJsonContent());
            contentValues.put("time", Long.valueOf(chatMsg.getMsgTime()));
            contentValues.put("tips_code", Integer.valueOf(chatMsg.getTipsCode()));
            contentValues.put("tips", chatMsg.getTips());
            synchronized (DBBase.mSyncLock) {
                updateChatMsgInternal = updateChatMsgInternal(contentValues, "_id = ?", new String[]{String.valueOf(chatMsg.getRowId())});
                if (updateChatMsgInternal >= 0) {
                    updateChatSession(chatMsg);
                }
            }
            return updateChatMsgInternal;
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0063, code lost:
        if (r2 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0065, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0073, code lost:
        if (r2 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0079, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long getMaxReliableMsgId(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048629, this, j)) == null) {
            String str = "select max(msgid) as max_msg_id from " + TableDefine.DB_TABLE_RELIABLE_MESSAGE + " where mcast_id = " + j;
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    LogUtils.e(TAG, "getMaxReliableMsgId db is null!");
                    return -1L;
                }
                Cursor cursor = null;
                try {
                    cursor = openDatabase.rawQuery(str, null);
                    if (cursor != null && cursor.moveToNext()) {
                        long j2 = cursor.getLong(cursor.getColumnIndex("max_msg_id"));
                        if (cursor != null) {
                            cursor.close();
                        }
                        return j2;
                    }
                } catch (Exception e) {
                    LogUtils.e(TAG, "getMaxReliableMsgId:", e);
                }
            }
        } else {
            return invokeJ.longValue;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x007c, code lost:
        if (0 == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007f, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isToastShowing(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048648, this, str)) == null) {
            LogUtils.e(TAG, "isToastShowing msgKey :" + str);
            SQLiteDatabase openDatabase = openDatabase();
            boolean z = false;
            if (openDatabase == null) {
                LogUtils.e(TAG, "isToastShowing db is null!");
                return false;
            }
            Cursor cursor = null;
            try {
                try {
                    String[] strArr = {str};
                    String str2 = "select * from message where msg_key = ?";
                    synchronized (DBBase.mSyncLock) {
                        cursor = openDatabase.rawQuery(str2, strArr);
                    }
                    if (cursor != null && cursor.moveToNext()) {
                        z = true;
                    }
                    LogUtils.d(TAG, "isToastShowing + " + z);
                } catch (Exception e) {
                    LogUtils.e(TAG, "isToastShowing:", e);
                }
            } finally {
                if (0 != 0) {
                    cursor.close();
                }
            }
        } else {
            return invokeL.booleanValue;
        }
    }

    public void updateChatSession(ChatMsg chatMsg) {
        ArrayList<ChatMsg> fetchMsgExcludeTypes;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, chatMsg) == null) {
            ChatObject chatObject = new ChatObject(this.mContext, chatMsg.getCategory(), chatMsg.getContacter(), chatMsg.getPaid(), chatMsg.getChatType());
            ChatSession chatRecord = getChatRecord(chatObject);
            boolean z = false;
            if (!MsgUtility.isDraftMsg(chatMsg)) {
                if (chatRecord == null || chatRecord.getState() != 3) {
                    if (1 == chatMsg.getCategory()) {
                        fetchMsgExcludeTypes = GroupMessageDAOImpl.fetchAllChatMsg(this.mContext, String.valueOf(chatMsg.getContacter()), null, 1L, true);
                    } else {
                        fetchMsgExcludeTypes = getInstance(this.mContext).fetchMsgExcludeTypes(chatObject, 0L, 1L, UNUPDATE_SESSION_MSG_TYPES);
                    }
                    if (fetchMsgExcludeTypes != null && fetchMsgExcludeTypes.size() > 0) {
                        int chatType = chatMsg.getChatType();
                        ChatMsg chatMsg2 = fetchMsgExcludeTypes.get(0);
                        chatMsg2.setChatType(chatType);
                        chatMsg = chatMsg2;
                    } else {
                        chatMsg = null;
                    }
                }
                updateSession(z, chatRecord, chatMsg);
            }
            z = true;
            updateSession(z, chatRecord, chatMsg);
        }
    }

    public int updateChatSessionAfterClearMsg(ChatObject chatObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048665, this, chatObject)) == null) {
            String[] strArr = {String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter())};
            ChatSession chatRecord = getChatRecord(chatObject);
            if (chatRecord == null) {
                return 0;
            }
            ChatMsg draftMsgForSingle = getDraftMsgForSingle(chatObject.getCategory(), chatObject.getContacter());
            ContentValues contentValues = new ContentValues();
            if (chatRecord.getState() != 3 || draftMsgForSingle == null) {
                contentValues.put("last_msg", "");
                contentValues.put("last_msg_name", "");
                contentValues.put("msg_state", (Integer) 0);
                contentValues.put("remind_type", (Integer) 0);
                contentValues.put("new_msg_sum", (Integer) 0);
                contentValues.put("remind_msgid", (Integer) 0);
                contentValues.put("remind_uid", (Integer) 0);
                contentValues.put("remind_role_display_name", "");
                contentValues.put("highlight_desc", "");
                contentValues.put("highlight_priority", (Integer) 0);
                contentValues.put("last_msgid_from_me", (Integer) 0);
                contentValues.put("highlight_data_id", (Integer) 0);
            }
            return updateChatRecordInternalAndNotify(contentValues, "category = ? AND contacter = ?", strArr, 1);
        }
        return invokeL.intValue;
    }

    public void updateSessionClassAndNotify(List<PaInfo> list) {
        ChatSession chatRecord;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048676, this, list) == null) && list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (PaInfo paInfo : list) {
                if (paInfo != null && (chatRecord = getChatRecord(new ChatObject(this.mContext, 0, paInfo.getPaId(), -1L, -1))) != null) {
                    int mapType = chatRecord.getMapType();
                    if (updateChatRecordInternal(setSessionClassParam(paInfo, chatRecord)) > 0 && paInfo.getMapType() == 1 && paInfo.getMapType() != mapType) {
                        arrayList.add(chatRecord);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                notifyDbChange(2, arrayList);
            }
        }
    }

    private long addReliableMsg(@NonNull TextMsg textMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, textMsg)) == null) {
            SQLiteDatabase openDatabase = openDatabase();
            try {
                if (openDatabase == null) {
                    LogUtils.e(TAG, "addReliableMsg db is null!");
                    return -1L;
                } else if (isReliableMsgExist(openDatabase, textMsg)) {
                    String str = TAG;
                    LogUtils.d(str, "addReliableMsg exist msgId = " + textMsg.getMsgId() + ", or msgKey :" + textMsg.getMsgKey());
                    return -1L;
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("msgid", Long.valueOf(textMsg.getMsgId()));
                    contentValues.put("category", Integer.valueOf(textMsg.getCategory()));
                    contentValues.put("type", Integer.valueOf(textMsg.getRealMsgType()));
                    contentValues.put("from_user", Long.valueOf(textMsg.getFromUser()));
                    contentValues.put("create_time", Long.valueOf(textMsg.getMsgTime()));
                    contentValues.put("mcast_id", Long.valueOf(textMsg.getCastId()));
                    contentValues.put("msg_key", textMsg.getMsgKey());
                    contentValues.put("is_read", Boolean.valueOf(textMsg.isMsgRead()));
                    contentValues.put("priority", Long.valueOf(textMsg.getPriority()));
                    contentValues.put("contacter", Long.valueOf(textMsg.getContacter()));
                    return openDatabase.insert(TableDefine.DB_TABLE_RELIABLE_MESSAGE, null, contentValues);
                }
            } catch (Exception e) {
                String str2 = TAG;
                LogUtils.d(str2, "addReliableMsg:" + e);
                return -1L;
            }
        }
        return invokeL.longValue;
    }

    private int delMsgsOfPaByPaId(long j) {
        InterceptResult invokeJ;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65551, this, j)) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                int i4 = -1;
                if (openDatabase == null) {
                    LogUtils.d(TAG, "getWritableDb fail!");
                    return -1;
                }
                try {
                    openDatabase.beginTransaction();
                    ChatObject chatObject = new ChatObject(this.mContext, 0, j);
                    String[] strArr = {String.valueOf(j)};
                    if (!TextUtils.isEmpty("from_user = ? ")) {
                        i = delChatMsgInternal("from_user = ? ", strArr);
                        String str = TAG;
                        LogUtils.d(str, "--delMsgsOfPaByPaId--delMsgs = " + i);
                    } else {
                        i = -1;
                    }
                    int delChatRecord = delChatRecord(chatObject);
                    if (!TextUtils.isEmpty("paid = ? ")) {
                        i2 = delete(openDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid = ? ", strArr);
                        String str2 = TAG;
                        LogUtils.d(str2, "--delMsgsOfPaByPaId--delPaInfoRecord = " + i2);
                    } else {
                        i2 = -1;
                    }
                    if (!TextUtils.isEmpty("paid = ? ")) {
                        i3 = delete(openDatabase, TableDefine.DB_TABLE_ZHIDAINFO, "paid = ? ", strArr);
                        String str3 = TAG;
                        LogUtils.d(str3, "--delMsgsOfPaByPaId--delZhiDaPaInfoRecord = " + i3);
                    } else {
                        i3 = -1;
                    }
                    if (i >= 0 || delChatRecord >= 0 || i2 >= 0 || i3 >= 0) {
                        openDatabase.setTransactionSuccessful();
                        i4 = i;
                    }
                    try {
                        openDatabase.endTransaction();
                    } catch (Exception e) {
                        LogUtils.e(TAG, "delMsgsOfPaByPaId finally:", e);
                    }
                    return i4;
                } catch (Exception e2) {
                    LogUtils.e(TAG, "delMsgsOfPaByPaId:", e2);
                    try {
                        openDatabase.endTransaction();
                    } catch (Exception e3) {
                        LogUtils.e(TAG, "delMsgsOfPaByPaId finally:", e3);
                    }
                    return -1;
                }
            }
        }
        return invokeJ.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00c6, code lost:
        if (r3 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00c8, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00d6, code lost:
        if (r3 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00da, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int getAllNewMsgCountNotInGFH(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, this, str)) == null) {
            synchronized (DBBase.mSyncLock) {
                int i = -1;
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    return -1;
                }
                Cursor cursor = null;
                try {
                    cursor = openDatabase.rawQuery("SELECT sum(chatrecord.new_msg_sum) FROM " + TableDefine.DB_TABLE_CHAT_SESSION + " WHERE " + ("chatrecord.contacter IN (" + ("select paSubscribe.paid from " + TableDefine.DB_TABLE_PA_SUBSCRIBE + " where (paSubscribe.subset_type = 16 OR paSubscribe.subset_type = 21 )  AND paSubscribe.pasubtype = 7 ") + ") OR  ( " + str + " ) "), null);
                    if (cursor != null && cursor.moveToNext()) {
                        i = cursor.getInt(0);
                    }
                } catch (Exception e) {
                    LogUtils.e(TAG, " getNewMsgCount:", e);
                }
            }
        } else {
            return invokeL.intValue;
        }
    }

    public int getUnReadMsgCount(ChatObject chatObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, chatObject)) == null) {
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
                    if (chatObject.getTimeInterval() > 0) {
                        str = str + " AND time >= " + TimeUtil.getTimeSecondByInterval(chatObject.getTimeInterval());
                    }
                    cursor = openDatabase.query("message", new String[]{"_id"}, str, strArr, null, null, null);
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

    public long studioMsgAddHandler(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048661, this, chatMsg)) == null) {
            if (chatMsg == null) {
                return -1L;
            }
            if (chatMsg.getChatType() != 20 && chatMsg.getMsgType() == 80) {
                return -1L;
            }
            SQLiteDatabase openDatabase = openDatabase();
            try {
                if (openDatabase == null) {
                    LogUtils.d(TAG, "studioMsgAddHandler getWritableDb fail!");
                    return -1L;
                } else if (existStudioMsg(openDatabase, chatMsg) > 0) {
                    LogUtils.d(TAG, "studioMsgAddHandler isDuplicateMsg = true");
                    return -2L;
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("msgid", Long.valueOf(chatMsg.getMsgId()));
                    contentValues.put("type", Integer.valueOf(chatMsg.getMsgType()));
                    contentValues.put("from_user", Long.valueOf(chatMsg.getFromUser()));
                    contentValues.put("input_time", Long.valueOf(System.currentTimeMillis()));
                    contentValues.put("category", Integer.valueOf(chatMsg.getCategory()));
                    contentValues.put("contacter", Long.valueOf(chatMsg.getContacter()));
                    contentValues.put("msg_key", chatMsg.getMsgKey());
                    contentValues.put("content", chatMsg.getMsgContent());
                    contentValues.put("is_read", Boolean.valueOf(chatMsg.isMsgRead()));
                    return openDatabase.insert(TableDefine.DB_TABLE_STUDIO_USE_PA_MESSAGE, null, contentValues);
                }
            } catch (Exception e) {
                LogUtils.e(TAG, "studioMsgAddHandler :", e);
                return -1L;
            }
        }
        return invokeL.longValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0283 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0285  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChatMsg constructChatMsg(Cursor cursor) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        int i;
        String str;
        String str2;
        boolean z3;
        String str3;
        String str4;
        JSONObject optJSONObject;
        JSONObject jSONObject;
        String jSONObject2;
        ChatMsg newChatMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, cursor)) == null) {
            int i2 = CursorWrapper.getInt(cursor, "_id");
            int i3 = CursorWrapper.getInt(cursor, "type");
            long j = CursorWrapper.getLong(cursor, "from_user");
            long j2 = CursorWrapper.getLong(cursor, "msgid");
            int i4 = CursorWrapper.getInt(cursor, "auto_risk_control_status");
            long j3 = CursorWrapper.getLong(cursor, "time");
            int i5 = CursorWrapper.getInt(cursor, "is_read");
            int i6 = CursorWrapper.getInt(cursor, "status");
            String string = CursorWrapper.getString(cursor, "content");
            int i7 = CursorWrapper.getInt(cursor, "category");
            long j4 = CursorWrapper.getLong(cursor, "contacter");
            int i8 = CursorWrapper.getInt(cursor, "cmd");
            String string2 = CursorWrapper.getString(cursor, "local_url");
            if (CursorWrapper.getInt(cursor, TableDefine.MessageColumns.COLUMN_ISZHIDA) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (CursorWrapper.getInt(cursor, "isclicked") == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z4 = z2;
            long j5 = CursorWrapper.getLong(cursor, "paid");
            int i9 = CursorWrapper.getInt(cursor, "device_flag");
            String string3 = CursorWrapper.getString(cursor, "sendid");
            String string4 = CursorWrapper.getString(cursor, "buid");
            String string5 = CursorWrapper.getString(cursor, "msg_key");
            long j6 = CursorWrapper.getLong(cursor, "expires_time");
            String string6 = CursorWrapper.getString(cursor, TableDefine.MessageColumns.COLUME_SERVICE_TYPE);
            int i10 = CursorWrapper.getInt(cursor, "tips_code");
            String string7 = CursorWrapper.getString(cursor, "tips");
            int i11 = CursorWrapper.getInt(cursor, "template_type");
            int i12 = CursorWrapper.getInt(cursor, "send_type");
            int i13 = CursorWrapper.getInt(cursor, "send_scene");
            String string8 = CursorWrapper.getString(cursor, "origin_pa");
            if (i3 == 80) {
                try {
                    int i14 = i3;
                    try {
                        try {
                            JSONObject jSONObject3 = new JSONObject(new JSONObject(new JSONObject(new JSONObject(string).optString("text")).optString("msg")).optString("ext"));
                            int optInt = jSONObject3.optInt("type", -1);
                            try {
                                if (optInt == 1) {
                                    JSONObject jSONObject4 = new JSONObject();
                                    jSONObject4.put("text", jSONObject3.optString("body"));
                                    jSONObject2 = jSONObject4.toString();
                                } else if (optInt == 0) {
                                    if (jSONObject3.has("content") && !jSONObject3.has("body")) {
                                        JSONObject jSONObject5 = new JSONObject();
                                        jSONObject5.put("text", new JSONObject(jSONObject3.optString("content")).optString("text"));
                                        jSONObject2 = jSONObject5.toString();
                                    } else {
                                        JSONArray jSONArray = new JSONArray(jSONObject3.optString("body"));
                                        int length = jSONArray.length();
                                        str2 = string8;
                                        str = string6;
                                        int i15 = 1;
                                        if (length == 1) {
                                            z3 = z;
                                            try {
                                                optJSONObject = jSONArray.optJSONObject(0);
                                                jSONObject = new JSONObject();
                                                i = i2;
                                            } catch (Exception e) {
                                                e = e;
                                                i = i2;
                                            }
                                            try {
                                                jSONObject.put("title", optJSONObject.optString("title"));
                                                jSONObject.put("article_url", optJSONObject.optString("url"));
                                                jSONObject.put(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, optJSONObject.optString("headImage"));
                                                str3 = jSONObject.toString();
                                                i15 = 1;
                                                i14 = 8;
                                            } catch (Exception e2) {
                                                e = e2;
                                                string = string;
                                                i3 = 8;
                                                LogUtils.e(TAG, "du construChatMsg:", e);
                                                newChatMsg = ChatMsgFactory.getInstance().newChatMsg(this.mContext, i7, i3, i8);
                                                if (newChatMsg != null) {
                                                }
                                            }
                                        } else {
                                            i = i2;
                                            z3 = z;
                                            str3 = string;
                                        }
                                        if (length > i15) {
                                            i14 = 9;
                                            try {
                                                JSONArray jSONArray2 = new JSONArray();
                                                int i16 = 0;
                                                while (i16 < length) {
                                                    int i17 = length;
                                                    JSONObject optJSONObject2 = jSONArray.optJSONObject(i16);
                                                    JSONArray jSONArray3 = jSONArray;
                                                    JSONObject jSONObject6 = new JSONObject();
                                                    str4 = str3;
                                                    try {
                                                        jSONObject6.put("title", optJSONObject2.optString("title"));
                                                        jSONObject6.put("article_url", optJSONObject2.optString("url"));
                                                        jSONObject6.put(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, optJSONObject2.optString("headImage"));
                                                        jSONArray2.put(jSONObject6);
                                                        i16++;
                                                        length = i17;
                                                        str3 = str4;
                                                        jSONArray = jSONArray3;
                                                    } catch (Exception e3) {
                                                        e = e3;
                                                        string = str4;
                                                        i3 = 9;
                                                        LogUtils.e(TAG, "du construChatMsg:", e);
                                                        newChatMsg = ChatMsgFactory.getInstance().newChatMsg(this.mContext, i7, i3, i8);
                                                        if (newChatMsg != null) {
                                                        }
                                                    }
                                                }
                                                str4 = str3;
                                                JSONObject jSONObject7 = new JSONObject();
                                                jSONObject7.put("articles", jSONArray2);
                                                str3 = jSONObject7.toString();
                                            } catch (Exception e4) {
                                                e = e4;
                                                str4 = str3;
                                            }
                                        }
                                        string = str3;
                                        i3 = i14;
                                    }
                                } else {
                                    i = i2;
                                    str = string6;
                                    str2 = string8;
                                    z3 = z;
                                    try {
                                        string = jSONObject3.optString("content");
                                        i3 = optInt;
                                    } catch (Exception e5) {
                                        e = e5;
                                        i3 = optInt;
                                        string = string;
                                        LogUtils.e(TAG, "du construChatMsg:", e);
                                        newChatMsg = ChatMsgFactory.getInstance().newChatMsg(this.mContext, i7, i3, i8);
                                        if (newChatMsg != null) {
                                        }
                                    }
                                }
                                string = jSONObject2;
                                i = i2;
                                str = string6;
                                str2 = string8;
                                z3 = z;
                                i3 = 0;
                            } catch (Exception e6) {
                                e = e6;
                                i = i2;
                                str = string6;
                                str2 = string8;
                                z3 = z;
                                string = string;
                                i3 = 0;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            i = i2;
                            str = string6;
                            str2 = string8;
                            z3 = z;
                            i3 = i14;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        i = i2;
                        str = string6;
                        str2 = string8;
                        z3 = z;
                        i3 = i14;
                    }
                } catch (Exception e9) {
                    e = e9;
                    i = i2;
                    str = string6;
                    str2 = string8;
                    z3 = z;
                }
            } else {
                i = i2;
                str = string6;
                str2 = string8;
                z3 = z;
            }
            newChatMsg = ChatMsgFactory.getInstance().newChatMsg(this.mContext, i7, i3, i8);
            if (newChatMsg != null) {
                return null;
            }
            newChatMsg.setCategory(i7);
            newChatMsg.setContacter(j4);
            newChatMsg.setFromUser(j);
            newChatMsg.setMsgContent(string);
            newChatMsg.setRowId(i);
            newChatMsg.setMsgId(j2);
            newChatMsg.setAutoRiskControlStatus(i4);
            newChatMsg.setMsgTime(j3);
            newChatMsg.setMsgReaded(i5);
            newChatMsg.setStatus(i6);
            newChatMsg.setCategory(i7);
            newChatMsg.setContacter(j4);
            newChatMsg.setNotifyCmd(i8);
            newChatMsg.setLocalUrl(string2);
            newChatMsg.setIsZhida(z3);
            newChatMsg.setIsClicked(z4);
            newChatMsg.setPaid(j5);
            newChatMsg.setMsgType(i3);
            newChatMsg.setDeviceFlag(i9);
            newChatMsg.setSendMsgId(string3);
            newChatMsg.setSenderUid(string4);
            newChatMsg.setMsgKey(string5);
            newChatMsg.setExpiresTime(j6);
            newChatMsg.setServiceType(str);
            newChatMsg.setTipsCode(i10);
            newChatMsg.setTips(string7);
            newChatMsg.setTemplateType(i11);
            newChatMsg.setSendType(i12);
            newChatMsg.setSendScene(i13);
            newChatMsg.setOriginPa(str2);
            return newChatMsg;
        }
        return (ChatMsg) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChatSession constructChatRecord(Cursor cursor) {
        InterceptResult invokeL;
        int i;
        int i2;
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        String senderUid;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, cursor)) == null) {
            if (cursor == null) {
                return null;
            }
            int i3 = CursorWrapper.getInt(cursor, "category");
            long j11 = CursorWrapper.getLong(cursor, "contacter");
            String string = CursorWrapper.getString(cursor, "name");
            String string2 = CursorWrapper.getString(cursor, "last_msg");
            long j12 = CursorWrapper.getLong(cursor, "last_msg_time");
            long j13 = CursorWrapper.getLong(cursor, TableDefine.SessionColumns.COLUMN_LAST_OPEN_TIME);
            long j14 = CursorWrapper.getInt(cursor, "new_msg_sum");
            int i4 = CursorWrapper.getInt(cursor, "show");
            int i5 = CursorWrapper.getInt(cursor, TableDefine.SessionColumns.COLUMN_COLLECTION_TYPE);
            int i6 = CursorWrapper.getInt(cursor, "chat_type");
            String string3 = CursorWrapper.getString(cursor, "icon_url");
            int i7 = CursorWrapper.getInt(cursor, "msg_state");
            int i8 = CursorWrapper.getInt(cursor, "isclicked");
            long j15 = CursorWrapper.getLong(cursor, "paid");
            int i9 = CursorWrapper.getInt(cursor, "classtype");
            int i10 = CursorWrapper.getInt(cursor, "classshow");
            String string4 = CursorWrapper.getString(cursor, "classtitle");
            String string5 = CursorWrapper.getString(cursor, "classavatar");
            int i11 = CursorWrapper.getInt(cursor, "marktop");
            long j16 = CursorWrapper.getLong(cursor, "marktoptime");
            String string6 = CursorWrapper.getString(cursor, "nickname");
            String string7 = CursorWrapper.getString(cursor, "extra");
            String string8 = CursorWrapper.getString(cursor, "v_portrait");
            String string9 = CursorWrapper.getString(cursor, "certification");
            String string10 = CursorWrapper.getString(cursor, "vip_id");
            int i12 = CursorWrapper.getInt(cursor, "shield");
            long j17 = CursorWrapper.getLong(cursor, "shield_time");
            long j18 = CursorWrapper.getLong(cursor, "last_msg_bduid");
            String string11 = CursorWrapper.getString(cursor, "last_msg_name");
            int i13 = CursorWrapper.getInt(cursor, "disturb");
            int i14 = CursorWrapper.getInt(cursor, "is_stranger");
            int i15 = CursorWrapper.getInt(cursor, "map_type");
            int i16 = CursorWrapper.getInt(cursor, "remind_type");
            long j19 = CursorWrapper.getLong(cursor, "remind_msgid");
            long j20 = CursorWrapper.getLong(cursor, "remind_uid");
            String string12 = CursorWrapper.getString(cursor, "remind_role_display_name");
            String string13 = CursorWrapper.getString(cursor, "highlight_desc");
            int i17 = CursorWrapper.getInt(cursor, "highlight_priority");
            int i18 = CursorWrapper.getInt(cursor, "highlight_data_id");
            long j21 = CursorWrapper.getLong(cursor, "last_msgid_from_me");
            if (i3 == 0 && i6 == 0) {
                long buidByUK = IMUserManager.getInstance(this.mContext).getBuidByUK(j11);
                if (buidByUK < 0 && !TextUtils.isEmpty(string2)) {
                    i = i6;
                    i2 = i5;
                    j = j14;
                    j2 = j13;
                    j3 = j15;
                    j4 = j16;
                    j5 = j17;
                    j6 = j18;
                    j7 = j19;
                    j8 = j20;
                    j9 = j21;
                    ArrayList<ChatMsg> fetchMessageSync = ChatMsgManagerImpl.getInstance(this.mContext).fetchMessageSync(0, j11, 1, (ChatMsg) null);
                    if (fetchMessageSync != null && fetchMessageSync.size() > 0) {
                        Iterator<ChatMsg> it = fetchMessageSync.iterator();
                        while (it.hasNext()) {
                            ChatMsg next = it.next();
                            if (next != null) {
                                if (AccountManager.getUid(this.mContext).equals(next.getSenderUid())) {
                                    senderUid = next.getToBduid();
                                } else {
                                    senderUid = next.getSenderUid();
                                }
                                j10 = Utility.getLongByString(senderUid, 0L);
                            }
                        }
                    }
                } else {
                    i = i6;
                    i2 = i5;
                    j = j14;
                    j2 = j13;
                    j3 = j15;
                    j4 = j16;
                    j5 = j17;
                    j6 = j18;
                    j7 = j19;
                    j8 = j20;
                    j9 = j21;
                }
                j10 = buidByUK;
            } else {
                i = i6;
                i2 = i5;
                j = j14;
                j2 = j13;
                j3 = j15;
                j4 = j16;
                j5 = j17;
                j6 = j18;
                j7 = j19;
                j8 = j20;
                j9 = j21;
                j10 = j11;
            }
            ChatSession chatSession = new ChatSession(i3, j11, j10, string);
            if (0 != j11) {
                chatSession.setLastMsg(string2);
                chatSession.setLastMsgTime(j12);
                chatSession.setLastOpenTime(j2);
                long j22 = j;
                chatSession.setNewMsgSum(j22);
                chatSession.setShow(i4);
                chatSession.setCollectionType(i2);
                chatSession.setChatType(i);
                chatSession.setIconUrl(string3);
                chatSession.setState(i7);
                chatSession.setIsClicked(i8);
                chatSession.setPaid(j3);
                chatSession.setClassType(i9);
                chatSession.setClassTitle(string4);
                chatSession.setClassAvatar(string5);
                chatSession.setClassShow(i10);
                chatSession.setMarkTop(i11);
                chatSession.setMarkTopTime(j4);
                chatSession.setNickName(string6);
                chatSession.setExt(string7);
                chatSession.setVPortrait(string8);
                chatSession.setCertification(string9);
                chatSession.setVipId(string10);
                chatSession.setShield(i12);
                chatSession.setShieldTime(j5);
                chatSession.setLastMsgUid(j6);
                chatSession.setLastMsgName(string11);
                chatSession.setDisturb(i13);
                chatSession.setIsStranger(i14);
                chatSession.setSessionFrom(0);
                chatSession.setMapType(i15);
                chatSession.setLastMsgidFromMe(j9);
                chatSession.setHighlightPriority(i17);
                chatSession.setHighlightDataId(i18);
                chatSession.setHighlightDesc(string13);
                if (j22 > 0) {
                    long j23 = j7;
                    if ((System.currentTimeMillis() * 1000) - j23 < IMConstants.NANOSECOND_24_HOUR) {
                        chatSession.setRemindType(i16);
                        chatSession.setRemindMsgId(j23);
                        chatSession.setRemindUid(j8);
                        chatSession.setRemindRoleDisplayName(string12);
                    }
                }
            }
            return chatSession;
        }
        return (ChatSession) invokeL.objValue;
    }

    private ContentValues contructChatMsgValues(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, chatMsg)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("msgid", Long.valueOf(chatMsg.getMsgId()));
            contentValues.put("auto_risk_control_status", Integer.valueOf(chatMsg.getAutoRiskControlStatus()));
            contentValues.put("content", chatMsg.getMsgContent());
            contentValues.put("type", Integer.valueOf(chatMsg.getRealMsgType()));
            contentValues.put("from_user", Long.valueOf(chatMsg.getFromUser()));
            contentValues.put("buid", chatMsg.getSenderUid());
            contentValues.put("time", Long.valueOf(chatMsg.getMsgTime()));
            contentValues.put("status", Integer.valueOf(chatMsg.getStatus()));
            contentValues.put("category", Integer.valueOf(chatMsg.getCategory()));
            contentValues.put("contacter", Long.valueOf(chatMsg.getContacter()));
            contentValues.put("is_read", Integer.valueOf(chatMsg.isMsgRead() ? 1 : 0));
            contentValues.put("cmd", Integer.valueOf(chatMsg.getNotifyCmd()));
            if (chatMsg instanceof HtmlMsg) {
                contentValues.put("local_url", chatMsg.getRecommendDescription());
            } else {
                contentValues.put("local_url", chatMsg.getLocalUrl());
            }
            contentValues.put(TableDefine.MessageColumns.COLUMN_ISZHIDA, Integer.valueOf(chatMsg.isZhida() ? 1 : 0));
            contentValues.put("isclicked", Integer.valueOf(chatMsg.isClicked() ? 1 : 0));
            contentValues.put("paid", Long.valueOf(chatMsg.getPaid()));
            contentValues.put("device_flag", Integer.valueOf(chatMsg.getDeviceFlag()));
            contentValues.put("msg_key", chatMsg.getMsgKey());
            contentValues.put("sendid", chatMsg.getSendMsgId());
            contentValues.put("expires_time", Long.valueOf(chatMsg.getExpiresTime()));
            contentValues.put(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, chatMsg.getServiceType());
            contentValues.put("tips_code", Integer.valueOf(chatMsg.getTipsCode()));
            contentValues.put("tips", chatMsg.getTips());
            contentValues.put("template_type", Integer.valueOf(chatMsg.getTemplateType()));
            contentValues.put("send_scene", Integer.valueOf(chatMsg.getSendScene()));
            contentValues.put("send_type", Integer.valueOf(chatMsg.getSendType()));
            contentValues.put("origin_pa", chatMsg.getOriginPa());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    private int delMsgs(long[] jArr) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, jArr)) == null) {
            synchronized (DBBase.mSyncLock) {
                int i2 = -1;
                if (openDatabase() == null) {
                    LogUtils.d(TAG, "getWritableDb fail!");
                    return -1;
                }
                if (jArr != null) {
                    try {
                    } catch (Exception e) {
                        e = e;
                    }
                    if (jArr.length > 0) {
                        try {
                            String[] strArr = new String[2];
                            strArr[1] = String.valueOf(0);
                            i = 0;
                            for (long j : jArr) {
                                try {
                                    strArr[0] = String.valueOf(j);
                                    i += delChatMsgInternal("msgid = ? AND status=?", strArr);
                                } catch (Exception e2) {
                                    e = e2;
                                    i2 = i;
                                    LogUtils.e(TAG, "delMsg:", e);
                                    i = i2;
                                    return i;
                                }
                            }
                            for (long j2 : jArr) {
                                long j3 = j2 + 1;
                                delChatMsgInternal("_id=? AND type in (?, ?, ?)", new String[]{String.valueOf(j3), String.valueOf(2012), String.valueOf(2001), String.valueOf(2014)});
                                LogUtils.e(TAG, "delete notSendButShowTipMsg :, msgId :" + j3);
                            }
                        } catch (Exception e3) {
                            e = e3;
                            i2 = 0;
                        }
                        return i;
                    }
                }
                return -1;
            }
        }
        return invokeL.intValue;
    }

    private boolean isMsgExist(ChatMsg chatMsg) {
        InterceptResult invokeL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, this, chatMsg)) == null) {
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
            if (getChatMsgInternal(sb.toString(), strArr) != null) {
                z = true;
            }
            if (z && chatMsg.getFetchTriggerReason() == 1) {
                TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable(this, chatMsg) { // from class: com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ChatMessageDBManager this$0;
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
                        if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                            return;
                        }
                        this.this$0.updateSingleMsg(this.val$msg);
                    }
                });
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    private int markChatMsgClicked(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, this, chatMsg)) == null) {
            synchronized (DBBase.mSyncLock) {
                if (chatMsg.getRowId() == -1) {
                    chatMsg.setRowId(addMsg(chatMsg));
                }
                if (chatMsg.getRowId() == -1) {
                    return -1;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("isclicked", (Integer) 1);
                int updateChatMsgInternal = updateChatMsgInternal(contentValues, "_id=?", new String[]{"" + chatMsg.getRowId()});
                if (updateChatMsgInternal < 0) {
                    return updateChatMsgInternal;
                }
                ArrayList<ChatMsg> fetchMsg = fetchMsg(new ChatObject(this.mContext, chatMsg.getCategory(), chatMsg.getContacter(), chatMsg.getPaid(), -1), 0L, 1L, -1L);
                if (fetchMsg != null && fetchMsg.size() != 0) {
                    if (chatMsg.getRowId() == fetchMsg.get(0).getRowId()) {
                        updateChatSession(chatMsg);
                    }
                    return updateChatMsgInternal;
                }
                return 1009;
            }
        }
        return invokeL.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int updateSingleMsg(ChatMsg chatMsg) {
        InterceptResult invokeL;
        String[] strArr;
        int updateChatMsgInternal;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65594, this, chatMsg)) == null) {
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
            synchronized (DBBase.mSyncLock) {
                updateChatMsgInternal = updateChatMsgInternal(contructChatMsgValues, sb.toString(), strArr);
                if (updateChatMsgInternal >= 0) {
                    updateChatSession(chatMsg);
                }
            }
            return updateChatMsgInternal;
        }
        return invokeL.intValue;
    }

    public long delChatRecordForChatType(int i) {
        InterceptResult invokeI;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            synchronized (DBBase.mSyncLock) {
                LogUtils.d(TAG, "delChatRecordForChatType chatType = " + i);
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    LogUtils.d(TAG, "getWritableDb fail!");
                    return -1L;
                }
                ArrayList arrayList = new ArrayList();
                try {
                    String[] strArr = {String.valueOf(i)};
                    List<ChatSession> sessionListInternal = getSessionListInternal("chat_type = ?", strArr);
                    if (sessionListInternal != null && sessionListInternal.size() > 0) {
                        for (ChatSession chatSession : sessionListInternal) {
                            arrayList.add(Long.valueOf(chatSession.getContacter()));
                        }
                    }
                    if (arrayList.size() > 0) {
                        j = delChatRecordInternal("chat_type = ?", strArr);
                        openDatabase.delete(TableDefine.DB_TABLE_PA_SUBSCRIBE, "pasubtype = ?", strArr);
                        for (int i2 = 0; i2 < arrayList.size(); i2++) {
                            delChatMsgInternal("from_user = ?", new String[]{String.valueOf(arrayList.get(i2))});
                        }
                    } else {
                        j = -1;
                    }
                    LogUtils.d(TAG, "delChatRecordForChatType num = " + j);
                    return j;
                } catch (Exception e) {
                    LogUtils.e(TAG, "delChatRecordForChatType:", e);
                    return -1L;
                }
            }
        }
        return invokeI.longValue;
    }

    public long dupMsgAddHandler(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, chatMsg)) == null) {
            if (chatMsg == null) {
                return -1L;
            }
            if (chatMsg.getChatType() != 24 && chatMsg.getMsgType() == 20) {
                return -1L;
            }
            SQLiteDatabase openDatabase = openDatabase();
            try {
                if (openDatabase == null) {
                    LogUtils.d(TAG, "dupMsgAddHandler getWritableDb fail!");
                    return -1L;
                } else if (isDuplicateMsg(openDatabase, chatMsg) > 0) {
                    LogUtils.d(TAG, "dupMsgAddHandler isDuplicateMsg = true");
                    return -2L;
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("msgid", Long.valueOf(chatMsg.getMsgId()));
                    contentValues.put("type", Integer.valueOf(chatMsg.getMsgType()));
                    contentValues.put("from_user", Long.valueOf(chatMsg.getFromUser()));
                    contentValues.put("input_time", Long.valueOf(System.currentTimeMillis()));
                    contentValues.put("category", Integer.valueOf(chatMsg.getCategory()));
                    contentValues.put("contacter", Long.valueOf(chatMsg.getContacter()));
                    contentValues.put("msg_key", chatMsg.getMsgKey());
                    return openDatabase.insert(TableDefine.DB_TABLE_NO_DUPLICATE_MESSAGE, null, contentValues);
                }
            } catch (Exception e) {
                LogUtils.e(TAG, "dupMsgAddHandler:", e);
                return -1L;
            }
        }
        return invokeL.longValue;
    }

    public void updateSessionClass(ChatUser chatUser) {
        ChatSession chatRecord;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048674, this, chatUser) == null) && (chatRecord = getChatRecord(new ChatObject(this.mContext, 0, chatUser.getUk(), -1L, -1))) != null) {
            String str = TAG;
            LogUtils.d(str, "sync user session " + chatUser.toString());
            chatRecord.setNickName(chatUser.getUserName());
            chatRecord.setName(chatUser.getUserName());
            chatRecord.setIconUrl(chatUser.getIconUrl());
            chatRecord.setMarkTop(chatUser.getMarkTop());
            chatRecord.setMarkTopTime(chatUser.getMarkTopTime());
            chatRecord.setVipId(chatUser.getVipId());
            chatRecord.setVPortrait(chatUser.getVPortrait());
            chatRecord.setCertification(chatUser.getIdentity());
            chatRecord.setShield(chatUser.getShield());
            chatRecord.setShieldTime(chatUser.getShieldTime());
            int i = 1;
            chatRecord.setIsStranger((chatUser.getHasSpecialIdentity() == 1 || chatUser.getSubscribe() == 1 || chatUser.getSubscribe() == 3) ? 0 : 0);
            updateChatRecordInternal(chatRecord);
        }
    }

    private int delMsgsOfCertainContacterForSingle(ChatObject chatObject, long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, this, new Object[]{chatObject, Long.valueOf(j), Integer.valueOf(i)})) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    LogUtils.d(TAG, "getWritableDb fail!");
                    return -1;
                }
                try {
                    openDatabase.beginTransaction();
                    String str = "contacter = ?  AND category = ?";
                    int i2 = 1;
                    String[] strArr = {String.valueOf(chatObject.getContacter()), String.valueOf(chatObject.getCategory())};
                    int i3 = (j > (-1L) ? 1 : (j == (-1L) ? 0 : -1));
                    if (i3 != 0) {
                        str = "contacter = ?  AND category = ? AND msgid <= " + j;
                    }
                    if (i == 1) {
                        str = str + " AND status != 3";
                    }
                    int delChatMsgInternal = delChatMsgInternal(str, strArr);
                    long maxMsgid = getMaxMsgid(chatObject);
                    if (i3 == 0 || maxMsgid <= j) {
                        if (i == 1) {
                            updateChatSessionAfterClearMsg(chatObject);
                        } else {
                            i2 = delChatRecord(chatObject);
                        }
                    }
                    if (i2 < 0) {
                        try {
                            openDatabase.endTransaction();
                        } catch (Exception e) {
                            LogUtils.e(TAG, "delMsgsOfCertainContacterForSingle finally:", e);
                        }
                        return -1;
                    }
                    openDatabase.setTransactionSuccessful();
                    try {
                        openDatabase.endTransaction();
                    } catch (Exception e2) {
                        LogUtils.e(TAG, "delMsgsOfCertainContacterForSingle finally:", e2);
                    }
                    return delChatMsgInternal;
                } catch (Exception e3) {
                    LogUtils.e(TAG, "delMsg:", e3);
                    try {
                        openDatabase.endTransaction();
                    } catch (Exception e4) {
                        LogUtils.e(TAG, "delMsgsOfCertainContacterForSingle finally:", e4);
                    }
                    return -1;
                }
            }
        }
        return invokeCommon.intValue;
    }

    private void updateSession(boolean z, ChatSession chatSession, ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65593, this, new Object[]{Boolean.valueOf(z), chatSession, chatMsg}) != null) || !z) {
            return;
        }
        if (chatSession == null) {
            long contacter = getContacter(chatMsg);
            if (contacter != -1) {
                GetChatObjectInfoForRecordManager.getChatObjectForSession(this.mContext, new ChatObject(this.mContext, chatMsg.getCategory(), contacter, chatMsg.getPaid(), chatMsg.getChatType()));
            }
        } else if (chatMsg == null) {
            ChatObject chatObject = new ChatObject(this.mContext, chatSession.getCategory(), chatSession.getContacter(), chatSession.getPaid(), -1);
            if (chatSession.getClassType() == 11 && chatSession.getSessionFrom() != 2) {
                getInstance(this.mContext).delChatRecord(chatObject);
            } else {
                updateChatSessionAfterClearMsg(chatObject);
            }
        } else {
            String recommendDescription = chatMsg.getRecommendDescription();
            if (!TextUtils.isEmpty(chatMsg.getPreviewDesc())) {
                recommendDescription = chatMsg.getPreviewDesc();
            }
            if ((chatMsg instanceof HtmlMsg) && !TextUtils.isEmpty(chatMsg.getLocalUrl())) {
                recommendDescription = chatMsg.getLocalUrl();
            }
            chatSession.setState(chatMsg.getStatus());
            chatSession.setLastMsg(recommendDescription);
            chatSession.setLastMsgTime(chatMsg.getMsgTime());
            chatSession.setIsClicked(Utility.getClickState(chatMsg));
            if (chatMsg.isSelf(this.mContext)) {
                chatSession.setLastMsgidFromMe(chatMsg.getMsgId());
            }
            if (chatMsg.isStarMessage()) {
                chatSession.setChatType(4);
            }
            setChatSessionLastName(chatSession, chatMsg.getSenderUid());
            getInstance(this.mContext).updateChatSession(4, chatSession);
        }
    }

    private int deleteChatMsg(long j) {
        InterceptResult invokeJ;
        int delChatMsgInternal;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65552, this, j)) == null) {
            synchronized (DBBase.mSyncLock) {
                delChatMsgInternal = delChatMsgInternal("_id = ? ", new String[]{String.valueOf(j)});
                delChatMsgInternal("_id=? AND type in (?, ?, ?)", new String[]{String.valueOf(j + 1), String.valueOf(2012), String.valueOf(2001), String.valueOf(2014)});
            }
            return delChatMsgInternal;
        }
        return invokeJ.intValue;
    }

    private List<Long> getContacterByChatTypes(List<Integer> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                List<ChatSession> sessionListInternal = getSessionListInternal("chat_type" + buildINStatement(list), null);
                if (sessionListInternal != null) {
                    for (ChatSession chatSession : sessionListInternal) {
                        arrayList.add(Long.valueOf(chatSession.getContacter()));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    private boolean isNeedInsertToDB(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, this, chatMsg)) == null) {
            if (2 == chatMsg.getCategory()) {
                int notifyCmd = chatMsg.getNotifyCmd();
                if (notifyCmd != 0) {
                    if (notifyCmd != 1) {
                        if (notifyCmd != 26 && notifyCmd != 60 && notifyCmd != 62) {
                            switch (notifyCmd) {
                            }
                        }
                        return false;
                    }
                    delSysMsg(chatMsg.getCategory(), chatMsg.getFromUser(), 1);
                } else {
                    delSysMsg(chatMsg.getCategory(), chatMsg.getFromUser(), 0);
                }
            }
            if (chatMsg.getMsgType() == 27) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private MultiplePair<String, Integer, Integer, Void> parseHighlight(String str) {
        InterceptResult invokeL;
        int i;
        int i2;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, this, str)) == null) {
            String str2 = "";
            int i3 = 0;
            try {
                optJSONObject = new JSONObject(str).optJSONObject("ext");
            } catch (JSONException unused) {
                i = 0;
            }
            if (optJSONObject != null && (optJSONObject2 = optJSONObject.optJSONObject("session_exts")) != null && (optJSONObject3 = optJSONObject2.optJSONObject("highlight")) != null) {
                str2 = optJSONObject3.optString("desc");
                i = optJSONObject3.optInt("priority_level");
                try {
                    i2 = optJSONObject3.optInt("highlight_data_id");
                    i3 = i;
                } catch (JSONException unused2) {
                    i3 = i;
                    i2 = 0;
                    return new MultiplePair<>(str2, Integer.valueOf(i3), Integer.valueOf(i2), null);
                }
                return new MultiplePair<>(str2, Integer.valueOf(i3), Integer.valueOf(i2), null);
            }
            i2 = 0;
            return new MultiplePair<>(str2, Integer.valueOf(i3), Integer.valueOf(i2), null);
        }
        return (MultiplePair) invokeL.objValue;
    }

    public void delPaLocalInfosByPaType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            ArrayList<Long> queryPaIdByPaType = PaInfoDBManager.getInstance(this.mContext).queryPaIdByPaType(i);
            if (queryPaIdByPaType != null && !queryPaIdByPaType.isEmpty()) {
                String str = TAG;
                LogUtils.d(str, "---delPaLocalInfosByPaType---paids.size = " + queryPaIdByPaType.size());
                Iterator<Long> it = queryPaIdByPaType.iterator();
                while (it.hasNext()) {
                    delMsgsOfPaByPaId(it.next().longValue());
                }
                return;
            }
            LogUtils.d(TAG, "---delPaLocalInfosByPaType---paids is null ---- ");
        }
    }

    public int deleteDraftMsg(ChatObject chatObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, chatObject)) == null) {
            if (1 == chatObject.getCategory()) {
                int deleteDraftMsg = GroupMessageDAOImpl.deleteDraftMsg(this.mContext, String.valueOf(chatObject.getContacter()));
                if (deleteDraftMsg > 0) {
                    ChatSession chatRecord = getChatRecord(chatObject);
                    ArrayList<ChatMsg> fetchAllChatMsg = GroupMessageDAOImpl.fetchAllChatMsg(this.mContext, String.valueOf(chatObject.getContacter()), null, 1L, true);
                    ChatMsg chatMsg = null;
                    if (fetchAllChatMsg != null && fetchAllChatMsg.size() > 0) {
                        chatMsg = fetchAllChatMsg.get(0);
                    }
                    updateSession(true, chatRecord, chatMsg);
                }
                return deleteDraftMsg;
            }
            return deleteDraftMsgForSingle(chatObject);
        }
        return invokeL.intValue;
    }

    public int getAllNewMsgCount(List<Integer> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, list)) == null) {
            if (list != null && list.size() > 0) {
                return getAllNewMsgCountNotInGFH("chatrecord.chat_type" + buildINStatement(list) + " AND " + TableDefine.DB_TABLE_CHAT_SESSION + ".is_stranger = 0  AND " + TableDefine.DB_TABLE_CHAT_SESSION + ".disturb = 0 ");
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public ChatSession getBusinessAggSession(int i) {
        InterceptResult invokeI;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i)) == null) {
            LogUtils.d(TAG, "getBusinessAggSession");
            if (i == 27) {
                i2 = 9;
                i3 = 58;
            } else {
                i2 = -1;
                i3 = -1;
            }
            if (i2 != -1 && i3 != -1) {
                return getChatRecordInternal("category = ? AND classtype > ? AND chat_type = ?", new String[]{String.valueOf(i2), String.valueOf(0), String.valueOf(i3)});
            }
            return null;
        }
        return (ChatSession) invokeI.objValue;
    }

    public ChatSession getChatRecord(ChatObject chatObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, chatObject)) == null) {
            String str = "category = ? AND contacter=?";
            if (chatObject.getTimeInterval() > 0) {
                str = "category = ? AND contacter=? AND last_msg_time >= " + TimeUtil.getTimeSecondByInterval(chatObject.getTimeInterval());
            }
            return getChatRecordInternal(str, new String[]{String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter())});
        }
        return (ChatSession) invokeL.objValue;
    }

    public long getMaxMsgid(ChatObject chatObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, chatObject)) == null) {
            if (1 == chatObject.getCategory()) {
                return GroupMessageDAOImpl.getMaxMsgid(this.mContext, String.valueOf(chatObject.getContacter()));
            }
            synchronized (DBBase.mSyncLock) {
                ArrayList<ChatMsg> fetchMsg = fetchMsg(chatObject, 0L, 1L);
                if (fetchMsg != null && fetchMsg.size() > 0) {
                    return fetchMsg.get(0).getMsgId();
                }
                if (fetchMsg == null) {
                    return -1L;
                }
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    private long existStudioMsg(SQLiteDatabase sQLiteDatabase, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, this, sQLiteDatabase, chatMsg)) == null) {
            synchronized (DBBase.mSyncLock) {
                long msgId = chatMsg.getMsgId();
                StringBuilder sb = new StringBuilder();
                sb.append("(");
                sb.append("msgid");
                sb.append(" = ?)");
                if (TextUtils.isEmpty(chatMsg.getMsgKey())) {
                    strArr = new String[]{String.valueOf(msgId), String.valueOf(chatMsg.getContacter())};
                } else {
                    sb.append(" OR ");
                    sb.append("msg_key");
                    sb.append(" = ?");
                    strArr = new String[]{String.valueOf(msgId), String.valueOf(chatMsg.getMsgKey()), String.valueOf(chatMsg.getContacter())};
                }
                StringBuilder insert = sb.insert(0, "((");
                insert.append(") AND ");
                insert.append("contacter");
                insert.append(" = ?)");
                String str = TAG;
                LogUtils.d(str, "existStudioMsg query sql = " + sb.toString());
                Cursor query = sQLiteDatabase.query(TableDefine.DB_TABLE_STUDIO_USE_PA_MESSAGE, null, sb.toString(), strArr, null, null, null, String.valueOf(1));
                if (query != null && query.moveToNext()) {
                    long j = CursorWrapper.getLong(query, "_id");
                    if (query != null) {
                        query.close();
                    }
                    return j;
                }
                if (query != null) {
                    query.close();
                }
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    private long isDuplicateMsg(SQLiteDatabase sQLiteDatabase, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65577, this, sQLiteDatabase, chatMsg)) == null) {
            synchronized (DBBase.mSyncLock) {
                long msgId = chatMsg.getMsgId();
                StringBuilder sb = new StringBuilder();
                sb.append("(");
                sb.append("msgid");
                sb.append(" = ?)");
                if (TextUtils.isEmpty(chatMsg.getMsgKey())) {
                    strArr = new String[]{String.valueOf(msgId), String.valueOf(chatMsg.getContacter())};
                } else {
                    sb.append(" OR ");
                    sb.append("msg_key");
                    sb.append(" = ?");
                    strArr = new String[]{String.valueOf(msgId), String.valueOf(chatMsg.getMsgKey()), String.valueOf(chatMsg.getContacter())};
                }
                StringBuilder insert = sb.insert(0, "((");
                insert.append(") AND ");
                insert.append("contacter");
                insert.append(" = ?)");
                String str = TAG;
                LogUtils.d(str, "isDuplicateMsg query sql = " + sb.toString());
                Cursor query = sQLiteDatabase.query(TableDefine.DB_TABLE_NO_DUPLICATE_MESSAGE, null, sb.toString(), strArr, null, null, null, String.valueOf(1));
                if (query != null && query.moveToNext()) {
                    long j = CursorWrapper.getLong(query, "_id");
                    if (query != null) {
                        query.close();
                    }
                    return j;
                }
                if (query != null) {
                    query.close();
                }
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    private ChatSession setSessionClassParam(PaInfo paInfo, ChatSession chatSession) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65587, this, paInfo, chatSession)) == null) {
            if (paInfo != null && chatSession != null) {
                String str = TAG;
                LogUtils.d(str, "syncpa session " + paInfo.toString());
                chatSession.setName(paInfo.getNickName());
                chatSession.setNickName(paInfo.getNickName());
                chatSession.setIconUrl(paInfo.getAvatar());
                chatSession.setClassType(paInfo.getClassType());
                chatSession.setClassTitle(paInfo.getClassTitle());
                chatSession.setClassAvatar(paInfo.getClassavatar());
                chatSession.setClassShow(paInfo.getClassshow());
                chatSession.setMarkTop(paInfo.getMarkTop());
                chatSession.setMarkTopTime(paInfo.getMarkTopTime());
                chatSession.setVipId(paInfo.getVipId());
                chatSession.setVPortrait(paInfo.getVPortrait());
                chatSession.setCertification(paInfo.getIdentity());
                chatSession.setShield(paInfo.getShield());
                chatSession.setShieldTime(paInfo.getShieldTime());
                chatSession.setChatType(paInfo.getSubtype());
                chatSession.setMapType(paInfo.getMapType());
                if (paInfo.getBusinessType() > 0) {
                    chatSession.setBusinessType(paInfo.getBusinessType());
                }
                int i = 0;
                if (paInfo.getSubtype() == 7 && paInfo.getSubsetType() == 0 && paInfo.getHasIdentity() != 1 && paInfo.getSubscribe() != 1 && paInfo.getSubscribe() != 3) {
                    i = 1;
                }
                chatSession.setIsStranger(i);
            }
            return chatSession;
        }
        return (ChatSession) invokeLL.objValue;
    }

    public int setMsgReadByContacterIds(List<Long> list, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048657, this, list, j)) == null) {
            if (list != null && list.size() > 0) {
                synchronized (DBBase.mSyncLock) {
                    SQLiteDatabase openDatabase = openDatabase();
                    if (openDatabase == null) {
                        return -1;
                    }
                    try {
                        openDatabase.beginTransaction();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("is_read", (Integer) 1);
                        String str = "is_read=? AND category = ? AND contacter" + buildINStatement(list);
                        if (j > 0) {
                            str = str + " AND msgid<=" + j;
                        }
                        int updateChatMsgInternal = updateChatMsgInternal(contentValues, str, new String[]{String.valueOf(0), "0"});
                        if (updateChatMsgInternal > 0) {
                            for (Long l : list) {
                                long longValue = l.longValue();
                                int unReadMsgCount = getUnReadMsgCount(new ChatObject(this.mContext, 0, longValue));
                                ContentValues contentValues2 = new ContentValues();
                                contentValues2.put("new_msg_sum", Integer.valueOf(unReadMsgCount));
                                contentValues2.put("highlight_desc", "");
                                contentValues2.put("highlight_priority", (Integer) 0);
                                contentValues2.put("highlight_data_id", (Integer) 0);
                                updateChatRecordInternalAndNotify(contentValues2, "category=? AND contacter=?", new String[]{String.valueOf(0), String.valueOf(longValue)}, 3);
                            }
                        }
                        openDatabase.setTransactionSuccessful();
                        try {
                            openDatabase.endTransaction();
                        } catch (Exception unused) {
                        }
                        return updateChatMsgInternal;
                    } catch (Exception e) {
                        LogUtils.e(TAG, "setMsgReadByContacterIds:", e);
                        try {
                            openDatabase.endTransaction();
                        } catch (Exception unused2) {
                        }
                        return -1;
                    }
                }
            }
            return DBResponseCode.ERROR_PARAMETER;
        }
        return invokeLJ.intValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:103:0x01dc */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:111:0x01ed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0148 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c1 A[Catch: all -> 0x0045, Exception -> 0x004a, TryCatch #8 {Exception -> 0x004a, all -> 0x0045, blocks: (B:40:0x007f, B:42:0x00c1, B:44:0x00d2, B:45:0x00e6, B:57:0x0112, B:58:0x0147, B:56:0x010e, B:39:0x006b), top: B:129:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d2 A[Catch: all -> 0x0045, Exception -> 0x004a, TryCatch #8 {Exception -> 0x004a, all -> 0x0045, blocks: (B:40:0x007f, B:42:0x00c1, B:44:0x00d2, B:45:0x00e6, B:57:0x0112, B:58:0x0147, B:56:0x010e, B:39:0x006b), top: B:129:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x010e A[Catch: all -> 0x0045, Exception -> 0x004a, TryCatch #8 {Exception -> 0x004a, all -> 0x0045, blocks: (B:40:0x007f, B:42:0x00c1, B:44:0x00d2, B:45:0x00e6, B:57:0x0112, B:58:0x0147, B:56:0x010e, B:39:0x006b), top: B:129:0x006b }] */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r17v0, types: [com.baidu.android.imsdk.db.DBBase, java.lang.Object, com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v18, types: [long] */
    /* JADX WARN: Type inference failed for: r9v20, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ArrayList<ChatMsg> fetchMsg(ChatObject chatObject, long j, long j2, long j3, boolean z, String str) {
        InterceptResult invokeCommon;
        String str2;
        String str3;
        long j4;
        int i;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, this, new Object[]{chatObject, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z), str})) == null) {
            long j5 = j2;
            ArrayList<ChatMsg> arrayList = new ArrayList<>();
            SQLiteDatabase openDatabase = openDatabase();
            Cursor cursor = null;
            if (openDatabase == null) {
                LogUtils.d(TAG, "getReadableDb fail!");
                return null;
            }
            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i2 <= 0 && j5 >= 0) {
                j5 = -j5;
            }
            ?? r9 = -1;
            try {
                try {
                    if (0 == j && j3 == -1) {
                        str2 = " >= ";
                    } else {
                        long j6 = Long.MAX_VALUE;
                        int i3 = (j5 > 0L ? 1 : (j5 == 0L ? 0 : -1));
                        if (i3 == 0) {
                            str2 = " = ";
                            j6 = -2;
                        } else if (i3 > 0) {
                            str2 = " > ";
                            if (j3 == Long.MAX_VALUE) {
                                j6 = 0;
                            } else {
                                j6 = j3;
                            }
                        } else {
                            if (j3 != -1) {
                                j6 = j3;
                            }
                            str2 = " < ";
                        }
                        if (j6 != -2) {
                            try {
                                str3 = " AND _id" + str2 + j6;
                                String str5 = "contacter = ? AND msgid" + str2 + "? AND category = ? ";
                                String[] strArr = {String.valueOf(chatObject.getContacter()), String.valueOf(j), String.valueOf(chatObject.getCategory())};
                                if (str3 != null) {
                                    str5 = str5 + str3;
                                }
                                if (str != null) {
                                    str5 = str5 + " AND " + str;
                                }
                                String str6 = str5 + " AND status != 3";
                                r9 = 1;
                                if (j5 != 0) {
                                    j4 = 1;
                                } else {
                                    j4 = j5;
                                }
                                i = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
                                if (i <= 0 && i2 > 0) {
                                    str4 = " asc ";
                                } else {
                                    str4 = " desc ";
                                }
                                if (i == 0) {
                                    r9 = Math.abs(j4);
                                }
                                String str7 = "select * from message where " + str6 + " ORDER BY msgid" + str4 + ",_id" + str4 + " limit " + r9;
                                synchronized (DBBase.mSyncLock) {
                                    try {
                                        r9 = openDatabase.rawQuery(str7, strArr);
                                        try {
                                            if (r9 == 0) {
                                                if (r9 != 0) {
                                                    r9.close();
                                                }
                                                return null;
                                            }
                                            try {
                                                boolean cursorMoveDirection = getCursorMoveDirection(z, j, j4);
                                                if (!cursorMoveDirection) {
                                                    if (!r9.moveToLast()) {
                                                        if (r9 != 0) {
                                                            r9.close();
                                                        }
                                                        return arrayList;
                                                    }
                                                } else if (!r9.moveToFirst()) {
                                                    if (r9 != 0) {
                                                        r9.close();
                                                    }
                                                    return arrayList;
                                                }
                                                while (true) {
                                                    ChatMsg constructChatMsg = constructChatMsg(r9);
                                                    if (constructChatMsg != null) {
                                                        LogUtils.d(TAG, "msgid : " + constructChatMsg.getMsgId());
                                                        arrayList.add(constructChatMsg);
                                                    } else {
                                                        LogUtils.d(TAG, "construChatMsg msg is null ");
                                                    }
                                                    if (cursorMoveDirection) {
                                                        if (!r9.moveToNext()) {
                                                            LogUtils.d(TAG, "cursor is moveToNext failed!");
                                                            break;
                                                        }
                                                    } else if (!r9.moveToPrevious()) {
                                                        LogUtils.d(TAG, "cursor is moveToPrevious failed!");
                                                        break;
                                                    }
                                                }
                                                if (r9 != 0) {
                                                    r9.close();
                                                }
                                                return arrayList;
                                            } catch (Exception e) {
                                                e = e;
                                                LogUtils.e(TAG, "fetchMsg:", e);
                                                if (r9 != 0) {
                                                    r9.close();
                                                }
                                                return null;
                                            } catch (Throwable th) {
                                                th = th;
                                                cursor = r9;
                                                if (cursor != null) {
                                                    cursor.close();
                                                }
                                                throw th;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            while (true) {
                                                try {
                                                    break;
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                }
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                    }
                                }
                            } catch (Exception e2) {
                                e = e2;
                                r9 = 0;
                                LogUtils.e(TAG, "fetchMsg:", e);
                                if (r9 != 0) {
                                }
                                return null;
                            } catch (Throwable th5) {
                                th = th5;
                                if (cursor != null) {
                                }
                                throw th;
                            }
                        }
                    }
                    synchronized (DBBase.mSyncLock) {
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                str3 = null;
                String str52 = "contacter = ? AND msgid" + str2 + "? AND category = ? ";
                String[] strArr2 = {String.valueOf(chatObject.getContacter()), String.valueOf(j), String.valueOf(chatObject.getCategory())};
                if (str3 != null) {
                }
                if (str != null) {
                }
                String str62 = str52 + " AND status != 3";
                r9 = 1;
                if (j5 != 0) {
                }
                i = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
                if (i <= 0) {
                }
                str4 = " desc ";
                if (i == 0) {
                }
                String str72 = "select * from message where " + str62 + " ORDER BY msgid" + str4 + ",_id" + str4 + " limit " + r9;
            } catch (Throwable th6) {
                th = th6;
            }
        } else {
            return (ArrayList) invokeCommon.objValue;
        }
    }

    private ChatMsg getChatMsgInternal(String str, String[] strArr, String str2, String str3, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65559, this, new Object[]{str, strArr, str2, str3, str4, str5})) == null) {
            SingleChatMsgParse singleChatMsgParse = new SingleChatMsgParse();
            synchronized (DBBase.mSyncLock) {
                query("message", null, str, strArr, str2, str3, str4, str5, singleChatMsgParse);
            }
            return singleChatMsgParse.getResult();
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    private ArrayList<ChatMsg> getMsgListInternal(String str, String[] strArr, String str2, String str3, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65566, this, new Object[]{str, strArr, str2, str3, str4, str5})) == null) {
            ChatMsgListParse chatMsgListParse = new ChatMsgListParse();
            synchronized (DBBase.mSyncLock) {
                query("message", null, str, strArr, str2, str3, str4, str5, chatMsgListParse);
            }
            return chatMsgListParse.getResult();
        }
        return (ArrayList) invokeCommon.objValue;
    }

    private ArrayList<ChatMsg> getMsgListWithTagInternal(String str, String[] strArr, String str2, String str3, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65567, this, new Object[]{str, strArr, str2, str3, str4, str5})) == null) {
            ChatMsgListParse chatMsgListParse = new ChatMsgListParse();
            synchronized (DBBase.mSyncLock) {
                query(TableDefine.DB_TABLE_MESSAGE_WITH_TAG, null, str, strArr, str2, str3, str4, str5, chatMsgListParse);
            }
            return chatMsgListParse.getResult();
        }
        return (ArrayList) invokeCommon.objValue;
    }

    private List<ChatSession> getSessionListInternal(String str, String[] strArr, String str2, String str3, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65570, this, new Object[]{str, strArr, str2, str3, str4, str5})) == null) {
            ChatSessionListParse chatSessionListParse = new ChatSessionListParse();
            synchronized (DBBase.mSyncLock) {
                query(TableDefine.DB_TABLE_CHAT_SESSION, null, str, strArr, str2, str3, str4, str5, chatSessionListParse);
            }
            return chatSessionListParse.getResult();
        }
        return (List) invokeCommon.objValue;
    }

    public ArrayList<ChatMsg> fetchSpecifyMsgsSync(ChatObject chatObject, int i, long j, long j2, long j3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048611, this, new Object[]{chatObject, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)})) == null) {
            return fetchMsg(chatObject, j, j2, j3, z, "type = " + i);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    private ChatMsg getDraftMsgForSingle(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65564, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return getChatMsgInternal("category=? AND contacter=? AND status=?", new String[]{String.valueOf(i), String.valueOf(j), String.valueOf(3)});
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    private long insertChatMsgInternal(ContentValues contentValues, String str) {
        InterceptResult invokeLL;
        long insert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65575, this, contentValues, str)) == null) {
            if (contentValues != null && contentValues.size() != 0) {
                synchronized (DBBase.mSyncLock) {
                    insert = insert("message", contentValues);
                    if (!TextUtils.isEmpty(str) && insert > 0) {
                        contentValues.put(TableDefine.MessageTagColumns.COLUMN_MESSAGE_TAG, str);
                        insert(TableDefine.DB_TABLE_MESSAGE_WITH_TAG, contentValues);
                    }
                }
                return insert;
            }
            return -1L;
        }
        return invokeLL.longValue;
    }

    public long addMsg(ChatMsg chatMsg, boolean z) {
        InterceptResult invokeLZ;
        long addMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, chatMsg, z)) == null) {
            synchronized (DBBase.mSyncLock) {
                if (1 == chatMsg.getCategory()) {
                    addMsg = GroupMessageDAOImpl.addSingleChatMsg(this.mContext, chatMsg);
                } else {
                    addMsg = addMsg(chatMsg);
                }
                if (addMsg < 0) {
                    return addMsg;
                }
                chatMsg.setRowId(addMsg);
                if (!z) {
                    return addMsg;
                }
                updateChatSession(chatMsg);
                return addMsg;
            }
        }
        return invokeLZ.longValue;
    }

    public int deleteMsgBatch(ChatObject chatObject, long[] jArr) {
        InterceptResult invokeLL;
        int delMsgs;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, chatObject, jArr)) == null) {
            synchronized (DBBase.mSyncLock) {
                if (1 == chatObject.getCategory()) {
                    delMsgs = GroupMessageDAOImpl.deleteMsgs(this.mContext, String.valueOf(chatObject.getContacter()), jArr);
                } else {
                    delMsgs = getInstance(this.mContext).delMsgs(jArr);
                }
                if (delMsgs < 0) {
                    return -1009;
                }
                return updateSession(delMsgs, chatObject);
            }
        }
        return invokeLL.intValue;
    }

    public ChatSession getChatRecord(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048617, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return getChatRecord(new ChatObject(this.mContext, i, j));
        }
        return (ChatSession) invokeCommon.objValue;
    }

    public ChatMsg getDraftMsg(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048622, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (1 == i) {
                return GroupMessageDAOImpl.getDraftMsg(this.mContext, String.valueOf(j));
            }
            return getDraftMsgForSingle(i, j);
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    public List<Long> setMsgReadByChatTypes(List<Integer> list, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048656, this, list, j)) == null) {
            if (list != null && list.size() > 0) {
                synchronized (DBBase.mSyncLock) {
                    List<Long> unreadContacterByChatTypes = getUnreadContacterByChatTypes(list);
                    if (unreadContacterByChatTypes != null && unreadContacterByChatTypes.size() > 0) {
                        setMsgReadByContacterIds(unreadContacterByChatTypes, j);
                        return unreadContacterByChatTypes;
                    }
                    return unreadContacterByChatTypes;
                }
            }
            return null;
        }
        return (List) invokeLJ.objValue;
    }

    public List<Long> setPaMsgReadByChatTypeAndSubType(SparseArray<List<Integer>> sparseArray, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048658, this, sparseArray, j)) == null) {
            if (sparseArray == null || sparseArray.size() <= 0) {
                return null;
            }
            synchronized (DBBase.mSyncLock) {
                List<Long> paidListByPainfos = PaInfoDBManager.getInstance(this.mContext).getPaidListByPainfos(sparseArray);
                if (paidListByPainfos != null && paidListByPainfos.size() > 0) {
                    setMsgReadByContacterIds(paidListByPainfos, j);
                    return paidListByPainfos;
                }
                return null;
            }
        }
        return (List) invokeLJ.objValue;
    }

    public int updateMsgStatus(long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048670, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", Integer.valueOf(i));
            return updateChatMsgInternal(contentValues, "_id = ?", new String[]{String.valueOf(j)});
        }
        return invokeCommon.intValue;
    }

    private List<ChatSession> getSessionListNoTop(long j, long j2, int i, List<Integer> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65571, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), list})) == null) {
            return getSessionListInternal("chat_type" + buildINStatement(list) + " AND last_msg_time >= ?  AND last_msg_time <= ?  AND marktop = ?  AND is_stranger = ? AND (classtype <= ?  OR classshow = ?)  AND map_type != ?", new String[]{String.valueOf(j), String.valueOf(j2), String.valueOf(0), String.valueOf(0), String.valueOf(1), String.valueOf(0), String.valueOf(1)}, null, null, "last_msg_time DESC ", String.valueOf(Math.abs(i)));
        }
        return (List) invokeCommon.objValue;
    }

    private List<ChatSession> getSessionListWithTop(long j, long j2, int i, List<Integer> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65572, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), list})) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                int i2 = 0;
                String[] strArr = {String.valueOf(j), String.valueOf(j2), String.valueOf(1), String.valueOf(0), String.valueOf(1), String.valueOf(0), String.valueOf(1)};
                int abs = Math.abs(i);
                List<ChatSession> sessionListInternal = getSessionListInternal("chat_type" + buildINStatement(list) + " AND last_msg_time >= ?  AND last_msg_time <= ?  AND marktop = ?  AND is_stranger = ? AND (classtype <= ?  OR classshow = ?)  AND map_type != ?", strArr, null, null, "last_msg_time DESC ", String.valueOf(abs));
                if (sessionListInternal != null && sessionListInternal.size() == abs) {
                    return sessionListInternal;
                }
                if (sessionListInternal != null) {
                    arrayList.addAll(sessionListInternal);
                }
                if (sessionListInternal != null) {
                    i2 = sessionListInternal.size();
                }
                List<ChatSession> sessionListNoTop = getSessionListNoTop(0L, Long.MAX_VALUE, abs - i2, list);
                if (sessionListNoTop != null) {
                    arrayList.addAll(sessionListNoTop);
                }
                return arrayList;
            }
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    private List<ChatSession> getUnReadSessionList(long j, long j2, int i, List<Integer> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65573, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), list})) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                arrayList.addAll(getSessionListInternal("chat_type" + buildINStatement(list) + " AND last_msg_time > ?  AND last_msg_time <= ?  AND is_stranger = ?  AND new_msg_sum > ? AND disturb = ?  AND (classtype <= ?  OR classshow = ?)", new String[]{String.valueOf(j), String.valueOf(j2), String.valueOf(0), String.valueOf(0), String.valueOf(0), String.valueOf(1), String.valueOf(0)}, null, null, "last_msg_time DESC ", null));
            }
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    private long insertChatRecordInternal(ContentValues contentValues, int i, long j) {
        InterceptResult invokeCommon;
        long insert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65576, this, new Object[]{contentValues, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            synchronized (DBBase.mSyncLock) {
                insert = insert(TableDefine.DB_TABLE_CHAT_SESSION, contentValues);
            }
            if (insert > 0) {
                notifyDbChange(0, getChatRecord(i, j));
            }
            return insert;
        }
        return invokeCommon.longValue;
    }

    private int updateChatMsgInternal(ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65588, this, contentValues, str, strArr)) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                int i = -1;
                if (openDatabase == null) {
                    return -1;
                }
                try {
                    i = openDatabase.update("message", contentValues, str, strArr);
                    if (i > 0) {
                        openDatabase.update(TableDefine.DB_TABLE_MESSAGE_WITH_TAG, contentValues, str, strArr);
                    }
                    return i;
                } catch (Exception e) {
                    LogUtils.e(TAG, "updateChatMsgInternal:", e);
                    return i;
                }
            }
        }
        return invokeLLL.intValue;
    }

    private int updateChatRecordInternal(ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65589, this, contentValues, str, strArr)) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    return -1;
                }
                try {
                    return openDatabase.update(TableDefine.DB_TABLE_CHAT_SESSION, contentValues, str, strArr);
                } catch (Exception e) {
                    LogUtils.e(TAG, "updateChatRecordInternal:", e);
                    return -1;
                }
            }
        }
        return invokeLLL.intValue;
    }

    public ArrayList<ChatMsg> getMaxMsgidByChatTypes(List<Integer> list, long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048628, this, new Object[]{list, Long.valueOf(j), Integer.valueOf(i)})) == null) {
            return fetchMsgByContacterIdOrderByMsgid(getContacterByChatTypes(list), j, i);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<ChatMsg> getNotificationMsgDataList(SparseArray<List<Integer>> sparseArray, long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048637, this, new Object[]{sparseArray, Long.valueOf(j), Integer.valueOf(i)})) == null) {
            return fetchMsgByContacterIdOrderByMsgid(new ArrayList(PaInfoDBManager.getInstance(this.mContext).getPaidListByPainfos(sparseArray)), j, i);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    private boolean isReliableMsgExist(SQLiteDatabase sQLiteDatabase, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        boolean z;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65580, this, sQLiteDatabase, chatMsg)) == null) {
            synchronized (DBBase.mSyncLock) {
                z = false;
                Cursor cursor = null;
                try {
                    long msgId = chatMsg.getMsgId();
                    String msgKey = chatMsg.getMsgKey();
                    StringBuilder sb = new StringBuilder();
                    sb.append("msgid");
                    sb.append(" = ?");
                    if (TextUtils.isEmpty(msgKey)) {
                        strArr = new String[]{String.valueOf(msgId)};
                    } else {
                        sb.append(" OR ");
                        sb.append("msg_key");
                        sb.append(" = ?");
                        strArr = new String[]{String.valueOf(msgId), String.valueOf(msgKey)};
                    }
                    cursor = sQLiteDatabase.query(TableDefine.DB_TABLE_RELIABLE_MESSAGE, null, sb.toString(), strArr, null, null, null, String.valueOf(1));
                    if (cursor != null) {
                        if (cursor.moveToNext()) {
                            z = true;
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e) {
                    String str = TAG;
                    LogUtils.e(str, "isReliableMsgExist e :" + e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return false;
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public MultiplePair<String, Integer, Long, Integer> getImportantReminderMsg(List<ChatMsg> list, ChatSession chatSession) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048624, this, list, chatSession)) == null) {
            if (list != null && list.size() != 0 && chatSession != null) {
                String highlightDesc = chatSession.getHighlightDesc();
                int highlightPriority = chatSession.getHighlightPriority();
                int highlightDataId = chatSession.getHighlightDataId();
                long lastMsgidFromMe = chatSession.getLastMsgidFromMe();
                int size = list.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    ChatMsg chatMsg = list.get(size);
                    if (chatMsg != null) {
                        if (chatMsg.isSelf(this.mContext)) {
                            lastMsgidFromMe = chatMsg.getMsgId();
                            break;
                        } else if (chatMsg.isMsgRead()) {
                            break;
                        } else {
                            MultiplePair<String, Integer, Integer, Void> parseHighlight = parseHighlight(chatMsg.getMsgContent());
                            if ((highlightPriority == 0 && ((Integer) ((Pair) parseHighlight).second).intValue() > 0) || ((Integer) ((Pair) parseHighlight).second).intValue() < highlightPriority) {
                                highlightDesc = (String) ((Pair) parseHighlight).first;
                                highlightPriority = ((Integer) ((Pair) parseHighlight).second).intValue();
                                highlightDataId = parseHighlight.third.intValue();
                            }
                        }
                    }
                    size--;
                }
                return new MultiplePair<>(highlightDesc, Integer.valueOf(highlightPriority), Long.valueOf(lastMsgidFromMe), Integer.valueOf(highlightDataId));
            }
            return null;
        }
        return (MultiplePair) invokeLL.objValue;
    }

    public boolean setAllMsgReadWithMsgid(ChatObject chatObject, long j) {
        InterceptResult invokeLJ;
        int allMsgRead;
        int unReadMsgCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048652, this, chatObject, j)) == null) {
            if (j == -1) {
                j = getInstance(this.mContext).getMaxMsgid(chatObject);
            }
            synchronized (DBBase.mSyncLock) {
                if (j < 0) {
                    return false;
                }
                if (chatObject.getCategory() == 1) {
                    allMsgRead = GroupMessageDAOImpl.setAllMsgRead(this.mContext, String.valueOf(chatObject.getContacter()), j);
                } else {
                    allMsgRead = getInstance(this.mContext).setAllMsgRead(chatObject, j);
                }
                if (allMsgRead < 0) {
                    return false;
                }
                ChatSession chatRecord = getInstance(this.mContext).getChatRecord(chatObject);
                String str = TAG;
                LogUtils.d(str, "delta:" + allMsgRead);
                if (chatRecord != null) {
                    if (j >= chatRecord.getRemindMsgid()) {
                        chatRecord.setRemindMsgId(0L);
                        chatRecord.setRemindType(0);
                        chatRecord.setRemindUid(0L);
                        chatRecord.setRemindRoleDisplayName("");
                    }
                    chatRecord.setHighlightDesc("");
                    chatRecord.setHighlightPriority(0);
                    if (1 == chatObject.getCategory()) {
                        unReadMsgCount = GroupMessageDAOImpl.getUnReadCount(this.mContext, String.valueOf(chatObject.getContacter()));
                    } else {
                        unReadMsgCount = getUnReadMsgCount(chatObject);
                    }
                    if (unReadMsgCount >= 0) {
                        chatRecord.setNewMsgSum(unReadMsgCount);
                    } else {
                        chatRecord.setNewMsgSum(0L);
                    }
                    getInstance(this.mContext).updateChatSession(3, chatRecord);
                }
                return true;
            }
        }
        return invokeLJ.booleanValue;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:24:0x0086
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public int showSendMsgPV(long r18, long r20) {
        /*
            r17 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager.$ic
            if (r0 != 0) goto L9e
        L4:
            r0 = r18
            android.database.sqlite.SQLiteDatabase r2 = r17.openDatabase()
            r10 = 0
            if (r2 != 0) goto Le
            return r10
        Le:
            r11 = 0
            java.lang.String r12 = "time > ? AND from_user= ?"
            r13 = r17
            android.content.Context r3 = r13.mContext     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            com.baidu.android.imsdk.account.AccountManagerImpl r3 = com.baidu.android.imsdk.account.AccountManagerImpl.getInstance(r3)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            long r14 = r3.getUK()     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            r3 = 2
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            r3 = 1000(0x3e8, double:4.94E-321)
            long r3 = r0 / r3
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            r6[r10] = r3     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            r3 = 1
            java.lang.String r4 = java.lang.String.valueOf(r14)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            r6[r3] = r4     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            java.lang.Object r16 = com.baidu.android.imsdk.db.DBBase.mSyncLock     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            monitor-enter(r16)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            java.lang.String r3 = "message"
            java.lang.String r4 = "_id"
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch: java.lang.Throwable -> L7f
            r7 = 0
            r8 = 0
            r9 = 0
            r5 = r12
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L7f
            monitor-exit(r16)     // Catch: java.lang.Throwable -> L7f
            int r10 = r11.getCount()     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            java.lang.String r2 = com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager.TAG     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            r3.<init>()     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            java.lang.String r4 = "showSendMsgPV whereClause :"
            r3.append(r4)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            r3.append(r12)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            java.lang.String r4 = "， timeStamp ："
            r3.append(r4)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            r3.append(r0)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            java.lang.String r0 = ", uk "
            r3.append(r0)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            r3.append(r14)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            java.lang.String r0 = ", msgPV :"
            r3.append(r0)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            r3.append(r10)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            com.baidu.android.imsdk.utils.LogUtils.d(r2, r0)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            if (r11 == 0) goto L97
        L7b:
            r11.close()
            goto L97
        L7f:
            r0 = move-exception
            monitor-exit(r16)     // Catch: java.lang.Throwable -> L7f
            throw r0     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
        L82:
            r0 = move-exception
            goto L98
        L84:
            r0 = move-exception
            goto L8d
        L86:
            r0 = move-exception
            r13 = r17
            goto L98
        L8a:
            r0 = move-exception
            r13 = r17
        L8d:
            java.lang.String r1 = com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager.TAG     // Catch: java.lang.Throwable -> L82
            java.lang.String r2 = "showSendMsgPV Exception :"
            com.baidu.android.imsdk.utils.LogUtils.e(r1, r2, r0)     // Catch: java.lang.Throwable -> L82
            if (r11 == 0) goto L97
            goto L7b
        L97:
            return r10
        L98:
            if (r11 == 0) goto L9d
            r11.close()
        L9d:
            throw r0
        L9e:
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r1 = 0
            java.lang.Long r2 = java.lang.Long.valueOf(r18)
            r3[r1] = r2
            r1 = 1
            java.lang.Long r2 = java.lang.Long.valueOf(r20)
            r3[r1] = r2
            r1 = 1048660(0x100054, float:1.469486E-39)
            r2 = r17
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r0.invokeCommon(r1, r2, r3)
            if (r0 == 0) goto L4
            int r1 = r0.intValue
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager.showSendMsgPV(long, long):int");
    }

    public long updateChatSession(int i, ChatSession chatSession) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048663, this, i, chatSession)) == null) {
            if (chatSession == null) {
                return -1L;
            }
            ContentValues contentValues = new ContentValues();
            contructChatRecordValues(chatSession, contentValues);
            if (!isRecordExist(chatSession.getCategory(), chatSession.getContacter())) {
                String str = TAG;
                LogUtils.e(str, "notifyType = " + i + " create chatsession! " + chatSession.toString());
                contentValues.put("category", Integer.valueOf(chatSession.getCategory()));
                contentValues.put("contacter", Long.valueOf(chatSession.getContacter()));
                contentValues.put("paid", Long.valueOf(chatSession.getPaid()));
                return insertChatRecordInternal(contentValues, chatSession.getCategory(), chatSession.getContacter());
            }
            String str2 = TAG;
            LogUtils.d(str2, "notifyType = " + i + "update chatsession! " + chatSession.toString());
            updateChatRecordInternalAndNotify(contentValues, "category =? AND contacter = ?", new String[]{String.valueOf(chatSession.getCategory()), String.valueOf(chatSession.getContacter())}, i);
            return -1L;
        }
        return invokeIL.longValue;
    }

    private void notifyDbChange(int i, List<ChatSession> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(65583, this, i, list) == null) && list != null && list.size() != 0) {
            super.notifyDbChange(0, i, list, true);
        }
    }

    private int setAllMsgRead(ChatObject chatObject, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65585, this, chatObject, j)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_read", (Integer) 1);
            String str = "is_read=? AND category = ? AND (contacter = ? OR from_user = ?)";
            if (j > 0) {
                str = "is_read=? AND category = ? AND (contacter = ? OR from_user = ?) AND msgid<=" + j;
            }
            return updateChatMsgInternal(contentValues, str, new String[]{String.valueOf(0), String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter()), String.valueOf(chatObject.getContacter())});
        }
        return invokeLJ.intValue;
    }

    public List<ChatMsg> fetchPaMsgByChatType(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048609, this, i, i2)) == null) {
            List<PaInfo> queryPaInfoByChatType = PaInfoDBManager.getInstance(this.mContext).queryPaInfoByChatType(i);
            if (queryPaInfoByChatType != null && queryPaInfoByChatType.size() > 0) {
                String str = "" + queryPaInfoByChatType.get(0).getPaId();
                for (int i3 = 1; i3 < queryPaInfoByChatType.size(); i3++) {
                    str = str + StringUtil.ARRAY_ELEMENT_SEPARATOR + queryPaInfoByChatType.get(i3).getPaId();
                }
                return getMsgListInternal("paid in (" + str + ") ", null, null, null, "time desc ", String.valueOf(Math.abs(i2)));
            }
            return null;
        }
        return (List) invokeII.objValue;
    }

    public ArrayList<ChatMsg> fetchPaUnreadMsgByPaids(List<Long> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048610, this, list, i)) == null) {
            if (list != null && list.size() > 0) {
                return getMsgListInternal((("contacter" + buildINStatement(list)) + " AND msgid > 0") + " AND is_read = 0", null, null, null, "msgid asc ", String.valueOf(Math.abs(i)));
            }
            return new ArrayList<>();
        }
        return (ArrayList) invokeLI.objValue;
    }

    public ArrayList<ChatSession> getChatRecordsByClass(long j, List<Integer> list) {
        InterceptResult invokeJL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048621, this, j, list)) == null) {
            String str2 = "show= ?";
            if (list != null && list.size() > 0) {
                str2 = "show= ? AND classtype" + buildINStatement(list);
            }
            String str3 = str2;
            if (j > 0) {
                str = String.valueOf(j);
            } else {
                str = null;
            }
            LogUtils.e(TAG, str3);
            List<ChatSession> sessionListInternal = getSessionListInternal(str3, new String[]{String.valueOf(1)}, null, null, "last_msg_time desc ", str);
            ArrayList<ChatSession> arrayList = new ArrayList<>();
            if (sessionListInternal != null) {
                arrayList.addAll(sessionListInternal);
            }
            return arrayList;
        }
        return (ArrayList) invokeJL.objValue;
    }

    public void setChatSessionLastName(ChatSession chatSession, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048653, this, chatSession, str) == null) {
            long longByString = Utility.getLongByString(str, 0L);
            if (chatSession.getChatType() == 57) {
                if (chatSession.getLastMsgUid() != longByString || TextUtils.isEmpty(chatSession.getLastMsgName())) {
                    chatSession.setLastMsgUid(longByString);
                    if (longByString != 0) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(str);
                        ArrayList<GroupMember> groupMember = GroupInfoDAOImpl.getGroupMember(this.mContext, String.valueOf(chatSession.getContacter()), arrayList, 1);
                        if (groupMember != null && groupMember.size() > 0) {
                            chatSession.setLastMsgName(groupMember.get(0).getShowName());
                            return;
                        } else {
                            chatSession.setLastMsgName("");
                            return;
                        }
                    }
                    chatSession.setLastMsgName("");
                }
            }
        }
    }

    public int setMsgRead(ChatObject chatObject, long j) {
        InterceptResult invokeLJ;
        int msgRead;
        ChatSession chatRecord;
        int unReadMsgCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048655, this, chatObject, j)) == null) {
            if (chatObject == null) {
                return DBResponseCode.ERROR_PARAMETER;
            }
            synchronized (DBBase.mSyncLock) {
                if (1 == chatObject.getCategory()) {
                    msgRead = GroupMessageDAOImpl.setMsgReaded(this.mContext, String.valueOf(chatObject.getContacter()), j);
                } else {
                    msgRead = getInstance(this.mContext).setMsgRead(j);
                }
                if (msgRead < 0) {
                    return -1009;
                }
                if (msgRead != 0 && (chatRecord = getChatRecord(chatObject)) != null) {
                    if (1 == chatObject.getCategory()) {
                        unReadMsgCount = GroupMessageDAOImpl.getUnReadCount(this.mContext, String.valueOf(chatObject.getContacter()));
                    } else {
                        unReadMsgCount = getUnReadMsgCount(chatObject);
                    }
                    if (unReadMsgCount >= 0) {
                        chatRecord.setNewMsgSum(unReadMsgCount);
                    } else {
                        chatRecord.setNewMsgSum(0L);
                    }
                    getInstance(this.mContext).updateChatSession(3, chatRecord);
                }
                return msgRead;
            }
        }
        return invokeLJ.intValue;
    }

    public int updateSession(int i, ChatObject chatObject) {
        InterceptResult invokeIL;
        ArrayList<ChatMsg> fetchMsgExcludeTypes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048673, this, i, chatObject)) == null) {
            synchronized (DBBase.mSyncLock) {
                ChatMsg chatMsg = null;
                ChatSession chatRecord = getChatRecord(chatObject);
                if (chatRecord != null && chatRecord.getState() != 3) {
                    if (i != 0) {
                        if (1 == chatObject.getCategory()) {
                            fetchMsgExcludeTypes = GroupMessageDAOImpl.fetchChatMsgExceptGroupSystem(this.mContext, String.valueOf(chatObject.getContacter()), null, 1L, true);
                        } else {
                            fetchMsgExcludeTypes = fetchMsgExcludeTypes(chatObject, 0L, 1L, UNUPDATE_SESSION_MSG_TYPES);
                        }
                        if (fetchMsgExcludeTypes != null && fetchMsgExcludeTypes.size() > 0) {
                            chatMsg = fetchMsgExcludeTypes.get(0);
                        }
                        chatRecord.setNewMsgSum(getUnReadMsgCount(chatObject));
                        updateSession(true, chatRecord, chatMsg);
                    }
                    return i;
                }
                return i;
            }
        }
        return invokeIL.intValue;
    }

    private int updateChatRecordInternal(ChatSession chatSession) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65590, this, chatSession)) == null) {
            if (chatSession == null) {
                return 0;
            }
            ContentValues contentValues = new ContentValues();
            contructChatRecordValues(chatSession, contentValues);
            return updateChatRecordInternal(contentValues, "category =? AND contacter = ?", new String[]{String.valueOf(chatSession.getCategory()), String.valueOf(chatSession.getContacter())});
        }
        return invokeL.intValue;
    }

    public int delChatRecord(ChatObject chatObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, chatObject)) == null) {
            String[] strArr = {String.valueOf(chatObject.getCategory()), String.valueOf(chatObject.getContacter())};
            ChatSession chatRecordInternal = getChatRecordInternal("category = ? AND contacter = ?", strArr);
            int delChatRecordInternal = delChatRecordInternal("category = ? AND contacter = ?", strArr);
            if (delChatRecordInternal > 0 && chatRecordInternal != null) {
                notifyDbChange(2, chatRecordInternal);
            }
            return delChatRecordInternal;
        }
        return invokeL.intValue;
    }

    public int delChatRecordByClass(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            String[] strArr = {String.valueOf(i)};
            List<ChatSession> sessionListInternal = getSessionListInternal("classtype = ? ", strArr);
            int delChatRecordInternal = delChatRecordInternal("classtype = ? ", strArr);
            if (delChatRecordInternal > 0 && sessionListInternal != null && sessionListInternal.size() > 0) {
                notifyDbChange(2, sessionListInternal);
            }
            return delChatRecordInternal;
        }
        return invokeI.intValue;
    }

    public int deleteChatMsg(ChatMsg chatMsg) {
        InterceptResult invokeL;
        int deleteChatMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, chatMsg)) == null) {
            synchronized (DBBase.mSyncLock) {
                if (1 == chatMsg.getCategory()) {
                    deleteChatMsg = GroupMessageDAOImpl.deleteChatMsg(this.mContext, chatMsg);
                } else {
                    deleteChatMsg = deleteChatMsg(chatMsg.getRowId());
                }
                if (deleteChatMsg < 0) {
                    return deleteChatMsg;
                }
                updateChatSession(chatMsg);
                return deleteChatMsg;
            }
        }
        return invokeL.intValue;
    }

    public int getChatRecordUnReadNum(ChatObject chatObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, chatObject)) == null) {
            if (1 == chatObject.getCategory()) {
                return GroupMessageDAOImpl.getUnReadCount(this.mContext, String.valueOf(chatObject.getContacter()));
            }
            ChatSession chatRecord = getChatRecord(chatObject.getCategory(), chatObject.getContacter());
            if (chatRecord == null) {
                return 0;
            }
            return (int) chatRecord.getNewMsgSum();
        }
        return invokeL.intValue;
    }

    public long getNewMsgNum(ChatObject chatObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, chatObject)) == null) {
            if (1 == chatObject.getCategory()) {
                return GroupMessageDAOImpl.getUnReadCount(this.mContext, String.valueOf(chatObject.getContacter()));
            }
            ChatSession chatRecord = getChatRecord(chatObject);
            if (chatRecord == null) {
                return -1L;
            }
            return chatRecord.getNewMsgSum();
        }
        return invokeL.longValue;
    }

    public int getStrangerUnReadCount(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048641, this, j)) == null) {
            String str = "is_stranger = 1";
            if (j > 0) {
                str = "is_stranger = 1 AND last_msg_time >= " + TimeUtil.getTimeSecondByInterval(j);
            }
            return getNewMsgCount(str);
        }
        return invokeJ.intValue;
    }

    public int setStudioMsgRead(long j) {
        InterceptResult invokeJ;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048659, this, j)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_read", (Integer) 1);
            synchronized (DBBase.mSyncLock) {
                update = update(TableDefine.DB_TABLE_STUDIO_USE_PA_MESSAGE, "msgid = ?", new String[]{String.valueOf(j)}, contentValues);
            }
            return update;
        }
        return invokeJ.intValue;
    }

    public int updateChatSessionName(ChatSession chatSession) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048667, this, chatSession)) == null) {
            if (chatSession == null) {
                return -1;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", chatSession.getName());
            return updateChatRecordInternalAndNotify(contentValues, "category =? AND contacter = ?", new String[]{String.valueOf(chatSession.getCategory()), String.valueOf(chatSession.getContacter())}, 1);
        }
        return invokeL.intValue;
    }

    public int updateMsgStatus(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048671, this, chatMsg)) == null) {
            if (chatMsg != null) {
                if (1 == chatMsg.getCategory()) {
                    int updateMsgStatus = GroupMessageDAOImpl.updateMsgStatus(this.mContext, chatMsg);
                    if (updateMsgStatus >= 0) {
                        updateChatSession(chatMsg);
                        return updateMsgStatus;
                    }
                    return updateMsgStatus;
                } else if (chatMsg.getCategory() == 0) {
                    return updateMsgStatusForSingle(chatMsg);
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    private int updateChatRecordInternalAndNotify(ContentValues contentValues, String str, String[] strArr, int i) {
        InterceptResult invokeLLLI;
        int updateChatRecordInternal;
        List<ChatSession> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65591, this, contentValues, str, strArr, i)) == null) {
            LogUtils.d(TAG, "updateChatRecordInternalAndNotify start");
            synchronized (DBBase.mSyncLock) {
                updateChatRecordInternal = updateChatRecordInternal(contentValues, str, strArr);
                if (updateChatRecordInternal > 0) {
                    list = getSessionListInternal(str, strArr, null, null, null, null);
                } else {
                    list = null;
                }
            }
            if (updateChatRecordInternal > 0 && list != null && list.size() > 0) {
                notifyDbChange(i, list);
            }
            return updateChatRecordInternal;
        }
        return invokeLLLI.intValue;
    }

    public ArrayList<ChatMsg> fetchMsg(ChatObject chatObject, long j, long j2, long j3) {
        InterceptResult invokeCommon;
        ArrayList<ChatMsg> fetchMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{chatObject, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            synchronized (DBBase.mSyncLock) {
                fetchMsg = fetchMsg(chatObject, j, j2, j3, false);
            }
            return fetchMsg;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<ChatMsg> addCastReliableMsgs(@NonNull List<TextMsg> list, List<Long> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, list, list2)) == null) {
            ArrayList<ChatMsg> arrayList = new ArrayList<>();
            synchronized (DBBase.mSyncLock) {
                for (TextMsg textMsg : list) {
                    if (addReliableMsg(textMsg) > 0) {
                        arrayList.add(textMsg);
                        list2.add(Long.valueOf(textMsg.getMsgId()));
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public long deleteAllMsg(ChatObject chatObject, int i) {
        InterceptResult invokeLI;
        long maxMsgid;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, chatObject, i)) == null) {
            synchronized (this.mContext) {
                if (1 == chatObject.getCategory()) {
                    maxMsgid = GroupMessageDAOImpl.getMaxMsgid(this.mContext, String.valueOf(chatObject.getContacter()));
                } else {
                    maxMsgid = getInstance(this.mContext).getMaxMsgid(chatObject);
                }
                if (maxMsgid < 0) {
                    return -1009L;
                }
                if (deleteAllMsgWithMsgid(chatObject, maxMsgid, i) < 0) {
                    return -1009L;
                }
                return maxMsgid;
            }
        }
        return invokeLI.longValue;
    }

    public ChatMsg getLatestMsg(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048625, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return getChatMsgInternal("category=? AND contacter=? ", new String[]{String.valueOf(i), String.valueOf(j)}, null, null, "msgid desc ", String.valueOf(1));
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    public int getNewMsgCount(List<Integer> list, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048631, this, list, j)) == null) {
            if (list != null && list.size() > 0) {
                String str = "chat_type" + buildINStatement(list);
                if (j > 0) {
                    str = str + " AND last_msg_time >= " + TimeUtil.getTimeSecondByInterval(j);
                }
                return getNewMsgCount(str);
            }
            return 0;
        }
        return invokeLJ.intValue;
    }

    public void addEmojiContent(int i, int i2, @NonNull String str) {
        int i3;
        long insert;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, str) == null) {
            if (TextUtils.isEmpty(str)) {
                LogUtils.e(TAG, "addEmojiContent emojiContent is null!");
                return;
            }
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                try {
                } catch (Exception e) {
                    LogUtils.d(TAG, "addEmojiContent:" + e);
                }
                if (openDatabase == null) {
                    LogUtils.e(TAG, "addEmojiContent db is null!");
                    return;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put(TableDefine.EmojiColumns.COLUMN_EMOJI_ID, Integer.valueOf(str.hashCode()));
                contentValues.put(TableDefine.EmojiColumns.COLUMN_PACKAGE_ID, Integer.valueOf(i));
                contentValues.put("emoji_content", str);
                contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("category", Integer.valueOf(i2));
                String[] strArr = {String.valueOf(str.hashCode()), String.valueOf(i), String.valueOf(i2)};
                LogUtils.d(TAG, "addEmojiContent :emoji_id =? AND package_id =? AND category =? " + str.hashCode());
                Cursor query = openDatabase.query(TableDefine.DB_TABLE_USED_EMOJI, null, "emoji_id =? AND package_id =? AND category =? ", strArr, null, null, null, String.valueOf(1));
                if (query != null && query.moveToNext()) {
                    i3 = CursorWrapper.getInt(query, "count") + 1;
                    LogUtils.d(TAG, "addEmojiContent count:" + i3);
                } else {
                    i3 = 1;
                }
                contentValues.put("count", Integer.valueOf(i3));
                if (i3 > 1) {
                    insert = openDatabase.update(TableDefine.DB_TABLE_USED_EMOJI, contentValues, "emoji_id =? AND package_id =? AND category =? ", strArr);
                } else {
                    insert = openDatabase.insert(TableDefine.DB_TABLE_USED_EMOJI, null, contentValues);
                }
                LogUtils.d(TAG, "addEmojiContent ok :" + str + ", result :" + insert + ", count " + i3);
            }
        }
    }

    public ArrayList<ChatMsg> addMsgs(Context context, ArrayList<ChatMsg> arrayList, boolean z, long j) {
        InterceptResult invokeCommon;
        ArrayList<ChatMsg> arrayList2;
        MultiplePair<String, Integer, Long, Integer> importantReminderMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{context, arrayList, Boolean.valueOf(z), Long.valueOf(j)})) == null) {
            ArrayList<ChatMsg> arrayList3 = arrayList;
            long j2 = j;
            if (arrayList3 != null) {
                synchronized (DBBase.mSyncLock) {
                    AccountManagerImpl.getInstance(this.mContext).getUid();
                    arrayList2 = new ArrayList<>();
                    ArrayList<ChatMsg> arrayList4 = new ArrayList<>();
                    ArrayList<ChatMsg> arrayList5 = new ArrayList<>();
                    ArrayList<ChatMsg> arrayList6 = new ArrayList<>();
                    HashMap<ChatObject, Integer> hashMap = new HashMap<>();
                    HashMap hashMap2 = new HashMap();
                    HashMap<ChatObject, MultiplePair<String, Integer, Long, Integer>> hashMap3 = new HashMap<>();
                    int i = 0;
                    while (i < arrayList.size()) {
                        ChatMsg chatMsg = arrayList3.get(i);
                        chatMsg.setTriggerReasonn(j2);
                        try {
                            JSONObject jSONObject = new JSONObject(chatMsg.getMsgContent());
                            jSONObject.put(Constants.EXTRA_TRIGGER_REASON, j2);
                            chatMsg.setMsgContent(jSONObject.toString());
                        } catch (Exception e) {
                            LogUtils.e(TAG, "addMsgs exception", e);
                        }
                        if (!isNeedInsertToDB(chatMsg)) {
                            arrayList2.add(chatMsg);
                        } else if (chatMsg.getChatType() == 24 && chatMsg.getMsgType() == 20) {
                            LogUtils.d(TAG, "msg will handle by dupMsgAddHandler");
                            if (dupMsgAddHandler(chatMsg) > 0) {
                                if (RetrieveUtil.isRetrievePaUid(context, chatMsg.getFromUser())) {
                                    arrayList6.add(chatMsg);
                                } else {
                                    arrayList4.add(chatMsg);
                                }
                            }
                        } else if (chatMsg.getChatType() == 20 && chatMsg.getMsgType() == 80) {
                            LogUtils.d(TAG, "msg will handle by stduioMsgAddHandler");
                            if (studioMsgAddHandler(chatMsg) > 0) {
                                arrayList5.add(chatMsg);
                            }
                        } else {
                            String str = TAG;
                            LogUtils.d(str, "will add msg to db, msg = " + chatMsg.toString());
                            long addMsg = addMsg(chatMsg);
                            String str2 = TAG;
                            LogUtils.e(str2, "addMsg result : " + addMsg);
                            if (-1 != addMsg && -2 != addMsg) {
                                chatMsg.setRowId(addMsg);
                                long contacter = getContacter(chatMsg);
                                if (contacter != -1) {
                                    ChatObject chatObject = new ChatObject(this.mContext, chatMsg.getCategory(), contacter, chatMsg.getPaid(), -1);
                                    ChatSession chatRecord = getChatRecord(chatObject);
                                    String str3 = TAG;
                                    LogUtils.e(str3, " addMsgs session : " + chatRecord);
                                    if (chatRecord != null) {
                                        chatMsg.setChatType(chatRecord.getChatType());
                                        arrayList2.add(chatMsg);
                                    }
                                    if (hashMap.containsKey(chatObject)) {
                                        if (z && !chatMsg.isMsgRead() && chatMsg.getMsgType() != 101) {
                                            hashMap.put(chatObject, Integer.valueOf(hashMap.get(chatObject).intValue() + 1));
                                            if (hashMap2.get(chatObject) != null) {
                                                ((ArrayList) hashMap2.get(chatObject)).add(chatMsg);
                                            }
                                        }
                                    } else if (z && !chatMsg.isMsgRead() && chatMsg.getMsgType() != 101) {
                                        hashMap.put(chatObject, 1);
                                        ArrayList arrayList7 = new ArrayList();
                                        arrayList7.add(chatMsg);
                                        hashMap2.put(chatObject, arrayList7);
                                    } else {
                                        hashMap.put(chatObject, 0);
                                        i++;
                                        arrayList3 = arrayList;
                                        j2 = j;
                                    }
                                }
                            }
                        }
                        i++;
                        arrayList3 = arrayList;
                        j2 = j;
                    }
                    for (Map.Entry entry : hashMap2.entrySet()) {
                        ChatObject chatObject2 = (ChatObject) entry.getKey();
                        ArrayList arrayList8 = (ArrayList) entry.getValue();
                        if (arrayList8 != null && !arrayList8.isEmpty() && (importantReminderMsg = getImportantReminderMsg(arrayList8, getChatRecord(chatObject2))) != null) {
                            hashMap3.put(chatObject2, importantReminderMsg);
                        }
                    }
                    recordLastMsg(hashMap, hashMap3);
                    if (!arrayList4.isEmpty()) {
                        ChatMsgManagerImpl.getInstance(this.mContext).deliverFetchedConfigMessage(arrayList4);
                    }
                    if (!arrayList6.isEmpty()) {
                        String str4 = TAG;
                        LogUtils.d(str4, "retrieve-->delverFetchedRetrieveMessage retrieveMsgs:" + arrayList6.toString());
                        ChatMsgManagerImpl.getInstance(this.mContext).delverFetchedRetrieveMessage(arrayList6);
                    }
                    if (!arrayList5.isEmpty()) {
                        String str5 = TAG;
                        LogUtils.d(str5, "deliverStudioUsePaMessage studioMsgs ：" + arrayList5.size());
                        ChatMsgManagerImpl.getInstance(this.mContext).deliverStudioUsePaMessage(arrayList5);
                    }
                }
                return arrayList2;
            }
            return null;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public int clearAllSessionMarkTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("marktop", (Integer) 0);
            return updateChatRecordInternal(contentValues, "marktop=?", new String[]{String.valueOf(1)});
        }
        return invokeV.intValue;
    }

    public int getAllNewMsgCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return getNewMsgCount("");
        }
        return invokeV.intValue;
    }

    public List<ChatSession> getGroupSession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return getSessionListInternal("category =? AND show= ?", new String[]{String.valueOf(1), String.valueOf(1)});
        }
        return (List) invokeV.objValue;
    }

    public long getMaxMsgid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            ChatMsg chatMsgInternal = getChatMsgInternal(null, null, null, null, "msgid desc ", String.valueOf(1));
            if (chatMsgInternal == null) {
                return 0L;
            }
            return chatMsgInternal.getMsgId();
        }
        return invokeV.longValue;
    }

    public void contructChatRecordValues(ChatSession chatSession, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, chatSession, contentValues) == null) {
            if (chatSession.getName() != null) {
                contentValues.put("name", chatSession.getName());
            }
            if (chatSession.getLastMsg() != null) {
                contentValues.put("last_msg", chatSession.getLastMsg());
            }
            if (-1 != chatSession.getLastMsgTime()) {
                contentValues.put("last_msg_time", Long.valueOf(chatSession.getLastMsgTime()));
            }
            if (-1 != chatSession.getLastOpenTime()) {
                contentValues.put(TableDefine.SessionColumns.COLUMN_LAST_OPEN_TIME, Long.valueOf(chatSession.getLastOpenTime()));
            }
            if (-1 != chatSession.getNewMsgSum()) {
                contentValues.put("new_msg_sum", Long.valueOf(chatSession.getNewMsgSum()));
            }
            contentValues.put("show", Integer.valueOf(chatSession.getShow()));
            contentValues.put("msg_state", Integer.valueOf(chatSession.getState()));
            contentValues.put("chat_type", Integer.valueOf(chatSession.getChatType()));
            contentValues.put(TableDefine.SessionColumns.COLUMN_COLLECTION_TYPE, Integer.valueOf(chatSession.getCollectionType()));
            contentValues.put("icon_url", chatSession.getIconUrl());
            contentValues.put("isclicked", Integer.valueOf(chatSession.getIsClicked()));
            if (chatSession.getClassType() > 0) {
                contentValues.put("classtype", Integer.valueOf(chatSession.getClassType()));
                contentValues.put("classshow", Integer.valueOf(chatSession.getClassShow()));
                contentValues.put("classtitle", chatSession.getClassTitle());
                contentValues.put("classavatar", chatSession.getClassAvatar());
            }
            contentValues.put("marktop", Integer.valueOf(chatSession.getMarkTop()));
            contentValues.put("marktoptime", Long.valueOf(chatSession.getMarkTopTime()));
            if (chatSession.getNickName() != null) {
                contentValues.put("nickname", chatSession.getNickName());
            }
            if (!TextUtils.isEmpty(chatSession.getExt())) {
                contentValues.put("extra", chatSession.getExt());
            }
            if (!TextUtils.isEmpty(chatSession.getVPortrait())) {
                contentValues.put("v_portrait", chatSession.getVPortrait());
            }
            if (!TextUtils.isEmpty(chatSession.getCertification())) {
                contentValues.put("certification", chatSession.getCertification());
            }
            if (!TextUtils.isEmpty(chatSession.getVipId())) {
                contentValues.put("vip_id", chatSession.getVipId());
            }
            contentValues.put("last_msg_bduid", Long.valueOf(chatSession.getLastMsgUid()));
            contentValues.put("last_msg_name", chatSession.getLastMsgName());
            contentValues.put("shield", Integer.valueOf(chatSession.getShield()));
            contentValues.put("shield_time", Long.valueOf(chatSession.getShieldTime()));
            contentValues.put("disturb", Integer.valueOf(chatSession.getDisturb()));
            contentValues.put("is_stranger", Integer.valueOf(chatSession.getIsStranger()));
            contentValues.put("map_type", Integer.valueOf(chatSession.getMapType()));
            if (chatSession.getNewMsgSum() == 0 || ((chatSession.getNewMsgSum() > 0 && chatSession.getRemindType() > 0 && chatSession.getRemindMsgid() > 0) || chatSession.isHandlerChangeRole())) {
                contentValues.put("remind_type", Integer.valueOf(chatSession.getRemindType()));
                contentValues.put("remind_msgid", Long.valueOf(chatSession.getRemindMsgid()));
                contentValues.put("remind_uid", Long.valueOf(chatSession.getRemindUid()));
                contentValues.put("remind_role_display_name", chatSession.getRemindRoleDisplayName());
                chatSession.setHandlerChangeRole(false);
                contentValues.put("highlight_desc", chatSession.getHighlightDesc());
                contentValues.put("highlight_priority", Integer.valueOf(chatSession.getHighlightPriority()));
                contentValues.put("highlight_data_id", Integer.valueOf(chatSession.getHighlightDataId()));
            }
            if (chatSession.getNewMsgSum() > 0 && chatSession.getHighlightPriority() > 0 && !TextUtils.isEmpty(chatSession.getHighlightDesc())) {
                contentValues.put("highlight_desc", chatSession.getHighlightDesc());
                contentValues.put("highlight_priority", Integer.valueOf(chatSession.getHighlightPriority()));
                contentValues.put("highlight_data_id", Integer.valueOf(chatSession.getHighlightDataId()));
            }
            if (chatSession.getLastMsgidFromMe() > 0) {
                contentValues.put("last_msgid_from_me", Long.valueOf(chatSession.getLastMsgidFromMe()));
            }
        }
    }

    public long createChatSession(ChatObject chatObject, String str, int i, String str2, int i2, String str3, String str4, int i3, int i4, long j, int i5, long j2, String str5, String str6, String str7, String str8) {
        InterceptResult invokeCommon;
        ArrayList<ChatMsg> arrayList;
        ChatMsg chatMsg;
        int i6;
        int unReadMsgCount;
        String str9;
        long j3;
        int i7;
        long j4;
        long j5;
        int i8;
        String str10;
        ArrayList<ChatMsg> fetchMsgExcludeTypes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{chatObject, str, Integer.valueOf(i), str2, Integer.valueOf(i2), str3, str4, Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j), Integer.valueOf(i5), Long.valueOf(j2), str5, str6, str7, str8})) == null) {
            if (getChatRecord(chatObject) != null) {
                return 0L;
            }
            int category = chatObject.getCategory();
            long contacter = chatObject.getContacter();
            ArrayList<ChatMsg> arrayList2 = null;
            synchronized (DBBase.mSyncLock) {
                if (category == 0 && i == 0) {
                    contacter = IMUserManager.getInstance(this.mContext).getBuidByUK(contacter);
                }
                ChatSession chatSession = new ChatSession(category, chatObject.getContacter(), contacter, str);
                ChatMsg draftMsg = getDraftMsg(chatObject.getCategory(), chatObject.getContacter());
                if (draftMsg == null) {
                    if (1 == chatObject.getCategory()) {
                        if (i == 4) {
                            fetchMsgExcludeTypes = GroupMessageDAOImpl.fetchLastChatMsg(this.mContext, String.valueOf(chatObject.getContacter()), null, 1L, true);
                        } else {
                            fetchMsgExcludeTypes = GroupMessageDAOImpl.fetchAllChatMsg(this.mContext, String.valueOf(chatObject.getContacter()), null, 1L, true);
                        }
                    } else {
                        fetchMsgExcludeTypes = getInstance(this.mContext).fetchMsgExcludeTypes(chatObject, 0L, 1L, UNUPDATE_SESSION_MSG_TYPES);
                    }
                    arrayList2 = fetchMsgExcludeTypes;
                    if (arrayList2 == null) {
                        LogUtils.e(TAG, "updateChatRecordName fetchmsg error! ");
                        return -1L;
                    } else if (arrayList2.size() == 0) {
                        LogUtils.e(TAG, "updateChatRecordName  msgs.size() = 0! ");
                        return 0L;
                    } else {
                        draftMsg = arrayList2.get(0);
                    }
                }
                ArrayList<ChatMsg> arrayList3 = arrayList2;
                ChatMsg chatMsg2 = draftMsg;
                String str11 = "";
                if (chatObject.getCategory() == 0 && (chatObject.getContacter() & 17592186044416L) != 0) {
                    if (!chatMsg2.isSelf(this.mContext)) {
                        arrayList = arrayList3;
                        chatMsg = chatMsg2;
                        str10 = chatMsg2.getExtLog();
                        i6 = 0;
                    } else {
                        arrayList = arrayList3;
                        i6 = 0;
                        chatMsg = chatMsg2;
                        ArrayList<ChatMsg> fetchMsg = fetchMsg(chatObject, 0L, 1L, -1L, false, "from_user != " + Utility.getUK(this.mContext));
                        if (fetchMsg != null && fetchMsg.size() > 0) {
                            str11 = fetchMsg.get(0).getExtLog();
                        }
                        str10 = str11;
                    }
                    chatSession.addExt(BasicVideoParserKt.EXT_LOG, str10);
                } else {
                    arrayList = arrayList3;
                    chatMsg = chatMsg2;
                    i6 = 0;
                }
                if (1 == chatObject.getCategory()) {
                    unReadMsgCount = GroupMessageDAOImpl.getUnReadCount(this.mContext, String.valueOf(chatObject.getContacter()));
                } else {
                    unReadMsgCount = getUnReadMsgCount(chatObject);
                }
                chatSession.setChatType(i);
                if (unReadMsgCount >= 0) {
                    chatSession.setNewMsgSum(unReadMsgCount);
                    if (1 == chatObject.getCategory()) {
                        MultiplePair<Integer, Long, Long, String> importantReminderMsg = GroupMessageManagerImpl.getInstance(this.mContext).getImportantReminderMsg(arrayList);
                        String str12 = "";
                        if (importantReminderMsg != null) {
                            i8 = ((Integer) ((Pair) importantReminderMsg).first).intValue();
                            long longValue = ((Long) ((Pair) importantReminderMsg).second).longValue();
                            j5 = importantReminderMsg.third.longValue();
                            j4 = longValue;
                            str12 = importantReminderMsg.fourth;
                        } else {
                            j4 = 0;
                            j5 = 0;
                            i8 = 0;
                        }
                        if (i8 > 0 && j4 > 0) {
                            chatSession.setRemindType(i8);
                            chatSession.setRemindMsgId(j4);
                            chatSession.setRemindUid(j5);
                            chatSession.setRemindRoleDisplayName(str12);
                        }
                    } else {
                        MultiplePair<String, Integer, Long, Integer> importantReminderMsg2 = getImportantReminderMsg(arrayList, chatSession);
                        if (importantReminderMsg2 == null) {
                            str9 = "";
                            j3 = 0;
                            i7 = 0;
                        } else {
                            String str13 = (String) ((Pair) importantReminderMsg2).first;
                            i7 = ((Integer) ((Pair) importantReminderMsg2).second).intValue();
                            j3 = importantReminderMsg2.third.longValue();
                            str9 = str13;
                        }
                        chatSession.setHighlightPriority(i7);
                        chatSession.setHighlightDesc(str9);
                        if (j3 > 0) {
                            chatSession.setLastMsgidFromMe(j3);
                        }
                    }
                }
                String recommendDescription = chatMsg.getRecommendDescription();
                if (!TextUtils.isEmpty(chatMsg.getPreviewDesc())) {
                    recommendDescription = chatMsg.getPreviewDesc();
                }
                ChatMsg chatMsg3 = chatMsg;
                if ((chatMsg3 instanceof HtmlMsg) && !TextUtils.isEmpty(chatMsg3.getLocalUrl())) {
                    recommendDescription = chatMsg3.getLocalUrl();
                }
                chatSession.setLastOpenTime(chatMsg3.getMsgTime());
                chatSession.setLastMsgTime(chatMsg3.getMsgTime());
                chatSession.setLastMsg(recommendDescription);
                chatSession.setState(chatMsg3.getStatus());
                chatSession.setIconUrl(str2);
                chatSession.setIsClicked(Utility.getClickState(chatMsg3));
                chatSession.setPaid(chatObject.getPaid());
                chatSession.setClassType(i2);
                chatSession.setClassTitle(str3);
                chatSession.setClassAvatar(str4);
                chatSession.setClassShow(i3);
                chatSession.setMarkTop(i4);
                chatSession.setMarkTopTime(j);
                chatSession.setVipId(str5);
                chatSession.setVPortrait(str6);
                chatSession.setCertification(str7);
                chatSession.setShield(i5);
                chatSession.setShieldTime(j2);
                if (chatObject.getBusinessType() > 0) {
                    chatSession.setBusinessType(chatObject.getBusinessType());
                }
                if (!TextUtils.isEmpty(str8)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str8);
                        int optInt = jSONObject.optInt("disturb");
                        int optInt2 = jSONObject.optInt("stranger");
                        int optInt3 = jSONObject.optInt("map_type");
                        chatSession.setDisturb(optInt);
                        chatSession.setIsStranger(optInt2);
                        chatSession.setMapType(optInt3);
                    } catch (JSONException e) {
                        LogUtils.e(TAG, "createChatSession exception ", e);
                    }
                }
                setChatSessionLastName(chatSession, chatMsg3.getSenderUid());
                if (chatMsg3.isStarMessage()) {
                    chatSession.setChatType(4);
                }
                return getInstance(this.mContext).updateChatSession(i6, chatSession);
            }
        }
        return invokeCommon.longValue;
    }

    public long delAllMsgAndSession() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                long j = 0;
                if (openDatabase == null) {
                    LogUtils.d(TAG, "getWritableDb fail!");
                    return 0L;
                }
                String path = openDatabase.getPath();
                String str = TAG;
                LogUtils.d(str, "db path: " + path);
                if (TextUtils.isEmpty(path)) {
                    return 0L;
                }
                File file = new File(path);
                long length = file.length();
                String str2 = TAG;
                LogUtils.d(str2, "--删除前单聊db大小 = " + length);
                try {
                    openDatabase.beginTransaction();
                    int delChatMsgInternal = delChatMsgInternal(null, null);
                    String str3 = TAG;
                    LogUtils.d(str3, "--删除消息 = " + delChatMsgInternal);
                    String[] strArr = {String.valueOf(9)};
                    List<ChatSession> sessionListInternal = getSessionListInternal("category != ?", strArr);
                    int delChatRecordInternal = delChatRecordInternal("category != ?", strArr);
                    String str4 = TAG;
                    LogUtils.d(str4, "--删除会话 = " + delChatRecordInternal);
                    long deleteGroupData = GroupMessageDAOImpl.deleteGroupData(this.mContext);
                    String str5 = TAG;
                    LogUtils.d(str5, "--删除群数据大小 = " + deleteGroupData);
                    if (delChatMsgInternal >= 0 && delChatRecordInternal >= 0 && deleteGroupData >= 0) {
                        openDatabase.setTransactionSuccessful();
                        z = true;
                    } else {
                        z = false;
                    }
                    try {
                        openDatabase.endTransaction();
                    } catch (Exception e) {
                        LogUtils.e(TAG, "delMsgsOfPaByPaId finally:", e);
                    }
                    if (z) {
                        openDatabase.execSQL("VACUUM;");
                        long length2 = file.length();
                        String str6 = TAG;
                        LogUtils.d(str6, "--删除后单聊db大小 = " + length2);
                        j = (length - length2) + deleteGroupData;
                        notifyDbChange(3, sessionListInternal);
                    }
                    String str7 = TAG;
                    LogUtils.d(str7, "--删除尺寸 = " + j);
                    return j;
                } catch (Exception e2) {
                    LogUtils.e(TAG, "delAllMsgAndSession:", e2);
                    try {
                        openDatabase.endTransaction();
                    } catch (Exception e3) {
                        LogUtils.e(TAG, "delMsgsOfPaByPaId finally:", e3);
                    }
                    return 0L;
                }
            }
        }
        return invokeV.longValue;
    }

    public int delMsgsOfCertainContacter(ChatObject chatObject, long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{chatObject, Long.valueOf(j), Integer.valueOf(i)})) == null) {
            int i2 = 1;
            if (1 == chatObject.getCategory()) {
                int delMsgsOfCertainContacter = GroupMessageDAOImpl.delMsgsOfCertainContacter(this.mContext, String.valueOf(chatObject.getContacter()), j);
                long maxMsgid = GroupMessageDAOImpl.getMaxMsgid(this.mContext, String.valueOf(chatObject.getContacter()));
                if (j == -1 || maxMsgid <= j) {
                    if (i == 1) {
                        GroupMessageDAOImpl.deleteSendFailedMsg(this.mContext, String.valueOf(chatObject.getContacter()));
                        updateChatSessionAfterClearMsg(chatObject);
                    } else {
                        i2 = delChatRecord(chatObject);
                    }
                }
                if (i2 < 0) {
                    return -1;
                }
                return delMsgsOfCertainContacter;
            }
            return delMsgsOfCertainContacterForSingle(chatObject, j, i);
        }
        return invokeCommon.intValue;
    }

    public ArrayList<ChatMsg> fetchMsgByContacterIdOrderByMsgid(List<Long> list, long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{list, Long.valueOf(j), Integer.valueOf(i)})) == null) {
            if (list != null && list.size() > 0) {
                String str = "contacter" + buildINStatement(list);
                if (j > 0) {
                    str = str + " AND msgid < " + j;
                }
                return getMsgListInternal(str, null, null, null, "msgid desc ", String.valueOf(Math.abs(i)));
            }
            return new ArrayList<>();
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<ChatMsg> fetchMsgsByTopicSourceTag(long j, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z), str})) == null) {
            return getMsgListWithTagInternal((("messsage_tag = ? AND msgid > ?") + " AND time > ?") + " AND is_read = ?", new String[]{str, String.valueOf(0), String.valueOf(j), String.valueOf(z ? 1 : 0)}, null, null, "msgid desc ", null);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public void updateConsultSession(int i, ChatSession chatSession, ChatSession chatSession2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048669, this, i, chatSession, chatSession2) == null) {
            if (chatSession != null) {
                delChatRecordInternal("category = ? AND contacter = ?", new String[]{String.valueOf(chatSession.getCategory()), String.valueOf(chatSession.getContacter())});
            }
            if (i != 2 && chatSession2 != null) {
                ContentValues contentValues = new ContentValues();
                contructChatRecordValues(chatSession2, contentValues);
                contentValues.put("category", Integer.valueOf(chatSession2.getCategory()));
                contentValues.put("contacter", Long.valueOf(chatSession2.getContacter()));
                synchronized (DBBase.mSyncLock) {
                    insert(TableDefine.DB_TABLE_CHAT_SESSION, contentValues);
                }
                notifyDbChange(i, chatSession2);
                return;
            }
            notifyDbChange(2, chatSession);
        }
    }

    public ChatMsg updateReplyChatMsgQuoteData(long j, int i, String str) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048672, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str})) == null) {
            synchronized (DBBase.mSyncLock) {
                ChatMsg chatMsgByMsgId = getChatMsgByMsgId(j);
                if (chatMsgByMsgId != null && !TextUtils.isEmpty(chatMsgByMsgId.getMsgContent())) {
                    String updatedMsgContent = MsgRepliedData.getUpdatedMsgContent(chatMsgByMsgId.getMsgContent(), i, str);
                    if (TextUtils.isEmpty(updatedMsgContent)) {
                        return null;
                    }
                    if (setMsgContent(j, updatedMsgContent) <= 0) {
                        return null;
                    }
                    chatMsgByMsgId.setMsgContent(updatedMsgContent);
                    return chatMsgByMsgId;
                }
                String str2 = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("updateReplyChatMsgQuoteData chat msg invalid:");
                if (chatMsgByMsgId == null) {
                    z = true;
                } else {
                    z = false;
                }
                sb.append(z);
                LogUtils.d(str2, sb.toString());
                return null;
            }
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    public long delSysMsg(int i, long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)})) == null) {
            return delChatMsgInternal("category = ?  AND (contacter = ? OR from_user = ? ) AND cmd = ? ", new String[]{String.valueOf(i), String.valueOf(j), String.valueOf(j), String.valueOf(i2)});
        }
        return invokeCommon.longValue;
    }

    public int deleteAllMsgWithMsgid(ChatObject chatObject, long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{chatObject, Long.valueOf(j), Integer.valueOf(i)})) == null) {
            synchronized (this.mContext) {
                int delMsgsOfCertainContacter = getInstance(this.mContext).delMsgsOfCertainContacter(chatObject, j, i);
                if (delMsgsOfCertainContacter < 0) {
                    return -1009;
                }
                ArrayList<ChatMsg> fetchMsg = fetchMsg(chatObject, Long.MAX_VALUE, 2L, -1L);
                if (fetchMsg != null && fetchMsg.size() > 0) {
                    return 0;
                }
                return delMsgsOfCertainContacter;
            }
        }
        return invokeCommon.intValue;
    }

    public ArrayList<ChatMsg> fetchMsg(ChatObject chatObject, long j, long j2) {
        InterceptResult invokeCommon;
        long j3;
        ArrayList<ChatMsg> fetchMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{chatObject, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            synchronized (DBBase.mSyncLock) {
                if (j == 0) {
                    j3 = -1;
                } else {
                    j3 = Long.MAX_VALUE;
                }
                fetchMsg = fetchMsg(chatObject, j, j2, j3, false);
            }
            return fetchMsg;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public List<ChatSession> getStrangerSessionList(long j, long j2, int i) {
        InterceptResult invokeCommon;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048640, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)})) == null) {
            String[] strArr = {String.valueOf(1), String.valueOf(j), String.valueOf(j2)};
            if (i > 0) {
                str = String.valueOf(i);
            } else {
                str = null;
            }
            return getSessionListInternal("is_stranger = ? AND last_msg_time >= ?  AND last_msg_time <= ? ", strArr, null, null, "last_msg_time DESC ", str);
        }
        return (List) invokeCommon.objValue;
    }

    public int updateChatRecordExtAndNotify(int i, long j, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048662, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), str})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("extra", str);
            return updateChatRecordInternalAndNotify(contentValues, "category = ? AND contacter = ?", new String[]{String.valueOf(i), String.valueOf(j)}, 9);
        }
        return invokeCommon.intValue;
    }

    public int updateSessionDisturb(int i, long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048677, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("disturb", Integer.valueOf(i2));
            return updateChatRecordInternalAndNotify(contentValues, "category =? AND contacter = ?", new String[]{String.valueOf(i), String.valueOf(j)}, 7);
        }
        return invokeCommon.intValue;
    }

    public int updateSessionStranger(int i, long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048678, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_stranger", Integer.valueOf(i2));
            return updateChatRecordInternalAndNotify(contentValues, "category =? AND contacter = ?", new String[]{String.valueOf(i), String.valueOf(j)}, 8);
        }
        return invokeCommon.intValue;
    }

    public ArrayList<ChatMsg> fetchMsg(ChatObject chatObject, long j, long j2, long j3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{chatObject, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)})) == null) {
            return fetchMsg(chatObject, j, j2, j3, z, null);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<ChatMsg> fetchMsgsExceptGroupSystemMsgSync(ChatObject chatObject, long j, long j2, long j3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{chatObject, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)})) == null) {
            return fetchMsg(chatObject, j, j2, j3, z, "type != 101");
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<ChatMsg> fetchMsg(ChatObject chatObject, ChatMsg chatMsg, long j, boolean z) {
        InterceptResult invokeCommon;
        long msgId;
        long rowId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048603, this, new Object[]{chatObject, chatMsg, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            if (1 == chatObject.getCategory()) {
                return GroupMessageDAOImpl.fetchAllChatMsg(this.mContext, String.valueOf(chatObject.getContacter()), chatMsg, j, z);
            }
            if (chatMsg == null) {
                msgId = 0;
            } else {
                msgId = chatMsg.getMsgId();
            }
            long j2 = msgId;
            if (chatMsg == null) {
                rowId = -1;
            } else {
                rowId = chatMsg.getRowId();
            }
            return fetchMsg(chatObject, j2, j, rowId, z, null);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<ChatMsg> fetchMsgExcludeTypes(ChatObject chatObject, long j, long j2, List<Integer> list) {
        InterceptResult invokeCommon;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{chatObject, Long.valueOf(j), Long.valueOf(j2), list})) == null) {
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

    public int updateChatSessionMarkTop(int i, long j, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048666, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("marktop", Integer.valueOf(i2));
            contentValues.put("marktoptime", Long.valueOf(j2));
            return updateChatRecordInternalAndNotify(contentValues, "category = ? AND contacter = ?", new String[]{String.valueOf(i), String.valueOf(j)}, 5);
        }
        return invokeCommon.intValue;
    }

    public int updateChatSessionShield(int i, long j, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048668, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("shield", Integer.valueOf(i2));
            contentValues.put("shield_time", Long.valueOf(j2));
            return updateChatRecordInternalAndNotify(contentValues, "category = ? AND contacter = ?", new String[]{String.valueOf(i), String.valueOf(j)}, 6);
        }
        return invokeCommon.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<ChatMsg> fetchMsgsByMsgTypes(ChatObject chatObject, long j, long j2, List<Integer> list) {
        InterceptResult invokeCommon;
        String str;
        long j3;
        ArrayList<ChatMsg> fetchMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{chatObject, Long.valueOf(j), Long.valueOf(j2), list})) == null) {
            synchronized (DBBase.mSyncLock) {
                if (list != null) {
                    try {
                        if (list.size() > 0) {
                            StringBuilder sb = new StringBuilder();
                            for (Integer num : list) {
                                sb.append(num.intValue());
                                sb.append(",");
                            }
                            str = "type IN (" + sb.substring(0, sb.length() - 1) + ") ";
                            String str2 = str;
                            if (j != 0) {
                                j3 = -1;
                            } else {
                                j3 = Long.MAX_VALUE;
                            }
                            fetchMsg = fetchMsg(chatObject, j, j2, j3, false, str2);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                str = null;
                String str22 = str;
                if (j != 0) {
                }
                fetchMsg = fetchMsg(chatObject, j, j2, j3, false, str22);
            }
            return fetchMsg;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<ChatSession> getChatRecords(long j, long j2, List<Integer> list) {
        InterceptResult invokeCommon;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048620, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), list})) == null) {
            long j3 = j2 + j;
            String str3 = "show= ?";
            if (list != null && list.size() > 0) {
                str3 = "show= ? AND chat_type" + buildINStatement(list);
            }
            String str4 = str3;
            LogUtils.e(TAG, str4);
            if (j3 > 0) {
                str = String.valueOf(j3);
            } else {
                str = null;
            }
            if (j > 0) {
                str2 = str + " OFFSET " + j;
            } else {
                str2 = str;
            }
            ArrayList<ChatSession> arrayList = new ArrayList<>();
            List<ChatSession> sessionListInternal = getSessionListInternal(str4, new String[]{String.valueOf(1)}, null, null, "last_msg_time desc ", str2);
            if (sessionListInternal != null) {
                arrayList.addAll(sessionListInternal);
            }
            return arrayList;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public int getNewMsgCountWithStranger(List<Integer> list, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048633, this, new Object[]{list, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (list != null && list.size() > 0) {
                String str = "chat_type" + buildINStatement(list) + " AND is_stranger = " + i + " AND map_type != 1";
                if (j > 0) {
                    String str2 = str + " AND (marktop = 1 OR last_msg_time >= " + TimeUtil.getTimeSecondByInterval(j);
                    if (BIMManager.hudongTop) {
                        str2 = str2 + " OR classtype = 11";
                    }
                    str = str2 + SmallTailInfo.EMOTION_SUFFIX;
                }
                return getNewMsgCount(str);
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    public int getNewMsgCountWithStrangerAndNoDisturb(List<Integer> list, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048634, this, new Object[]{list, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (list != null && list.size() > 0) {
                String str = "chat_type" + buildINStatement(list) + " AND is_stranger = " + i + " AND map_type != 1 AND disturb = 1";
                if (j > 0) {
                    String str2 = str + " AND (marktop = 1 OR last_msg_time >= " + TimeUtil.getTimeSecondByInterval(j);
                    if (BIMManager.hudongTop) {
                        str2 = str2 + " OR classtype = 11";
                    }
                    str = str2 + SmallTailInfo.EMOTION_SUFFIX;
                }
                return getNewMsgCount(str);
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    public List<ChatSession> getNewUnReadSessionList(long j, long j2, int i, List<Integer> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048636, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), list})) == null) {
            ArrayList arrayList = new ArrayList();
            synchronized (DBBase.mSyncLock) {
                if (list != null) {
                    if (list.size() > 0) {
                        List<ChatSession> unReadSessionList = getUnReadSessionList(j, j2, i, list);
                        if (unReadSessionList != null) {
                            for (ChatSession chatSession : unReadSessionList) {
                                if (arrayList.size() >= i) {
                                    break;
                                } else if (chatSession != null) {
                                    if (chatSession.getChatType() == 7) {
                                        List<PaInfo> paInfoListFromDb = PaInfoDBManager.getInstance(this.mContext).getPaInfoListFromDb(Collections.singletonList(Long.valueOf(chatSession.getContacter())));
                                        if (paInfoListFromDb != null && !paInfoListFromDb.isEmpty()) {
                                            if (paInfoListFromDb.get(0).getSubsetType() == 16) {
                                                chatSession.setBusinessType(4);
                                            } else if (paInfoListFromDb.get(0).getSubsetType() == 21) {
                                                chatSession.setBusinessType(6);
                                            }
                                            arrayList.add(chatSession);
                                        }
                                    } else {
                                        arrayList.add(chatSession);
                                    }
                                }
                            }
                        }
                        if (arrayList.size() < i) {
                            List<ChatSession> sessionListInternal = getSessionListInternal("classtype > 1 AND classshow > 0 AND new_msg_sum > 0 AND last_msg_time > " + j + " AND chat_type" + buildINStatement(list), null, "classtype", null, null, null);
                            if (sessionListInternal != null && sessionListInternal.size() > 0) {
                                for (int i2 = 0; i2 < sessionListInternal.size(); i2++) {
                                    ChatSession chatSession2 = sessionListInternal.get(i2);
                                    if (Utility.isValidAggSession(chatSession2.getClassType(), chatSession2.getClassShow())) {
                                        ArrayList arrayList2 = new ArrayList();
                                        arrayList2.add(Integer.valueOf(chatSession2.getClassType()));
                                        ArrayList<ChatSession> chatRecordsByClass = getChatRecordsByClass(i - arrayList.size(), arrayList2);
                                        if (chatRecordsByClass != null && chatRecordsByClass.size() != 0) {
                                            ChatSession chatSession3 = chatRecordsByClass.get(0);
                                            long lastMsgTime = chatSession3.getLastMsgTime();
                                            if (lastMsgTime >= j && lastMsgTime <= j2) {
                                                chatSession3.setNewMsgSum(getNewMsgCountOfClass(chatSession3.getClassType()));
                                                chatSession3.setSessionFrom(2);
                                                arrayList.add(chatSession3);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        return arrayList;
                    }
                }
                return arrayList;
            }
        }
        return (List) invokeCommon.objValue;
    }

    public ArrayList<ChatMsg> getPaMsgByChatTypeAndPaidList(List<Integer> list, List<Long> list2, long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048638, this, new Object[]{list, list2, Long.valueOf(j), Integer.valueOf(i)})) == null) {
            List<Long> contacterByChatTypes = getContacterByChatTypes(list);
            HashSet hashSet = new HashSet();
            if (list2 != null) {
                hashSet.addAll(list2);
            }
            if (contacterByChatTypes != null) {
                hashSet.addAll(contacterByChatTypes);
            }
            return fetchMsgByContacterIdOrderByMsgid(new ArrayList(hashSet), j, i);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public List<ChatSession> getSessionList(long j, long j2, int i, int i2, int i3, List<Integer> list, SessionParam sessionParam) {
        InterceptResult invokeCommon;
        boolean z;
        List<ChatSession> sessionListNoTop;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048639, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), list, sessionParam})) == null) {
            ArrayList arrayList = new ArrayList();
            synchronized (DBBase.mSyncLock) {
                try {
                    if (i2 == 2) {
                        return getStrangerSessionList(j, j2, i);
                    }
                    if (list != null && list.size() > 0) {
                        int i4 = i > 0 ? i + 1 : i - 1;
                        if (i3 == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            sessionListNoTop = getSessionListWithTop(j, j2, i4, list);
                        } else {
                            sessionListNoTop = getSessionListNoTop(j, j2, i4, list);
                        }
                        if (sessionListNoTop != null) {
                            arrayList.addAll(sessionListNoTop);
                        }
                        List<ChatSession> sessionListInternal = getSessionListInternal("classtype > 1 AND classshow > 0 AND chat_type" + buildINStatement(list), null, "classtype", null, null, null);
                        if (sessionListInternal != null && sessionListInternal.size() > 0) {
                            z2 = false;
                            for (int i5 = 0; i5 < sessionListInternal.size(); i5++) {
                                ChatSession chatSession = sessionListInternal.get(i5);
                                if (Utility.isValidAggSession(chatSession.getClassType(), chatSession.getClassShow())) {
                                    ArrayList arrayList2 = new ArrayList();
                                    arrayList2.add(Integer.valueOf(chatSession.getClassType()));
                                    ArrayList<ChatSession> chatRecordsByClass = getChatRecordsByClass(1L, arrayList2);
                                    if (chatRecordsByClass != null && chatRecordsByClass.size() != 0) {
                                        ChatSession chatSession2 = chatRecordsByClass.get(0);
                                        long lastMsgTime = chatSession2.getLastMsgTime();
                                        if (z || (lastMsgTime >= j && lastMsgTime <= j2)) {
                                            chatSession2.setNewMsgSum(getNewMsgCountOfClass(chatSession2.getClassType()));
                                            chatSession2.setSessionFrom(2);
                                            if (chatSession2.getClassType() == 11 && sessionParam != null && sessionParam.hudongNeedTop) {
                                                chatSession2.setMarkTop(1);
                                                chatSession2.setMarkTopTime(9223372036854765807L);
                                                arrayList.add(chatSession2);
                                                z2 = true;
                                            } else {
                                                arrayList.add(chatSession2);
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            z2 = false;
                        }
                        if (sessionParam != null && sessionParam.hudongNeedTop && !z2) {
                            arrayList.add(creatTopAndNullHudongSession());
                        }
                        List<ChatSession> strangerSessionList = getStrangerSessionList(0L, Long.MAX_VALUE, 1);
                        if (strangerSessionList != null && strangerSessionList.size() > 0) {
                            for (ChatSession chatSession3 : strangerSessionList) {
                                long lastMsgTime2 = chatSession3.getLastMsgTime();
                                if (z || (lastMsgTime2 >= j && lastMsgTime2 <= j2)) {
                                    chatSession3.setSessionFrom(2);
                                    chatSession3.setNewMsgSum(getStrangerUnReadCount(0L));
                                    arrayList.add(chatSession3);
                                }
                            }
                        }
                        Collections.sort(arrayList, new Comparator<ChatSession>(this) { // from class: com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ ChatMessageDBManager this$0;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i6 = newInitContext.flag;
                                    if ((i6 & 1) != 0) {
                                        int i7 = i6 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            public int compare(ChatSession chatSession4, ChatSession chatSession5) {
                                InterceptResult invokeLL;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, chatSession4, chatSession5)) == null) {
                                    if (chatSession4.getMarkTop() == 1 && chatSession5.getMarkTop() == 1) {
                                        int i6 = ((chatSession5.getMarkTopTime() - chatSession4.getMarkTopTime()) > 0L ? 1 : ((chatSession5.getMarkTopTime() - chatSession4.getMarkTopTime()) == 0L ? 0 : -1));
                                        if (i6 > 0) {
                                            return 1;
                                        }
                                        if (i6 < 0) {
                                            return -1;
                                        }
                                        return 0;
                                    } else if (chatSession4.getMarkTop() == 0 && chatSession5.getMarkTop() == 0) {
                                        int i7 = ((chatSession5.getLastMsgTime() - chatSession4.getLastMsgTime()) > 0L ? 1 : ((chatSession5.getLastMsgTime() - chatSession4.getLastMsgTime()) == 0L ? 0 : -1));
                                        if (i7 > 0) {
                                            return 1;
                                        }
                                        if (i7 < 0) {
                                            return -1;
                                        }
                                        return 0;
                                    } else {
                                        return chatSession5.getMarkTop() - chatSession4.getMarkTop();
                                    }
                                }
                                return invokeLL.intValue;
                            }
                        });
                        if (arrayList.size() > Math.abs(i4)) {
                            return arrayList.subList(0, Math.abs(i4));
                        }
                        return arrayList;
                    }
                    return arrayList;
                } finally {
                }
            }
        }
        return (List) invokeCommon.objValue;
    }

    public ArrayList<ChatMsg> getStudioUsePaUnReadMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            ArrayList<ChatMsg> arrayList = new ArrayList<>();
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                Cursor cursor = null;
                try {
                    if (openDatabase == null) {
                        return null;
                    }
                    try {
                        Cursor query = openDatabase.query(TableDefine.DB_TABLE_STUDIO_USE_PA_MESSAGE, null, "is_read =?", new String[]{String.valueOf(0)}, null, null, null, null);
                        if (query != null) {
                            while (query.moveToNext()) {
                                try {
                                    ChatMsg generateStudioUsePaMsg = generateStudioUsePaMsg(query);
                                    if (generateStudioUsePaMsg != null) {
                                        arrayList.add(generateStudioUsePaMsg);
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    cursor = query;
                                    LogUtils.e(TAG, "getStudioUsePaUnReadMsg :", e);
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return arrayList;
                                } catch (Throwable th) {
                                    th = th;
                                    cursor = query;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    throw th;
                                }
                            }
                            if (query != null) {
                                query.close();
                            }
                            return arrayList;
                        }
                        if (query != null) {
                            query.close();
                        }
                        return null;
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } else {
            return (ArrayList) invokeV.objValue;
        }
    }

    public List<Integer> getUnreadChatTypesByAllClassType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                ArrayList arrayList = new ArrayList();
                Cursor cursor = null;
                try {
                    if (openDatabase == null) {
                        return null;
                    }
                    try {
                        Cursor query = openDatabase.query(true, TableDefine.DB_TABLE_CHAT_SESSION, new String[]{"chat_type"}, "classtype > 1 AND new_msg_sum > 0", null, null, null, null, null);
                        if (query != null) {
                            while (query.moveToNext()) {
                                try {
                                    arrayList.add(Integer.valueOf(CursorWrapper.getInt(query, "chat_type")));
                                } catch (Exception e) {
                                    e = e;
                                    cursor = query;
                                    LogUtils.e(TAG, "getUnreadChatTypesByAllClassType:", e);
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return arrayList;
                                } catch (Throwable th) {
                                    th = th;
                                    cursor = query;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    throw th;
                                }
                            }
                            if (query != null) {
                                query.close();
                            }
                            return arrayList;
                        }
                        if (query != null) {
                            query.close();
                        }
                        return null;
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } else {
            return (List) invokeV.objValue;
        }
    }

    public void getUsedEmojiContent(int i, int i2, boolean z, int i3, BIMValueCallBack<List<String>> bIMValueCallBack) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048646, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), bIMValueCallBack}) == null) {
            synchronized (DBBase.mSyncLock) {
                ArrayList arrayList = new ArrayList();
                SQLiteDatabase openDatabase = openDatabase();
                try {
                } catch (Exception e) {
                    LogUtils.d(TAG, "getUsedEmojiContent:" + e);
                }
                if (openDatabase == null) {
                    LogUtils.e(TAG, "getUsedEmojiContent db is null!");
                    if (bIMValueCallBack != null) {
                        bIMValueCallBack.onResult(1009, "", arrayList);
                    }
                    return;
                }
                String str2 = "ASC";
                if (i3 < 0) {
                    str2 = "DESC";
                }
                if (z) {
                    str = "time";
                } else {
                    str = "count";
                }
                String str3 = "SELECT * FROM used_emoji WHERE package_id = " + i + " AND category = " + i2 + " ORDER BY " + str + " " + str2 + " LIMIT " + Math.abs(i3);
                LogUtils.d(TAG, "sql = " + str3);
                Cursor rawQuery = openDatabase.rawQuery(str3, null);
                if (rawQuery != null) {
                    while (rawQuery.moveToNext()) {
                        arrayList.add(CursorWrapper.getString(rawQuery, "emoji_content"));
                    }
                }
                LogUtils.d(TAG, "getUsedEmojiContent :" + arrayList);
                if (bIMValueCallBack != null) {
                    bIMValueCallBack.onResult(0, "", arrayList);
                }
            }
        }
    }

    public void recordLastMsg(ChatObject chatObject, String str, long j, int i, int i2, int i3, boolean z, String str2, String str3, int i4, long j2, long j3, String str4, String str5, int i5, long j4, int i6) {
        ChatSession mediaChatSession;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048650, this, new Object[]{chatObject, str, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), str2, str3, Integer.valueOf(i4), Long.valueOf(j2), Long.valueOf(j3), str4, str5, Integer.valueOf(i5), Long.valueOf(j4), Integer.valueOf(i6)}) == null) {
            String str6 = TAG;
            LogUtils.d(str6, "recordSendLastMsg " + chatObject.toString());
            ChatSession chatRecord = getInstance(this.mContext).getChatRecord(chatObject);
            if (chatRecord == null) {
                if (chatObject.getCategory() == 0) {
                    IMUserManager.getInstance(this.mContext).removeChatObject(chatObject.getContacter());
                }
                LogUtils.d(TAG, "recordLastMsg getChatObjectForSession");
                GetChatObjectInfoForRecordManager.getChatObjectForSession(this.mContext, chatObject);
                return;
            }
            if (chatRecord.getState() == -1 && chatRecord.getCategory() == 1) {
                GetChatObjectInfoForRecordManager.updateChatInfoDbFromSession(this.mContext, chatObject);
            }
            if (chatRecord.getState() != 3) {
                chatRecord.setLastMsg(str);
                chatRecord.setState(i2);
                chatRecord.setIsClicked(i3);
                setChatSessionLastName(chatRecord, str3);
            }
            if (i >= 0) {
                chatRecord.setNewMsgSum(i);
                chatRecord.setRemindType(i4);
                chatRecord.setRemindMsgId(j2);
                chatRecord.setRemindUid(j3);
                chatRecord.setRemindRoleDisplayName(str4);
            }
            chatRecord.setLastMsgTime(j);
            chatRecord.setShow(1);
            if (z) {
                chatRecord.setChatType(4);
            }
            if (chatObject.getBusinessType() > 0) {
                chatRecord.setBusinessType(chatObject.getBusinessType());
            }
            if (chatObject.getCategory() == 0 && (chatObject.getContacter() & 17592186044416L) != 0) {
                chatRecord.addExt(BasicVideoParserKt.EXT_LOG, str2);
                if (j4 > 0) {
                    chatRecord.setLastMsgidFromMe(j4);
                }
                chatRecord.setHighlightPriority(i5);
                chatRecord.setHighlightDesc(str5);
                chatRecord.setHighlightDataId(i6);
            }
            if (AccountManager.getMediaRole(this.mContext) && (mediaChatSession = MediaMessageDBManager.getInstance(this.mContext).getMediaChatSession(chatObject.getCategory(), chatObject.getContacter())) != null) {
                chatRecord.setMarkTop(mediaChatSession.getMarkTop());
            }
            updateChatSession(4, chatRecord);
        }
    }

    public void recordLastMsg(HashMap<ChatObject, Integer> hashMap, HashMap<ChatObject, MultiplePair<String, Integer, Long, Integer>> hashMap2) {
        long j;
        String str;
        int i;
        int i2;
        int i3;
        String str2;
        String extLog;
        MultiplePair<String, Integer, Long, Integer> multiplePair;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048651, this, hashMap, hashMap2) == null) {
            ChatMessageDBManager chatMessageDBManager = this;
            HashMap<ChatObject, MultiplePair<String, Integer, Long, Integer>> hashMap3 = hashMap2;
            LogUtils.d(TAG, "recordReceiveLastMsg");
            for (Map.Entry<ChatObject, Integer> entry : hashMap.entrySet()) {
                ChatObject key = entry.getKey();
                if (hashMap3 != null && !hashMap2.isEmpty() && (multiplePair = hashMap3.get(key)) != null) {
                    int intValue = ((Integer) ((Pair) multiplePair).second).intValue();
                    long longValue = multiplePair.third.longValue();
                    i2 = multiplePair.fourth.intValue();
                    str = (String) ((Pair) multiplePair).first;
                    i = intValue;
                    j = longValue;
                } else {
                    j = 0;
                    str = "";
                    i = 0;
                    i2 = 0;
                }
                int intValue2 = entry.getValue().intValue();
                ArrayList<ChatMsg> fetchMsgExcludeTypes = fetchMsgExcludeTypes(entry.getKey(), 0L, 1L, UNUPDATE_SESSION_MSG_TYPES);
                if (fetchMsgExcludeTypes.size() > 0) {
                    ChatMsg chatMsg = fetchMsgExcludeTypes.get(0);
                    String recommendDescription = chatMsg.getRecommendDescription();
                    if (!TextUtils.isEmpty(chatMsg.getPreviewDesc())) {
                        recommendDescription = chatMsg.getPreviewDesc();
                    }
                    if ((chatMsg instanceof HtmlMsg) && !TextUtils.isEmpty(chatMsg.getLocalUrl())) {
                        recommendDescription = chatMsg.getLocalUrl();
                    }
                    String str3 = recommendDescription;
                    long newMsgNum = chatMessageDBManager.getNewMsgNum(key);
                    if (newMsgNum >= 0) {
                        i3 = (int) (intValue2 + newMsgNum);
                    } else {
                        i3 = intValue2;
                    }
                    int clickState = Utility.getClickState(chatMsg);
                    if (key.getCategory() == 0 && (key.getContacter() & 17592186044416L) != 0) {
                        if (!chatMsg.isSelf(chatMessageDBManager.mContext)) {
                            extLog = chatMsg.getExtLog();
                        } else {
                            ArrayList<ChatMsg> fetchMsg = fetchMsg(key, 0L, 1L, -1L, false, "from_user != " + Utility.getUK(chatMessageDBManager.mContext));
                            if (fetchMsg != null && fetchMsg.size() > 0) {
                                extLog = fetchMsg.get(0).getExtLog();
                            }
                        }
                        str2 = extLog;
                        recordLastMsg(key, str3, chatMsg.getMsgTime(), i3, chatMsg.getStatus(), clickState, chatMsg.isStarMessage(), str2, chatMsg.getSenderUid(), 0, 0L, 0L, "", str, i, j, i2);
                    }
                    str2 = "";
                    recordLastMsg(key, str3, chatMsg.getMsgTime(), i3, chatMsg.getStatus(), clickState, chatMsg.isStarMessage(), str2, chatMsg.getSenderUid(), 0, 0L, 0L, "", str, i, j, i2);
                }
                chatMessageDBManager = this;
                hashMap3 = hashMap2;
            }
        }
    }
}
