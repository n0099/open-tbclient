package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.IReplyMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TextMsg extends NormalMsg implements IReplyMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<TextMsg> CREATOR;
    public static final String TAG = "TextMsg";
    public transient /* synthetic */ FieldHolder $fh;
    public String advisoryEncodeAid;
    public String advisoryExtraAnswerContent;
    public String advisoryExtraContent;
    public AdvisoryMsgBusinessExtra advisoryMsgBusinessExtra;
    public long castId;
    public long priority;
    public MsgRepliedData replyMsgData;
    public String text;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-21326429, "Lcom/baidu/android/imsdk/chatmessage/messages/TextMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-21326429, "Lcom/baidu/android/imsdk/chatmessage/messages/TextMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<TextMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.TextMsg.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TextMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new TextMsg(parcel);
                }
                return (TextMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TextMsg[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new TextMsg[i];
                }
                return (TextMsg[]) invokeI.objValue;
            }
        };
    }

    public TextMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.advisoryExtraContent = "";
        this.advisoryExtraAnswerContent = "";
        this.advisoryEncodeAid = "";
        setMsgType(0);
    }

    public AdvisoryMsgBusinessExtra getAdvisoryBusinessExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.advisoryMsgBusinessExtra;
        }
        return (AdvisoryMsgBusinessExtra) invokeV.objValue;
    }

    public String getAdvisoryEncodeAid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.advisoryEncodeAid;
        }
        return (String) invokeV.objValue;
    }

    public String getAdvisoryExtraAnswerContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.advisoryExtraAnswerContent;
        }
        return (String) invokeV.objValue;
    }

    public String getAdvisoryExtraContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.advisoryExtraContent;
        }
        return (String) invokeV.objValue;
    }

    public long getCastId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.castId;
        }
        return invokeV.longValue;
    }

    public long getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.priority;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return getText();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.IReplyMsg
    public MsgRepliedData getReplyMsgData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.replyMsgData;
        }
        return (MsgRepliedData) invokeV.objValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.text;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.IReplyMsg
    public boolean isReplyMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            MsgRepliedData msgRepliedData = this.replyMsgData;
            if (msgRepliedData != null && msgRepliedData.isReplyMsg()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextMsg(Parcel parcel) {
        super(parcel);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Parcel) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.advisoryExtraContent = "";
        this.advisoryExtraAnswerContent = "";
        this.advisoryEncodeAid = "";
        this.text = parcel.readString();
        this.castId = parcel.readLong();
        this.priority = parcel.readLong();
        this.replyMsgData = (MsgRepliedData) parcel.readParcelable(MsgRepliedData.class.getClassLoader());
    }

    public String getTextJson(String str, MsgRepliedData msgRepliedData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, msgRepliedData)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("text", str);
                if (msgRepliedData != null) {
                    msgRepliedData.appendMsgRepliedDataToMsgJson(jSONObject);
                }
            } catch (JSONException e) {
                LogUtils.e(LogUtils.TAG, "getTextJson", e);
            }
            return jSONObject.toString();
        }
        return (String) invokeLL.objValue;
    }

    public void setText(String str, MsgRepliedData msgRepliedData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, msgRepliedData) == null) {
            setMsgContent(getTextJson(str, msgRepliedData));
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, parcel, i) == null) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.text);
            parcel.writeLong(this.castId);
            parcel.writeLong(this.priority);
            parcel.writeParcelable(this.replyMsgData, i);
        }
    }

    public TextMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.advisoryExtraContent = "";
        this.advisoryExtraAnswerContent = "";
        this.advisoryEncodeAid = "";
        setMsgType(0);
        this.text = str;
        setText(str);
    }

    public String getTextJson(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            return getTextJson(str, null);
        }
        return (String) invokeL.objValue;
    }

    public void setCastId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
            this.castId = j;
        }
    }

    public void setPriority(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            this.priority = j;
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            setText(str, null);
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            String jsonContent = getJsonContent();
            if (!TextUtils.isEmpty(jsonContent)) {
                try {
                    JSONObject jSONObject = new JSONObject(jsonContent);
                    this.text = jSONObject.optString("text");
                    String optString = jSONObject.optString("business_ext");
                    if (!TextUtils.isEmpty(optString)) {
                        JSONObject jSONObject2 = new JSONObject(optString);
                        this.advisoryExtraContent = jSONObject2.optString("extraContent");
                        this.advisoryExtraAnswerContent = jSONObject2.optString("extraAnswerContent");
                        this.advisoryEncodeAid = jSONObject2.optString("encodeAid");
                    }
                    this.advisoryMsgBusinessExtra = AdvisoryMsgBusinessExtra.parseAdvisoryExtra(optString);
                    MsgRepliedData msgRepliedData = new MsgRepliedData(jSONObject);
                    this.replyMsgData = msgRepliedData;
                    return msgRepliedData.parseCorrect();
                } catch (JSONException e) {
                    LogUtils.e(TAG, "parse json err!", e);
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
