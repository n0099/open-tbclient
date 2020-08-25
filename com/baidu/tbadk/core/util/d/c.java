package com.baidu.tbadk.core.util.d;

import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.util.SvgManager;
/* loaded from: classes2.dex */
public class c extends a {
    public int emR;

    public c(int i, int i2) {
        super(i);
        this.emR = i2;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public Drawable getDrawable() {
        return SvgManager.bjq().a(this.egM, this.emR, this.emQ);
    }
}
