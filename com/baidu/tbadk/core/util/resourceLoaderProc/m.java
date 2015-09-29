package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m extends a {
    private static BdAsyncTaskParallel acO = null;
    private String acN;
    private boolean acP;
    private boolean acQ;
    private int size;

    public m(boolean z, boolean z2, boolean z3) {
        this.acN = null;
        this.size = 0;
        this.acP = false;
        this.acQ = false;
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        this.acP = z;
        this.acQ = z3;
        if (f < 2.0f) {
            this.acN = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.acN = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.acN = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.acN = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.e
    public boolean hd() {
        if (this.acQ) {
            return com.baidu.tbadk.core.m.qX().qZ();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        if (this.acP) {
            return null;
        }
        com.baidu.adp.widget.a.a fn = com.baidu.tbadk.imageManager.c.Cf().fn(str);
        if (fn != null) {
            fn.Gn.Gp = "memory";
            fn.Gn.Gq = 0L;
            fn.Gn.Gr = true;
            return fn;
        }
        return fn;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.acP) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected String d(String str, int i, int i2) {
        return String.valueOf(this.acN) + str;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c Cf = com.baidu.tbadk.imageManager.c.Cf();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            Cf.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean vl() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vm() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel he() {
        if (acO == null) {
            acO = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return acO;
    }
}
