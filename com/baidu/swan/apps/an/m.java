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
        void d(String str, Bitmap bitmap);
    }

    public static boolean i(Uri uri) {
        return uri != null && com.facebook.drawee.a.a.c.cGF().L(uri);
    }

    public static Bitmap b(Uri uri, Context context) {
        if (uri == null || context == null) {
            return null;
        }
        if (i(uri)) {
            if (DEBUG) {
                Log.i("SwanAppFrescoImageUtils", "start get Bitmap from memory, uri : " + uri.toString());
            }
            return c(com.facebook.drawee.a.a.c.cGF().d(ImageRequest.S(uri), context.getApplicationContext()));
        }
        if (DEBUG) {
            Log.i("SwanAppFrescoImageUtils", "start get Bitmap from sdcard, uri : " + uri.toString());
        }
        com.facebook.datasource.b<Boolean> M = com.facebook.drawee.a.a.c.cGF().M(uri);
        if (M == null || !M.cGo() || M.getResult() == null || !M.getResult().booleanValue()) {
            return null;
        }
        try {
            return c(com.facebook.drawee.a.a.c.cGF().e(ImageRequest.S(uri), context));
        } finally {
            M.AM();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [130=4] */
    private static Bitmap c(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bVar) {
        Bitmap cKM;
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar = null;
        if (bVar == null) {
            return null;
        }
        try {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.b> result = bVar.getResult();
            if (result != null) {
                try {
                    com.facebook.imagepipeline.f.b bVar2 = result.get();
                    if (bVar2 != null && (bVar2 instanceof com.facebook.imagepipeline.f.a) && (cKM = ((com.facebook.imagepipeline.f.a) bVar2).cKM()) != null && !cKM.isRecycled()) {
                        try {
                            Bitmap createBitmap = Bitmap.createBitmap(cKM);
                            bVar.AM();
                            com.facebook.common.references.a.c(result);
                            return createBitmap;
                        } catch (OutOfMemoryError e) {
                            System.gc();
                        }
                    }
                } catch (Throwable th) {
                    aVar = result;
                    th = th;
                    bVar.AM();
                    com.facebook.common.references.a.c(aVar);
                    throw th;
                }
            }
            bVar.AM();
            com.facebook.common.references.a.c(result);
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
            com.facebook.drawee.a.a.c.cGF().f(ImageRequestBuilder.U(uri).cML(), str);
        }
    }
}
