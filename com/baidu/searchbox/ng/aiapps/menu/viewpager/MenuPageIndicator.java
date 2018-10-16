package com.baidu.searchbox.ng.aiapps.menu.viewpager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
/* loaded from: classes2.dex */
class MenuPageIndicator extends PointPageIndicator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MenuPageIndicator(Context context) {
        super(context);
    }

    MenuPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    MenuPageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ng.aiapps.menu.viewpager.PointPageIndicator
    public MenuPageIndicator setPointDrawable(Drawable drawable, Drawable drawable2) {
        this.mNormalDrawable = drawable;
        this.mSelectDrawable = drawable2;
        this.mNormalPointRect.set(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.mSelectPointRect.set(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        return this;
    }
}
