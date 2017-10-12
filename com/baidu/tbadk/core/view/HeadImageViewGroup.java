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
    public StoryHeaderOutView akf;
    private HeadImageView akg;
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
        this.akf = (StoryHeaderOutView) findViewById(d.h.out_img);
        this.akf.setIsRound(true);
        this.akf.setVisibility(0);
        this.akg = (HeadImageView) findViewById(d.h.inner_img);
        this.akg.setScaleType(ImageView.ScaleType.FIT_XY);
        this.akg.setDrawBorder(false);
    }

    public HeadImageView getInnerImg() {
        return this.akg;
    }

    public void setOuterColor(int i) {
        this.akf.setColor(i);
    }

    public void a(a aVar, int i) {
        if (this.akf != null) {
            StoryHeaderOutView storyHeaderOutView = this.akf;
            StoryHeaderOutView storyHeaderOutView2 = this.akf;
            storyHeaderOutView.setMaskColor(1);
            this.akf.invalidate();
        }
    }

    public void we() {
        if (this.akf != null) {
            this.akf.bmX();
            StoryHeaderOutView storyHeaderOutView = this.akf;
            StoryHeaderOutView storyHeaderOutView2 = this.akf;
            storyHeaderOutView.setMaskColor(0);
            this.akf.invalidate();
        }
    }

    public void aJ(boolean z) {
        int i;
        if (this.akf != null) {
            StoryHeaderOutView storyHeaderOutView = this.akf;
            if (z) {
                StoryHeaderOutView storyHeaderOutView2 = this.akf;
                i = 3;
            } else {
                StoryHeaderOutView storyHeaderOutView3 = this.akf;
                i = 0;
            }
            storyHeaderOutView.setMaskColor(i);
            this.akf.invalidate();
        }
    }

    public void aK(boolean z) {
        int i;
        if (this.akf != null) {
            StoryHeaderOutView storyHeaderOutView = this.akf;
            if (z) {
                StoryHeaderOutView storyHeaderOutView2 = this.akf;
                i = 0;
            } else {
                StoryHeaderOutView storyHeaderOutView3 = this.akf;
                i = 4;
            }
            storyHeaderOutView.setMaskColor(i);
            this.akf.invalidate();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.akf != null) {
            this.akf.onChangeSkinType(i);
        }
    }
}
