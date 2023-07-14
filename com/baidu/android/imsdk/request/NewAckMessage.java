package com.baidu.android.imsdk.request;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.ubc.MessageUbc;
import com.baidu.android.imsdk.ubc.UBCConstants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.tieba.l80;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class NewAckMessage extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "NewAckMessage";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public MessageUbc.DebugInfo mDebugInfo;
    public boolean mIsReliable;
    public JSONArray mJsonArray;
    public long mTriggerId;
    public MessageUbc mUbcData;
    public List<Tripule> tripules;

    /* loaded from: classes.dex */
    public static class Tripule {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String accountType;
        public long businesType;
        public long contacter;
        public int contentType;
        public String eventList;
        public long groupId;
        public String interActiveAction;
        public int interActiveSource;
        public int isParseFailed;
        public boolean isReliable;
        public int mCategory;
        public String mFromSelf;
        public String mFromType;
        public String mToType;
        public long mcastId;
        public long msgReceiveTime;
        public long msgid;
        public String msgkey;
        public long notifyId;
        public long notifyMsgId;
        public String originPa;
        public String osName;
        public int sdkVersion;
        public int sendScene;
        public int sendType;
        public int templateType;
        public int templateVersion;
        public long topicId;
        public String topicSource;
        public long ukFromUser;
        public long ukToUser;

        public Tripule(long j, String str, long j2, long j3, int i, String str2, long j4, long j5, int i2, int i3, long j6, long j7, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), str, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i), str2, Long.valueOf(j4), Long.valueOf(j5), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j6), Long.valueOf(j7), str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.isReliable = false;
            this.templateVersion = -1;
            this.templateType = 0;
            this.sdkVersion = 0;
            this.interActiveSource = -1;
            this.isParseFailed = 0;
            this.groupId = 0L;
            this.msgid = j;
            this.msgkey = str;
            this.msgReceiveTime = j2;
            this.contacter = j3;
            this.osName = "android";
            this.contentType = i;
            this.accountType = str2;
            this.ukFromUser = j4;
            this.ukToUser = j5;
            this.businesType = i2;
            this.mCategory = i3;
            this.notifyMsgId = j6;
            this.notifyId = j7;
            this.eventList = str3;
        }

        public void setChatMsg(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.mCategory = i;
            }
        }

        public void setFromSelf(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.mFromSelf = str;
            }
        }

        public void setFromType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.mFromType = str;
            }
        }

        public void setGroupId(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
                this.groupId = j;
            }
        }

        public void setInterActiveAction(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.interActiveAction = str;
            }
        }

        public void setInterActiveSource(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
                this.interActiveSource = i;
            }
        }

        public void setIsParseFailed(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
                this.isParseFailed = i;
            }
        }

        public void setMcastId(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
                this.mcastId = j;
            }
        }

        public void setOriginPa(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
                this.originPa = str;
            }
        }

        public void setSdkVersion(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
                this.sdkVersion = i;
            }
        }

        public void setSendScene(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
                this.sendScene = i;
            }
        }

        public void setSendType(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
                this.sendType = i;
            }
        }

        public void setStudioIsReliable(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
                this.isReliable = z;
            }
        }

        public void setTemplateType(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
                this.templateType = i;
            }
        }

        public void setTemplateVersion(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
                this.templateVersion = i;
            }
        }

        public void setToType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
                this.mToType = str;
            }
        }

        public void setTopicId(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
                this.topicId = j;
            }
        }

        public void setTopicSource(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
                this.topicSource = str;
            }
        }

        public int getCategory() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mCategory;
            }
            return invokeV.intValue;
        }

        public String getEventList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.eventList;
            }
            return (String) invokeV.objValue;
        }

        public JSONObject toJsonObject() {
            InterceptResult invokeV;
            JSONArray jSONArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("from_user", this.ukFromUser);
                    jSONObject.put("msgid", this.msgid);
                    jSONObject.put("msg_key", this.msgkey);
                    jSONObject.put("time", this.msgReceiveTime);
                    jSONObject.put("contacter", this.contacter);
                    jSONObject.put("os_name", this.osName);
                    jSONObject.put("content_type", this.contentType);
                    jSONObject.put("account_type", this.accountType);
                    jSONObject.put("time", this.msgReceiveTime);
                    jSONObject.put("uk", this.ukFromUser);
                    jSONObject.put("to_uk", this.ukToUser);
                    jSONObject.put("category", this.mCategory);
                    jSONObject.put("business_type", this.businesType);
                    if (this.mcastId > 0) {
                        jSONObject.put("mcast_id", this.mcastId);
                    }
                    if (this.sendScene > 0) {
                        jSONObject.put("send_scene", this.sendScene);
                    }
                    if (this.sendType > 0) {
                        jSONObject.put("send_type", this.sendType);
                    }
                    if (this.interActiveSource > -1) {
                        jSONObject.put(IMConstants.MSG_CONTENT_EXT_SOURCE, this.interActiveSource);
                    }
                    if (!TextUtils.isEmpty(this.interActiveAction)) {
                        jSONObject.put(IMConstants.MSG_CONTENT_EXT_ACTION, this.interActiveAction);
                    }
                    if (this.isReliable) {
                        jSONObject.put("is_reliable", this.isReliable);
                    }
                    if (this.groupId > 0) {
                        jSONObject.put("group_id", this.groupId);
                    }
                    if (this.mCategory == 0 && this.businesType != 27) {
                        jSONObject.put("from_type", this.mFromType);
                        jSONObject.put("to_type", this.mToType);
                        jSONObject.put("from_self", this.mFromSelf);
                    }
                    try {
                        if (this.notifyMsgId <= this.msgid && this.notifyId > 0) {
                            jSONObject.put(Constants.EXTRA_NOTIFY_ID, this.notifyId);
                        }
                        if (!TextUtils.isEmpty(this.eventList)) {
                            jSONArray = new JSONObject(this.eventList).optJSONArray("event_list");
                        } else {
                            jSONArray = null;
                        }
                        if (jSONArray == null) {
                            jSONArray = new JSONArray();
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("event", "CSaveT");
                        jSONObject2.put("timestamp_ms", System.currentTimeMillis());
                        jSONArray.put(jSONObject2);
                        jSONObject.put("event_list", jSONArray);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("event_list", jSONArray);
                        this.eventList = jSONObject3.toString();
                    } catch (JSONException e) {
                        LogUtils.e(NewAckMessage.TAG, "toJsonObject exception :", e);
                    }
                    if (!TextUtils.isEmpty(this.topicSource)) {
                        jSONObject.put(IMConstants.MSG_TOPIC_SOURCE, this.topicSource);
                    }
                    if (this.topicId > 0) {
                        jSONObject.put("topic_id", this.topicId);
                    }
                    jSONObject.put("origin_pa", this.originPa);
                    if (this.templateVersion >= 0) {
                        jSONObject.put("template_version", this.templateVersion);
                    }
                    if (this.templateType >= 0) {
                        jSONObject.put("template_type", this.templateType);
                    }
                    if (this.sdkVersion >= 0) {
                        jSONObject.put("sdk_version", this.sdkVersion);
                    }
                    if (this.isParseFailed > 0) {
                        jSONObject.put("is_client_parse_msg_fail", this.isParseFailed);
                        return jSONObject;
                    }
                    return jSONObject;
                } catch (JSONException e2) {
                    LogUtils.e(LogUtils.TAG, "toJsonObject event_list", e2);
                    return null;
                }
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    public NewAckMessage(Context context, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsonArray = null;
        this.mIsReliable = false;
        this.mContext = null;
        this.mDebugInfo = new MessageUbc.DebugInfo();
        initCommonParameter(context);
        this.mUk = j;
        this.mTriggerId = j2;
        this.mContext = context;
        this.tripules = new LinkedList();
        setNeedReplay(true);
        setType(95);
        this.mPriority = 16;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewAckMessage(Context context, long j, long j2, boolean z) {
        this(context, j, j2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r8;
            Object[] objArr = {context, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIsReliable = z;
    }

    public void addTriples(List<Tripule> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.tripules.addAll(list);
            toJsonArray(list);
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void onMsgSending(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            setSendingState(context);
        }
    }

    public void setJsonArray(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONArray) == null) {
            this.mJsonArray = jSONArray;
        }
    }

    public static NewAckMessage parseBody(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, str2, str3)) == null) {
            NewAckMessage newAckMessage = null;
            try {
                JSONObject jSONObject = new JSONObject(str2);
                long optLong = jSONObject.optLong(Constants.KEY_TRIGGER_ID, 0L);
                long optLong2 = jSONObject.optLong("uk", 0L);
                JSONArray optJSONArray = jSONObject.optJSONArray("msgs");
                NewAckMessage newAckMessage2 = new NewAckMessage(context, optLong2, optLong);
                try {
                    newAckMessage2.setUUID(str);
                    newAckMessage2.setJsonArray(optJSONArray);
                    return newAckMessage2;
                } catch (Exception e) {
                    e = e;
                    newAckMessage = newAckMessage2;
                    LogUtils.e(TAG, "parseBody :", e);
                    return newAckMessage;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            return (NewAckMessage) invokeLLLL.objValue;
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048579, this, context, jSONObject, i, str) == null) {
            super.handleMessageResult(context, jSONObject, i, str);
            if (i == 0) {
                AckHandlerThread.getInstance(context).mRetryCount.set(0);
                TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable(this) { // from class: com.baidu.android.imsdk.request.NewAckMessage.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ NewAckMessage this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        int i2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("delete uuid :");
                            sb.append(this.this$0.getUUID());
                            sb.append(", ack msgSize :");
                            if (this.this$0.tripules != null) {
                                i2 = this.this$0.tripules.size();
                            } else {
                                i2 = 0;
                            }
                            sb.append(i2);
                            LogUtils.w(NewAckMessage.TAG, sb.toString());
                            DBManager.getInstance(this.this$0.mContext).deleteCmdMsg(this.this$0.getUUID());
                        }
                    }
                });
                return;
            }
            try {
                l80.d().f(this.mUbcData.generateUBCData(String.valueOf(i), str), UBCConstants.IS_REAL, UBCConstants.IS_SAVE_DB, UBCConstants.IS_ASYNC);
            } catch (Throwable th) {
                LogUtils.e(TAG, "upload ackMsg :", th);
            }
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            TextMsg textMsg = new TextMsg();
            try {
                jSONObject.put("method", 95);
                jSONObject.put(Constants.KEY_TRIGGER_ID, this.mTriggerId);
                if (this.mUk <= 0) {
                    this.mUk = AccountManager.getUK(this.mContext);
                    textMsg.setSenderUid("" + this.mUk);
                    textMsg.setStatus(AccountManager.getLoginState(this.mContext));
                }
                jSONObject.put("uk", this.mUk);
                if (this.mAppid <= 0) {
                    this.mAppid = AccountManager.getAppid(this.mContext);
                }
                jSONObject.put("appid", this.mAppid);
                jSONObject.put("device_id", Utility.getIMDeviceId(this.mContext));
                jSONObject.put("msgs", this.mJsonArray);
                try {
                    JSONArray jSONArray = new JSONArray();
                    jSONObject2.put("event", "CIMAckBegin");
                    jSONObject2.put("timestamp_ms", System.currentTimeMillis());
                    jSONArray.put(jSONObject2);
                    jSONObject.put("event_list", jSONArray);
                } catch (JSONException e) {
                    LogUtils.i(TAG, "buildBody ackJson JSONException:" + e.getMessage());
                }
                String jSONObject3 = jSONObject.toString();
                this.mBody = jSONObject3;
                textMsg.setMsgContent(jSONObject3);
                LogUtils.d(TAG, "buildBody :" + this.mBody);
            } catch (Throwable th) {
                LogUtils.e(TAG, "buildBody", th);
                textMsg.setMsgContent("build body crash");
            }
            try {
                textMsg.setFromUser(this.mUk);
                textMsg.setTriggerReasonn(this.mTriggerId);
                this.mUbcData = new MessageUbc(this.mContext, textMsg);
                this.mDebugInfo.methodId = 95L;
                if (this.tripules != null && this.tripules.size() > 0) {
                    this.mDebugInfo.msgId = this.tripules.get(0).msgid;
                    this.mDebugInfo.msgSize = this.tripules.size();
                    this.mDebugInfo.notifyId = this.tripules.get(0).notifyId;
                    this.mDebugInfo.eventList = this.tripules.get(0).getEventList();
                    JSONObject jSONObject4 = new JSONObject();
                    try {
                        JSONArray optJSONArray = new JSONObject(this.tripules.get(0).getEventList()).optJSONArray("event_list");
                        if (optJSONArray == null) {
                            optJSONArray = new JSONArray();
                        }
                        optJSONArray.put(jSONObject2);
                        jSONObject4.put("event_list", optJSONArray);
                    } catch (JSONException e2) {
                        LogUtils.i(TAG, "buildBody JSONException:" + e2.getMessage());
                    }
                    this.mDebugInfo.eventList = jSONObject4.toString();
                    this.mDebugInfo.ackMsgs.clear();
                    for (Tripule tripule : this.tripules) {
                        this.mDebugInfo.ackMsgs.add(String.valueOf(tripule.msgid));
                    }
                }
                this.mUbcData.setDebugInfo(this.mDebugInfo);
            } catch (Exception e3) {
                LogUtils.e(TAG, "mDebugInfo", e3);
            }
        }
    }

    public JSONArray getJsonArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mJsonArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public void toJsonArray(List<Tripule> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, list) == null) && list != null && list.size() != 0) {
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            for (Tripule tripule : list) {
                JSONObject jsonObject = tripule.toJsonObject();
                if (jsonObject != null) {
                    jSONArray.put(jsonObject);
                }
                i = tripule.mCategory;
            }
            this.mJsonArray = jSONArray;
            if (jSONArray.length() != 0 && !this.mIsReliable && i != 4) {
                TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable(this) { // from class: com.baidu.android.imsdk.request.NewAckMessage.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ NewAckMessage this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                            return;
                        }
                        Context context = this.this$0.mContext;
                        NewAckMessage newAckMessage = this.this$0;
                        Message.saveCmdMessage(context, newAckMessage, null, newAckMessage.mPriority);
                        LogUtils.w(NewAckMessage.TAG, "saveCmdMessage msg :" + this.this$0.mBody + "， uuid :" + this.this$0.getUUID());
                    }
                });
            }
        }
    }
}
