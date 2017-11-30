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
    public StoryHeaderOutView akC;
    private HeadImageView akD;
    private HeadImageView akE;
    private ImageView akF;
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
        this.akC = (StoryHeaderOutView) findViewById(d.g.out_img);
        this.akC.setIsRound(true);
        this.akC.setVisibility(0);
        this.akD = (HeadImageView) findViewById(d.g.front_img);
        this.akE = (HeadImageView) findViewById(d.g.back_img);
        this.akD.setScaleType(ImageView.ScaleType.FIT_XY);
        this.akD.setDrawBorder(false);
        this.akE.setScaleType(ImageView.ScaleType.FIT_XY);
        this.akE.setDrawBorder(false);
        this.akF = (ImageView) findViewById(d.g.ala_live_ing_img);
    }

    public void setLiveIngImgVisible(boolean z) {
        this.akF.setVisibility(z ? 0 : 8);
    }

    public HeadImageView getFrontImg() {
        return this.akD;
    }

    public HeadImageView getBackImg() {
        return this.akE;
    }

    public void setOuterColor(int i) {
        this.akC.setColor(i);
    }

    public void onChangeSkinType(int i) {
        if (this.akC != null) {
            this.akC.onChangeSkinType(i);
        }
        if (this.akF != null) {
            aj.b(this.akF, d.f.btn_story_live, i);
        }
    }
}
