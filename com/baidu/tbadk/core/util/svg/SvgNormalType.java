package com.baidu.tbadk.core.util.svg;

import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.util.SvgManager;
/* loaded from: classes3.dex */
public class SvgNormalType extends AbsSvgType {
    public SvgNormalType(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.core.util.svg.AbsSvgType
    public Drawable getDrawable() {
        return SvgManager.getInstance().getNormalDrawable(this.drawableId, this.stateType);
    }

    public SvgNormalType(int i, SvgManager.SvgResourceStateType svgResourceStateType) {
        super(i, svgResourceStateType);
    }
}
