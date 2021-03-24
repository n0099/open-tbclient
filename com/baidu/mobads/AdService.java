package com.baidu.mobads;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes2.dex */
public class AdService {
    public static String channelId = "";
    public static int instanceCount = -1;

    /* renamed from: a  reason: collision with root package name */
    public AdView f8065a;

    public AdService(Context context, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, AdViewListener adViewListener) {
        this(context, viewGroup, layoutParams, adViewListener, AdSize.Banner, "");
    }

    private void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        try {
            if (this.f8065a.getParent() != viewGroup) {
                if (this.f8065a.getParent() != null) {
                    ((ViewGroup) this.f8065a.getParent()).removeView(this.f8065a);
                }
                viewGroup.addView(this.f8065a, layoutParams);
            }
        } catch (Exception e2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e2);
        }
    }

    public static void setChannelId(String str) {
        channelId = str;
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setChannelId(str);
    }

    public void destroy() {
        AdView adView = this.f8065a;
        if (adView != null) {
            adView.destroy();
            this.f8065a = null;
        }
    }

    public AdService(Context context, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, AdViewListener adViewListener, AdSize adSize, String str) {
        if (context != null && viewGroup != null && layoutParams != null && adViewListener != null && adSize != null) {
            AdView adView = new AdView(context, false, adSize, str);
            this.f8065a = adView;
            adView.setListener(adViewListener);
            a(viewGroup, layoutParams);
            instanceCount++;
            return;
        }
        throw new IllegalArgumentException("One of arguments is null");
    }
}
