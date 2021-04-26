package com.baidu.mobads.container.components;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;
/* loaded from: classes2.dex */
public class XAdCountdownTimerView extends TextView {
    public XAdCountdownTimerView(Context context) {
        super(context);
        setBackgroundColor(-2146497529);
        setGravity(17);
        setTextColor(Color.rgb(254, 211, 73));
        setTextSize(12.0f);
    }

    public void setRemainTime(int i2, int i3) {
        setText("" + (i3 - i2));
    }
}
