package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class t extends a {
    private static BdAsyncTaskParallel bNg = null;
    private String bNf;
    private boolean bNh;
    private int bNi;
    private int size;

    public t(boolean z, boolean z2, int i) {
        this.bNf = null;
        this.size = 0;
        this.bNh = false;
        this.bNi = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.bNh = z;
        this.bNi = i;
        if (f < 2.0f) {
            this.bNf = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.bNf = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.bNf = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.bNf = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public boolean jE() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPhotoMemoryCache;
        if (this.bNh || (checkIsValidPhotoMemoryCache = BitmapHelper.checkIsValidPhotoMemoryCache(str, com.baidu.tbadk.imageManager.c.anm().pi(str), i, i2)) == null || checkIsValidPhotoMemoryCache.oy() == null || checkIsValidPhotoMemoryCache.oy().isRecycled()) {
            return null;
        }
        checkIsValidPhotoMemoryCache.Of.Oh = "memory";
        checkIsValidPhotoMemoryCache.Of.Oi = 0L;
        checkIsValidPhotoMemoryCache.Of.Oj = true;
        return checkIsValidPhotoMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.bNh) {
            return null;
        }
        return super.a(str, str2, i, i2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected String m(String str, int i, int i2) {
        return this.bNf + str;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aN(i);
            aVar.aO(i2);
            com.baidu.tbadk.imageManager.c.anm().b(str, aVar);
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
    public boolean adP() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean adQ() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel jF() {
        if (bNg == null) {
            bNg = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return bNg;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int adR() {
        return this.bNi;
    }
}
