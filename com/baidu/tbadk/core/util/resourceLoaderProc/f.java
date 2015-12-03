package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class f extends a {
    private int height;
    private int width;

    public f(boolean z) {
        this.width = 0;
        this.height = 0;
        if (z) {
            this.width = TbadkCoreApplication.m411getInst().getApp().getResources().getDimensionPixelSize(n.d.frs_starheader_photo_width);
            this.height = this.width;
            return;
        }
        this.width = TbadkCoreApplication.m411getInst().getApp().getResources().getDimensionPixelSize(n.d.frs_header_photo_width);
        this.height = TbadkCoreApplication.m411getInst().getApp().getResources().getDimensionPixelSize(n.d.frs_header_photo_height);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a c = super.c(str, str2, objArr);
        if (c != null && c.ng() != null && c.ng().isRecycled()) {
            return null;
        }
        return c;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public boolean hg() {
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
    public boolean vS() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vT() {
        return false;
    }
}
