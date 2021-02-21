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
/* loaded from: classes9.dex */
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
        if (!TextUtils.equals(m.cKS, m2.cKS)) {
            a2.gv(9);
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@NonNull V v, @NonNull M m, @NonNull com.baidu.swan.apps.component.d.b bVar) {
        super.a((a<V, M>) v, (V) m, bVar);
        if (bVar.gw(9)) {
            a((a<V, M>) v, (V) m);
        }
    }

    protected void a(@NonNull V v, @NonNull M m) {
        a((a<V, M>) v, (V) m, (com.facebook.drawee.controller.b<f>) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(@NonNull V v, @NonNull M m, @Nullable com.facebook.drawee.controller.b<f> bVar) {
        Uri lJ;
        if (m.cLb != null) {
            if (DEBUG) {
                Log.d("Component-SimpleDrawee", "renderImageStyle");
            }
            String str = m.cKS;
            if (!TextUtils.isEmpty(str) && (lJ = lJ(str)) != null) {
                c.i("Component-SimpleDrawee", "Image Uri:" + lJ);
                e b2 = com.facebook.drawee.a.a.c.etw().c(v.getController());
                if (bVar != null) {
                    b2.c(bVar);
                }
                b2.V(lJ);
                com.facebook.drawee.controller.a euj = b2.eun();
                RoundingParams roundingParams = new RoundingParams();
                roundingParams.bK(m.cLc);
                com.facebook.drawee.generic.a euY = new com.facebook.drawee.generic.b(v.getResources()).euY();
                euY.a(roundingParams);
                euY.b(p.b.pDQ);
                v.setHierarchy(euY);
                v.setController(euj);
            }
        }
    }

    public static Uri lJ(@NonNull String str) {
        String str2;
        String str3;
        PathType te = com.baidu.swan.apps.storage.b.te(str);
        com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
        if (aIK != null) {
            str3 = aIK.id;
            str2 = aIK.getVersion();
        } else {
            str2 = null;
            str3 = null;
        }
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
            return null;
        }
        switch (te) {
            case BD_FILE:
                String cx = com.baidu.swan.apps.storage.b.cx(str, str3);
                if (TextUtils.isEmpty(cx)) {
                    return null;
                }
                return Uri.fromFile(new File(cx));
            case RELATIVE:
                File file = new File(str);
                if (file.exists()) {
                    return Uri.fromFile(file);
                }
                String a2 = com.baidu.swan.apps.storage.b.a(str, aIK, str2);
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
