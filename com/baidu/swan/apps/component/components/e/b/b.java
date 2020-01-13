package com.baidu.swan.apps.component.components.e.b;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.facebook.drawee.drawable.p;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.g.f;
/* loaded from: classes10.dex */
public final class b extends com.baidu.swan.apps.component.a.b.a<SimpleDraweeView, c> {
    private a bel;
    private SwanAppComponentContainerView bem;
    private SimpleDraweeView ben;

    public b(@NonNull Context context, @NonNull c cVar) {
        super(context, cVar);
        dO(4);
        this.bem = new SwanAppComponentContainerView(context);
        this.ben = new SimpleDraweeView(context);
    }

    public void a(a aVar) {
        this.bel = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: bK */
    public SimpleDraweeView bj(@NonNull Context context) {
        return this.ben;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    /* renamed from: a */
    public void ac(@NonNull SimpleDraweeView simpleDraweeView) {
        super.ac(simpleDraweeView);
        simpleDraweeView.getHierarchy().b(p.b.lLZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.b.a, com.baidu.swan.apps.component.a.d.a, com.baidu.swan.apps.component.b.a
    @NonNull
    public com.baidu.swan.apps.component.d.b a(@NonNull c cVar, @NonNull c cVar2) {
        com.baidu.swan.apps.component.d.b a = super.a(cVar, cVar2);
        if (cVar.ber != cVar2.ber) {
            a.dS(9);
        }
        return a;
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
        final boolean z = cVar.ber;
        return new com.facebook.drawee.controller.b<f>() { // from class: com.baidu.swan.apps.component.components.e.b.b.1
            @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
            public void onFailure(String str, Throwable th) {
                super.onFailure(str, th);
                if (z && b.this.bel != null) {
                    b.this.bel.a(0, simpleDraweeView, null);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
            public void onFinalImageSet(String str, f fVar, Animatable animatable) {
                super.onFinalImageSet(str, (String) fVar, animatable);
                if (z && b.this.bel != null) {
                    b.this.bel.a(1, simpleDraweeView, null);
                }
            }
        };
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected SwanAppComponentContainerView bF(@NonNull Context context) {
        return this.bem;
    }
}
