package com.baidu.mobads;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes3.dex */
public class AdService {
    protected static String channelId = "";
    protected static int instanceCount = -1;
    private AdView a;

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
        this.a = new AdView(context, false, adSize, str);
        this.a.setListener(adViewListener);
        a(viewGroup, layoutParams);
        instanceCount++;
    }

    private void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        try {
            if (this.a.getParent() != viewGroup) {
                if (this.a.getParent() != null) {
                    ((ViewGroup) this.a.getParent()).removeView(this.a);
                }
                viewGroup.addView(this.a, layoutParams);
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }

    public void destroy() {
        if (this.a != null) {
            this.a.destroy();
            this.a = null;
        }
    }
}
