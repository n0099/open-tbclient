package com.baidu.swan.apps.view.coverview.subview;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.swan.apps.view.coverview.subview.CoverViewHelper;
import com.facebook.drawee.a.a.c;
import com.facebook.drawee.a.a.e;
import com.facebook.drawee.drawable.n;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ImageCoverView extends SimpleDraweeView implements a {
    private static final boolean DEBUG = b.DEBUG;
    private CoverViewHelper bcc;
    private com.baidu.swan.apps.view.coverview.b.a bcd;

    public ImageCoverView(Context context) {
        super(context);
        this.bcc = new CoverViewHelper();
        getHierarchy().b(n.b.jVU);
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public void a(@NonNull com.baidu.swan.apps.view.coverview.b.a aVar) {
        if (aVar != null) {
            this.bcd = aVar;
            this.bcc.ap(this);
            JSONObject jSONObject = aVar.akx;
            if (jSONObject != null) {
                this.bcc.a(this, jSONObject);
                this.bcc.c(this, jSONObject);
                b(aVar);
            }
        }
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public void setAlpha(@NonNull com.baidu.swan.apps.view.coverview.b.a aVar) {
        if (aVar.akx != null) {
            this.bcc.b(this, aVar.akx);
        }
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public void setModel(@NonNull com.baidu.swan.apps.view.coverview.b.a aVar) {
        if (aVar != null) {
            this.bcd = aVar;
            this.bcc.ap(this);
        }
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public void setOnActionCallback(com.baidu.swan.apps.view.coverview.a aVar) {
        this.bcc.setOnActionCallback(aVar);
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public CoverViewHelper.a getClickPosition() {
        return this.bcc.getClickPosition();
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public com.baidu.swan.apps.view.coverview.b.a getModel() {
        return this.bcd;
    }

    protected void b(@NonNull com.baidu.swan.apps.view.coverview.b.a aVar) {
        Uri iz;
        if (aVar.akx != null && (aVar instanceof com.baidu.swan.apps.view.coverview.b.b)) {
            String str = ((com.baidu.swan.apps.view.coverview.b.b) aVar).bbX;
            if (!TextUtils.isEmpty(str) && (iz = iz(str)) != null) {
                if (DEBUG) {
                    Log.d("CoverImage", "Image Uri:" + iz);
                }
                final boolean z = ((com.baidu.swan.apps.view.coverview.b.b) aVar).bbY;
                e b = c.cCs().b(getController()).b(new com.facebook.drawee.controller.b<com.facebook.imagepipeline.f.e>() { // from class: com.baidu.swan.apps.view.coverview.subview.ImageCoverView.1
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void g(String str2, Throwable th) {
                        super.g(str2, th);
                        if (ImageCoverView.this.bcc != null) {
                            com.baidu.swan.apps.view.coverview.a PA = ImageCoverView.this.bcc.PA();
                            if (z && PA != null) {
                                PA.a(0, ImageCoverView.this, null);
                            }
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void a(String str2, com.facebook.imagepipeline.f.e eVar, Animatable animatable) {
                        super.a(str2, (String) eVar, animatable);
                        if (ImageCoverView.this.bcc != null) {
                            com.baidu.swan.apps.view.coverview.a PA = ImageCoverView.this.bcc.PA();
                            if (z && PA != null) {
                                PA.a(1, ImageCoverView.this, null);
                            }
                        }
                    }
                });
                b.I(iz);
                com.facebook.drawee.controller.a cCY = b.cDc();
                RoundingParams roundingParams = new RoundingParams();
                roundingParams.bb(this.bcc.ap(aVar.akx));
                com.facebook.drawee.generic.a cDM = new com.facebook.drawee.generic.b(getResources()).cDM();
                cDM.a(roundingParams);
                cDM.b(n.b.jVU);
                setHierarchy(cDM);
                setController(cCY);
            }
        }
    }

    private Uri iz(@NonNull String str) {
        String str2;
        String str3;
        PathType hA = com.baidu.swan.apps.storage.b.hA(str);
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        if (Lq != null) {
            str3 = Lq.id;
            str2 = Lq.getVersion();
        } else {
            str2 = null;
            str3 = null;
        }
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
            return null;
        }
        switch (hA) {
            case BD_FILE:
                String aE = com.baidu.swan.apps.storage.b.aE(str, str3);
                if (TextUtils.isEmpty(aE)) {
                    return null;
                }
                return Uri.fromFile(new File(aE));
            case RELATIVE:
                File file = new File(str);
                if (file.exists()) {
                    return Uri.fromFile(file);
                }
                String a = com.baidu.swan.apps.storage.b.a(str, Lq, str2);
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
