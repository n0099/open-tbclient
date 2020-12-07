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
    private HeadImageView aGa;
    private TextView aYq;
    private TextView aYs;

    public AlaBigGiftExtraInfoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aGa.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            this.aYq.setText(cVar.userName);
        }
        if (cVar.bcN != null) {
            this.aYs.setText(getResources().getString(a.h.gift_name_prefix) + cVar.bcN.GY());
        }
    }

    private void init() {
        setBackgroundColor(0);
        setOrientation(1);
        II();
    }

    private void II() {
        setBackgroundColor(0);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.g.popup_extra_info_layout, (ViewGroup) this, true);
        this.aGa = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aYq = (TextView) findViewById(a.f.tv_sender);
        this.aYs = (TextView) findViewById(a.f.tv_tip);
        this.aGa.setIsRound(true);
        this.aGa.setAutoChangeStyle(false);
        this.aGa.setDefaultBgResource(a.e.sdk_default_avatar);
    }
}
