package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class e extends a {
    private boolean GC;
    private boolean GD;
    private boolean GE;
    private int GG;
    private int GH;

    public e(boolean z, boolean z2, boolean z3) {
        this.GC = true;
        this.GD = false;
        this.GE = false;
        this.GG = 0;
        this.GH = 0;
        this.GC = z;
        this.GD = z2;
        this.GE = z3;
        int n = com.baidu.adp.lib.util.m.n(TbadkApplication.m251getInst().getApp());
        this.GG = n <= 0 ? Constants.MEDIA_INFO : n;
        if (this.GG > 480) {
            this.GG = 480;
        }
        if (this.GG > com.baidu.adp.lib.util.m.dip2px(TbadkApplication.m251getInst().getApp(), 320.0f)) {
            this.GG = com.baidu.adp.lib.util.m.dip2px(TbadkApplication.m251getInst().getApp(), 320.0f);
        }
        this.GH = (int) (this.GG * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.j.fi() ? this.GG : this.GH;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.GC;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean nk() {
        return this.GE;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean nl() {
        return this.GD;
    }
}
