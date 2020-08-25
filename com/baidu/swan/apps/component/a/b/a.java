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
        com.baidu.swan.apps.component.d.b a = super.a(m, m2);
        if (!TextUtils.equals(m.caw, m2.caw)) {
            a.gJ(9);
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@NonNull V v, @NonNull M m, @NonNull com.baidu.swan.apps.component.d.b bVar) {
        super.a((a<V, M>) v, (V) m, bVar);
        if (bVar.gK(9)) {
            a((a<V, M>) v, (V) m);
        }
    }

    protected void a(@NonNull V v, @NonNull M m) {
        a((a<V, M>) v, (V) m, (com.facebook.drawee.controller.b<f>) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(@NonNull V v, @NonNull M m, @Nullable com.facebook.drawee.controller.b<f> bVar) {
        Uri ku;
        if (m.caE != null) {
            if (DEBUG) {
                Log.d("Component-SimpleDrawee", "renderImageStyle");
            }
            String str = m.caw;
            if (!TextUtils.isEmpty(str) && (ku = ku(str)) != null) {
                c.i("Component-SimpleDrawee", "Image Uri:" + ku);
                e b = com.facebook.drawee.a.a.c.dPn().c(v.getController());
                if (bVar != null) {
                    b.c(bVar);
                }
                b.Q(ku);
                com.facebook.drawee.controller.a dQa = b.dQe();
                RoundingParams roundingParams = new RoundingParams();
                roundingParams.aO(m.caF);
                com.facebook.drawee.generic.a dQN = new com.facebook.drawee.generic.b(v.getResources()).dQN();
                dQN.a(roundingParams);
                dQN.b(p.b.npk);
                v.setHierarchy(dQN);
                v.setController(dQa);
            }
        }
    }

    public static Uri ku(@NonNull String str) {
        String str2;
        String str3;
        PathType rJ = com.baidu.swan.apps.storage.b.rJ(str);
        com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
        if (azI != null) {
            str3 = azI.id;
            str2 = azI.getVersion();
        } else {
            str2 = null;
            str3 = null;
        }
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
            return null;
        }
        switch (rJ) {
            case BD_FILE:
                String cn2 = com.baidu.swan.apps.storage.b.cn(str, str3);
                if (TextUtils.isEmpty(cn2)) {
                    return null;
                }
                return Uri.fromFile(new File(cn2));
            case RELATIVE:
                File file = new File(str);
                if (file.exists()) {
                    return Uri.fromFile(file);
                }
                String a = com.baidu.swan.apps.storage.b.a(str, azI, str2);
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
