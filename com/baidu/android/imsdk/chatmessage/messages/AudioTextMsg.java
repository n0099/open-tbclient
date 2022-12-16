package com.baidu.android.imsdk.chatmessage.messages;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AudioTextMsg extends AudioMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AudioTextMsg";
    public transient /* synthetic */ FieldHolder $fh;
    public String mText;

    public AudioTextMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mText = "";
        setMsgType(82);
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mText;
        }
        return (String) invokeV.objValue;
    }

    public AudioTextMsg(String str, int i, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mText = "";
        setMsgType(82);
        setLocalUrl(str);
        this.mDuration = i2;
        this.mFormat = i;
        this.mText = str2;
    }

    public String getAudioContent(String str, int i, int i2, String str2) {
        InterceptResult invokeCommon;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2})) == null) {
            String audioContent = super.getAudioContent(str, i, i2);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject = new JSONObject(audioContent);
                try {
                    jSONObject.put("text", str2);
                } catch (JSONException e) {
                    e = e;
                    jSONObject2 = jSONObject;
                    LogUtils.e(TAG, "getAudioContent", e);
                    jSONObject = jSONObject2;
                    return jSONObject.toString();
                }
            } catch (JSONException e2) {
                e = e2;
            }
            return jSONObject.toString();
        }
        return (String) invokeCommon.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.AudioMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (TextUtils.isEmpty(this.mjsonContent)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(this.mjsonContent);
                this.mRemoteUrl = jSONObject.optString("url");
                this.mFormat = jSONObject.optInt("format");
                this.mDuration = jSONObject.optInt("duration");
                if (this.mRemoteUrl.regionMatches(0, "http%3A", 0, 7)) {
                    transCodeUrl(jSONObject);
                }
                this.mText = jSONObject.optString("text");
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void setContent(String str, int i, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2}) == null) {
            this.mText = str2;
            setMsgContent(getAudioContent(str, i, i2, str2));
        }
    }
}
