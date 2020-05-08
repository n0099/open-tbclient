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
/* loaded from: classes11.dex */
public final class a extends com.baidu.swan.apps.component.a.c.a<TextView, b> {
    private SwanAppComponentContainerView bHd;
    private TextView mTextView;

    public a(@NonNull Context context, @NonNull b bVar) {
        super(context, bVar);
        ej(4);
        this.bHd = new SwanAppComponentContainerView(context);
        this.mTextView = new TextView(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: bm */
    public TextView aO(@NonNull Context context) {
        return this.mTextView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.c.a, com.baidu.swan.apps.component.a.d.a, com.baidu.swan.apps.component.b.a
    @NonNull
    public com.baidu.swan.apps.component.d.b a(@NonNull b bVar, @NonNull b bVar2) {
        com.baidu.swan.apps.component.d.b a = super.a(bVar, bVar2);
        if (!TextUtils.equals(bVar.bHk, bVar2.bHk) && (TextUtils.equals(bVar.bHk, "scroll") || TextUtils.equals(bVar2.bHk, "scroll"))) {
            a.en(7);
        }
        if (!TextUtils.equals(bVar.bHk, bVar2.bHk) || (TextUtils.equals(bVar2.bHk, "scroll") && bVar.bHj != bVar2.bHj)) {
            a.en(8);
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
        if (bVar.bGy != null) {
            ViewParent parent = textView.getParent();
            if (parent instanceof View) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(bVar.backgroundColor);
                gradientDrawable.setCornerRadius(bVar.bGz);
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
        if (bVar.bGy != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                super.c((View) parent, (View) bVar);
            }
        }
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected SwanAppComponentContainerView bk(@NonNull Context context) {
        return this.bHd;
    }
}
