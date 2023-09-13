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
/* loaded from: classes4.dex */
public class BdShimmerView extends ShimmerFrameLayout implements LoadingViewHolder<BdShimmerView> {
    public static final int BLACK_LOADING = 0;
    public static final int WHITE_LOADING = 1;
    public ImageView mShimmerContent;
    public int mType;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.android.ext.widget.LoadingViewHolder
    public BdShimmerView getLoadingView() {
        return this;
    }

    public BdShimmerView(Context context) {
        this(context, null, 0);
    }

    public void init(Context context) {
        this.mShimmerContent = new ImageView(context);
        this.mShimmerContent.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        addView(this.mShimmerContent);
    }

    public void setType(int i) {
        this.mType = i;
        setTypeAttrs();
    }

    public BdShimmerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BdShimmerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void setTypeAttrs() {
        int i = this.mType;
        if (i != 0) {
            if (i == 1) {
                Drawable preloadedDrawable = PreloadUIResUtil.getPreloadedDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f0815b7);
                if (preloadedDrawable == null) {
                    this.mShimmerContent.setImageDrawable(getResources().getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f0815b7));
                } else {
                    this.mShimmerContent.setImageDrawable(preloadedDrawable);
                }
                setMaskShape(ShimmerFrameLayout.MaskShape.WHITE_LINEAR);
                return;
            }
            return;
        }
        Drawable preloadedDrawable2 = PreloadUIResUtil.getPreloadedDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f08038e);
        if (preloadedDrawable2 == null) {
            this.mShimmerContent.setImageDrawable(getResources().getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f08038e));
        } else {
            this.mShimmerContent.setImageDrawable(preloadedDrawable2);
        }
        ShimmerFrameLayout.MaskShape maskShape = ShimmerFrameLayout.MaskShape.LINEAR;
        if (NightModeHelper.getNightModeSwitcherState()) {
            maskShape = ShimmerFrameLayout.MaskShape.WHITE_LINEAR;
        }
        setMaskShape(maskShape);
    }

    @Override // com.baidu.android.ext.widget.LoadingViewHolder
    public void dismiss() {
        setVisibility(8);
    }

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

    @Override // com.baidu.searchbox.ui.ShimmerFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        NightModeHelper.unsubscribeNightModeChangedEvent(this);
    }

    public void setPageResources() {
        setTypeAttrs();
    }

    @Override // com.baidu.android.ext.widget.LoadingViewHolder
    public void show() {
        setVisibility(0);
    }
}
