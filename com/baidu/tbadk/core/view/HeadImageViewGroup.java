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
    public StoryHeaderOutView ajT;
    private HeadImageView ajU;
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
        this.ajT = (StoryHeaderOutView) findViewById(d.h.out_img);
        this.ajT.setIsRound(true);
        this.ajT.setVisibility(0);
        this.ajU = (HeadImageView) findViewById(d.h.inner_img);
        this.ajU.setScaleType(ImageView.ScaleType.FIT_XY);
        this.ajU.setDrawBorder(false);
    }

    public HeadImageView getInnerImg() {
        return this.ajU;
    }

    public void setOuterColor(int i) {
        this.ajT.setColor(i);
    }

    public void a(a aVar, int i) {
        if (this.ajT != null) {
            StoryHeaderOutView storyHeaderOutView = this.ajT;
            StoryHeaderOutView storyHeaderOutView2 = this.ajT;
            storyHeaderOutView.setMaskColor(1);
            this.ajT.invalidate();
        }
    }

    public void vX() {
        if (this.ajT != null) {
            this.ajT.bmQ();
            StoryHeaderOutView storyHeaderOutView = this.ajT;
            StoryHeaderOutView storyHeaderOutView2 = this.ajT;
            storyHeaderOutView.setMaskColor(0);
            this.ajT.invalidate();
        }
    }

    public void aI(boolean z) {
        int i;
        if (this.ajT != null) {
            StoryHeaderOutView storyHeaderOutView = this.ajT;
            if (z) {
                StoryHeaderOutView storyHeaderOutView2 = this.ajT;
                i = 3;
            } else {
                StoryHeaderOutView storyHeaderOutView3 = this.ajT;
                i = 0;
            }
            storyHeaderOutView.setMaskColor(i);
            this.ajT.invalidate();
        }
    }

    public void aJ(boolean z) {
        int i;
        if (this.ajT != null) {
            StoryHeaderOutView storyHeaderOutView = this.ajT;
            if (z) {
                StoryHeaderOutView storyHeaderOutView2 = this.ajT;
                i = 0;
            } else {
                StoryHeaderOutView storyHeaderOutView3 = this.ajT;
                i = 4;
            }
            storyHeaderOutView.setMaskColor(i);
            this.ajT.invalidate();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ajT != null) {
            this.ajT.onChangeSkinType(i);
        }
    }
}
