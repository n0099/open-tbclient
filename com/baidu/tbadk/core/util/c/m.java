package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.r;
/* loaded from: classes.dex */
public class m extends a {
    private static BdAsyncTaskParallel ahA = null;
    private boolean ahB;
    private boolean ahC;
    private int ahD;
    private String ahz;
    private int size;

    public m(boolean z, boolean z2, boolean z3, int i) {
        this.ahz = null;
        this.size = 0;
        this.ahB = false;
        this.ahC = false;
        this.ahD = 0;
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        this.ahB = z;
        this.ahC = z3;
        this.ahD = i;
        if (f < 2.0f) {
            this.ahz = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.ahz = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.ahz = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.ahz = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public boolean fP() {
        if (this.ahC) {
            return r.oN().oP();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public com.baidu.adp.widget.a.a c(String str, String str2, Object... objArr) {
        if (this.ahB) {
            return null;
        }
        com.baidu.adp.widget.a.a fJ = com.baidu.tbadk.imageManager.c.DH().fJ(str);
        if (fJ != null) {
            fJ.Hd.Hf = "memory";
            fJ.Hd.Hg = 0L;
            fJ.Hd.Hh = true;
            return fJ;
        }
        return fJ;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.ahB) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected String c(String str, int i, int i2) {
        return String.valueOf(this.ahz) + str;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c DH = com.baidu.tbadk.imageManager.c.DH();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            DH.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean vN() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vO() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fQ() {
        if (ahA == null) {
            ahA = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return ahA;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int vP() {
        return this.ahD;
    }
}
