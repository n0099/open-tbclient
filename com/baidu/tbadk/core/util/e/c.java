package com.baidu.tbadk.core.util.e;

import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.util.SvgManager;
/* loaded from: classes.dex */
public class c extends a {
    public int feL;

    public c(int i, int i2) {
        super(i);
        this.feL = i2;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public Drawable getDrawable() {
        return SvgManager.bsU().a(this.eXU, this.feL, this.feK);
    }
}
