package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class n extends a {
    private static BdAsyncTaskParallel Lc = null;
    private String Lb;
    private boolean Ld;
    private boolean Le;
    private int size;

    public n(boolean z, boolean z2, boolean z3) {
        this.Lb = null;
        this.size = 0;
        this.Ld = false;
        this.Le = false;
        float f = TbadkCoreApplication.m255getInst().getApp().getResources().getDisplayMetrics().density;
        this.Ld = z;
        this.Le = z3;
        if (f < 2.0f) {
            this.Lb = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.Lb = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.Lb = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.Lb = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.g
    public boolean eh() {
        if (this.Le) {
            return com.baidu.tbadk.core.l.mc().me();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        if (this.Ld) {
            return null;
        }
        com.baidu.adp.widget.a.a em = com.baidu.tbadk.imageManager.e.vL().em(str);
        if (em != null) {
            em.vu.vw = "memory";
            em.vu.vx = 0L;
            em.vu.vy = true;
            return em;
        }
        return em;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.Ld) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected String d(String str, int i, int i2) {
        return String.valueOf(this.Lb) + str;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.g
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.e vL = com.baidu.tbadk.imageManager.e.vL();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            vL.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean qf() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean qg() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.g
    public BdAsyncTaskParallel ei() {
        if (Lc == null) {
            Lc = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return Lc;
    }
}
