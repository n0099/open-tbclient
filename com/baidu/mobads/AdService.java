package com.baidu.mobads;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes7.dex */
public class AdService {
    protected static String channelId = "";
    protected static int instanceCount = -1;

    /* renamed from: a  reason: collision with root package name */
    private AdView f2291a;

    public static void setChannelId(String str) {
        channelId = str;
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setChannelId(str);
    }

    public AdService(Context context, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, AdViewListener adViewListener) {
        this(context, viewGroup, layoutParams, adViewListener, AdSize.Banner, "");
    }

    public AdService(Context context, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, AdViewListener adViewListener, AdSize adSize, String str) {
        if (context == null || viewGroup == null || layoutParams == null || adViewListener == null || adSize == null) {
            throw new IllegalArgumentException("One of arguments is null");
        }
        this.f2291a = new AdView(context, false, adSize, str);
        this.f2291a.setListener(adViewListener);
        a(viewGroup, layoutParams);
        instanceCount++;
    }

    private void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        try {
            if (this.f2291a.getParent() != viewGroup) {
                if (this.f2291a.getParent() != null) {
                    ((ViewGroup) this.f2291a.getParent()).removeView(this.f2291a);
                }
                viewGroup.addView(this.f2291a, layoutParams);
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }

    public void destroy() {
        if (this.f2291a != null) {
            this.f2291a.destroy();
            this.f2291a = null;
        }
    }
}
