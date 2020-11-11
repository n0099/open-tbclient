package com.baidu.swan.apps.core.pms.f;

import android.graphics.Bitmap;
import android.net.Uri;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.am.e;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.statistic.a.d;
import com.baidu.swan.apps.statistic.h;
import com.facebook.common.b.i;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
/* loaded from: classes10.dex */
public class c {

    /* loaded from: classes10.dex */
    public interface a {
        void k(Bitmap bitmap);
    }

    public static void a(String str, final int i, final a aVar) {
        Uri uri = ak.getUri(str);
        if (uri == null) {
            a(i, aVar, "download icon fail: icon url is null");
            return;
        }
        com.facebook.drawee.a.a.c.ekU().e(ImageRequestBuilder.ad(uri).erY(), AppRuntime.getAppContext()).a(new com.facebook.imagepipeline.e.b() { // from class: com.baidu.swan.apps.core.pms.f.c.1
            @Override // com.facebook.imagepipeline.e.b
            protected void e(Bitmap bitmap) {
                Bitmap copy;
                if (bitmap == null || bitmap.isRecycled()) {
                    c.a(i, a.this, "download icon fail: bitmap is null or is recycled");
                    return;
                }
                try {
                    if (bitmap.getConfig() == null) {
                        copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                    } else {
                        copy = bitmap.copy(bitmap.getConfig(), true);
                    }
                    if (a.this != null) {
                        a.this.k(copy);
                    }
                } catch (Exception e) {
                    c.a(i, a.this, "download icon fail: " + e.getMessage());
                }
            }

            @Override // com.facebook.datasource.a
            protected void a(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> bVar) {
                c.a(i, a.this, "download icon fail: onFailureImpl");
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void b(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> bVar) {
                super.b(bVar);
                c.a(i, a.this, "download icon fail: onCancellation");
            }
        }, i.eka());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(int i, a aVar, String str) {
        com.baidu.swan.apps.am.a ua = new com.baidu.swan.apps.am.a().cv(4L).cw(10L).ua(str);
        e.aLT().j(ua);
        h.b(new d().i(ua).ti(h.ky(i)));
        if (aVar != null) {
            aVar.k(null);
        }
    }
}
