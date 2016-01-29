package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class f extends a {
    private int acq;
    private int height;
    private int width;

    public f(boolean z, int i) {
        this.width = 0;
        this.height = 0;
        this.acq = 0;
        this.acq = i;
        if (z) {
            this.width = TbadkCoreApplication.m411getInst().getApp().getResources().getDimensionPixelSize(t.e.frs_starheader_photo_width);
            this.height = this.width;
            return;
        }
        this.width = TbadkCoreApplication.m411getInst().getApp().getResources().getDimensionPixelSize(t.e.frs_header_photo_width);
        this.height = TbadkCoreApplication.m411getInst().getApp().getResources().getDimensionPixelSize(t.e.frs_header_photo_height);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a c = super.c(str, str2, objArr);
        if (c != null && c.mS() != null && c.mS().isRecycled()) {
            return null;
        }
        return c;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public boolean ho() {
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
    public boolean wI() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean wJ() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int wK() {
        return this.acq;
    }
}
