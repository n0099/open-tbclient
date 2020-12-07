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
    private HeadImageView aGa;
    private TextView aYq;
    private TextView aYs;
    private AlphaAnimation aYt;
    private AlphaAnimation aYu;

    public AlaBigGiftExtraInfoRevisionView(Context context) {
        this(context, null);
    }

    public AlaBigGiftExtraInfoRevisionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aGa.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            String str = cVar.userName;
            if (TextHelper.getTextLengthWithEmoji(str) > 20) {
                str = TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE;
            }
            this.aYq.setText(str);
        }
        if (cVar.bcN != null) {
            this.aYs.setText(getResources().getString(a.h.donate) + cVar.bcN.GY());
        }
    }

    public void IG() {
        setVisibility(0);
        if (this.aYt == null) {
            this.aYt = new AlphaAnimation(0.0f, 1.0f);
            this.aYt.setDuration(500L);
            this.aYt.setFillAfter(true);
        }
        startAnimation(this.aYt);
    }

    public void IH() {
        if (this.aYu == null) {
            this.aYu = new AlphaAnimation(1.0f, 0.0f);
            this.aYu.setDuration(500L);
            this.aYu.setFillAfter(true);
        }
        startAnimation(this.aYu);
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
        II();
    }

    private void II() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.popup_extra_info_revision_layout, (ViewGroup) this, true);
        this.aGa = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aYq = (TextView) findViewById(a.f.tv_sender);
        this.aYs = (TextView) findViewById(a.f.tv_tip);
        this.aGa.setIsRound(true);
        this.aGa.setAutoChangeStyle(false);
        this.aGa.setDefaultBgResource(a.e.sdk_default_avatar);
    }
}
