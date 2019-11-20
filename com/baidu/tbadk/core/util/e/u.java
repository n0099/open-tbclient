package com.baidu.tbadk.core.util.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class u extends a {
    private static BdAsyncTaskParallel cld = null;
    private String clc;
    private boolean cle;
    private int clf;
    private int size;

    public u(boolean z, boolean z2, int i) {
        this.clc = null;
        this.size = 0;
        this.cle = false;
        this.clf = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.cle = z;
        this.clf = i;
        if (f < 2.0f) {
            this.clc = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.clc = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.clc = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.clc = TbConfig.getPhotoSmallAddress();
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
        if (this.cle || (checkIsValidPhotoMemoryCache = BitmapHelper.checkIsValidPhotoMemoryCache(str, com.baidu.tbadk.imageManager.c.avs().pX(str), i, i2)) == null || checkIsValidPhotoMemoryCache.getRawBitmap() == null || checkIsValidPhotoMemoryCache.getRawBitmap().isRecycled()) {
            return null;
        }
        checkIsValidPhotoMemoryCache.xd.resourceFromType = "memory";
        checkIsValidPhotoMemoryCache.xd.costTime = 0L;
        checkIsValidPhotoMemoryCache.xd.isScuess = true;
        return checkIsValidPhotoMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.e.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.cle) {
            return null;
        }
        return super.a(str, str2, i, i2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.e.a
    protected String l(String str, int i, int i2) {
        return this.clc + str;
    }

    @Override // com.baidu.tbadk.core.util.e.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.ac(i);
            aVar.ad(i2);
            com.baidu.tbadk.imageManager.c.avs().b(str, aVar);
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
    public boolean ang() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean anh() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.e.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fX() {
        if (cld == null) {
            cld = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return cld;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int ani() {
        return this.clf;
    }
}
