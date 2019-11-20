package com.baidu.tbadk.core.util.f;

import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.util.SvgManager;
/* loaded from: classes.dex */
public class d extends a {
    public int cli;

    public d(int i, int i2) {
        super(i);
        this.cli = i2;
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public Drawable getDrawable() {
        return SvgManager.amL().a(this.cfF, this.cli, this.clh);
    }
}
