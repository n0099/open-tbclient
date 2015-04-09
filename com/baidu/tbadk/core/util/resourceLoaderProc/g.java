package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class g extends a {
    private final boolean WH = false;
    private final boolean WI = false;
    private final boolean WJ = false;
    private int height;
    private int width;

    public g(boolean z) {
        this.width = 0;
        this.height = 0;
        if (z) {
            this.width = TbadkCoreApplication.m411getInst().getApp().getResources().getDimensionPixelSize(t.frs_starheader_photo_width);
            this.height = this.width;
            return;
        }
        this.width = TbadkCoreApplication.m411getInst().getApp().getResources().getDimensionPixelSize(t.frs_header_photo_width);
        this.height = TbadkCoreApplication.m411getInst().getApp().getResources().getDimensionPixelSize(t.frs_header_photo_height);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a c = super.c(str, str2, objArr);
        if (c != null && c.mz() != null && c.mz().isRecycled()) {
            return null;
        }
        return c;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.g
    public boolean hE() {
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
    public boolean tz() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean tA() {
        return false;
    }
}
