package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m extends a {
    private static BdAsyncTaskParallel aaK = null;
    private String aaJ;
    private boolean aaL;
    private boolean aaM;
    private int aaN;
    private int size;

    public m(boolean z, boolean z2, boolean z3, int i) {
        this.aaJ = null;
        this.size = 0;
        this.aaL = false;
        this.aaM = false;
        this.aaN = 0;
        float f = TbadkCoreApplication.m10getInst().getApp().getResources().getDisplayMetrics().density;
        this.aaL = z;
        this.aaM = z3;
        this.aaN = i;
        if (f < 2.0f) {
            this.aaJ = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.aaJ = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.aaJ = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.aaJ = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public boolean dI() {
        if (this.aaM) {
            return com.baidu.tbadk.core.l.nL().nN();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a d(String str, String str2, Object... objArr) {
        if (this.aaL) {
            return null;
        }
        com.baidu.adp.widget.a.a fP = com.baidu.tbadk.imageManager.c.CP().fP(str);
        if (fP != null) {
            fP.yk.ym = "memory";
            fP.yk.yn = 0L;
            fP.yk.yo = true;
            return fP;
        }
        return fP;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.g.a aVar, Object... objArr) {
        if (this.aaL) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected String c(String str, int i, int i2) {
        return String.valueOf(this.aaJ) + str;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c CP = com.baidu.tbadk.imageManager.c.CP();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            CP.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean uH() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean uI() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public BdAsyncTaskParallel dJ() {
        if (aaK == null) {
            aaK = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return aaK;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int uJ() {
        return this.aaN;
    }
}
