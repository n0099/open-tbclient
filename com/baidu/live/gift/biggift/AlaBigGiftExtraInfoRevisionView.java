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
    private HeadImageView aAs;
    private TextView aAt;
    private TextView aAu;
    private AlphaAnimation aAv;
    private AlphaAnimation aAw;

    public AlaBigGiftExtraInfoRevisionView(Context context) {
        this(context, null);
    }

    public AlaBigGiftExtraInfoRevisionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aAs.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            String str = cVar.userName;
            if (TextHelper.getTextLengthWithEmoji(str) > 20) {
                str = TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE;
            }
            this.aAt.setText(str);
        }
        if (cVar.aEd != null) {
            this.aAu.setText(getResources().getString(a.i.donate) + cVar.aEd.vV());
        }
    }

    public void xm() {
        setVisibility(0);
        if (this.aAv == null) {
            this.aAv = new AlphaAnimation(0.0f, 1.0f);
            this.aAv.setDuration(500L);
            this.aAv.setFillAfter(true);
        }
        startAnimation(this.aAv);
    }

    public void xn() {
        if (this.aAw == null) {
            this.aAw = new AlphaAnimation(1.0f, 0.0f);
            this.aAw.setDuration(500L);
            this.aAw.setFillAfter(true);
        }
        startAnimation(this.aAw);
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
        xo();
    }

    private void xo() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.popup_extra_info_revision_layout, (ViewGroup) this, true);
        this.aAs = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aAt = (TextView) findViewById(a.g.tv_sender);
        this.aAu = (TextView) findViewById(a.g.tv_tip);
        this.aAs.setIsRound(true);
        this.aAs.setAutoChangeStyle(false);
        this.aAs.setDefaultBgResource(a.f.sdk_default_avatar);
    }
}
