package com.baidu.live.gift.graffitiGift;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.k;
/* loaded from: classes2.dex */
public class AlaGraffitiGiftInfoView extends LinearLayout {
    private TbImageView alp;
    private HeadImageView alq;
    private TextView mTitle;

    public AlaGraffitiGiftInfoView(Context context) {
        super(context);
        init();
    }

    public AlaGraffitiGiftInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public AlaGraffitiGiftInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.popup_graffiti_gift_info_layout, this);
        setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape);
        this.alp = (TbImageView) findViewById(a.g.graffiti_sender_img);
        this.alp.setIsNight(false);
        this.alp.setAutoChangeStyle(false);
        this.alq = (HeadImageView) findViewById(a.g.graffiti_sender_avatar);
        this.alq.setIsRound(true);
        this.alq.setAutoChangeStyle(false);
        this.alq.setDefaultBgResource(a.f.sdk_default_avatar);
        this.alq.setIsNight(false);
        this.alq.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(a.g.graffiti_sender_info_txt);
    }

    public void setGiftInfo(String str, String str2, String str3) {
        this.alq.setUrl(str);
        k.a(this.alq, str, false, false);
        this.mTitle.setText(str3);
    }
}
