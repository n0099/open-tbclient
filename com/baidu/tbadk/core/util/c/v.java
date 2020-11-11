package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class v extends a {
    private static BdAsyncTaskParallel ePH = null;
    private String ePG;
    private boolean ePI;
    private int ePJ;
    private int size;

    public v(boolean z, boolean z2, int i) {
        this.ePG = null;
        this.size = 0;
        this.ePI = false;
        this.ePJ = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.ePI = z;
        this.ePJ = i;
        if (f < 2.0f) {
            this.ePG = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.ePG = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.ePG = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.ePG = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.e.e
    public boolean mV() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPhotoMemoryCache;
        if (this.ePI || (checkIsValidPhotoMemoryCache = BitmapHelper.checkIsValidPhotoMemoryCache(str, com.baidu.tbadk.imageManager.c.bBd().Ea(str), i, i2)) == null || checkIsValidPhotoMemoryCache.getRawBitmap() == null || checkIsValidPhotoMemoryCache.getRawBitmap().isRecycled()) {
            return null;
        }
        checkIsValidPhotoMemoryCache.Vn.resourceFromType = "memory";
        checkIsValidPhotoMemoryCache.Vn.costTime = 0L;
        checkIsValidPhotoMemoryCache.Vn.isScuess = true;
        return checkIsValidPhotoMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        if (this.ePI) {
            return null;
        }
        return super.a(str, str2, i, i2, aVar, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.util.c.a
    public String o(String str, int i, int i2) {
        return (str == null || !(str.toLowerCase().startsWith("http://") || str.toLowerCase().startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) ? this.ePG + str : str;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a) && ((com.baidu.adp.widget.ImageView.a) obj).isNeedCache()) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aJ(i);
            aVar.aK(i2);
            com.baidu.tbadk.imageManager.c.bBd().b(str, aVar);
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
    public boolean brG() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean brH() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.e.e
    public BdAsyncTaskParallel mW() {
        if (ePH == null) {
            ePH = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return ePH;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int brI() {
        return this.ePJ;
    }
}
