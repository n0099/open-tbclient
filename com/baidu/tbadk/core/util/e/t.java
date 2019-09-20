package com.baidu.tbadk.core.util.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class t extends a {
    private static BdAsyncTaskParallel bWQ = null;
    private String bWP;
    private boolean bWR;
    private int bWS;
    private int size;

    public t(boolean z, boolean z2, int i) {
        this.bWP = null;
        this.size = 0;
        this.bWR = false;
        this.bWS = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.bWR = z;
        this.bWS = i;
        if (f < 2.0f) {
            this.bWP = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.bWP = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.bWP = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.bWP = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.e.a, com.baidu.adp.lib.f.e
    public boolean iH() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.e.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPhotoMemoryCache;
        if (this.bWR || (checkIsValidPhotoMemoryCache = BitmapHelper.checkIsValidPhotoMemoryCache(str, com.baidu.tbadk.imageManager.c.atK().qR(str), i, i2)) == null || checkIsValidPhotoMemoryCache.nK() == null || checkIsValidPhotoMemoryCache.nK().isRecycled()) {
            return null;
        }
        checkIsValidPhotoMemoryCache.Mb.Md = "memory";
        checkIsValidPhotoMemoryCache.Mb.Me = 0L;
        checkIsValidPhotoMemoryCache.Mb.Mf = true;
        return checkIsValidPhotoMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.e.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.bWR) {
            return null;
        }
        return super.a(str, str2, i, i2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.e.a
    protected String m(String str, int i, int i2) {
        return this.bWP + str;
    }

    @Override // com.baidu.tbadk.core.util.e.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aG(i);
            aVar.aH(i2);
            com.baidu.tbadk.imageManager.c.atK().b(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int getWidth() {
        return this.size;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int getHeight() {
        return this.size;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean isFromCDN() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean akg() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean akh() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.e.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel iI() {
        if (bWQ == null) {
            bWQ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return bWQ;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int aki() {
        return this.bWS;
    }
}
