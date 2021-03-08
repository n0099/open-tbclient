package com.baidu.live.gift.graffitiGift;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.m;
/* loaded from: classes10.dex */
public class AlaGraffitiGiftInfoView extends LinearLayout {
    private TbImageView bht;
    private HeadImageView bhu;
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
        View.inflate(getContext(), a.g.popup_graffiti_gift_info_layout, this);
        setBackgroundResource(a.e.ala_small_gift_bg_alpha_shape);
        this.bht = (TbImageView) findViewById(a.f.graffiti_sender_img);
        this.bht.setIsNight(false);
        this.bht.setAutoChangeStyle(false);
        this.bhu = (HeadImageView) findViewById(a.f.graffiti_sender_avatar);
        this.bhu.setIsRound(true);
        this.bhu.setAutoChangeStyle(false);
        this.bhu.setDefaultBgResource(a.e.sdk_default_avatar);
        this.bhu.setIsNight(false);
        this.bhu.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(a.f.graffiti_sender_info_txt);
    }

    public void setGiftInfo(String str, String str2, String str3) {
        this.bhu.setUrl(str);
        m.a(this.bhu, str, false, false);
        this.mTitle.setText(str3);
    }
}
