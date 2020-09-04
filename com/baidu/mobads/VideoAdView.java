package com.baidu.mobads;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes20.dex */
public class VideoAdView extends RelativeLayout {
    private com.baidu.mobads.production.h.b bDx;
    private IOAdEventListener bDy;
    private VideoAdViewListener bDz;

    public VideoAdView(Context context) {
        super(context);
        this.bDy = new v(this);
    }

    public VideoAdView(Context context, String str) {
        super(context, null);
        this.bDy = new v(this);
    }

    /* loaded from: classes20.dex */
    public enum VideoDuration {
        DURATION_15_SECONDS(15),
        DURATION_30_SECONDS(30),
        DURATION_45_SECONDS(45);
        
        private int a;

        VideoDuration(int i) {
            this.a = i;
        }

        protected int getValue() {
            return this.a;
        }
    }

    /* loaded from: classes20.dex */
    public enum VideoSize {
        SIZE_16x9(320, 180),
        SIZE_4x3(400, 300);
        
        private int a;
        private int b;

        VideoSize(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        protected int getWidth() {
            return this.a;
        }

        protected int getHeight() {
            return this.b;
        }
    }

    public void requestAd(VideoAdRequest videoAdRequest) {
        this.bDx = new com.baidu.mobads.production.h.b(getContext(), "TODO");
        this.bDx.setActivity(getContext());
        this.bDx.setAdSlotBase(this);
        this.bDx.addEventListener(IXAdEvent.AD_CLICK_THRU, this.bDy);
        this.bDx.addEventListener(IXAdEvent.AD_LOADED, this.bDy);
        this.bDx.addEventListener(IXAdEvent.AD_STARTED, this.bDy);
        this.bDx.addEventListener(IXAdEvent.AD_STOPPED, this.bDy);
        this.bDx.addEventListener(IXAdEvent.AD_ERROR, this.bDy);
        this.bDx.request();
    }

    public void startVideo() {
        this.bDx.start();
    }

    public static void setAppSid(Context context, String str) {
        AdView.setAppSid(context, str);
    }

    public void setListener(VideoAdViewListener videoAdViewListener) {
        this.bDz = videoAdViewListener;
    }
}
