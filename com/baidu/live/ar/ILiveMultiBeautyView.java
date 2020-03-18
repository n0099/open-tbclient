package com.baidu.live.ar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.live.adp.base.BdPageContext;
/* loaded from: classes3.dex */
public abstract class ILiveMultiBeautyView extends LinearLayout {
    public abstract void pG();

    public abstract void pH();

    public abstract void setArModel(c cVar);

    public abstract void setBdPageContext(BdPageContext bdPageContext);

    public abstract void setOnEffectSelectedListener(e eVar);

    public abstract void setViewData();

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
