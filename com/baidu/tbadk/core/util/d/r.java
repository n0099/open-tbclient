package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class r extends a {
    private static BdAsyncTaskParallel aZm = null;
    private String aZl;
    private boolean aZn;
    private boolean aZo;
    private int aZp;
    private int size;

    public r(boolean z, boolean z2, boolean z3, int i) {
        this.aZl = null;
        this.size = 0;
        this.aZn = false;
        this.aZo = false;
        this.aZp = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.aZn = z;
        this.aZo = z3;
        this.aZp = i;
        if (f < 2.0f) {
            this.aZl = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.aZl = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.aZl = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.aZl = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public boolean np() {
        if (this.aZo) {
            return com.baidu.tbadk.core.i.xo().xq();
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: g */
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        if (this.aZn) {
            return null;
        }
        com.baidu.adp.widget.a.a gO = com.baidu.tbadk.imageManager.c.Mw().gO(str);
        if (gO != null) {
            gO.aub.aud = "memory";
            gO.aub.aue = 0L;
            gO.aub.auf = true;
            return gO;
        }
        return gO;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.aZn) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected String i(String str, int i, int i2) {
        return this.aZl + str;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c Mw = com.baidu.tbadk.imageManager.c.Mw();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            Mw.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean DI() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean DJ() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel nq() {
        if (aZm == null) {
            aZm = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return aZm;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int DK() {
        return this.aZp;
    }
}
