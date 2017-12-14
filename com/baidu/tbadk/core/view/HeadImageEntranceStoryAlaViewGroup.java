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
    private HeadImageView akA;
    private HeadImageView akB;
    private ImageView akC;
    public StoryHeaderOutView akz;
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
        this.akz = (StoryHeaderOutView) findViewById(d.g.out_img);
        this.akz.setIsRound(true);
        this.akz.setVisibility(0);
        this.akA = (HeadImageView) findViewById(d.g.front_img);
        this.akB = (HeadImageView) findViewById(d.g.back_img);
        this.akA.setScaleType(ImageView.ScaleType.FIT_XY);
        this.akA.setDrawBorder(false);
        this.akB.setScaleType(ImageView.ScaleType.FIT_XY);
        this.akB.setDrawBorder(false);
        this.akC = (ImageView) findViewById(d.g.ala_live_ing_img);
    }

    public void setLiveIngImgVisible(boolean z) {
        this.akC.setVisibility(z ? 0 : 8);
    }

    public HeadImageView getFrontImg() {
        return this.akA;
    }

    public HeadImageView getBackImg() {
        return this.akB;
    }

    public void setOuterColor(int i) {
        this.akz.setColor(i);
    }

    public void onChangeSkinType(int i) {
        if (this.akz != null) {
            this.akz.onChangeSkinType(i);
        }
        if (this.akC != null) {
            aj.b(this.akC, d.f.btn_story_live, i);
        }
    }
}
