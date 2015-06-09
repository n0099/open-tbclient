package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class n extends a {
    private static BdAsyncTaskParallel XI = null;
    private String XH;
    private boolean XJ;
    private boolean XK;
    private int size;

    public n(boolean z, boolean z2, boolean z3) {
        this.XH = null;
        this.size = 0;
        this.XJ = false;
        this.XK = false;
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        this.XJ = z;
        this.XK = z3;
        if (f < 2.0f) {
            this.XH = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.XH = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.XH = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.XH = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.g
    public boolean ho() {
        if (this.XK) {
            return com.baidu.tbadk.core.n.qc().qe();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        if (this.XJ) {
            return null;
        }
        com.baidu.adp.widget.a.a eK = com.baidu.tbadk.imageManager.e.Am().eK(str);
        if (eK != null) {
            eK.Gm.Go = "memory";
            eK.Gm.Gp = 0L;
            eK.Gm.Gq = true;
            return eK;
        }
        return eK;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.XJ) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected String d(String str, int i, int i2) {
        return String.valueOf(this.XH) + str;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.g
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.e Am = com.baidu.tbadk.imageManager.e.Am();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            Am.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean ue() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean uf() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.g
    public BdAsyncTaskParallel hp() {
        if (XI == null) {
            XI = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return XI;
    }
}
