package com.baidu.live.ar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.live.adp.base.BdPageContext;
/* loaded from: classes4.dex */
public abstract class ILiveMultiBeautyView extends LinearLayout {
    public abstract void setArModel(h hVar);

    public abstract void setBdPageContext(BdPageContext bdPageContext);

    public abstract void setOnEffectSelectedListener(j jVar);

    public abstract void setViewData();

    public abstract void vw();

    public abstract void vx();

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
