package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m extends a {
    private static BdAsyncTaskParallel adC = null;
    private String adB;
    private boolean adD;
    private boolean adE;
    private int adF;
    private int size;

    public m(boolean z, boolean z2, boolean z3, int i) {
        this.adB = null;
        this.size = 0;
        this.adD = false;
        this.adE = false;
        this.adF = 0;
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        this.adD = z;
        this.adE = z3;
        this.adF = i;
        if (f < 2.0f) {
            this.adB = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.adB = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.adB = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.adB = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public boolean eD() {
        if (this.adE) {
            return com.baidu.tbadk.core.l.oJ().oL();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a d(String str, String str2, Object... objArr) {
        if (this.adD) {
            return null;
        }
        com.baidu.adp.widget.a.a fV = com.baidu.tbadk.imageManager.c.DX().fV(str);
        if (fV != null) {
            fV.Ax.Az = "memory";
            fV.Ax.AA = 0L;
            fV.Ax.AB = true;
            return fV;
        }
        return fV;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.g.a aVar, Object... objArr) {
        if (this.adD) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected String c(String str, int i, int i2) {
        return String.valueOf(this.adB) + str;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c DX = com.baidu.tbadk.imageManager.c.DX();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            DX.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean vO() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vP() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public BdAsyncTaskParallel eE() {
        if (adC == null) {
            adC = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return adC;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int vQ() {
        return this.adF;
    }
}
