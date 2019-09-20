package com.baidu.tbadk.core.util.f;

import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.util.SvgManager;
/* loaded from: classes.dex */
public class d extends a {
    public int bWV;

    public d(int i, int i2) {
        super(i);
        this.bWV = i2;
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public Drawable getDrawable() {
        return SvgManager.ajv().a(this.bPt, this.bWV, this.bWU);
    }
}
