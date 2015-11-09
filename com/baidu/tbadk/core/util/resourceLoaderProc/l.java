package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class l extends a {
    private static BdAsyncTaskParallel acU = null;
    private String acT;
    private boolean acV;
    private boolean acW;
    private int size;

    public l(boolean z, boolean z2, boolean z3) {
        this.acT = null;
        this.size = 0;
        this.acV = false;
        this.acW = false;
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        this.acV = z;
        this.acW = z3;
        if (f < 2.0f) {
            this.acT = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.acT = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.acT = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.acT = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.e
    public boolean he() {
        if (this.acW) {
            return com.baidu.tbadk.core.m.qV().qX();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        if (this.acV) {
            return null;
        }
        com.baidu.adp.widget.a.a fp = com.baidu.tbadk.imageManager.c.BV().fp(str);
        if (fp != null) {
            fp.Gp.Gr = "memory";
            fp.Gp.Gs = 0L;
            fp.Gp.Gt = true;
            return fp;
        }
        return fp;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.acV) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected String d(String str, int i, int i2) {
        return String.valueOf(this.acT) + str;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c BV = com.baidu.tbadk.imageManager.c.BV();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            BV.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean vm() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vn() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel hf() {
        if (acU == null) {
            acU = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return acU;
    }
}
