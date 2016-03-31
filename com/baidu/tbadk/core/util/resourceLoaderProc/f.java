package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class f extends a {
    private int abD;
    private int height;
    private int width;

    public f(boolean z, int i) {
        this.width = 0;
        this.height = 0;
        this.abD = 0;
        this.abD = i;
        if (z) {
            this.width = TbadkCoreApplication.m411getInst().getApp().getResources().getDimensionPixelSize(t.e.frs_starheader_photo_width);
            this.height = this.width;
            return;
        }
        this.width = TbadkCoreApplication.m411getInst().getApp().getResources().getDimensionPixelSize(t.e.frs_header_photo_width);
        this.height = TbadkCoreApplication.m411getInst().getApp().getResources().getDimensionPixelSize(t.e.frs_header_photo_height);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a c(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a b = super.b(str, str2, objArr);
        if (b != null && b.mK() != null && b.mK().isRecycled()) {
            return null;
        }
        return b;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public boolean hu() {
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
    public boolean xb() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean xc() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int xd() {
        return this.abD;
    }
}
