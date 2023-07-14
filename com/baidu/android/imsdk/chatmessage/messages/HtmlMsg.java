package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMConstants;
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
public class HtmlMsg extends NormalMsg implements IReplyMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<HtmlMsg> CREATOR;
    public static final String TAG = "HtmlMsg";
    public transient /* synthetic */ FieldHolder $fh;
    public String mDesc;
    public String mHtml;
    public MsgRepliedData replyMsgData;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(645130529, "Lcom/baidu/android/imsdk/chatmessage/messages/HtmlMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(645130529, "Lcom/baidu/android/imsdk/chatmessage/messages/HtmlMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<HtmlMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.HtmlMsg.1
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
            public HtmlMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new HtmlMsg(parcel);
                }
                return (HtmlMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public HtmlMsg[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new HtmlMsg[i];
                }
                return (HtmlMsg[]) invokeI.objValue;
            }
        };
    }

    public HtmlMsg() {
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
        this.mDesc = "[新消息]";
        setMsgType(18);
    }

    public String getDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mDesc;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mDesc;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.IReplyMsg
    public MsgRepliedData getReplyMsgData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.replyMsgData;
        }
        return (MsgRepliedData) invokeV.objValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mHtml;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.IReplyMsg
    public boolean isReplyMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            MsgRepliedData msgRepliedData = this.replyMsgData;
            if (msgRepliedData != null && msgRepliedData.isReplyMsg()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HtmlMsg(Parcel parcel) {
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
        this.mDesc = "[新消息]";
        this.mHtml = parcel.readString();
        this.mDesc = parcel.readString();
        this.replyMsgData = (MsgRepliedData) parcel.readParcelable(MsgRepliedData.class.getClassLoader());
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, parcel, i) == null) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.mHtml);
            parcel.writeString(this.mDesc);
            parcel.writeParcelable(this.replyMsgData, i);
        }
    }

    public HtmlMsg(String str) {
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
        this.mDesc = "[新消息]";
        setMsgType(18);
        this.mHtml = str;
        setText(str);
    }

    private String getTextJson(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(IMConstants.IM_RECEIVE_SERVER_COMMON_TYPE_HTML, str);
            } catch (JSONException e) {
                LogUtils.e(LogUtils.TAG, "getTextJson", e);
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public void setDesc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.mDesc = str;
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            setMsgContent(getTextJson(str));
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String jsonContent = getJsonContent();
            if (!TextUtils.isEmpty(jsonContent)) {
                try {
                    JSONObject jSONObject = new JSONObject(jsonContent);
                    this.mHtml = jSONObject.optString(IMConstants.IM_RECEIVE_SERVER_COMMON_TYPE_HTML);
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
