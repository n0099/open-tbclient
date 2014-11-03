package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class f extends a {
    private final boolean GD = false;
    private final boolean GE = false;
    private final boolean GF = false;
    private int height;
    private int width;

    public f(boolean z) {
        this.width = 0;
        this.height = 0;
        if (z) {
            this.width = TbadkApplication.m251getInst().getApp().getResources().getDimensionPixelSize(t.frs_starheader_photo_width);
            this.height = this.width;
            return;
        }
        this.width = TbadkApplication.m251getInst().getApp().getResources().getDimensionPixelSize(t.frs_header_photo_width);
        this.height = TbadkApplication.m251getInst().getApp().getResources().getDimensionPixelSize(t.frs_header_photo_height);
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
    public boolean nk() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean nl() {
        return false;
    }
}
