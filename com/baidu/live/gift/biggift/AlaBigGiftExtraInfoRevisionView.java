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
/* loaded from: classes7.dex */
public class AlaBigGiftExtraInfoRevisionView extends FrameLayout {
    private HeadImageView aAw;
    private TextView aOR;
    private TextView aOS;
    private AlphaAnimation aOT;
    private AlphaAnimation aOU;

    public AlaBigGiftExtraInfoRevisionView(Context context) {
        this(context, null);
    }

    public AlaBigGiftExtraInfoRevisionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aAw.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            String str = cVar.userName;
            if (TextHelper.getTextLengthWithEmoji(str) > 20) {
                str = TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE;
            }
            this.aOR.setText(str);
        }
        if (cVar.aSS != null) {
            this.aOS.setText(getResources().getString(a.i.donate) + cVar.aSS.DS());
        }
    }

    public void Ff() {
        setVisibility(0);
        if (this.aOT == null) {
            this.aOT = new AlphaAnimation(0.0f, 1.0f);
            this.aOT.setDuration(500L);
            this.aOT.setFillAfter(true);
        }
        startAnimation(this.aOT);
    }

    public void Fg() {
        if (this.aOU == null) {
            this.aOU = new AlphaAnimation(1.0f, 0.0f);
            this.aOU.setDuration(500L);
            this.aOU.setFillAfter(true);
        }
        startAnimation(this.aOU);
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
        Fh();
    }

    private void Fh() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.popup_extra_info_revision_layout, (ViewGroup) this, true);
        this.aAw = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aOR = (TextView) findViewById(a.g.tv_sender);
        this.aOS = (TextView) findViewById(a.g.tv_tip);
        this.aAw.setIsRound(true);
        this.aAw.setAutoChangeStyle(false);
        this.aAw.setDefaultBgResource(a.f.sdk_default_avatar);
    }
}
