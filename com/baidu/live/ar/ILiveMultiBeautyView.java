package com.baidu.live.ar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.data.w;
/* loaded from: classes4.dex */
public abstract class ILiveMultiBeautyView extends LinearLayout {
    public abstract void CA();

    public abstract void Cz();

    public abstract void b(short s);

    public abstract void setAlaLiveShowData(w wVar);

    public abstract void setArModel(j jVar);

    public abstract void setBdPageContext(BdPageContext bdPageContext);

    public abstract void setOnEffectSelectedListener(l lVar);

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
