package com.baidu.live.gift.widget.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class GiftPanelCountBadgeView extends FrameLayout {
    private int bjj;
    private boolean bjk;
    private ImageView mImageView;
    private TextView mTextView;

    public GiftPanelCountBadgeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setPlusThreshold(int i, boolean z) {
        this.bjj = i;
        this.bjk = z;
    }

    public void setCount(int i) {
        boolean z = this.bjj > 0 && i > this.bjj;
        if (this.mImageView != null && this.bjk) {
            this.mImageView.setImageResource(z ? a.e.live_gift_panel_count_badge_large_icon : a.e.live_gift_panel_count_badge_small_icon);
        }
        if (this.mTextView != null) {
            this.mTextView.setText(z ? this.bjj + "+" : String.valueOf(i));
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.live_gift_panel_count_badge, (ViewGroup) this, true);
        this.mImageView = (ImageView) findViewById(a.f.iv_count);
        this.mTextView = (TextView) findViewById(a.f.tv_count);
    }
}
