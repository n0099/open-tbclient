package com.baidu.ala.gift;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaDynamicGiftConfigInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int frame_count;
    public int frame_rate;
    public int height;
    public int isBottomMargin;
    public double oppositeX;
    public double oppositeY;
    public int repeatCount;
    public double userInfoX;
    public double userInfoY;
    public int width;

    public AlaDynamicGiftConfigInfo() {
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
        this.isBottomMargin = 0;
    }

    public boolean isBottomMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.isBottomMargin == 1 : invokeV.booleanValue;
    }

    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.frame_rate = jSONObject.optInt("frame_rate");
        this.frame_count = jSONObject.optInt("frame_count");
        this.isBottomMargin = jSONObject.optInt("is_bottom_margin");
        this.width = jSONObject.optInt("width");
        this.height = jSONObject.optInt("height");
        this.oppositeX = jSONObject.optDouble("opposite_x");
        this.oppositeY = jSONObject.optDouble("opposite_y");
        this.repeatCount = jSONObject.optInt("repeat_count");
        this.userInfoX = jSONObject.optDouble("user_info_x");
        this.userInfoY = jSONObject.optDouble("user_info_y");
    }
}
