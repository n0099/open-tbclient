package com.baidu.swan.apps.component.a.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.component.a.b.b;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.storage.PathType;
import com.facebook.drawee.a.a.e;
import com.facebook.drawee.drawable.p;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.f.f;
import java.io.File;
/* loaded from: classes8.dex */
public abstract class a<V extends SimpleDraweeView, M extends b> extends com.baidu.swan.apps.component.a.d.a<V, M> {
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.component.a.b.a<V extends com.facebook.drawee.view.SimpleDraweeView, M extends com.baidu.swan.apps.component.a.b.b> */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.swan.apps.component.a.d.a
    public /* bridge */ /* synthetic */ void a(@NonNull View view, @NonNull com.baidu.swan.apps.component.a.d.b bVar, @NonNull com.baidu.swan.apps.component.d.b bVar2) {
        a((a<V, M>) ((SimpleDraweeView) view), (SimpleDraweeView) ((b) bVar), bVar2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.component.a.b.a<V extends com.facebook.drawee.view.SimpleDraweeView, M extends com.baidu.swan.apps.component.a.b.b> */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.swan.apps.component.a.d.a, com.baidu.swan.apps.component.b.a
    public /* bridge */ /* synthetic */ void a(@NonNull View view, @NonNull com.baidu.swan.apps.component.b.b bVar, @NonNull com.baidu.swan.apps.component.d.b bVar2) {
        a((a<V, M>) ((SimpleDraweeView) view), (SimpleDraweeView) ((b) bVar), bVar2);
    }

    public a(@Nullable Context context, @NonNull M m) {
        super(context, m);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.d.a, com.baidu.swan.apps.component.b.a
    @NonNull
    public com.baidu.swan.apps.component.d.b a(@NonNull M m, @NonNull M m2) {
        com.baidu.swan.apps.component.d.b a2 = super.a(m, m2);
        if (!TextUtils.equals(m.cIE, m2.cIE)) {
            a2.gs(9);
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@NonNull V v, @NonNull M m, @NonNull com.baidu.swan.apps.component.d.b bVar) {
        super.a((a<V, M>) v, (V) m, bVar);
        if (bVar.gt(9)) {
            a((a<V, M>) v, (V) m);
        }
    }

    protected void a(@NonNull V v, @NonNull M m) {
        a((a<V, M>) v, (V) m, (com.facebook.drawee.controller.b<f>) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(@NonNull V v, @NonNull M m, @Nullable com.facebook.drawee.controller.b<f> bVar) {
        Uri lr;
        if (m.cIN != null) {
            if (DEBUG) {
                Log.d("Component-SimpleDrawee", "renderImageStyle");
            }
            String str = m.cIE;
            if (!TextUtils.isEmpty(str) && (lr = lr(str)) != null) {
                c.i("Component-SimpleDrawee", "Image Uri:" + lr);
                e b2 = com.facebook.drawee.a.a.c.eqV().c(v.getController());
                if (bVar != null) {
                    b2.c(bVar);
                }
                b2.V(lr);
                com.facebook.drawee.controller.a erJ = b2.erN();
                RoundingParams roundingParams = new RoundingParams();
                roundingParams.bH(m.cIO);
                com.facebook.drawee.generic.a esy = new com.facebook.drawee.generic.b(v.getResources()).esy();
                esy.a(roundingParams);
                esy.b(p.b.ptg);
                v.setHierarchy(esy);
                v.setController(erJ);
            }
        }
    }

    public static Uri lr(@NonNull String str) {
        String str2;
        String str3;
        PathType sL = com.baidu.swan.apps.storage.b.sL(str);
        com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
        if (aIr != null) {
            str3 = aIr.id;
            str2 = aIr.getVersion();
        } else {
            str2 = null;
            str3 = null;
        }
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
            return null;
        }
        switch (sL) {
            case BD_FILE:
                String cD = com.baidu.swan.apps.storage.b.cD(str, str3);
                if (TextUtils.isEmpty(cD)) {
                    return null;
                }
                return Uri.fromFile(new File(cD));
            case RELATIVE:
                File file = new File(str);
                if (file.exists()) {
                    return Uri.fromFile(file);
                }
                String a2 = com.baidu.swan.apps.storage.b.a(str, aIr, str2);
                if (TextUtils.isEmpty(a2)) {
                    return null;
                }
                return Uri.fromFile(new File(a2));
            case NETWORK:
                return Uri.parse(str);
            default:
                return null;
        }
    }
}
