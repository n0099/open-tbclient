package com.baidu.live.gift.biggift;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes11.dex */
public class AlaBigGiftExtraInfoView extends LinearLayout {
    private HeadImageView aDr;
    private TextView aYr;
    private TextView aYt;

    public AlaBigGiftExtraInfoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aDr.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            this.aYr.setText(cVar.userName);
        }
        if (cVar.bcO != null) {
            this.aYt.setText(getResources().getString(a.h.gift_name_prefix) + cVar.bcO.DS());
        }
    }

    private void init() {
        setBackgroundColor(0);
        setOrientation(1);
        FF();
    }

    private void FF() {
        setBackgroundColor(0);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.g.popup_extra_info_layout, (ViewGroup) this, true);
        this.aDr = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aYr = (TextView) findViewById(a.f.tv_sender);
        this.aYt = (TextView) findViewById(a.f.tv_tip);
        this.aDr.setIsRound(true);
        this.aDr.setAutoChangeStyle(false);
        this.aDr.setDefaultBgResource(a.e.sdk_default_avatar);
    }
}
