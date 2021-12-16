package com.baidu.android.imsdk.request;

import android.content.Context;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
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
/* loaded from: classes9.dex */
public class NewAckMessage extends Message {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public JSONArray mJsonArray;
    public long mTriggerId;
    public List<Tripule> tripules;

    /* loaded from: classes9.dex */
    public static class Tripule {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String accountType;
        public String businessSource;
        public int contentType;
        public long fromUser;
        public boolean isReliable;
        public JSONObject jack;
        public long mcastId;
        public String msgCategory;
        public String msgPage;
        public long msgReceiveTime;
        public long msgid;
        public String msgkey;
        public String osName;
        public int paClassType;
        public long paId;
        public int paType;
        public int subPaType;
        public String thirdId;
        public long ukFromUser;
        public long ukToUser;

        public Tripule(long j2, String str, long j3, String str2, int i2, String str3, long j4, long j5, long j6, int i3, int i4, int i5, String str4, String str5, String str6) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), str, Long.valueOf(j3), str2, Integer.valueOf(i2), str3, Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str4, str5, str6};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.jack = null;
            this.isReliable = false;
            this.msgid = j2;
            this.msgkey = str;
            this.msgReceiveTime = j3;
            this.msgPage = str2;
            this.osName = "android";
            this.contentType = i2;
            this.accountType = str3;
            this.ukFromUser = j4;
            this.ukToUser = j5;
            this.paId = j6;
            this.paType = i3;
            this.subPaType = i4;
            this.paClassType = i5;
            this.msgCategory = str4;
            this.businessSource = str5;
            this.thirdId = str6;
        }

        public void setAck(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.jack = jSONObject;
            }
        }

        public void setFromUser(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                this.fromUser = j2;
            }
        }

        public void setMcastId(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
                this.mcastId = j2;
            }
        }

        public void setStudioIsReliable(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.isReliable = z;
            }
        }

        public JSONObject toJsonObject() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("from_user", this.fromUser);
                    jSONObject.put("msgid", this.msgid);
                    jSONObject.put("msg_key", this.msgkey);
                    jSONObject.put("time", this.msgReceiveTime);
                    jSONObject.put("page", this.msgPage);
                    jSONObject.put("os_name", this.osName);
                    jSONObject.put("content_type", this.contentType);
                    jSONObject.put("account_type", this.accountType);
                    jSONObject.put("time", this.msgReceiveTime);
                    jSONObject.put("uk", this.ukFromUser);
                    jSONObject.put("to_uk", this.ukToUser);
                    if ((this.paId & Constants.PAFLAG) != 0) {
                        jSONObject.put("paid", this.paId);
                        jSONObject.put("pa_type", this.paType);
                        jSONObject.put("sub_pa_type", this.subPaType);
                        jSONObject.put("pa_class_type", this.paClassType);
                        jSONObject.put("msg_category", this.msgCategory);
                        jSONObject.put("business_source", this.businessSource);
                        jSONObject.put("third_id", this.thirdId);
                    }
                    if (this.jack != null) {
                        jSONObject.put(IMTrackDatabase.AckEnum.TABLE_NAME, this.jack);
                    }
                    if (this.mcastId > 0) {
                        jSONObject.put("mcast_id", this.mcastId);
                    }
                    if (this.isReliable) {
                        jSONObject.put("is_reliable", this.isReliable);
                        return jSONObject;
                    }
                    return jSONObject;
                } catch (JSONException e2) {
                    LogUtils.e(LogUtils.TAG, "toJsonObject", e2);
                    return null;
                }
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    public NewAckMessage(Context context, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsonArray = null;
        this.mContext = null;
        initCommonParameter(context);
        this.mUk = j2;
        this.mTriggerId = j3;
        this.mContext = context;
        this.tripules = new LinkedList();
        setNeedReplay(true);
        setType(95);
        this.mPriority = 16;
    }

    public static NewAckMessage parseBody(Context context, String str, String str2, String str3) throws Exception {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, context, str, str2, str3)) == null) {
            JSONObject jSONObject = new JSONObject(str2);
            long optLong = jSONObject.optLong(Constants.KEY_TRIGGER_ID, 0L);
            long optLong2 = jSONObject.optLong("uk", 0L);
            JSONArray optJSONArray = jSONObject.optJSONArray("msgs");
            NewAckMessage newAckMessage = new NewAckMessage(context, optLong2, optLong);
            newAckMessage.setUUID(str);
            newAckMessage.setJsonArray(optJSONArray);
            return newAckMessage;
        }
        return (NewAckMessage) invokeLLLL.objValue;
    }

    public boolean addTriples(List<Tripule> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            this.tripules.addAll(list);
            return toJsonArray(list);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", 95);
                jSONObject.put(Constants.KEY_TRIGGER_ID, this.mTriggerId);
                jSONObject.put("uk", this.mUk);
                if (this.mAppid <= 0) {
                    this.mAppid = AccountManager.getAppid(this.mContext);
                }
                jSONObject.put("appid", this.mAppid);
                jSONObject.put("device_id", Utility.getIMDeviceId(this.mContext));
                jSONObject.put("msgs", this.mJsonArray);
                this.mBody = jSONObject.toString();
            } catch (JSONException e2) {
                LogUtils.e(LogUtils.TAG, "buildBody", e2);
            }
        }
    }

    public JSONArray getJsonArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mJsonArray : (JSONArray) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048579, this, context, jSONObject, i2, str) == null) {
            super.handleMessageResult(context, jSONObject, i2, str);
            if (i2 == 0) {
                DBManager.getInstance(context).deleteCmdMsg(getUUID());
                AckHandlerThread.getInstance(context).mRetryCount.set(0);
            }
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

    public boolean toJsonArray(List<Tripule> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            if (list == null || list.size() == 0) {
                return false;
            }
            JSONArray jSONArray = new JSONArray();
            for (Tripule tripule : list) {
                JSONObject jsonObject = tripule.toJsonObject();
                if (jsonObject != null) {
                    jSONArray.put(jsonObject);
                }
            }
            this.mJsonArray = jSONArray;
            return jSONArray.length() != 0;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewAckMessage(Context context, long j2, long j3, boolean z) {
        this(context, j2, j3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r8;
            Object[] objArr = {context, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (z) {
            return;
        }
        Message.saveCmdMessage(context, this, null, this.mPriority);
    }
}
