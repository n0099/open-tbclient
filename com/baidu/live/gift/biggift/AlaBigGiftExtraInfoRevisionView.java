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
    private HeadImageView ahI;
    private TextView ahJ;
    private TextView ahK;
    private AlphaAnimation ahL;
    private AlphaAnimation ahM;

    public AlaBigGiftExtraInfoRevisionView(Context context) {
        this(context, null);
    }

    public AlaBigGiftExtraInfoRevisionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar.portrait != null) {
            this.ahI.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            this.ahJ.setText(cVar.userName);
        }
        if (cVar.alw != null) {
            this.ahK.setText(getResources().getString(a.i.donate) + cVar.alw.ry());
        }
    }

    public void sP() {
        setVisibility(0);
        if (this.ahL == null) {
            this.ahL = new AlphaAnimation(0.0f, 1.0f);
            this.ahL.setDuration(500L);
            this.ahL.setFillAfter(true);
        }
        startAnimation(this.ahL);
    }

    public void sQ() {
        if (this.ahM == null) {
            this.ahM = new AlphaAnimation(1.0f, 0.0f);
            this.ahM.setDuration(500L);
            this.ahM.setFillAfter(true);
        }
        startAnimation(this.ahM);
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
        sR();
    }

    private void sR() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.popup_extra_info_revision_layout, (ViewGroup) this, true);
        this.ahI = (HeadImageView) findViewById(a.g.iv_avatar);
        this.ahJ = (TextView) findViewById(a.g.tv_sender);
        this.ahK = (TextView) findViewById(a.g.tv_tip);
        this.ahI.setIsRound(true);
        this.ahI.setAutoChangeStyle(false);
        this.ahI.setDefaultBgResource(a.f.sdk_default_avatar);
    }
}
