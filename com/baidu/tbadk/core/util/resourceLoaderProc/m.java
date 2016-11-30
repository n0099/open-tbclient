package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m extends a {
    private static BdAsyncTaskParallel aej = null;
    private String aei;
    private boolean aek;
    private boolean ael;
    private int aem;
    private int size;

    public m(boolean z, boolean z2, boolean z3, int i) {
        this.aei = null;
        this.size = 0;
        this.aek = false;
        this.ael = false;
        this.aem = 0;
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        this.aek = z;
        this.ael = z3;
        this.aem = i;
        if (f < 2.0f) {
            this.aei = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.aei = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.aei = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.aei = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public boolean eD() {
        if (this.ael) {
            return com.baidu.tbadk.core.l.oJ().oL();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a d(String str, String str2, Object... objArr) {
        if (this.aek) {
            return null;
        }
        com.baidu.adp.widget.a.a fZ = com.baidu.tbadk.imageManager.c.Ep().fZ(str);
        if (fZ != null) {
            fZ.Ax.Az = "memory";
            fZ.Ax.AA = 0L;
            fZ.Ax.AB = true;
            return fZ;
        }
        return fZ;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.g.a aVar, Object... objArr) {
        if (this.aek) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected String c(String str, int i, int i2) {
        return String.valueOf(this.aei) + str;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c Ep = com.baidu.tbadk.imageManager.c.Ep();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            Ep.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean we() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean wf() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.g.e
    public BdAsyncTaskParallel eE() {
        if (aej == null) {
            aej = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return aej;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int wg() {
        return this.aem;
    }
}
