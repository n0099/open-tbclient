package com.baidu.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class AlaLoadingView extends RelativeLayout {
    public AlaLoadingView(Context context) {
        super(context);
        bv(context);
    }

    public AlaLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bv(context);
    }

    public AlaLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bv(context);
    }

    protected void bv(Context context) {
        LayoutInflater.from(context).inflate(a.g.yuyin_ala_loading_view, (ViewGroup) this, true);
        setGravity(17);
        setBackgroundColor(-1);
    }
}
