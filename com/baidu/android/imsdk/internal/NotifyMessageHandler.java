package com.baidu.android.imsdk.internal;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl;
import com.baidu.android.imsdk.chatmessage.IMediaGetChatSessionListener;
import com.baidu.android.imsdk.chatmessage.MediaChatMessageManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.request.Type;
import com.baidu.android.imsdk.chatmessage.request.params.FetchMsgParam;
import com.baidu.android.imsdk.chatmessage.sync.Generator;
import com.baidu.android.imsdk.chatmessage.sync.SyncGroupMessageService;
import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import com.baidu.android.imsdk.conversation.ConversationStudioManImpl;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.ubc.CaseUbc;
import com.baidu.android.imsdk.ubc.UBCConstants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.tieba.a30;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class NotifyMessageHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "NotifyMessageHandler";
    public transient /* synthetic */ FieldHolder $fh;

    public NotifyMessageHandler() {
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

    public static void handleBusinessCustomizeNotify(Context context, int i, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65538, null, context, i, jSONObject) == null) {
            ChatMsgManagerImpl.getInstance(context).handleCustomNotifyMessage(i, jSONObject);
        }
    }

    public static void handleMcastMessage(Context context, JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, context, jSONObject, str) == null) {
            TaskManager.getInstance(context).submitForNetWork(new Runnable(context, jSONObject, str) { // from class: com.baidu.android.imsdk.internal.NotifyMessageHandler.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ String val$eventList;
                public final /* synthetic */ JSONObject val$msgObj;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, jSONObject, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$context = context;
                    this.val$msgObj = jSONObject;
                    this.val$eventList = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ConversationStudioManImpl.getInstance(this.val$context).handleMessage(this.val$msgObj, this.val$eventList);
                    }
                }
            });
        }
    }

    public static void handleBusinessMsgNotify(Context context, int i, int i2, long j, int i3, long j2, long j3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3), str}) == null) {
            boolean isShieldSession = BIMManager.isShieldSession(9, i);
            LogUtils.d(TAG, "96新消息通知拉取，问一问消息屏蔽状态：" + isShieldSession);
            if (isShieldSession) {
                return;
            }
            List<ChatSession> busiChatSessionsFromDb = ChatSessionManagerImpl.getInstance(context).getBusiChatSessionsFromDb(i, i2, 0L, 0L, Long.MAX_VALUE, -1, 1);
            long j4 = 0;
            if (busiChatSessionsFromDb != null && busiChatSessionsFromDb.size() > 0) {
                if (i3 == 2) {
                    j4 = busiChatSessionsFromDb.get(0).getLastMsgId();
                }
            }
            handleConsultMsgChanged(context, i, i2, j, i3, j2, j3, str);
            ChatSessionManagerImpl.getInstance(context).updateBusiSessionAndGet(i, i2, 0L, j4 + 1, Long.MAX_VALUE, -20, 2, 1, new IMediaGetChatSessionListener(j, context, i, i3, j2, j3, str) { // from class: com.baidu.android.imsdk.internal.NotifyMessageHandler.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int val$businessType;
                public final /* synthetic */ long val$contacterImUk;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ String val$eventList;
                public final /* synthetic */ long val$notifyId;
                public final /* synthetic */ long val$notifyMsgId;
                public final /* synthetic */ int val$notifyType;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Long.valueOf(j), context, Integer.valueOf(i), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3), str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$contacterImUk = j;
                    this.val$context = context;
                    this.val$businessType = i;
                    this.val$notifyType = i3;
                    this.val$notifyMsgId = j2;
                    this.val$notifyId = j3;
                    this.val$eventList = str;
                }

                @Override // com.baidu.android.imsdk.chatmessage.IMediaGetChatSessionListener
                public void onMediaGetChatSessionResult(int i4, int i5, int i6, boolean z, List<ChatSession> list) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Boolean.valueOf(z), list}) == null) && i4 == 0 && list != null && list.size() > 0) {
                        for (ChatSession chatSession : list) {
                            if (chatSession.getContacter() != this.val$contacterImUk) {
                                NotifyMessageHandler.handleConsultMsgChanged(this.val$context, this.val$businessType, chatSession.getSessionType(), chatSession.getContacter(), this.val$notifyType, this.val$notifyMsgId, this.val$notifyId, this.val$eventList);
                            }
                        }
                    }
                }
            });
        }
    }

    public static void handleClueMsgNotify(Context context, int i, int i2, long j, int i3, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3), jSONObject}) == null) && jSONObject != null && i3 == 0 && i == 238) {
            long optLong = jSONObject.optLong("contacter_pa_uid", -1L);
            int optInt = jSONObject.optInt("contacter_user_type", 0);
            String optString = jSONObject.optString(Constants.EXTRA_BUSINESS_MSG_EXT);
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            int optInt2 = jSONObject.optInt("im_notify_type");
            if (optInt2 == 6) {
                try {
                    JSONArray optJSONArray = new JSONObject(optString).optJSONArray("msgid");
                    int length = optJSONArray.length();
                    if (length > 0) {
                        TaskManager.getInstance(context).submitForNetWork(new Runnable(length, optJSONArray, context, optLong, optInt, i3, j) { // from class: com.baidu.android.imsdk.internal.NotifyMessageHandler.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ int val$category;
                            public final /* synthetic */ long val$contacterImUk;
                            public final /* synthetic */ long val$contacterPauid;
                            public final /* synthetic */ int val$contacterUserType;
                            public final /* synthetic */ Context val$context;
                            public final /* synthetic */ JSONArray val$notifyArray;
                            public final /* synthetic */ int val$notifySize;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {Integer.valueOf(length), optJSONArray, context, Long.valueOf(optLong), Integer.valueOf(optInt), Integer.valueOf(i3), Long.valueOf(j)};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i4 = newInitContext.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.val$notifySize = length;
                                this.val$notifyArray = optJSONArray;
                                this.val$context = context;
                                this.val$contacterPauid = optLong;
                                this.val$contacterUserType = optInt;
                                this.val$category = i3;
                                this.val$contacterImUk = j;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    for (int i4 = 0; i4 < this.val$notifySize; i4++) {
                                        long optLong2 = this.val$notifyArray.optLong(i4, -1L);
                                        if (optLong2 > 0) {
                                            LogUtils.d(NotifyMessageHandler.TAG, "B身份更新单条消息，msgid：" + optLong2);
                                            FetchMsgParam.FetchMsgParamConstruct fetchMsgParamConstruct = new FetchMsgParam.FetchMsgParamConstruct(this) { // from class: com.baidu.android.imsdk.internal.NotifyMessageHandler.3.1
                                                public static /* synthetic */ Interceptable $ic;
                                                public transient /* synthetic */ FieldHolder $fh;
                                                public final /* synthetic */ AnonymousClass3 this$0;

                                                {
                                                    Interceptable interceptable3 = $ic;
                                                    if (interceptable3 != null) {
                                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                                        newInitContext.initArgs = r2;
                                                        Object[] objArr = {this};
                                                        interceptable3.invokeUnInit(65536, newInitContext);
                                                        int i5 = newInitContext.flag;
                                                        if ((i5 & 1) != 0) {
                                                            int i6 = i5 & 2;
                                                            newInitContext.thisArg = this;
                                                            interceptable3.invokeInitBody(65536, newInitContext);
                                                            return;
                                                        }
                                                    }
                                                    this.this$0 = this;
                                                }

                                                @Override // com.baidu.android.imsdk.chatmessage.request.params.FetchMsgParam.FetchMsgParamConstruct
                                                public void construct(FetchMsgParam fetchMsgParam) {
                                                    Interceptable interceptable3 = $ic;
                                                    if (interceptable3 == null || interceptable3.invokeL(1048576, this, fetchMsgParam) == null) {
                                                        fetchMsgParam.setFetchTriggerReason(1);
                                                        BIMManager.fetchMsg(this.this$0.val$context, fetchMsgParam);
                                                    }
                                                }
                                            };
                                            if (this.val$contacterPauid <= 0 && this.val$contacterUserType == 0) {
                                                FetchMsgParam.newInstanceByUk(this.val$context, optLong2, optLong2, 1, this.val$category, this.val$contacterImUk, "", null, fetchMsgParamConstruct);
                                            } else {
                                                FetchMsgParam.newInstanceByPa(this.val$context, optLong2, optLong2, 1, this.val$category, this.val$contacterPauid, "", null, fetchMsgParamConstruct);
                                            }
                                        }
                                    }
                                }
                            }
                        });
                    }
                } catch (JSONException e) {
                    LogUtils.e(TAG, "handleClueMsgNotify extcption:" + e.getMessage());
                }
            } else if (optInt2 == 7) {
                try {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    int optInt3 = jSONObject2.optInt("re_msg_status");
                    String optString2 = jSONObject2.optString("re_msg_status_display_text");
                    JSONArray jSONArray = jSONObject2.getJSONArray("msgid");
                    for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                        long j2 = jSONArray.getLong(i4);
                        jSONObject2.optLong("1657773954733779");
                        TaskManager.getInstance(context).submitForNetWork(new Runnable(context, j2, optInt3, optString2) { // from class: com.baidu.android.imsdk.internal.NotifyMessageHandler.4
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ Context val$context;
                            public final /* synthetic */ String val$displayText;
                            public final /* synthetic */ int val$msgRepliedStatus;
                            public final /* synthetic */ long val$replyMsgId;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {context, Long.valueOf(j2), Integer.valueOf(optInt3), optString2};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i5 = newInitContext.flag;
                                    if ((i5 & 1) != 0) {
                                        int i6 = i5 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.val$context = context;
                                this.val$replyMsgId = j2;
                                this.val$msgRepliedStatus = optInt3;
                                this.val$displayText = optString2;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                ChatMsg updateReplyChatMsgQuoteData;
                                Interceptable interceptable2 = $ic;
                                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && (updateReplyChatMsgQuoteData = MediaChatMessageManager.getInstance(this.val$context).updateReplyChatMsgQuoteData(this.val$replyMsgId, this.val$msgRepliedStatus, this.val$displayText)) != null) {
                                    ChatMsgManagerImpl.getInstance(this.val$context).sendMsgUpdatedBroadcast(this.val$context, updateReplyChatMsgQuoteData);
                                }
                            }
                        });
                    }
                } catch (JSONException e2) {
                    LogUtils.e(TAG, "handleClueMsgNotify parse failed,", e2);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [T, java.lang.Long] */
    public static void handleConfigMessage(Context context, JSONObject jSONObject) throws JSONException {
        ArrayList<ChatMsg> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, jSONObject) == null) {
            LogUtils.i(TAG, "handleMessage Config:" + jSONObject.toString());
            JSONArray jSONArray = new JSONArray();
            try {
                JSONArray jSONArray2 = jSONObject.getJSONArray(NotificationCompat.CarExtender.KEY_MESSAGES);
                for (int i = 0; i < jSONArray2.length(); i++) {
                    jSONArray.put(jSONArray2.getJSONObject(i));
                }
            } catch (JSONException e) {
                LogUtils.e(TAG, "Exception ", e);
                arrayList = null;
            }
            if (jSONArray.length() == 0) {
                return;
            }
            Type type = new Type();
            type.t = 0L;
            arrayList = MessageParser.parserMessage(context, jSONArray, type, true, true);
            ChatMsgManagerImpl.getInstance(context).persisConfigMsgIds(arrayList);
            ChatMsgManagerImpl.getInstance(context).deliverConfigMessage(arrayList);
        }
    }

    public static void handleRtcNotifyMessage(Context context, JSONObject jSONObject) {
        String jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, context, jSONObject) == null) {
            if (jSONObject == null) {
                jSONObject2 = "msgobj == null";
            } else {
                jSONObject2 = jSONObject.toString();
            }
            handleRtcReport("notify", jSONObject2);
            if (context != null && jSONObject != null) {
                CaseUbc.DebugInfo debugInfo = new CaseUbc.DebugInfo();
                debugInfo.curClassName = "NotifyMessageHandler.handleRtcNotifyMessage";
                try {
                    LogUtils.i(TAG, "handleRtcNotifyMessage context ！= null && msgobj ！= null ");
                    Class<?> cls = Class.forName("com.baidu.android.imrtc.BIMRtcManager");
                    cls.getMethod("notifyParse", JSONObject.class).invoke(cls, jSONObject);
                    debugInfo.extInfo = jSONObject.toString();
                } catch (Throwable th) {
                    LogUtils.e(TAG, "handleRtcNotifyMessage ClassNotFoundException BIMRtcManager...", th);
                    handleRtcReport("notify", "exception :" + th.getMessage());
                    debugInfo.extInfo = "ClassNotFoundException BIMRtcManager";
                }
                a30.d().f(CaseUbc.generateUBCData(context, "-1", "", debugInfo), UBCConstants.IS_REAL, UBCConstants.IS_SAVE_DB, UBCConstants.IS_ASYNC);
                return;
            }
            LogUtils.i(TAG, "handleRtcNotifyMessage context == null || msgobj == null ");
        }
    }

    public static void handleRtcReport(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, str2) == null) {
            try {
                LogUtils.i(TAG, "handleRtcReport " + str + ", ext :" + str2);
                Class<?> cls = Class.forName("com.baidu.android.imrtc.BIMRtcManager");
                Method method = cls.getMethod("imRtcReport", String.class, String.class);
                method.invoke(cls, "im rtc_report " + str, str2);
            } catch (Throwable th) {
                LogUtils.e(TAG, "handleRtcReport ClassNotFoundException BIMRtcManager...", th);
            }
        }
    }

    public static void handleConsultMsgChanged(Context context, int i, int i2, long j, int i3, long j2, long j3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3), str}) == null) {
            ChatMsgManagerImpl.getInstance(context).handleConsultMsgNotify(i, i2, j, i3, j2, j3, str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x007f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void handleDeliverMessage(Context context, JSONObject jSONObject, String str) throws JSONException {
        long j;
        long j2;
        SyncStrategy generate;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, context, jSONObject, str) == null) {
            LogUtils.i(TAG, "handleMessage Deliver:" + jSONObject.toString());
            int i = jSONObject.getInt("category");
            if (jSONObject.has("msgid")) {
                try {
                    j = jSONObject.getLong("msgid");
                } catch (JSONException e) {
                    LogUtils.i(TAG, "JSONException:" + e.getMessage());
                }
                if (jSONObject.has(Constants.EXTRA_NOTIFY_ID)) {
                    try {
                        j2 = jSONObject.getLong(Constants.EXTRA_NOTIFY_ID);
                    } catch (JSONException e2) {
                        LogUtils.i(TAG, "notifyId JSONException:" + e2.getMessage());
                    }
                    if (i == 0 && i != 2) {
                        if (i == 1) {
                            long j3 = jSONObject.getLong("contacter");
                            long j4 = jSONObject.getLong("msgid");
                            LogUtils.i(TAG, "msgid : " + j4);
                            SyncGroupMessageService.getInstance().execute(context, i, j3, j4, 2, j, j2, str);
                            return;
                        } else if (i == 9) {
                            handleBusinessMsgNotify(context, jSONObject.getInt("business_type"), jSONObject.optInt("session_type"), jSONObject.getLong("contacter"), 2, j, j2, str);
                            return;
                        } else {
                            LogUtils.e(TAG, "handleDeliverMessage category error!!");
                            return;
                        }
                    }
                    generate = Generator.generate(context, 5);
                    if (generate != null) {
                        generate.setCategory(i);
                        generate.resetFetchState();
                        if (j != -1) {
                            generate.start(2, j, j2, str);
                            return;
                        } else {
                            generate.start(2);
                            return;
                        }
                    }
                    return;
                }
                j2 = -1;
                if (i == 0) {
                }
                generate = Generator.generate(context, 5);
                if (generate != null) {
                }
            }
            j = -1;
            if (jSONObject.has(Constants.EXTRA_NOTIFY_ID)) {
            }
            j2 = -1;
            if (i == 0) {
            }
            generate = Generator.generate(context, 5);
            if (generate != null) {
            }
        }
    }

    public static void handleMediaNotifyMessage(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, jSONObject) == null) {
            ChatMsgManagerImpl.getInstance(context).handleMediaNotifyMessage(jSONObject);
        }
    }
}
