package com.baidu.searchbox.crius.parser;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ScaleFocusPoint {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float DEFAULT_VALUE = 0.5f;
    public transient /* synthetic */ FieldHolder $fh;
    public float x;
    public float y;

    public ScaleFocusPoint() {
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
        this.x = 0.5f;
        this.y = 0.5f;
    }

    public static ScaleFocusPoint getFocusPoint(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject != null) {
                ScaleFocusPoint scaleFocusPoint = new ScaleFocusPoint();
                scaleFocusPoint.x = (float) jSONObject.optDouble("x", 0.5d);
                scaleFocusPoint.y = (float) jSONObject.optDouble("y", 0.5d);
                return scaleFocusPoint;
            }
            return null;
        }
        return (ScaleFocusPoint) invokeL.objValue;
    }
}
