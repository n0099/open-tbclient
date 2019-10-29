package com.baidu.live.gift.biggift;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.gift.a.d;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes6.dex */
public class AlaBigGiftExtraInfoView extends LinearLayout {
    private TextView XA;
    private AlphaAnimation XB;
    private AlphaAnimation XC;
    private HeadImageView Xy;
    private TextView Xz;

    public AlaBigGiftExtraInfoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(d dVar) {
        if (dVar.portrait != null) {
            this.Xy.startLoad(dVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(dVar.userName)) {
            this.Xz.setText(dVar.userName);
        }
        if (dVar.aaR != null) {
            this.XA.setText(getResources().getString(a.i.gift_name_prefix) + dVar.aaR.pd());
        }
    }

    public void pP() {
        setVisibility(0);
        if (this.XB == null) {
            this.XB = new AlphaAnimation(0.0f, 1.0f);
            this.XB.setDuration(500L);
            this.XB.setFillAfter(true);
        }
        startAnimation(this.XB);
    }

    public void pQ() {
        if (this.XC == null) {
            this.XC = new AlphaAnimation(1.0f, 0.0f);
            this.XC.setDuration(500L);
            this.XC.setFillAfter(true);
        }
        startAnimation(this.XC);
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
        setOrientation(1);
        pR();
    }

    private void pR() {
        setBackgroundColor(0);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.popup_extra_info_layout, (ViewGroup) this, true);
        this.Xy = (HeadImageView) findViewById(a.g.iv_avatar);
        this.Xz = (TextView) findViewById(a.g.tv_sender);
        this.XA = (TextView) findViewById(a.g.tv_tip);
        this.Xy.setIsRound(true);
        this.Xy.setAutoChangeStyle(false);
        this.Xy.setDefaultBgResource(a.f.sdk_default_avatar);
    }
}
