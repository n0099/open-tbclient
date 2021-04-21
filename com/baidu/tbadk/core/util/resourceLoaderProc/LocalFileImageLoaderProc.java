package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.img.effect.ImageOperation;
import d.b.c.e.l.b;
import d.b.c.e.l.e;
import d.b.c.e.p.l;
import d.b.c.j.d.a;
import d.b.i0.a0.c;
import d.b.i0.b0.g.d;
/* loaded from: classes3.dex */
public class LocalFileImageLoaderProc implements e<a> {
    public int height;
    public int width;

    public LocalFileImageLoaderProc() {
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

    @Override // d.b.c.e.l.e
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        return null;
    }

    @Override // d.b.c.e.l.e
    public int getAsyncTaskPriority() {
        return 1;
    }

    public a getBitmapFromFile(String str, int i, int i2) {
        try {
            if (str.toLowerCase().endsWith(".gif")) {
                return new a(BitmapHelper.loadBitmap(str), true, str);
            }
            return new a(BitmapHelper.checkBitmapSize(BitmapHelper.loadResizedBitmap(str, this.width, this.height), i, i2), false, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.b.c.e.l.e
    public a getFromRemote(String str, String str2, int i, int i2, b bVar, Object... objArr) {
        return null;
    }

    @Override // d.b.c.e.l.e
    public boolean isNeedLoad() {
        return true;
    }

    public void storeLocal(String str, byte[] bArr, Object... objArr) {
    }

    public String toCacheKey(String str) {
        ImageOperation g2 = d.g(this.width, this.height);
        return "image_" + str + ':' + g2.actionName + com.alipay.sdk.encrypt.a.f1922h + g2.actionParam;
    }

    @Override // d.b.c.e.l.e
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj == null || !(obj instanceof a)) {
            return;
        }
        a aVar = (a) obj;
        if (aVar.u()) {
            aVar.A(i);
            aVar.z(i2);
            c.k().d(toCacheKey(str), aVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.b.c.e.l.e
    public a getFromLocal(String str, String str2, int i, int i2, b bVar, Object... objArr) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return getBitmapFromFile(str, i, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.b.c.e.l.e
    public a getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(toCacheKey(str), c.k().m(toCacheKey(str)), i, i2);
        if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.p() == null || checkIsValidPicMemoryCache.p().isRecycled()) {
            return null;
        }
        return checkIsValidPicMemoryCache;
    }

    public LocalFileImageLoaderProc(int i, int i2) {
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
