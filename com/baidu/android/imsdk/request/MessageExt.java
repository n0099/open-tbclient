package com.baidu.android.imsdk.request;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MessageExt {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Long DEFAULT;
    public static final String KEY_CAST_ID = "cast_id";
    public static final String KEY_LAST_CALLBACK_MSG_ID = "last_callback_msg_id";
    public static final String KEY_LATEST_MSG_ID = "latest_msg_id";
    public static final String KEY_TS = "local_ts";
    public static MessageExt mInstance;
    public static Object mSyncLock;
    public transient /* synthetic */ FieldHolder $fh;
    public Long castId;
    public Long dBLatestMsgId;
    public Long lastCallbackMsgId;
    public Long localTimestamp;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-794566822, "Lcom/baidu/android/imsdk/request/MessageExt;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-794566822, "Lcom/baidu/android/imsdk/request/MessageExt;");
                return;
            }
        }
        DEFAULT = 0L;
        mSyncLock = new Object();
        mInstance = null;
    }

    public MessageExt() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Long l = DEFAULT;
        this.lastCallbackMsgId = l;
        this.castId = l;
        this.localTimestamp = l;
        this.dBLatestMsgId = l;
    }

    public static MessageExt getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (mSyncLock) {
                if (mInstance == null) {
                    mInstance = new MessageExt();
                }
            }
            return mInstance;
        }
        return (MessageExt) invokeV.objValue;
    }

    public void setCastId(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, l) == null) {
            this.castId = l;
        }
    }

    public void setLastCallbackMsgId(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l) == null) {
            this.lastCallbackMsgId = l;
        }
    }

    public void setLocalTimestamp(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l) == null) {
            this.localTimestamp = l;
        }
    }

    public void setdBLatestMsgId(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, l) == null) {
            this.dBLatestMsgId = l;
        }
    }

    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(KEY_LAST_CALLBACK_MSG_ID, this.lastCallbackMsgId);
                jSONObject.put(KEY_CAST_ID, this.castId);
                jSONObject.put(KEY_TS, this.localTimestamp);
                jSONObject.put(KEY_LATEST_MSG_ID, this.dBLatestMsgId);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
