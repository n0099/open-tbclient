package com.baidu.searchbox.crius.ui.swiper;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SwiperAttrs {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int autoPlay;
    public String id;

    public SwiperAttrs() {
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
        this.autoPlay = 3000;
    }

    public static SwiperAttrs parse(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            SwiperAttrs swiperAttrs = new SwiperAttrs();
            if (jSONObject == null) {
                return swiperAttrs;
            }
            swiperAttrs.id = jSONObject.optString("swiper-id", "");
            swiperAttrs.autoPlay = jSONObject.optInt("autoplay-duration", 3000);
            return swiperAttrs;
        }
        return (SwiperAttrs) invokeL.objValue;
    }
}
