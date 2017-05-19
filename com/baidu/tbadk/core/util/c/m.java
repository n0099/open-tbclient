package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.r;
/* loaded from: classes.dex */
public class m extends a {
    private static BdAsyncTaskParallel ahJ = null;
    private String ahI;
    private boolean ahK;
    private boolean ahL;
    private int ahM;
    private int size;

    public m(boolean z, boolean z2, boolean z3, int i) {
        this.ahI = null;
        this.size = 0;
        this.ahK = false;
        this.ahL = false;
        this.ahM = 0;
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        this.ahK = z;
        this.ahL = z3;
        this.ahM = i;
        if (f < 2.0f) {
            this.ahI = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.ahI = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.ahI = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.ahI = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public boolean fP() {
        if (this.ahL) {
            return r.oV().oX();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public com.baidu.adp.widget.a.a c(String str, String str2, Object... objArr) {
        if (this.ahK) {
            return null;
        }
        com.baidu.adp.widget.a.a fK = com.baidu.tbadk.imageManager.c.DN().fK(str);
        if (fK != null) {
            fK.Hd.Hf = "memory";
            fK.Hd.Hg = 0L;
            fK.Hd.Hh = true;
            return fK;
        }
        return fK;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.ahK) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected String c(String str, int i, int i2) {
        return String.valueOf(this.ahI) + str;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c DN = com.baidu.tbadk.imageManager.c.DN();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            DN.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean vQ() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vR() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fQ() {
        if (ahJ == null) {
            ahJ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return ahJ;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int vS() {
        return this.ahM;
    }
}
