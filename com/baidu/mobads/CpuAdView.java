package com.baidu.mobads;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.CpuInfoManager;
import com.baidu.mobads.component.XAdView;
/* loaded from: classes8.dex */
public final class CpuAdView extends RelativeLayout {
    private com.baidu.mobads.production.b.b aKJ;

    public CpuAdView(Context context) {
        super(context);
    }

    public CpuAdView(Context context, String str, String str2, CpuInfoManager.UrlListener urlListener) {
        super(context);
        XAdView xAdView = new XAdView(context);
        this.aKJ = new com.baidu.mobads.production.b.b(context, xAdView, str, str2);
        this.aKJ.request();
        addView(xAdView, new ViewGroup.LayoutParams(-1, -1));
    }
}
