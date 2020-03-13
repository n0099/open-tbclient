package com.baidu.mobads;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes10.dex */
public class AdService {
    private AdView aOv;
    protected static String channelId = "";
    protected static int aOw = -1;

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
        this.aOv = new AdView(context, false, adSize, str);
        this.aOv.setListener(adViewListener);
        c(viewGroup, layoutParams);
        aOw++;
    }

    private void c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        try {
            if (this.aOv.getParent() != viewGroup) {
                if (this.aOv.getParent() != null) {
                    ((ViewGroup) this.aOv.getParent()).removeView(this.aOv);
                }
                viewGroup.addView(this.aOv, layoutParams);
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }

    public void destroy() {
        if (this.aOv != null) {
            this.aOv.destroy();
            this.aOv = null;
        }
    }
}
