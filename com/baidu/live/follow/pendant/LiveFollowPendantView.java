package com.baidu.live.follow.pendant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes11.dex */
public class LiveFollowPendantView extends LinearLayout {
    private HeadImageView aVk;
    private TextView aVl;
    private ImageView aVm;

    public LiveFollowPendantView(Context context) {
        super(context);
        init();
    }

    public void c(View.OnClickListener onClickListener) {
        this.aVl.setOnClickListener(onClickListener);
        this.aVk.setOnClickListener(onClickListener);
        this.aVm.setOnClickListener(onClickListener);
    }

    public void setNickName(String str) {
        this.aVl.setText(str);
    }

    public void setHeadImage(String str) {
        this.aVk.startLoad(str, 10, true);
    }

    public TextView getNickNameView() {
        return this.aVl;
    }

    public HeadImageView getHeadView() {
        return this.aVk;
    }

    public ImageView getFollowView() {
        return this.aVm;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.sdk_video_follow_pendant, this);
        this.aVm = (ImageView) findViewById(a.f.img_follow);
        this.aVl = (TextView) findViewById(a.f.tv_nickname);
        this.aVk = (HeadImageView) findViewById(a.f.head_view);
        this.aVk.setIsRound(true);
        this.aVk.setAutoChangeStyle(false);
        this.aVk.setDefaultBgResource(a.e.sdk_default_avatar);
    }
}
