package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m extends a {
    private static BdAsyncTaskParallel acM = null;
    private String acL;
    private boolean acN;
    private boolean acO;
    private int acP;
    private int size;

    public m(boolean z, boolean z2, boolean z3, int i) {
        this.acL = null;
        this.size = 0;
        this.acN = false;
        this.acO = false;
        this.acP = 0;
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        this.acN = z;
        this.acO = z3;
        this.acP = i;
        if (f < 2.0f) {
            this.acL = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.acL = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.acL = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.acL = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.e
    public boolean eB() {
        if (this.acO) {
            return com.baidu.tbadk.core.l.oC().oE();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a d(String str, String str2, Object... objArr) {
        if (this.acN) {
            return null;
        }
        com.baidu.adp.widget.a.a fS = com.baidu.tbadk.imageManager.c.DS().fS(str);
        if (fS != null) {
            fS.An.Ap = "memory";
            fS.An.Aq = 0L;
            fS.An.Ar = true;
            return fS;
        }
        return fS;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.acN) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected String c(String str, int i, int i2) {
        return String.valueOf(this.acL) + str;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c DS = com.baidu.tbadk.imageManager.c.DS();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            DS.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean vI() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vJ() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel eC() {
        if (acM == null) {
            acM = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return acM;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int vK() {
        return this.acP;
    }
}
