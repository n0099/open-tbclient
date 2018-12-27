package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class t extends a {
    private static BdAsyncTaskParallel aEG = null;
    private String aEF;
    private boolean aEH;
    private int aEI;
    private int size;

    public t(boolean z, boolean z2, int i) {
        this.aEF = null;
        this.size = 0;
        this.aEH = false;
        this.aEI = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.aEH = z;
        this.aEI = i;
        if (f < 2.0f) {
            this.aEF = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.aEF = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.aEF = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.aEF = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public boolean jD() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPhotoMemoryCache;
        if (this.aEH || (checkIsValidPhotoMemoryCache = BitmapHelper.checkIsValidPhotoMemoryCache(str, com.baidu.tbadk.imageManager.c.Nv().ih(str), i, i2)) == null || checkIsValidPhotoMemoryCache.op() == null || checkIsValidPhotoMemoryCache.op().isRecycled()) {
            return null;
        }
        checkIsValidPhotoMemoryCache.NI.NK = "memory";
        checkIsValidPhotoMemoryCache.NI.NL = 0L;
        checkIsValidPhotoMemoryCache.NI.NM = true;
        return checkIsValidPhotoMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.aEH) {
            return null;
        }
        return super.a(str, str2, i, i2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected String n(String str, int i, int i2) {
        return this.aEF + str;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.be(i);
            aVar.bf(i2);
            com.baidu.tbadk.imageManager.c.Nv().b(str, aVar);
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
    public boolean Ev() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Ew() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel jE() {
        if (aEG == null) {
            aEG = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return aEG;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Ex() {
        return this.aEI;
    }
}
