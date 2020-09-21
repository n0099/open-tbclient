package com.baidu.swan.apps.component.components.e.c;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
/* loaded from: classes3.dex */
public final class a extends com.baidu.swan.apps.component.a.c.a<TextView, b> {
    private SwanAppComponentContainerView cdq;
    private TextView mTextView;

    public a(@NonNull Context context, @NonNull b bVar) {
        super(context, bVar);
        gO(4);
        this.cdq = new SwanAppComponentContainerView(context);
        this.mTextView = new TextView(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: bG */
    public TextView be(@NonNull Context context) {
        return this.mTextView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.c.a, com.baidu.swan.apps.component.a.d.a, com.baidu.swan.apps.component.b.a
    @NonNull
    public com.baidu.swan.apps.component.d.b a(@NonNull b bVar, @NonNull b bVar2) {
        com.baidu.swan.apps.component.d.b a = super.a(bVar, bVar2);
        if (!TextUtils.equals(bVar.cdx, bVar2.cdx) && (TextUtils.equals(bVar.cdx, "scroll") || TextUtils.equals(bVar2.cdx, "scroll"))) {
            a.gS(7);
        }
        if (!TextUtils.equals(bVar.cdx, bVar2.cdx) || (TextUtils.equals(bVar2.cdx, "scroll") && bVar.cdw != bVar2.cdw)) {
            a.gS(8);
        }
        return a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.d.a
    public void a(@NonNull TextView textView, @NonNull b bVar) {
        if (DEBUG) {
            Log.d("Component-CoverView", "renderBackground");
        }
        if (bVar.ccK != null) {
            SwanAppComponentContainerView adN = adN();
            if (adN != null) {
                adN.setModel(bVar);
            }
            ViewParent parent = textView.getParent();
            if (parent instanceof View) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(bVar.backgroundColor);
                gradientDrawable.setCornerRadius(bVar.ccL);
                gradientDrawable.setStroke(bVar.borderWidth, bVar.borderColor);
                ((View) parent).setBackground(gradientDrawable);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.d.a
    /* renamed from: a */
    public void c(@NonNull View view, @NonNull b bVar) {
        if (DEBUG) {
            Log.d("Component-CoverView", "renderAlpha");
        }
        if (bVar.ccK != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                super.c((View) parent, (View) bVar);
            }
        }
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected SwanAppComponentContainerView bE(@NonNull Context context) {
        return this.cdq;
    }
}
