package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.swan.apps.res.ui.ShimmerFrameLayout;
import d.a.h0.a.e;
import d.a.h0.a.q1.b.d.b;
/* loaded from: classes3.dex */
public class BdShimmerView extends ShimmerFrameLayout implements b<BdShimmerView> {
    public ImageView w;
    public int x;

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.x1.a {
        public a() {
        }
    }

    public BdShimmerView(Context context) {
        this(context, null, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.q1.b.d.b
    public BdShimmerView getLoadingView() {
        return this;
    }

    @Override // com.baidu.swan.apps.res.ui.ShimmerFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d.a.h0.a.w0.a.z().f(this, new a());
    }

    @Override // com.baidu.swan.apps.res.ui.ShimmerFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d.a.h0.a.w0.a.z().g(this);
    }

    public void setPageResources() {
        v();
    }

    public void setType(int i2) {
        this.x = i2;
        v();
    }

    public void u(Context context) {
        this.w = new ImageView(context);
        this.w.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        addView(this.w);
    }

    public final void v() {
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
        if (d.a.h0.a.w0.a.z().a()) {
            maskShape = ShimmerFrameLayout.MaskShape.WHITE_LINEAR;
        }
        setMaskShape(maskShape);
    }

    public BdShimmerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BdShimmerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        u(context);
    }
}
