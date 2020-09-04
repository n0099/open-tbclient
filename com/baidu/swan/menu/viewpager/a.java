package com.baidu.swan.menu.viewpager;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes14.dex */
class a extends PointPageIndicator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        super(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.menu.viewpager.PointPageIndicator
    /* renamed from: a */
    public a b(Drawable drawable, Drawable drawable2) {
        this.dEE = drawable;
        this.dEF = drawable2;
        this.dEG.set(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.dEH.set(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        return this;
    }
}
