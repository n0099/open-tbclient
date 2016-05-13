package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m extends a {
    private static BdAsyncTaskParallel ZK = null;
    private String ZJ;
    private boolean ZL;
    private boolean ZM;
    private int ZN;
    private int size;

    public m(boolean z, boolean z2, boolean z3, int i) {
        this.ZJ = null;
        this.size = 0;
        this.ZL = false;
        this.ZM = false;
        this.ZN = 0;
        float f = TbadkCoreApplication.m11getInst().getApp().getResources().getDisplayMetrics().density;
        this.ZL = z;
        this.ZM = z3;
        this.ZN = i;
        if (f < 2.0f) {
            this.ZJ = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.ZJ = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.ZJ = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.ZJ = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public boolean dI() {
        if (this.ZM) {
            return com.baidu.tbadk.core.l.ob().od();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a d(String str, String str2, Object... objArr) {
        if (this.ZL) {
            return null;
        }
        com.baidu.adp.widget.a.a fL = com.baidu.tbadk.imageManager.c.CI().fL(str);
        if (fL != null) {
            fL.xH.xJ = "memory";
            fL.xH.xK = 0L;
            fL.xH.xL = true;
            return fL;
        }
        return fL;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.g.a aVar, Object... objArr) {
        if (this.ZL) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected String c(String str, int i, int i2) {
        return String.valueOf(this.ZJ) + str;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c CI = com.baidu.tbadk.imageManager.c.CI();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            CI.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean uI() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean uJ() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public BdAsyncTaskParallel dJ() {
        if (ZK == null) {
            ZK = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return ZK;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int uK() {
        return this.ZN;
    }
}
