package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class t extends a {
    private static BdAsyncTaskParallel bUR = null;
    private String bUQ;
    private boolean bUS;
    private int bUT;
    private int size;

    public t(boolean z, boolean z2, int i) {
        this.bUQ = null;
        this.size = 0;
        this.bUS = false;
        this.bUT = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.bUS = z;
        this.bUT = i;
        if (f < 2.0f) {
            this.bUQ = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.bUQ = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.bUQ = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.bUQ = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public boolean iy() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPhotoMemoryCache;
        if (this.bUS || (checkIsValidPhotoMemoryCache = BitmapHelper.checkIsValidPhotoMemoryCache(str, com.baidu.tbadk.imageManager.c.asp().qq(str), i, i2)) == null || checkIsValidPhotoMemoryCache.ns() == null || checkIsValidPhotoMemoryCache.ns().isRecycled()) {
            return null;
        }
        checkIsValidPhotoMemoryCache.LO.LQ = "memory";
        checkIsValidPhotoMemoryCache.LO.LR = 0L;
        checkIsValidPhotoMemoryCache.LO.LS = true;
        return checkIsValidPhotoMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.bUS) {
            return null;
        }
        return super.a(str, str2, i, i2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected String m(String str, int i, int i2) {
        return this.bUQ + str;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aG(i);
            aVar.aH(i2);
            com.baidu.tbadk.imageManager.c.asp().b(str, aVar);
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
    public boolean aiO() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aiP() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel iz() {
        if (bUR == null) {
            bUR = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return bUR;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int aiQ() {
        return this.bUT;
    }
}
