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
public class AdvisoryTextMsg extends TextMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AdvisoryTextMsg";
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean ignoreKeyWord;
    public final boolean isRevisitReply;
    public final boolean isToolsReply;
    public String mAdvisoryMsgControl;
    public String mAdvisoryMsgDescription;

    public AdvisoryTextMsg(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isToolsReply = z;
        this.isRevisitReply = z2;
        this.ignoreKeyWord = z3;
    }

    public static boolean isRevisitReply(TextMsg textMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, textMsg)) == null) {
            String jsonContent = textMsg.getJsonContent();
            if (TextUtils.isEmpty(jsonContent)) {
                return false;
            }
            try {
                String optString = new JSONObject(jsonContent).optString("business_ext");
                if (TextUtils.isEmpty(optString)) {
                    return false;
                }
                if (new JSONObject(optString).optInt("revisitReply") != 1) {
                    return false;
                }
                return true;
            } catch (JSONException e) {
                LogUtils.d(TAG, e.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isToolsReply(TextMsg textMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, textMsg)) == null) {
            String jsonContent = textMsg.getJsonContent();
            if (TextUtils.isEmpty(jsonContent)) {
                return false;
            }
            try {
                String optString = new JSONObject(jsonContent).optString("business_ext");
                if (TextUtils.isEmpty(optString)) {
                    return false;
                }
                if (new JSONObject(optString).optInt("toolsReply") != 1) {
                    return false;
                }
                return true;
            } catch (JSONException e) {
                LogUtils.d(TAG, e.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.TextMsg
    public String getTextJson(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String textJson = super.getTextJson(str);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject = new JSONObject(textJson);
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    if (this.isToolsReply) {
                        jSONObject3.put("toolsReply", 1);
                    }
                    if (this.isRevisitReply) {
                        jSONObject3.put("revisitReply", 1);
                    }
                    if (this.ignoreKeyWord) {
                        jSONObject3.put("ignoreKeyWord", 1);
                    }
                    AdvisoryMsgBusinessExtra.putAdvisoryExtra(jSONObject3, this.advisoryMsgBusinessExtra);
                    jSONObject.put("business_ext", jSONObject3.toString());
                } catch (JSONException e) {
                    e = e;
                    jSONObject2 = jSONObject;
                    LogUtils.e(TAG, "getTextJson", e);
                    jSONObject = jSONObject2;
                    return jSONObject.toString();
                }
            } catch (JSONException e2) {
                e = e2;
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getAdvisoryMsgControl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mAdvisoryMsgControl;
        }
        return (String) invokeV.objValue;
    }

    public String getAdvisoryMsgDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mAdvisoryMsgDescription;
        }
        return (String) invokeV.objValue;
    }

    public void setAdvisoryMsgControl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.mAdvisoryMsgControl = str;
        }
    }

    public void setAdvisoryMsgDescription(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.mAdvisoryMsgDescription = str;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.TextMsg
    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            setMsgContent(getTextJson(str));
        }
    }

    public void setBusinessExtInfo(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) {
            if (this.advisoryMsgBusinessExtra == null) {
                this.advisoryMsgBusinessExtra = new AdvisoryMsgBusinessExtra();
            }
            this.advisoryMsgBusinessExtra.setRounds(i);
            this.advisoryMsgBusinessExtra.setAid(str);
        }
    }
}
