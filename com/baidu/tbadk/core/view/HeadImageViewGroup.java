package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.story.StoryHeaderOutView;
/* loaded from: classes.dex */
public class HeadImageViewGroup extends FrameLayout {
    public StoryHeaderOutView akd;
    private HeadImageView ake;
    private View mRootView;

    /* loaded from: classes.dex */
    public interface a {
    }

    public HeadImageViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public HeadImageViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.mRootView = View.inflate(getContext(), d.j.head_view_group, null);
        addView(this.mRootView);
        this.akd = (StoryHeaderOutView) findViewById(d.h.out_img);
        this.akd.setIsRound(true);
        this.akd.setVisibility(0);
        this.ake = (HeadImageView) findViewById(d.h.inner_img);
        this.ake.setScaleType(ImageView.ScaleType.FIT_XY);
        this.ake.setDrawBorder(false);
    }

    public HeadImageView getInnerImg() {
        return this.ake;
    }

    public void setOuterColor(int i) {
        this.akd.setColor(i);
    }

    public void a(a aVar, int i) {
        if (this.akd != null) {
            StoryHeaderOutView storyHeaderOutView = this.akd;
            StoryHeaderOutView storyHeaderOutView2 = this.akd;
            storyHeaderOutView.setMaskColor(1);
            this.akd.invalidate();
        }
    }

    public void wz() {
        if (this.akd != null) {
            this.akd.boe();
            StoryHeaderOutView storyHeaderOutView = this.akd;
            StoryHeaderOutView storyHeaderOutView2 = this.akd;
            storyHeaderOutView.setMaskColor(0);
            this.akd.invalidate();
        }
    }

    public void aJ(boolean z) {
        int i;
        if (this.akd != null) {
            StoryHeaderOutView storyHeaderOutView = this.akd;
            if (z) {
                StoryHeaderOutView storyHeaderOutView2 = this.akd;
                i = 3;
            } else {
                StoryHeaderOutView storyHeaderOutView3 = this.akd;
                i = 0;
            }
            storyHeaderOutView.setMaskColor(i);
            this.akd.invalidate();
        }
    }

    public void aK(boolean z) {
        int i;
        if (this.akd != null) {
            StoryHeaderOutView storyHeaderOutView = this.akd;
            if (z) {
                StoryHeaderOutView storyHeaderOutView2 = this.akd;
                i = 0;
            } else {
                StoryHeaderOutView storyHeaderOutView3 = this.akd;
                i = 4;
            }
            storyHeaderOutView.setMaskColor(i);
            this.akd.invalidate();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.akd != null) {
            this.akd.onChangeSkinType(i);
        }
    }
}
