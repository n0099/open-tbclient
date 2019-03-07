package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class t extends a {
    private static BdAsyncTaskParallel bNc = null;
    private String bNb;
    private boolean bNd;
    private int bNe;
    private int size;

    public t(boolean z, boolean z2, int i) {
        this.bNb = null;
        this.size = 0;
        this.bNd = false;
        this.bNe = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.bNd = z;
        this.bNe = i;
        if (f < 2.0f) {
            this.bNb = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.bNb = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.bNb = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.bNb = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public boolean jE() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPhotoMemoryCache;
        if (this.bNd || (checkIsValidPhotoMemoryCache = BitmapHelper.checkIsValidPhotoMemoryCache(str, com.baidu.tbadk.imageManager.c.anq().ph(str), i, i2)) == null || checkIsValidPhotoMemoryCache.oy() == null || checkIsValidPhotoMemoryCache.oy().isRecycled()) {
            return null;
        }
        checkIsValidPhotoMemoryCache.Oe.Og = "memory";
        checkIsValidPhotoMemoryCache.Oe.Oh = 0L;
        checkIsValidPhotoMemoryCache.Oe.Oi = true;
        return checkIsValidPhotoMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.bNd) {
            return null;
        }
        return super.a(str, str2, i, i2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected String m(String str, int i, int i2) {
        return this.bNb + str;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aO(i);
            aVar.aP(i2);
            com.baidu.tbadk.imageManager.c.anq().b(str, aVar);
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
    public boolean adS() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean adT() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel jF() {
        if (bNc == null) {
            bNc = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return bNc;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int adU() {
        return this.bNe;
    }
}
