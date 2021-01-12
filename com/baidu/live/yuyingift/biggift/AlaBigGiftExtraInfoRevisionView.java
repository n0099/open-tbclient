package com.baidu.live.yuyingift.biggift;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
/* loaded from: classes10.dex */
public class AlaBigGiftExtraInfoRevisionView extends FrameLayout {
    private HeadImageView aBE;
    private TextView aVj;
    private TextView aVl;
    private AlphaAnimation aVm;
    private AlphaAnimation aVn;

    public AlaBigGiftExtraInfoRevisionView(Context context) {
        this(context, null);
    }

    public AlaBigGiftExtraInfoRevisionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aBE.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            String str = cVar.userName;
            if (TextHelper.getTextLengthWithEmoji(str) > 20) {
                str = TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE;
            }
            this.aVj.setText(str);
        }
        if (cVar.aZH != null) {
            this.aVl.setText(getResources().getString(a.h.donate) + cVar.aZH.CD());
        }
    }

    public void En() {
        setVisibility(0);
        if (this.aVm == null) {
            this.aVm = new AlphaAnimation(0.0f, 1.0f);
            this.aVm.setDuration(500L);
            this.aVm.setFillAfter(true);
        }
        startAnimation(this.aVm);
    }

    public void Eo() {
        if (this.aVn == null) {
            this.aVn = new AlphaAnimation(1.0f, 0.0f);
            this.aVn.setDuration(500L);
            this.aVn.setFillAfter(true);
        }
        startAnimation(this.aVn);
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
        Ep();
    }

    private void Ep() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.popup_extra_info_revision_layout, (ViewGroup) this, true);
        this.aBE = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aVj = (TextView) findViewById(a.f.tv_sender);
        this.aVl = (TextView) findViewById(a.f.tv_tip);
        this.aBE.setIsRound(true);
        this.aBE.setAutoChangeStyle(false);
        this.aBE.setDefaultBgResource(a.e.sdk_default_avatar);
    }
}
