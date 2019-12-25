package com.baidu.tbadk.core.util.e;

import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.util.SvgManager;
/* loaded from: classes.dex */
public class c extends a {
    public int cXG;

    public c(int i, int i2) {
        super(i);
        this.cXG = i2;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public Drawable getDrawable() {
        return SvgManager.aDW().a(this.cSe, this.cXG, this.cXF);
    }
}
