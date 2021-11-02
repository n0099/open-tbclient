package com.baidu.android.imsdk.request;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.IMSDK;
import com.baidu.android.imsdk.utils.BigEndianDataOutputStream;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class Message {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context context;
    public boolean isHeartbeat;
    public long mAppid;
    public String mBody;
    public boolean mIsSending;
    public String mListenerKey;
    public int mPriority;
    public int mType;
    public String mUUId;
    public long mUk;
    public long msgId;
    public boolean needReSend;
    public boolean needReplay;

    public Message() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isHeartbeat = false;
        this.mIsSending = false;
        this.needReplay = false;
        this.mBody = "";
        this.mPriority = 15;
        this.needReSend = false;
        this.mUUId = UUID.randomUUID().toString();
    }

    private void addRetryTime() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || TextUtils.isEmpty(this.mBody)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.mBody);
            if (this.context != null) {
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.context));
            }
            if (TextUtils.isEmpty(jSONObject.optString("rpc"))) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("rpc_retry_time", 0);
                jSONObject.put("rpc", jSONObject2.toString());
                this.mBody = jSONObject.toString();
            }
        } catch (JSONException e2) {
            LogUtils.e("Message", "getBody :", e2);
        }
    }

    public static Message parseBody(Context context, String str, String str2, String str3) throws Exception {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, context, str, str2, str3)) == null) {
            return null;
        }
        return (Message) invokeLLLL.objValue;
    }

    public static void saveCmdMessage(Context context, Message message, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65539, null, context, message, str, i2) == null) {
            DBManager.getInstance(context).saveCmdMsg(message.getUUID(), message.getType(), message.getBody(), str, i2, 0);
        }
    }

    public abstract void buildBody();

    public long getAppid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAppid : invokeV.longValue;
    }

    public String getBody() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            buildBody();
            if (this.mIsSending) {
                addRetryTime();
            }
            return this.mBody;
        }
        return (String) invokeV.objValue;
    }

    public String getListenerKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mListenerKey : (String) invokeV.objValue;
    }

    public byte[] getMessageBytes() {
        InterceptResult invokeV;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            buildBody();
            addRetryTime();
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (IOException unused) {
                byteArrayOutputStream = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                BigEndianDataOutputStream bigEndianDataOutputStream = new BigEndianDataOutputStream(byteArrayOutputStream);
                if (!this.isHeartbeat) {
                    bigEndianDataOutputStream.writeByte((byte) 2);
                    bigEndianDataOutputStream.writeByte((byte) 1);
                    bigEndianDataOutputStream.writeInt(this.mBody.getBytes().length);
                    bigEndianDataOutputStream.writeLong(this.msgId);
                    if (this.mBody.length() != 0) {
                        bigEndianDataOutputStream.write(this.mBody.getBytes());
                    }
                } else {
                    bigEndianDataOutputStream.writeByte((byte) 2);
                    bigEndianDataOutputStream.writeByte(Constants.SHORT_PING_CMD_TYPE);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    LogUtils.e("Message", "baos.close", e2);
                }
                return byteArray;
            } catch (IOException unused2) {
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e3) {
                        LogUtils.e("Message", "baos.close", e3);
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (IOException e4) {
                        LogUtils.e("Message", "baos.close", e4);
                    }
                }
                throw th;
            }
        }
        return (byte[]) invokeV.objValue;
    }

    public long getMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.msgId : invokeV.longValue;
    }

    public int getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mPriority : invokeV.intValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mType : invokeV.intValue;
    }

    public String getUUID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mUUId : (String) invokeV.objValue;
    }

    public long getUk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mUk : invokeV.longValue;
    }

    public void handleMessageResult(Context context, JSONObject jSONObject, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048586, this, context, jSONObject, i2, str) == null) {
            if (i2 == 4001 || i2 == 4003 || i2 == 4004 || i2 == 4005) {
                LoginManager.getInstance(context).triggleLogoutListener(i2, str);
            }
        }
    }

    public void initCommonParameter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            this.context = context;
            setUk(IMSDK.getInstance(context).getUk());
            setAppid(AccountManager.getAppid(context));
        }
    }

    public boolean isHeartbeat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.isHeartbeat : invokeV.booleanValue;
    }

    public boolean isNeedReSend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.needReSend : invokeV.booleanValue;
    }

    public boolean isNeedReplay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.needReplay : invokeV.booleanValue;
    }

    public void isSending(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.mIsSending = z;
        }
    }

    public void onMsgSending(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, context) == null) {
        }
    }

    public void setAppid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048593, this, j) == null) {
            this.mAppid = j;
        }
    }

    public void setHeartbeat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.isHeartbeat = z;
        }
    }

    public void setListenerKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.mListenerKey = str;
        }
    }

    public void setMsgId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j) == null) {
            this.msgId = j;
        }
    }

    public void setNeedReSend(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.needReSend = z;
        }
    }

    public void setNeedReplay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.needReplay = z;
        }
    }

    public void setSendingState(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, context) == null) {
            DBManager.getInstance(context).updateCmdMsgSendStatus(getUUID(), 2);
        }
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.mType = i2;
        }
    }

    public void setUUID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.mUUId = str;
        }
    }

    public void setUk(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048602, this, j) == null) {
            this.mUk = j;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            buildBody();
            if (this.mIsSending) {
                addRetryTime();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("MsgId: ");
            sb.append(this.msgId);
            sb.append(" body: ");
            sb.append(this.isHeartbeat ? "heartbeat" : this.mBody);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
