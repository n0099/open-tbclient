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
/* loaded from: classes11.dex */
public class AlaBigGiftExtraInfoRevisionView extends FrameLayout {
    private HeadImageView aDr;
    private TextView aYr;
    private TextView aYt;
    private AlphaAnimation aYu;
    private AlphaAnimation aYv;

    public AlaBigGiftExtraInfoRevisionView(Context context) {
        this(context, null);
    }

    public AlaBigGiftExtraInfoRevisionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aDr.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            String str = cVar.userName;
            if (TextHelper.getTextLengthWithEmoji(str) > 20) {
                str = TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE;
            }
            this.aYr.setText(str);
        }
        if (cVar.bcO != null) {
            this.aYt.setText(getResources().getString(a.h.donate) + cVar.bcO.DS());
        }
    }

    public void FD() {
        setVisibility(0);
        if (this.aYu == null) {
            this.aYu = new AlphaAnimation(0.0f, 1.0f);
            this.aYu.setDuration(500L);
            this.aYu.setFillAfter(true);
        }
        startAnimation(this.aYu);
    }

    public void FE() {
        if (this.aYv == null) {
            this.aYv = new AlphaAnimation(1.0f, 0.0f);
            this.aYv.setDuration(500L);
            this.aYv.setFillAfter(true);
        }
        startAnimation(this.aYv);
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
        FF();
    }

    private void FF() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.popup_extra_info_revision_layout, (ViewGroup) this, true);
        this.aDr = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aYr = (TextView) findViewById(a.f.tv_sender);
        this.aYt = (TextView) findViewById(a.f.tv_tip);
        this.aDr.setIsRound(true);
        this.aDr.setAutoChangeStyle(false);
        this.aDr.setDefaultBgResource(a.e.sdk_default_avatar);
    }
}
