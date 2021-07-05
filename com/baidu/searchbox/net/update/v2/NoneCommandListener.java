package com.baidu.searchbox.net.update.v2;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.JsonElement;
import org.json.JSONException;
/* loaded from: classes3.dex */
public class NoneCommandListener extends AbstractCommandListener<JsonElement> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public NoneCommandListener() {
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

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, context, str, str2, commandPostData) == null) {
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<JsonElement> actionData) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2, actionData)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, str2)) == null) {
            return null;
        }
        return (String) invokeLLL.objValue;
    }
}
