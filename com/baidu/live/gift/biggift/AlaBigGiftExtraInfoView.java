package com.baidu.live.gift.biggift;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes2.dex */
public class AlaBigGiftExtraInfoView extends LinearLayout {
    private HeadImageView afA;
    private TextView afB;
    private TextView afC;

    public AlaBigGiftExtraInfoView(Context context, @Nullable AttributeSet attributeSet) {
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
            this.afC.setText(getResources().getString(a.i.gift_name_prefix) + cVar.ajo.qF());
        }
    }

    private void init() {
        setBackgroundColor(0);
        setOrientation(1);
        rG();
    }

    private void rG() {
        setBackgroundColor(0);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.popup_extra_info_layout, (ViewGroup) this, true);
        this.afA = (HeadImageView) findViewById(a.g.iv_avatar);
        this.afB = (TextView) findViewById(a.g.tv_sender);
        this.afC = (TextView) findViewById(a.g.tv_tip);
        this.afA.setIsRound(true);
        this.afA.setAutoChangeStyle(false);
        this.afA.setDefaultBgResource(a.f.sdk_default_avatar);
    }
}
