package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.BitmapHelper;
import d.a.c.e.l.b;
import d.a.c.j.d.a;
import d.a.i0.a0.c;
/* loaded from: classes3.dex */
public class LocalFileDrawableLoaderProc extends AbstractImageLoaderProc {
    public int procType;

    public LocalFileDrawableLoaderProc(int i2) {
        this.procType = i2;
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
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, d.a.c.e.l.e
    public a getFromLocal(String str, String str2, int i2, int i3, b bVar, Object... objArr) {
        Bitmap checkBitmapSize;
        if (StringUtils.isNull(str) || (checkBitmapSize = BitmapHelper.checkBitmapSize(BitmapFactory.decodeFile(str), i2, i3)) == null) {
            return null;
        }
        return new a(checkBitmapSize, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, d.a.c.e.l.e
    public a getFromMemory(String str, String str2, int i2, int i3, boolean z, Object... objArr) {
        a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(str, c.k().m(str), i2, i3);
        if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.p() == null || checkIsValidPicMemoryCache.p().isRecycled()) {
            return null;
        }
        return checkIsValidPicMemoryCache;
    }
}
