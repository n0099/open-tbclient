package com.baidu.swan.menu.viewpager;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes4.dex */
class a extends PointPageIndicator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        super(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.menu.viewpager.PointPageIndicator
    /* renamed from: a */
    public a b(Drawable drawable, Drawable drawable2) {
        this.euP = drawable;
        this.euQ = drawable2;
        this.euR.set(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.euS.set(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        return this;
    }
}
