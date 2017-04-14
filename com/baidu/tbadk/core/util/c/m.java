package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.q;
/* loaded from: classes.dex */
public class m extends a {
    private static BdAsyncTaskParallel aiq = null;
    private String aip;
    private boolean air;
    private boolean ais;
    private int ait;
    private int size;

    public m(boolean z, boolean z2, boolean z3, int i) {
        this.aip = null;
        this.size = 0;
        this.air = false;
        this.ais = false;
        this.ait = 0;
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        this.air = z;
        this.ais = z3;
        this.ait = i;
        if (f < 2.0f) {
            this.aip = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.aip = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.aip = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.aip = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public boolean fO() {
        if (this.ais) {
            return q.po().pq();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public com.baidu.adp.widget.a.a c(String str, String str2, Object... objArr) {
        if (this.air) {
            return null;
        }
        com.baidu.adp.widget.a.a fN = com.baidu.tbadk.imageManager.c.EJ().fN(str);
        if (fN != null) {
            fN.Hb.Hd = "memory";
            fN.Hb.He = 0L;
            fN.Hb.Hf = true;
            return fN;
        }
        return fN;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.air) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected String c(String str, int i, int i2) {
        return String.valueOf(this.aip) + str;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c EJ = com.baidu.tbadk.imageManager.c.EJ();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            EJ.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean wC() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wD() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fP() {
        if (aiq == null) {
            aiq = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return aiq;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wE() {
        return this.ait;
    }
}
