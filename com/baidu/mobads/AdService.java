package com.baidu.mobads;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes8.dex */
public class AdService {
    private AdView aKp;
    protected static String channelId = "";
    protected static int aKq = -1;

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
        this.aKp = new AdView(context, false, adSize, str);
        this.aKp.setListener(adViewListener);
        b(viewGroup, layoutParams);
        aKq++;
    }

    private void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        try {
            if (this.aKp.getParent() != viewGroup) {
                if (this.aKp.getParent() != null) {
                    ((ViewGroup) this.aKp.getParent()).removeView(this.aKp);
                }
                viewGroup.addView(this.aKp, layoutParams);
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }

    public void destroy() {
        if (this.aKp != null) {
            this.aKp.destroy();
            this.aKp = null;
        }
    }
}
