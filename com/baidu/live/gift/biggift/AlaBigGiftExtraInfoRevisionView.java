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
    private HeadImageView aAm;
    private TextView aAn;
    private TextView aAo;
    private AlphaAnimation aAp;
    private AlphaAnimation aAq;

    public AlaBigGiftExtraInfoRevisionView(Context context) {
        this(context, null);
    }

    public AlaBigGiftExtraInfoRevisionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aAm.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            String str = cVar.userName;
            if (TextHelper.getTextLengthWithEmoji(str) > 20) {
                str = TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE;
            }
            this.aAn.setText(str);
        }
        if (cVar.aDX != null) {
            this.aAo.setText(getResources().getString(a.i.donate) + cVar.aDX.vW());
        }
    }

    public void xn() {
        setVisibility(0);
        if (this.aAp == null) {
            this.aAp = new AlphaAnimation(0.0f, 1.0f);
            this.aAp.setDuration(500L);
            this.aAp.setFillAfter(true);
        }
        startAnimation(this.aAp);
    }

    public void xo() {
        if (this.aAq == null) {
            this.aAq = new AlphaAnimation(1.0f, 0.0f);
            this.aAq.setDuration(500L);
            this.aAq.setFillAfter(true);
        }
        startAnimation(this.aAq);
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
        xp();
    }

    private void xp() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.popup_extra_info_revision_layout, (ViewGroup) this, true);
        this.aAm = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aAn = (TextView) findViewById(a.g.tv_sender);
        this.aAo = (TextView) findViewById(a.g.tv_tip);
        this.aAm.setIsRound(true);
        this.aAm.setAutoChangeStyle(false);
        this.aAm.setDefaultBgResource(a.f.sdk_default_avatar);
    }
}
