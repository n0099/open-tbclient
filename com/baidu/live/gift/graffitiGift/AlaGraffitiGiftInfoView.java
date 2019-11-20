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
    private TbImageView acF;
    private HeadImageView acG;
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
        this.acF = (TbImageView) findViewById(a.g.graffiti_sender_img);
        this.acF.setIsNight(false);
        this.acF.setAutoChangeStyle(false);
        this.acG = (HeadImageView) findViewById(a.g.graffiti_sender_avatar);
        this.acG.setIsRound(true);
        this.acG.setAutoChangeStyle(false);
        this.acG.setDefaultBgResource(a.f.sdk_default_avatar);
        this.acG.setIsNight(false);
        this.acG.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(a.g.graffiti_sender_info_txt);
    }

    public void setGiftInfo(String str, String str2, String str3) {
        this.acF.stopLoad();
        this.acF.startLoad(str2, 10, false);
        this.acG.setUrl(str);
        j.a(this.acG, str, false, false);
        this.mTitle.setText(str3);
    }
}
