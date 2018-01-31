package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class r extends a {
    private static BdAsyncTaskParallel aXP = null;
    private String aXO;
    private boolean aXQ;
    private boolean aXR;
    private int aXS;
    private int size;

    public r(boolean z, boolean z2, boolean z3, int i) {
        this.aXO = null;
        this.size = 0;
        this.aXQ = false;
        this.aXR = false;
        this.aXS = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.aXQ = z;
        this.aXR = z3;
        this.aXS = i;
        if (f < 2.0f) {
            this.aXO = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.aXO = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.aXO = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.aXO = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public boolean np() {
        if (this.aXR) {
            return com.baidu.tbadk.core.i.wB().wD();
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: g */
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        if (this.aXQ) {
            return null;
        }
        com.baidu.adp.widget.a.a gE = com.baidu.tbadk.imageManager.c.LR().gE(str);
        if (gE != null) {
            gE.aup.aur = "memory";
            gE.aup.aus = 0L;
            gE.aup.aut = true;
            return gE;
        }
        return gE;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.aXQ) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected String i(String str, int i, int i2) {
        return this.aXO + str;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c LR = com.baidu.tbadk.imageManager.c.LR();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            LR.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean Dp() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Dq() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel nq() {
        if (aXP == null) {
            aXP = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return aXP;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Dr() {
        return this.aXS;
    }
}
