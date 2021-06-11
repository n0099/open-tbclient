package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.media.ThumbnailUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.BitmapHelper;
import d.a.c.e.l.b;
import d.a.c.e.l.e;
import d.a.c.k.d.a;
import d.a.m0.a0.c;
import java.io.File;
/* loaded from: classes3.dex */
public class LocalVideoThumbLoaderProc implements e<a> {
    public a createVideoThumbnail(String str, int i2, int i3) {
        try {
            if (new File(str).exists()) {
                return new a(BitmapHelper.checkBitmapSize(ThumbnailUtils.createVideoThumbnail(str, 1), i2, i3), false, str);
            }
            return null;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public a m22decodeToResource(byte[] bArr, Object... objArr) {
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

    public String toCacheKey(String str) {
        return "videoThumb_" + str;
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
            c.k().d(toCacheKey(str), aVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.a.c.e.l.e
    public a getFromLocal(String str, String str2, int i2, int i3, b bVar, Object... objArr) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return createVideoThumbnail(str, i2, i3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.a.c.e.l.e
    public a getFromMemory(String str, String str2, int i2, int i3, boolean z, Object... objArr) {
        a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(toCacheKey(str), c.k().m(toCacheKey(str)), i2, i3);
        if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.p() == null || checkIsValidPicMemoryCache.p().isRecycled()) {
            return null;
        }
        return checkIsValidPicMemoryCache;
    }
}
