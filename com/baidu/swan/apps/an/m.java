package com.baidu.swan.apps.an;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.util.Log;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
/* loaded from: classes2.dex */
public class m {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes2.dex */
    public interface a {
        void e(String str, Bitmap bitmap);
    }

    public static boolean g(Uri uri) {
        return uri != null && com.facebook.drawee.a.a.c.cDD().I(uri);
    }

    public static Bitmap b(Uri uri, Context context) {
        if (uri == null || context == null) {
            return null;
        }
        if (g(uri)) {
            if (DEBUG) {
                Log.i("SwanAppFrescoImageUtils", "start get Bitmap from memory, uri : " + uri.toString());
            }
            return c(com.facebook.drawee.a.a.c.cDD().d(ImageRequest.P(uri), context.getApplicationContext()));
        }
        if (DEBUG) {
            Log.i("SwanAppFrescoImageUtils", "start get Bitmap from sdcard, uri : " + uri.toString());
        }
        com.facebook.datasource.b<Boolean> J = com.facebook.drawee.a.a.c.cDD().J(uri);
        if (J == null || !J.cDm() || J.getResult() == null || !J.getResult().booleanValue()) {
            return null;
        }
        try {
            return c(com.facebook.drawee.a.a.c.cDD().e(ImageRequest.P(uri), context));
        } finally {
            J.FH();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [130=4] */
    private static Bitmap c(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bVar) {
        Bitmap cHJ;
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar = null;
        if (bVar == null) {
            return null;
        }
        try {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.b> result = bVar.getResult();
            if (result != null) {
                try {
                    com.facebook.imagepipeline.f.b bVar2 = result.get();
                    if (bVar2 != null && (bVar2 instanceof com.facebook.imagepipeline.f.a) && (cHJ = ((com.facebook.imagepipeline.f.a) bVar2).cHJ()) != null && !cHJ.isRecycled()) {
                        try {
                            Bitmap createBitmap = Bitmap.createBitmap(cHJ);
                            bVar.FH();
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) result);
                            return createBitmap;
                        } catch (OutOfMemoryError e) {
                            System.gc();
                        }
                    }
                } catch (Throwable th) {
                    aVar = result;
                    th = th;
                    bVar.FH();
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
                    throw th;
                }
            }
            bVar.FH();
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) result);
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Bitmap c(Bitmap bitmap, int i, int i2) {
        Bitmap bitmap2;
        if (bitmap == null || i <= 0 || i2 <= 0) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == 0 || height == 0) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        try {
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        } catch (Exception | OutOfMemoryError e) {
            bitmap2 = null;
        }
        return bitmap2;
    }

    public static void a(Uri uri, String str) {
        if (uri != null) {
            if (DEBUG) {
                Log.i("SwanAppFrescoImageUtils", "start preFetch into memory, uri : " + uri.toString());
            }
            com.facebook.drawee.a.a.c.cDD().f(ImageRequestBuilder.R(uri).cJI(), str);
        }
    }
}
