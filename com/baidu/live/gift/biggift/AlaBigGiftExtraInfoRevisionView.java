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
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaBigGiftExtraInfoRevisionView extends FrameLayout {
    private HeadImageView ahS;
    private TextView ahT;
    private TextView ahU;
    private AlphaAnimation ahV;
    private AlphaAnimation ahW;

    public AlaBigGiftExtraInfoRevisionView(Context context) {
        this(context, null);
    }

    public AlaBigGiftExtraInfoRevisionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar.portrait != null) {
            this.ahS.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            this.ahT.setText(cVar.userName);
        }
        if (cVar.alH != null) {
            this.ahU.setText(getResources().getString(a.i.donate) + cVar.alH.rD());
        }
    }

    public void sU() {
        setVisibility(0);
        if (this.ahV == null) {
            this.ahV = new AlphaAnimation(0.0f, 1.0f);
            this.ahV.setDuration(500L);
            this.ahV.setFillAfter(true);
        }
        startAnimation(this.ahV);
    }

    public void sV() {
        if (this.ahW == null) {
            this.ahW = new AlphaAnimation(1.0f, 0.0f);
            this.ahW.setDuration(500L);
            this.ahW.setFillAfter(true);
        }
        startAnimation(this.ahW);
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
        sW();
    }

    private void sW() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.popup_extra_info_revision_layout, (ViewGroup) this, true);
        this.ahS = (HeadImageView) findViewById(a.g.iv_avatar);
        this.ahT = (TextView) findViewById(a.g.tv_sender);
        this.ahU = (TextView) findViewById(a.g.tv_tip);
        this.ahS.setIsRound(true);
        this.ahS.setAutoChangeStyle(false);
        this.ahS.setDefaultBgResource(a.f.sdk_default_avatar);
    }
}
