package com.baidu.mobads;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes20.dex */
public class AdService {
    private AdView bxk;
    protected static String channelId = "";
    protected static int bxl = -1;

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
        this.bxk = new AdView(context, false, adSize, str);
        this.bxk.setListener(adViewListener);
        c(viewGroup, layoutParams);
        bxl++;
    }

    private void c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        try {
            if (this.bxk.getParent() != viewGroup) {
                if (this.bxk.getParent() != null) {
                    ((ViewGroup) this.bxk.getParent()).removeView(this.bxk);
                }
                viewGroup.addView(this.bxk, layoutParams);
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }

    public void destroy() {
        if (this.bxk != null) {
            this.bxk.destroy();
            this.bxk = null;
        }
    }
}
