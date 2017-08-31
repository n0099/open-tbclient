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
    public StoryHeaderOutView ake;
    private HeadImageView akf;
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
        this.ake = (StoryHeaderOutView) findViewById(d.h.out_img);
        this.ake.setIsRound(true);
        this.ake.setVisibility(0);
        this.akf = (HeadImageView) findViewById(d.h.inner_img);
        this.akf.setScaleType(ImageView.ScaleType.FIT_XY);
        this.akf.setDrawBorder(false);
    }

    public HeadImageView getInnerImg() {
        return this.akf;
    }

    public void setOuterColor(int i) {
        this.ake.setColor(i);
    }

    public void a(a aVar, int i) {
        if (this.ake != null) {
            StoryHeaderOutView storyHeaderOutView = this.ake;
            StoryHeaderOutView storyHeaderOutView2 = this.ake;
            storyHeaderOutView.setMaskColor(1);
            this.ake.invalidate();
        }
    }

    public void wz() {
        if (this.ake != null) {
            this.ake.bnT();
            StoryHeaderOutView storyHeaderOutView = this.ake;
            StoryHeaderOutView storyHeaderOutView2 = this.ake;
            storyHeaderOutView.setMaskColor(0);
            this.ake.invalidate();
        }
    }

    public void aJ(boolean z) {
        int i;
        if (this.ake != null) {
            StoryHeaderOutView storyHeaderOutView = this.ake;
            if (z) {
                StoryHeaderOutView storyHeaderOutView2 = this.ake;
                i = 3;
            } else {
                StoryHeaderOutView storyHeaderOutView3 = this.ake;
                i = 0;
            }
            storyHeaderOutView.setMaskColor(i);
            this.ake.invalidate();
        }
    }

    public void aK(boolean z) {
        int i;
        if (this.ake != null) {
            StoryHeaderOutView storyHeaderOutView = this.ake;
            if (z) {
                StoryHeaderOutView storyHeaderOutView2 = this.ake;
                i = 0;
            } else {
                StoryHeaderOutView storyHeaderOutView3 = this.ake;
                i = 4;
            }
            storyHeaderOutView.setMaskColor(i);
            this.ake.invalidate();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ake != null) {
            this.ake.onChangeSkinType(i);
        }
    }
}
