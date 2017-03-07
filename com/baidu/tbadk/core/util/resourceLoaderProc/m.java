package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m extends a {
    private static BdAsyncTaskParallel aic = null;
    private String aib;
    private boolean aid;
    private boolean aie;
    private int aif;
    private int size;

    public m(boolean z, boolean z2, boolean z3, int i) {
        this.aib = null;
        this.size = 0;
        this.aid = false;
        this.aie = false;
        this.aif = 0;
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        this.aid = z;
        this.aie = z3;
        this.aif = i;
        if (f < 2.0f) {
            this.aib = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.aib = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.aib = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.aib = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.e
    public boolean fJ() {
        if (this.aie) {
            return com.baidu.tbadk.core.l.oQ().oS();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a c(String str, String str2, Object... objArr) {
        if (this.aid) {
            return null;
        }
        com.baidu.adp.widget.a.a fH = com.baidu.tbadk.imageManager.c.El().fH(str);
        if (fH != null) {
            fH.HA.HC = "memory";
            fH.HA.HD = 0L;
            fH.HA.HE = true;
            return fH;
        }
        return fH;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.aid) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected String c(String str, int i, int i2) {
        return String.valueOf(this.aib) + str;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c El = com.baidu.tbadk.imageManager.c.El();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            El.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean wf() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean wg() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fK() {
        if (aic == null) {
            aic = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return aic;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int wh() {
        return this.aif;
    }
}
