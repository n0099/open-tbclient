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
    private HeadImageView aBc;
    private TextView aQT;
    private TextView aQU;
    private AlphaAnimation aQV;
    private AlphaAnimation aQW;

    public AlaBigGiftExtraInfoRevisionView(Context context) {
        this(context, null);
    }

    public AlaBigGiftExtraInfoRevisionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aBc.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            String str = cVar.userName;
            if (TextHelper.getTextLengthWithEmoji(str) > 20) {
                str = TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE;
            }
            this.aQT.setText(str);
        }
        if (cVar.aVd != null) {
            this.aQU.setText(getResources().getString(a.i.donate) + cVar.aVd.Ei());
        }
    }

    public void FF() {
        setVisibility(0);
        if (this.aQV == null) {
            this.aQV = new AlphaAnimation(0.0f, 1.0f);
            this.aQV.setDuration(500L);
            this.aQV.setFillAfter(true);
        }
        startAnimation(this.aQV);
    }

    public void FG() {
        if (this.aQW == null) {
            this.aQW = new AlphaAnimation(1.0f, 0.0f);
            this.aQW.setDuration(500L);
            this.aQW.setFillAfter(true);
        }
        startAnimation(this.aQW);
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
        FH();
    }

    private void FH() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.popup_extra_info_revision_layout, (ViewGroup) this, true);
        this.aBc = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aQT = (TextView) findViewById(a.g.tv_sender);
        this.aQU = (TextView) findViewById(a.g.tv_tip);
        this.aBc.setIsRound(true);
        this.aBc.setAutoChangeStyle(false);
        this.aBc.setDefaultBgResource(a.f.sdk_default_avatar);
    }
}
