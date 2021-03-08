package com.baidu.swan.apps.core.pms.f;

import android.graphics.Bitmap;
import android.net.Uri;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.al.e;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.statistic.a.d;
import com.baidu.swan.apps.statistic.h;
import com.facebook.common.b.i;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
/* loaded from: classes8.dex */
public class c {

    /* loaded from: classes8.dex */
    public interface a {
        void k(Bitmap bitmap);
    }

    public static void a(String str, final int i, final a aVar) {
        Uri uc = ak.uc(str);
        if (uc == null) {
            a(i, aVar, "download icon fail: icon url is null");
            return;
        }
        com.facebook.drawee.a.a.c.etH().e(ImageRequestBuilder.ag(uc).eAz(), AppRuntime.getAppContext()).a(new com.facebook.imagepipeline.d.b() { // from class: com.baidu.swan.apps.core.pms.f.c.1
            @Override // com.facebook.imagepipeline.d.b
            protected void f(Bitmap bitmap) {
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
            protected void a(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> bVar) {
                c.a(i, a.this, "download icon fail: onFailureImpl");
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void b(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> bVar) {
                super.b(bVar);
                c.a(i, a.this, "download icon fail: onCancellation");
            }
        }, i.esN());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(int i, a aVar, String str) {
        com.baidu.swan.apps.al.a tO = new com.baidu.swan.apps.al.a().db(4L).dc(10L).tO(str);
        e.aNm().j(tO);
        h.b(new d().i(tO).sW(h.jv(i)));
        if (aVar != null) {
            aVar.k(null);
        }
    }
}
