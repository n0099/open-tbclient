package com.baidu.searchbox.crius.ui.indicator;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class IndicatorAttrs {
    public int indicatorContentLRMargin;
    public String indicatorDefaultColor;
    public String indicatorDefaultColorNight;
    public int indicatorItemHeight;
    public int indicatorItemSelectedWidth;
    public int indicatorItemWidth;
    public int indicatorMargin;
    public String indicatorSelectedColor;
    public String indicatorSelectedColorNight;
    public boolean isHorizontalCenter = false;
    public String swiperId;

    public static IndicatorAttrs parse(JSONObject jSONObject) {
        IndicatorAttrs indicatorAttrs = new IndicatorAttrs();
        if (jSONObject == null) {
            return indicatorAttrs;
        }
        indicatorAttrs.indicatorMargin = jSONObject.optInt("indicator-margin", 6);
        indicatorAttrs.indicatorItemWidth = jSONObject.optInt("indicator-item-width", 6);
        indicatorAttrs.indicatorItemHeight = jSONObject.optInt("indicator-item-height", 6);
        boolean z = false;
        indicatorAttrs.indicatorContentLRMargin = jSONObject.optInt("indicator-content-left", 0);
        indicatorAttrs.indicatorItemSelectedWidth = jSONObject.optInt("indicator-item-selected-width", -1);
        indicatorAttrs.indicatorMargin = jSONObject.optInt("indicator-margin", 6);
        indicatorAttrs.indicatorMargin = jSONObject.optInt("indicator-margin", 6);
        indicatorAttrs.swiperId = jSONObject.optString("swiper-id", "");
        indicatorAttrs.indicatorSelectedColor = jSONObject.optString("indicator-selected-color", "");
        indicatorAttrs.indicatorDefaultColor = jSONObject.optString("indicator-default-color", "");
        indicatorAttrs.indicatorSelectedColorNight = jSONObject.optString("indicator-selected-night-color", "");
        indicatorAttrs.indicatorDefaultColorNight = jSONObject.optString("indicator-default-night-color", "");
        if (jSONObject.optInt("indicator-horizontal-center", 1) == 1) {
            z = true;
        }
        indicatorAttrs.isHorizontalCenter = z;
        return indicatorAttrs;
    }
}
