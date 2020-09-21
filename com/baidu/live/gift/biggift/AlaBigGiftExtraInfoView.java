package com.baidu.live.gift.biggift;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes4.dex */
public class AlaBigGiftExtraInfoView extends LinearLayout {
    private HeadImageView aBc;
    private TextView aQT;
    private TextView aQU;

    public AlaBigGiftExtraInfoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aBc.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            this.aQT.setText(cVar.userName);
        }
        if (cVar.aVd != null) {
            this.aQU.setText(getResources().getString(a.i.gift_name_prefix) + cVar.aVd.Ei());
        }
    }

    private void init() {
        setBackgroundColor(0);
        setOrientation(1);
        FH();
    }

    private void FH() {
        setBackgroundColor(0);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.popup_extra_info_layout, (ViewGroup) this, true);
        this.aBc = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aQT = (TextView) findViewById(a.g.tv_sender);
        this.aQU = (TextView) findViewById(a.g.tv_tip);
        this.aBc.setIsRound(true);
        this.aBc.setAutoChangeStyle(false);
        this.aBc.setDefaultBgResource(a.f.sdk_default_avatar);
    }
}
