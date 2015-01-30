package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class n extends a {
    private static BdAsyncTaskParallel Lw = null;
    private String Lv;
    private boolean Lx;
    private boolean Ly;
    private int size;

    public n(boolean z, boolean z2, boolean z3) {
        this.Lv = null;
        this.size = 0;
        this.Lx = false;
        this.Ly = false;
        float f = TbadkCoreApplication.m255getInst().getApp().getResources().getDisplayMetrics().density;
        this.Lx = z;
        this.Ly = z3;
        if (f < 2.0f) {
            this.Lv = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.Lv = TbConfig.getBigPhotoAdress();
            this.size = TbConfig.BIG_PHOTO_MAX_SIZE;
        }
        if (z2) {
            this.Lv = TbConfig.getBigPhotoAdress();
            this.size = TbConfig.BIG_PHOTO_MAX_SIZE;
            return;
        }
        this.Lv = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.g
    public boolean ef() {
        if (this.Ly) {
            return com.baidu.tbadk.core.l.mc().me();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        if (this.Lx) {
            return null;
        }
        com.baidu.adp.widget.a.a em = com.baidu.tbadk.imageManager.e.we().em(str);
        if (em != null) {
            em.vA.vC = "memory";
            em.vA.vD = 0L;
            em.vA.vE = true;
            return em;
        }
        return em;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.Lx) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected String d(String str, int i, int i2) {
        return String.valueOf(this.Lv) + str;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.g
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.e we = com.baidu.tbadk.imageManager.e.we();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            we.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean qq() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean qr() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.g
    public BdAsyncTaskParallel eg() {
        if (Lw == null) {
            Lw = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return Lw;
    }
}
