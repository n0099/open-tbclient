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
    private HeadImageView aBE;
    private TextView aVj;
    private TextView aVl;

    public AlaBigGiftExtraInfoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aBE.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            this.aVj.setText(cVar.userName);
        }
        if (cVar.aZH != null) {
            this.aVl.setText(getResources().getString(a.h.gift_name_prefix) + cVar.aZH.CD());
        }
    }

    private void init() {
        setBackgroundColor(0);
        setOrientation(1);
        Ep();
    }

    private void Ep() {
        setBackgroundColor(0);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.g.popup_extra_info_layout, (ViewGroup) this, true);
        this.aBE = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aVj = (TextView) findViewById(a.f.tv_sender);
        this.aVl = (TextView) findViewById(a.f.tv_tip);
        this.aBE.setIsRound(true);
        this.aBE.setAutoChangeStyle(false);
        this.aBE.setDefaultBgResource(a.e.sdk_default_avatar);
    }
}
