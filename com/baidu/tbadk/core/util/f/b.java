package com.baidu.tbadk.core.util.f;

import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.util.SvgManager;
/* loaded from: classes.dex */
public class b extends a {
    public b(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public Drawable getDrawable() {
        return SvgManager.amN().a(this.cgw, this.clY);
    }
}
