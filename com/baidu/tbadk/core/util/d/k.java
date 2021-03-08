package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.lib.e.e<com.baidu.adp.widget.ImageView.a> {
    private int width = 0;
    private int height = 0;

    public k() {
        btw();
    }

    private void btw() {
        this.width = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.height = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.adp.lib.e.e
    public boolean mx() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(r(str, i, i2), com.baidu.tbadk.imageManager.c.bCS().Dp(r(str, i, i2)), i, i2);
        if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.getRawBitmap() == null || checkIsValidPicMemoryCache.getRawBitmap().isRecycled()) {
            return null;
        }
        return checkIsValidPicMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: c */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.b bVar, Object... objArr) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return q(str, i, i2);
    }

    @Override // com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a) && ((com.baidu.adp.widget.ImageView.a) obj).isNeedCache()) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aP(i);
            aVar.aQ(i2);
            com.baidu.tbadk.imageManager.c.bCS().b(r(str, i, i2), aVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: d */
    public com.baidu.adp.widget.ImageView.a b(String str, String str2, int i, int i2, com.baidu.adp.lib.e.b bVar, Object... objArr) {
        return null;
    }

    @Override // com.baidu.adp.lib.e.e
    public BdAsyncTaskParallel my() {
        return null;
    }

    @Override // com.baidu.adp.lib.e.e
    public int mz() {
        return 1;
    }

    public com.baidu.adp.widget.ImageView.a q(String str, int i, int i2) {
        Bitmap loadResizedBitmap;
        try {
            if (str.toLowerCase().endsWith(".gif")) {
                return new com.baidu.adp.widget.ImageView.a(BitmapHelper.loadBitmap(str), true, str);
            }
            if (i > 0 && i2 > 0 && i < this.width && i2 < this.height) {
                loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, i, i2);
            } else {
                loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, this.width, this.height);
            }
            return new com.baidu.adp.widget.ImageView.a(loadResizedBitmap, false, str);
        } catch (Throwable th) {
            return null;
        }
    }

    public String r(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("localimage_");
        sb.append(str);
        sb.append(':').append("w=").append(i).append("&h=").append(i2);
        return sb.toString();
    }
}
