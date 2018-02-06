package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class r extends a {
    private static BdAsyncTaskParallel aZy = null;
    private boolean aZA;
    private int aZB;
    private String aZx;
    private boolean aZz;
    private int size;

    public r(boolean z, boolean z2, boolean z3, int i) {
        this.aZx = null;
        this.size = 0;
        this.aZz = false;
        this.aZA = false;
        this.aZB = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.aZz = z;
        this.aZA = z3;
        this.aZB = i;
        if (f < 2.0f) {
            this.aZx = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.aZx = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.aZx = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.aZx = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public boolean np() {
        if (this.aZA) {
            return com.baidu.tbadk.core.i.xo().xq();
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: g */
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        if (this.aZz) {
            return null;
        }
        com.baidu.adp.widget.a.a gO = com.baidu.tbadk.imageManager.c.Mx().gO(str);
        if (gO != null) {
            gO.auk.aum = "memory";
            gO.auk.aun = 0L;
            gO.auk.auo = true;
            return gO;
        }
        return gO;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.aZz) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected String i(String str, int i, int i2) {
        return this.aZx + str;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c Mx = com.baidu.tbadk.imageManager.c.Mx();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            Mx.b(str, (com.baidu.adp.widget.a.a) obj);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.size;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return this.size;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean DJ() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean DK() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel nq() {
        if (aZy == null) {
            aZy = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return aZy;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int DL() {
        return this.aZB;
    }
}
