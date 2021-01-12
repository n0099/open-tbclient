package com.baidu.tbadk.core.util.d;

import android.media.ThumbnailUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.io.File;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.lib.e.e<com.baidu.adp.widget.ImageView.a> {
    @Override // com.baidu.adp.lib.e.e
    public boolean my() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(Be(str), com.baidu.tbadk.imageManager.c.bCx().CT(Be(str)), i, i2);
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
        return s(str, i, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: d */
    public com.baidu.adp.widget.ImageView.a b(String str, String str2, int i, int i2, com.baidu.adp.lib.e.b bVar, Object... objArr) {
        return null;
    }

    @Override // com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a) && ((com.baidu.adp.widget.ImageView.a) obj).isNeedCache()) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aP(i);
            aVar.aQ(i2);
            com.baidu.tbadk.imageManager.c.bCx().b(Be(str), aVar);
        }
    }

    @Override // com.baidu.adp.lib.e.e
    public BdAsyncTaskParallel mz() {
        return null;
    }

    @Override // com.baidu.adp.lib.e.e
    public int mA() {
        return 1;
    }

    public com.baidu.adp.widget.ImageView.a s(String str, int i, int i2) {
        try {
            File file = new File(str);
            if (file != null && file.exists()) {
                return new com.baidu.adp.widget.ImageView.a(BitmapHelper.checkBitmapSize(ThumbnailUtils.createVideoThumbnail(str, 1), i, i2), false, str);
            }
        } catch (OutOfMemoryError e) {
        }
        return null;
    }

    public String Be(String str) {
        return "videoThumb_" + str;
    }
}
