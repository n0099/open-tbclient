package com.baidu.live.gift.biggift;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaBigGiftExtraInfoView extends LinearLayout {
    private HeadImageView ahS;
    private TextView ahT;
    private TextView ahU;

    public AlaBigGiftExtraInfoView(Context context, @Nullable AttributeSet attributeSet) {
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
            this.ahU.setText(getResources().getString(a.i.gift_name_prefix) + cVar.alH.rD());
        }
    }

    private void init() {
        setBackgroundColor(0);
        setOrientation(1);
        sW();
    }

    private void sW() {
        setBackgroundColor(0);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.popup_extra_info_layout, (ViewGroup) this, true);
        this.ahS = (HeadImageView) findViewById(a.g.iv_avatar);
        this.ahT = (TextView) findViewById(a.g.tv_sender);
        this.ahU = (TextView) findViewById(a.g.tv_tip);
        this.ahS.setIsRound(true);
        this.ahS.setAutoChangeStyle(false);
        this.ahS.setDefaultBgResource(a.f.sdk_default_avatar);
    }
}
