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
/* loaded from: classes7.dex */
public final class a extends com.baidu.swan.apps.component.a.c.a<TextView, b> {
    private SwanAppComponentContainerView cCq;
    private TextView mTextView;

    public a(@NonNull Context context, @NonNull b bVar) {
        super(context, bVar);
        hC(4);
        this.cCq = new SwanAppComponentContainerView(context);
        this.mTextView = new TextView(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: bM */
    public TextView bk(@NonNull Context context) {
        return this.mTextView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.c.a, com.baidu.swan.apps.component.a.d.a, com.baidu.swan.apps.component.b.a
    @NonNull
    public com.baidu.swan.apps.component.d.b a(@NonNull b bVar, @NonNull b bVar2) {
        com.baidu.swan.apps.component.d.b a2 = super.a(bVar, bVar2);
        if (!TextUtils.equals(bVar.cCx, bVar2.cCx) && (TextUtils.equals(bVar.cCx, "scroll") || TextUtils.equals(bVar2.cCx, "scroll"))) {
            a2.hG(7);
        }
        if (!TextUtils.equals(bVar.cCx, bVar2.cCx) || (TextUtils.equals(bVar2.cCx, "scroll") && bVar.cCw != bVar2.cCw)) {
            a2.hG(8);
        }
        return a2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.d.a
    public void a(@NonNull TextView textView, @NonNull b bVar) {
        if (DEBUG) {
            Log.d("Component-CoverView", "renderBackground");
        }
        if (bVar.cBL != null) {
            SwanAppComponentContainerView akk = akk();
            if (akk != null) {
                akk.setModel(bVar);
            }
            ViewParent parent = textView.getParent();
            if (parent instanceof View) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(bVar.backgroundColor);
                gradientDrawable.setCornerRadius(bVar.cBM);
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
        if (bVar.cBL != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                super.c((View) parent, (View) bVar);
            }
        }
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected SwanAppComponentContainerView bK(@NonNull Context context) {
        return this.cCq;
    }
}
