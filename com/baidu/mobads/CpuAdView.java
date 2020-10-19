package com.baidu.mobads;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.CpuInfoManager;
import com.baidu.mobads.component.XAdView;
/* loaded from: classes7.dex */
public final class CpuAdView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.mobads.production.b.b f2302a;

    public CpuAdView(Context context) {
        super(context);
    }

    public CpuAdView(Context context, String str, String str2, CpuInfoManager.UrlListener urlListener) {
        super(context);
        XAdView xAdView = new XAdView(context);
        this.f2302a = new com.baidu.mobads.production.b.b(context, xAdView, str, str2);
        this.f2302a.request();
        addView(xAdView, new ViewGroup.LayoutParams(-1, -1));
    }
}
