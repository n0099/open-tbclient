package com.baidu.live.ar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.live.adp.base.BdPageContext;
/* loaded from: classes3.dex */
public abstract class ILiveMultiBeautyView extends LinearLayout {
    public abstract void setArModel(f fVar);

    public abstract void setBdPageContext(BdPageContext bdPageContext);

    public abstract void setOnEffectSelectedListener(h hVar);

    public abstract void setViewData();

    public abstract void vb();

    public abstract void vc();

    public ILiveMultiBeautyView(Context context) {
        super(context);
    }

    public ILiveMultiBeautyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ILiveMultiBeautyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
