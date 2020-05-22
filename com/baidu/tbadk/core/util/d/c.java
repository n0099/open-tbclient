package com.baidu.tbadk.core.util.d;

import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.util.SvgManager;
/* loaded from: classes.dex */
public class c extends a {
    public int dPV;

    public c(int i, int i2) {
        super(i);
        this.dPV = i2;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public Drawable getDrawable() {
        return SvgManager.aUV().a(this.dJY, this.dPV, this.dPU);
    }
}
