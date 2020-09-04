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
    private HeadImageView aAw;
    private TextView aOR;
    private TextView aOS;

    public AlaBigGiftExtraInfoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aAw.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            this.aOR.setText(cVar.userName);
        }
        if (cVar.aSS != null) {
            this.aOS.setText(getResources().getString(a.i.gift_name_prefix) + cVar.aSS.DS());
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
        this.aAw = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aOR = (TextView) findViewById(a.g.tv_sender);
        this.aOS = (TextView) findViewById(a.g.tv_tip);
        this.aAw.setIsRound(true);
        this.aAw.setAutoChangeStyle(false);
        this.aAw.setDefaultBgResource(a.f.sdk_default_avatar);
    }
}
