package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class n extends a {
    private static BdAsyncTaskParallel Lt = null;
    private String Ls;
    private boolean Lu;
    private boolean Lv;
    private int size;

    public n(boolean z, boolean z2, boolean z3) {
        this.Ls = null;
        this.size = 0;
        this.Lu = false;
        this.Lv = false;
        float f = TbadkCoreApplication.m255getInst().getApp().getResources().getDisplayMetrics().density;
        this.Lu = z;
        this.Lv = z3;
        if (f < 2.0f) {
            this.Ls = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.Ls = TbConfig.getBigPhotoAdress();
            this.size = TbConfig.BIG_PHOTO_MAX_SIZE;
        }
        if (z2) {
            this.Ls = TbConfig.getBigPhotoAdress();
            this.size = TbConfig.BIG_PHOTO_MAX_SIZE;
            return;
        }
        this.Ls = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.g
    public boolean ef() {
        if (this.Lv) {
            return com.baidu.tbadk.core.l.lV().lX();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        if (this.Lu) {
            return null;
        }
        com.baidu.adp.widget.a.a ej = com.baidu.tbadk.imageManager.e.vY().ej(str);
        if (ej != null) {
            ej.vx.vz = "memory";
            ej.vx.vA = 0L;
            ej.vx.vB = true;
            return ej;
        }
        return ej;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.Lu) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected String d(String str, int i, int i2) {
        return String.valueOf(this.Ls) + str;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.g
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.e vY = com.baidu.tbadk.imageManager.e.vY();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            vY.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean qj() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean qk() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.f.g
    public BdAsyncTaskParallel eg() {
        if (Lt == null) {
            Lt = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return Lt;
    }
}
