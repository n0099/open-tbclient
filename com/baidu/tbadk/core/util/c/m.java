package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.r;
/* loaded from: classes.dex */
public class m extends a {
    private static BdAsyncTaskParallel aii = null;
    private String aih;
    private boolean aij;
    private boolean aik;
    private int ail;
    private int size;

    public m(boolean z, boolean z2, boolean z3, int i) {
        this.aih = null;
        this.size = 0;
        this.aij = false;
        this.aik = false;
        this.ail = 0;
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        this.aij = z;
        this.aik = z3;
        this.ail = i;
        if (f < 2.0f) {
            this.aih = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.aih = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.aih = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.aih = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public boolean fO() {
        if (this.aik) {
            return r.oK().oM();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public com.baidu.adp.widget.a.a c(String str, String str2, Object... objArr) {
        if (this.aij) {
            return null;
        }
        com.baidu.adp.widget.a.a gd = com.baidu.tbadk.imageManager.c.Eb().gd(str);
        if (gd != null) {
            gd.Hc.He = "memory";
            gd.Hc.Hf = 0L;
            gd.Hc.Hg = true;
            return gd;
        }
        return gd;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.aij) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected String c(String str, int i, int i2) {
        return String.valueOf(this.aih) + str;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c Eb = com.baidu.tbadk.imageManager.c.Eb();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            Eb.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean we() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wf() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fP() {
        if (aii == null) {
            aii = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return aii;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wg() {
        return this.ail;
    }
}
