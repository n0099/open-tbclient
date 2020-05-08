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
    private HeadImageView aAs;
    private TextView aAt;
    private TextView aAu;

    public AlaBigGiftExtraInfoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aAs.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            this.aAt.setText(cVar.userName);
        }
        if (cVar.aEd != null) {
            this.aAu.setText(getResources().getString(a.i.gift_name_prefix) + cVar.aEd.vV());
        }
    }

    private void init() {
        setBackgroundColor(0);
        setOrientation(1);
        xo();
    }

    private void xo() {
        setBackgroundColor(0);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.popup_extra_info_layout, (ViewGroup) this, true);
        this.aAs = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aAt = (TextView) findViewById(a.g.tv_sender);
        this.aAu = (TextView) findViewById(a.g.tv_tip);
        this.aAs.setIsRound(true);
        this.aAs.setAutoChangeStyle(false);
        this.aAs.setDefaultBgResource(a.f.sdk_default_avatar);
    }
}
