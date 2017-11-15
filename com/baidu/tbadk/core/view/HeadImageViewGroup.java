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
    public StoryHeaderOutView akg;
    private HeadImageView akr;
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
        this.mRootView = View.inflate(getContext(), d.h.head_view_group, null);
        addView(this.mRootView);
        this.akg = (StoryHeaderOutView) findViewById(d.g.out_img);
        this.akg.setIsRound(true);
        this.akg.setVisibility(0);
        this.akr = (HeadImageView) findViewById(d.g.inner_img);
        this.akr.setScaleType(ImageView.ScaleType.FIT_XY);
        this.akr.setDrawBorder(false);
    }

    public HeadImageView getInnerImg() {
        return this.akr;
    }

    public void setOuterColor(int i) {
        this.akg.setColor(i);
    }

    public void a(a aVar, int i) {
        if (this.akg != null) {
            StoryHeaderOutView storyHeaderOutView = this.akg;
            StoryHeaderOutView storyHeaderOutView2 = this.akg;
            storyHeaderOutView.setMaskColor(1);
            this.akg.invalidate();
        }
    }

    public void we() {
        if (this.akg != null) {
            this.akg.bqg();
            StoryHeaderOutView storyHeaderOutView = this.akg;
            StoryHeaderOutView storyHeaderOutView2 = this.akg;
            storyHeaderOutView.setMaskColor(0);
            this.akg.invalidate();
        }
    }

    public void aG(boolean z) {
        int i;
        if (this.akg != null) {
            StoryHeaderOutView storyHeaderOutView = this.akg;
            if (z) {
                StoryHeaderOutView storyHeaderOutView2 = this.akg;
                i = 3;
            } else {
                StoryHeaderOutView storyHeaderOutView3 = this.akg;
                i = 0;
            }
            storyHeaderOutView.setMaskColor(i);
            this.akg.invalidate();
        }
    }

    public void aH(boolean z) {
        int i;
        if (this.akg != null) {
            StoryHeaderOutView storyHeaderOutView = this.akg;
            if (z) {
                StoryHeaderOutView storyHeaderOutView2 = this.akg;
                i = 0;
            } else {
                StoryHeaderOutView storyHeaderOutView3 = this.akg;
                i = 4;
            }
            storyHeaderOutView.setMaskColor(i);
            this.akg.invalidate();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.akg != null) {
            this.akg.onChangeSkinType(i);
        }
    }
}
