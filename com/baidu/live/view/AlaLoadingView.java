package com.baidu.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class AlaLoadingView extends RelativeLayout {
    public AlaLoadingView(Context context) {
        super(context);
        bs(context);
    }

    public AlaLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bs(context);
    }

    public AlaLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bs(context);
    }

    protected void bs(Context context) {
        LayoutInflater.from(context).inflate(a.g.yuyin_ala_loading_view, (ViewGroup) this, true);
        setGravity(17);
        setBackgroundColor(-1);
    }
}
