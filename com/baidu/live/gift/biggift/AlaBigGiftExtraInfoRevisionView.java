package com.baidu.live.gift.biggift;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes2.dex */
public class AlaBigGiftExtraInfoRevisionView extends FrameLayout {
    private HeadImageView aeR;
    private TextView aeS;
    private TextView aeT;
    private AlphaAnimation aeU;
    private AlphaAnimation aeV;

    public AlaBigGiftExtraInfoRevisionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.b bVar) {
        if (bVar.portrait != null) {
            this.aeR.startLoad(bVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(bVar.userName)) {
            this.aeS.setText(bVar.userName);
        }
        if (bVar.aiC != null) {
            this.aeT.setText(getResources().getString(a.i.donate) + bVar.aiC.qy());
        }
    }

    public void rr() {
        setVisibility(0);
        if (this.aeU == null) {
            this.aeU = new AlphaAnimation(0.0f, 1.0f);
            this.aeU.setDuration(500L);
            this.aeU.setFillAfter(true);
        }
        startAnimation(this.aeU);
    }

    public void rs() {
        if (this.aeV == null) {
            this.aeV = new AlphaAnimation(1.0f, 0.0f);
            this.aeV.setDuration(500L);
            this.aeV.setFillAfter(true);
        }
        startAnimation(this.aeV);
    }

    public void onDestroy() {
        setVisibility(8);
        clearAnimation();
    }

    public void end() {
        setVisibility(8);
        clearAnimation();
    }

    private void init() {
        setBackgroundColor(0);
        rt();
    }

    private void rt() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.popup_extra_info_revision_layout, (ViewGroup) this, true);
        this.aeR = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aeS = (TextView) findViewById(a.g.tv_sender);
        this.aeT = (TextView) findViewById(a.g.tv_tip);
        this.aeR.setIsRound(true);
        this.aeR.setAutoChangeStyle(false);
        this.aeR.setDefaultBgResource(a.f.sdk_default_avatar);
    }
}
