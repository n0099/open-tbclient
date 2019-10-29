package com.baidu.tbadk.core.util.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class u extends a {
    private static BdAsyncTaskParallel clU = null;
    private String clT;
    private boolean clV;
    private int clW;
    private int size;

    public u(boolean z, boolean z2, int i) {
        this.clT = null;
        this.size = 0;
        this.clV = false;
        this.clW = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.clV = z;
        this.clW = i;
        if (f < 2.0f) {
            this.clT = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.clT = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.clT = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.clT = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.e.a, com.baidu.adp.lib.f.e
    public boolean fW() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.e.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPhotoMemoryCache;
        if (this.clV || (checkIsValidPhotoMemoryCache = BitmapHelper.checkIsValidPhotoMemoryCache(str, com.baidu.tbadk.imageManager.c.avu().pX(str), i, i2)) == null || checkIsValidPhotoMemoryCache.getRawBitmap() == null || checkIsValidPhotoMemoryCache.getRawBitmap().isRecycled()) {
            return null;
        }
        checkIsValidPhotoMemoryCache.xD.resourceFromType = "memory";
        checkIsValidPhotoMemoryCache.xD.costTime = 0L;
        checkIsValidPhotoMemoryCache.xD.isScuess = true;
        return checkIsValidPhotoMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.e.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.clV) {
            return null;
        }
        return super.a(str, str2, i, i2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.e.a
    protected String l(String str, int i, int i2) {
        return this.clT + str;
    }

    @Override // com.baidu.tbadk.core.util.e.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.ac(i);
            aVar.ad(i2);
            com.baidu.tbadk.imageManager.c.avu().b(str, aVar);
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
    public boolean ani() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean anj() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.e.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fX() {
        if (clU == null) {
            clU = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return clU;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int ank() {
        return this.clW;
    }
}
