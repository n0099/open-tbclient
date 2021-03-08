package com.baidu.live.yuyingift.biggift;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
/* loaded from: classes10.dex */
public class AlaBigGiftExtraInfoRevisionView extends FrameLayout {
    private HeadImageView aER;
    private TextView aZR;
    private TextView aZT;
    private AlphaAnimation aZU;
    private AlphaAnimation aZV;

    public AlaBigGiftExtraInfoRevisionView(Context context) {
        this(context, null);
    }

    public AlaBigGiftExtraInfoRevisionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aER.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            String str = cVar.userName;
            if (TextHelper.getTextLengthWithEmoji(str) > 20) {
                str = TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE;
            }
            this.aZR.setText(str);
        }
        if (cVar.bep != null) {
            this.aZT.setText(getResources().getString(a.h.donate) + cVar.bep.DV());
        }
    }

    public void FG() {
        setVisibility(0);
        if (this.aZU == null) {
            this.aZU = new AlphaAnimation(0.0f, 1.0f);
            this.aZU.setDuration(500L);
            this.aZU.setFillAfter(true);
        }
        startAnimation(this.aZU);
    }

    public void FH() {
        if (this.aZV == null) {
            this.aZV = new AlphaAnimation(1.0f, 0.0f);
            this.aZV.setDuration(500L);
            this.aZV.setFillAfter(true);
        }
        startAnimation(this.aZV);
    }

    public void onDestroy() {
        setVisibility(8);
        clearAnimation();
    }

    public void end() {
        setVisibility(8);
        clearAnimation();
    }

    private void init() {
        setBackgroundColor(0);
        FI();
    }

    private void FI() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.popup_extra_info_revision_layout, (ViewGroup) this, true);
        this.aER = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aZR = (TextView) findViewById(a.f.tv_sender);
        this.aZT = (TextView) findViewById(a.f.tv_tip);
        this.aER.setIsRound(true);
        this.aER.setAutoChangeStyle(false);
        this.aER.setDefaultBgResource(a.e.sdk_default_avatar);
    }
}
