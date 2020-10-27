package com.baidu.swan.apps.component.a.b;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.baidu.swan.apps.component.a.b.b;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.storage.PathType;
import com.facebook.drawee.a.a.e;
import com.facebook.drawee.drawable.p;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.g.f;
import java.io.File;
/* loaded from: classes10.dex */
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
        if (!TextUtils.equals(m.cxu, m2.cxu)) {
            a2.hA(9);
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@NonNull V v, @NonNull M m, @NonNull com.baidu.swan.apps.component.d.b bVar) {
        super.a((a<V, M>) v, (V) m, bVar);
        if (bVar.hB(9)) {
            a((a<V, M>) v, (V) m);
        }
    }

    protected void a(@NonNull V v, @NonNull M m) {
        a((a<V, M>) v, (V) m, (com.facebook.drawee.controller.b<f>) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(@NonNull V v, @NonNull M m, @Nullable com.facebook.drawee.controller.b<f> bVar) {
        Uri lT;
        if (m.cxC != null) {
            if (DEBUG) {
                Log.d("Component-SimpleDrawee", "renderImageStyle");
            }
            String str = m.cxu;
            if (!TextUtils.isEmpty(str) && (lT = lT(str)) != null) {
                c.i("Component-SimpleDrawee", "Image Uri:" + lT);
                e b = com.facebook.drawee.a.a.c.ehd().c(v.getController());
                if (bVar != null) {
                    b.c(bVar);
                }
                b.S(lT);
                com.facebook.drawee.controller.a ehQ = b.ehU();
                RoundingParams roundingParams = new RoundingParams();
                roundingParams.bl(m.cxD);
                com.facebook.drawee.generic.a eiD = new com.facebook.drawee.generic.b(v.getResources()).eiD();
                eiD.a(roundingParams);
                eiD.b(p.b.oGm);
                v.setHierarchy(eiD);
                v.setController(ehQ);
            }
        }
    }

    public static Uri lT(@NonNull String str) {
        String str2;
        String str3;
        PathType tj = com.baidu.swan.apps.storage.b.tj(str);
        com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
        if (aEU != null) {
            str3 = aEU.id;
            str2 = aEU.getVersion();
        } else {
            str2 = null;
            str3 = null;
        }
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
            return null;
        }
        switch (tj) {
            case BD_FILE:
                String cz = com.baidu.swan.apps.storage.b.cz(str, str3);
                if (TextUtils.isEmpty(cz)) {
                    return null;
                }
                return Uri.fromFile(new File(cz));
            case RELATIVE:
                File file = new File(str);
                if (file.exists()) {
                    return Uri.fromFile(file);
                }
                String a2 = com.baidu.swan.apps.storage.b.a(str, aEU, str2);
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
