package com.baidu.live.ar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.data.w;
/* loaded from: classes4.dex */
public abstract class ILiveMultiBeautyView extends LinearLayout {
    public abstract void Ch();

    public abstract void Ci();

    public abstract void b(short s);

    public abstract void setAlaLiveShowData(w wVar);

    public abstract void setArModel(i iVar);

    public abstract void setBdPageContext(BdPageContext bdPageContext);

    public abstract void setOnEffectSelectedListener(k kVar);

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
