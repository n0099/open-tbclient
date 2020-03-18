package com.baidu.swan.apps.component.components.b;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;
/* loaded from: classes11.dex */
public final class a extends com.baidu.swan.apps.component.a.c.a<TextView, c> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@Nullable Context context, @NonNull c cVar) {
        super(context, cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: bK */
    public TextView bm(@NonNull Context context) {
        return new TextView(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.c.a
    /* renamed from: a */
    public void c(@NonNull TextView textView, @NonNull c cVar) {
        if (DEBUG) {
            Log.d("Component-Button", "renderTextStyleLineSpace");
        }
        int i = cVar.lineSpace;
        if (i > 0) {
            textView.setLineSpacing((i - textView.getLineHeight()) + textView.getLineSpacingExtra(), 1.0f);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.c.a
    /* renamed from: b */
    public void d(@NonNull TextView textView, @NonNull c cVar) {
        a((a) textView, (TextView) cVar, 16);
    }
}
