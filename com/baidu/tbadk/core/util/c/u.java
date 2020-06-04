package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class u extends a {
    private static BdAsyncTaskParallel dPQ = null;
    private String dPP;
    private boolean dPR;
    private int dPS;
    private int size;

    public u(boolean z, boolean z2, int i) {
        this.dPP = null;
        this.size = 0;
        this.dPR = false;
        this.dPS = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.dPR = z;
        this.dPS = i;
        if (f < 2.0f) {
            this.dPP = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.dPP = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.dPP = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.dPP = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.e.e
    public boolean la() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPhotoMemoryCache;
        if (this.dPR || (checkIsValidPhotoMemoryCache = BitmapHelper.checkIsValidPhotoMemoryCache(str, com.baidu.tbadk.imageManager.c.beu().yu(str), i, i2)) == null || checkIsValidPhotoMemoryCache.getRawBitmap() == null || checkIsValidPhotoMemoryCache.getRawBitmap().isRecycled()) {
            return null;
        }
        checkIsValidPhotoMemoryCache.TA.resourceFromType = "memory";
        checkIsValidPhotoMemoryCache.TA.costTime = 0L;
        checkIsValidPhotoMemoryCache.TA.isScuess = true;
        return checkIsValidPhotoMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        if (this.dPR) {
            return null;
        }
        return super.a(str, str2, i, i2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected String o(String str, int i, int i2) {
        return (str == null || !(str.toLowerCase().startsWith("http://") || str.toLowerCase().startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) ? this.dPP + str : str;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a) && ((com.baidu.adp.widget.ImageView.a) obj).isNeedCache()) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.av(i);
            aVar.aw(i2);
            com.baidu.tbadk.imageManager.c.beu().b(str, aVar);
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
    public boolean aVo() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean aVp() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.e.e
    public BdAsyncTaskParallel lb() {
        if (dPQ == null) {
            dPQ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return dPQ;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int aVq() {
        return this.dPS;
    }
}
