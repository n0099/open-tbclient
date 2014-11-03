package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class m extends a {
    private static BdAsyncTaskParallel GS = null;
    private String GR;
    private boolean GT;
    private boolean GU;
    private int size;

    public m(boolean z, boolean z2, boolean z3) {
        this.GR = null;
        this.size = 0;
        this.GT = false;
        this.GU = false;
        float f = TbadkApplication.m251getInst().getApp().getResources().getDisplayMetrics().density;
        this.GT = z;
        this.GU = z3;
        if (f < 2.0f) {
            this.GR = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.GR = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.GR = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.GR = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.g
    public boolean eh() {
        if (this.GU) {
            return com.baidu.tbadk.core.l.js().ju();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
        if (this.GT) {
            return null;
        }
        com.baidu.adp.widget.a.a ds = com.baidu.tbadk.imageManager.e.si().ds(str);
        if (ds != null) {
            ds.tj.tl = "memory";
            ds.tj.tm = 0L;
            ds.tj.tn = true;
            return ds;
        }
        return ds;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.GT) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected String c(String str, int i, int i2) {
        return String.valueOf(this.GR) + str;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.g
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.e si = com.baidu.tbadk.imageManager.e.si();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            si.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean nk() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean nl() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.g
    public BdAsyncTaskParallel ei() {
        if (GS == null) {
            GS = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return GS;
    }
}
