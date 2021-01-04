package com.baidu.swan.apps.ao;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
/* loaded from: classes9.dex */
public class s {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes9.dex */
    public interface a {
        void g(String str, Bitmap bitmap);
    }

    public static boolean k(Uri uri) {
        return uri != null && com.facebook.drawee.a.a.c.euK().aa(uri);
    }

    public static Bitmap b(Uri uri, Context context) {
        if (uri == null || context == null) {
            return null;
        }
        if (k(uri)) {
            if (DEBUG) {
                Log.i("SwanAppFrescoImageUtils", "start get Bitmap from memory, uri : " + uri.toString());
            }
            return c(com.facebook.drawee.a.a.c.euK().d(ImageRequest.ah(uri), context.getApplicationContext()));
        }
        if (DEBUG) {
            Log.i("SwanAppFrescoImageUtils", "start get Bitmap from sdcard, uri : " + uri.toString());
        }
        com.facebook.datasource.b<Boolean> ab = com.facebook.drawee.a.a.c.euK().ab(uri);
        if (ab == null || !ab.eur() || ab.getResult() == null || !ab.getResult().booleanValue()) {
            return null;
        }
        try {
            return c(com.facebook.drawee.a.a.c.euK().e(ImageRequest.ah(uri), context));
        } finally {
            ab.ath();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [130=4] */
    private static Bitmap c(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> bVar) {
        Throwable th;
        Bitmap ezc;
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar = null;
        if (bVar == null) {
            return null;
        }
        try {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.c> result = bVar.getResult();
            if (result != null) {
                try {
                    com.facebook.imagepipeline.f.c cVar = result.get();
                    if (cVar != null && (cVar instanceof com.facebook.imagepipeline.f.b) && (ezc = ((com.facebook.imagepipeline.f.b) cVar).ezc()) != null && !ezc.isRecycled()) {
                        try {
                            Bitmap createBitmap = Bitmap.createBitmap(ezc);
                            bVar.ath();
                            com.facebook.common.references.a.c(result);
                            return createBitmap;
                        } catch (OutOfMemoryError e) {
                            System.gc();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    aVar = result;
                    bVar.ath();
                    com.facebook.common.references.a.c(aVar);
                    throw th;
                }
            }
            bVar.ath();
            com.facebook.common.references.a.c(result);
            return null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static Bitmap d(Bitmap bitmap, int i, int i2) {
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
            com.facebook.drawee.a.a.c.euK().f(ImageRequestBuilder.aj(uri).eBe(), str);
        }
    }

    public static void a(final String str, final a aVar) {
        Uri uN = ak.uN(str);
        if (uN == null) {
            aVar.g(str, null);
            return;
        }
        com.facebook.drawee.a.a.c.euK().e(ImageRequestBuilder.aj(uN).eBe(), AppRuntime.getAppContext()).a(new com.facebook.imagepipeline.d.b() { // from class: com.baidu.swan.apps.ao.s.1
            @Override // com.facebook.imagepipeline.d.b
            protected void f(Bitmap bitmap) {
                Bitmap copy;
                if (bitmap != null && !bitmap.isRecycled()) {
                    try {
                        if (bitmap.getConfig() == null) {
                            copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                        } else {
                            copy = bitmap.copy(bitmap.getConfig(), true);
                        }
                        a.this.g(str, copy);
                        return;
                    } catch (Exception e) {
                        if (s.DEBUG) {
                            Log.e("SwanAppFrescoImageUtils", e.getMessage());
                        }
                        a.this.g(str, null);
                        return;
                    }
                }
                a.this.g(str, null);
            }

            @Override // com.facebook.datasource.a
            protected void a(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> bVar) {
                a.this.g(str, null);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void b(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> bVar) {
                super.b(bVar);
                a.this.g(str, null);
            }
        }, com.facebook.common.b.f.etR());
    }
}
