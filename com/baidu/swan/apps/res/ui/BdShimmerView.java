package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.swan.apps.res.ui.ShimmerFrameLayout;
import d.a.m0.a.e;
import d.a.m0.a.z1.b.d.b;
/* loaded from: classes3.dex */
public class BdShimmerView extends ShimmerFrameLayout implements b<BdShimmerView> {
    public ImageView w;
    public int x;

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.g2.a {
        public a() {
        }
    }

    public BdShimmerView(Context context) {
        this(context, null, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.z1.b.d.b
    public BdShimmerView getLoadingView() {
        return this;
    }

    @Override // com.baidu.swan.apps.res.ui.ShimmerFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d.a.m0.a.c1.a.H().f(this, new a());
    }

    @Override // com.baidu.swan.apps.res.ui.ShimmerFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d.a.m0.a.c1.a.H().g(this);
    }

    public void setPageResources() {
        w();
    }

    public void setType(int i2) {
        this.x = i2;
        w();
    }

    public void u() {
        setVisibility(8);
    }

    public void v(Context context) {
        this.w = new ImageView(context);
        this.w.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        addView(this.w);
    }

    public final void w() {
        int i2 = this.x;
        if (i2 != 0) {
            if (i2 != 1) {
                return;
            }
            this.w.setImageDrawable(getResources().getDrawable(e.aiapps_white_shimmer_loading));
            setMaskShape(ShimmerFrameLayout.MaskShape.WHITE_LINEAR);
            return;
        }
        this.w.setImageDrawable(getResources().getDrawable(e.aiapps_black_shimmer_loading));
        ShimmerFrameLayout.MaskShape maskShape = ShimmerFrameLayout.MaskShape.LINEAR;
        if (d.a.m0.a.c1.a.H().a()) {
            maskShape = ShimmerFrameLayout.MaskShape.WHITE_LINEAR;
        }
        setMaskShape(maskShape);
    }

    public BdShimmerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BdShimmerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        v(context);
    }
}
