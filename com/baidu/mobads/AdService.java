package com.baidu.mobads;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes10.dex */
public class AdService {
    private AdView bwV;
    protected static String channelId = "";
    protected static int bwW = -1;

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
        this.bwV = new AdView(context, false, adSize, str);
        this.bwV.setListener(adViewListener);
        c(viewGroup, layoutParams);
        bwW++;
    }

    private void c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        try {
            if (this.bwV.getParent() != viewGroup) {
                if (this.bwV.getParent() != null) {
                    ((ViewGroup) this.bwV.getParent()).removeView(this.bwV);
                }
                viewGroup.addView(this.bwV, layoutParams);
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }

    public void destroy() {
        if (this.bwV != null) {
            this.bwV.destroy();
            this.bwV = null;
        }
    }
}
