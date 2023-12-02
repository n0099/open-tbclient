package com.baidu.tbadk.core.hybrid.handlers;

import android.content.ClipboardManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.hybrid.NamedBridgeHandler;
import com.baidu.tieba.c45;
import com.baidu.tieba.e45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ClipboardBridgeHandler extends NamedBridgeHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tbadk.core.hybrid.NamedBridgeHandler
    public String scope() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "TBHY_COMMON_Clipboard" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClipboardBridgeHandler(c45 c45Var) {
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

    @e45(CommandUBCHelper.COMMAND_UBC_TYPE_COPY)
    public JSONObject copyToClipboard(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject != null) {
                String optString = jSONObject.optString("message");
                if (!StringUtils.isNull(optString)) {
                    ((ClipboardManager) getContext().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setText(optString.trim());
                    jSONObject2.put("status", 0);
                    jSONObject2.put("message", "");
                    return jSONObject2;
                }
            }
            jSONObject2.put("status", -1);
            jSONObject2.put("message", "无效内容");
            return jSONObject2;
        }
        return (JSONObject) invokeL.objValue;
    }
}
