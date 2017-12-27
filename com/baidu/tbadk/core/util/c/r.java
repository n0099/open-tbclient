package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class r extends a {
    private static BdAsyncTaskParallel aXI = null;
    private String aXH;
    private boolean aXJ;
    private boolean aXK;
    private int aXL;
    private int size;

    public r(boolean z, boolean z2, boolean z3, int i) {
        this.aXH = null;
        this.size = 0;
        this.aXJ = false;
        this.aXK = false;
        this.aXL = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.aXJ = z;
        this.aXK = z3;
        this.aXL = i;
        if (f < 2.0f) {
            this.aXH = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.aXH = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.aXH = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.aXH = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public boolean no() {
        if (this.aXK) {
            return com.baidu.tbadk.core.i.wB().wD();
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: g */
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        if (this.aXJ) {
            return null;
        }
        com.baidu.adp.widget.a.a gw = com.baidu.tbadk.imageManager.c.Mb().gw(str);
        if (gw != null) {
            gw.aun.aup = "memory";
            gw.aun.auq = 0L;
            gw.aun.aur = true;
            return gw;
        }
        return gw;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.aXJ) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected String i(String str, int i, int i2) {
        return this.aXH + str;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c Mb = com.baidu.tbadk.imageManager.c.Mb();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            Mb.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean Dw() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean Dx() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel np() {
        if (aXI == null) {
            aXI = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return aXI;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int Dy() {
        return this.aXL;
    }
}
