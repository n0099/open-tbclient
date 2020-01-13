package com.baidu.tbadk.core.util.e;

import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.util.SvgManager;
/* loaded from: classes.dex */
public class c extends a {
    public int cXQ;

    public c(int i, int i2) {
        super(i);
        this.cXQ = i2;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public Drawable getDrawable() {
        return SvgManager.aEp().a(this.cSo, this.cXQ, this.cXP);
    }
}
