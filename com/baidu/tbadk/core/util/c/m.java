package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.q;
/* loaded from: classes.dex */
public class m extends a {
    private static BdAsyncTaskParallel air = null;
    private String aiq;
    private boolean ais;
    private boolean ait;
    private int aiu;
    private int size;

    public m(boolean z, boolean z2, boolean z3, int i) {
        this.aiq = null;
        this.size = 0;
        this.ais = false;
        this.ait = false;
        this.aiu = 0;
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        this.ais = z;
        this.ait = z3;
        this.aiu = i;
        if (f < 2.0f) {
            this.aiq = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.aiq = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.aiq = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.aiq = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public boolean fP() {
        if (this.ait) {
            return q.po().pq();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public com.baidu.adp.widget.a.a c(String str, String str2, Object... objArr) {
        if (this.ais) {
            return null;
        }
        com.baidu.adp.widget.a.a fN = com.baidu.tbadk.imageManager.c.EJ().fN(str);
        if (fN != null) {
            fN.Hd.Hf = "memory";
            fN.Hd.Hg = 0L;
            fN.Hd.Hh = true;
            return fN;
        }
        return fN;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.ais) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected String c(String str, int i, int i2) {
        return String.valueOf(this.aiq) + str;
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
    public BdAsyncTaskParallel fQ() {
        if (air == null) {
            air = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return air;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wE() {
        return this.aiu;
    }
}
