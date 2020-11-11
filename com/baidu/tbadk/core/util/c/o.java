package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class o implements com.baidu.adp.lib.e.e<com.baidu.adp.widget.ImageView.a> {
    private int width = 0;
    private int height = 0;

    public o() {
        brM();
    }

    private void brM() {
        this.width = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.height = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.adp.lib.e.e
    public boolean mV() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(q(str, i, i2), com.baidu.tbadk.imageManager.c.bBd().Eb(q(str, i, i2)), i, i2);
        if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.getRawBitmap() == null || checkIsValidPicMemoryCache.getRawBitmap().isRecycled()) {
            return null;
        }
        return checkIsValidPicMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return p(str, i, i2);
    }

    @Override // com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a) && ((com.baidu.adp.widget.ImageView.a) obj).isNeedCache()) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aJ(i);
            aVar.aK(i2);
            com.baidu.tbadk.imageManager.c.bBd().c(q(str, i, i2), aVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        return null;
    }

    @Override // com.baidu.adp.lib.e.e
    public BdAsyncTaskParallel mW() {
        return null;
    }

    @Override // com.baidu.adp.lib.e.e
    public int mX() {
        return 1;
    }

    public com.baidu.adp.widget.ImageView.a p(String str, int i, int i2) {
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

    public String q(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("localimage_");
        sb.append(str);
        sb.append(':').append("w=").append(i).append("&h=").append(i2);
        return sb.toString();
    }
}
