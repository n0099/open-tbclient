package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class AudioMsg extends RichMediaMsg {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<AudioMsg> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;
    public int mDuration;
    public int mFormat;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581094228, "Lcom/baidu/android/imsdk/chatmessage/messages/AudioMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581094228, "Lcom/baidu/android/imsdk/chatmessage/messages/AudioMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<AudioMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.AudioMsg.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AudioMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new AudioMsg(parcel) : (AudioMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AudioMsg[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new AudioMsg[i2] : (AudioMsg[]) invokeI.objValue;
            }
        };
    }

    private String getAudioContent(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65541, this, str, i2, i3)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str);
                jSONObject.put("format", i2);
                jSONObject.put("duration", i3);
                return jSONObject.toString();
            } catch (JSONException e2) {
                LogUtils.e(this.TAG, "getAudioContent Json", e2);
                return "";
            }
        }
        return (String) invokeLII.objValue;
    }

    private void transCodeUrl(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, jSONObject) == null) {
            try {
                String decode = URLDecoder.decode(this.mRemoteUrl, "UTF-8");
                LogUtils.d(ChatMsg.TAG, decode);
                this.mRemoteUrl = decode;
                jSONObject.put("url", decode);
                this.mjsonContent = jSONObject.toString();
            } catch (UnsupportedEncodingException e2) {
                LogUtils.e(this.TAG, "transCodeUrl:", e2);
            } catch (JSONException e3) {
                LogUtils.e(this.TAG, "transCodeUrl:", e3);
            }
        }
    }

    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mDuration : invokeV.intValue;
    }

    public int getFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mFormat : invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "[语音]" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
                return true;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void setContent(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, str, i2, i3) == null) {
            setMsgContent(getAudioContent(str, i2, i3));
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.RichMediaMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, parcel, i2) == null) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.mFormat);
            parcel.writeInt(this.mDuration);
        }
    }

    public AudioMsg() {
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
        this.TAG = VideoMsg.class.getSimpleName();
        this.mFormat = -1;
        this.mDuration = -1;
        setMsgType(2);
    }

    public AudioMsg(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.TAG = VideoMsg.class.getSimpleName();
        this.mFormat = -1;
        this.mDuration = -1;
        setMsgType(2);
        setLocalUrl(str);
        this.mDuration = i2;
        this.mFormat = i3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioMsg(Parcel parcel) {
        super(parcel);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Parcel) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.TAG = VideoMsg.class.getSimpleName();
        this.mFormat = -1;
        this.mDuration = -1;
        this.mFormat = parcel.readInt();
        this.mDuration = parcel.readInt();
    }
}
