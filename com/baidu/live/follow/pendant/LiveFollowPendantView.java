package com.baidu.live.follow.pendant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes10.dex */
public class LiveFollowPendantView extends LinearLayout {
    private HeadImageView aWK;
    private TextView aWL;
    private ImageView aWM;

    public LiveFollowPendantView(Context context) {
        super(context);
        init();
    }

    public void c(View.OnClickListener onClickListener) {
        this.aWL.setOnClickListener(onClickListener);
        this.aWK.setOnClickListener(onClickListener);
        this.aWM.setOnClickListener(onClickListener);
    }

    public void setNickName(String str) {
        this.aWL.setText(str);
    }

    public void setHeadImage(String str) {
        this.aWK.startLoad(str, 10, true);
    }

    public TextView getNickNameView() {
        return this.aWL;
    }

    public HeadImageView getHeadView() {
        return this.aWK;
    }

    public ImageView getFollowView() {
        return this.aWM;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.sdk_video_follow_pendant, this);
        this.aWM = (ImageView) findViewById(a.f.img_follow);
        this.aWL = (TextView) findViewById(a.f.tv_nickname);
        this.aWK = (HeadImageView) findViewById(a.f.head_view);
        this.aWK.setIsRound(true);
        this.aWK.setAutoChangeStyle(false);
        this.aWK.setDefaultBgResource(a.e.sdk_default_avatar);
    }
}
