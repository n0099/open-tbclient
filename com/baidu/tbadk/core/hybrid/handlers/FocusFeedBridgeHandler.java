package com.baidu.tbadk.core.hybrid.handlers;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.hybrid.NamedBridgeHandler;
import com.baidu.tieba.c45;
import com.baidu.tieba.e45;
import com.baidu.tieba.gd5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FocusFeedBridgeHandler extends NamedBridgeHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tbadk.core.hybrid.NamedBridgeHandler
    public String scope() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "TBHY_EXT_FocusFeed" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusFeedBridgeHandler(c45 c45Var) {
        super(c45Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c45Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c45) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @e45("appointNotice")
    public void appointNotice(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null) {
            int optInt = jSONObject.optInt("activityId");
            int optInt2 = jSONObject.optInt("state");
            String optString = jSONObject.optString("curNum");
            gd5 gd5Var = new gd5();
            gd5Var.a(optInt);
            gd5Var.c(optInt2);
            gd5Var.b(optString);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016492, gd5Var));
        }
    }
}
