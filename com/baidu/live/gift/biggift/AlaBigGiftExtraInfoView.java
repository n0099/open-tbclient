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
    private HeadImageView aFf;
    private TextView aWQ;
    private TextView aWS;

    public AlaBigGiftExtraInfoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aFf.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            this.aWQ.setText(cVar.userName);
        }
        if (cVar.bbc != null) {
            this.aWS.setText(getResources().getString(a.h.gift_name_prefix) + cVar.bbc.FU());
        }
    }

    private void init() {
        setBackgroundColor(0);
        setOrientation(1);
        HA();
    }

    private void HA() {
        setBackgroundColor(0);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.g.popup_extra_info_layout, (ViewGroup) this, true);
        this.aFf = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aWQ = (TextView) findViewById(a.f.tv_sender);
        this.aWS = (TextView) findViewById(a.f.tv_tip);
        this.aFf.setIsRound(true);
        this.aFf.setAutoChangeStyle(false);
        this.aFf.setDefaultBgResource(a.e.sdk_default_avatar);
    }
}
