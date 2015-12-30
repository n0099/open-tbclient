package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class l extends a {
    private static BdAsyncTaskParallel aer = null;
    private String aeq;
    private boolean aes;
    private boolean aet;
    private int size;

    public l(boolean z, boolean z2, boolean z3) {
        this.aeq = null;
        this.size = 0;
        this.aes = false;
        this.aet = false;
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        this.aes = z;
        this.aet = z3;
        if (f < 2.0f) {
            this.aeq = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.aeq = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.aeq = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.aeq = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public boolean hg() {
        if (this.aet) {
            return com.baidu.tbadk.core.m.qQ().qS();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        if (this.aes) {
            return null;
        }
        com.baidu.adp.widget.a.a fI = com.baidu.tbadk.imageManager.c.CM().fI(str);
        if (fI != null) {
            fI.GX.GZ = "memory";
            fI.GX.Ha = 0L;
            fI.GX.Hb = true;
            return fI;
        }
        return fI;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.g.a aVar, Object... objArr) {
        if (this.aes) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected String d(String str, int i, int i2) {
        return String.valueOf(this.aeq) + str;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c CM = com.baidu.tbadk.imageManager.c.CM();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            CM.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean vC() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vD() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public BdAsyncTaskParallel hh() {
        if (aer == null) {
            aer = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return aer;
    }
}
