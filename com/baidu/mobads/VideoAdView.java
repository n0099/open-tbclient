package com.baidu.mobads;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes10.dex */
public class VideoAdView extends RelativeLayout {
    private com.baidu.mobads.production.h.b blh;
    private IOAdEventListener bli;
    private VideoAdViewListener blj;

    public VideoAdView(Context context) {
        super(context);
        this.bli = new v(this);
    }

    public VideoAdView(Context context, String str) {
        super(context, null);
        this.bli = new v(this);
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
        this.blh = new com.baidu.mobads.production.h.b(getContext(), "TODO");
        this.blh.setActivity(getContext());
        this.blh.setAdSlotBase(this);
        this.blh.addEventListener(IXAdEvent.AD_CLICK_THRU, this.bli);
        this.blh.addEventListener(IXAdEvent.AD_LOADED, this.bli);
        this.blh.addEventListener(IXAdEvent.AD_STARTED, this.bli);
        this.blh.addEventListener(IXAdEvent.AD_STOPPED, this.bli);
        this.blh.addEventListener(IXAdEvent.AD_ERROR, this.bli);
        this.blh.request();
    }

    public void startVideo() {
        this.blh.start();
    }

    public static void setAppSid(Context context, String str) {
        AdView.setAppSid(context, str);
    }

    public void setListener(VideoAdViewListener videoAdViewListener) {
        this.blj = videoAdViewListener;
    }
}
