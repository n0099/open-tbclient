package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.p;
/* loaded from: classes.dex */
public class d extends a {
    private final boolean a = false;
    private final boolean b = false;
    private final boolean c = false;
    private int d;
    private int e;

    public d(boolean z) {
        this.d = 0;
        this.e = 0;
        if (z) {
            this.d = TbadkApplication.m252getInst().getApp().getResources().getDimensionPixelSize(p.frs_starheader_photo_width);
            this.e = this.d;
            return;
        }
        this.d = TbadkApplication.m252getInst().getApp().getResources().getDimensionPixelSize(p.frs_header_photo_width);
        this.e = TbadkApplication.m252getInst().getApp().getResources().getDimensionPixelSize(p.frs_header_photo_height);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.resourceLoader.g
    public boolean a() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int b() {
        return this.d;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int c() {
        return this.e;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean d() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean e() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean f() {
        return false;
    }
}
