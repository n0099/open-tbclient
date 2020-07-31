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
    private TextView aJE;
    private TextView aJF;
    private HeadImageView avs;

    public AlaBigGiftExtraInfoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar.portrait != null) {
            this.avs.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            this.aJE.setText(cVar.userName);
        }
        if (cVar.aND != null) {
            this.aJF.setText(getResources().getString(a.i.gift_name_prefix) + cVar.aND.yp());
        }
    }

    private void init() {
        setBackgroundColor(0);
        setOrientation(1);
        zE();
    }

    private void zE() {
        setBackgroundColor(0);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.popup_extra_info_layout, (ViewGroup) this, true);
        this.avs = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aJE = (TextView) findViewById(a.g.tv_sender);
        this.aJF = (TextView) findViewById(a.g.tv_tip);
        this.avs.setIsRound(true);
        this.avs.setAutoChangeStyle(false);
        this.avs.setDefaultBgResource(a.f.sdk_default_avatar);
    }
}
