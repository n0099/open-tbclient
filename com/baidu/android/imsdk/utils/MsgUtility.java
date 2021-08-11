package com.baidu.android.imsdk.utils;

import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class MsgUtility {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MsgUtility() {
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

    public static boolean isNotice(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, chatMsg)) == null) {
            if (2 == chatMsg.getCategory() || -1 == chatMsg.getMsgType()) {
                return true;
            }
            return (chatMsg.getMsgType() >= 1001 && chatMsg.getMsgType() <= 1014) || chatMsg.getMsgType() == 2001 || chatMsg.getMsgType() == 2010 || chatMsg.getMsgType() == 22 || chatMsg.getMsgType() == 36;
        }
        return invokeL.booleanValue;
    }

    public static JSONArray listToJsonArray(List<Long> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    jSONArray.put(list.get(i2));
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }
}
