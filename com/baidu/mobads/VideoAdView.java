package com.baidu.mobads;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes7.dex */
public class VideoAdView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.mobads.production.h.b f2313a;
    private IOAdEventListener b;
    private VideoAdViewListener c;

    public VideoAdView(Context context) {
        super(context);
        this.b = new v(this);
    }

    public VideoAdView(Context context, String str) {
        super(context, null);
        this.b = new v(this);
    }

    /* loaded from: classes7.dex */
    public enum VideoDuration {
        DURATION_15_SECONDS(15),
        DURATION_30_SECONDS(30),
        DURATION_45_SECONDS(45);
        

        /* renamed from: a  reason: collision with root package name */
        private int f2314a;

        VideoDuration(int i) {
            this.f2314a = i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public int getValue() {
            return this.f2314a;
        }
    }

    /* loaded from: classes7.dex */
    public enum VideoSize {
        SIZE_16x9(320, 180),
        SIZE_4x3(400, 300);
        

        /* renamed from: a  reason: collision with root package name */
        private int f2315a;
        private int b;

        VideoSize(int i, int i2) {
            this.f2315a = i;
            this.b = i2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public int getWidth() {
            return this.f2315a;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public int getHeight() {
            return this.b;
        }
    }

    public void requestAd(VideoAdRequest videoAdRequest) {
        this.f2313a = new com.baidu.mobads.production.h.b(getContext(), "TODO");
        this.f2313a.setActivity(getContext());
        this.f2313a.setAdSlotBase(this);
        this.f2313a.addEventListener(IXAdEvent.AD_CLICK_THRU, this.b);
        this.f2313a.addEventListener(IXAdEvent.AD_LOADED, this.b);
        this.f2313a.addEventListener(IXAdEvent.AD_STARTED, this.b);
        this.f2313a.addEventListener(IXAdEvent.AD_STOPPED, this.b);
        this.f2313a.addEventListener(IXAdEvent.AD_ERROR, this.b);
        this.f2313a.request();
    }

    public void startVideo() {
        this.f2313a.start();
    }

    public static void setAppSid(Context context, String str) {
        AdView.setAppSid(context, str);
    }

    public void setListener(VideoAdViewListener videoAdViewListener) {
        this.c = videoAdViewListener;
    }
}
