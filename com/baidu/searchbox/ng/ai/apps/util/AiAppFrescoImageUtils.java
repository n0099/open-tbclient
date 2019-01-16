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
        return uri != null && c.bVv().x(uri);
    }

    public static boolean isLoadedInSdcard(Uri uri) {
        if (uri == null) {
            return false;
        }
        b<Boolean> y = c.bVv().y(uri);
        boolean z = y != null && y.bVd() && y.getResult() != null && y.getResult().booleanValue();
        if (y != null) {
            y.bVg();
            return z;
        }
        return z;
    }

    public static Bitmap getBitmapFromCache(Uri uri, Context context) {
        if (uri == null || context == null) {
            return null;
        }
        if (isLoadedInMemory(uri)) {
            return fetchImage(c.bVv().d(ImageRequest.E(uri), context.getApplicationContext()));
        }
        b<Boolean> y = c.bVv().y(uri);
        if (y == null || !y.bVd() || y.getResult() == null || !y.getResult().booleanValue()) {
            return null;
        }
        try {
            return fetchImage(c.bVv().e(ImageRequest.E(uri), context));
        } finally {
            y.bVg();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [108=4] */
    private static Bitmap fetchImage(b<a<com.facebook.imagepipeline.f.b>> bVar) {
        Bitmap bZs;
        a<com.facebook.imagepipeline.f.b> aVar = null;
        if (bVar == null) {
            return null;
        }
        try {
            a<com.facebook.imagepipeline.f.b> result = bVar.getResult();
            if (result != null) {
                try {
                    com.facebook.imagepipeline.f.b bVar2 = result.get();
                    if (bVar2 != null && (bVar2 instanceof com.facebook.imagepipeline.f.a) && (bZs = ((com.facebook.imagepipeline.f.a) bVar2).bZs()) != null && !bZs.isRecycled()) {
                        try {
                            Bitmap createBitmap = Bitmap.createBitmap(bZs);
                            bVar.bVg();
                            a.c((a<?>) result);
                            return createBitmap;
                        } catch (OutOfMemoryError e) {
                            System.gc();
                        }
                    }
                } catch (Throwable th) {
                    aVar = result;
                    th = th;
                    bVar.bVg();
                    a.c((a<?>) aVar);
                    throw th;
                }
            }
            bVar.bVg();
            a.c((a<?>) result);
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
