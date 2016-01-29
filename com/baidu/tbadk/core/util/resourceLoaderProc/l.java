package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class l extends a {
    private static BdAsyncTaskParallel aeR = null;
    private String aeQ;
    private boolean aeS;
    private boolean aeT;
    private int aeU;
    private int size;

    public l(boolean z, boolean z2, boolean z3, int i) {
        this.aeQ = null;
        this.size = 0;
        this.aeS = false;
        this.aeT = false;
        this.aeU = 0;
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        this.aeS = z;
        this.aeT = z3;
        this.aeU = i;
        if (f < 2.0f) {
            this.aeQ = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.aeQ = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.aeQ = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.aeQ = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public boolean ho() {
        if (this.aeT) {
            return com.baidu.tbadk.core.l.rn().rp();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        if (this.aeS) {
            return null;
        }
        com.baidu.adp.widget.a.a fG = com.baidu.tbadk.imageManager.c.Ed().fG(str);
        if (fG != null) {
            fG.Hj.Hl = "memory";
            fG.Hj.Hm = 0L;
            fG.Hj.Hn = true;
            return fG;
        }
        return fG;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.g.a aVar, Object... objArr) {
        if (this.aeS) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected String c(String str, int i, int i2) {
        return String.valueOf(this.aeQ) + str;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c Ed = com.baidu.tbadk.imageManager.c.Ed();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            Ed.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean wI() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean wJ() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public BdAsyncTaskParallel hp() {
        if (aeR == null) {
            aeR = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return aeR;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int wK() {
        return this.aeU;
    }
}
