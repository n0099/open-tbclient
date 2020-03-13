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
    private HeadImageView ahI;
    private TextView ahJ;
    private TextView ahK;

    public AlaBigGiftExtraInfoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar.portrait != null) {
            this.ahI.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            this.ahJ.setText(cVar.userName);
        }
        if (cVar.alx != null) {
            this.ahK.setText(getResources().getString(a.i.gift_name_prefix) + cVar.alx.ry());
        }
    }

    private void init() {
        setBackgroundColor(0);
        setOrientation(1);
        sR();
    }

    private void sR() {
        setBackgroundColor(0);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.popup_extra_info_layout, (ViewGroup) this, true);
        this.ahI = (HeadImageView) findViewById(a.g.iv_avatar);
        this.ahJ = (TextView) findViewById(a.g.tv_sender);
        this.ahK = (TextView) findViewById(a.g.tv_tip);
        this.ahI.setIsRound(true);
        this.ahI.setAutoChangeStyle(false);
        this.ahI.setDefaultBgResource(a.f.sdk_default_avatar);
    }
}
