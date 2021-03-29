package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.swan.apps.res.ui.ShimmerFrameLayout;
import d.b.g0.a.e;
import d.b.g0.a.q1.b.d.b;
/* loaded from: classes2.dex */
public class BdShimmerView extends ShimmerFrameLayout implements b<BdShimmerView> {
    public ImageView w;
    public int x;

    /* loaded from: classes2.dex */
    public class a implements d.b.g0.a.x1.a {
        public a() {
        }
    }

    public BdShimmerView(Context context) {
        this(context, null, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.q1.b.d.b
    public BdShimmerView getLoadingView() {
        return this;
    }

    @Override // com.baidu.swan.apps.res.ui.ShimmerFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d.b.g0.a.w0.a.z().f(this, new a());
    }

    @Override // com.baidu.swan.apps.res.ui.ShimmerFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d.b.g0.a.w0.a.z().g(this);
    }

    public void setPageResources() {
        v();
    }

    public void setType(int i) {
        this.x = i;
        v();
    }

    public void u(Context context) {
        this.w = new ImageView(context);
        this.w.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        addView(this.w);
    }

    public final void v() {
        int i = this.x;
        if (i != 0) {
            if (i != 1) {
                return;
            }
            this.w.setImageDrawable(getResources().getDrawable(e.aiapps_white_shimmer_loading));
            setMaskShape(ShimmerFrameLayout.MaskShape.WHITE_LINEAR);
            return;
        }
        this.w.setImageDrawable(getResources().getDrawable(e.aiapps_black_shimmer_loading));
        ShimmerFrameLayout.MaskShape maskShape = ShimmerFrameLayout.MaskShape.LINEAR;
        if (d.b.g0.a.w0.a.z().a()) {
            maskShape = ShimmerFrameLayout.MaskShape.WHITE_LINEAR;
        }
        setMaskShape(maskShape);
    }

    public BdShimmerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BdShimmerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        u(context);
    }
}
