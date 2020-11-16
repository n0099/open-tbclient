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
    private HeadImageView aDu;
    private TextView aVf;
    private TextView aVh;
    private AlphaAnimation aVi;
    private AlphaAnimation aVj;

    public AlaBigGiftExtraInfoRevisionView(Context context) {
        this(context, null);
    }

    public AlaBigGiftExtraInfoRevisionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aDu.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            String str = cVar.userName;
            if (TextHelper.getTextLengthWithEmoji(str) > 20) {
                str = TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE;
            }
            this.aVf.setText(str);
        }
        if (cVar.aZq != null) {
            this.aVh.setText(getResources().getString(a.h.donate) + cVar.aZq.Fl());
        }
    }

    public void GP() {
        setVisibility(0);
        if (this.aVi == null) {
            this.aVi = new AlphaAnimation(0.0f, 1.0f);
            this.aVi.setDuration(500L);
            this.aVi.setFillAfter(true);
        }
        startAnimation(this.aVi);
    }

    public void GQ() {
        if (this.aVj == null) {
            this.aVj = new AlphaAnimation(1.0f, 0.0f);
            this.aVj.setDuration(500L);
            this.aVj.setFillAfter(true);
        }
        startAnimation(this.aVj);
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
        GR();
    }

    private void GR() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.popup_extra_info_revision_layout, (ViewGroup) this, true);
        this.aDu = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aVf = (TextView) findViewById(a.f.tv_sender);
        this.aVh = (TextView) findViewById(a.f.tv_tip);
        this.aDu.setIsRound(true);
        this.aDu.setAutoChangeStyle(false);
        this.aDu.setDefaultBgResource(a.e.sdk_default_avatar);
    }
}
