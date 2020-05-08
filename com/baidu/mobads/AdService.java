package com.baidu.mobads;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes10.dex */
public class AdService {
    private AdView bkF;
    protected static String channelId = "";
    protected static int bkG = -1;

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
        this.bkF = new AdView(context, false, adSize, str);
        this.bkF.setListener(adViewListener);
        c(viewGroup, layoutParams);
        bkG++;
    }

    private void c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        try {
            if (this.bkF.getParent() != viewGroup) {
                if (this.bkF.getParent() != null) {
                    ((ViewGroup) this.bkF.getParent()).removeView(this.bkF);
                }
                viewGroup.addView(this.bkF, layoutParams);
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }

    public void destroy() {
        if (this.bkF != null) {
            this.bkF.destroy();
            this.bkF = null;
        }
    }
}
