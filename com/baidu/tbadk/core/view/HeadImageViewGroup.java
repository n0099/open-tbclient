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
    public StoryHeaderOutView akI;
    private HeadImageView akJ;
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
        this.akI = (StoryHeaderOutView) findViewById(d.h.out_img);
        this.akI.setIsRound(true);
        this.akI.setDefaultResource(d.g.icon_toast_game_error);
        this.akI.setVisibility(0);
        this.akJ = (HeadImageView) findViewById(d.h.inner_img);
        this.akJ.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    public HeadImageView getInnerImg() {
        return this.akJ;
    }

    public void setOuterColor(int i) {
        this.akI.setColor(i);
    }

    public void a(a aVar, int i) {
        if (this.akI != null) {
            StoryHeaderOutView storyHeaderOutView = this.akI;
            StoryHeaderOutView storyHeaderOutView2 = this.akI;
            storyHeaderOutView.setMaskColor(1);
            this.akI.invalidate();
        }
    }

    public void wB() {
        if (this.akI != null) {
            this.akI.bog();
            StoryHeaderOutView storyHeaderOutView = this.akI;
            StoryHeaderOutView storyHeaderOutView2 = this.akI;
            storyHeaderOutView.setMaskColor(0);
            this.akI.invalidate();
        }
    }

    public void aJ(boolean z) {
        int i;
        if (this.akI != null) {
            StoryHeaderOutView storyHeaderOutView = this.akI;
            if (z) {
                StoryHeaderOutView storyHeaderOutView2 = this.akI;
                i = 3;
            } else {
                StoryHeaderOutView storyHeaderOutView3 = this.akI;
                i = 0;
            }
            storyHeaderOutView.setMaskColor(i);
            this.akI.invalidate();
        }
    }

    public void aK(boolean z) {
        int i;
        if (this.akI != null) {
            StoryHeaderOutView storyHeaderOutView = this.akI;
            if (z) {
                StoryHeaderOutView storyHeaderOutView2 = this.akI;
                i = 0;
            } else {
                StoryHeaderOutView storyHeaderOutView3 = this.akI;
                i = 4;
            }
            storyHeaderOutView.setMaskColor(i);
            this.akI.invalidate();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.akI != null) {
            this.akI.onChangeSkinType(i);
        }
    }
}
