package com.baidu.tbadk.core.util.f;

import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.util.SvgManager;
/* loaded from: classes.dex */
public class c extends a {
    public c(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public Drawable getDrawable() {
        return SvgManager.amL().b(this.cfF, this.clh);
    }
}
