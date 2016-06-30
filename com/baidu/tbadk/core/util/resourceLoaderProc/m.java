package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m extends a {
    private static BdAsyncTaskParallel aab = null;
    private String aaa;
    private boolean aac;
    private boolean aad;
    private int aae;
    private int size;

    public m(boolean z, boolean z2, boolean z3, int i) {
        this.aaa = null;
        this.size = 0;
        this.aac = false;
        this.aad = false;
        this.aae = 0;
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        this.aac = z;
        this.aad = z3;
        this.aae = i;
        if (f < 2.0f) {
            this.aaa = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.aaa = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.aaa = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.aaa = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public boolean dJ() {
        if (this.aad) {
            return com.baidu.tbadk.core.l.nW().nY();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a d(String str, String str2, Object... objArr) {
        if (this.aac) {
            return null;
        }
        com.baidu.adp.widget.a.a fR = com.baidu.tbadk.imageManager.c.CQ().fR(str);
        if (fR != null) {
            fR.xJ.xL = "memory";
            fR.xJ.xM = 0L;
            fR.xJ.xN = true;
            return fR;
        }
        return fR;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.g.a aVar, Object... objArr) {
        if (this.aac) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected String c(String str, int i, int i2) {
        return String.valueOf(this.aaa) + str;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c CQ = com.baidu.tbadk.imageManager.c.CQ();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            CQ.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public BdAsyncTaskParallel dK() {
        if (aab == null) {
            aab = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return aab;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int uJ() {
        return this.aae;
    }
}
