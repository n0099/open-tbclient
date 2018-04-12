package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class r extends a {
    private static BdAsyncTaskParallel akR = null;
    private String akQ;
    private boolean akS;
    private boolean akT;
    private int akU;
    private int size;

    public r(boolean z, boolean z2, boolean z3, int i) {
        this.akQ = null;
        this.size = 0;
        this.akS = false;
        this.akT = false;
        this.akU = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.akS = z;
        this.akT = z3;
        this.akU = i;
        if (f < 2.0f) {
            this.akQ = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.akQ = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.akQ = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.akQ = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public boolean ft() {
        if (this.akT) {
            return com.baidu.tbadk.core.i.pY().qa();
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: g */
    public com.baidu.adp.widget.ImageView.a f(String str, String str2, Object... objArr) {
        if (this.akS) {
            return null;
        }
        com.baidu.adp.widget.ImageView.a gF = com.baidu.tbadk.imageManager.c.Fa().gF(str);
        if (gF != null) {
            gF.EF.EH = "memory";
            gF.EF.EI = 0L;
            gF.EF.EJ = true;
            return gF;
        }
        return gF;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.akS) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected String j(String str, int i, int i2) {
        return this.akQ + str;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c Fa = com.baidu.tbadk.imageManager.c.Fa();
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            Fa.b(str, (com.baidu.adp.widget.ImageView.a) obj);
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
    public boolean wv() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean ww() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fu() {
        if (akR == null) {
            akR = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return akR;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int wx() {
        return this.akU;
    }
}
