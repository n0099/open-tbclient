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
    private HeadImageView aWT;
    private TextView aWU;
    private ImageView aWV;

    public LiveFollowPendantView(Context context) {
        super(context);
        init();
    }

    public void c(View.OnClickListener onClickListener) {
        this.aWU.setOnClickListener(onClickListener);
        this.aWT.setOnClickListener(onClickListener);
        this.aWV.setOnClickListener(onClickListener);
    }

    public void setNickName(String str) {
        this.aWU.setText(str);
    }

    public void setHeadImage(String str) {
        this.aWT.startLoad(str, 10, true);
    }

    public TextView getNickNameView() {
        return this.aWU;
    }

    public HeadImageView getHeadView() {
        return this.aWT;
    }

    public ImageView getFollowView() {
        return this.aWV;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.sdk_video_follow_pendant, this);
        this.aWV = (ImageView) findViewById(a.f.img_follow);
        this.aWU = (TextView) findViewById(a.f.tv_nickname);
        this.aWT = (HeadImageView) findViewById(a.f.head_view);
        this.aWT.setIsRound(true);
        this.aWT.setAutoChangeStyle(false);
        this.aWT.setDefaultBgResource(a.e.sdk_default_avatar);
    }
}
