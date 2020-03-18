package com.baidu.tbadk.core.util.d;

import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.util.SvgManager;
/* loaded from: classes.dex */
public class c extends a {
    public int dcv;

    public c(int i, int i2) {
        super(i);
        this.dcv = i2;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public Drawable getDrawable() {
        return SvgManager.aGG().a(this.cWF, this.dcv, this.dct);
    }
}
