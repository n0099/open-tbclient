package com.baidu.mobads.rewardvideo;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.production.rewardvideo.a;
import com.baidu.mobads.rewardvideo.AbstractScreenVideoAd;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class RewardVideoAd extends AbstractScreenVideoAd {

    /* loaded from: classes4.dex */
    public interface RewardVideoAdListener extends AbstractScreenVideoAd.ScreenVideoAdListener {
        @Override // com.baidu.mobads.rewardvideo.AbstractScreenVideoAd.ScreenVideoAdListener
        void onAdClick();

        @Override // com.baidu.mobads.rewardvideo.AbstractScreenVideoAd.ScreenVideoAdListener
        void onAdClose(float f);

        @Override // com.baidu.mobads.rewardvideo.AbstractScreenVideoAd.ScreenVideoAdListener
        void onAdFailed(String str);

        @Override // com.baidu.mobads.rewardvideo.AbstractScreenVideoAd.ScreenVideoAdListener
        void onAdShow();

        @Override // com.baidu.mobads.rewardvideo.AbstractScreenVideoAd.ScreenVideoAdListener
        void onVideoDownloadFailed();

        @Override // com.baidu.mobads.rewardvideo.AbstractScreenVideoAd.ScreenVideoAdListener
        void onVideoDownloadSuccess();

        @Override // com.baidu.mobads.rewardvideo.AbstractScreenVideoAd.ScreenVideoAdListener
        void playCompletion();
    }

    public RewardVideoAd(Activity activity, String str, RewardVideoAdListener rewardVideoAdListener) {
        this(activity, str, rewardVideoAdListener, false);
    }

    public RewardVideoAd(Activity activity, String str, RewardVideoAdListener rewardVideoAdListener, boolean z) {
        super(activity, (AbstractScreenVideoAd.ScreenVideoAdListener) rewardVideoAdListener);
        this.mAdProd = new a(this.mContext, str, z);
    }

    public RewardVideoAd(Context context, String str, RewardVideoAdListener rewardVideoAdListener) {
        this(context, str, rewardVideoAdListener, false);
    }

    public RewardVideoAd(Context context, String str, RewardVideoAdListener rewardVideoAdListener, boolean z) {
        super(context, rewardVideoAdListener);
        this.mAdProd = new a(this.mContext, str, z);
    }

    @Override // com.baidu.mobads.rewardvideo.AbstractScreenVideoAd
    protected AbstractScreenVideoAd.ScreenVideoIOAdEventListener registerIOAdEventListener() {
        return new RewardVideoIOAdEventListener();
    }

    /* loaded from: classes4.dex */
    private class RewardVideoIOAdEventListener extends AbstractScreenVideoAd.ScreenVideoIOAdEventListener {
        private RewardVideoIOAdEventListener() {
            super();
        }

        @Override // com.baidu.mobads.rewardvideo.AbstractScreenVideoAd.ScreenVideoIOAdEventListener
        protected void handleCustomEvent(String str, HashMap<String, Object> hashMap) {
        }
    }
}
