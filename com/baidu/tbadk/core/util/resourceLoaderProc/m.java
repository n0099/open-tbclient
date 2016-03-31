package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m extends a {
    private static BdAsyncTaskParallel aem = null;
    private String ael;
    private boolean aen;
    private boolean aeo;
    private int aep;
    private int size;

    public m(boolean z, boolean z2, boolean z3, int i) {
        this.ael = null;
        this.size = 0;
        this.aen = false;
        this.aeo = false;
        this.aep = 0;
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        this.aen = z;
        this.aeo = z3;
        this.aep = i;
        if (f < 2.0f) {
            this.ael = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.ael = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.ael = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.ael = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public boolean hu() {
        if (this.aeo) {
            return com.baidu.tbadk.core.l.qE().qG();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a c(String str, String str2, Object... objArr) {
        if (this.aen) {
            return null;
        }
        com.baidu.adp.widget.a.a fO = com.baidu.tbadk.imageManager.c.EO().fO(str);
        if (fO != null) {
            fO.Hp.Hr = "memory";
            fO.Hp.Hs = 0L;
            fO.Hp.Ht = true;
            return fO;
        }
        return fO;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.g.a aVar, Object... objArr) {
        if (this.aen) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected String c(String str, int i, int i2) {
        return String.valueOf(this.ael) + str;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c EO = com.baidu.tbadk.imageManager.c.EO();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            EO.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean xb() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean xc() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public BdAsyncTaskParallel hv() {
        if (aem == null) {
            aem = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return aem;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int xd() {
        return this.aep;
    }
}
