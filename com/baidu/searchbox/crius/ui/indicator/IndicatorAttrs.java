package com.baidu.searchbox.crius.ui.indicator;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class IndicatorAttrs {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int indicatorContentLRMargin;
    public String indicatorDefaultColor;
    public String indicatorDefaultColorNight;
    public int indicatorItemHeight;
    public int indicatorItemSelectedWidth;
    public int indicatorItemWidth;
    public int indicatorMargin;
    public String indicatorSelectedColor;
    public String indicatorSelectedColorNight;
    public boolean isHorizontalCenter;
    public String swiperId;

    public IndicatorAttrs() {
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
        this.isHorizontalCenter = false;
    }

    public static IndicatorAttrs parse(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            IndicatorAttrs indicatorAttrs = new IndicatorAttrs();
            if (jSONObject == null) {
                return indicatorAttrs;
            }
            indicatorAttrs.indicatorMargin = jSONObject.optInt("indicator-margin", 6);
            indicatorAttrs.indicatorItemWidth = jSONObject.optInt("indicator-item-width", 6);
            indicatorAttrs.indicatorItemHeight = jSONObject.optInt("indicator-item-height", 6);
            indicatorAttrs.indicatorContentLRMargin = jSONObject.optInt("indicator-content-left", 0);
            indicatorAttrs.indicatorItemSelectedWidth = jSONObject.optInt("indicator-item-selected-width", -1);
            indicatorAttrs.indicatorMargin = jSONObject.optInt("indicator-margin", 6);
            indicatorAttrs.indicatorMargin = jSONObject.optInt("indicator-margin", 6);
            indicatorAttrs.swiperId = jSONObject.optString("swiper-id", "");
            indicatorAttrs.indicatorSelectedColor = jSONObject.optString("indicator-selected-color", "");
            indicatorAttrs.indicatorDefaultColor = jSONObject.optString("indicator-default-color", "");
            indicatorAttrs.indicatorSelectedColorNight = jSONObject.optString("indicator-selected-night-color", "");
            indicatorAttrs.indicatorDefaultColorNight = jSONObject.optString("indicator-default-night-color", "");
            indicatorAttrs.isHorizontalCenter = jSONObject.optInt("indicator-horizontal-center", 1) == 1;
            return indicatorAttrs;
        }
        return (IndicatorAttrs) invokeL.objValue;
    }
}
