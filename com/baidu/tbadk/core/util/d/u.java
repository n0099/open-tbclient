package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class u extends a {
    private static BdAsyncTaskParallel cXL = null;
    private String cXK;
    private boolean cXM;
    private int cXN;
    private int size;

    public u(boolean z, boolean z2, int i) {
        this.cXK = null;
        this.size = 0;
        this.cXM = false;
        this.cXN = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.cXM = z;
        this.cXN = i;
        if (f < 2.0f) {
            this.cXK = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.cXK = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.cXK = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.cXK = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.e.e
    public boolean gu() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPhotoMemoryCache;
        if (this.cXM || (checkIsValidPhotoMemoryCache = BitmapHelper.checkIsValidPhotoMemoryCache(str, com.baidu.tbadk.imageManager.c.aNs().vf(str), i, i2)) == null || checkIsValidPhotoMemoryCache.getRawBitmap() == null || checkIsValidPhotoMemoryCache.getRawBitmap().isRecycled()) {
            return null;
        }
        checkIsValidPhotoMemoryCache.zF.resourceFromType = "memory";
        checkIsValidPhotoMemoryCache.zF.costTime = 0L;
        checkIsValidPhotoMemoryCache.zF.isScuess = true;
        return checkIsValidPhotoMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        if (this.cXM) {
            return null;
        }
        return super.a(str, str2, i, i2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected String m(String str, int i, int i2) {
        return (str == null || !(str.toLowerCase().startsWith("http://") || str.toLowerCase().startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) ? this.cXK + str : str;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.af(i);
            aVar.ag(i2);
            com.baidu.tbadk.imageManager.c.aNs().b(str, aVar);
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
    public boolean aEE() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aEF() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.e.e
    public BdAsyncTaskParallel gv() {
        if (cXL == null) {
            cXL = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return cXL;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int aEG() {
        return this.cXN;
    }
}
