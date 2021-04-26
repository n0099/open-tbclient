package com.baidu.android.lbspay.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.android.lbspay.network.NewCashierContent;
/* loaded from: classes.dex */
public abstract class ChannelViewBase extends RelativeLayout {
    public ChannelViewBase(Context context) {
        super(context);
    }

    public abstract void setChannel(NewCashierContent.IBaseChannel iBaseChannel);

    public abstract void setChecked(boolean z);

    public abstract void setEnabled(boolean z, NewCashierContent.IBaseChannel iBaseChannel);

    public ChannelViewBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @TargetApi(11)
    public ChannelViewBase(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
