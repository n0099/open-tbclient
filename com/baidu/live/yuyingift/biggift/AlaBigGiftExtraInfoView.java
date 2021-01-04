package com.baidu.live.yuyingift.biggift;

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
    private HeadImageView aGr;
    private TextView aZW;
    private TextView aZY;

    public AlaBigGiftExtraInfoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aGr.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            this.aZW.setText(cVar.userName);
        }
        if (cVar.bex != null) {
            this.aZY.setText(getResources().getString(a.h.gift_name_prefix) + cVar.bex.Gy());
        }
    }

    private void init() {
        setBackgroundColor(0);
        setOrientation(1);
        Ik();
    }

    private void Ik() {
        setBackgroundColor(0);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.g.popup_extra_info_layout, (ViewGroup) this, true);
        this.aGr = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aZW = (TextView) findViewById(a.f.tv_sender);
        this.aZY = (TextView) findViewById(a.f.tv_tip);
        this.aGr.setIsRound(true);
        this.aGr.setAutoChangeStyle(false);
        this.aGr.setDefaultBgResource(a.e.sdk_default_avatar);
    }
}
