package com.baidu.android.imsdk.media.request;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatMsgManager;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl;
import com.baidu.android.imsdk.chatmessage.IMMediaBuildSessionListener;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.request.RequestContants;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.group.BIMGroupManager;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.GroupInfo;
import com.baidu.android.imsdk.group.GroupMessageManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.MessageParser;
import com.baidu.android.imsdk.media.MediaSessionManager;
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

    private int getAggBusinessType(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65556, this, i, i2)) == null) {
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

        /* JADX WARN: Removed duplicated region for block: B:20:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00e5  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0136 A[ADDED_TO_REGION] */
        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
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
                        if (i3 == 0) {
                            list = this.this$0.parseBusinessSessions(this.mResponse.optJSONArray("sessions"));
                            i = this.mResponse.getInt("has_more");
                            try {
                                i5 = this.mResponse.getInt("total_unread_num");
                                this.mResponse.optInt("consult_unread_num");
                                i2 = this.mResponse.getInt("top_has_more");
                            } catch (JSONException unused) {
                                i2 = 0;
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
                            try {
                                int i6 = this.mResponse.getInt("stranger_unread_num");
                                if (this.this$0.mMode != 2) {
                                    MediaSessionManager.getInstance(this.mContext).setMediaTotalUnread(i5);
                                    MediaSessionManager.getInstance(this.mContext).setStrangerUnread(i6);
                                }
                            } catch (JSONException unused2) {
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
                        } else {
                            i = 0;
                            i2 = 0;
                        }
                    } catch (JSONException unused3) {
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
                    i4 = 0;
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

    public IMFetchBusinessSessionMsg(Context context, int i, long j, long j2, long j3, int i2, int i3, int i4, int i5, int i6, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
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

    private int getCategory(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65557, this, i)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, this, chatMsg)) == null) {
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
        if (interceptable == null || (invokeI = interceptable.invokeI(65559, this, i)) == null) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, this, jSONObject, chatSession)) == null) {
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

    public static IMFetchBusinessSessionMsg newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, context, intent)) == null) {
            if (intent.hasExtra("count") && intent.hasExtra(Constants.EXTRA_BUSINESS_TYPE)) {
                int intExtra = intent.getIntExtra("count", -1);
                return new IMFetchBusinessSessionMsg(context, intent.getIntExtra(Constants.EXTRA_BUSINESS_TYPE, -1), intent.getLongExtra("contacter", -1L), intent.getLongExtra(Constants.EXTRA_BEGIN_MSGID, -1L), intent.getLongExtra(Constants.EXTRA_END_MSGID, -1L), intExtra, intent.getIntExtra(Constants.EXTRA_FETCH_SESSION_MODE, 0), intent.getIntExtra(Constants.EXTRA_FETCH_SESSION_TOP, 1), intent.getIntExtra("session_type", -1), intent.getIntExtra(Constants.EXTRA_TRIGGER_REASON, -1), intent.getStringExtra(Constants.EXTRA_LISTENER_ID), intent.getStringExtra(Constants.EXTRA_SCREEN_KEY));
            }
            return null;
        }
        return (IMFetchBusinessSessionMsg) invokeLL.objValue;
    }

    private String buildAdvisoryRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
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

    private String buildMediaRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), map, map2, map3, list}) == null) {
            CompleteSessionInfoListener completeSessionInfoListener = new CompleteSessionInfoListener(this, i, z, i2, list);
            IMMediaBuildSessionListener iMMediaBuildSessionListener = new IMMediaBuildSessionListener(this.mContext, completeSessionInfoListener);
            if (i == 0) {
                if (list != null && list.size() > 0) {
                    for (ChatSession chatSession : list) {
                        if (chatSession != null && chatSession.getIsStranger() != 1 && chatSession.getClassType() != 12) {
                            if (chatSession.getBusinessType() == 27) {
                                chatSession.setNewMsgSum(chatSession.getNewMsgSum() + ChatMsgManager.getTotalUnReadMsgCountByAdvisory(this.mContext, 0L));
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
                    ChatUserManagerImpl.getInstance(this.mContext).getUsersProfileBatchByBuid(arrayList, false, iGetUsersProfileBatchListener);
                }
                if (iGetPaInfosListener != null) {
                    PaManager.getPaInfos(this.mContext, arrayList2, false, iGetPaInfosListener);
                }
                if (bIMValueCallBack != null) {
                    BIMGroupManager.getFansGroupInfo(this.mContext, arrayList3, false, bIMValueCallBack);
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

    /* JADX INFO: Access modifiers changed from: private */
    public List<ChatSession> parseBusinessSessions(JSONArray jSONArray) {
        InterceptResult invokeL;
        IMFetchBusinessSessionMsg iMFetchBusinessSessionMsg;
        String str;
        int i;
        String str2;
        int i2;
        int i3;
        long j;
        int i4;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, this, jSONArray)) == null) {
            IMFetchBusinessSessionMsg iMFetchBusinessSessionMsg2 = this;
            JSONArray jSONArray2 = jSONArray;
            ArrayList arrayList = new ArrayList();
            if (jSONArray2 != null && jSONArray.length() != 0) {
                String str3 = TAG;
                LogUtils.d(TAG, "parseBusinessSessions size = " + jSONArray.length());
                int i5 = 0;
                while (i5 < jSONArray.length()) {
                    try {
                        JSONObject jSONObject = jSONArray2.getJSONObject(i5);
                        LogUtils.d(str3, "parseBusinessSessions json = " + jSONObject.toString());
                        long optLong = jSONObject.optLong("sort_update_time_us");
                        long j3 = jSONObject.getLong("contacter_uk");
                        long j4 = jSONObject.getLong("contacter_bduid");
                        long optLong2 = jSONObject.optLong(RequestContants.EXTRA_CONTACTER_PA_UID, -1L);
                        long j5 = jSONObject.getLong("unread_num");
                        i = i5;
                        try {
                            long optLong3 = jSONObject.optLong(TableDefine.MediaSessionColumns.COLUMN_LAST_MSGID);
                            int optInt = jSONObject.optInt("last_msgtype");
                            String optString = jSONObject.optString("last_content");
                            ArrayList arrayList2 = arrayList;
                            try {
                                long optLong4 = jSONObject.optLong("last_time");
                                int optInt2 = jSONObject.optInt("pa_classtype");
                                int optInt3 = jSONObject.optInt("pa_classshow");
                                String optString2 = jSONObject.optString("pa_classavatar");
                                String optString3 = jSONObject.optString("pa_classtitle");
                                int optInt4 = jSONObject.optInt("is_top", 0);
                                int optInt5 = jSONObject.optInt("is_block");
                                long optLong5 = jSONObject.optLong("block_timestamp");
                                int optInt6 = jSONObject.optInt("aggr_type");
                                int optInt7 = jSONObject.optInt("stranger_type");
                                str = str3;
                                if (optInt6 != 12 && optInt7 != 1) {
                                    i2 = optInt2;
                                    i3 = 0;
                                } else {
                                    i2 = optInt6;
                                    i3 = 1;
                                }
                                try {
                                    int optInt8 = jSONObject.optInt("do_not_disturb");
                                    int optInt9 = jSONObject.optInt("chat_type");
                                    int i6 = i3;
                                    long optLong6 = jSONObject.optLong("last_msg_bduid");
                                    jSONObject.optLong("last_msg_uk");
                                    String optString4 = jSONObject.optString("desc");
                                    int category = iMFetchBusinessSessionMsg2.getCategory(optInt9);
                                    int aggBusinessType = iMFetchBusinessSessionMsg2.getAggBusinessType(category, i2);
                                    ChatMsg parseChatMsg = MessageParser.parseChatMsg(iMFetchBusinessSessionMsg2.mContext, category, optInt, aggBusinessType, 0, optString);
                                    if (TextUtils.isEmpty(optString4)) {
                                        optString4 = iMFetchBusinessSessionMsg2.getLastMsgDesc(parseChatMsg);
                                    }
                                    if (optInt9 == 57 && !GroupMessageManagerImpl.getInstance(iMFetchBusinessSessionMsg2.mContext).isValidGroup(parseChatMsg)) {
                                        iMFetchBusinessSessionMsg = iMFetchBusinessSessionMsg2;
                                        arrayList = arrayList2;
                                        str2 = str;
                                    } else {
                                        int i7 = (optLong2 > 0L ? 1 : (optLong2 == 0L ? 0 : -1));
                                        if (i7 > 0) {
                                            j = optLong2;
                                        } else {
                                            j = j3;
                                        }
                                        if (optInt9 == 57) {
                                            i4 = optInt9;
                                            ChatSession chatRecord = ChatMessageDBManager.getInstance(iMFetchBusinessSessionMsg2.mContext).getChatRecord(new ChatObject(iMFetchBusinessSessionMsg2.mContext, 1, j3));
                                            if (chatRecord == null) {
                                                j2 = 0;
                                            } else {
                                                j2 = chatRecord.getNewMsgSum();
                                            }
                                        } else {
                                            i4 = optInt9;
                                            j2 = j5;
                                        }
                                        int i8 = i4;
                                        String str4 = optString4;
                                        try {
                                            ChatSession chatSession = new ChatSession(category, j, j4, "");
                                            chatSession.setChatType(i8);
                                            chatSession.setLastMsg(str4);
                                            chatSession.setNewMsgSum(j2);
                                            chatSession.setLastMsgId(optLong3);
                                            chatSession.setLastMsgTime(optLong4);
                                            chatSession.setClassShow(optInt3);
                                            chatSession.setClassType(i2);
                                            chatSession.setClassAvatar(optString2);
                                            chatSession.setClassTitle(optString3);
                                            chatSession.setBusinessType(aggBusinessType);
                                            if (i7 > 0) {
                                                chatSession.setPaid(optLong2);
                                            }
                                            chatSession.setMarkTop(optInt4);
                                            chatSession.setShield(optInt5);
                                            chatSession.setShieldTime(optLong5);
                                            chatSession.setSortTime(optLong);
                                            chatSession.setIsStranger(i6);
                                            try {
                                                chatSession.setState(0);
                                                chatSession.setIsClicked(1);
                                                chatSession.setDisturb(optInt8);
                                                chatSession.setContacterImuk(j3);
                                                if (i8 == 57) {
                                                    chatSession.setLastMsgUid(optLong6);
                                                    iMFetchBusinessSessionMsg = this;
                                                    try {
                                                        ChatSession chatRecord2 = ChatSessionManagerImpl.getInstance(iMFetchBusinessSessionMsg.mContext).getChatRecord(1, j);
                                                        if (chatRecord2 != null) {
                                                            chatSession.setRemindType(chatRecord2.getRemindType());
                                                            chatSession.setRemindMsgId(chatRecord2.getRemindMsgid());
                                                            chatSession.setRemindUid(chatRecord2.getRemindUid());
                                                            chatSession.setRemindRoleDisplayName(chatRecord2.getRemindRoleDisplayName());
                                                            chatSession.setHighlightPriority(chatRecord2.getHighlightPriority());
                                                            chatSession.setHighlightDesc(chatRecord2.getHighlightDesc());
                                                            chatSession.setLastMsgidFromMe(chatRecord2.getLastMsgidFromMe());
                                                            chatSession.setExt(chatRecord2.getExt());
                                                        }
                                                    } catch (Exception e) {
                                                        e = e;
                                                        arrayList = arrayList2;
                                                        str2 = str;
                                                        LogUtils.e(str2, "parseBusinessSessions exception ", e);
                                                        i5 = i + 1;
                                                        iMFetchBusinessSessionMsg2 = iMFetchBusinessSessionMsg;
                                                        str3 = str2;
                                                        jSONArray2 = jSONArray;
                                                    }
                                                } else {
                                                    iMFetchBusinessSessionMsg = this;
                                                }
                                                if (BIMManager.hudongTop && chatSession.getClassType() == 11) {
                                                    chatSession.setMarkTopTime(9223372036854765807L);
                                                    chatSession.setMarkTop(1);
                                                }
                                                arrayList = arrayList2;
                                                try {
                                                    arrayList.add(iMFetchBusinessSessionMsg.addAdvisoryValue(jSONObject, chatSession));
                                                    str2 = str;
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    str2 = str;
                                                    LogUtils.e(str2, "parseBusinessSessions exception ", e);
                                                    i5 = i + 1;
                                                    iMFetchBusinessSessionMsg2 = iMFetchBusinessSessionMsg;
                                                    str3 = str2;
                                                    jSONArray2 = jSONArray;
                                                }
                                            } catch (Exception e3) {
                                                e = e3;
                                                iMFetchBusinessSessionMsg = this;
                                            }
                                        } catch (Exception e4) {
                                            e = e4;
                                            iMFetchBusinessSessionMsg = this;
                                            arrayList = arrayList2;
                                            str2 = str;
                                            LogUtils.e(str2, "parseBusinessSessions exception ", e);
                                            i5 = i + 1;
                                            iMFetchBusinessSessionMsg2 = iMFetchBusinessSessionMsg;
                                            str3 = str2;
                                            jSONArray2 = jSONArray;
                                        }
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    iMFetchBusinessSessionMsg = iMFetchBusinessSessionMsg2;
                                }
                            } catch (Exception e6) {
                                e = e6;
                                iMFetchBusinessSessionMsg = iMFetchBusinessSessionMsg2;
                                str = str3;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            iMFetchBusinessSessionMsg = iMFetchBusinessSessionMsg2;
                            str = str3;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        iMFetchBusinessSessionMsg = iMFetchBusinessSessionMsg2;
                        str = str3;
                        i = i5;
                    }
                    i5 = i + 1;
                    iMFetchBusinessSessionMsg2 = iMFetchBusinessSessionMsg;
                    str3 = str2;
                    jSONArray2 = jSONArray;
                }
                return arrayList;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.mBusinessType == 27) {
                this.mBody = buildAdvisoryRequestParam();
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
            } else {
                TaskManager.getInstance(this.mContext).submitForNetWork(new MediaSessionResultTask(this, context, i, str, jSONObject));
            }
        }
    }
}
