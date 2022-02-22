package com.baidu.android.imsdk.internal;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes10.dex */
public class DefaultConfig implements IIMConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TOKEN_SEPARATOR = ".";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mRootComplete;

    public DefaultConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRootComplete = true;
    }

    public static String[] getTokens(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i2)) == null) {
            String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            return (split == null || split.length != i2) ? new String[0] : split;
        }
        return (String[]) invokeLI.objValue;
    }

    @Override // com.baidu.android.imsdk.internal.IIMConfig
    public String getBduss(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? AccountManagerImpl.getInstance(context).getToken() : (String) invokeL.objValue;
    }

    @Override // com.baidu.android.imsdk.internal.IIMConfig
    public int getHeartBeatType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.internal.IIMConfig
    public Map<String, Object> getOtherParameters(Context context, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, chatMsg)) == null) {
            return null;
        }
        return (Map) invokeLL.objValue;
    }

    @Override // com.baidu.android.imsdk.internal.IIMConfig
    public String getPaidCondition(String str, String str2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Long.valueOf(j2)})) == null) ? str : (String) invokeCommon.objValue;
    }

    @Override // com.baidu.android.imsdk.internal.IIMConfig
    public String getProductLineName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "main" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.internal.IIMConfig
    public boolean getRootComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mRootComplete : invokeV.booleanValue;
    }

    @Override // com.baidu.android.imsdk.internal.IIMConfig
    public String getSubscribeRefApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.internal.IIMConfig
    public String getSubscribeSrcApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.internal.IIMConfig
    public String getToken(ChatObject chatObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, chatObject)) == null) {
            if (chatObject == null) {
                return null;
            }
            return chatObject.getCategory() + "." + chatObject.getContacter() + "." + chatObject.getType();
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.android.imsdk.internal.IIMConfig
    public boolean isCategorySupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.android.imsdk.internal.IIMConfig
    public boolean isMsgTypeSupported(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.android.imsdk.internal.IIMConfig
    public boolean isNeedPaid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.android.imsdk.internal.IIMConfig
    public ChatObject parseTokenToChatObject(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, context, str)) == null) {
            String[] tokens = getTokens(str, 3);
            try {
                if (tokens.length == 3) {
                    return new ChatObject(context, Integer.parseInt(tokens[0]), Long.parseLong(tokens[1]), -1L, Integer.parseInt(tokens[2]));
                }
                return null;
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e("CRMConfig", "parseTokenToChatObject", e2);
                return null;
            }
        }
        return (ChatObject) invokeLL.objValue;
    }

    @Override // com.baidu.android.imsdk.internal.IIMConfig
    public void setRootComplete(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.mRootComplete = z;
        }
    }
}
