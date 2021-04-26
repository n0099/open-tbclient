package com.baidu.tbadk.core.util.svg;

import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.util.SvgManager;
/* loaded from: classes3.dex */
public class SvgPureType extends AbsSvgType {
    public int tintColorId;

    public SvgPureType(int i2, int i3) {
        super(i2);
        this.tintColorId = i3;
    }

    @Override // com.baidu.tbadk.core.util.svg.AbsSvgType
    public Drawable getDrawable() {
        return SvgManager.getInstance().getPureDrawable(this.drawableId, this.tintColorId, this.stateType);
    }

    public SvgPureType(int i2, SvgManager.SvgResourceStateType svgResourceStateType, int i3) {
        super(i2, svgResourceStateType);
        this.tintColorId = i3;
    }
}
