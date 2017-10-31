package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.story.StoryHeaderOutView;
/* loaded from: classes.dex */
public class HeadImageEntranceStoryAlaViewGroup extends FrameLayout {
    public StoryHeaderOutView akg;
    private HeadImageView akh;
    private HeadImageView aki;
    private ImageView akj;
    private View mRootView;

    public HeadImageEntranceStoryAlaViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public HeadImageEntranceStoryAlaViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.mRootView = View.inflate(getContext(), d.h.head_story_ala_live_group, null);
        addView(this.mRootView);
        this.akg = (StoryHeaderOutView) findViewById(d.g.out_img);
        this.akg.setIsRound(true);
        this.akg.setVisibility(0);
        this.akh = (HeadImageView) findViewById(d.g.front_img);
        this.aki = (HeadImageView) findViewById(d.g.back_img);
        this.akh.setScaleType(ImageView.ScaleType.FIT_XY);
        this.akh.setDrawBorder(false);
        this.aki.setScaleType(ImageView.ScaleType.FIT_XY);
        this.aki.setDrawBorder(false);
        this.akj = (ImageView) findViewById(d.g.ala_live_ing_img);
    }

    public void setLiveIngImgVisible(boolean z) {
        this.akj.setVisibility(z ? 0 : 8);
    }

    public HeadImageView getFrontImg() {
        return this.akh;
    }

    public HeadImageView getBackImg() {
        return this.aki;
    }

    public void setOuterColor(int i) {
        this.akg.setColor(i);
    }

    public void onChangeSkinType(int i) {
        if (this.akg != null) {
            this.akg.onChangeSkinType(i);
        }
        if (this.akj != null) {
            aj.b(this.akj, d.f.btn_story_live, i);
        }
    }
}
