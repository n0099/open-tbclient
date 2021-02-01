package com.baidu.live.liveroom.middleware.ar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.tbadk.core.data.BaseData;
/* loaded from: classes11.dex */
public abstract class ILiveMultiBeautyView extends LinearLayout {

    /* loaded from: classes11.dex */
    public interface a {
    }

    public abstract void setBdPageContext(BdPageContext bdPageContext);

    public abstract void setOnEffectSelectedListener(a aVar);

    public abstract void setViewData(BaseData... baseDataArr);

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
