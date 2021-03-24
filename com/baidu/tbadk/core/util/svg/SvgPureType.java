package com.baidu.tbadk.core.util.svg;

import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.util.SvgManager;
/* loaded from: classes3.dex */
public class SvgPureType extends AbsSvgType {
    public int tintColorId;

    public SvgPureType(int i, int i2) {
        super(i);
        this.tintColorId = i2;
    }

    @Override // com.baidu.tbadk.core.util.svg.AbsSvgType
    public Drawable getDrawable() {
        return SvgManager.getInstance().getPureDrawable(this.drawableId, this.tintColorId, this.stateType);
    }

    public SvgPureType(int i, SvgManager.SvgResourceStateType svgResourceStateType, int i2) {
        super(i, svgResourceStateType);
        this.tintColorId = i2;
    }
}
