package com.baidu.tbadk.core.util.c;

import android.media.ThumbnailUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.io.File;
/* loaded from: classes.dex */
public class p implements com.baidu.adp.lib.e.e<com.baidu.adp.widget.ImageView.a> {
    @Override // com.baidu.adp.lib.e.e
    public boolean la() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(wI(str), com.baidu.tbadk.imageManager.c.bet().yv(wI(str)), i, i2);
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
        return r(str, i, i2);
    }

    @Override // com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a) && ((com.baidu.adp.widget.ImageView.a) obj).isNeedCache()) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.av(i);
            aVar.aw(i2);
            com.baidu.tbadk.imageManager.c.bet().c(wI(str), aVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        return null;
    }

    @Override // com.baidu.adp.lib.e.e
    public BdAsyncTaskParallel lb() {
        return null;
    }

    @Override // com.baidu.adp.lib.e.e
    public int lc() {
        return 1;
    }

    public com.baidu.adp.widget.ImageView.a r(String str, int i, int i2) {
        try {
            File file = new File(str);
            if (file != null && file.exists()) {
                return new com.baidu.adp.widget.ImageView.a(BitmapHelper.checkBitmapSize(ThumbnailUtils.createVideoThumbnail(str, 1), i, i2), false, str);
            }
        } catch (OutOfMemoryError e) {
        }
        return null;
    }

    public String wI(String str) {
        return "videoThumb_" + str;
    }
}
