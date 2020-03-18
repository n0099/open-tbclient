package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class u extends a {
    private static BdAsyncTaskParallel dcp = null;
    private String dco;
    private boolean dcq;
    private int dcr;
    private int size;

    public u(boolean z, boolean z2, int i) {
        this.dco = null;
        this.size = 0;
        this.dcq = false;
        this.dcr = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.dcq = z;
        this.dcr = i;
        if (f < 2.0f) {
            this.dco = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.dco = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.dco = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.dco = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.e.e
    public boolean gu() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPhotoMemoryCache;
        if (this.dcq || (checkIsValidPhotoMemoryCache = BitmapHelper.checkIsValidPhotoMemoryCache(str, com.baidu.tbadk.imageManager.c.aPV().vw(str), i, i2)) == null || checkIsValidPhotoMemoryCache.getRawBitmap() == null || checkIsValidPhotoMemoryCache.getRawBitmap().isRecycled()) {
            return null;
        }
        checkIsValidPhotoMemoryCache.zX.resourceFromType = "memory";
        checkIsValidPhotoMemoryCache.zX.costTime = 0L;
        checkIsValidPhotoMemoryCache.zX.isScuess = true;
        return checkIsValidPhotoMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        if (this.dcq) {
            return null;
        }
        return super.a(str, str2, i, i2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected String m(String str, int i, int i2) {
        return (str == null || !(str.toLowerCase().startsWith("http://") || str.toLowerCase().startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) ? this.dco + str : str;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a) && ((com.baidu.adp.widget.ImageView.a) obj).isNeedCache()) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.ai(i);
            aVar.aj(i2);
            com.baidu.tbadk.imageManager.c.aPV().b(str, aVar);
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
    public boolean aGX() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean aGY() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.e.e
    public BdAsyncTaskParallel gv() {
        if (dcp == null) {
            dcp = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return dcp;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int aGZ() {
        return this.dcr;
    }
}
