package com.baidu.mobads.rewardvideo;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.MobRewardVideoImpl;
import com.baidu.mobads.g.q;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.production.rewardvideo.a;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;
/* loaded from: classes2.dex */
public abstract class AbstractScreenVideoAd {

    /* renamed from: a  reason: collision with root package name */
    public IXAdConstants4PDK.ActivityState f8509a = IXAdConstants4PDK.ActivityState.CREATE;
    public ScreenVideoAdListener mAdListener;
    public a mAdProd;
    public final Context mContext;

    /* loaded from: classes2.dex */
    public interface ScreenVideoAdListener {
        void onAdClick();

        void onAdClose(float f2);

        void onAdFailed(String str);

        void onAdShow();

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();

        void playCompletion();
    }

    /* loaded from: classes2.dex */
    public abstract class ScreenVideoIOAdEventListener implements IOAdEventListener {
        public ScreenVideoIOAdEventListener() {
        }

        private void a(String str, HashMap<String, Object> hashMap) {
            if (IXAdEvent.AD_LOADED.equals(str)) {
                return;
            }
            if (IXAdEvent.AD_STARTED.equals(str)) {
                ScreenVideoAdListener screenVideoAdListener = AbstractScreenVideoAd.this.mAdListener;
                if (screenVideoAdListener != null) {
                    screenVideoAdListener.onAdShow();
                }
            } else if ("AdUserClick".equals(str)) {
                ScreenVideoAdListener screenVideoAdListener2 = AbstractScreenVideoAd.this.mAdListener;
                if (screenVideoAdListener2 != null) {
                    screenVideoAdListener2.onAdClick();
                }
            } else if (IXAdEvent.AD_STOPPED.equals(str)) {
                MobRewardVideoImpl.mVideoPlaying = false;
                String obj = hashMap != null ? hashMap.get("play_scale").toString() : "0";
                ScreenVideoAdListener screenVideoAdListener3 = AbstractScreenVideoAd.this.mAdListener;
                if (screenVideoAdListener3 != null) {
                    screenVideoAdListener3.onAdClose(Float.valueOf(obj).floatValue());
                }
            } else if ("AdRvdieoCacheSucc".equals(str)) {
                ScreenVideoAdListener screenVideoAdListener4 = AbstractScreenVideoAd.this.mAdListener;
                if (screenVideoAdListener4 != null) {
                    screenVideoAdListener4.onVideoDownloadSuccess();
                }
            } else if ("AdRvdieoCacheFailed".equals(str)) {
                ScreenVideoAdListener screenVideoAdListener5 = AbstractScreenVideoAd.this.mAdListener;
                if (screenVideoAdListener5 != null) {
                    screenVideoAdListener5.onVideoDownloadFailed();
                }
            } else if (IXAdEvent.AD_ERROR.equals(str)) {
                ScreenVideoAdListener screenVideoAdListener6 = AbstractScreenVideoAd.this.mAdListener;
                if (screenVideoAdListener6 != null) {
                    screenVideoAdListener6.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(hashMap));
                }
            } else if ("PlayCompletion".equals(str)) {
                ScreenVideoAdListener screenVideoAdListener7 = AbstractScreenVideoAd.this.mAdListener;
                if (screenVideoAdListener7 != null) {
                    screenVideoAdListener7.playCompletion();
                }
            } else {
                "AdRvdieoPlayError".equals(str);
            }
        }

        public abstract void handleCustomEvent(String str, HashMap<String, Object> hashMap);

        @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            String type = iOAdEvent.getType();
            HashMap<String, Object> hashMap = (HashMap) iOAdEvent.getData();
            a(type, hashMap);
            handleCustomEvent(type, hashMap);
        }
    }

    public AbstractScreenVideoAd(Activity activity, ScreenVideoAdListener screenVideoAdListener) {
        this.mContext = activity;
        XAdSDKFoundationFacade.getInstance().initializeApplicationContext(this.mContext.getApplicationContext());
        q.a(this.mContext).a();
        this.mAdListener = screenVideoAdListener;
    }

    private void a(IXAdConstants4PDK.ActivityState activityState) {
        this.f8509a = activityState;
        a aVar = this.mAdProd;
        if (aVar != null) {
            if (activityState == IXAdConstants4PDK.ActivityState.PAUSE) {
                aVar.pause();
            }
            if (activityState == IXAdConstants4PDK.ActivityState.RESUME) {
                this.mAdProd.resume();
            }
        }
    }

    public static void setAppSid(String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    public boolean isReady() {
        a aVar = this.mAdProd;
        return aVar != null && aVar.s() && !this.mAdProd.a() && this.mAdProd.b();
    }

    public synchronized void load() {
        if (MobRewardVideoImpl.mVideoPlaying) {
            return;
        }
        if (this.mAdProd != null) {
            this.mAdProd.c(false);
        }
        makeRequest();
    }

    public void makeRequest() {
        this.mAdProd.removeAllListeners();
        ScreenVideoIOAdEventListener registerIOAdEventListener = registerIOAdEventListener();
        this.mAdProd.addEventListener("AdUserClick", registerIOAdEventListener);
        this.mAdProd.addEventListener(IXAdEvent.AD_LOADED, registerIOAdEventListener);
        this.mAdProd.addEventListener(IXAdEvent.AD_STARTED, registerIOAdEventListener);
        this.mAdProd.addEventListener(IXAdEvent.AD_STOPPED, registerIOAdEventListener);
        this.mAdProd.addEventListener(IXAdEvent.AD_ERROR, registerIOAdEventListener);
        this.mAdProd.addEventListener("AdRvdieoCacheSucc", registerIOAdEventListener);
        this.mAdProd.addEventListener("AdRvdieoCacheFailed", registerIOAdEventListener);
        this.mAdProd.addEventListener("PlayCompletion", registerIOAdEventListener);
        this.mAdProd.addEventListener("AdRvdieoPlayError", registerIOAdEventListener);
        this.mAdProd.request();
    }

    public void pause() {
        a(IXAdConstants4PDK.ActivityState.PAUSE);
    }

    public abstract ScreenVideoIOAdEventListener registerIOAdEventListener();

    public void resume() {
        a(IXAdConstants4PDK.ActivityState.RESUME);
    }

    public synchronized void show() {
        if (this.mAdProd != null) {
            if (MobRewardVideoImpl.mVideoPlaying) {
                return;
            }
            if (this.mAdProd.getCurrentXAdContainer() != null && this.mAdProd.t() && !this.mAdProd.a() && this.mAdProd.s()) {
                MobRewardVideoImpl.mVideoPlaying = true;
                this.mAdProd.u();
            } else {
                makeRequest();
                this.mAdProd.c(true);
            }
        }
    }

    public AbstractScreenVideoAd(Context context, ScreenVideoAdListener screenVideoAdListener) {
        this.mContext = context;
        XAdSDKFoundationFacade.getInstance().initializeApplicationContext(this.mContext.getApplicationContext());
        q.a(this.mContext).a();
        this.mAdListener = screenVideoAdListener;
    }
}
