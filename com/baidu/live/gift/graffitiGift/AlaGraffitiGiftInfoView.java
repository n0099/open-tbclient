package com.baidu.live.gift.graffitiGift;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.k;
/* loaded from: classes2.dex */
public class AlaGraffitiGiftInfoView extends LinearLayout {
    private TbImageView akC;
    private HeadImageView akD;
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
        this.akC = (TbImageView) findViewById(a.g.graffiti_sender_img);
        this.akC.setIsNight(false);
        this.akC.setAutoChangeStyle(false);
        this.akD = (HeadImageView) findViewById(a.g.graffiti_sender_avatar);
        this.akD.setIsRound(true);
        this.akD.setAutoChangeStyle(false);
        this.akD.setDefaultBgResource(a.f.sdk_default_avatar);
        this.akD.setIsNight(false);
        this.akD.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(a.g.graffiti_sender_info_txt);
    }

    public void setGiftInfo(String str, String str2, String str3) {
        this.akD.setUrl(str);
        k.a(this.akD, str, false, false);
        this.mTitle.setText(str3);
    }
}
