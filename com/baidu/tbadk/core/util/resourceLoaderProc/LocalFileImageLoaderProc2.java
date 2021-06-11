package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import d.a.c.e.l.b;
import d.a.c.e.l.e;
import d.a.c.e.p.l;
import d.a.c.k.d.a;
import d.a.m0.a0.c;
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
    public a m21decodeToResource(byte[] bArr, Object... objArr) {
        return null;
    }

    @Override // d.a.c.e.l.e
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        return null;
    }

    @Override // d.a.c.e.l.e
    public int getAsyncTaskPriority() {
        return 1;
    }

    public a getBitmapFromFile(String str, int i2, int i3) {
        Bitmap loadResizedBitmap;
        try {
            if (str.toLowerCase().endsWith(".gif")) {
                return new a(BitmapHelper.loadBitmap(str), true, str);
            }
            if (i2 > 0 && i3 > 0 && i2 < this.width && i3 < this.height) {
                loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, i2, i3);
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
    @Override // d.a.c.e.l.e
    public a getFromRemote(String str, String str2, int i2, int i3, b bVar, Object... objArr) {
        return null;
    }

    @Override // d.a.c.e.l.e
    public boolean isNeedLoad() {
        return true;
    }

    public void storeLocal(String str, byte[] bArr, Object... objArr) {
    }

    public String toCacheKey(String str, int i2, int i3) {
        return "localimage_" + str + ":w=" + i2 + "&h=" + i3;
    }

    @Override // d.a.c.e.l.e
    public void updateMemory(String str, Object obj, int i2, int i3, Object... objArr) {
        if (obj == null || !(obj instanceof a)) {
            return;
        }
        a aVar = (a) obj;
        if (aVar.u()) {
            aVar.A(i2);
            aVar.z(i3);
            c.k().d(toCacheKey(str, i2, i3), aVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.a.c.e.l.e
    public a getFromLocal(String str, String str2, int i2, int i3, b bVar, Object... objArr) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return getBitmapFromFile(str, i2, i3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.a.c.e.l.e
    public a getFromMemory(String str, String str2, int i2, int i3, boolean z, Object... objArr) {
        a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(toCacheKey(str, i2, i3), c.k().m(toCacheKey(str, i2, i3)), i2, i3);
        if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.p() == null || checkIsValidPicMemoryCache.p().isRecycled()) {
            return null;
        }
        return checkIsValidPicMemoryCache;
    }

    public LocalFileImageLoaderProc2(int i2, int i3) {
        this.width = 0;
        this.height = 0;
        if (i2 > 0 && i3 > 0) {
            this.width = i2;
            this.height = i3;
            return;
        }
        initDefalutMaxSize();
    }
}
