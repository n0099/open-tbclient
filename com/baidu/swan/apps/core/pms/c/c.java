package com.baidu.swan.apps.core.pms.c;

import android.graphics.Bitmap;
import android.net.Uri;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ak.e;
import com.baidu.swan.apps.an.ac;
import com.facebook.common.b.f;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
/* loaded from: classes2.dex */
public class c {

    /* loaded from: classes2.dex */
    public interface a {
        void i(Bitmap bitmap);
    }

    public static void a(String str, final a aVar) {
        Uri jb = ac.jb(str);
        if (jb == null) {
            e.TR().b(new com.baidu.swan.apps.ak.a().ar(4L).as(10L).iL("download icon fail: icon url is null"));
            if (aVar != null) {
                aVar.i(null);
                return;
            }
            return;
        }
        com.facebook.drawee.a.a.c.cDB().e(ImageRequestBuilder.R(jb).cJG(), AppRuntime.getAppContext()).a(new com.facebook.imagepipeline.e.b() { // from class: com.baidu.swan.apps.core.pms.c.c.1
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
                        if (a.this != null) {
                            a.this.i(copy);
                        }
                    } catch (Exception e) {
                        if (a.this != null) {
                            a.this.i(null);
                        }
                    }
                } else if (a.this != null) {
                    a.this.i(null);
                }
            }

            @Override // com.facebook.datasource.a
            protected void a(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bVar) {
                if (a.this != null) {
                    a.this.i(null);
                }
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void b(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bVar) {
                super.b(bVar);
                if (a.this != null) {
                    a.this.i(null);
                }
            }
        }, f.cCG());
    }
}
