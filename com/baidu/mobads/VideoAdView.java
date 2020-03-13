package com.baidu.mobads;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes10.dex */
public class VideoAdView extends RelativeLayout {
    private com.baidu.mobads.production.h.b aOX;
    private IOAdEventListener aOY;
    private VideoAdViewListener aOZ;

    public VideoAdView(Context context) {
        super(context);
        this.aOY = new v(this);
    }

    public VideoAdView(Context context, String str) {
        super(context, null);
        this.aOY = new v(this);
    }

    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
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
        this.aOX = new com.baidu.mobads.production.h.b(getContext(), "TODO");
        this.aOX.setActivity(getContext());
        this.aOX.setAdSlotBase(this);
        this.aOX.addEventListener(IXAdEvent.AD_CLICK_THRU, this.aOY);
        this.aOX.addEventListener(IXAdEvent.AD_LOADED, this.aOY);
        this.aOX.addEventListener(IXAdEvent.AD_STARTED, this.aOY);
        this.aOX.addEventListener(IXAdEvent.AD_STOPPED, this.aOY);
        this.aOX.addEventListener(IXAdEvent.AD_ERROR, this.aOY);
        this.aOX.request();
    }

    public void startVideo() {
        this.aOX.start();
    }

    public static void setAppSid(Context context, String str) {
        AdView.setAppSid(context, str);
    }

    public void setListener(VideoAdViewListener videoAdViewListener) {
        this.aOZ = videoAdViewListener;
    }
}
