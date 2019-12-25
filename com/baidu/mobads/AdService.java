package com.baidu.mobads;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes7.dex */
public class AdService {
    private AdView aJx;
    protected static String channelId = "";
    protected static int aJy = -1;

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
        this.aJx = new AdView(context, false, adSize, str);
        this.aJx.setListener(adViewListener);
        b(viewGroup, layoutParams);
        aJy++;
    }

    private void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        try {
            if (this.aJx.getParent() != viewGroup) {
                if (this.aJx.getParent() != null) {
                    ((ViewGroup) this.aJx.getParent()).removeView(this.aJx);
                }
                viewGroup.addView(this.aJx, layoutParams);
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }

    public void destroy() {
        if (this.aJx != null) {
            this.aJx.destroy();
            this.aJx = null;
        }
    }
}
