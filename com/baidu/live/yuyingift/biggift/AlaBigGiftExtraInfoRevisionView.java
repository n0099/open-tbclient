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
    private HeadImageView aGr;
    private TextView aZW;
    private TextView aZY;
    private AlphaAnimation aZZ;
    private AlphaAnimation baa;

    public AlaBigGiftExtraInfoRevisionView(Context context) {
        this(context, null);
    }

    public AlaBigGiftExtraInfoRevisionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar.portrait != null) {
            this.aGr.startLoad(cVar.portrait, 12, false);
        }
        if (!TextUtils.isEmpty(cVar.userName)) {
            String str = cVar.userName;
            if (TextHelper.getTextLengthWithEmoji(str) > 20) {
                str = TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE;
            }
            this.aZW.setText(str);
        }
        if (cVar.bex != null) {
            this.aZY.setText(getResources().getString(a.h.donate) + cVar.bex.Gy());
        }
    }

    public void Ii() {
        setVisibility(0);
        if (this.aZZ == null) {
            this.aZZ = new AlphaAnimation(0.0f, 1.0f);
            this.aZZ.setDuration(500L);
            this.aZZ.setFillAfter(true);
        }
        startAnimation(this.aZZ);
    }

    public void Ij() {
        if (this.baa == null) {
            this.baa = new AlphaAnimation(1.0f, 0.0f);
            this.baa.setDuration(500L);
            this.baa.setFillAfter(true);
        }
        startAnimation(this.baa);
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
        Ik();
    }

    private void Ik() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.popup_extra_info_revision_layout, (ViewGroup) this, true);
        this.aGr = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aZW = (TextView) findViewById(a.f.tv_sender);
        this.aZY = (TextView) findViewById(a.f.tv_tip);
        this.aGr.setIsRound(true);
        this.aGr.setAutoChangeStyle(false);
        this.aGr.setDefaultBgResource(a.e.sdk_default_avatar);
    }
}
