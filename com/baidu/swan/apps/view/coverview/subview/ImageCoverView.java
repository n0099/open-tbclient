package com.baidu.swan.apps.view.coverview.subview;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.swan.apps.view.coverview.b.b;
import com.baidu.swan.apps.view.coverview.subview.CoverViewHelper;
import com.facebook.drawee.a.a.e;
import com.facebook.drawee.drawable.n;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ImageCoverView extends SimpleDraweeView implements a {
    private static final boolean DEBUG = c.DEBUG;
    private CoverViewHelper aZj;
    private com.baidu.swan.apps.view.coverview.b.a aZk;

    public ImageCoverView(Context context) {
        super(context);
        this.aZj = new CoverViewHelper();
        getHierarchy().b(n.b.jDB);
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public void a(@NonNull com.baidu.swan.apps.view.coverview.b.a aVar) {
        if (aVar != null) {
            this.aZk = aVar;
            this.aZj.am(this);
            JSONObject jSONObject = aVar.akf;
            if (jSONObject != null) {
                this.aZj.a(this, jSONObject);
                this.aZj.c(this, jSONObject);
                b(aVar);
            }
        }
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public void setAlpha(@NonNull com.baidu.swan.apps.view.coverview.b.a aVar) {
        if (aVar.akf != null) {
            this.aZj.b(this, aVar.akf);
        }
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public void setModel(@NonNull com.baidu.swan.apps.view.coverview.b.a aVar) {
        if (aVar != null) {
            this.aZk = aVar;
            this.aZj.am(this);
        }
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public void setOnActionCallback(com.baidu.swan.apps.view.coverview.a aVar) {
        this.aZj.setOnActionCallback(aVar);
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public CoverViewHelper.a getClickPosition() {
        return this.aZj.getClickPosition();
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public com.baidu.swan.apps.view.coverview.b.a getModel() {
        return this.aZk;
    }

    protected void b(@NonNull com.baidu.swan.apps.view.coverview.b.a aVar) {
        Uri hT;
        if (aVar.akf != null && (aVar instanceof b)) {
            String str = ((b) aVar).aZe;
            if (!TextUtils.isEmpty(str) && (hT = hT(str)) != null) {
                if (DEBUG) {
                    Log.d("CoverImage", "Image Uri:" + hT);
                }
                final boolean z = ((b) aVar).aZf;
                e b = com.facebook.drawee.a.a.c.cuq().b(getController()).b(new com.facebook.drawee.controller.b<com.facebook.imagepipeline.f.e>() { // from class: com.baidu.swan.apps.view.coverview.subview.ImageCoverView.1
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void g(String str2, Throwable th) {
                        super.g(str2, th);
                        if (ImageCoverView.this.aZj != null) {
                            com.baidu.swan.apps.view.coverview.a MT = ImageCoverView.this.aZj.MT();
                            if (z && MT != null) {
                                MT.a(0, ImageCoverView.this, null);
                            }
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void a(String str2, com.facebook.imagepipeline.f.e eVar, Animatable animatable) {
                        super.a(str2, (String) eVar, animatable);
                        if (ImageCoverView.this.aZj != null) {
                            com.baidu.swan.apps.view.coverview.a MT = ImageCoverView.this.aZj.MT();
                            if (z && MT != null) {
                                MT.a(1, ImageCoverView.this, null);
                            }
                        }
                    }
                });
                b.C(hT);
                com.facebook.drawee.controller.a cuW = b.cva();
                RoundingParams roundingParams = new RoundingParams();
                roundingParams.aX(this.aZj.an(aVar.akf));
                com.facebook.drawee.generic.a cvK = new com.facebook.drawee.generic.b(getResources()).cvK();
                cvK.a(roundingParams);
                cvK.b(n.b.jDB);
                setHierarchy(cvK);
                setController(cuW);
            }
        }
    }

    private Uri hT(@NonNull String str) {
        String str2;
        String str3;
        PathType gY = com.baidu.swan.apps.storage.b.gY(str);
        com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
        if (IX != null) {
            str3 = IX.id;
            str2 = IX.getVersion();
        } else {
            str2 = null;
            str3 = null;
        }
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
            return null;
        }
        switch (gY) {
            case BD_FILE:
                String aC = com.baidu.swan.apps.storage.b.aC(str, str3);
                if (TextUtils.isEmpty(aC)) {
                    return null;
                }
                return Uri.fromFile(new File(aC));
            case RELATIVE:
                File file = new File(str);
                if (file.exists()) {
                    return Uri.fromFile(file);
                }
                String a = com.baidu.swan.apps.storage.b.a(str, IX, str2);
                if (TextUtils.isEmpty(a)) {
                    return null;
                }
                return Uri.fromFile(new File(a));
            case NETWORK:
                return Uri.parse(str);
            default:
                return null;
        }
    }
}
