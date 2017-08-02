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
    public StoryHeaderOutView ajp;
    private HeadImageView ajq;
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
        this.ajp = (StoryHeaderOutView) findViewById(d.h.out_img);
        this.ajp.setIsRound(true);
        this.ajp.setVisibility(0);
        this.ajq = (HeadImageView) findViewById(d.h.inner_img);
        this.ajq.setScaleType(ImageView.ScaleType.FIT_XY);
        this.ajq.setDrawBorder(false);
    }

    public HeadImageView getInnerImg() {
        return this.ajq;
    }

    public void setOuterColor(int i) {
        this.ajp.setColor(i);
    }

    public void a(a aVar, int i) {
        if (this.ajp != null) {
            StoryHeaderOutView storyHeaderOutView = this.ajp;
            StoryHeaderOutView storyHeaderOutView2 = this.ajp;
            storyHeaderOutView.setMaskColor(1);
            this.ajp.invalidate();
        }
    }

    public void wr() {
        if (this.ajp != null) {
            this.ajp.bnX();
            StoryHeaderOutView storyHeaderOutView = this.ajp;
            StoryHeaderOutView storyHeaderOutView2 = this.ajp;
            storyHeaderOutView.setMaskColor(0);
            this.ajp.invalidate();
        }
    }

    public void aJ(boolean z) {
        int i;
        if (this.ajp != null) {
            StoryHeaderOutView storyHeaderOutView = this.ajp;
            if (z) {
                StoryHeaderOutView storyHeaderOutView2 = this.ajp;
                i = 3;
            } else {
                StoryHeaderOutView storyHeaderOutView3 = this.ajp;
                i = 0;
            }
            storyHeaderOutView.setMaskColor(i);
            this.ajp.invalidate();
        }
    }

    public void aK(boolean z) {
        int i;
        if (this.ajp != null) {
            StoryHeaderOutView storyHeaderOutView = this.ajp;
            if (z) {
                StoryHeaderOutView storyHeaderOutView2 = this.ajp;
                i = 0;
            } else {
                StoryHeaderOutView storyHeaderOutView3 = this.ajp;
                i = 4;
            }
            storyHeaderOutView.setMaskColor(i);
            this.ajp.invalidate();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ajp != null) {
            this.ajp.onChangeSkinType(i);
        }
    }
}
