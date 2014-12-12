package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class f extends a {
    private boolean KM;
    private boolean KN;
    private boolean KO;
    private int KR;
    private int KS;

    public f(boolean z, boolean z2, boolean z3) {
        this.KM = true;
        this.KN = false;
        this.KO = false;
        this.KR = 0;
        this.KS = 0;
        this.KM = z;
        this.KN = z2;
        this.KO = z3;
        int M = com.baidu.adp.lib.util.l.M(TbadkCoreApplication.m255getInst().getApp());
        this.KR = M <= 0 ? Constants.MEDIA_INFO : M;
        if (this.KR > 480) {
            this.KR = 480;
        }
        if (this.KR > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.m255getInst().getApp(), 320.0f)) {
            this.KR = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.m255getInst().getApp(), 320.0f);
        }
        this.KS = (int) (this.KR * 0.4f);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.i.fh() ? this.KR : this.KS;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return getWidth();
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.KM;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean qf() {
        return this.KO;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean qg() {
        return this.KN;
    }
}
