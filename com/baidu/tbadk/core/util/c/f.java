package com.baidu.tbadk.core.util.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class f extends a {
    private int height;
    private int procType;
    private int width;

    public f(boolean z, int i) {
        this.width = 0;
        this.height = 0;
        this.procType = 0;
        this.procType = i;
        if (z) {
            this.width = TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.f.ds176);
            this.height = this.width;
            return;
        }
        this.width = TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.f.ds184);
        this.height = TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.f.ds184);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: c */
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a b = super.b(str, str2, objArr);
        if (b != null && b.kO() != null && b.kO().isRecycled()) {
            return null;
        }
        return b;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public boolean fN() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return this.width;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return this.height;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean ws() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wt() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wu() {
        return this.procType;
    }
}
