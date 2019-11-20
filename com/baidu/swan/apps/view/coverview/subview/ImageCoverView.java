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
    private CoverViewHelper bvt;
    private com.baidu.swan.apps.view.coverview.b.a bvu;

    public ImageCoverView(Context context) {
        super(context);
        this.bvt = new CoverViewHelper();
        getHierarchy().b(n.b.kdX);
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public void a(@NonNull com.baidu.swan.apps.view.coverview.b.a aVar) {
        if (aVar != null) {
            this.bvu = aVar;
            this.bvt.ax(this);
            JSONObject jSONObject = aVar.aEB;
            if (jSONObject != null) {
                this.bvt.a(this, jSONObject);
                this.bvt.c(this, jSONObject);
                b(aVar);
            }
        }
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public void setAlpha(@NonNull com.baidu.swan.apps.view.coverview.b.a aVar) {
        if (aVar.aEB != null) {
            this.bvt.b(this, aVar.aEB);
        }
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public void setModel(@NonNull com.baidu.swan.apps.view.coverview.b.a aVar) {
        if (aVar != null) {
            this.bvu = aVar;
            this.bvt.ax(this);
        }
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public void setOnActionCallback(com.baidu.swan.apps.view.coverview.a aVar) {
        this.bvt.setOnActionCallback(aVar);
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public CoverViewHelper.a getClickPosition() {
        return this.bvt.getClickPosition();
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public com.baidu.swan.apps.view.coverview.b.a getModel() {
        return this.bvu;
    }

    protected void b(@NonNull com.baidu.swan.apps.view.coverview.b.a aVar) {
        Uri jk;
        if (aVar.aEB != null && (aVar instanceof com.baidu.swan.apps.view.coverview.b.b)) {
            String str = ((com.baidu.swan.apps.view.coverview.b.b) aVar).bvo;
            if (!TextUtils.isEmpty(str) && (jk = jk(str)) != null) {
                if (DEBUG) {
                    Log.d("CoverImage", "Image Uri:" + jk);
                }
                final boolean z = ((com.baidu.swan.apps.view.coverview.b.b) aVar).bvp;
                e b = c.cDz().b(getController()).b(new com.facebook.drawee.controller.b<com.facebook.imagepipeline.f.e>() { // from class: com.baidu.swan.apps.view.coverview.subview.ImageCoverView.1
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void h(String str2, Throwable th) {
                        super.h(str2, th);
                        if (ImageCoverView.this.bvt != null) {
                            com.baidu.swan.apps.view.coverview.a Vk = ImageCoverView.this.bvt.Vk();
                            if (z && Vk != null) {
                                Vk.a(0, ImageCoverView.this, null);
                            }
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void a(String str2, com.facebook.imagepipeline.f.e eVar, Animatable animatable) {
                        super.a(str2, (String) eVar, animatable);
                        if (ImageCoverView.this.bvt != null) {
                            com.baidu.swan.apps.view.coverview.a Vk = ImageCoverView.this.bvt.Vk();
                            if (z && Vk != null) {
                                Vk.a(1, ImageCoverView.this, null);
                            }
                        }
                    }
                });
                b.F(jk);
                com.facebook.drawee.controller.a cEf = b.cEj();
                RoundingParams roundingParams = new RoundingParams();
                roundingParams.aG(this.bvt.aO(aVar.aEB));
                com.facebook.drawee.generic.a cEV = new com.facebook.drawee.generic.b(getResources()).cEV();
                cEV.a(roundingParams);
                cEV.b(n.b.kdX);
                setHierarchy(cEV);
                setController(cEf);
            }
        }
    }

    private Uri jk(@NonNull String str) {
        String str2;
        String str3;
        PathType im = com.baidu.swan.apps.storage.b.im(str);
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra != null) {
            str3 = Ra.id;
            str2 = Ra.getVersion();
        } else {
            str2 = null;
            str3 = null;
        }
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
            return null;
        }
        switch (im) {
            case BD_FILE:
                String aL = com.baidu.swan.apps.storage.b.aL(str, str3);
                if (TextUtils.isEmpty(aL)) {
                    return null;
                }
                return Uri.fromFile(new File(aL));
            case RELATIVE:
                File file = new File(str);
                if (file.exists()) {
                    return Uri.fromFile(file);
                }
                String a = com.baidu.swan.apps.storage.b.a(str, Ra, str2);
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
