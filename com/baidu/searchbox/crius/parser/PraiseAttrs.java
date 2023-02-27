package com.baidu.searchbox.crius.parser;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u001e\u0018\u0000B\u0007¢\u0006\u0004\b.\u0010/R$\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u0010\u0010\u0005\"\u0004\b\u0011\u0010\u0007R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR$\u0010\u001c\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001d\u0010\u0005\"\u0004\b\u001e\u0010\u0007R$\u0010\u001f\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0003\u001a\u0004\b \u0010\u0005\"\u0004\b!\u0010\u0007R$\u0010\"\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0003\u001a\u0004\b#\u0010\u0005\"\u0004\b$\u0010\u0007R$\u0010%\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0003\u001a\u0004\b&\u0010\u0005\"\u0004\b'\u0010\u0007R$\u0010(\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\n\u001a\u0004\b)\u0010\f\"\u0004\b*\u0010\u000eR$\u0010+\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\n\u001a\u0004\b,\u0010\f\"\u0004\b-\u0010\u000e¨\u00060"}, d2 = {"Lcom/baidu/searchbox/crius/parser/PraiseAttrs;", "", "countText", "Ljava/lang/String;", "getCountText", "()Ljava/lang/String;", "setCountText", "(Ljava/lang/String;)V", "", "iconType", "Ljava/lang/Integer;", "getIconType", "()Ljava/lang/Integer;", "setIconType", "(Ljava/lang/Integer;)V", "id", "getId", "setId", "", "longPressEnable", "Ljava/lang/Boolean;", "getLongPressEnable", "()Ljava/lang/Boolean;", "setLongPressEnable", "(Ljava/lang/Boolean;)V", "praiseStatus", "getPraiseStatus", "setPraiseStatus", "textColorNormal", "getTextColorNormal", "setTextColorNormal", "textColorNormalNight", "getTextColorNormalNight", "setTextColorNormalNight", "textColorPraised", "getTextColorPraised", "setTextColorPraised", "textColorPraisedNight", "getTextColorPraisedNight", "setTextColorPraisedNight", "textLeftMargin", "getTextLeftMargin", "setTextLeftMargin", "textSize", "getTextSize", "setTextSize", "<init>", "()V", "lib-crius_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class PraiseAttrs {
    public String countText;
    public Integer praiseStatus;
    public String textColorNormal;
    public String textColorNormalNight;
    public String textColorPraised;
    public String textColorPraisedNight;
    public Integer textLeftMargin;
    public Integer textSize;
    public String id = "";
    public Integer iconType = 0;
    public Boolean longPressEnable = Boolean.FALSE;

    public final String getCountText() {
        return this.countText;
    }

    public final Integer getIconType() {
        return this.iconType;
    }

    public final String getId() {
        return this.id;
    }

    public final Boolean getLongPressEnable() {
        return this.longPressEnable;
    }

    public final Integer getPraiseStatus() {
        return this.praiseStatus;
    }

    public final String getTextColorNormal() {
        return this.textColorNormal;
    }

    public final String getTextColorNormalNight() {
        return this.textColorNormalNight;
    }

    public final String getTextColorPraised() {
        return this.textColorPraised;
    }

    public final String getTextColorPraisedNight() {
        return this.textColorPraisedNight;
    }

    public final Integer getTextLeftMargin() {
        return this.textLeftMargin;
    }

    public final Integer getTextSize() {
        return this.textSize;
    }

    public final void setCountText(String str) {
        this.countText = str;
    }

    public final void setIconType(Integer num) {
        this.iconType = num;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final void setLongPressEnable(Boolean bool) {
        this.longPressEnable = bool;
    }

    public final void setPraiseStatus(Integer num) {
        this.praiseStatus = num;
    }

    public final void setTextColorNormal(String str) {
        this.textColorNormal = str;
    }

    public final void setTextColorNormalNight(String str) {
        this.textColorNormalNight = str;
    }

    public final void setTextColorPraised(String str) {
        this.textColorPraised = str;
    }

    public final void setTextColorPraisedNight(String str) {
        this.textColorPraisedNight = str;
    }

    public final void setTextLeftMargin(Integer num) {
        this.textLeftMargin = num;
    }

    public final void setTextSize(Integer num) {
        this.textSize = num;
    }
}
