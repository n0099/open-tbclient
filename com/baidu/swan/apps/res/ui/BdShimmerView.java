package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.ShimmerFrameLayout;
/* loaded from: classes2.dex */
public class BdShimmerView extends ShimmerFrameLayout implements com.baidu.swan.apps.res.widget.loadingview.b<BdShimmerView> {
    private ImageView aHQ;
    private int mType;

    public BdShimmerView(Context context) {
        this(context, null, 0);
    }

    public BdShimmerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BdShimmerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    protected void init(Context context) {
        this.aHQ = new ImageView(context);
        this.aHQ.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        addView(this.aHQ);
    }

    public void setType(int i) {
        this.mType = i;
        Jg();
    }

    private void Jg() {
        switch (this.mType) {
            case 0:
                this.aHQ.setImageDrawable(getResources().getDrawable(a.e.aiapps_black_shimmer_loading));
                ShimmerFrameLayout.MaskShape maskShape = ShimmerFrameLayout.MaskShape.LINEAR;
                if (com.baidu.swan.apps.u.a.DW().Ev()) {
                    maskShape = ShimmerFrameLayout.MaskShape.WHITE_LINEAR;
                }
                setMaskShape(maskShape);
                return;
            case 1:
                this.aHQ.setImageDrawable(getResources().getDrawable(a.e.aiapps_white_shimmer_loading));
                setMaskShape(ShimmerFrameLayout.MaskShape.WHITE_LINEAR);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.ShimmerFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.swan.apps.u.a.DW().a(this, new com.baidu.swan.apps.ai.a() { // from class: com.baidu.swan.apps.res.ui.BdShimmerView.1
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.ShimmerFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.swan.apps.u.a.DW().H(this);
    }

    public void setPageResources() {
        Jg();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.res.widget.loadingview.b
    public BdShimmerView getLoadingView() {
        return this;
    }
}
