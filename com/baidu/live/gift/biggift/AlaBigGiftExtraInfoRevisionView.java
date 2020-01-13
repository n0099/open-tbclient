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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes2.dex */
public class AlaBigGiftExtraInfoRevisionView extends FrameLayout {
    private HeadImageView afA;
    private TextView afB;
    private TextView afC;
    private AlphaAnimation afD;
    private AlphaAnimation afE;

    public AlaBigGiftExtraInfoRevisionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar.portrait != null) {
            this.afA.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            this.afB.setText(cVar.userName);
        }
        if (cVar.ajo != null) {
            this.afC.setText(getResources().getString(a.i.donate) + cVar.ajo.qF());
        }
    }

    public void rE() {
        setVisibility(0);
        if (this.afD == null) {
            this.afD = new AlphaAnimation(0.0f, 1.0f);
            this.afD.setDuration(500L);
            this.afD.setFillAfter(true);
        }
        startAnimation(this.afD);
    }

    public void rF() {
        if (this.afE == null) {
            this.afE = new AlphaAnimation(1.0f, 0.0f);
            this.afE.setDuration(500L);
            this.afE.setFillAfter(true);
        }
        startAnimation(this.afE);
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
        rG();
    }

    private void rG() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.popup_extra_info_revision_layout, (ViewGroup) this, true);
        this.afA = (HeadImageView) findViewById(a.g.iv_avatar);
        this.afB = (TextView) findViewById(a.g.tv_sender);
        this.afC = (TextView) findViewById(a.g.tv_tip);
        this.afA.setIsRound(true);
        this.afA.setAutoChangeStyle(false);
        this.afA.setDefaultBgResource(a.f.sdk_default_avatar);
    }
}
