package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m extends a {
    private static BdAsyncTaskParallel acF = null;
    private String acE;
    private boolean acG;
    private boolean acH;
    private int size;

    public m(boolean z, boolean z2, boolean z3) {
        this.acE = null;
        this.size = 0;
        this.acG = false;
        this.acH = false;
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        this.acG = z;
        this.acH = z3;
        if (f < 2.0f) {
            this.acE = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.acE = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.acE = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.acE = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.e
    public boolean hf() {
        if (this.acH) {
            return com.baidu.tbadk.core.m.rd().rf();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        if (this.acG) {
            return null;
        }
        com.baidu.adp.widget.a.a fa = com.baidu.tbadk.imageManager.c.Ce().fa(str);
        if (fa != null) {
            fa.Gn.Gp = "memory";
            fa.Gn.Gq = 0L;
            fa.Gn.Gr = true;
            return fa;
        }
        return fa;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.acG) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected String d(String str, int i, int i2) {
        return String.valueOf(this.acE) + str;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c Ce = com.baidu.tbadk.imageManager.c.Ce();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            Ce.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean vi() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vj() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel hg() {
        if (acF == null) {
            acF = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return acF;
    }
}
