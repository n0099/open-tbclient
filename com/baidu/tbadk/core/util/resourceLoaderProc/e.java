package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class e extends a {
    private boolean GD;
    private boolean GE;
    private boolean GF;
    private int GH;
    private int GI;

    public e(boolean z, boolean z2, boolean z3) {
        this.GD = true;
        this.GE = false;
        this.GF = false;
        this.GH = 0;
        this.GI = 0;
        this.GD = z;
        this.GE = z2;
        this.GF = z3;
        int n = com.baidu.adp.lib.util.m.n(TbadkApplication.m251getInst().getApp());
        this.GH = n <= 0 ? Constants.MEDIA_INFO : n;
        if (this.GH > 480) {
            this.GH = 480;
        }
        if (this.GH > com.baidu.adp.lib.util.m.dip2px(TbadkApplication.m251getInst().getApp(), 320.0f)) {
            this.GH = com.baidu.adp.lib.util.m.dip2px(TbadkApplication.m251getInst().getApp(), 320.0f);
        }
        this.GI = (int) (this.GH * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.j.fi() ? this.GH : this.GI;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.GD;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean nk() {
        return this.GF;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean nl() {
        return this.GE;
    }
}
