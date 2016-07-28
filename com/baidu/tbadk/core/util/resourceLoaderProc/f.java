package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class f extends a {
    private int Yd;
    private int height;
    private int width;

    public f(boolean z, int i) {
        this.width = 0;
        this.height = 0;
        this.Yd = 0;
        this.Yd = i;
        if (z) {
            this.width = TbadkCoreApplication.m10getInst().getApp().getResources().getDimensionPixelSize(u.e.ds176);
            this.height = this.width;
            return;
        }
        this.width = TbadkCoreApplication.m10getInst().getApp().getResources().getDimensionPixelSize(u.e.ds184);
        this.height = TbadkCoreApplication.m10getInst().getApp().getResources().getDimensionPixelSize(u.e.ds184);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a d(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a b = super.b(str, str2, objArr);
        if (b != null && b.ja() != null && b.ja().isRecycled()) {
            return null;
        }
        return b;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public boolean dI() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return this.width;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return this.height;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean uH() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean uI() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int uJ() {
        return this.Yd;
    }
}
