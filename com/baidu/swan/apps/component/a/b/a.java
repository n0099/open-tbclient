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
/* loaded from: classes11.dex */
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
        com.baidu.swan.apps.component.d.b a = super.a(m, m2);
        if (!TextUtils.equals(m.bia, m2.bia)) {
            a.ei(9);
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@NonNull V v, @NonNull M m, @NonNull com.baidu.swan.apps.component.d.b bVar) {
        super.a((a<V, M>) v, (V) m, bVar);
        if (bVar.ej(9)) {
            a((a<V, M>) v, (V) m);
        }
    }

    protected void a(@NonNull V v, @NonNull M m) {
        a((a<V, M>) v, (V) m, (com.facebook.drawee.controller.b<f>) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(@NonNull V v, @NonNull M m, @Nullable com.facebook.drawee.controller.b<f> bVar) {
        Uri go;
        if (m.bik != null) {
            if (DEBUG) {
                Log.d("Component-SimpleDrawee", "renderImageStyle");
            }
            String str = m.bia;
            if (!TextUtils.isEmpty(str) && (go = go(str)) != null) {
                c.d("Component-SimpleDrawee", "Image Uri:" + go);
                e b = com.facebook.drawee.a.a.c.dlW().c(v.getController());
                if (bVar != null) {
                    b.c(bVar);
                }
                b.K(go);
                com.facebook.drawee.controller.a dmJ = b.dmN();
                RoundingParams roundingParams = new RoundingParams();
                roundingParams.bo(m.bil);
                com.facebook.drawee.generic.a dnx = new com.facebook.drawee.generic.b(v.getResources()).dnx();
                dnx.a(roundingParams);
                dnx.b(p.b.lOE);
                v.setHierarchy(dnx);
                v.setController(dmJ);
            }
        }
    }

    private Uri go(@NonNull String str) {
        String str2;
        String str3;
        PathType lZ = com.baidu.swan.apps.storage.b.lZ(str);
        com.baidu.swan.apps.runtime.e acI = com.baidu.swan.apps.runtime.e.acI();
        if (acI != null) {
            str3 = acI.id;
            str2 = acI.getVersion();
        } else {
            str2 = null;
            str3 = null;
        }
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
            return null;
        }
        switch (lZ) {
            case BD_FILE:
                String bo = com.baidu.swan.apps.storage.b.bo(str, str3);
                if (TextUtils.isEmpty(bo)) {
                    return null;
                }
                return Uri.fromFile(new File(bo));
            case RELATIVE:
                File file = new File(str);
                if (file.exists()) {
                    return Uri.fromFile(file);
                }
                String a = com.baidu.swan.apps.storage.b.a(str, acI, str2);
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
