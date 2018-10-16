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
        return uri != null && c.bSw().w(uri);
    }

    public static boolean isLoadedInSdcard(Uri uri) {
        if (uri == null) {
            return false;
        }
        b<Boolean> x = c.bSw().x(uri);
        boolean z = x != null && x.bSe() && x.getResult() != null && x.getResult().booleanValue();
        if (x != null) {
            x.bSh();
            return z;
        }
        return z;
    }

    public static Bitmap getBitmapFromCache(Uri uri, Context context) {
        if (uri == null || context == null) {
            return null;
        }
        if (isLoadedInMemory(uri)) {
            return fetchImage(c.bSw().d(ImageRequest.D(uri), context.getApplicationContext()));
        }
        b<Boolean> x = c.bSw().x(uri);
        if (x == null || !x.bSe() || x.getResult() == null || !x.getResult().booleanValue()) {
            return null;
        }
        try {
            return fetchImage(c.bSw().e(ImageRequest.D(uri), context));
        } finally {
            x.bSh();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [108=4] */
    private static Bitmap fetchImage(b<a<com.facebook.imagepipeline.f.b>> bVar) {
        Bitmap bWt;
        a<com.facebook.imagepipeline.f.b> aVar = null;
        if (bVar == null) {
            return null;
        }
        try {
            a<com.facebook.imagepipeline.f.b> result = bVar.getResult();
            if (result != null) {
                try {
                    com.facebook.imagepipeline.f.b bVar2 = result.get();
                    if (bVar2 != null && (bVar2 instanceof com.facebook.imagepipeline.f.a) && (bWt = ((com.facebook.imagepipeline.f.a) bVar2).bWt()) != null && !bWt.isRecycled()) {
                        try {
                            Bitmap createBitmap = Bitmap.createBitmap(bWt);
                            bVar.bSh();
                            a.c((a<?>) result);
                            return createBitmap;
                        } catch (OutOfMemoryError e) {
                            System.gc();
                        }
                    }
                } catch (Throwable th) {
                    aVar = result;
                    th = th;
                    bVar.bSh();
                    a.c((a<?>) aVar);
                    throw th;
                }
            }
            bVar.bSh();
            a.c((a<?>) result);
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
