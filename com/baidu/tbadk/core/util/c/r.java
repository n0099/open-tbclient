package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class r extends a {
    private static BdAsyncTaskParallel aXH = null;
    private String aXG;
    private boolean aXI;
    private boolean aXJ;
    private int aXK;
    private int size;

    public r(boolean z, boolean z2, boolean z3, int i) {
        this.aXG = null;
        this.size = 0;
        this.aXI = false;
        this.aXJ = false;
        this.aXK = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.aXI = z;
        this.aXJ = z3;
        this.aXK = i;
        if (f < 2.0f) {
            this.aXG = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.aXG = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.aXG = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.aXG = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public boolean no() {
        if (this.aXJ) {
            return com.baidu.tbadk.core.i.wA().wC();
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: g */
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        if (this.aXI) {
            return null;
        }
        com.baidu.adp.widget.a.a gx = com.baidu.tbadk.imageManager.c.LP().gx(str);
        if (gx != null) {
            gx.aum.auo = "memory";
            gx.aum.aup = 0L;
            gx.aum.auq = true;
            return gx;
        }
        return gx;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.aXI) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected String i(String str, int i, int i2) {
        return this.aXG + str;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c LP = com.baidu.tbadk.imageManager.c.LP();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            LP.b(str, (com.baidu.adp.widget.a.a) obj);
        }
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return this.size;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return this.size;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean Dn() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean Do() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel np() {
        if (aXH == null) {
            aXH = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return aXH;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int Dp() {
        return this.aXK;
    }
}
