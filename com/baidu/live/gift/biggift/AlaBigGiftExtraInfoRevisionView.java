package com.baidu.live.gift.biggift;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaBigGiftExtraInfoRevisionView extends FrameLayout {
    private HeadImageView aFL;
    private TextView aFM;
    private TextView aFN;
    private AlphaAnimation aFO;
    private AlphaAnimation aFP;

    public AlaBigGiftExtraInfoRevisionView(Context context) {
        this(context, null);
    }

    public AlaBigGiftExtraInfoRevisionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aFL.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            String str = cVar.userName;
            if (TextHelper.getTextLengthWithEmoji(str) > 20) {
                str = TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE;
            }
            this.aFM.setText(str);
        }
        if (cVar.aJC != null) {
            this.aFN.setText(getResources().getString(a.i.donate) + cVar.aJC.xm());
        }
    }

    public void yA() {
        setVisibility(0);
        if (this.aFO == null) {
            this.aFO = new AlphaAnimation(0.0f, 1.0f);
            this.aFO.setDuration(500L);
            this.aFO.setFillAfter(true);
        }
        startAnimation(this.aFO);
    }

    public void yB() {
        if (this.aFP == null) {
            this.aFP = new AlphaAnimation(1.0f, 0.0f);
            this.aFP.setDuration(500L);
            this.aFP.setFillAfter(true);
        }
        startAnimation(this.aFP);
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
        yC();
    }

    private void yC() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.popup_extra_info_revision_layout, (ViewGroup) this, true);
        this.aFL = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aFM = (TextView) findViewById(a.g.tv_sender);
        this.aFN = (TextView) findViewById(a.g.tv_tip);
        this.aFL.setIsRound(true);
        this.aFL.setAutoChangeStyle(false);
        this.aFL.setDefaultBgResource(a.f.sdk_default_avatar);
    }
}
