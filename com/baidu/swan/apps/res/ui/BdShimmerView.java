package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.swan.apps.res.ui.ShimmerFrameLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.fu2;
import com.baidu.tieba.ha3;
import com.baidu.tieba.mg3;
/* loaded from: classes4.dex */
public class BdShimmerView extends ShimmerFrameLayout implements ha3<BdShimmerView> {
    public ImageView s;
    public int t;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ha3
    public BdShimmerView getLoadingView() {
        return this;
    }

    /* loaded from: classes4.dex */
    public class a implements mg3 {
        public a() {
        }
    }

    public BdShimmerView(Context context) {
        this(context, null, 0);
    }

    public void setType(int i) {
        this.t = i;
        v();
    }

    public void u(Context context) {
        this.s = new ImageView(context);
        this.s.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        addView(this.s);
    }

    public BdShimmerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BdShimmerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        u(context);
    }

    @Override // com.baidu.swan.apps.res.ui.ShimmerFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fu2.M().f(this, new a());
    }

    @Override // com.baidu.swan.apps.res.ui.ShimmerFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fu2.M().g(this);
    }

    public void setPageResources() {
        v();
    }

    public final void v() {
        int i = this.t;
        if (i != 0) {
            if (i == 1) {
                this.s.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0801e4));
                setMaskShape(ShimmerFrameLayout.MaskShape.WHITE_LINEAR);
                return;
            }
            return;
        }
        this.s.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080149));
        ShimmerFrameLayout.MaskShape maskShape = ShimmerFrameLayout.MaskShape.LINEAR;
        if (fu2.M().a()) {
            maskShape = ShimmerFrameLayout.MaskShape.WHITE_LINEAR;
        }
        setMaskShape(maskShape);
    }
}
