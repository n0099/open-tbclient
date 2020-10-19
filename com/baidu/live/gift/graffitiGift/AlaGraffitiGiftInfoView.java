package com.baidu.live.gift.graffitiGift;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.l;
/* loaded from: classes4.dex */
public class AlaGraffitiGiftInfoView extends LinearLayout {
    private TbImageView baW;
    private HeadImageView baX;
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
        this.baW = (TbImageView) findViewById(a.g.graffiti_sender_img);
        this.baW.setIsNight(false);
        this.baW.setAutoChangeStyle(false);
        this.baX = (HeadImageView) findViewById(a.g.graffiti_sender_avatar);
        this.baX.setIsRound(true);
        this.baX.setAutoChangeStyle(false);
        this.baX.setDefaultBgResource(a.f.sdk_default_avatar);
        this.baX.setIsNight(false);
        this.baX.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(a.g.graffiti_sender_info_txt);
    }

    public void setGiftInfo(String str, String str2, String str3) {
        this.baX.setUrl(str);
        l.a(this.baX, str, false, false);
        this.mTitle.setText(str3);
    }
}
