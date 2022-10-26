package com.baidu.searchbox.crius.parser;

import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.crius.util.CriusUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PrefixLabelAttrs {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HAS_PREFIX_VALUE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String bindingId;
    public boolean hasPrefix;
    public double prefixTitleMargin;
    public double prefixWidthWithoutText;

    public PrefixLabelAttrs() {
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

    public static PrefixLabelAttrs getLabelAttrs(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            PrefixLabelAttrs prefixLabelAttrs = new PrefixLabelAttrs();
            boolean z = true;
            if (jSONObject.optInt(NativeConstants.HAS_PREFIX) != 1) {
                z = false;
            }
            prefixLabelAttrs.hasPrefix = z;
            prefixLabelAttrs.prefixTitleMargin = CriusUtil.getDoubleIfExist(jSONObject, NativeConstants.PREFIX_MARGIN);
            prefixLabelAttrs.bindingId = jSONObject.optString(NativeConstants.BINDING_ID);
            prefixLabelAttrs.prefixWidthWithoutText = CriusUtil.getDoubleIfExist(jSONObject, NativeConstants.PREFIX_WIDTH_WITHOUT_TEXT);
            return prefixLabelAttrs;
        }
        return (PrefixLabelAttrs) invokeL.objValue;
    }
}
