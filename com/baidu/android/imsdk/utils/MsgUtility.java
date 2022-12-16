package com.baidu.android.imsdk.utils;

import android.annotation.SuppressLint;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.FansGroupAtMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class MsgUtility {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MsgUtility() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static String getMsgUUid(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, chatMsg)) == null) {
            if (chatMsg == null) {
                return "";
            }
            return String.format("send.user.msg.%d.%d", Long.valueOf(chatMsg.getRowId()), Integer.valueOf(chatMsg.getCategory()));
        }
        return (String) invokeL.objValue;
    }

    public static JSONArray listToJsonArray(List<Long> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    jSONArray.put(list.get(i));
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public static boolean isDraftMsg(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, chatMsg)) == null) {
            if ((!(chatMsg instanceof TextMsg) && !(chatMsg instanceof FansGroupAtMsg)) || chatMsg.getStatus() != 3) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isNotice(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, chatMsg)) == null) {
            if (2 == chatMsg.getCategory() || -1 == chatMsg.getMsgType()) {
                return true;
            }
            if ((chatMsg.getMsgType() >= 1001 && chatMsg.getMsgType() <= 1027) || chatMsg.getMsgType() == 2001 || chatMsg.getMsgType() == 22 || chatMsg.getMsgType() == 36) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
