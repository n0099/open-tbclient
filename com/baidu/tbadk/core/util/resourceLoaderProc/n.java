package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class n extends a {
    private static BdAsyncTaskParallel WV = null;
    private String WU;
    private boolean WW;
    private boolean WX;
    private int size;

    public n(boolean z, boolean z2, boolean z3) {
        this.WU = null;
        this.size = 0;
        this.WW = false;
        this.WX = false;
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        this.WW = z;
        this.WX = z3;
        if (f < 2.0f) {
            this.WU = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.WU = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.WU = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.WU = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.g
    public boolean hE() {
        if (this.WX) {
            return com.baidu.tbadk.core.n.px().pz();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        if (this.WW) {
            return null;
        }
        com.baidu.adp.widget.a.a eq = com.baidu.tbadk.imageManager.e.zs().eq(str);
        if (eq != null) {
            eq.Gu.Gw = "memory";
            eq.Gu.Gx = 0L;
            eq.Gu.Gy = true;
            return eq;
        }
        return eq;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.WW) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected String d(String str, int i, int i2) {
        return String.valueOf(this.WU) + str;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.g
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.e zs = com.baidu.tbadk.imageManager.e.zs();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            zs.b(str, (com.baidu.adp.widget.a.a) obj);
        }
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return this.size;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return this.size;
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

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.g
    public BdAsyncTaskParallel hF() {
        if (WV == null) {
            WV = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return WV;
    }
}
