package com.baidu.swan.apps.component.components.b;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes9.dex */
public final class a extends com.baidu.swan.apps.component.a.c.a<TextView, c> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@Nullable Context context, @NonNull c cVar) {
        super(context, cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: cy */
    public TextView cv(@NonNull Context context) {
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
        int i = cVar.cKU;
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
