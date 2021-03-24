package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import d.b.b.e.l.b;
import d.b.b.e.l.e;
import d.b.b.e.p.l;
import d.b.b.j.d.a;
import d.b.h0.a0.c;
/* loaded from: classes3.dex */
public class LocalFileImageLoaderProc2 implements e<a> {
    public int height;
    public int width;

    public LocalFileImageLoaderProc2() {
        this.width = 0;
        this.height = 0;
        initDefalutMaxSize();
    }

    private void initDefalutMaxSize() {
        this.width = l.k(TbadkCoreApplication.getInst());
        this.height = l.i(TbadkCoreApplication.getInst());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public a m22decodeToResource(byte[] bArr, Object... objArr) {
        return null;
    }

    @Override // d.b.b.e.l.e
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        return null;
    }

    @Override // d.b.b.e.l.e
    public int getAsyncTaskPriority() {
        return 1;
    }

    public a getBitmapFromFile(String str, int i, int i2) {
        Bitmap loadResizedBitmap;
        try {
            if (str.toLowerCase().endsWith(".gif")) {
                return new a(BitmapHelper.loadBitmap(str), true, str);
            }
            if (i > 0 && i2 > 0 && i < this.width && i2 < this.height) {
                loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, i, i2);
            } else {
                loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, this.width, this.height);
            }
            return new a(loadResizedBitmap, false, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.b.b.e.l.e
    public a getFromRemote(String str, String str2, int i, int i2, b bVar, Object... objArr) {
        return null;
    }

    @Override // d.b.b.e.l.e
    public boolean isNeedLoad() {
        return true;
    }

    public void storeLocal(String str, byte[] bArr, Object... objArr) {
    }

    public String toCacheKey(String str, int i, int i2) {
        return "localimage_" + str + ":w=" + i + "&h=" + i2;
    }

    @Override // d.b.b.e.l.e
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj == null || !(obj instanceof a)) {
            return;
        }
        a aVar = (a) obj;
        if (aVar.u()) {
            aVar.A(i);
            aVar.z(i2);
            c.j().d(toCacheKey(str, i, i2), aVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.b.b.e.l.e
    public a getFromLocal(String str, String str2, int i, int i2, b bVar, Object... objArr) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return getBitmapFromFile(str, i, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.b.b.e.l.e
    public a getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(toCacheKey(str, i, i2), c.j().l(toCacheKey(str, i, i2)), i, i2);
        if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.p() == null || checkIsValidPicMemoryCache.p().isRecycled()) {
            return null;
        }
        return checkIsValidPicMemoryCache;
    }

    public LocalFileImageLoaderProc2(int i, int i2) {
        this.width = 0;
        this.height = 0;
        if (i > 0 && i2 > 0) {
            this.width = i;
            this.height = i2;
            return;
        }
        initDefalutMaxSize();
    }
}
