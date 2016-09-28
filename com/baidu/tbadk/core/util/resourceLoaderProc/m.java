package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m extends a {
    private static BdAsyncTaskParallel adL = null;
    private String adK;
    private boolean adM;
    private boolean adN;
    private int adO;
    private int size;

    public m(boolean z, boolean z2, boolean z3, int i) {
        this.adK = null;
        this.size = 0;
        this.adM = false;
        this.adN = false;
        this.adO = 0;
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        this.adM = z;
        this.adN = z3;
        this.adO = i;
        if (f < 2.0f) {
            this.adK = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.adK = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.adK = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.adK = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public boolean eD() {
        if (this.adN) {
            return com.baidu.tbadk.core.l.oH().oJ();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a d(String str, String str2, Object... objArr) {
        if (this.adM) {
            return null;
        }
        com.baidu.adp.widget.a.a fW = com.baidu.tbadk.imageManager.c.Ek().fW(str);
        if (fW != null) {
            fW.Ax.Az = "memory";
            fW.Ax.AA = 0L;
            fW.Ax.AB = true;
            return fW;
        }
        return fW;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.g.a aVar, Object... objArr) {
        if (this.adM) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected String c(String str, int i, int i2) {
        return String.valueOf(this.adK) + str;
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
    public boolean wa() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean wb() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public BdAsyncTaskParallel eE() {
        if (adL == null) {
            adL = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return adL;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int wc() {
        return this.adO;
    }
}
