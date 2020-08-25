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
/* loaded from: classes7.dex */
public class AlaBigGiftExtraInfoView extends LinearLayout {
    private HeadImageView aAu;
    private TextView aOP;
    private TextView aOQ;

    public AlaBigGiftExtraInfoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aAu.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            this.aOP.setText(cVar.userName);
        }
        if (cVar.aSQ != null) {
            this.aOQ.setText(getResources().getString(a.i.gift_name_prefix) + cVar.aSQ.DS());
        }
    }

    private void init() {
        setBackgroundColor(0);
        setOrientation(1);
        Fh();
    }

    private void Fh() {
        setBackgroundColor(0);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.popup_extra_info_layout, (ViewGroup) this, true);
        this.aAu = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aOP = (TextView) findViewById(a.g.tv_sender);
        this.aOQ = (TextView) findViewById(a.g.tv_tip);
        this.aAu.setIsRound(true);
        this.aAu.setAutoChangeStyle(false);
        this.aAu.setDefaultBgResource(a.f.sdk_default_avatar);
    }
}
