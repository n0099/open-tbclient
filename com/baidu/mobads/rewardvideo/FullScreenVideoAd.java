package com.baidu.mobads.rewardvideo;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.production.rewardvideo.a;
import com.baidu.mobads.rewardvideo.AbstractScreenVideoAd;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class FullScreenVideoAd extends AbstractScreenVideoAd {

    /* loaded from: classes4.dex */
    public interface FullScreenVideoAdListener extends AbstractScreenVideoAd.ScreenVideoAdListener {
        @Override // com.baidu.mobads.rewardvideo.AbstractScreenVideoAd.ScreenVideoAdListener
        void onAdClick();

        @Override // com.baidu.mobads.rewardvideo.AbstractScreenVideoAd.ScreenVideoAdListener
        void onAdClose(float f);

        @Override // com.baidu.mobads.rewardvideo.AbstractScreenVideoAd.ScreenVideoAdListener
        void onAdFailed(String str);

        @Override // com.baidu.mobads.rewardvideo.AbstractScreenVideoAd.ScreenVideoAdListener
        void onAdShow();

        void onAdSkip(float f);

        @Override // com.baidu.mobads.rewardvideo.AbstractScreenVideoAd.ScreenVideoAdListener
        void onVideoDownloadFailed();

        @Override // com.baidu.mobads.rewardvideo.AbstractScreenVideoAd.ScreenVideoAdListener
        void onVideoDownloadSuccess();

        @Override // com.baidu.mobads.rewardvideo.AbstractScreenVideoAd.ScreenVideoAdListener
        void playCompletion();
    }

    public FullScreenVideoAd(Context context, String str, FullScreenVideoAdListener fullScreenVideoAdListener) {
        this(context, str, fullScreenVideoAdListener, false);
    }

    public FullScreenVideoAd(Context context, String str, FullScreenVideoAdListener fullScreenVideoAdListener, boolean z) {
        super(context, fullScreenVideoAdListener);
        this.mAdProd = new a(this.mContext, str, z, IXAdConstants4PDK.SlotType.SLOT_TYPE_FULLSCREEN_VIDEO);
    }

    @Override // com.baidu.mobads.rewardvideo.AbstractScreenVideoAd
    protected AbstractScreenVideoAd.ScreenVideoIOAdEventListener registerIOAdEventListener() {
        FullScreenIOEventListener fullScreenIOEventListener = new FullScreenIOEventListener();
        this.mAdProd.addEventListener("AdVideoSkip", fullScreenIOEventListener);
        return fullScreenIOEventListener;
    }

    /* loaded from: classes4.dex */
    private class FullScreenIOEventListener extends AbstractScreenVideoAd.ScreenVideoIOAdEventListener {
        private FullScreenIOEventListener() {
            super();
        }

        @Override // com.baidu.mobads.rewardvideo.AbstractScreenVideoAd.ScreenVideoIOAdEventListener
        protected void handleCustomEvent(String str, HashMap<String, Object> hashMap) {
            String str2;
            if ((FullScreenVideoAd.this.mAdListener instanceof FullScreenVideoAdListener) && "AdVideoSkip".equals(str)) {
                if (hashMap == null) {
                    str2 = "0";
                } else {
                    str2 = hashMap.get("play_scale").toString();
                }
                ((FullScreenVideoAdListener) FullScreenVideoAd.this.mAdListener).onAdSkip(Float.parseFloat(str2));
            }
        }
    }
}
