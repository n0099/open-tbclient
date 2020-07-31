package com.baidu.tbadk.core.util.d;

import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.util.SvgManager;
/* loaded from: classes.dex */
public class c extends a {
    public int edi;

    public c(int i, int i2) {
        super(i);
        this.edi = i2;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public Drawable getDrawable() {
        return SvgManager.baR().a(this.dXg, this.edi, this.edh);
    }
}
