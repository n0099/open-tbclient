package com.baidu.searchbox.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.android.ext.widget.LoadingViewHolder;
import com.baidu.android.util.media.PreloadUIResUtil;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.ui.ShimmerFrameLayout;
/* loaded from: classes5.dex */
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
                Drawable preloadedDrawable = PreloadUIResUtil.getPreloadedDrawable(com.baidu.android.common.loading.R.drawable.black_shimmer_loading);
                if (preloadedDrawable == null) {
                    this.mShimmerContent.setImageDrawable(getResources().getDrawable(com.baidu.android.common.loading.R.drawable.black_shimmer_loading));
                } else {
                    this.mShimmerContent.setImageDrawable(preloadedDrawable);
                }
                ShimmerFrameLayout.MaskShape maskShape = ShimmerFrameLayout.MaskShape.LINEAR;
                if (NightModeHelper.getNightModeSwitcherState()) {
                    maskShape = ShimmerFrameLayout.MaskShape.WHITE_LINEAR;
                }
                setMaskShape(maskShape);
                return;
            case 1:
                Drawable preloadedDrawable2 = PreloadUIResUtil.getPreloadedDrawable(com.baidu.android.common.loading.R.drawable.white_shimmer_loading);
                if (preloadedDrawable2 == null) {
                    this.mShimmerContent.setImageDrawable(getResources().getDrawable(com.baidu.android.common.loading.R.drawable.white_shimmer_loading));
                } else {
                    this.mShimmerContent.setImageDrawable(preloadedDrawable2);
                }
                setMaskShape(ShimmerFrameLayout.MaskShape.WHITE_LINEAR);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ui.ShimmerFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        NightModeHelper.subscribeNightModeChangeEvent(this, new NightModeChangeListener() { // from class: com.baidu.searchbox.ui.BdShimmerView.1
            @Override // com.baidu.searchbox.skin.callback.NightModeChangeListener
            public void onNightModeChanged(boolean z) {
                BdShimmerView.this.setPageResources();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ui.ShimmerFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        NightModeHelper.unsubscribeNightModeChangedEvent(this);
    }

    public void setPageResources() {
        setTypeAttrs();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.android.ext.widget.LoadingViewHolder
    public BdShimmerView getLoadingView() {
        return this;
    }

    @Override // com.baidu.android.ext.widget.LoadingViewHolder
    public void show() {
        setVisibility(0);
    }

    @Override // com.baidu.android.ext.widget.LoadingViewHolder
    public void dismiss() {
        setVisibility(8);
    }
}
