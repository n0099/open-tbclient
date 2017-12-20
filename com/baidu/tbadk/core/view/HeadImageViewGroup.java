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
    private HeadImageView akK;
    public StoryHeaderOutView akz;
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
        this.akz = (StoryHeaderOutView) findViewById(d.g.out_img);
        this.akz.setIsRound(true);
        this.akz.setVisibility(0);
        this.akK = (HeadImageView) findViewById(d.g.inner_img);
        this.akK.setScaleType(ImageView.ScaleType.FIT_XY);
        this.akK.setDrawBorder(false);
    }

    public HeadImageView getInnerImg() {
        return this.akK;
    }

    public void setOuterColor(int i) {
        this.akz.setColor(i);
    }

    public void a(a aVar, int i) {
        if (this.akz != null) {
            StoryHeaderOutView storyHeaderOutView = this.akz;
            StoryHeaderOutView storyHeaderOutView2 = this.akz;
            storyHeaderOutView.setMaskColor(1);
            this.akz.invalidate();
        }
    }

    public void wg() {
        if (this.akz != null) {
            this.akz.bst();
            StoryHeaderOutView storyHeaderOutView = this.akz;
            StoryHeaderOutView storyHeaderOutView2 = this.akz;
            storyHeaderOutView.setMaskColor(0);
            this.akz.invalidate();
        }
    }

    public void aG(boolean z) {
        int i;
        if (this.akz != null) {
            StoryHeaderOutView storyHeaderOutView = this.akz;
            if (z) {
                StoryHeaderOutView storyHeaderOutView2 = this.akz;
                i = 3;
            } else {
                StoryHeaderOutView storyHeaderOutView3 = this.akz;
                i = 0;
            }
            storyHeaderOutView.setMaskColor(i);
            this.akz.invalidate();
        }
    }

    public void aH(boolean z) {
        int i;
        if (this.akz != null) {
            StoryHeaderOutView storyHeaderOutView = this.akz;
            if (z) {
                StoryHeaderOutView storyHeaderOutView2 = this.akz;
                i = 0;
            } else {
                StoryHeaderOutView storyHeaderOutView3 = this.akz;
                i = 4;
            }
            storyHeaderOutView.setMaskColor(i);
            this.akz.invalidate();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.akz != null) {
            this.akz.onChangeSkinType(i);
        }
    }
}
