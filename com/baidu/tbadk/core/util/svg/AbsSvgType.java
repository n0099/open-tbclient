package com.baidu.tbadk.core.util.svg;

import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.util.SvgManager;
/* loaded from: classes3.dex */
public abstract class AbsSvgType {
    public int drawableId;
    public SvgManager.SvgResourceStateType stateType;

    public AbsSvgType(int i2) {
        this.drawableId = i2;
    }

    public abstract Drawable getDrawable();

    public AbsSvgType(int i2, SvgManager.SvgResourceStateType svgResourceStateType) {
        this.drawableId = i2;
        this.stateType = svgResourceStateType;
    }
}
