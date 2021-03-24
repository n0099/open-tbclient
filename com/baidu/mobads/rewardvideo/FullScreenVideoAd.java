package com.baidu.mobads.rewardvideo;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.production.rewardvideo.a;
import com.baidu.mobads.rewardvideo.AbstractScreenVideoAd;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class FullScreenVideoAd extends AbstractScreenVideoAd {

    /* loaded from: classes2.dex */
    public class FullScreenIOEventListener extends AbstractScreenVideoAd.ScreenVideoIOAdEventListener {
        public FullScreenIOEventListener() {
            super();
        }

        @Override // com.baidu.mobads.rewardvideo.AbstractScreenVideoAd.ScreenVideoIOAdEventListener
        public void handleCustomEvent(String str, HashMap<String, Object> hashMap) {
            if ((FullScreenVideoAd.this.mAdListener instanceof FullScreenVideoAdListener) && "AdVideoSkip".equals(str)) {
                ((FullScreenVideoAdListener) FullScreenVideoAd.this.mAdListener).onAdSkip(Float.parseFloat(hashMap != null ? hashMap.get("play_scale").toString() : "0"));
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface FullScreenVideoAdListener extends AbstractScreenVideoAd.ScreenVideoAdListener {
        @Override // com.baidu.mobads.rewardvideo.AbstractScreenVideoAd.ScreenVideoAdListener
        void onAdClick();

        @Override // com.baidu.mobads.rewardvideo.AbstractScreenVideoAd.ScreenVideoAdListener
        void onAdClose(float f2);

        @Override // com.baidu.mobads.rewardvideo.AbstractScreenVideoAd.ScreenVideoAdListener
        void onAdFailed(String str);

        @Override // com.baidu.mobads.rewardvideo.AbstractScreenVideoAd.ScreenVideoAdListener
        void onAdShow();

        void onAdSkip(float f2);

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

    @Override // com.baidu.mobads.rewardvideo.AbstractScreenVideoAd
    public AbstractScreenVideoAd.ScreenVideoIOAdEventListener registerIOAdEventListener() {
        FullScreenIOEventListener fullScreenIOEventListener = new FullScreenIOEventListener();
        this.mAdProd.addEventListener("AdVideoSkip", fullScreenIOEventListener);
        return fullScreenIOEventListener;
    }

    public FullScreenVideoAd(Context context, String str, FullScreenVideoAdListener fullScreenVideoAdListener, boolean z) {
        super(context, fullScreenVideoAdListener);
        this.mAdProd = new a(this.mContext, str, z, IXAdConstants4PDK.SlotType.SLOT_TYPE_FULLSCREEN_VIDEO);
    }
}
