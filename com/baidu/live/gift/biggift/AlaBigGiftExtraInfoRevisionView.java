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
    private HeadImageView aAu;
    private TextView aOP;
    private TextView aOQ;
    private AlphaAnimation aOR;
    private AlphaAnimation aOS;

    public AlaBigGiftExtraInfoRevisionView(Context context) {
        this(context, null);
    }

    public AlaBigGiftExtraInfoRevisionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aAu.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            String str = cVar.userName;
            if (TextHelper.getTextLengthWithEmoji(str) > 20) {
                str = TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE;
            }
            this.aOP.setText(str);
        }
        if (cVar.aSQ != null) {
            this.aOQ.setText(getResources().getString(a.i.donate) + cVar.aSQ.DS());
        }
    }

    public void Ff() {
        setVisibility(0);
        if (this.aOR == null) {
            this.aOR = new AlphaAnimation(0.0f, 1.0f);
            this.aOR.setDuration(500L);
            this.aOR.setFillAfter(true);
        }
        startAnimation(this.aOR);
    }

    public void Fg() {
        if (this.aOS == null) {
            this.aOS = new AlphaAnimation(1.0f, 0.0f);
            this.aOS.setDuration(500L);
            this.aOS.setFillAfter(true);
        }
        startAnimation(this.aOS);
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
        this.aAu = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aOP = (TextView) findViewById(a.g.tv_sender);
        this.aOQ = (TextView) findViewById(a.g.tv_tip);
        this.aAu.setIsRound(true);
        this.aAu.setAutoChangeStyle(false);
        this.aAu.setDefaultBgResource(a.f.sdk_default_avatar);
    }
}
