package com.baidu.live.gift.biggift;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes10.dex */
public class AlaBigGiftExtraInfoView extends LinearLayout {
    private HeadImageView aER;
    private TextView aZR;
    private TextView aZT;

    public AlaBigGiftExtraInfoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aER.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            this.aZR.setText(cVar.userName);
        }
        if (cVar.bep != null) {
            this.aZT.setText(getResources().getString(a.h.gift_name_prefix) + cVar.bep.DV());
        }
    }

    private void init() {
        setBackgroundColor(0);
        setOrientation(1);
        FI();
    }

    private void FI() {
        setBackgroundColor(0);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.g.popup_extra_info_layout, (ViewGroup) this, true);
        this.aER = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aZR = (TextView) findViewById(a.f.tv_sender);
        this.aZT = (TextView) findViewById(a.f.tv_tip);
        this.aER.setIsRound(true);
        this.aER.setAutoChangeStyle(false);
        this.aER.setDefaultBgResource(a.e.sdk_default_avatar);
    }
}
