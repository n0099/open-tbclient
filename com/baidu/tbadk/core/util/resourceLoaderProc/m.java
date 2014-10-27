package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class m extends a {
    private static BdAsyncTaskParallel GR = null;
    private String GQ;
    private boolean GS;
    private boolean GT;
    private int size;

    public m(boolean z, boolean z2, boolean z3) {
        this.GQ = null;
        this.size = 0;
        this.GS = false;
        this.GT = false;
        float f = TbadkApplication.m251getInst().getApp().getResources().getDisplayMetrics().density;
        this.GS = z;
        this.GT = z3;
        if (f < 2.0f) {
            this.GQ = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.GQ = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.GQ = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.GQ = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.g
    public boolean eh() {
        if (this.GT) {
            return com.baidu.tbadk.core.k.js().ju();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
        if (this.GS) {
            return null;
        }
        com.baidu.adp.widget.a.a ds = com.baidu.tbadk.imageManager.e.sg().ds(str);
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
        if (this.GS) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected String c(String str, int i, int i2) {
        return String.valueOf(this.GQ) + str;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.g
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.e sg = com.baidu.tbadk.imageManager.e.sg();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            sg.b(str, (com.baidu.adp.widget.a.a) obj);
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
        if (GR == null) {
            GR = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return GR;
    }
}
