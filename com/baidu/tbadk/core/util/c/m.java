package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m extends a {
    private static BdAsyncTaskParallel aiE = null;
    private String aiD;
    private boolean aiF;
    private boolean aiG;
    private int aiH;
    private int size;

    public m(boolean z, boolean z2, boolean z3, int i) {
        this.aiD = null;
        this.size = 0;
        this.aiF = false;
        this.aiG = false;
        this.aiH = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.aiF = z;
        this.aiG = z3;
        this.aiH = i;
        if (f < 2.0f) {
            this.aiD = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.aiD = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.aiD = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.aiD = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public boolean fM() {
        if (this.aiG) {
            return com.baidu.tbadk.core.h.oN().oP();
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: c */
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
        if (this.aiF) {
            return null;
        }
        com.baidu.adp.widget.a.a gj = com.baidu.tbadk.imageManager.c.Ep().gj(str);
        if (gj != null) {
            gj.Hc.He = "memory";
            gj.Hc.Hf = 0L;
            gj.Hc.Hg = true;
            return gj;
        }
        return gj;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.aiF) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected String c(String str, int i, int i2) {
        return this.aiD + str;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c Ep = com.baidu.tbadk.imageManager.c.Ep();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            Ep.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean wk() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wl() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fN() {
        if (aiE == null) {
            aiE = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return aiE;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wm() {
        return this.aiH;
    }
}
