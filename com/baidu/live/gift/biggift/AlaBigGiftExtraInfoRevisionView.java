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
/* loaded from: classes3.dex */
public class AlaBigGiftExtraInfoRevisionView extends FrameLayout {
    private HeadImageView aIh;
    private TextView aIi;
    private TextView aIj;
    private AlphaAnimation aIk;
    private AlphaAnimation aIl;

    public AlaBigGiftExtraInfoRevisionView(Context context) {
        this(context, null);
    }

    public AlaBigGiftExtraInfoRevisionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aIh.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            String str = cVar.userName;
            if (TextHelper.getTextLengthWithEmoji(str) > 20) {
                str = TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE;
            }
            this.aIi.setText(str);
        }
        if (cVar.aMi != null) {
            this.aIj.setText(getResources().getString(a.i.donate) + cVar.aMi.xN());
        }
    }

    public void za() {
        setVisibility(0);
        if (this.aIk == null) {
            this.aIk = new AlphaAnimation(0.0f, 1.0f);
            this.aIk.setDuration(500L);
            this.aIk.setFillAfter(true);
        }
        startAnimation(this.aIk);
    }

    public void zb() {
        if (this.aIl == null) {
            this.aIl = new AlphaAnimation(1.0f, 0.0f);
            this.aIl.setDuration(500L);
            this.aIl.setFillAfter(true);
        }
        startAnimation(this.aIl);
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
        zc();
    }

    private void zc() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.popup_extra_info_revision_layout, (ViewGroup) this, true);
        this.aIh = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aIi = (TextView) findViewById(a.g.tv_sender);
        this.aIj = (TextView) findViewById(a.g.tv_tip);
        this.aIh.setIsRound(true);
        this.aIh.setAutoChangeStyle(false);
        this.aIh.setDefaultBgResource(a.f.sdk_default_avatar);
    }
}
