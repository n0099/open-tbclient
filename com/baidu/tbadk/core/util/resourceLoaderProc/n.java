package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class n extends a {
    private static BdAsyncTaskParallel WX = null;
    private String WW;
    private boolean WY;
    private boolean WZ;
    private int size;

    public n(boolean z, boolean z2, boolean z3) {
        this.WW = null;
        this.size = 0;
        this.WY = false;
        this.WZ = false;
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        this.WY = z;
        this.WZ = z3;
        if (f < 2.0f) {
            this.WW = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.WW = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.WW = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.WW = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.g
    public boolean hE() {
        if (this.WZ) {
            return com.baidu.tbadk.core.n.px().pz();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        if (this.WY) {
            return null;
        }
        com.baidu.adp.widget.a.a et = com.baidu.tbadk.imageManager.e.zy().et(str);
        if (et != null) {
            et.Gw.Gy = "memory";
            et.Gw.Gz = 0L;
            et.Gw.GA = true;
            return et;
        }
        return et;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.WY) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected String d(String str, int i, int i2) {
        return String.valueOf(this.WW) + str;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.g
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.e zy = com.baidu.tbadk.imageManager.e.zy();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            zy.b(str, (com.baidu.adp.widget.a.a) obj);
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
        if (WX == null) {
            WX = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return WX;
    }
}
