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
    private HeadImageView aEp;
    private TextView aVA;
    private AlphaAnimation aVB;
    private AlphaAnimation aVC;
    private TextView aVy;

    public AlaBigGiftExtraInfoRevisionView(Context context) {
        this(context, null);
    }

    public AlaBigGiftExtraInfoRevisionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aEp.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            String str = cVar.userName;
            if (TextHelper.getTextLengthWithEmoji(str) > 20) {
                str = TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE;
            }
            this.aVy.setText(str);
        }
        if (cVar.aZJ != null) {
            this.aVA.setText(getResources().getString(a.i.donate) + cVar.aZJ.Ft());
        }
    }

    public void GX() {
        setVisibility(0);
        if (this.aVB == null) {
            this.aVB = new AlphaAnimation(0.0f, 1.0f);
            this.aVB.setDuration(500L);
            this.aVB.setFillAfter(true);
        }
        startAnimation(this.aVB);
    }

    public void GY() {
        if (this.aVC == null) {
            this.aVC = new AlphaAnimation(1.0f, 0.0f);
            this.aVC.setDuration(500L);
            this.aVC.setFillAfter(true);
        }
        startAnimation(this.aVC);
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
        GZ();
    }

    private void GZ() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.popup_extra_info_revision_layout, (ViewGroup) this, true);
        this.aEp = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aVy = (TextView) findViewById(a.g.tv_sender);
        this.aVA = (TextView) findViewById(a.g.tv_tip);
        this.aEp.setIsRound(true);
        this.aEp.setAutoChangeStyle(false);
        this.aEp.setDefaultBgResource(a.f.sdk_default_avatar);
    }
}
