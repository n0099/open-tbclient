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
    private HeadImageView aEh;
    private TextView aUe;
    private TextView aUf;
    private AlphaAnimation aUg;
    private AlphaAnimation aUh;

    public AlaBigGiftExtraInfoRevisionView(Context context) {
        this(context, null);
    }

    public AlaBigGiftExtraInfoRevisionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aEh.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            String str = cVar.userName;
            if (TextHelper.getTextLengthWithEmoji(str) > 20) {
                str = TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE;
            }
            this.aUe.setText(str);
        }
        if (cVar.aYo != null) {
            this.aUf.setText(getResources().getString(a.i.donate) + cVar.aYo.Fe());
        }
    }

    public void GB() {
        setVisibility(0);
        if (this.aUg == null) {
            this.aUg = new AlphaAnimation(0.0f, 1.0f);
            this.aUg.setDuration(500L);
            this.aUg.setFillAfter(true);
        }
        startAnimation(this.aUg);
    }

    public void GC() {
        if (this.aUh == null) {
            this.aUh = new AlphaAnimation(1.0f, 0.0f);
            this.aUh.setDuration(500L);
            this.aUh.setFillAfter(true);
        }
        startAnimation(this.aUh);
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
        GD();
    }

    private void GD() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.popup_extra_info_revision_layout, (ViewGroup) this, true);
        this.aEh = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aUe = (TextView) findViewById(a.g.tv_sender);
        this.aUf = (TextView) findViewById(a.g.tv_tip);
        this.aEh.setIsRound(true);
        this.aEh.setAutoChangeStyle(false);
        this.aEh.setDefaultBgResource(a.f.sdk_default_avatar);
    }
}
