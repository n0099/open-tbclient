package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.ShimmerFrameLayout;
/* loaded from: classes10.dex */
public class BdShimmerView extends ShimmerFrameLayout implements com.baidu.swan.apps.res.widget.loadingview.b<BdShimmerView> {
    private ImageView mShimmerContent;
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
        this.mShimmerContent = new ImageView(context);
        this.mShimmerContent.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        addView(this.mShimmerContent);
    }

    public void setType(int i) {
        this.mType = i;
        setTypeAttrs();
    }

    private void setTypeAttrs() {
        switch (this.mType) {
            case 0:
                this.mShimmerContent.setImageDrawable(getResources().getDrawable(a.e.aiapps_black_shimmer_loading));
                ShimmerFrameLayout.MaskShape maskShape = ShimmerFrameLayout.MaskShape.LINEAR;
                if (com.baidu.swan.apps.t.a.auw().getNightModeSwitcherState()) {
                    maskShape = ShimmerFrameLayout.MaskShape.WHITE_LINEAR;
                }
                setMaskShape(maskShape);
                return;
            case 1:
                this.mShimmerContent.setImageDrawable(getResources().getDrawable(a.e.aiapps_white_shimmer_loading));
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
        com.baidu.swan.apps.t.a.auw().a(this, new com.baidu.swan.apps.aj.a() { // from class: com.baidu.swan.apps.res.ui.BdShimmerView.1
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.ShimmerFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.swan.apps.t.a.auw().unsubscribeNightModeChangedEvent(this);
    }

    public void setPageResources() {
        setTypeAttrs();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.res.widget.loadingview.b
    public BdShimmerView getLoadingView() {
        return this;
    }
}
