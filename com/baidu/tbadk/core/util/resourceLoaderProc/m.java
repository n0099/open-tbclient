package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m extends a {
    private static BdAsyncTaskParallel adA = null;
    private boolean adB;
    private boolean adC;
    private int adD;
    private String adz;
    private int size;

    public m(boolean z, boolean z2, boolean z3, int i) {
        this.adz = null;
        this.size = 0;
        this.adB = false;
        this.adC = false;
        this.adD = 0;
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        this.adB = z;
        this.adC = z3;
        this.adD = i;
        if (f < 2.0f) {
            this.adz = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.adz = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.adz = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.adz = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public boolean eD() {
        if (this.adC) {
            return com.baidu.tbadk.core.l.oG().oI();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a d(String str, String str2, Object... objArr) {
        if (this.adB) {
            return null;
        }
        com.baidu.adp.widget.a.a fS = com.baidu.tbadk.imageManager.c.Ek().fS(str);
        if (fS != null) {
            fS.Ax.Az = "memory";
            fS.Ax.AA = 0L;
            fS.Ax.AB = true;
            return fS;
        }
        return fS;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.g.a aVar, Object... objArr) {
        if (this.adB) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected String c(String str, int i, int i2) {
        return String.valueOf(this.adz) + str;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c Ek = com.baidu.tbadk.imageManager.c.Ek();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            Ek.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean vM() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vN() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public BdAsyncTaskParallel eE() {
        if (adA == null) {
            adA = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return adA;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int vO() {
        return this.adD;
    }
}
