package com.baidu.live.ar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.data.ab;
/* loaded from: classes11.dex */
public abstract class ILiveMultiBeautyView extends LinearLayout {
    public abstract void b(short s);

    public abstract void setAlaLiveShowData(ab abVar);

    public abstract void setArModel(k kVar);

    public abstract void setBdPageContext(BdPageContext bdPageContext);

    public abstract void setOnEffectSelectedListener(m mVar);

    public abstract void setViewData();

    public abstract void zC();

    public abstract void zD();

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
