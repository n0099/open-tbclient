package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m extends a {
    private static BdAsyncTaskParallel acP = null;
    private String acO;
    private boolean acQ;
    private boolean acR;
    private int size;

    public m(boolean z, boolean z2, boolean z3) {
        this.acO = null;
        this.size = 0;
        this.acQ = false;
        this.acR = false;
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        this.acQ = z;
        this.acR = z3;
        if (f < 2.0f) {
            this.acO = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.acO = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.acO = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.acO = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.e
    public boolean hd() {
        if (this.acR) {
            return com.baidu.tbadk.core.m.qU().qW();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        if (this.acQ) {
            return null;
        }
        com.baidu.adp.widget.a.a fn = com.baidu.tbadk.imageManager.c.Cc().fn(str);
        if (fn != null) {
            fn.Go.Gq = "memory";
            fn.Go.Gr = 0L;
            fn.Go.Gs = true;
            return fn;
        }
        return fn;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.acQ) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected String d(String str, int i, int i2) {
        return String.valueOf(this.acO) + str;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c Cc = com.baidu.tbadk.imageManager.c.Cc();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            Cc.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public BdAsyncTaskParallel he() {
        if (acP == null) {
            acP = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return acP;
    }
}
