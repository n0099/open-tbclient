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
    private CoverViewHelper bcO;
    private com.baidu.swan.apps.view.coverview.b.a bcP;

    public ImageCoverView(Context context) {
        super(context);
        this.bcO = new CoverViewHelper();
        getHierarchy().b(n.b.kdc);
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public void a(@NonNull com.baidu.swan.apps.view.coverview.b.a aVar) {
        if (aVar != null) {
            this.bcP = aVar;
            this.bcO.ar(this);
            JSONObject jSONObject = aVar.akZ;
            if (jSONObject != null) {
                this.bcO.a(this, jSONObject);
                this.bcO.c(this, jSONObject);
                b(aVar);
            }
        }
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public void setAlpha(@NonNull com.baidu.swan.apps.view.coverview.b.a aVar) {
        if (aVar.akZ != null) {
            this.bcO.b(this, aVar.akZ);
        }
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public void setModel(@NonNull com.baidu.swan.apps.view.coverview.b.a aVar) {
        if (aVar != null) {
            this.bcP = aVar;
            this.bcO.ar(this);
        }
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public void setOnActionCallback(com.baidu.swan.apps.view.coverview.a aVar) {
        this.bcO.setOnActionCallback(aVar);
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public CoverViewHelper.a getClickPosition() {
        return this.bcO.getClickPosition();
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public com.baidu.swan.apps.view.coverview.b.a getModel() {
        return this.bcP;
    }

    protected void b(@NonNull com.baidu.swan.apps.view.coverview.b.a aVar) {
        Uri iF;
        if (aVar.akZ != null && (aVar instanceof com.baidu.swan.apps.view.coverview.b.b)) {
            String str = ((com.baidu.swan.apps.view.coverview.b.b) aVar).bcJ;
            if (!TextUtils.isEmpty(str) && (iF = iF(str)) != null) {
                if (DEBUG) {
                    Log.d("CoverImage", "Image Uri:" + iF);
                }
                final boolean z = ((com.baidu.swan.apps.view.coverview.b.b) aVar).bcK;
                e b = c.cFu().b(getController()).b(new com.facebook.drawee.controller.b<com.facebook.imagepipeline.f.e>() { // from class: com.baidu.swan.apps.view.coverview.subview.ImageCoverView.1
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void g(String str2, Throwable th) {
                        super.g(str2, th);
                        if (ImageCoverView.this.bcO != null) {
                            com.baidu.swan.apps.view.coverview.a Qs = ImageCoverView.this.bcO.Qs();
                            if (z && Qs != null) {
                                Qs.a(0, ImageCoverView.this, null);
                            }
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void a(String str2, com.facebook.imagepipeline.f.e eVar, Animatable animatable) {
                        super.a(str2, (String) eVar, animatable);
                        if (ImageCoverView.this.bcO != null) {
                            com.baidu.swan.apps.view.coverview.a Qs = ImageCoverView.this.bcO.Qs();
                            if (z && Qs != null) {
                                Qs.a(1, ImageCoverView.this, null);
                            }
                        }
                    }
                });
                b.I(iF);
                com.facebook.drawee.controller.a cGa = b.cGe();
                RoundingParams roundingParams = new RoundingParams();
                roundingParams.bc(this.bcO.ap(aVar.akZ));
                com.facebook.drawee.generic.a cGQ = new com.facebook.drawee.generic.b(getResources()).cGQ();
                cGQ.a(roundingParams);
                cGQ.b(n.b.kdc);
                setHierarchy(cGQ);
                setController(cGa);
            }
        }
    }

    private Uri iF(@NonNull String str) {
        String str2;
        String str3;
        PathType hG = com.baidu.swan.apps.storage.b.hG(str);
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        if (Md != null) {
            str3 = Md.id;
            str2 = Md.getVersion();
        } else {
            str2 = null;
            str3 = null;
        }
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
            return null;
        }
        switch (hG) {
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
                String a = com.baidu.swan.apps.storage.b.a(str, Md, str2);
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
