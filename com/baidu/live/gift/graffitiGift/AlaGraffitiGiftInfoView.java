package com.baidu.live.gift.graffitiGift;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.j;
/* loaded from: classes6.dex */
public class AlaGraffitiGiftInfoView extends LinearLayout {
    private TbImageView acX;
    private HeadImageView acY;
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
        this.acX = (TbImageView) findViewById(a.g.graffiti_sender_img);
        this.acX.setIsNight(false);
        this.acX.setAutoChangeStyle(false);
        this.acY = (HeadImageView) findViewById(a.g.graffiti_sender_avatar);
        this.acY.setIsRound(true);
        this.acY.setAutoChangeStyle(false);
        this.acY.setDefaultBgResource(a.f.sdk_default_avatar);
        this.acY.setIsNight(false);
        this.acY.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(a.g.graffiti_sender_info_txt);
    }

    public void setGiftInfo(String str, String str2, String str3) {
        this.acX.stopLoad();
        this.acX.startLoad(str2, 10, false);
        this.acY.setUrl(str);
        j.a(this.acY, str, false, false);
        this.mTitle.setText(str3);
    }
}
