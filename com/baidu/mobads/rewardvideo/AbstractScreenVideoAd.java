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
/* loaded from: classes5.dex */
public abstract class AbstractScreenVideoAd {

    /* renamed from: a  reason: collision with root package name */
    private IXAdConstants4PDK.ActivityState f3476a = IXAdConstants4PDK.ActivityState.CREATE;
    protected ScreenVideoAdListener mAdListener;
    protected a mAdProd;
    protected final Context mContext;

    /* loaded from: classes5.dex */
    public interface ScreenVideoAdListener {
        void onAdClick();

        void onAdClose(float f);

        void onAdFailed(String str);

        void onAdShow();

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();

        void playCompletion();
    }

    protected abstract ScreenVideoIOAdEventListener registerIOAdEventListener();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractScreenVideoAd(Activity activity, ScreenVideoAdListener screenVideoAdListener) {
        this.mContext = activity;
        XAdSDKFoundationFacade.getInstance().initializeApplicationContext(this.mContext.getApplicationContext());
        q.a(this.mContext).a();
        this.mAdListener = screenVideoAdListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractScreenVideoAd(Context context, ScreenVideoAdListener screenVideoAdListener) {
        this.mContext = context;
        XAdSDKFoundationFacade.getInstance().initializeApplicationContext(this.mContext.getApplicationContext());
        q.a(this.mContext).a();
        this.mAdListener = screenVideoAdListener;
    }

    public synchronized void load() {
        if (!MobRewardVideoImpl.mVideoPlaying) {
            if (this.mAdProd != null) {
                this.mAdProd.c(false);
            }
            makeRequest();
        }
    }

    public synchronized void show() {
        if (this.mAdProd != null && !MobRewardVideoImpl.mVideoPlaying) {
            if (this.mAdProd.getCurrentXAdContainer() != null && this.mAdProd.t() && !this.mAdProd.a() && this.mAdProd.s()) {
                MobRewardVideoImpl.mVideoPlaying = true;
                this.mAdProd.u();
            } else {
                makeRequest();
                this.mAdProd.c(true);
            }
        }
    }

    public void pause() {
        a(IXAdConstants4PDK.ActivityState.PAUSE);
    }

    public void resume() {
        a(IXAdConstants4PDK.ActivityState.RESUME);
    }

    public boolean isReady() {
        return this.mAdProd != null && this.mAdProd.s() && !this.mAdProd.a() && this.mAdProd.b();
    }

    public static void setAppSid(String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    protected void makeRequest() {
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

    private void a(IXAdConstants4PDK.ActivityState activityState) {
        this.f3476a = activityState;
        if (this.mAdProd != null) {
            if (activityState == IXAdConstants4PDK.ActivityState.PAUSE) {
                this.mAdProd.pause();
            }
            if (activityState == IXAdConstants4PDK.ActivityState.RESUME) {
                this.mAdProd.resume();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes5.dex */
    public abstract class ScreenVideoIOAdEventListener implements IOAdEventListener {
        protected abstract void handleCustomEvent(String str, HashMap<String, Object> hashMap);

        public ScreenVideoIOAdEventListener() {
        }

        @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            String type = iOAdEvent.getType();
            HashMap<String, Object> hashMap = (HashMap) iOAdEvent.getData();
            a(type, hashMap);
            handleCustomEvent(type, hashMap);
        }

        private void a(String str, HashMap<String, Object> hashMap) {
            if (!IXAdEvent.AD_LOADED.equals(str)) {
                if (IXAdEvent.AD_STARTED.equals(str)) {
                    if (AbstractScreenVideoAd.this.mAdListener != null) {
                        AbstractScreenVideoAd.this.mAdListener.onAdShow();
                    }
                } else if ("AdUserClick".equals(str)) {
                    if (AbstractScreenVideoAd.this.mAdListener != null) {
                        AbstractScreenVideoAd.this.mAdListener.onAdClick();
                    }
                } else if (IXAdEvent.AD_STOPPED.equals(str)) {
                    MobRewardVideoImpl.mVideoPlaying = false;
                    String str2 = "0";
                    if (hashMap != null) {
                        str2 = hashMap.get("play_scale").toString();
                    }
                    if (AbstractScreenVideoAd.this.mAdListener != null) {
                        AbstractScreenVideoAd.this.mAdListener.onAdClose(Float.valueOf(str2).floatValue());
                    }
                } else if ("AdRvdieoCacheSucc".equals(str)) {
                    if (AbstractScreenVideoAd.this.mAdListener != null) {
                        AbstractScreenVideoAd.this.mAdListener.onVideoDownloadSuccess();
                    }
                } else if ("AdRvdieoCacheFailed".equals(str)) {
                    if (AbstractScreenVideoAd.this.mAdListener != null) {
                        AbstractScreenVideoAd.this.mAdListener.onVideoDownloadFailed();
                    }
                } else if (IXAdEvent.AD_ERROR.equals(str)) {
                    if (AbstractScreenVideoAd.this.mAdListener != null) {
                        AbstractScreenVideoAd.this.mAdListener.onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(hashMap));
                    }
                } else if ("PlayCompletion".equals(str)) {
                    if (AbstractScreenVideoAd.this.mAdListener != null) {
                        AbstractScreenVideoAd.this.mAdListener.playCompletion();
                    }
                } else {
                    if ("AdRvdieoPlayError".equals(str)) {
                    }
                }
            }
        }
    }
}
