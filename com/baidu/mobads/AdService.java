package com.baidu.mobads;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes10.dex */
public class AdService {
    private AdView bkA;
    protected static String channelId = "";
    protected static int bkB = -1;

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
        this.bkA = new AdView(context, false, adSize, str);
        this.bkA.setListener(adViewListener);
        c(viewGroup, layoutParams);
        bkB++;
    }

    private void c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        try {
            if (this.bkA.getParent() != viewGroup) {
                if (this.bkA.getParent() != null) {
                    ((ViewGroup) this.bkA.getParent()).removeView(this.bkA);
                }
                viewGroup.addView(this.bkA, layoutParams);
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }

    public void destroy() {
        if (this.bkA != null) {
            this.bkA.destroy();
            this.bkA = null;
        }
    }
}
