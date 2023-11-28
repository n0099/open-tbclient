package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.MediaChatMessageManager;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.chatmessage.response.FetchMsgResponse;
import com.baidu.android.imsdk.conversation.ConversationStudioManImpl;
import com.baidu.android.imsdk.group.GroupMessageManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.MessageParser;
import com.baidu.android.imsdk.media.MediaSessionManager;
import com.baidu.android.imsdk.media.db.MediaMessageDBManager;
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.request.MessageExt;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.ubc.MessageUbc;
import com.baidu.android.imsdk.ubc.ScreenUbc;
import com.baidu.android.imsdk.ubc.UBCConstants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.tieba.b30;
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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMFetchMsgByIdMsg extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMFetchMsgByIdMsg";
    public static final Map<Long, Boolean> reliableListFirst;
    public transient /* synthetic */ FieldHolder $fh;
    public final long mBeginId;
    public int mBusinessType;
    public final int mCategory;
    public final long mContacter;
    public long mContacterBduid;
    public final long mContacterPaUid;
    public long mContacterUk;
    public final int mContacterUserType;
    public final Context mContext;
    public final int mCount;
    public MessageUbc.DebugInfo mDebugInfo;
    public final long mEndId;
    public String mEventList;
    public int mFetchTimes;
    public int mFetchTriggerReason;
    public boolean mIsFromMedia;
    public int mJumpToRecent;
    public JSONObject mMessageExt;
    public long mNotifyId;
    public long mNotifyMsgId;
    public String mScreenKey;
    public int mSessionType;
    public String mSource;
    public final long mTriggerReason;
    public MessageUbc mUbcData;

    /* loaded from: classes.dex */
    public class ParseResultTask extends TaskManager.Task {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context mContext;
        public int mErrorCode;
        public JSONObject mObj;
        public ScreenUbc.MethodInfo mScreenMethodInfo;
        public String mStrMsg;
        public final /* synthetic */ IMFetchMsgByIdMsg this$0;

        public ParseResultTask(IMFetchMsgByIdMsg iMFetchMsgByIdMsg, Context context, JSONObject jSONObject, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMFetchMsgByIdMsg, context, jSONObject, Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = iMFetchMsgByIdMsg;
            this.mContext = context;
            this.mObj = jSONObject;
            this.mErrorCode = i;
            this.mStrMsg = str;
            if (!TextUtils.isEmpty(iMFetchMsgByIdMsg.mScreenKey)) {
                this.mScreenMethodInfo = Utility.getScreenMethodInfo(iMFetchMsgByIdMsg.mScreenKey);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:100:0x0442  */
        /* JADX WARN: Removed duplicated region for block: B:134:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00b7 A[Catch: JSONException -> 0x00fc, TRY_ENTER, TryCatch #4 {JSONException -> 0x00fc, blocks: (B:27:0x00aa, B:30:0x00b7, B:32:0x00c2, B:33:0x00c7), top: B:121:0x00aa }] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00c2 A[Catch: JSONException -> 0x00fc, TryCatch #4 {JSONException -> 0x00fc, blocks: (B:27:0x00aa, B:30:0x00b7, B:32:0x00c2, B:33:0x00c7), top: B:121:0x00aa }] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0125  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x02fe  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x0330  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x03f3  */
        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Long] */
        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            String str;
            boolean z;
            JSONArray jSONArray;
            boolean z2;
            int i;
            boolean z3;
            ArrayList<ChatMsg> parserMessage;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Type type = new Type();
                type.t = 0L;
                String eventList = this.this$0.getEventList();
                ArrayList<ChatMsg> arrayList = null;
                JSONArray jSONArray2 = null;
                int i2 = 0;
                if (this.mErrorCode == 0 && this.mObj.has(NotificationCompat.CarExtender.KEY_MESSAGES)) {
                    try {
                        z2 = this.mObj.optBoolean("has_more", false);
                        try {
                            jSONArray = this.mObj.getJSONArray(NotificationCompat.CarExtender.KEY_MESSAGES);
                            try {
                                i = jSONArray.length();
                                try {
                                    LogUtils.d(IMFetchMsgByIdMsg.TAG, "fetch message result hasMore = " + z2 + " realMsgCount = " + i + " count = " + this.this$0.mCount);
                                } catch (JSONException e) {
                                    e = e;
                                    LogUtils.e(IMFetchMsgByIdMsg.TAG, "Exception ", e);
                                    z3 = z2;
                                    if (z3) {
                                    }
                                    int i3 = i;
                                    int optInt = this.mObj.optInt(Constants.EXTRA_BC_FETCH_TRIGGER_REASON, 0);
                                    JSONObject jSONObject = new JSONObject();
                                    if (!TextUtils.isEmpty(eventList)) {
                                    }
                                    if (jSONArray2 == null) {
                                    }
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("event", "CIMFetchEnd");
                                    jSONObject2.put("timestamp_ms", System.currentTimeMillis());
                                    jSONArray2.put(jSONObject2);
                                    jSONObject.put("event_list", jSONArray2);
                                    eventList = jSONObject.toString();
                                    LogUtils.d(IMFetchMsgByIdMsg.TAG, "ParseResultTask event_list :" + eventList);
                                    String str2 = eventList;
                                    Context context = this.mContext;
                                    long j = this.this$0.mNotifyMsgId;
                                    long j2 = this.this$0.mNotifyId;
                                    str = IMFetchMsgByIdMsg.TAG;
                                    parserMessage = MessageParser.parserMessage(context, jSONArray, type, true, true, j, j2, str2, optInt);
                                    if (parserMessage.size() != 0) {
                                    }
                                    arrayList = parserMessage;
                                    z = z3;
                                    i2 = i3;
                                    eventList = str2;
                                    if (!TextUtils.isEmpty(this.this$0.mScreenKey)) {
                                    }
                                    if (this.this$0.mCategory != 9) {
                                    }
                                    TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable(this) { // from class: com.baidu.android.imsdk.chatmessage.request.IMFetchMsgByIdMsg.ParseResultTask.2
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ ParseResultTask this$1;

                                        {
                                            Interceptable interceptable2 = $ic;
                                            if (interceptable2 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
                                                interceptable2.invokeUnInit(65536, newInitContext);
                                                int i4 = newInitContext.flag;
                                                if ((i4 & 1) != 0) {
                                                    int i5 = i4 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable2.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$1 = this;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable2 = $ic;
                                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                                PaManagerImpl.getInstance(this.this$1.mContext).syncAndQueryAllPaInfo();
                                            }
                                        }
                                    });
                                    if (this.mErrorCode != 0) {
                                    }
                                }
                            } catch (JSONException e2) {
                                e = e2;
                                i = 0;
                                LogUtils.e(IMFetchMsgByIdMsg.TAG, "Exception ", e);
                                z3 = z2;
                                if (z3) {
                                }
                                int i32 = i;
                                int optInt2 = this.mObj.optInt(Constants.EXTRA_BC_FETCH_TRIGGER_REASON, 0);
                                JSONObject jSONObject3 = new JSONObject();
                                if (!TextUtils.isEmpty(eventList)) {
                                }
                                if (jSONArray2 == null) {
                                }
                                JSONObject jSONObject22 = new JSONObject();
                                jSONObject22.put("event", "CIMFetchEnd");
                                jSONObject22.put("timestamp_ms", System.currentTimeMillis());
                                jSONArray2.put(jSONObject22);
                                jSONObject3.put("event_list", jSONArray2);
                                eventList = jSONObject3.toString();
                                LogUtils.d(IMFetchMsgByIdMsg.TAG, "ParseResultTask event_list :" + eventList);
                                String str22 = eventList;
                                Context context2 = this.mContext;
                                long j3 = this.this$0.mNotifyMsgId;
                                long j22 = this.this$0.mNotifyId;
                                str = IMFetchMsgByIdMsg.TAG;
                                parserMessage = MessageParser.parserMessage(context2, jSONArray, type, true, true, j3, j22, str22, optInt2);
                                if (parserMessage.size() != 0) {
                                }
                                arrayList = parserMessage;
                                z = z3;
                                i2 = i32;
                                eventList = str22;
                                if (!TextUtils.isEmpty(this.this$0.mScreenKey)) {
                                }
                                if (this.this$0.mCategory != 9) {
                                }
                                TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable(this) { // from class: com.baidu.android.imsdk.chatmessage.request.IMFetchMsgByIdMsg.ParseResultTask.2
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ ParseResultTask this$1;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = objArr;
                                            Object[] objArr = {this};
                                            interceptable2.invokeUnInit(65536, newInitContext);
                                            int i4 = newInitContext.flag;
                                            if ((i4 & 1) != 0) {
                                                int i5 = i4 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                            PaManagerImpl.getInstance(this.this$1.mContext).syncAndQueryAllPaInfo();
                                        }
                                    }
                                });
                                if (this.mErrorCode != 0) {
                                }
                            }
                        } catch (JSONException e3) {
                            e = e3;
                            jSONArray = null;
                        }
                    } catch (JSONException e4) {
                        e = e4;
                        jSONArray = null;
                        z2 = false;
                    }
                    z3 = z2;
                    if (z3) {
                        i = Math.abs(this.this$0.mCount);
                        LogUtils.d(IMFetchMsgByIdMsg.TAG, "fetch message set realMsgCount = " + this.this$0.mCount);
                    }
                    int i322 = i;
                    int optInt22 = this.mObj.optInt(Constants.EXTRA_BC_FETCH_TRIGGER_REASON, 0);
                    try {
                        JSONObject jSONObject32 = new JSONObject();
                        if (!TextUtils.isEmpty(eventList)) {
                            jSONArray2 = new JSONObject(eventList).optJSONArray("event_list");
                        }
                        if (jSONArray2 == null) {
                            jSONArray2 = new JSONArray();
                        }
                        JSONObject jSONObject222 = new JSONObject();
                        jSONObject222.put("event", "CIMFetchEnd");
                        jSONObject222.put("timestamp_ms", System.currentTimeMillis());
                        jSONArray2.put(jSONObject222);
                        jSONObject32.put("event_list", jSONArray2);
                        eventList = jSONObject32.toString();
                        LogUtils.d(IMFetchMsgByIdMsg.TAG, "ParseResultTask event_list :" + eventList);
                    } catch (JSONException e5) {
                        LogUtils.e(IMFetchMsgByIdMsg.TAG, "ParseResultTask eventList ", e5);
                    }
                    String str222 = eventList;
                    Context context22 = this.mContext;
                    long j32 = this.this$0.mNotifyMsgId;
                    long j222 = this.this$0.mNotifyId;
                    str = IMFetchMsgByIdMsg.TAG;
                    parserMessage = MessageParser.parserMessage(context22, jSONArray, type, true, true, j32, j222, str222, optInt22);
                    if (parserMessage.size() != 0) {
                        if (1 == this.this$0.mCategory) {
                            arrayList = GroupMessageManagerImpl.getInstance(this.mContext).addMsgs(parserMessage, true);
                        } else if (4 == this.this$0.mCategory) {
                            LogUtils.d(str, " fetch cast message , size " + parserMessage.size());
                            long castId = ((TextMsg) parserMessage.get(0)).getCastId();
                            MessageExt.getInstance().setCastId(Long.valueOf(castId));
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = new ArrayList();
                            Iterator<ChatMsg> it = parserMessage.iterator();
                            while (it.hasNext()) {
                                ChatMsg next = it.next();
                                TextMsg textMsg = (TextMsg) next;
                                if (ConversationStudioManImpl.getInstance(this.mContext).isReliable(textMsg.getCastId())) {
                                    arrayList2.add(textMsg);
                                    arrayList3.add(Long.valueOf(next.getMsgId()));
                                }
                            }
                            LogUtils.d(str, " fetch reliableMsgs cast message , size " + arrayList2.size() + ", ids :" + arrayList3.toString());
                            if (arrayList2.size() > 0) {
                                ArrayList arrayList4 = new ArrayList();
                                ArrayList<ChatMsg> addCastReliableMsgs = ChatMessageDBManager.getInstance(this.mContext).addCastReliableMsgs(arrayList2, arrayList4);
                                if (arrayList4.size() > 0) {
                                    JSONObject jSONObject4 = new JSONObject();
                                    try {
                                        jSONObject4.put(Constants.RELIABLE_MSGID, Collections.max(arrayList4));
                                        jSONObject4.put(Constants.RELIABLE_CASTID, ((TextMsg) addCastReliableMsgs.get(0)).getCastId());
                                        jSONObject4.put(Constants.RELIABLE_UPDATTIME, System.currentTimeMillis());
                                        Utility.setReliableMaxMsg(this.mContext, jSONObject4);
                                    } catch (JSONException e6) {
                                        e6.printStackTrace();
                                    }
                                }
                                long castId2 = ((TextMsg) addCastReliableMsgs.get(0)).getCastId();
                                ConversationStudioManImpl.getInstance(this.mContext).deliverCastReliableMsg(castId2, addCastReliableMsgs);
                                if (!IMFetchMsgByIdMsg.reliableListFirst.containsKey(Long.valueOf(castId2))) {
                                    IMFetchMsgByIdMsg.reliableListFirst.put(Long.valueOf(castId2), Boolean.FALSE);
                                }
                                if (IMFetchMsgByIdMsg.reliableListFirst.containsKey(Long.valueOf(castId2)) && !IMFetchMsgByIdMsg.reliableListFirst.get(Long.valueOf(castId2)).booleanValue()) {
                                    IMFetchMsgByIdMsg.reliableListFirst.put(Long.valueOf(castId2), Boolean.TRUE);
                                    TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable(this, addCastReliableMsgs) { // from class: com.baidu.android.imsdk.chatmessage.request.IMFetchMsgByIdMsg.ParseResultTask.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ ParseResultTask this$1;
                                        public final /* synthetic */ ArrayList val$finalMsgs;

                                        {
                                            Interceptable interceptable2 = $ic;
                                            if (interceptable2 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this, addCastReliableMsgs};
                                                interceptable2.invokeUnInit(65536, newInitContext);
                                                int i4 = newInitContext.flag;
                                                if ((i4 & 1) != 0) {
                                                    int i5 = i4 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable2.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$1 = this;
                                            this.val$finalMsgs = addCastReliableMsgs;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable2 = $ic;
                                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                                LogUtils.d(IMFetchMsgByIdMsg.TAG, "可靠消息第一次拉礼物消息，多回一次ack：" + this.val$finalMsgs.toString());
                                                MessageParser.handleAck(this.this$1.mContext, this.val$finalMsgs, true);
                                            }
                                        }
                                    });
                                }
                                parserMessage = addCastReliableMsgs;
                            }
                            MessageExt.getInstance().setdBLatestMsgId(Utility.getReliableMaxMsgId(this.mContext, castId));
                            MessageExt.getInstance().setLocalTimestamp(Long.valueOf(System.currentTimeMillis()));
                        } else if (9 != this.this$0.mCategory) {
                            if (this.this$0.mIsFromMedia) {
                                ScreenUbc.MethodInfo methodInfo = this.mScreenMethodInfo;
                                if (methodInfo != null) {
                                    Utility.addEventList(methodInfo.eventList, "replaceChatMsgList_begin");
                                }
                                MediaMessageDBManager.getInstance(this.mContext).replaceChatMsgList(parserMessage);
                            } else {
                                ScreenUbc.MethodInfo methodInfo2 = this.mScreenMethodInfo;
                                if (methodInfo2 != null) {
                                    Utility.addEventList(methodInfo2.eventList, "addMsgs_begin");
                                }
                                arrayList = ChatMessageDBManager.getInstance(this.mContext).addMsgs(this.mContext, parserMessage, true, this.this$0.mTriggerReason);
                            }
                        }
                        z = z3;
                        i2 = i322;
                        eventList = str222;
                    }
                    arrayList = parserMessage;
                    z = z3;
                    i2 = i322;
                    eventList = str222;
                } else {
                    str = IMFetchMsgByIdMsg.TAG;
                    z = false;
                }
                if (!TextUtils.isEmpty(this.this$0.mScreenKey)) {
                    ScreenUbc.MethodInfo screenMethodInfo = Utility.getScreenMethodInfo(this.this$0.mScreenKey);
                    try {
                        JSONObject jSONObject5 = new JSONObject(this.this$0.mBody);
                        if (jSONObject5.has("client_logid")) {
                            screenMethodInfo.clientLogId = jSONObject5.optString("client_logid");
                        }
                    } catch (JSONException unused) {
                    }
                    Utility.addEventList(screenMethodInfo.eventList, "onFetchMsgByIdResult");
                }
                if (this.this$0.mCategory != 9) {
                    if (this.this$0.mIsFromMedia) {
                        FetchMsgResponse fetchMsgResponse = new FetchMsgResponse();
                        fetchMsgResponse.errorCode = this.mErrorCode;
                        fetchMsgResponse.strMsg = this.mStrMsg;
                        fetchMsgResponse.category = this.this$0.mCategory;
                        fetchMsgResponse.contacter = this.this$0.mContacter;
                        fetchMsgResponse.beginId = this.this$0.mBeginId;
                        fetchMsgResponse.endId = this.this$0.mEndId;
                        fetchMsgResponse.count = this.this$0.mCount;
                        fetchMsgResponse.realCount = i2;
                        fetchMsgResponse.maxMsgid = ((Long) type.t).longValue();
                        fetchMsgResponse.uuid = this.this$0.getUUID();
                        fetchMsgResponse.msgs = arrayList;
                        fetchMsgResponse.listenerkey = this.this$0.getListenerKey();
                        fetchMsgResponse.fetchReason = (int) this.this$0.mTriggerReason;
                        MediaChatMessageManager.getInstance(this.mContext).onFetchMsgByIdResult(fetchMsgResponse, this.this$0.mScreenKey);
                    } else {
                        ChatMsgManagerImpl.getInstance(this.mContext).onFetchMsgByIdResult(this.mErrorCode, this.mStrMsg, this.this$0.mCategory, this.this$0.mContacter, this.this$0.mBeginId, this.this$0.mEndId, this.this$0.mCount, i2, ((Long) type.t).longValue(), this.this$0.getUUID(), arrayList, this.this$0.getListenerKey(), this.this$0.mScreenKey);
                    }
                } else {
                    ChatMsgManagerImpl.getInstance(this.mContext).onFetchBusinessMsgResult(this.mErrorCode, this.mStrMsg, this.this$0.mBeginId, this.this$0.mEndId, this.this$0.mCount, this.this$0.mContacter, z, this.this$0.mBusinessType, this.this$0.mSessionType, arrayList, this.this$0.getListenerKey());
                }
                TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable(this) { // from class: com.baidu.android.imsdk.chatmessage.request.IMFetchMsgByIdMsg.ParseResultTask.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ParseResultTask this$1;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = objArr;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            PaManagerImpl.getInstance(this.this$1.mContext).syncAndQueryAllPaInfo();
                        }
                    }
                });
                if (this.mErrorCode != 0) {
                    this.this$0.mDebugInfo.eventList = eventList;
                    this.this$0.mDebugInfo.clientSource = this.this$0.mSource;
                    try {
                        JSONObject jSONObject6 = new JSONObject(this.this$0.mBody);
                        if (jSONObject6.has("client_logid")) {
                            this.this$0.mDebugInfo.clientLogId = jSONObject6.optString("client_logid");
                        }
                    } catch (Exception e7) {
                        LogUtils.e(str, "clientLogId :" + e7.getMessage());
                    }
                    this.this$0.mUbcData.setDebugInfo(this.this$0.mDebugInfo);
                    b30.d().f(this.this$0.mUbcData.generateUBCData(String.valueOf(this.mErrorCode), this.mStrMsg), UBCConstants.IS_REAL, UBCConstants.IS_SAVE_DB, UBCConstants.IS_ASYNC);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1198856258, "Lcom/baidu/android/imsdk/chatmessage/request/IMFetchMsgByIdMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1198856258, "Lcom/baidu/android/imsdk/chatmessage/request/IMFetchMsgByIdMsg;");
                return;
            }
        }
        reliableListFirst = new ConcurrentHashMap();
    }

    public int getCategory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mCategory;
        }
        return invokeV.intValue;
    }

    public long getContacter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mContacter;
        }
        return invokeV.longValue;
    }

    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mCount;
        }
        return invokeV.intValue;
    }

    public IMFetchMsgByIdMsg(Context context, long j, long j2, long j3, long j4, String str, String str2, int i, int i2, long j5, int i3, int i4, int i5, long j6, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), str, str2, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j5), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j6), Integer.valueOf(i6)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mJumpToRecent = -1;
        this.mFetchTimes = 0;
        this.mBusinessType = 0;
        this.mSessionType = 0;
        this.mDebugInfo = new MessageUbc.DebugInfo();
        this.mSource = "";
        this.mFetchTriggerReason = 0;
        this.mScreenKey = "";
        initCommonParameter(context);
        this.mBeginId = j;
        this.mEndId = j2;
        this.mNotifyMsgId = j3;
        this.mNotifyId = j4;
        this.mEventList = str;
        this.mCount = i;
        this.mCategory = i2;
        this.mContacter = j5;
        this.mTriggerReason = i3;
        this.mFetchTimes = i4;
        this.mContacterUserType = i5;
        this.mContacterPaUid = j6;
        this.mContext = context;
        setNeedReplay(true);
        setType(93);
        this.mMessageExt = new JSONObject();
        this.mUbcData = new MessageUbc(context, new TextMsg());
        MessageUbc.DebugInfo debugInfo = this.mDebugInfo;
        debugInfo.methodId = 93L;
        debugInfo.msgId = this.mBeginId;
        debugInfo.notifyId = j4;
        this.mSource = str2;
        this.mFetchTriggerReason = i6;
    }

    private void setBusinessType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65557, this, i) == null) {
            this.mBusinessType = i;
        }
    }

    private void setSessionType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65558, this, i) == null) {
            this.mSessionType = i;
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void onMsgSending(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            setSendingState(context);
        }
    }

    public void setJumpToNewMsg(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.mJumpToRecent = i;
        }
    }

    private void appendMediaParam(JSONObject jSONObject) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65555, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            if (AccountManagerImpl.getInstance(this.mContext).getMediaRole()) {
                i = 1;
            } else {
                i = 0;
            }
            jSONObject.put("user_type", i);
            long meidaPaid = MediaSessionManager.getInstance(this.mContext).getMeidaPaid();
            if (meidaPaid > 0) {
                jSONObject.put(Constants.EXTRA_PAUID_TYPE, meidaPaid);
            }
            long bduid = AccountManagerImpl.getInstance(this.mContext).getBduid();
            if (bduid > 0) {
                jSONObject.put("bduid", bduid);
            }
            if (this.mContacterUserType > -1) {
                jSONObject.put("contacter_user_type", this.mContacterUserType);
            }
            if (this.mContacterPaUid > 0) {
                jSONObject.put("contacter_pa_uid", this.mContacterPaUid);
            }
            if (this.mContacterBduid > 0) {
                jSONObject.put("contacter_bduid", this.mContacterBduid);
            }
            if (this.mContacterUk > 0) {
                jSONObject.put("contacter_uk", this.mContacterUk);
            }
        } catch (JSONException e) {
            LogUtils.e(TAG, "Exception ", e);
        }
    }

    public static IMFetchMsgByIdMsg newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, context, intent)) == null) {
            if (intent.hasExtra("contacter") && intent.hasExtra("count") && intent.hasExtra(Constants.EXTRA_TRIGGER_REASON)) {
                int intExtra = intent.getIntExtra("category", -1);
                long longExtra = intent.getLongExtra("contacter", -1L);
                int intExtra2 = intent.getIntExtra("count", -1);
                long longExtra2 = intent.getLongExtra(Constants.EXTRA_BEGIN_MSGID, -1L);
                long longExtra3 = intent.getLongExtra(Constants.EXTRA_END_MSGID, -1L);
                long longExtra4 = intent.getLongExtra(Constants.EXTRA_NOTIFY_MSGID, -1L);
                long longExtra5 = intent.getLongExtra(Constants.EXTRA_NOTIFY_ID, -1L);
                String stringExtra = intent.getStringExtra("event_list");
                int intExtra3 = intent.getIntExtra(Constants.EXTRA_TRIGGER_REASON, -1);
                int intExtra4 = intent.getIntExtra(Constants.EXTRA_JUMP_MSG, -1);
                int intExtra5 = intent.getIntExtra(Constants.EXTRA_RETRY_TIME, 0);
                int intExtra6 = intent.getIntExtra(Constants.EXTRA_BUSINESS_TYPE, 0);
                int intExtra7 = intent.getIntExtra("session_type", -1);
                int intExtra8 = intent.getIntExtra("contacter_user_type", 0);
                long longExtra6 = intent.getLongExtra("contacter_pa_uid", 0L);
                long longExtra7 = intent.getLongExtra("contacter_bduid", 0L);
                long longExtra8 = intent.getLongExtra("contacter_uk", 0L);
                boolean booleanExtra = intent.getBooleanExtra(Constants.EXTRA_FROM_MEDIA, false);
                String stringExtra2 = intent.getStringExtra(Constants.EXTRA_SCREEN_KEY);
                int intExtra9 = intent.getIntExtra(Constants.EXTRA_BC_FETCH_TRIGGER_REASON, 0);
                String stringExtra3 = intent.getStringExtra(Constants.EXTRA_LISTENER_ID);
                String stringExtra4 = intent.getStringExtra("source");
                if (longExtra2 >= 0 && longExtra3 >= 0 && intExtra3 >= 0) {
                    IMFetchMsgByIdMsg iMFetchMsgByIdMsg = new IMFetchMsgByIdMsg(context, longExtra2, longExtra3, longExtra4, longExtra5, stringExtra, stringExtra4, intExtra2, intExtra, longExtra, intExtra3, intExtra5, intExtra8, longExtra6, intExtra9);
                    iMFetchMsgByIdMsg.setJumpToNewMsg(intExtra4);
                    iMFetchMsgByIdMsg.setBusinessType(intExtra6);
                    iMFetchMsgByIdMsg.setSessionType(intExtra7);
                    iMFetchMsgByIdMsg.mIsFromMedia = booleanExtra;
                    iMFetchMsgByIdMsg.mContacterBduid = longExtra7;
                    iMFetchMsgByIdMsg.mContacterUk = longExtra8;
                    iMFetchMsgByIdMsg.setListenerKey(stringExtra3);
                    iMFetchMsgByIdMsg.mScreenKey = stringExtra2;
                    return iMFetchMsgByIdMsg;
                }
                return null;
            }
            return null;
        }
        return (IMFetchMsgByIdMsg) invokeLL.objValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", 93);
                jSONObject.put("appid", this.mAppid);
                jSONObject.put("uk", this.mUk);
                if (this.mBeginId >= 0) {
                    jSONObject.put(Constants.EXTRA_BEGIN_MSGID, this.mBeginId);
                }
                if (this.mEndId > 0) {
                    jSONObject.put(Constants.EXTRA_END_MSGID, this.mEndId);
                }
                jSONObject.put("count", this.mCount);
                if (this.mContacter >= 0) {
                    jSONObject.put("to", this.mContacter);
                }
                if (this.mCategory >= 0) {
                    jSONObject.put("category", this.mCategory);
                }
                if (this.mJumpToRecent != -1) {
                    jSONObject.put(Constants.KEY_JUMP_TO_RECENT_MSG, this.mJumpToRecent);
                }
                if (this.mJumpToRecent == 1) {
                    jSONObject.put("most_recent_msg_num", this.mCount);
                }
                if (this.mTriggerReason == 2) {
                    jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
                }
                if (this.mBusinessType > 0) {
                    jSONObject.put("business_type", this.mBusinessType);
                }
                if (this.mSessionType >= 0) {
                    jSONObject.put("session_type", this.mSessionType);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("rpc_retry_time", this.mFetchTimes);
                jSONObject.put("rpc", jSONObject2.toString());
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("client_business_source", this.mSource);
                if (4 == this.mCategory) {
                    JSONObject json = MessageExt.getInstance().toJson();
                    this.mMessageExt = json;
                    if (json != null && json.length() > 0) {
                        jSONObject.put(MigrateStatisticUtils.EXT_INFO, this.mMessageExt.toString());
                    }
                }
                if (this.mIsFromMedia) {
                    appendMediaParam(jSONObject);
                }
                jSONObject.put(Constants.EXTRA_BC_FETCH_TRIGGER_REASON, this.mFetchTriggerReason);
                JSONArray jSONArray = null;
                try {
                    if (!TextUtils.isEmpty(this.mEventList)) {
                        jSONArray = new JSONObject(this.mEventList).optJSONArray("event_list");
                    }
                    if (jSONArray == null) {
                        jSONArray = new JSONArray();
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("event", "CIMFetchBegin");
                    jSONObject3.put("timestamp_ms", System.currentTimeMillis());
                    jSONArray.put(jSONObject3);
                    jSONObject.put("event_list", jSONArray);
                    if (this.mNotifyId > 0) {
                        jSONObject.put(Constants.EXTRA_NOTIFY_ID, this.mNotifyId);
                    }
                } catch (JSONException e) {
                    LogUtils.e(TAG, "event_list ", e);
                }
                this.mBody = jSONObject.toString();
                LogUtils.d(TAG, "长连接拉消息的消息 is media:" + this.mIsFromMedia + ";body" + this.mBody);
            } catch (JSONException e2) {
                LogUtils.e(TAG, "Exception ", e2);
            }
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048580, this, context, jSONObject, i, str) == null) {
            LogUtils.d(TAG, "handleMessageResult isMedia: " + this.mIsFromMedia + ";errorCode:" + i + ", msg:" + str);
            super.handleMessageResult(context, jSONObject, i, str);
            if (this.mNotifyId > 0 && !AccountManager.getMediaRole(this.mContext) && this.mCategory == 0) {
                setEventList(Utility.appendEventList(getEventList(), "CIMResultFetch"));
            }
            if (!TextUtils.isEmpty(this.mScreenKey)) {
                Utility.addEventList(Utility.getScreenMethodInfo(this.mScreenKey).eventList, "handleMessageResult_subTask");
            }
            TaskManager.getInstance(this.mContext).submitForNetWork(new ParseResultTask(this, context, jSONObject, i, str));
        }
    }
}
