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
    private HeadImageView aFL;
    private TextView aFM;
    private TextView aFN;

    public AlaBigGiftExtraInfoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aFL.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            this.aFM.setText(cVar.userName);
        }
        if (cVar.aJC != null) {
            this.aFN.setText(getResources().getString(a.i.gift_name_prefix) + cVar.aJC.xm());
        }
    }

    private void init() {
        setBackgroundColor(0);
        setOrientation(1);
        yC();
    }

    private void yC() {
        setBackgroundColor(0);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.popup_extra_info_layout, (ViewGroup) this, true);
        this.aFL = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aFM = (TextView) findViewById(a.g.tv_sender);
        this.aFN = (TextView) findViewById(a.g.tv_tip);
        this.aFL.setIsRound(true);
        this.aFL.setAutoChangeStyle(false);
        this.aFL.setDefaultBgResource(a.f.sdk_default_avatar);
    }
}
