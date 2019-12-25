package com.baidu.live.gift.biggift;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes2.dex */
public class AlaBigGiftExtraInfoView extends LinearLayout {
    private HeadImageView aeR;
    private TextView aeS;
    private TextView aeT;

    public AlaBigGiftExtraInfoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.b bVar) {
        if (bVar.portrait != null) {
            this.aeR.startLoad(bVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(bVar.userName)) {
            this.aeS.setText(bVar.userName);
        }
        if (bVar.aiC != null) {
            this.aeT.setText(getResources().getString(a.i.gift_name_prefix) + bVar.aiC.qy());
        }
    }

    private void init() {
        setBackgroundColor(0);
        setOrientation(1);
        rt();
    }

    private void rt() {
        setBackgroundColor(0);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.popup_extra_info_layout, (ViewGroup) this, true);
        this.aeR = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aeS = (TextView) findViewById(a.g.tv_sender);
        this.aeT = (TextView) findViewById(a.g.tv_tip);
        this.aeR.setIsRound(true);
        this.aeR.setAutoChangeStyle(false);
        this.aeR.setDefaultBgResource(a.f.sdk_default_avatar);
    }
}
