package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class t extends a {
    private static BdAsyncTaskParallel aAq = null;
    private String aAp;
    private boolean aAr;
    private int aAs;
    private int size;

    public t(boolean z, boolean z2, int i) {
        this.aAp = null;
        this.size = 0;
        this.aAr = false;
        this.aAs = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.aAr = z;
        this.aAs = i;
        if (f < 2.0f) {
            this.aAp = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.aAp = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.aAp = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.aAp = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public boolean jF() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPhotoMemoryCache;
        if (this.aAr || (checkIsValidPhotoMemoryCache = BitmapHelper.checkIsValidPhotoMemoryCache(str, com.baidu.tbadk.imageManager.c.Me().hN(str), i, i2)) == null || checkIsValidPhotoMemoryCache.os() == null || checkIsValidPhotoMemoryCache.os().isRecycled()) {
            return null;
        }
        checkIsValidPhotoMemoryCache.NF.NH = "memory";
        checkIsValidPhotoMemoryCache.NF.NI = 0L;
        checkIsValidPhotoMemoryCache.NF.NJ = true;
        return checkIsValidPhotoMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.aAr) {
            return null;
        }
        return super.a(str, str2, i, i2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected String l(String str, int i, int i2) {
        return this.aAp + str;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aN(i);
            aVar.aO(i2);
            com.baidu.tbadk.imageManager.c.Me().b(str, aVar);
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
    public boolean Dk() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Dl() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel jG() {
        if (aAq == null) {
            aAq = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return aAq;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Dm() {
        return this.aAs;
    }
}
