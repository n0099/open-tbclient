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
/* loaded from: classes11.dex */
public class c {

    /* loaded from: classes11.dex */
    public interface a {
        void i(Bitmap bitmap);
    }

    public static void a(String str, final int i, final a aVar) {
        Uri uri = ai.getUri(str);
        if (uri == null) {
            a(i, aVar, "download icon fail: icon url is null");
            return;
        }
        com.facebook.drawee.a.a.c.dnO().e(ImageRequestBuilder.Z(uri).duT(), AppRuntime.getAppContext()).a(new com.facebook.imagepipeline.e.b() { // from class: com.baidu.swan.apps.core.pms.d.c.1
            @Override // com.facebook.imagepipeline.e.b
            protected void h(Bitmap bitmap) {
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
                        a.this.i(copy);
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
        }, i.dmT());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(int i, a aVar, String str) {
        com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(4L).bo(10L).nL(str);
        e.aov().f(nL);
        f.b(new d().e(nL).mZ(f.gz(i)));
        if (aVar != null) {
            aVar.i(null);
        }
    }
}
