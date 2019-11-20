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
    private HeadImageView Xg;
    private TextView Xh;
    private TextView Xi;
    private AlphaAnimation Xj;
    private AlphaAnimation Xk;

    public AlaBigGiftExtraInfoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(d dVar) {
        if (dVar.portrait != null) {
            this.Xg.startLoad(dVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(dVar.userName)) {
            this.Xh.setText(dVar.userName);
        }
        if (dVar.aaz != null) {
            this.Xi.setText(getResources().getString(a.i.gift_name_prefix) + dVar.aaz.pd());
        }
    }

    public void pP() {
        setVisibility(0);
        if (this.Xj == null) {
            this.Xj = new AlphaAnimation(0.0f, 1.0f);
            this.Xj.setDuration(500L);
            this.Xj.setFillAfter(true);
        }
        startAnimation(this.Xj);
    }

    public void pQ() {
        if (this.Xk == null) {
            this.Xk = new AlphaAnimation(1.0f, 0.0f);
            this.Xk.setDuration(500L);
            this.Xk.setFillAfter(true);
        }
        startAnimation(this.Xk);
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
        this.Xg = (HeadImageView) findViewById(a.g.iv_avatar);
        this.Xh = (TextView) findViewById(a.g.tv_sender);
        this.Xi = (TextView) findViewById(a.g.tv_tip);
        this.Xg.setIsRound(true);
        this.Xg.setAutoChangeStyle(false);
        this.Xg.setDefaultBgResource(a.f.sdk_default_avatar);
    }
}
