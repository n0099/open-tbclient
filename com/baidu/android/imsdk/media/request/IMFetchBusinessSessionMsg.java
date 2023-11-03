package com.baidu.android.imsdk.media.request;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatMsgManager;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl;
import com.baidu.android.imsdk.chatmessage.IMMediaBuildSessionListener;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.group.BIMGroupManager;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.GroupInfo;
import com.baidu.android.imsdk.group.GroupMessageManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.internal.MessageParser;
import com.baidu.android.imsdk.media.MediaSessionManager;
import com.baidu.android.imsdk.media.bean.GetSessionResult;
import com.baidu.android.imsdk.media.listener.BIMValuesCallBack;
import com.baidu.android.imsdk.pubaccount.IGetPaInfosListener;
import com.baidu.android.imsdk.pubaccount.PaManager;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.ubc.ScreenUbc;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMFetchBusinessSessionMsg extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMFetchBusinessSessionMsg";
    public transient /* synthetic */ FieldHolder $fh;
    public long mBeginTime;
    public int mBusinessType;
    public long mContacterUk;
    public Context mContext;
    public int mCount;
    public long mEndTime;
    public int mMode;
    public int mNeedTop;
    public int mReason;
    public String mScreenKey;
    public ScreenUbc.MethodInfo mScreenMethodInfo;
    public int mSessionType;
    public long mToContacterPaUid;
    public long mToContacterUk;
    public int mToContacterUserType;

    private int getAggBusinessType(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65559, this, i, i2)) == null) {
            if (i == 1) {
                return 2;
            }
            if (i == 9) {
                return 27;
            }
            if (i2 == 11) {
                return 10;
            }
            if (i2 == 9) {
                return 29;
            }
            return i2 == 10 ? 27 : 3;
        }
        return invokeII.intValue;
    }

    /* loaded from: classes.dex */
    public class AdvisorySessionResultTask extends TaskManager.Task {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context mContext;
        public int mError;
        public JSONObject mResponse;
        public String mStrMsg;
        public final /* synthetic */ IMFetchBusinessSessionMsg this$0;

        public AdvisorySessionResultTask(IMFetchBusinessSessionMsg iMFetchBusinessSessionMsg, Context context, int i, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMFetchBusinessSessionMsg, context, Integer.valueOf(i), str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = iMFetchBusinessSessionMsg;
            this.mContext = context;
            this.mError = i;
            this.mStrMsg = str;
            this.mResponse = jSONObject;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0097  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0099  */
        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            int i;
            List<ChatSession> list;
            int i2;
            int i3;
            int i4;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject jSONObject = this.mResponse;
                List<ChatSession> list2 = null;
                if (jSONObject != null) {
                    try {
                        int optInt = jSONObject.optInt(PmsConstant.Statistic.STATISTIC_ERRCODE);
                        if (optInt == 0) {
                            list2 = this.this$0.parseBusinessSessions(this.mResponse.optJSONArray("sessions"));
                            i = this.mResponse.getInt("has_more");
                            try {
                                i3 = this.mResponse.getInt("consult_unread_num");
                            } catch (JSONException unused) {
                                LogUtils.d(IMFetchBusinessSessionMsg.TAG, "FetchSessionTask exception");
                                list = list2;
                                i2 = 1005;
                                i4 = 0;
                                if (!TextUtils.isEmpty(this.this$0.mScreenKey)) {
                                }
                                ChatSessionManagerImpl chatSessionManagerImpl = ChatSessionManagerImpl.getInstance(this.mContext);
                                if (i == 1) {
                                }
                                chatSessionManagerImpl.onFetchBusiChatSessionResult(i2, z, i4, list, this.this$0.getListenerKey());
                            }
                        } else {
                            i = 0;
                            i3 = 0;
                        }
                        i2 = optInt;
                        list = list2;
                        i4 = i3;
                    } catch (JSONException unused2) {
                        i = 0;
                    }
                    if (!TextUtils.isEmpty(this.this$0.mScreenKey)) {
                        IMFetchBusinessSessionMsg iMFetchBusinessSessionMsg = this.this$0;
                        iMFetchBusinessSessionMsg.mScreenMethodInfo = Utility.getScreenMethodInfo(iMFetchBusinessSessionMsg.mScreenKey);
                        try {
                            JSONObject jSONObject2 = new JSONObject(this.this$0.mBody);
                            if (jSONObject2.has("client_logid")) {
                                this.this$0.mScreenMethodInfo.clientLogId = jSONObject2.optString("client_logid");
                            }
                        } catch (JSONException unused3) {
                        }
                        Utility.addEventList(this.this$0.mScreenMethodInfo.eventList, "AdvisorySessionResultTask");
                    }
                    ChatSessionManagerImpl chatSessionManagerImpl2 = ChatSessionManagerImpl.getInstance(this.mContext);
                    if (i == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    chatSessionManagerImpl2.onFetchBusiChatSessionResult(i2, z, i4, list, this.this$0.getListenerKey());
                }
                list = null;
                i = 0;
                i2 = 0;
                i4 = 0;
                if (!TextUtils.isEmpty(this.this$0.mScreenKey)) {
                }
                ChatSessionManagerImpl chatSessionManagerImpl22 = ChatSessionManagerImpl.getInstance(this.mContext);
                if (i == 1) {
                }
                chatSessionManagerImpl22.onFetchBusiChatSessionResult(i2, z, i4, list, this.this$0.getListenerKey());
            }
        }
    }

    /* loaded from: classes.dex */
    public class CompleteSessionInfoListener implements BIMValueCallBack<List<ChatSession>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<ChatSession> mClassSessions;
        public int mCode;
        public boolean mHasMore;
        public int mTopHasMore;
        public final /* synthetic */ IMFetchBusinessSessionMsg this$0;

        public CompleteSessionInfoListener(IMFetchBusinessSessionMsg iMFetchBusinessSessionMsg, int i, boolean z, int i2, List<ChatSession> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMFetchBusinessSessionMsg, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = iMFetchBusinessSessionMsg;
            this.mCode = i;
            this.mHasMore = z;
            this.mTopHasMore = i2;
            this.mClassSessions = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.android.imsdk.group.BIMValueCallBack
        public void onResult(int i, String str, List<ChatSession> list) {
            List<ChatSession> list2;
            List<ChatSession> list3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, list) == null) {
                if (this.mClassSessions != null) {
                    if (list == null) {
                        list3 = new ArrayList<>();
                    } else {
                        list3 = list;
                    }
                    list3.addAll(this.mClassSessions);
                    list2 = list3;
                } else {
                    list2 = list;
                }
                if (list2 != null) {
                    Iterator<ChatSession> it = list2.iterator();
                    while (it.hasNext()) {
                        LogUtils.d(IMFetchBusinessSessionMsg.TAG, "CompleteSessionInfoListener session = " + it.next());
                    }
                }
                MediaSessionManager.getInstance(this.this$0.mContext).handleFetchSessionListResult(this.mCode, list2, this.mTopHasMore, this.mHasMore, this.this$0.mReason, this.this$0.mMode, this.this$0.getListenerKey(), this.this$0.mBeginTime, this.this$0.mEndTime, this.this$0.mCount, this.this$0.mNeedTop, this.this$0.mBusinessType);
            }
        }
    }

    /* loaded from: classes.dex */
    public class MediaSessionResultTask extends TaskManager.Task {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context mContext;
        public int mError;
        public JSONObject mResponse;
        public String mStrMsg;
        public final /* synthetic */ IMFetchBusinessSessionMsg this$0;

        public MediaSessionResultTask(IMFetchBusinessSessionMsg iMFetchBusinessSessionMsg, Context context, int i, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMFetchBusinessSessionMsg, context, Integer.valueOf(i), str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = iMFetchBusinessSessionMsg;
            this.mContext = context;
            this.mError = i;
            this.mStrMsg = str;
            this.mResponse = jSONObject;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00e8  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00f8  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0149 A[ADDED_TO_REGION] */
        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            int i;
            int i2;
            int i3;
            int i4;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                HashMap hashMap3 = new HashMap();
                ArrayList arrayList = new ArrayList();
                JSONObject jSONObject = this.mResponse;
                List<ChatSession> list = null;
                if (jSONObject != null) {
                    try {
                        i3 = jSONObject.optInt(PmsConstant.Statistic.STATISTIC_ERRCODE);
                        if (i3 != 0) {
                            i = 0;
                            i2 = 0;
                        } else {
                            list = this.this$0.parseBusinessSessions(this.mResponse.optJSONArray("sessions"));
                            i = this.mResponse.optInt("has_more");
                            try {
                                int optInt = this.mResponse.optInt("total_unread_num");
                                this.mResponse.optInt("consult_unread_num");
                                i2 = this.mResponse.optInt("top_has_more");
                                try {
                                    int optInt2 = this.mResponse.optInt("stranger_unread_num");
                                    int optInt3 = this.mResponse.optInt("do_not_disturb_unread_number");
                                    if (this.this$0.mMode != 2) {
                                        MediaSessionManager.getInstance(this.mContext).setMediaTotalUnread(optInt);
                                        MediaSessionManager.getInstance(this.mContext).setStrangerUnread(optInt2);
                                        MediaSessionManager.getInstance(this.mContext).setPrivateChatNoDisturbNum(optInt3);
                                    }
                                } catch (Exception unused) {
                                    i3 = 1005;
                                    if (!TextUtils.isEmpty(this.this$0.mScreenKey)) {
                                    }
                                    i4 = i3;
                                    if (list != null) {
                                        while (r1.hasNext()) {
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                    z = true;
                                    this.this$0.completeSessionInfo(i4, z, i2, hashMap, hashMap2, hashMap3, arrayList);
                                }
                            } catch (Exception unused2) {
                                i2 = 0;
                                i3 = 1005;
                                if (!TextUtils.isEmpty(this.this$0.mScreenKey)) {
                                }
                                i4 = i3;
                                if (list != null) {
                                }
                                if (i == 1) {
                                }
                                z = true;
                                this.this$0.completeSessionInfo(i4, z, i2, hashMap, hashMap2, hashMap3, arrayList);
                            }
                        }
                    } catch (Exception unused3) {
                        i = 0;
                    }
                    if (!TextUtils.isEmpty(this.this$0.mScreenKey)) {
                        IMFetchBusinessSessionMsg iMFetchBusinessSessionMsg = this.this$0;
                        iMFetchBusinessSessionMsg.mScreenMethodInfo = Utility.getScreenMethodInfo(iMFetchBusinessSessionMsg.mScreenKey);
                        try {
                            JSONObject jSONObject2 = new JSONObject(this.this$0.mBody);
                            if (jSONObject2.has("client_logid")) {
                                this.this$0.mScreenMethodInfo.clientLogId = jSONObject2.optString("client_logid");
                            }
                        } catch (JSONException e) {
                            LogUtils.e(IMFetchBusinessSessionMsg.TAG, "mScreenKey exception ", e);
                        }
                        Utility.addEventList(this.this$0.mScreenMethodInfo.eventList, "MediaSessionResultTask");
                    }
                    i4 = i3;
                } else {
                    i4 = -1003;
                    i = 0;
                    i2 = 0;
                }
                if (list != null && list.size() > 0) {
                    for (ChatSession chatSession : list) {
                        if (chatSession.getClassType() > 0) {
                            arrayList.add(chatSession);
                        } else if (chatSession.getPaid() > 0) {
                            hashMap.put(Long.valueOf(chatSession.getPaid()), chatSession);
                        } else if (chatSession.getChatType() == 57) {
                            hashMap3.put(String.valueOf(chatSession.getContacter()), chatSession);
                        } else if (chatSession.getContacterId() > 0) {
                            hashMap2.put(Long.valueOf(chatSession.getContacterId()), chatSession);
                        }
                    }
                }
                if (i == 1 && i2 != 1) {
                    z = false;
                } else {
                    z = true;
                }
                this.this$0.completeSessionInfo(i4, z, i2, hashMap, hashMap2, hashMap3, arrayList);
            }
        }
    }

    /* loaded from: classes.dex */
    public class SingleMediaSessionResultTask extends TaskManager.Task {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context mContext;
        public int mError;
        public JSONObject mResponse;
        public String mStrMsg;
        public final /* synthetic */ IMFetchBusinessSessionMsg this$0;

        public SingleMediaSessionResultTask(IMFetchBusinessSessionMsg iMFetchBusinessSessionMsg, Context context, int i, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMFetchBusinessSessionMsg, context, Integer.valueOf(i), str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = iMFetchBusinessSessionMsg;
            this.mContext = context;
            this.mError = i;
            this.mStrMsg = str;
            this.mResponse = jSONObject;
        }

        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        public void run() {
            JSONObject jSONObject;
            List<ChatSession> list;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (jSONObject = this.mResponse) != null) {
                int i = 0;
                try {
                    i = jSONObject.optInt(PmsConstant.Statistic.STATISTIC_ERRCODE);
                    if (i != 0) {
                        list = null;
                    } else {
                        list = this.this$0.parseBusinessSessions(this.mResponse.optJSONArray("sessions"));
                    }
                    GetSessionResult getSessionResult = new GetSessionResult();
                    getSessionResult.sessionList = list;
                    IMListener removeListener = ListenerManager.getInstance().removeListener(this.this$0.mListenerKey);
                    if (removeListener != null && (removeListener instanceof BIMValuesCallBack)) {
                        ((BIMValuesCallBack) removeListener).onResult(i, this.mStrMsg, getSessionResult, null);
                    }
                } catch (Exception unused) {
                    GetSessionResult getSessionResult2 = new GetSessionResult();
                    getSessionResult2.sessionList = null;
                    IMListener removeListener2 = ListenerManager.getInstance().removeListener(this.this$0.mListenerKey);
                    if (removeListener2 != null && (removeListener2 instanceof BIMValuesCallBack)) {
                        ((BIMValuesCallBack) removeListener2).onResult(1005, this.mStrMsg, getSessionResult2, null);
                    }
                } catch (Throwable th) {
                    GetSessionResult getSessionResult3 = new GetSessionResult();
                    getSessionResult3.sessionList = null;
                    IMListener removeListener3 = ListenerManager.getInstance().removeListener(this.this$0.mListenerKey);
                    if (removeListener3 != null && (removeListener3 instanceof BIMValuesCallBack)) {
                        ((BIMValuesCallBack) removeListener3).onResult(i, this.mStrMsg, getSessionResult3, null);
                    }
                    throw th;
                }
            }
        }
    }

    public IMFetchBusinessSessionMsg(Context context, int i, long j, long j2, long j3, int i2, int i3, int i4, int i5, int i6, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mToContacterUserType = -1;
        this.mContext = context;
        initCommonParameter(context);
        this.mBusinessType = i;
        this.mContacterUk = j;
        this.mBeginTime = j2;
        this.mEndTime = j3;
        this.mCount = i2;
        this.mMode = i3;
        this.mNeedTop = i4;
        this.mSessionType = i5;
        this.mReason = i6;
        this.mScreenKey = str2;
        setListenerKey(str);
        setType(206);
    }

    public IMFetchBusinessSessionMsg(Context context, int i, long j, String str, int i2, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Long.valueOf(j), str, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mToContacterUserType = -1;
        this.mContext = context;
        initCommonParameter(context);
        this.mBusinessType = i;
        this.mContacterUk = j;
        this.mToContacterUserType = i2;
        this.mToContacterPaUid = j2;
        this.mToContacterUk = j3;
        setListenerKey(str);
        setType(206);
    }

    private int getCategory(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65560, this, i)) == null) {
            if (this.mBusinessType == 27) {
                return 9;
            }
            if (i == 57) {
                return 1;
            }
            if (i == 58) {
                return 9;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    private String getLastMsgDesc(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, this, chatMsg)) == null) {
            if (chatMsg != null) {
                String recommendDescription = chatMsg.getRecommendDescription();
                if (!TextUtils.isEmpty(chatMsg.getPreviewDesc())) {
                    return chatMsg.getPreviewDesc();
                }
                return recommendDescription;
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    private int getUserType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65562, this, i)) == null) {
            if (AccountManagerImpl.getInstance(this.mContext).getMediaRole()) {
                if (i == 3 || i == 0) {
                    return 1;
                }
                return 0;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    private ChatSession addAdvisoryValue(JSONObject jSONObject, ChatSession chatSession) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, this, jSONObject, chatSession)) == null) {
            if (jSONObject != null && chatSession != null && this.mBusinessType == 27) {
                try {
                    int i = jSONObject.getInt("session_type");
                    long optLong = jSONObject.optLong(TableDefine.BusiSessionColumns.COLUMN_LAST_DIALOGUE_ID);
                    String optString = jSONObject.optString(TableDefine.BusiSessionColumns.COLUMN_LAST_RESOURCE_ID);
                    int optInt = jSONObject.optInt("aid_type");
                    int optInt2 = jSONObject.optInt("status");
                    long optLong2 = jSONObject.optLong(TableDefine.BusiSessionColumns.COLUMN_LAST_ASK_UK);
                    long optLong3 = jSONObject.optLong(TableDefine.BusiSessionColumns.COLUMN_LAST_ANSWER_UK);
                    String optString2 = jSONObject.optString("desc");
                    String optString3 = jSONObject.optString(TableDefine.BusiSessionColumns.COLUMN_STATUS_SHOW);
                    int optInt3 = jSONObject.optInt("follow_state", 0);
                    int optInt4 = jSONObject.optInt("consult_collect_state");
                    chatSession.setDesc(optString2);
                    chatSession.setLastStatusShow(optString3);
                    chatSession.setSessionType(i);
                    chatSession.setLastDialogueId(optLong);
                    chatSession.setLastResourceId(optString);
                    chatSession.setAidType(optInt);
                    chatSession.setLastDialogueStatus(optInt2);
                    chatSession.setLastAnswerUk(optLong3);
                    chatSession.setLastAskUk(optLong2);
                    chatSession.setBusinessType(27);
                    chatSession.setSubscribe(optInt3);
                    chatSession.setCollectState(optInt4);
                } catch (Exception unused) {
                }
            }
            return chatSession;
        }
        return (ChatSession) invokeLL.objValue;
    }

    public void updateAggSessionFromServerWithCSession(ChatSession chatSession, int i) {
        ChatSession chatSession2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, chatSession, i) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(i));
            ArrayList<ChatSession> chatRecordsByClass = ChatMessageDBManager.getInstance(this.mContext).getChatRecordsByClass(1L, arrayList);
            if (chatRecordsByClass != null && chatRecordsByClass.size() > 0 && chatRecordsByClass.get(0) != null) {
                chatSession2 = chatRecordsByClass.get(0);
                chatSession.setLastMsg(chatSession2.getLastMsg());
            } else {
                if (i == 11) {
                    chatSession.setLastMsg("暂无互动消息，快和朋友互动起来吧>");
                }
                chatSession2 = null;
            }
            LogUtils.d(TAG, "聚合会话修正，session = " + chatSession + "localSession = " + chatSession2);
        }
    }

    private String buildAdvisoryRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            String str = null;
            try {
                jSONObject.put("method", 206);
                jSONObject.put("appid", this.mAppid);
                jSONObject.put("business_type", this.mBusinessType);
                jSONObject.put("uk", this.mUk);
                jSONObject.put("user_type", getUserType(this.mBusinessType));
                if (this.mContacterUk > 0) {
                    jSONObject.put("to", this.mContacterUk);
                }
                jSONObject.put("sort_update_time_us_begin", this.mBeginTime);
                jSONObject.put("sort_update_time_us_end", this.mEndTime);
                jSONObject.put("count", this.mCount);
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("app_version", AccountManagerImpl.getInstance(this.mContext).getAppVersion());
                if (this.mSessionType >= 0) {
                    jSONObject.put("session_type", this.mSessionType);
                }
                str = jSONObject.toString();
                LogUtils.d(TAG, "拉取咨询会话" + str);
                return str;
            } catch (JSONException e) {
                LogUtils.e(TAG, "Exception ", e);
                return str;
            }
        }
        return (String) invokeV.objValue;
    }

    private String buildSingleMediaRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            String str = null;
            try {
                jSONObject.put("method", 206);
                jSONObject.put("appid", this.mAppid);
                jSONObject.put("business_type", this.mBusinessType);
                jSONObject.put("uk", AccountManager.getUK(this.mContext));
                jSONObject.put("user_type", getUserType(this.mBusinessType));
                if (this.mToContacterUserType >= 0) {
                    jSONObject.put("contacter_user_type", this.mToContacterUserType);
                }
                jSONObject.put("contacter_pa_uid", this.mToContacterPaUid);
                jSONObject.put("contacter_uk", this.mToContacterUk);
                jSONObject.put(Constants.EXTRA_PAUID_TYPE, MediaSessionManager.getInstance(this.mContext).getMeidaPaid());
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("app_version", AccountManagerImpl.getInstance(this.mContext).getAppVersion());
                str = jSONObject.toString();
                LogUtils.d(TAG, "request param = " + str);
                return str;
            } catch (JSONException unused) {
                return str;
            }
        }
        return (String) invokeV.objValue;
    }

    private String buildMediaRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            String str = null;
            try {
                jSONObject.put("method", 206);
                jSONObject.put("appid", this.mAppid);
                jSONObject.put("business_type", this.mBusinessType);
                jSONObject.put("uk", this.mUk);
                jSONObject.put("user_type", getUserType(this.mBusinessType));
                jSONObject.put(Constants.EXTRA_PAUID_TYPE, MediaSessionManager.getInstance(this.mContext).getMeidaPaid());
                jSONObject.put("sort_update_time_us_begin", this.mBeginTime);
                jSONObject.put("sort_update_time_us_end", this.mEndTime);
                jSONObject.put("count", this.mCount);
                jSONObject.put("stranger_mode", this.mMode);
                if (this.mMode != 2) {
                    jSONObject.put("need_top", this.mNeedTop);
                }
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("app_version", AccountManagerImpl.getInstance(this.mContext).getAppVersion());
                if (BIMManager.weakIntervalTime > 0) {
                    jSONObject.put("weak_reminder_msgid_begin", (System.currentTimeMillis() - (BIMManager.weakIntervalTime * 1000)) * 1000);
                }
                str = jSONObject.toString();
                LogUtils.d(TAG, "request param = " + str);
                return str;
            } catch (JSONException unused) {
                return str;
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void completeSessionInfo(int i, boolean z, int i2, Map<Long, ChatSession> map, Map<Long, ChatSession> map2, Map<String, ChatSession> map3, List<ChatSession> list) {
        ArrayList<Long> arrayList;
        IGetUsersProfileBatchListener iGetUsersProfileBatchListener;
        ArrayList arrayList2;
        IGetPaInfosListener iGetPaInfosListener;
        ArrayList arrayList3;
        BIMValueCallBack<ArrayList<GroupInfo>> bIMValueCallBack;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), map, map2, map3, list}) == null) {
            CompleteSessionInfoListener completeSessionInfoListener = new CompleteSessionInfoListener(this, i, z, i2, list);
            IMMediaBuildSessionListener iMMediaBuildSessionListener = new IMMediaBuildSessionListener(this.mContext, completeSessionInfoListener);
            if (i == 0) {
                if (list != null && list.size() > 0) {
                    for (ChatSession chatSession : list) {
                        if (chatSession != null && chatSession.getIsStranger() != 1 && chatSession.getClassType() != 12) {
                            if (chatSession.getBusinessType() == 27) {
                                chatSession.setNewMsgSum(ChatMsgManager.getTotalUnReadMsgCountByAdvisory(this.mContext, 0L) + chatSession.getNewMsgSum());
                                List<ChatSession> sessionByGfhPA = ChatSessionManagerImpl.getInstance(this.mContext).getSessionByGfhPA(27, 0L);
                                if (sessionByGfhPA != null && !sessionByGfhPA.isEmpty()) {
                                    chatSession.setLastMsg(sessionByGfhPA.get(0).getLastMsg());
                                } else {
                                    List<ChatSession> busiChatSessionsFromDb = ChatSessionManagerImpl.getInstance(this.mContext).getBusiChatSessionsFromDb(chatSession.getBusinessType(), -1, 0L, 0L, Long.MAX_VALUE, -1, 2);
                                    if (busiChatSessionsFromDb != null && busiChatSessionsFromDb.size() > 0) {
                                        chatSession.setLastMsg(ChatSessionManagerImpl.getInstance(this.mContext).getBusinessSessionLastMsg(busiChatSessionsFromDb.get(0)));
                                    } else {
                                        chatSession.setLastMsg("");
                                    }
                                }
                            } else {
                                ArrayList arrayList4 = new ArrayList();
                                arrayList4.add(Integer.valueOf(chatSession.getClassType()));
                                ArrayList<ChatSession> chatRecordsByClass = ChatMessageDBManager.getInstance(this.mContext).getChatRecordsByClass(1L, arrayList4);
                                if (chatRecordsByClass != null && chatRecordsByClass.size() > 0) {
                                    chatSession.setLastMsgName(chatRecordsByClass.get(0).getNickName());
                                }
                                chatSession.setNewMsgSum(ChatMessageDBManager.getInstance(this.mContext).getNewMsgCountOfClass(chatSession.getClassType()));
                            }
                        }
                    }
                }
                if (map2 != null && map2.size() > 0) {
                    arrayList = new ArrayList<>(map2.keySet());
                    iGetUsersProfileBatchListener = iMMediaBuildSessionListener.getUserIdentityListener(map2);
                } else {
                    arrayList = null;
                    iGetUsersProfileBatchListener = null;
                }
                if (map != null && map.size() > 0) {
                    arrayList2 = new ArrayList(map.keySet());
                    iGetPaInfosListener = iMMediaBuildSessionListener.getPaInfosListener(map);
                } else {
                    arrayList2 = null;
                    iGetPaInfosListener = null;
                }
                if (map3 != null && map3.size() > 0) {
                    arrayList3 = new ArrayList(map3.keySet());
                    bIMValueCallBack = iMMediaBuildSessionListener.getGroupInfoListener(map3);
                } else {
                    arrayList3 = null;
                    bIMValueCallBack = null;
                }
                if (iGetUsersProfileBatchListener != null) {
                    z2 = false;
                    ChatUserManagerImpl.getInstance(this.mContext).getUsersProfileBatchByBuid(arrayList, false, iGetUsersProfileBatchListener);
                } else {
                    z2 = false;
                }
                if (iGetPaInfosListener != null) {
                    PaManager.getPaInfos(this.mContext, arrayList2, z2, iGetPaInfosListener);
                }
                if (bIMValueCallBack != null) {
                    BIMGroupManager.getFansGroupInfo(this.mContext, arrayList3, z2, bIMValueCallBack);
                }
                if (arrayList == null && arrayList2 == null && arrayList3 == null) {
                    iMMediaBuildSessionListener.onResult(i, null, completeSessionInfoListener);
                    return;
                }
                return;
            }
            iMMediaBuildSessionListener.onResult(i, null, completeSessionInfoListener);
        }
    }

    public static IMFetchBusinessSessionMsg newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, context, intent)) == null) {
            if (intent.hasExtra("contacter_user_type") && (intent.hasExtra("contacter_pa_uid") || intent.hasExtra("contacter_uk"))) {
                return new IMFetchBusinessSessionMsg(context, intent.getIntExtra(Constants.EXTRA_BUSINESS_TYPE, -1), intent.getLongExtra("contacter", -1L), intent.getStringExtra(Constants.EXTRA_LISTENER_ID), intent.getIntExtra("contacter_user_type", -1), intent.getLongExtra("contacter_pa_uid", -1L), intent.getLongExtra("contacter_uk", -1L));
            } else if (intent.hasExtra("count") && intent.hasExtra(Constants.EXTRA_BUSINESS_TYPE)) {
                int intExtra = intent.getIntExtra("count", -1);
                return new IMFetchBusinessSessionMsg(context, intent.getIntExtra(Constants.EXTRA_BUSINESS_TYPE, -1), intent.getLongExtra("contacter", -1L), intent.getLongExtra(Constants.EXTRA_BEGIN_MSGID, -1L), intent.getLongExtra(Constants.EXTRA_END_MSGID, -1L), intExtra, intent.getIntExtra(Constants.EXTRA_FETCH_SESSION_MODE, 0), intent.getIntExtra(Constants.EXTRA_FETCH_SESSION_TOP, 1), intent.getIntExtra("session_type", -1), intent.getIntExtra(Constants.EXTRA_TRIGGER_REASON, -1), intent.getStringExtra(Constants.EXTRA_LISTENER_ID), intent.getStringExtra(Constants.EXTRA_SCREEN_KEY));
            } else {
                return null;
            }
        }
        return (IMFetchBusinessSessionMsg) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(32:(4:10|11|12|(7:13|14|15|16|17|(1:19)(1:126)|20))|(9:124|26|27|28|29|(1:31)|32|(20:39|(1:41)(1:120)|42|43|44|45|(1:47)|48|49|50|51|52|(11:54|55|56|58|59|(1:61)|62|(1:105)(4:66|67|68|(1:70))|71|72|(2:88|89))(1:111)|74|(1:78)|79|80|81|82|84)(2:36|37)|38)|25|26|27|28|29|(0)|32|(1:34)|39|(0)(0)|42|43|44|45|(0)|48|49|50|51|52|(0)(0)|74|(2:76|78)|79|80|81|82|84|38|8) */
    /* JADX WARN: Can't wrap try/catch for region: R(35:10|11|12|(7:13|14|15|16|17|(1:19)(1:126)|20)|(9:124|26|27|28|29|(1:31)|32|(20:39|(1:41)(1:120)|42|43|44|45|(1:47)|48|49|50|51|52|(11:54|55|56|58|59|(1:61)|62|(1:105)(4:66|67|68|(1:70))|71|72|(2:88|89))(1:111)|74|(1:78)|79|80|81|82|84)(2:36|37)|38)|25|26|27|28|29|(0)|32|(1:34)|39|(0)(0)|42|43|44|45|(0)|48|49|50|51|52|(0)(0)|74|(2:76|78)|79|80|81|82|84|38|8) */
    /* JADX WARN: Can't wrap try/catch for region: R(41:10|11|12|13|14|15|16|17|(1:19)(1:126)|20|(9:124|26|27|28|29|(1:31)|32|(20:39|(1:41)(1:120)|42|43|44|45|(1:47)|48|49|50|51|52|(11:54|55|56|58|59|(1:61)|62|(1:105)(4:66|67|68|(1:70))|71|72|(2:88|89))(1:111)|74|(1:78)|79|80|81|82|84)(2:36|37)|38)|25|26|27|28|29|(0)|32|(1:34)|39|(0)(0)|42|43|44|45|(0)|48|49|50|51|52|(0)(0)|74|(2:76|78)|79|80|81|82|84|38|8) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0303, code lost:
        r8 = r50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x030a, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x030b, code lost:
        r8 = r50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x030e, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x030f, code lost:
        r8 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0310, code lost:
        r2 = r26;
        r3 = r41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x02fc, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0302, code lost:
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0258 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0137 A[Catch: Exception -> 0x030e, TryCatch #0 {Exception -> 0x030e, blocks: (B:30:0x011b, B:32:0x0137, B:35:0x0140, B:42:0x015f), top: B:124:0x011b }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01b0 A[Catch: Exception -> 0x030a, TryCatch #4 {Exception -> 0x030a, blocks: (B:44:0x0187, B:46:0x01b0, B:47:0x01b5), top: B:130:0x0187 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02da A[Catch: Exception -> 0x02fe, TryCatch #7 {Exception -> 0x02fe, blocks: (B:77:0x024a, B:79:0x0258, B:86:0x02d6, B:88:0x02da, B:90:0x02e2, B:91:0x02f0, B:76:0x0247), top: B:136:0x0258 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<ChatSession> parseBusinessSessions(JSONArray jSONArray) {
        InterceptResult invokeL;
        IMFetchBusinessSessionMsg iMFetchBusinessSessionMsg;
        ArrayList arrayList;
        String str;
        int i;
        JSONObject jSONObject;
        long optLong;
        long j;
        long j2;
        long optLong2;
        long j3;
        long optLong3;
        int optInt;
        String optString;
        ArrayList arrayList2;
        long optLong4;
        int optInt2;
        int optInt3;
        String optString2;
        String optString3;
        int i2;
        int optInt4;
        long optLong5;
        int optInt5;
        int optInt6;
        int i3;
        int optInt7;
        String optString4;
        int i4;
        long j4;
        ChatSession chatSession;
        ChatSession chatRecord;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, this, jSONArray)) == null) {
            IMFetchBusinessSessionMsg iMFetchBusinessSessionMsg2 = this;
            JSONArray jSONArray2 = jSONArray;
            ArrayList arrayList3 = new ArrayList();
            if (jSONArray2 != null && jSONArray.length() != 0) {
                String str2 = TAG;
                LogUtils.d(TAG, "parseBusinessSessions size = " + jSONArray.length());
                int i5 = 0;
                while (i5 < jSONArray.length()) {
                    try {
                        jSONObject = jSONArray2.getJSONObject(i5);
                        LogUtils.d(str2, "parseBusinessSessions json = " + jSONObject.toString());
                        optLong = jSONObject.optLong("sort_update_time_us");
                        j = jSONObject.getLong("contacter_uk");
                        j2 = jSONObject.getLong("contacter_bduid");
                        optLong2 = jSONObject.optLong("contacter_pa_uid", -1L);
                        j3 = jSONObject.getLong("unread_num");
                        i = i5;
                        try {
                            optLong3 = jSONObject.optLong(TableDefine.MediaSessionColumns.COLUMN_LAST_MSGID);
                            optInt = jSONObject.optInt("last_msgtype");
                            optString = jSONObject.optString("last_content");
                            arrayList2 = arrayList3;
                            try {
                                optLong4 = jSONObject.optLong("last_time");
                                optInt2 = jSONObject.optInt("pa_classtype");
                                optInt3 = jSONObject.optInt("pa_classshow");
                                optString2 = jSONObject.optString("pa_classavatar");
                                optString3 = jSONObject.optString("pa_classtitle");
                                if (jSONObject.optLong("is_top", 0L) > 0) {
                                    i2 = 1;
                                } else {
                                    i2 = 0;
                                }
                                optInt4 = jSONObject.optInt("is_block");
                                optLong5 = jSONObject.optLong("block_timestamp");
                                optInt5 = jSONObject.optInt("aggr_type");
                                optInt6 = jSONObject.optInt("stranger_type");
                            } catch (Exception e) {
                                e = e;
                                iMFetchBusinessSessionMsg = iMFetchBusinessSessionMsg2;
                                str = str2;
                                arrayList = arrayList2;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            iMFetchBusinessSessionMsg = iMFetchBusinessSessionMsg2;
                            arrayList = arrayList3;
                            str = str2;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        iMFetchBusinessSessionMsg = iMFetchBusinessSessionMsg2;
                        arrayList = arrayList3;
                        str = str2;
                        i = i5;
                    }
                    if (optInt5 != 12 && optInt6 != 1) {
                        optInt5 = optInt2;
                        i3 = 0;
                        int optInt8 = jSONObject.optInt("do_not_disturb");
                        int i6 = i3;
                        optInt7 = jSONObject.optInt("chat_type");
                        long optLong6 = jSONObject.optLong("last_msg_bduid");
                        jSONObject.optLong("last_msg_uk");
                        optString4 = jSONObject.optString("desc");
                        int category = iMFetchBusinessSessionMsg2.getCategory(optInt7);
                        String str3 = str2;
                        int aggBusinessType = iMFetchBusinessSessionMsg2.getAggBusinessType(category, optInt5);
                        ChatMsg parseChatMsg = MessageParser.parseChatMsg(iMFetchBusinessSessionMsg2.mContext, category, optInt, aggBusinessType, 0, optString);
                        if (TextUtils.isEmpty(optString4)) {
                            optString4 = iMFetchBusinessSessionMsg2.getLastMsgDesc(parseChatMsg);
                        }
                        String str4 = optString4;
                        if (optInt7 != 57 && !GroupMessageManagerImpl.getInstance(iMFetchBusinessSessionMsg2.mContext).isValidGroup(parseChatMsg)) {
                            iMFetchBusinessSessionMsg = iMFetchBusinessSessionMsg2;
                            arrayList = arrayList2;
                            str = str3;
                        } else {
                            i4 = (optLong2 > 0L ? 1 : (optLong2 == 0L ? 0 : -1));
                            if (i4 <= 0) {
                                j4 = optLong2;
                            } else {
                                j4 = j;
                            }
                            chatSession = new ChatSession(category, j4, j2, "");
                            chatSession.setChatType(optInt7);
                            chatSession.setLastMsg(str4);
                            chatSession.setNewMsgSum(j3);
                            chatSession.setLastMsgId(optLong3);
                            chatSession.setLastMsgTime(optLong4);
                            chatSession.setClassShow(optInt3);
                            chatSession.setClassType(optInt5);
                            chatSession.setClassAvatar(optString2);
                            chatSession.setClassTitle(optString3);
                            chatSession.setBusinessType(aggBusinessType);
                            if (i4 > 0) {
                                chatSession.setPaid(optLong2);
                            }
                            chatSession.setMarkTop(i2);
                            chatSession.setShield(optInt4);
                            chatSession.setShieldTime(optLong5);
                            chatSession.setSortTime(optLong);
                            chatSession.setIsStranger(i6);
                            chatSession.setState(0);
                            chatSession.setIsClicked(1);
                            chatSession.setDisturb(optInt8);
                            chatSession.setContacterImuk(j);
                            if (optInt7 != 57) {
                                try {
                                    chatSession.setLastMsgUid(optLong6);
                                    try {
                                        JSONObject optJSONObject = new JSONObject(optString).optJSONObject("ext");
                                        String str5 = null;
                                        if (optJSONObject != null) {
                                            str5 = optJSONObject.optString("group_member_name");
                                        }
                                        if (!TextUtils.isEmpty(chatSession.getLastMsg()) && optLong6 > 0) {
                                            iMFetchBusinessSessionMsg = this;
                                            try {
                                                if (optLong6 != Utility.getLongByString(AccountManager.getUid(iMFetchBusinessSessionMsg.mContext), 0L)) {
                                                    chatSession.setLastMsgName(str5);
                                                }
                                            } catch (JSONException e4) {
                                                e = e4;
                                                try {
                                                    str = str3;
                                                    LogUtils.e(str, "JSON PARSER ERROR: " + e.getMessage());
                                                    chatRecord = ChatMessageDBManager.getInstance(iMFetchBusinessSessionMsg.mContext).getChatRecord(1, j4);
                                                    if (chatRecord != null) {
                                                    }
                                                    if (BIMManager.hudongTop) {
                                                    }
                                                    arrayList = arrayList2;
                                                    arrayList.add(iMFetchBusinessSessionMsg.addAdvisoryValue(jSONObject, chatSession));
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    str = str3;
                                                    arrayList = arrayList2;
                                                    LogUtils.e(str, "parseBusinessSessions exception ", e);
                                                    i5 = i + 1;
                                                    str2 = str;
                                                    iMFetchBusinessSessionMsg2 = iMFetchBusinessSessionMsg;
                                                    arrayList3 = arrayList;
                                                    jSONArray2 = jSONArray;
                                                }
                                                i5 = i + 1;
                                                str2 = str;
                                                iMFetchBusinessSessionMsg2 = iMFetchBusinessSessionMsg;
                                                arrayList3 = arrayList;
                                                jSONArray2 = jSONArray;
                                            } catch (Exception e6) {
                                                e = e6;
                                                arrayList = arrayList2;
                                                str = str3;
                                                LogUtils.e(str, "parseBusinessSessions exception ", e);
                                                i5 = i + 1;
                                                str2 = str;
                                                iMFetchBusinessSessionMsg2 = iMFetchBusinessSessionMsg;
                                                arrayList3 = arrayList;
                                                jSONArray2 = jSONArray;
                                            }
                                        } else {
                                            iMFetchBusinessSessionMsg = this;
                                        }
                                        str = str3;
                                    } catch (JSONException e7) {
                                        e = e7;
                                        iMFetchBusinessSessionMsg = this;
                                    }
                                    chatRecord = ChatMessageDBManager.getInstance(iMFetchBusinessSessionMsg.mContext).getChatRecord(1, j4);
                                    if (chatRecord != null) {
                                        try {
                                            chatSession.setNewMsgSum(chatRecord.getNewMsgSum());
                                            chatSession.setLastMsg(chatRecord.getLastMsg());
                                            LogUtils.d(str, "修正从server拉取的群会话 session = " + chatSession + "\n chatSession = " + chatRecord);
                                            chatSession.setLastMsgName(chatRecord.getLastMsgName());
                                            chatSession.setRemindType(chatRecord.getRemindType());
                                            chatSession.setRemindMsgId(chatRecord.getRemindMsgid());
                                            chatSession.setRemindUid(chatRecord.getRemindUid());
                                            chatSession.setRemindRoleDisplayName(chatRecord.getRemindRoleDisplayName());
                                            chatSession.setHighlightPriority(chatRecord.getHighlightPriority());
                                            chatSession.setHighlightDesc(chatRecord.getHighlightDesc());
                                            chatSession.setLastMsgidFromMe(chatRecord.getLastMsgidFromMe());
                                            chatSession.setExt(chatRecord.getExt());
                                            chatSession.setDisturb(chatRecord.getDisturb());
                                        } catch (Exception e8) {
                                            e = e8;
                                            arrayList = arrayList2;
                                            LogUtils.e(str, "parseBusinessSessions exception ", e);
                                            i5 = i + 1;
                                            str2 = str;
                                            iMFetchBusinessSessionMsg2 = iMFetchBusinessSessionMsg;
                                            arrayList3 = arrayList;
                                            jSONArray2 = jSONArray;
                                        }
                                    }
                                } catch (Exception e9) {
                                    e = e9;
                                    iMFetchBusinessSessionMsg = this;
                                }
                            } else {
                                iMFetchBusinessSessionMsg = this;
                                str = str3;
                            }
                            if (BIMManager.hudongTop && chatSession.getClassType() == 11) {
                                chatSession.setMarkTopTime(9223372036854765807L);
                                chatSession.setMarkTop(1);
                                iMFetchBusinessSessionMsg.updateAggSessionFromServerWithCSession(chatSession, optInt5);
                            }
                            arrayList = arrayList2;
                            arrayList.add(iMFetchBusinessSessionMsg.addAdvisoryValue(jSONObject, chatSession));
                        }
                        i5 = i + 1;
                        str2 = str;
                        iMFetchBusinessSessionMsg2 = iMFetchBusinessSessionMsg;
                        arrayList3 = arrayList;
                        jSONArray2 = jSONArray;
                    }
                    i3 = 1;
                    int optInt82 = jSONObject.optInt("do_not_disturb");
                    int i62 = i3;
                    optInt7 = jSONObject.optInt("chat_type");
                    long optLong62 = jSONObject.optLong("last_msg_bduid");
                    jSONObject.optLong("last_msg_uk");
                    optString4 = jSONObject.optString("desc");
                    int category2 = iMFetchBusinessSessionMsg2.getCategory(optInt7);
                    String str32 = str2;
                    int aggBusinessType2 = iMFetchBusinessSessionMsg2.getAggBusinessType(category2, optInt5);
                    ChatMsg parseChatMsg2 = MessageParser.parseChatMsg(iMFetchBusinessSessionMsg2.mContext, category2, optInt, aggBusinessType2, 0, optString);
                    if (TextUtils.isEmpty(optString4)) {
                    }
                    String str42 = optString4;
                    if (optInt7 != 57) {
                    }
                    i4 = (optLong2 > 0L ? 1 : (optLong2 == 0L ? 0 : -1));
                    if (i4 <= 0) {
                    }
                    chatSession = new ChatSession(category2, j4, j2, "");
                    chatSession.setChatType(optInt7);
                    chatSession.setLastMsg(str42);
                    chatSession.setNewMsgSum(j3);
                    chatSession.setLastMsgId(optLong3);
                    chatSession.setLastMsgTime(optLong4);
                    chatSession.setClassShow(optInt3);
                    chatSession.setClassType(optInt5);
                    chatSession.setClassAvatar(optString2);
                    chatSession.setClassTitle(optString3);
                    chatSession.setBusinessType(aggBusinessType2);
                    if (i4 > 0) {
                    }
                    chatSession.setMarkTop(i2);
                    chatSession.setShield(optInt4);
                    chatSession.setShieldTime(optLong5);
                    chatSession.setSortTime(optLong);
                    chatSession.setIsStranger(i62);
                    chatSession.setState(0);
                    chatSession.setIsClicked(1);
                    chatSession.setDisturb(optInt82);
                    chatSession.setContacterImuk(j);
                    if (optInt7 != 57) {
                    }
                    if (BIMManager.hudongTop) {
                        chatSession.setMarkTopTime(9223372036854765807L);
                        chatSession.setMarkTop(1);
                        iMFetchBusinessSessionMsg.updateAggSessionFromServerWithCSession(chatSession, optInt5);
                    }
                    arrayList = arrayList2;
                    arrayList.add(iMFetchBusinessSessionMsg.addAdvisoryValue(jSONObject, chatSession));
                    i5 = i + 1;
                    str2 = str;
                    iMFetchBusinessSessionMsg2 = iMFetchBusinessSessionMsg;
                    arrayList3 = arrayList;
                    jSONArray2 = jSONArray;
                }
                return arrayList3;
            }
            return arrayList3;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.mBusinessType == 27) {
                this.mBody = buildAdvisoryRequestParam();
            } else if (this.mToContacterUserType >= 0) {
                this.mBody = buildSingleMediaRequestParam();
            } else {
                this.mBody = buildMediaRequestParam();
            }
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, i, str) == null) {
            LogUtils.d(TAG, "handleMessageResult err : " + i + ", msg :" + str + " result = " + jSONObject);
            super.handleMessageResult(context, jSONObject, i, str);
            if (this.mBusinessType == 27) {
                TaskManager.getInstance(this.mContext).submitForNetWork(new AdvisorySessionResultTask(this, context, i, str, jSONObject));
            } else if (this.mToContacterUserType >= 0) {
                TaskManager.getInstance(this.mContext).submitForNetWork(new SingleMediaSessionResultTask(this, context, i, str, jSONObject));
            } else {
                TaskManager.getInstance(this.mContext).submitForNetWork(new MediaSessionResultTask(this, context, i, str, jSONObject));
            }
        }
    }
}
