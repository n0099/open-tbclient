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
    private CoverViewHelper bdm;
    private com.baidu.swan.apps.view.coverview.b.a bdn;

    public ImageCoverView(Context context) {
        super(context);
        this.bdm = new CoverViewHelper();
        getHierarchy().b(n.b.kgG);
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public void a(@NonNull com.baidu.swan.apps.view.coverview.b.a aVar) {
        if (aVar != null) {
            this.bdn = aVar;
            this.bdm.ar(this);
            JSONObject jSONObject = aVar.aly;
            if (jSONObject != null) {
                this.bdm.a(this, jSONObject);
                this.bdm.c(this, jSONObject);
                b(aVar);
            }
        }
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public void setAlpha(@NonNull com.baidu.swan.apps.view.coverview.b.a aVar) {
        if (aVar.aly != null) {
            this.bdm.b(this, aVar.aly);
        }
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public void setModel(@NonNull com.baidu.swan.apps.view.coverview.b.a aVar) {
        if (aVar != null) {
            this.bdn = aVar;
            this.bdm.ar(this);
        }
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public void setOnActionCallback(com.baidu.swan.apps.view.coverview.a aVar) {
        this.bdm.setOnActionCallback(aVar);
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public CoverViewHelper.a getClickPosition() {
        return this.bdm.getClickPosition();
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public com.baidu.swan.apps.view.coverview.b.a getModel() {
        return this.bdn;
    }

    protected void b(@NonNull com.baidu.swan.apps.view.coverview.b.a aVar) {
        Uri iH;
        if (aVar.aly != null && (aVar instanceof com.baidu.swan.apps.view.coverview.b.b)) {
            String str = ((com.baidu.swan.apps.view.coverview.b.b) aVar).bdh;
            if (!TextUtils.isEmpty(str) && (iH = iH(str)) != null) {
                if (DEBUG) {
                    Log.d("CoverImage", "Image Uri:" + iH);
                }
                final boolean z = ((com.baidu.swan.apps.view.coverview.b.b) aVar).bdi;
                e b = c.cGD().b(getController()).b(new com.facebook.drawee.controller.b<com.facebook.imagepipeline.f.e>() { // from class: com.baidu.swan.apps.view.coverview.subview.ImageCoverView.1
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void g(String str2, Throwable th) {
                        super.g(str2, th);
                        if (ImageCoverView.this.bdm != null) {
                            com.baidu.swan.apps.view.coverview.a Qw = ImageCoverView.this.bdm.Qw();
                            if (z && Qw != null) {
                                Qw.a(0, ImageCoverView.this, null);
                            }
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void a(String str2, com.facebook.imagepipeline.f.e eVar, Animatable animatable) {
                        super.a(str2, (String) eVar, animatable);
                        if (ImageCoverView.this.bdm != null) {
                            com.baidu.swan.apps.view.coverview.a Qw = ImageCoverView.this.bdm.Qw();
                            if (z && Qw != null) {
                                Qw.a(1, ImageCoverView.this, null);
                            }
                        }
                    }
                });
                b.I(iH);
                com.facebook.drawee.controller.a cHj = b.cHn();
                RoundingParams roundingParams = new RoundingParams();
                roundingParams.bd(this.bdm.ap(aVar.aly));
                com.facebook.drawee.generic.a cHZ = new com.facebook.drawee.generic.b(getResources()).cHZ();
                cHZ.a(roundingParams);
                cHZ.b(n.b.kgG);
                setHierarchy(cHZ);
                setController(cHj);
            }
        }
    }

    private Uri iH(@NonNull String str) {
        String str2;
        String str3;
        PathType hI = com.baidu.swan.apps.storage.b.hI(str);
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        if (Mh != null) {
            str3 = Mh.id;
            str2 = Mh.getVersion();
        } else {
            str2 = null;
            str3 = null;
        }
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
            return null;
        }
        switch (hI) {
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
                String a = com.baidu.swan.apps.storage.b.a(str, Mh, str2);
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
