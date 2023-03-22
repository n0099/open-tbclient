package com.baidu.android.imsdk.chatmessage;

import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.FansGroupAtMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class DraftManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DraftManager() {
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

    public static boolean isDraftMsgInvalid(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, chatMsg)) == null) {
            boolean z = chatMsg instanceof TextMsg;
            if (!z && !(chatMsg instanceof FansGroupAtMsg)) {
                return true;
            }
            if (z) {
                if ((TextUtils.isEmpty(chatMsg.getMsgContent()) || TextUtils.isEmpty(((TextMsg) chatMsg).getText())) && (chatMsg instanceof IReplyMsg) && !((IReplyMsg) chatMsg).isReplyMsg()) {
                    return true;
                }
                return false;
            } else if (TextUtils.isEmpty(((FansGroupAtMsg) chatMsg).getText()) && (chatMsg instanceof IReplyMsg) && !((IReplyMsg) chatMsg).isReplyMsg()) {
                return true;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
