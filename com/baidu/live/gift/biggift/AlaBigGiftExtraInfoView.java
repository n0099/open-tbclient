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
    private HeadImageView aEp;
    private TextView aVA;
    private TextView aVy;

    public AlaBigGiftExtraInfoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aEp.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            this.aVy.setText(cVar.userName);
        }
        if (cVar.aZJ != null) {
            this.aVA.setText(getResources().getString(a.i.gift_name_prefix) + cVar.aZJ.Ft());
        }
    }

    private void init() {
        setBackgroundColor(0);
        setOrientation(1);
        GZ();
    }

    private void GZ() {
        setBackgroundColor(0);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.popup_extra_info_layout, (ViewGroup) this, true);
        this.aEp = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aVy = (TextView) findViewById(a.g.tv_sender);
        this.aVA = (TextView) findViewById(a.g.tv_tip);
        this.aEp.setIsRound(true);
        this.aEp.setAutoChangeStyle(false);
        this.aEp.setDefaultBgResource(a.f.sdk_default_avatar);
    }
}
