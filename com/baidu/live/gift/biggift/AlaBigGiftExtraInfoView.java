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
    private HeadImageView aEh;
    private TextView aUe;
    private TextView aUf;

    public AlaBigGiftExtraInfoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aEh.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            this.aUe.setText(cVar.userName);
        }
        if (cVar.aYo != null) {
            this.aUf.setText(getResources().getString(a.i.gift_name_prefix) + cVar.aYo.Fe());
        }
    }

    private void init() {
        setBackgroundColor(0);
        setOrientation(1);
        GD();
    }

    private void GD() {
        setBackgroundColor(0);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.popup_extra_info_layout, (ViewGroup) this, true);
        this.aEh = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aUe = (TextView) findViewById(a.g.tv_sender);
        this.aUf = (TextView) findViewById(a.g.tv_tip);
        this.aEh.setIsRound(true);
        this.aEh.setAutoChangeStyle(false);
        this.aEh.setDefaultBgResource(a.f.sdk_default_avatar);
    }
}
