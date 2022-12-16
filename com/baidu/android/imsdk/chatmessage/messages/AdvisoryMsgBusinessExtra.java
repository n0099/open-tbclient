package com.baidu.android.imsdk.chatmessage.messages;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
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
public class AdvisoryMsgBusinessExtra {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AID_KEY = "aid";
    public static final String ROUNDS_KEY = "rounds";
    public static final String SUBTYPE_KEY = "subType";
    public static final int SUB_TYPE_SYSTEM_INVITE_EVALUATION = 2;
    public static final String TAG = "AdvisoryTextMsgBusinessExtra";
    public transient /* synthetic */ FieldHolder $fh;
    public String advisoryAskExtraText;
    public String advisoryReplyExtraText;
    public String aid;
    public int rounds;
    public int subType;

    public AdvisoryMsgBusinessExtra() {
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
        this.subType = -1;
        this.advisoryAskExtraText = "";
        this.advisoryReplyExtraText = "";
        this.rounds = -1;
    }

    public String getAdvisoryAskExtraText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.advisoryAskExtraText;
        }
        return (String) invokeV.objValue;
    }

    public String getAdvisoryReplyExtraText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.advisoryReplyExtraText;
        }
        return (String) invokeV.objValue;
    }

    public String getAid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.aid;
        }
        return (String) invokeV.objValue;
    }

    public int getRounds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.rounds;
        }
        return invokeV.intValue;
    }

    public int getSubType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.subType;
        }
        return invokeV.intValue;
    }

    public static int getMsgRounds(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, chatMsg)) == null) {
            AdvisoryMsgBusinessExtra hasBusinessExtra = hasBusinessExtra(chatMsg);
            if (hasBusinessExtra == null) {
                return -1;
            }
            return hasBusinessExtra.rounds;
        }
        return invokeL.intValue;
    }

    public static boolean isSystemInviteEvaluationMsg(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, chatMsg)) == null) {
            AdvisoryMsgBusinessExtra hasBusinessExtra = hasBusinessExtra(chatMsg);
            if (hasBusinessExtra == null || hasBusinessExtra.getSubType() != 2) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setAid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.aid = str;
        }
    }

    public void setRounds(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.rounds = i;
        }
    }

    public void setSubType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.subType = i;
        }
    }

    public static AdvisoryMsgBusinessExtra hasBusinessExtra(ChatMsg chatMsg) {
        InterceptResult invokeL;
        AdvisoryMsgBusinessExtra advisoryMsgBusinessExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, chatMsg)) == null) {
            if (chatMsg instanceof TextMsg) {
                advisoryMsgBusinessExtra = ((TextMsg) chatMsg).getAdvisoryBusinessExtra();
            } else {
                advisoryMsgBusinessExtra = null;
            }
            if (chatMsg instanceof AudioMsg) {
                advisoryMsgBusinessExtra = ((AudioMsg) chatMsg).getAdvisoryBusinessExtra();
            }
            if (chatMsg instanceof ImageMsg) {
                return ((ImageMsg) chatMsg).getAdvisoryBusinessExtra();
            }
            return advisoryMsgBusinessExtra;
        }
        return (AdvisoryMsgBusinessExtra) invokeL.objValue;
    }

    public static AdvisoryMsgBusinessExtra parseAdvisoryExtra(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        AdvisoryMsgBusinessExtra advisoryMsgBusinessExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            AdvisoryMsgBusinessExtra advisoryMsgBusinessExtra2 = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                jSONObject = new JSONObject(str);
                advisoryMsgBusinessExtra = new AdvisoryMsgBusinessExtra();
            } catch (JSONException e) {
                e = e;
            }
            try {
                advisoryMsgBusinessExtra.subType = jSONObject.optInt(SUBTYPE_KEY, -1);
                advisoryMsgBusinessExtra.rounds = jSONObject.optInt(ROUNDS_KEY, -1);
                advisoryMsgBusinessExtra.aid = jSONObject.optString("aid");
                advisoryMsgBusinessExtra.advisoryAskExtraText = jSONObject.optString("askExtraText");
                advisoryMsgBusinessExtra.advisoryReplyExtraText = jSONObject.optString("replyExtraText");
                return advisoryMsgBusinessExtra;
            } catch (JSONException e2) {
                e = e2;
                advisoryMsgBusinessExtra2 = advisoryMsgBusinessExtra;
                LogUtils.e(LogUtils.TAG, "getTextJson", e);
                return advisoryMsgBusinessExtra2;
            }
        }
        return (AdvisoryMsgBusinessExtra) invokeL.objValue;
    }

    public static void putAdvisoryExtra(JSONObject jSONObject, AdvisoryMsgBusinessExtra advisoryMsgBusinessExtra) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, null, jSONObject, advisoryMsgBusinessExtra) == null) && jSONObject != null && advisoryMsgBusinessExtra != null) {
            try {
                jSONObject.put(ROUNDS_KEY, advisoryMsgBusinessExtra.rounds);
                jSONObject.put("aid", advisoryMsgBusinessExtra.aid);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
