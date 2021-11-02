package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.conversation.ConversationStudioManImpl;
import com.baidu.android.imsdk.group.GroupMessageManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.MessageParser;
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.request.MessageExt;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
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
/* loaded from: classes6.dex */
public class IMFetchMsgByIdMsg extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMFetchMsgByIdMsg";
    public static final Map<Long, Boolean> reliableListFirst;
    public transient /* synthetic */ FieldHolder $fh;
    public long mBeginId;
    public int mCategory;
    public long mContacter;
    public Context mContext;
    public int mCount;
    public long mEndId;
    public int mFetchNum;
    public int mJumpToRecent;
    public JSONObject mMessageExt;
    public long mTriggerReason;

    /* loaded from: classes6.dex */
    public class FetchTask extends TaskManager.Task {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context mContext;
        public int mErrorCode;
        public JSONObject mObj;
        public String mStrMsg;
        public final /* synthetic */ IMFetchMsgByIdMsg this$0;

        public FetchTask(IMFetchMsgByIdMsg iMFetchMsgByIdMsg, Context context, JSONObject jSONObject, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMFetchMsgByIdMsg, context, jSONObject, Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = iMFetchMsgByIdMsg;
            this.mContext = context;
            this.mObj = jSONObject;
            this.mErrorCode = i2;
            this.mStrMsg = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0083  */
        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Long] */
        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            ArrayList<ChatMsg> arrayList;
            int i2;
            int i3;
            boolean z;
            ArrayList<ChatMsg> parserMessage;
            ArrayList<ChatMsg> addMsgs;
            ArrayList<ChatMsg> arrayList2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Type type = new Type();
                type.t = 0L;
                JSONArray jSONArray = null;
                if (this.mErrorCode == 0 && this.mObj.has(NotificationCompat.CarExtender.KEY_MESSAGES)) {
                    try {
                        z = this.mObj.optBoolean("has_more", false);
                        try {
                            jSONArray = this.mObj.getJSONArray(NotificationCompat.CarExtender.KEY_MESSAGES);
                            i3 = jSONArray.length();
                            try {
                                LogUtils.d(IMFetchMsgByIdMsg.TAG, "fetch message result hasMore = " + z + " realMsgCount = " + i3 + " count = " + this.this$0.mCount);
                            } catch (JSONException e2) {
                                e = e2;
                                LogUtils.e(IMFetchMsgByIdMsg.TAG, "Exception ", e);
                                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                                if (z) {
                                }
                                parserMessage = MessageParser.parserMessage(this.mContext, jSONArray, type, true, true);
                                if (parserMessage != null) {
                                }
                                i2 = i3;
                                arrayList = parserMessage;
                                ChatMsgManagerImpl.getInstance(this.mContext).onFetchMsgByIdResult(this.mContext, this.mErrorCode, this.mStrMsg, this.this$0.mCategory, this.this$0.mContacter, this.this$0.mBeginId, this.this$0.mEndId, this.this$0.mCount, i2, ((Long) type.t).longValue(), this.this$0.getUUID(), arrayList, this.this$0.getListenerKey());
                            }
                        } catch (JSONException e3) {
                            e = e3;
                            i3 = 0;
                        }
                    } catch (JSONException e4) {
                        e = e4;
                        i3 = 0;
                        z = false;
                    }
                    if (z) {
                        i3 = Math.abs(this.this$0.mCount);
                        LogUtils.d(IMFetchMsgByIdMsg.TAG, "fetch message set realMsgCount = " + this.this$0.mCount);
                    }
                    parserMessage = MessageParser.parserMessage(this.mContext, jSONArray, type, true, true);
                    if (parserMessage != null || parserMessage.size() == 0) {
                        i2 = i3;
                        arrayList = parserMessage;
                    } else {
                        if (1 != this.this$0.mCategory) {
                            if (4 == this.this$0.mCategory) {
                                LogUtils.d(IMFetchMsgByIdMsg.TAG, " fetch cast message , size " + parserMessage.size());
                                Long valueOf = Long.valueOf(((TextMsg) parserMessage.get(0)).getCastId());
                                MessageExt.getInstance().setCastId(valueOf);
                                ArrayList arrayList3 = new ArrayList();
                                ArrayList arrayList4 = new ArrayList();
                                Iterator<ChatMsg> it = parserMessage.iterator();
                                while (it.hasNext()) {
                                    ChatMsg next = it.next();
                                    TextMsg textMsg = (TextMsg) next;
                                    if (ConversationStudioManImpl.getInstance(this.mContext).isReliable(textMsg.getCastId())) {
                                        arrayList3.add(textMsg);
                                        arrayList4.add(Long.valueOf(next.getMsgId()));
                                    }
                                }
                                LogUtils.d(IMFetchMsgByIdMsg.TAG, " fetch reliableMsgs cast message , size " + arrayList3.size() + ", ids :" + arrayList4.toString());
                                if (arrayList3.size() > 0) {
                                    ArrayList arrayList5 = new ArrayList();
                                    arrayList2 = ChatMessageDBManager.getInstance(this.mContext).addCastReliableMsgs(arrayList3, arrayList5);
                                    if (arrayList5.size() > 0) {
                                        JSONObject jSONObject = new JSONObject();
                                        try {
                                            jSONObject.put(Constants.RELIABLE_MSGID, Collections.max(arrayList5));
                                            jSONObject.put(Constants.RELIABLE_CASTID, ((TextMsg) arrayList2.get(0)).getCastId());
                                            jSONObject.put(Constants.RELIABLE_UPDATTIME, System.currentTimeMillis());
                                            Utility.setReliableMaxMsg(this.mContext, jSONObject);
                                        } catch (JSONException e5) {
                                            e5.printStackTrace();
                                        }
                                    }
                                    long castId = ((TextMsg) arrayList2.get(0)).getCastId();
                                    ConversationStudioManImpl.getInstance(this.mContext).deliverCastReliableMsg(castId, arrayList2);
                                    if (!IMFetchMsgByIdMsg.reliableListFirst.containsKey(Long.valueOf(castId))) {
                                        IMFetchMsgByIdMsg.reliableListFirst.put(Long.valueOf(castId), Boolean.FALSE);
                                    }
                                    if (IMFetchMsgByIdMsg.reliableListFirst.containsKey(Long.valueOf(castId)) && !IMFetchMsgByIdMsg.reliableListFirst.get(Long.valueOf(castId)).booleanValue()) {
                                        IMFetchMsgByIdMsg.reliableListFirst.put(Long.valueOf(castId), Boolean.TRUE);
                                        TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable(this, arrayList2) { // from class: com.baidu.android.imsdk.chatmessage.request.IMFetchMsgByIdMsg.FetchTask.1
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;
                                            public final /* synthetic */ FetchTask this$1;
                                            public final /* synthetic */ ArrayList val$finalMsgs;

                                            {
                                                Interceptable interceptable2 = $ic;
                                                if (interceptable2 != null) {
                                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                                    newInitContext.initArgs = r2;
                                                    Object[] objArr = {this, arrayList2};
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
                                                this.val$finalMsgs = arrayList2;
                                            }

                                            @Override // java.lang.Runnable
                                            public void run() {
                                                Interceptable interceptable2 = $ic;
                                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                                    LogUtils.d(IMFetchMsgByIdMsg.TAG, "可靠消息第一次拉礼物消息，多回一次ack：" + this.val$finalMsgs.toString());
                                                    MessageParser.handleAck(this.this$1.mContext, this.val$finalMsgs, false);
                                                }
                                            }
                                        });
                                    }
                                } else {
                                    arrayList2 = parserMessage;
                                }
                                MessageExt.getInstance().setdBLatestMsgId(Utility.getReliableMaxMsgId(this.mContext, valueOf.longValue()));
                                MessageExt.getInstance().setLocalTimestamp(Long.valueOf(System.currentTimeMillis()));
                                i2 = i3;
                                arrayList = arrayList2;
                            } else {
                                addMsgs = ChatMessageDBManager.getInstance(this.mContext).addMsgs(this.mContext, parserMessage, true, this.this$0.mTriggerReason);
                                PaManagerImpl.getInstance(this.mContext).syncAndQueryAllPaInfo();
                            }
                        } else {
                            addMsgs = GroupMessageManagerImpl.getInstance(this.mContext).addMsgs(parserMessage, true);
                        }
                        arrayList = addMsgs;
                        i2 = i3;
                    }
                } else {
                    arrayList = null;
                    i2 = 0;
                }
                ChatMsgManagerImpl.getInstance(this.mContext).onFetchMsgByIdResult(this.mContext, this.mErrorCode, this.mStrMsg, this.this$0.mCategory, this.this$0.mContacter, this.this$0.mBeginId, this.this$0.mEndId, this.this$0.mCount, i2, ((Long) type.t).longValue(), this.this$0.getUUID(), arrayList, this.this$0.getListenerKey());
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

    public IMFetchMsgByIdMsg(Context context, long j, long j2, int i2, int i3, long j3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mJumpToRecent = -1;
        this.mFetchNum = 0;
        initCommonParameter(context);
        this.mBeginId = j;
        this.mEndId = j2;
        this.mCount = i2;
        this.mCategory = i3;
        this.mContacter = j3;
        this.mTriggerReason = i4;
        this.mFetchNum = i5;
        this.mContext = context;
        setNeedReplay(true);
        setType(93);
        this.mMessageExt = new JSONObject();
    }

    public static IMFetchMsgByIdMsg newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, intent)) == null) {
            if (intent.hasExtra("contacter") && intent.hasExtra("count") && intent.hasExtra(Constants.EXTRA_TRIGGER_REASON)) {
                int intExtra = intent.getIntExtra("category", -1);
                long longExtra = intent.getLongExtra("contacter", -1L);
                int intExtra2 = intent.getIntExtra("count", -1);
                long longExtra2 = intent.getLongExtra(Constants.EXTRA_BEGIN_MSGID, -1L);
                long longExtra3 = intent.getLongExtra(Constants.EXTRA_END_MSGID, -1L);
                int intExtra3 = intent.getIntExtra(Constants.EXTRA_TRIGGER_REASON, -1);
                int intExtra4 = intent.getIntExtra(Constants.EXTRA_JUMP_MSG, -1);
                int intExtra5 = intent.getIntExtra(Constants.EXTRA_RETRY_TIME, 0);
                if (longExtra2 < 0 || longExtra3 < 0 || intExtra3 < 0) {
                    return null;
                }
                IMFetchMsgByIdMsg iMFetchMsgByIdMsg = new IMFetchMsgByIdMsg(context, longExtra2, longExtra3, intExtra2, intExtra, longExtra, intExtra3, intExtra5);
                iMFetchMsgByIdMsg.setJumpToNewMsg(intExtra4);
                return iMFetchMsgByIdMsg;
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
                jSONObject.put(Constants.EXTRA_BEGIN_MSGID, this.mBeginId);
                jSONObject.put(Constants.EXTRA_END_MSGID, this.mEndId);
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
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("rpc_retry_time", this.mFetchNum);
                jSONObject.put("rpc", jSONObject2.toString());
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                if (4 == this.mCategory) {
                    JSONObject json = MessageExt.getInstance().toJson();
                    this.mMessageExt = json;
                    if (json != null && json.length() > 0) {
                        jSONObject.put("ext_info", this.mMessageExt.toString());
                    }
                }
                this.mBody = jSONObject.toString();
                LogUtils.d(TAG, "长连接拉消息的消息body" + this.mBody);
            } catch (JSONException e2) {
                LogUtils.e(TAG, "Exception ", e2);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            }
        }
    }

    public int getCategory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCategory : invokeV.intValue;
    }

    public long getContacter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mContacter : invokeV.longValue;
    }

    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mCount : invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048580, this, context, jSONObject, i2, str) == null) {
            LogUtils.d(TAG, "fetch handleMessageResult err : " + i2 + ", msg :" + str);
            super.handleMessageResult(context, jSONObject, i2, str);
            TaskManager.getInstance(this.mContext).submitForNetWork(new FetchTask(this, context, jSONObject, i2, str));
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void onMsgSending(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            setSendingState(context);
        }
    }

    public void setJumpToNewMsg(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.mJumpToRecent = i2;
        }
    }
}
