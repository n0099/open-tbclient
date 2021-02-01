package com.baidu.live.yuyinquick;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class QuickInputFlexTextView extends TextView {
    public QuickInputFlexTextView(Context context) {
        super(context);
        init();
    }

    private void init() {
        setBackgroundResource(a.e.ala_yuyin_im_round_quick_input_flex);
        setGravity(17);
        setTextColor(Color.parseColor("#525252"));
        setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_fontsize28));
        setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds24), getResources().getDimensionPixelOffset(a.d.sdk_ds16), getResources().getDimensionPixelOffset(a.d.sdk_ds24), getResources().getDimensionPixelOffset(a.d.sdk_ds16));
        setMaxLines(1);
        setEllipsize(TextUtils.TruncateAt.END);
        setIncludeFontPadding(false);
    }
}
