package com.baidu.live.yuyingift.biggift;

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
    private HeadImageView aFf;
    private TextView aWQ;
    private TextView aWS;
    private AlphaAnimation aWT;
    private AlphaAnimation aWU;

    public AlaBigGiftExtraInfoRevisionView(Context context) {
        this(context, null);
    }

    public AlaBigGiftExtraInfoRevisionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aFf.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            String str = cVar.userName;
            if (TextHelper.getTextLengthWithEmoji(str) > 20) {
                str = TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE;
            }
            this.aWQ.setText(str);
        }
        if (cVar.bbc != null) {
            this.aWS.setText(getResources().getString(a.h.donate) + cVar.bbc.FU());
        }
    }

    public void Hy() {
        setVisibility(0);
        if (this.aWT == null) {
            this.aWT = new AlphaAnimation(0.0f, 1.0f);
            this.aWT.setDuration(500L);
            this.aWT.setFillAfter(true);
        }
        startAnimation(this.aWT);
    }

    public void Hz() {
        if (this.aWU == null) {
            this.aWU = new AlphaAnimation(1.0f, 0.0f);
            this.aWU.setDuration(500L);
            this.aWU.setFillAfter(true);
        }
        startAnimation(this.aWU);
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
        HA();
    }

    private void HA() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.popup_extra_info_revision_layout, (ViewGroup) this, true);
        this.aFf = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aWQ = (TextView) findViewById(a.f.tv_sender);
        this.aWS = (TextView) findViewById(a.f.tv_tip);
        this.aFf.setIsRound(true);
        this.aFf.setAutoChangeStyle(false);
        this.aFf.setDefaultBgResource(a.e.sdk_default_avatar);
    }
}
