package com.baidu.searchbox.crius.parser;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\"\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007\"\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lorg/json/JSONObject;", "jsonObject", "Lcom/baidu/searchbox/crius/parser/PraiseAttrs;", "parsePraiseAttrs", "(Lorg/json/JSONObject;)Lcom/baidu/searchbox/crius/parser/PraiseAttrs;", "", "PRAISE_ICON_TYPE_HAND", "I", "PRAISE_ICON_TYPE_HEART", "lib-crius_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class PraiseAttrsKt {
    public static final int PRAISE_ICON_TYPE_HAND = 0;
    public static final int PRAISE_ICON_TYPE_HEART = 1;

    public static final PraiseAttrs parsePraiseAttrs(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        PraiseAttrs praiseAttrs = new PraiseAttrs();
        praiseAttrs.setId(jsonObject.optString("id"));
        boolean z = false;
        praiseAttrs.setIconType(Integer.valueOf(jsonObject.optInt("icon_type", 0)));
        praiseAttrs.setCountText(jsonObject.optString("text", ""));
        praiseAttrs.setPraiseStatus(Integer.valueOf(jsonObject.optInt("status", 0)));
        praiseAttrs.setTextLeftMargin(Integer.valueOf(jsonObject.optInt("text_left_margin")));
        praiseAttrs.setTextSize(Integer.valueOf(jsonObject.optInt("text_size", 16)));
        if (jsonObject.optInt("enable_long_press_anim", 0) == 1) {
            z = true;
        }
        praiseAttrs.setLongPressEnable(Boolean.valueOf(z));
        if (jsonObject.has("text_color_normal")) {
            praiseAttrs.setTextColorNormal(jsonObject.optString("text_color_normal"));
        }
        if (jsonObject.has("text_color_praised")) {
            praiseAttrs.setTextColorPraised(jsonObject.optString("text_color_praised"));
        }
        if (jsonObject.has("text_color_normal_night")) {
            praiseAttrs.setTextColorNormalNight(jsonObject.optString("text_color_normal_night"));
        }
        if (jsonObject.has("text_color_praised_night")) {
            praiseAttrs.setTextColorPraisedNight(jsonObject.optString("text_color_praised_night"));
        }
        return praiseAttrs;
    }
}
