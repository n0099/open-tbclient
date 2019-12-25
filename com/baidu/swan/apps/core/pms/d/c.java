package com.baidu.swan.apps.core.pms.d;

import android.graphics.Bitmap;
import android.net.Uri;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ap.e;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.statistic.a.d;
import com.baidu.swan.apps.statistic.f;
import com.facebook.common.b.i;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
/* loaded from: classes9.dex */
public class c {

    /* loaded from: classes9.dex */
    public interface a {
        void h(Bitmap bitmap);
    }

    public static void a(String str, final int i, final a aVar) {
        Uri uri = ai.getUri(str);
        if (uri == null) {
            a(i, aVar, "download icon fail: icon url is null");
            return;
        }
        com.facebook.drawee.a.a.c.dji().e(ImageRequestBuilder.X(uri).dpZ(), AppRuntime.getAppContext()).a(new com.facebook.imagepipeline.e.b() { // from class: com.baidu.swan.apps.core.pms.d.c.1
            @Override // com.facebook.imagepipeline.e.b
            protected void onNewResultImpl(Bitmap bitmap) {
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
                        a.this.h(copy);
                    }
                } catch (Exception e) {
                    c.a(i, a.this, "download icon fail: " + e.getMessage());
                }
            }

            @Override // com.facebook.datasource.a
            protected void onFailureImpl(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> bVar) {
                c.a(i, a.this, "download icon fail: onFailureImpl");
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void onCancellation(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> bVar) {
                super.onCancellation(bVar);
                c.a(i, a.this, "download icon fail: onCancellation");
            }
        }, i.din());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(int i, a aVar, String str) {
        com.baidu.swan.apps.ap.a mh = new com.baidu.swan.apps.ap.a().aB(4L).aC(10L).mh(str);
        e.adF().f(mh);
        f.b(new d().e(mh).lv(f.ga(i)));
        if (aVar != null) {
            aVar.h(null);
        }
    }
}
