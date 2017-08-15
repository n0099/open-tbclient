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
    public StoryHeaderOutView akK;
    private HeadImageView akL;
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
        this.akK = (StoryHeaderOutView) findViewById(d.h.out_img);
        this.akK.setIsRound(true);
        this.akK.setVisibility(0);
        this.akL = (HeadImageView) findViewById(d.h.inner_img);
        this.akL.setScaleType(ImageView.ScaleType.FIT_XY);
        this.akL.setDrawBorder(false);
    }

    public HeadImageView getInnerImg() {
        return this.akL;
    }

    public void setOuterColor(int i) {
        this.akK.setColor(i);
    }

    public void a(a aVar, int i) {
        if (this.akK != null) {
            StoryHeaderOutView storyHeaderOutView = this.akK;
            StoryHeaderOutView storyHeaderOutView2 = this.akK;
            storyHeaderOutView.setMaskColor(1);
            this.akK.invalidate();
        }
    }

    public void wB() {
        if (this.akK != null) {
            this.akK.boM();
            StoryHeaderOutView storyHeaderOutView = this.akK;
            StoryHeaderOutView storyHeaderOutView2 = this.akK;
            storyHeaderOutView.setMaskColor(0);
            this.akK.invalidate();
        }
    }

    public void aJ(boolean z) {
        int i;
        if (this.akK != null) {
            StoryHeaderOutView storyHeaderOutView = this.akK;
            if (z) {
                StoryHeaderOutView storyHeaderOutView2 = this.akK;
                i = 3;
            } else {
                StoryHeaderOutView storyHeaderOutView3 = this.akK;
                i = 0;
            }
            storyHeaderOutView.setMaskColor(i);
            this.akK.invalidate();
        }
    }

    public void aK(boolean z) {
        int i;
        if (this.akK != null) {
            StoryHeaderOutView storyHeaderOutView = this.akK;
            if (z) {
                StoryHeaderOutView storyHeaderOutView2 = this.akK;
                i = 0;
            } else {
                StoryHeaderOutView storyHeaderOutView3 = this.akK;
                i = 4;
            }
            storyHeaderOutView.setMaskColor(i);
            this.akK.invalidate();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.akK != null) {
            this.akK.onChangeSkinType(i);
        }
    }
}
