package com.baidu.swan.apps.component.components.e.b;

import android.content.Context;
import android.graphics.drawable.Animatable;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.facebook.drawee.drawable.p;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.f.f;
/* loaded from: classes8.dex */
public final class b extends com.baidu.swan.apps.component.a.b.a<SimpleDraweeView, c> {
    private a cJt;
    private SwanAppComponentContainerView cJu;
    private SimpleDraweeView cJv;

    public b(@NonNull Context context, @NonNull c cVar) {
        super(context, cVar);
        gn(4);
        this.cJu = new SwanAppComponentContainerView(context);
        this.cJv = new SimpleDraweeView(context);
    }

    public void a(a aVar) {
        this.cJt = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: cC */
    public SimpleDraweeView cw(@NonNull Context context) {
        return this.cJv;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    /* renamed from: a */
    public void ax(@NonNull SimpleDraweeView simpleDraweeView) {
        super.ax(simpleDraweeView);
        simpleDraweeView.getHierarchy().b(p.b.ptg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.b.a, com.baidu.swan.apps.component.a.d.a, com.baidu.swan.apps.component.b.a
    @NonNull
    public com.baidu.swan.apps.component.d.b a(@NonNull c cVar, @NonNull c cVar2) {
        com.baidu.swan.apps.component.d.b a2 = super.a(cVar, cVar2);
        if (cVar.cJz != cVar2.cJz) {
            a2.gs(9);
        }
        return a2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.b.a
    public void a(@NonNull SimpleDraweeView simpleDraweeView, @NonNull c cVar, @NonNull com.baidu.swan.apps.component.d.b bVar) {
        super.a((b) simpleDraweeView, (SimpleDraweeView) cVar, bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.b.a
    public void a(@NonNull SimpleDraweeView simpleDraweeView, @NonNull c cVar) {
        super.a((b) simpleDraweeView, (SimpleDraweeView) cVar, b(simpleDraweeView, cVar));
    }

    private com.facebook.drawee.controller.b<f> b(@NonNull final SimpleDraweeView simpleDraweeView, @NonNull c cVar) {
        final boolean z = cVar.cJz;
        return new com.facebook.drawee.controller.b<f>() { // from class: com.baidu.swan.apps.component.components.e.b.b.1
            @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
            public void h(String str, Throwable th) {
                super.h(str, th);
                if (z && b.this.cJt != null) {
                    b.this.cJt.a(0, simpleDraweeView, null);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
            public void a(String str, f fVar, Animatable animatable) {
                super.a(str, (String) fVar, animatable);
                if (z && b.this.cJt != null) {
                    b.this.cJt.a(1, simpleDraweeView, null);
                }
            }
        };
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected SwanAppComponentContainerView cx(@NonNull Context context) {
        return this.cJu;
    }
}
