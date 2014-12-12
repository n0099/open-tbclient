package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class g extends a {
    private final boolean KM = false;
    private final boolean KN = false;
    private final boolean KO = false;
    private int height;
    private int width;

    public g(boolean z) {
        this.width = 0;
        this.height = 0;
        if (z) {
            this.width = TbadkCoreApplication.m255getInst().getApp().getResources().getDimensionPixelSize(u.frs_starheader_photo_width);
            this.height = this.width;
            return;
        }
        this.width = TbadkCoreApplication.m255getInst().getApp().getResources().getDimensionPixelSize(u.frs_header_photo_width);
        this.height = TbadkCoreApplication.m255getInst().getApp().getResources().getDimensionPixelSize(u.frs_header_photo_height);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a c = super.c(str, str2, objArr);
        if (c != null && c.ji() != null && c.ji().isRecycled()) {
            return null;
        }
        return c;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.g
    public boolean eh() {
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
    public boolean qf() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean qg() {
        return false;
    }
}
