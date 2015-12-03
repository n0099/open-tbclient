package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class l extends a {
    private static BdAsyncTaskParallel adM = null;
    private String adL;
    private boolean adN;
    private boolean adO;
    private int size;

    public l(boolean z, boolean z2, boolean z3) {
        this.adL = null;
        this.size = 0;
        this.adN = false;
        this.adO = false;
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        this.adN = z;
        this.adO = z3;
        if (f < 2.0f) {
            this.adL = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.adL = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.adL = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.adL = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public boolean hg() {
        if (this.adO) {
            return com.baidu.tbadk.core.m.rh().rj();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        if (this.adN) {
            return null;
        }
        com.baidu.adp.widget.a.a fE = com.baidu.tbadk.imageManager.c.CX().fE(str);
        if (fE != null) {
            fE.GG.GI = "memory";
            fE.GG.GJ = 0L;
            fE.GG.GK = true;
            return fE;
        }
        return fE;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.g.a aVar, Object... objArr) {
        if (this.adN) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected String d(String str, int i, int i2) {
        return String.valueOf(this.adL) + str;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c CX = com.baidu.tbadk.imageManager.c.CX();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            CX.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean vS() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vT() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public BdAsyncTaskParallel hh() {
        if (adM == null) {
            adM = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return adM;
    }
}
