package com.baidu.searchbox.ng.ai.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.res.ui.ShimmerFrameLayout;
import com.baidu.searchbox.ng.ai.apps.res.widget.loadingview.LoadingViewHolder;
import com.baidu.searchbox.ng.ai.apps.skin.AiAppNightModeChangeListener;
import com.baidu.searchbox.ng.ai.apps.skin.AiAppNightModeHelper;
/* loaded from: classes2.dex */
public class BdShimmerView extends ShimmerFrameLayout implements LoadingViewHolder<BdShimmerView> {
    public static final int BLACK_LOADING = 0;
    public static final int WHITE_LOADING = 1;
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
                this.mShimmerContent.setImageDrawable(getResources().getDrawable(R.drawable.aiapps_black_shimmer_loading));
                ShimmerFrameLayout.MaskShape maskShape = ShimmerFrameLayout.MaskShape.LINEAR;
                if (AiAppNightModeHelper.getNightModeSwitcherState()) {
                    maskShape = ShimmerFrameLayout.MaskShape.WHITE_LINEAR;
                }
                setMaskShape(maskShape);
                return;
            case 1:
                this.mShimmerContent.setImageDrawable(getResources().getDrawable(R.drawable.aiapps_white_shimmer_loading));
                setMaskShape(ShimmerFrameLayout.MaskShape.WHITE_LINEAR);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.ShimmerFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AiAppNightModeHelper.subscribeNightModeChangeEvent(this, new AiAppNightModeChangeListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.BdShimmerView.1
            @Override // com.baidu.searchbox.ng.ai.apps.skin.AiAppNightModeChangeListener
            public void onNightModeChanged(boolean z) {
                BdShimmerView.this.setPageResources();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.ShimmerFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AiAppNightModeHelper.unsubscribeNightModeChangedEvent(this);
    }

    public void setPageResources() {
        setTypeAttrs();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ng.ai.apps.res.widget.loadingview.LoadingViewHolder
    public BdShimmerView getLoadingView() {
        return this;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.widget.loadingview.LoadingViewHolder
    public void show() {
        setVisibility(0);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.widget.loadingview.LoadingViewHolder
    public void dismiss() {
        setVisibility(8);
    }
}
