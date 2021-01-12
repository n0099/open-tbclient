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
    private HeadImageView aSg;
    private TextView aSh;
    private ImageView aSi;

    public LiveFollowPendantView(Context context) {
        super(context);
        init();
    }

    public void c(View.OnClickListener onClickListener) {
        this.aSh.setOnClickListener(onClickListener);
        this.aSg.setOnClickListener(onClickListener);
        this.aSi.setOnClickListener(onClickListener);
    }

    public void setNickName(String str) {
        this.aSh.setText(str);
    }

    public void setHeadImage(String str) {
        this.aSg.startLoad(str, 10, true);
    }

    public TextView getNickNameView() {
        return this.aSh;
    }

    public HeadImageView getHeadView() {
        return this.aSg;
    }

    public ImageView getFollowView() {
        return this.aSi;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.sdk_video_follow_pendant, this);
        this.aSi = (ImageView) findViewById(a.f.img_follow);
        this.aSh = (TextView) findViewById(a.f.tv_nickname);
        this.aSg = (HeadImageView) findViewById(a.f.head_view);
        this.aSg.setIsRound(true);
        this.aSg.setAutoChangeStyle(false);
        this.aSg.setDefaultBgResource(a.e.sdk_default_avatar);
    }
}
