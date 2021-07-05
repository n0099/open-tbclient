package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class RealTimeMsg extends NormalMsg implements Parcelable, NoProGuard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mDuration;
    public boolean mSucess;

    public RealTimeMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mDuration : invokeV.intValue;
    }

    public String getRealTimeMsgJsonString(boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sucess", z);
                jSONObject.put("duration", i2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public boolean isSucess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mSucess : invokeV.booleanValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String jsonContent = getJsonContent();
            if (TextUtils.isEmpty(jsonContent)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(jsonContent);
                this.mSucess = jSONObject.optBoolean("sucess");
                this.mDuration = jSONObject.optInt("duration");
                return false;
            } catch (JSONException e2) {
                LogUtils.e(LogUtils.TAG, "parseJsonString", e2);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void setContent(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            setMsgContent(getRealTimeMsgJsonString(z, i2));
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, parcel, i2) == null) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.mSucess ? 1 : 0);
            parcel.writeInt(this.mDuration);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealTimeMsg(Parcel parcel) {
        super(parcel);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Parcel) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSucess = parcel.readInt() != 0;
        this.mDuration = parcel.readInt();
    }
}
