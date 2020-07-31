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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
/* loaded from: classes4.dex */
public class AlaBigGiftExtraInfoRevisionView extends FrameLayout {
    private TextView aJE;
    private TextView aJF;
    private AlphaAnimation aJG;
    private AlphaAnimation aJH;
    private HeadImageView avs;

    public AlaBigGiftExtraInfoRevisionView(Context context) {
        this(context, null);
    }

    public AlaBigGiftExtraInfoRevisionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar.portrait != null) {
            this.avs.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            String str = cVar.userName;
            if (TextHelper.getTextLengthWithEmoji(str) > 20) {
                str = TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE;
            }
            this.aJE.setText(str);
        }
        if (cVar.aND != null) {
            this.aJF.setText(getResources().getString(a.i.donate) + cVar.aND.yp());
        }
    }

    public void zC() {
        setVisibility(0);
        if (this.aJG == null) {
            this.aJG = new AlphaAnimation(0.0f, 1.0f);
            this.aJG.setDuration(500L);
            this.aJG.setFillAfter(true);
        }
        startAnimation(this.aJG);
    }

    public void zD() {
        if (this.aJH == null) {
            this.aJH = new AlphaAnimation(1.0f, 0.0f);
            this.aJH.setDuration(500L);
            this.aJH.setFillAfter(true);
        }
        startAnimation(this.aJH);
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
        zE();
    }

    private void zE() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.popup_extra_info_revision_layout, (ViewGroup) this, true);
        this.avs = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aJE = (TextView) findViewById(a.g.tv_sender);
        this.aJF = (TextView) findViewById(a.g.tv_tip);
        this.avs.setIsRound(true);
        this.avs.setAutoChangeStyle(false);
        this.avs.setDefaultBgResource(a.f.sdk_default_avatar);
    }
}
