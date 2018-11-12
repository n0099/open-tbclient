package com.baidu.searchbox.ng.ai.apps.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.common.references.a;
import com.facebook.datasource.b;
import com.facebook.drawee.a.a.c;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class AiAppFrescoImageUtils {
    public static boolean isLoadedInMemory(Uri uri) {
        return uri != null && c.bRR().w(uri);
    }

    public static boolean isLoadedInSdcard(Uri uri) {
        if (uri == null) {
            return false;
        }
        b<Boolean> x = c.bRR().x(uri);
        boolean z = x != null && x.bRz() && x.getResult() != null && x.getResult().booleanValue();
        if (x != null) {
            x.bRC();
            return z;
        }
        return z;
    }

    public static Bitmap getBitmapFromCache(Uri uri, Context context) {
        if (uri == null || context == null) {
            return null;
        }
        if (isLoadedInMemory(uri)) {
            return fetchImage(c.bRR().d(ImageRequest.D(uri), context.getApplicationContext()));
        }
        b<Boolean> x = c.bRR().x(uri);
        if (x == null || !x.bRz() || x.getResult() == null || !x.getResult().booleanValue()) {
            return null;
        }
        try {
            return fetchImage(c.bRR().e(ImageRequest.D(uri), context));
        } finally {
            x.bRC();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [108=4] */
    private static Bitmap fetchImage(b<a<com.facebook.imagepipeline.f.b>> bVar) {
        Bitmap bVO;
        a<com.facebook.imagepipeline.f.b> aVar = null;
        if (bVar == null) {
            return null;
        }
        try {
            a<com.facebook.imagepipeline.f.b> result = bVar.getResult();
            if (result != null) {
                try {
                    com.facebook.imagepipeline.f.b bVar2 = result.get();
                    if (bVar2 != null && (bVar2 instanceof com.facebook.imagepipeline.f.a) && (bVO = ((com.facebook.imagepipeline.f.a) bVar2).bVO()) != null && !bVO.isRecycled()) {
                        try {
                            Bitmap createBitmap = Bitmap.createBitmap(bVO);
                            bVar.bRC();
                            a.c((a<?>) result);
                            return createBitmap;
                        } catch (OutOfMemoryError e) {
                            System.gc();
                        }
                    }
                } catch (Throwable th) {
                    aVar = result;
                    th = th;
                    bVar.bRC();
                    a.c((a<?>) aVar);
                    throw th;
                }
            }
            bVar.bRC();
            a.c((a<?>) result);
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
