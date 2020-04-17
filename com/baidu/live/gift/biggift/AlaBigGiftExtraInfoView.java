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
    private HeadImageView aAm;
    private TextView aAn;
    private TextView aAo;

    public AlaBigGiftExtraInfoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aAm.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            this.aAn.setText(cVar.userName);
        }
        if (cVar.aDX != null) {
            this.aAo.setText(getResources().getString(a.i.gift_name_prefix) + cVar.aDX.vW());
        }
    }

    private void init() {
        setBackgroundColor(0);
        setOrientation(1);
        xp();
    }

    private void xp() {
        setBackgroundColor(0);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.popup_extra_info_layout, (ViewGroup) this, true);
        this.aAm = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aAn = (TextView) findViewById(a.g.tv_sender);
        this.aAo = (TextView) findViewById(a.g.tv_tip);
        this.aAm.setIsRound(true);
        this.aAm.setAutoChangeStyle(false);
        this.aAm.setDefaultBgResource(a.f.sdk_default_avatar);
    }
}
