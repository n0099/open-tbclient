package com.baidu.mobads;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes20.dex */
public class AdService {
    private AdView bCT;
    protected static String channelId = "";
    protected static int bCU = -1;

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
        this.bCT = new AdView(context, false, adSize, str);
        this.bCT.setListener(adViewListener);
        c(viewGroup, layoutParams);
        bCU++;
    }

    private void c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        try {
            if (this.bCT.getParent() != viewGroup) {
                if (this.bCT.getParent() != null) {
                    ((ViewGroup) this.bCT.getParent()).removeView(this.bCT);
                }
                viewGroup.addView(this.bCT, layoutParams);
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }

    public void destroy() {
        if (this.bCT != null) {
            this.bCT.destroy();
            this.bCT = null;
        }
    }
}
