package com.baidu.mobads;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes14.dex */
public class AdService {
    protected static String channelId = "";
    protected static int instanceCount = -1;

    /* renamed from: a  reason: collision with root package name */
    private AdView f3252a;

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
        this.f3252a = new AdView(context, false, adSize, str);
        this.f3252a.setListener(adViewListener);
        a(viewGroup, layoutParams);
        instanceCount++;
    }

    private void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        try {
            if (this.f3252a.getParent() != viewGroup) {
                if (this.f3252a.getParent() != null) {
                    ((ViewGroup) this.f3252a.getParent()).removeView(this.f3252a);
                }
                viewGroup.addView(this.f3252a, layoutParams);
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }

    public void destroy() {
        if (this.f3252a != null) {
            this.f3252a.destroy();
            this.f3252a = null;
        }
    }
}
