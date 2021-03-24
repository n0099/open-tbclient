package com.baidu.tbadk.core.util.svg;

import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.util.SvgManager;
/* loaded from: classes3.dex */
public abstract class AbsSvgType {
    public int drawableId;
    public SvgManager.SvgResourceStateType stateType;

    public AbsSvgType(int i) {
        this.drawableId = i;
    }

    public abstract Drawable getDrawable();

    public AbsSvgType(int i, SvgManager.SvgResourceStateType svgResourceStateType) {
        this.drawableId = i;
        this.stateType = svgResourceStateType;
    }
}
