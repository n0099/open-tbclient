package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.BitmapHelper;
import d.b.c.e.l.b;
import d.b.c.j.d.a;
import d.b.h0.a0.c;
/* loaded from: classes3.dex */
public class LocalFileDrawableLoaderProc extends AbstractImageLoaderProc {
    public int procType;

    public LocalFileDrawableLoaderProc(int i) {
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getProcType() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getSuggestHeight() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getSuggestWidth() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public boolean isFromCDN() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, d.b.c.e.l.e
    public a getFromLocal(String str, String str2, int i, int i2, b bVar, Object... objArr) {
        Bitmap checkBitmapSize;
        if (StringUtils.isNull(str) || (checkBitmapSize = BitmapHelper.checkBitmapSize(BitmapFactory.decodeFile(str), i, i2)) == null) {
            return null;
        }
        return new a(checkBitmapSize, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, d.b.c.e.l.e
    public a getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(str, c.k().m(str), i, i2);
        if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.p() == null || checkIsValidPicMemoryCache.p().isRecycled()) {
            return null;
        }
        return checkIsValidPicMemoryCache;
    }
}
