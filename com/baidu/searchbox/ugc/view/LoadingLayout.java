package com.baidu.searchbox.ugc.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.ugc.album.R;
import com.baidu.searchbox.ugc.utils.ResourceUtils;
import com.baidu.searchbox.ugc.utils.UiBaseUtils;
/* loaded from: classes13.dex */
public class LoadingLayout extends LinearLayout {
    private ImageView mPromptImg;
    private TextView mPromptTv;

    public LoadingLayout(Context context) {
        super(context);
    }

    public LoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    private void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ugc_album_loadding_layout, (ViewGroup) null);
        UiBaseUtils.setViewColorResource(inflate, R.color.ugc_white);
        this.mPromptImg = (ImageView) inflate.findViewById(ResourceUtils.getResIdByName("ugc_loadding_img"));
        this.mPromptTv = (TextView) inflate.findViewById(ResourceUtils.getResIdByName("ugc_loadding_tv"));
        addView(inflate);
    }

    public void showLoading(boolean z) {
        if (z) {
            setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.ugc_rotate_loading);
            UiBaseUtils.setImageResource(this.mPromptImg, R.drawable.ugc_progress_icon);
            UiBaseUtils.startAnimation(this.mPromptImg, loadAnimation);
            return;
        }
        setVisibility(8);
    }

    public void showEmpty(int i) {
        setVisibility(0);
        if (this.mPromptImg != null) {
            this.mPromptImg.clearAnimation();
            this.mPromptImg.setImageResource(R.drawable.ugc_album_empty_icon);
            if (i == 0) {
                UiBaseUtils.setTextStringResource(this.mPromptTv, R.string.ugc_album_empty_photo_prmmpt_tv);
            } else {
                UiBaseUtils.setTextStringResource(this.mPromptTv, R.string.ugc_album_empty_video_prompt_tv);
            }
        }
    }
}
