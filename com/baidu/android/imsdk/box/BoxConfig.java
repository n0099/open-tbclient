package com.baidu.android.imsdk.box;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.DefaultConfig;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.util.io.FileUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class BoxConfig extends DefaultConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BoxConfig() {
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

    @Override // com.baidu.android.imsdk.internal.DefaultConfig, com.baidu.android.imsdk.internal.IIMConfig
    public int getHeartBeatType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.internal.DefaultConfig, com.baidu.android.imsdk.internal.IIMConfig
    public Map<String, Object> getOtherParameters(Context context, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, chatMsg)) == null) {
            HashMap hashMap = new HashMap();
            if (chatMsg != null && chatMsg.isZhida()) {
                hashMap.put("tpl", Integer.valueOf(Constants.getTplZhida(context)));
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    @Override // com.baidu.android.imsdk.internal.DefaultConfig, com.baidu.android.imsdk.internal.IIMConfig
    public String getProductLineName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? FileUtils.SEARCHBOX_FOLDER : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.internal.DefaultConfig, com.baidu.android.imsdk.internal.IIMConfig
    public String getSubscribeRefApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? FileUtils.SEARCHBOX_FOLDER : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.internal.DefaultConfig, com.baidu.android.imsdk.internal.IIMConfig
    public String getSubscribeSrcApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? FileUtils.SEARCHBOX_FOLDER : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.internal.DefaultConfig, com.baidu.android.imsdk.internal.IIMConfig
    public String getToken(ChatObject chatObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, chatObject)) == null) {
            if (chatObject == null) {
                return null;
            }
            return chatObject.getCategory() + "." + chatObject.getContacter() + "." + chatObject.getType();
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.android.imsdk.internal.DefaultConfig, com.baidu.android.imsdk.internal.IIMConfig
    public boolean isMsgTypeSupported(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? BIMManager.isSupportMsgType(i2) : invokeI.booleanValue;
    }

    @Override // com.baidu.android.imsdk.internal.DefaultConfig, com.baidu.android.imsdk.internal.IIMConfig
    public ChatObject parseTokenToChatObject(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, context, str)) == null) {
            String[] tokens = DefaultConfig.getTokens(str, 3);
            try {
                if (tokens.length == 3) {
                    return new ChatObject(context, Integer.parseInt(tokens[0]), Long.parseLong(tokens[1]), -1L, Integer.parseInt(tokens[2]));
                }
                return null;
            } catch (Exception e2) {
                LogUtils.e("BoxConfig", "parseTokenToChatObject", e2);
                new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
                return null;
            }
        }
        return (ChatObject) invokeLL.objValue;
    }
}
