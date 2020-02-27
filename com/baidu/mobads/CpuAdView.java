package com.baidu.mobads;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.CpuInfoManager;
import com.baidu.mobads.component.XAdView;
/* loaded from: classes10.dex */
public final class CpuAdView extends RelativeLayout {
    private com.baidu.mobads.production.b.b aON;

    public CpuAdView(Context context) {
        super(context);
    }

    public CpuAdView(Context context, String str, String str2, CpuInfoManager.UrlListener urlListener) {
        super(context);
        XAdView xAdView = new XAdView(context);
        this.aON = new com.baidu.mobads.production.b.b(context, xAdView, str, str2);
        this.aON.request();
        addView(xAdView, new ViewGroup.LayoutParams(-1, -1));
    }
}
