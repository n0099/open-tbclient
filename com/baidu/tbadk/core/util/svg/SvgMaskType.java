package com.baidu.tbadk.core.util.svg;

import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.util.SvgManager;
/* loaded from: classes3.dex */
public class SvgMaskType extends AbsSvgType {
    public SvgMaskType(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.core.util.svg.AbsSvgType
    public Drawable getDrawable() {
        return SvgManager.getInstance().getMaskDrawable(this.drawableId, this.stateType);
    }

    public SvgMaskType(int i2, SvgManager.SvgResourceStateType svgResourceStateType) {
        super(i2, svgResourceStateType);
    }
}
