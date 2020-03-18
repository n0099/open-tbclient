package com.baidu.mobads;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes10.dex */
public class AdService {
    private AdView aOJ;
    protected static String channelId = "";
    protected static int aOK = -1;

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
        this.aOJ = new AdView(context, false, adSize, str);
        this.aOJ.setListener(adViewListener);
        c(viewGroup, layoutParams);
        aOK++;
    }

    private void c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        try {
            if (this.aOJ.getParent() != viewGroup) {
                if (this.aOJ.getParent() != null) {
                    ((ViewGroup) this.aOJ.getParent()).removeView(this.aOJ);
                }
                viewGroup.addView(this.aOJ, layoutParams);
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }

    public void destroy() {
        if (this.aOJ != null) {
            this.aOJ.destroy();
            this.aOJ = null;
        }
    }
}
