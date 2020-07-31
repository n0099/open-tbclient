package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class v extends a {
    private static BdAsyncTaskParallel ede = null;
    private String edd;
    private boolean edf;
    private int edg;
    private int size;

    public v(boolean z, boolean z2, int i) {
        this.edd = null;
        this.size = 0;
        this.edf = false;
        this.edg = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.edf = z;
        this.edg = i;
        if (f < 2.0f) {
            this.edd = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.edd = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.edd = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.edd = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.e.e
    public boolean lq() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPhotoMemoryCache;
        if (this.edf || (checkIsValidPhotoMemoryCache = BitmapHelper.checkIsValidPhotoMemoryCache(str, com.baidu.tbadk.imageManager.c.bkk().zU(str), i, i2)) == null || checkIsValidPhotoMemoryCache.getRawBitmap() == null || checkIsValidPhotoMemoryCache.getRawBitmap().isRecycled()) {
            return null;
        }
        checkIsValidPhotoMemoryCache.TY.resourceFromType = "memory";
        checkIsValidPhotoMemoryCache.TY.costTime = 0L;
        checkIsValidPhotoMemoryCache.TY.isScuess = true;
        return checkIsValidPhotoMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        if (this.edf) {
            return null;
        }
        return super.a(str, str2, i, i2, aVar, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.util.c.a
    public String o(String str, int i, int i2) {
        return (str == null || !(str.toLowerCase().startsWith("http://") || str.toLowerCase().startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) ? this.edd + str : str;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a) && ((com.baidu.adp.widget.ImageView.a) obj).isNeedCache()) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aD(i);
            aVar.aE(i2);
            com.baidu.tbadk.imageManager.c.bkk().b(str, aVar);
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
    public boolean bbj() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bbk() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.e.e
    public BdAsyncTaskParallel lr() {
        if (ede == null) {
            ede = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return ede;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int bbl() {
        return this.edg;
    }
}
