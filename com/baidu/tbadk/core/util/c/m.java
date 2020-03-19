package com.baidu.tbadk.core.util.c;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.img.effect.ImageOperation;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.lib.e.e<com.baidu.adp.widget.ImageView.a> {
    private int height;
    private int width;

    public m() {
        this.width = 0;
        this.height = 0;
        aHd();
    }

    public m(int i, int i2) {
        this.width = 0;
        this.height = 0;
        if (i > 0 && i2 > 0) {
            this.width = i;
            this.height = i2;
            return;
        }
        aHd();
    }

    private void aHd() {
        this.width = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.height = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.adp.lib.e.e
    public boolean gu() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(tM(str), com.baidu.tbadk.imageManager.c.aPV().vy(tM(str)), i, i2);
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
        return n(str, i, i2);
    }

    @Override // com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a) && ((com.baidu.adp.widget.ImageView.a) obj).isNeedCache()) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.ai(i);
            aVar.aj(i2);
            com.baidu.tbadk.imageManager.c.aPV().c(tM(str), aVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        return null;
    }

    @Override // com.baidu.adp.lib.e.e
    public BdAsyncTaskParallel gv() {
        return null;
    }

    @Override // com.baidu.adp.lib.e.e
    public int gw() {
        return 1;
    }

    public com.baidu.adp.widget.ImageView.a n(String str, int i, int i2) {
        com.baidu.adp.widget.ImageView.a aVar;
        try {
            if (str.toLowerCase().endsWith(".gif")) {
                aVar = new com.baidu.adp.widget.ImageView.a(BitmapHelper.loadBitmap(str), true, str);
            } else {
                aVar = new com.baidu.adp.widget.ImageView.a(BitmapHelper.checkBitmapSize(BitmapHelper.loadResizedBitmap(str, this.width, this.height), i, i2), false, str);
            }
            return aVar;
        } catch (Throwable th) {
            return null;
        }
    }

    public String tM(String str) {
        ImageOperation aK = com.baidu.tbadk.img.effect.d.aK(this.width, this.height);
        StringBuilder sb = new StringBuilder();
        sb.append("image_");
        sb.append(str);
        sb.append(':').append(aK.actionName).append('=').append(aK.actionParam);
        return sb.toString();
    }
}
