package com.baidu.live.yuyingift.biggift;

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
    private HeadImageView aDu;
    private TextView aVf;
    private TextView aVh;

    public AlaBigGiftExtraInfoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aDu.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            this.aVf.setText(cVar.userName);
        }
        if (cVar.aZq != null) {
            this.aVh.setText(getResources().getString(a.h.gift_name_prefix) + cVar.aZq.Fl());
        }
    }

    private void init() {
        setBackgroundColor(0);
        setOrientation(1);
        GR();
    }

    private void GR() {
        setBackgroundColor(0);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.g.popup_extra_info_layout, (ViewGroup) this, true);
        this.aDu = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aVf = (TextView) findViewById(a.f.tv_sender);
        this.aVh = (TextView) findViewById(a.f.tv_tip);
        this.aDu.setIsRound(true);
        this.aDu.setAutoChangeStyle(false);
        this.aDu.setDefaultBgResource(a.e.sdk_default_avatar);
    }
}
