package com.baidu.tbadk.core.util.e;

import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.util.SvgManager;
/* loaded from: classes.dex */
public class c extends a {
    public int fdm;

    public c(int i, int i2) {
        super(i);
        this.fdm = i2;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public Drawable getDrawable() {
        return SvgManager.bsR().a(this.eWv, this.fdm, this.fdl);
    }
}
