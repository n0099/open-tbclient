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
/* loaded from: classes3.dex */
public class AlaBigGiftExtraInfoView extends LinearLayout {
    private HeadImageView aIh;
    private TextView aIi;
    private TextView aIj;

    public AlaBigGiftExtraInfoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aIh.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            this.aIi.setText(cVar.userName);
        }
        if (cVar.aMi != null) {
            this.aIj.setText(getResources().getString(a.i.gift_name_prefix) + cVar.aMi.xN());
        }
    }

    private void init() {
        setBackgroundColor(0);
        setOrientation(1);
        zc();
    }

    private void zc() {
        setBackgroundColor(0);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.popup_extra_info_layout, (ViewGroup) this, true);
        this.aIh = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aIi = (TextView) findViewById(a.g.tv_sender);
        this.aIj = (TextView) findViewById(a.g.tv_tip);
        this.aIh.setIsRound(true);
        this.aIh.setAutoChangeStyle(false);
        this.aIh.setDefaultBgResource(a.f.sdk_default_avatar);
    }
}
