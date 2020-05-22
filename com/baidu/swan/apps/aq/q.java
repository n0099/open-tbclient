package com.baidu.swan.apps.aq;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
/* loaded from: classes11.dex */
public class q {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes11.dex */
    public interface a {
        void h(String str, Bitmap bitmap);
    }

    public static boolean i(Uri uri) {
        return uri != null && com.facebook.drawee.a.a.c.dvh().S(uri);
    }

    public static Bitmap b(Uri uri, Context context) {
        if (uri == null || context == null) {
            return null;
        }
        if (i(uri)) {
            if (DEBUG) {
                Log.i("SwanAppFrescoImageUtils", "start get Bitmap from memory, uri : " + uri.toString());
            }
            return c(com.facebook.drawee.a.a.c.dvh().d(ImageRequest.Z(uri), context.getApplicationContext()));
        }
        if (DEBUG) {
            Log.i("SwanAppFrescoImageUtils", "start get Bitmap from sdcard, uri : " + uri.toString());
        }
        com.facebook.datasource.b<Boolean> T = com.facebook.drawee.a.a.c.dvh().T(uri);
        if (T == null || !T.duO() || T.getResult() == null || !T.getResult().booleanValue()) {
            return null;
        }
        try {
            return c(com.facebook.drawee.a.a.c.dvh().e(ImageRequest.Z(uri), context));
        } finally {
            T.Zg();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [130=4] */
    private static Bitmap c(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> bVar) {
        Bitmap dAd;
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = null;
        if (bVar == null) {
            return null;
        }
        try {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> result = bVar.getResult();
            if (result != null) {
                try {
                    com.facebook.imagepipeline.g.c cVar = result.get();
                    if (cVar != null && (cVar instanceof com.facebook.imagepipeline.g.b) && (dAd = ((com.facebook.imagepipeline.g.b) cVar).dAd()) != null && !dAd.isRecycled()) {
                        try {
                            Bitmap createBitmap = Bitmap.createBitmap(dAd);
                            bVar.Zg();
                            com.facebook.common.references.a.c(result);
                            return createBitmap;
                        } catch (OutOfMemoryError e) {
                            System.gc();
                        }
                    }
                } catch (Throwable th) {
                    aVar = result;
                    th = th;
                    bVar.Zg();
                    com.facebook.common.references.a.c(aVar);
                    throw th;
                }
            }
            bVar.Zg();
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

    public static void b(Uri uri, String str) {
        if (uri != null) {
            if (DEBUG) {
                Log.i("SwanAppFrescoImageUtils", "start preFetch into memory, uri : " + uri.toString());
            }
            com.facebook.drawee.a.a.c.dvh().f(ImageRequestBuilder.ab(uri).dCl(), str);
        }
    }

    public static void a(final String str, final a aVar) {
        Uri uri = aj.getUri(str);
        if (uri == null) {
            aVar.h(str, null);
            return;
        }
        com.facebook.drawee.a.a.c.dvh().e(ImageRequestBuilder.ab(uri).dCl(), AppRuntime.getAppContext()).a(new com.facebook.imagepipeline.e.b() { // from class: com.baidu.swan.apps.aq.q.1
            @Override // com.facebook.imagepipeline.e.b
            protected void h(Bitmap bitmap) {
                Bitmap copy;
                if (bitmap != null && !bitmap.isRecycled()) {
                    try {
                        if (bitmap.getConfig() == null) {
                            copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                        } else {
                            copy = bitmap.copy(bitmap.getConfig(), true);
                        }
                        a.this.h(str, copy);
                        return;
                    } catch (Exception e) {
                        if (q.DEBUG) {
                            Log.e("SwanAppFrescoImageUtils", e.getMessage());
                        }
                        a.this.h(str, null);
                        return;
                    }
                }
                a.this.h(str, null);
            }

            @Override // com.facebook.datasource.a
            protected void a(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> bVar) {
                a.this.h(str, null);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void b(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> bVar) {
                super.b(bVar);
                a.this.h(str, null);
            }
        }, com.facebook.common.b.i.dun());
    }
}
