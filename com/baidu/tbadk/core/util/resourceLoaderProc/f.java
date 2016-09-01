package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class f extends a {
    private int aaR;
    private int height;
    private int width;

    public f(boolean z, int i) {
        this.width = 0;
        this.height = 0;
        this.aaR = 0;
        this.aaR = i;
        if (z) {
            this.width = TbadkCoreApplication.m9getInst().getApp().getResources().getDimensionPixelSize(t.e.ds176);
            this.height = this.width;
            return;
        }
        this.width = TbadkCoreApplication.m9getInst().getApp().getResources().getDimensionPixelSize(t.e.ds184);
        this.height = TbadkCoreApplication.m9getInst().getApp().getResources().getDimensionPixelSize(t.e.ds184);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a d(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a b = super.b(str, str2, objArr);
        if (b != null && b.jV() != null && b.jV().isRecycled()) {
            return null;
        }
        return b;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public boolean eD() {
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
    public boolean vM() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vN() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int vO() {
        return this.aaR;
    }
}
