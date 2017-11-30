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
    public StoryHeaderOutView akC;
    private HeadImageView akN;
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
        this.akC = (StoryHeaderOutView) findViewById(d.g.out_img);
        this.akC.setIsRound(true);
        this.akC.setVisibility(0);
        this.akN = (HeadImageView) findViewById(d.g.inner_img);
        this.akN.setScaleType(ImageView.ScaleType.FIT_XY);
        this.akN.setDrawBorder(false);
    }

    public HeadImageView getInnerImg() {
        return this.akN;
    }

    public void setOuterColor(int i) {
        this.akC.setColor(i);
    }

    public void a(a aVar, int i) {
        if (this.akC != null) {
            StoryHeaderOutView storyHeaderOutView = this.akC;
            StoryHeaderOutView storyHeaderOutView2 = this.akC;
            storyHeaderOutView.setMaskColor(1);
            this.akC.invalidate();
        }
    }

    public void wi() {
        if (this.akC != null) {
            this.akC.brO();
            StoryHeaderOutView storyHeaderOutView = this.akC;
            StoryHeaderOutView storyHeaderOutView2 = this.akC;
            storyHeaderOutView.setMaskColor(0);
            this.akC.invalidate();
        }
    }

    public void aG(boolean z) {
        int i;
        if (this.akC != null) {
            StoryHeaderOutView storyHeaderOutView = this.akC;
            if (z) {
                StoryHeaderOutView storyHeaderOutView2 = this.akC;
                i = 3;
            } else {
                StoryHeaderOutView storyHeaderOutView3 = this.akC;
                i = 0;
            }
            storyHeaderOutView.setMaskColor(i);
            this.akC.invalidate();
        }
    }

    public void aH(boolean z) {
        int i;
        if (this.akC != null) {
            StoryHeaderOutView storyHeaderOutView = this.akC;
            if (z) {
                StoryHeaderOutView storyHeaderOutView2 = this.akC;
                i = 0;
            } else {
                StoryHeaderOutView storyHeaderOutView3 = this.akC;
                i = 4;
            }
            storyHeaderOutView.setMaskColor(i);
            this.akC.invalidate();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.akC != null) {
            this.akC.onChangeSkinType(i);
        }
    }
}
