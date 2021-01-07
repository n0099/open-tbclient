package com.baidu.mobads;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes3.dex */
public class VideoAdView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.mobads.production.h.b f3329a;

    /* renamed from: b  reason: collision with root package name */
    private IOAdEventListener f3330b;
    private VideoAdViewListener c;

    public VideoAdView(Context context) {
        super(context);
        this.f3330b = new v(this);
    }

    public VideoAdView(Context context, String str) {
        super(context, null);
        this.f3330b = new v(this);
    }

    /* loaded from: classes3.dex */
    public enum VideoDuration {
        DURATION_15_SECONDS(15),
        DURATION_30_SECONDS(30),
        DURATION_45_SECONDS(45);
        

        /* renamed from: a  reason: collision with root package name */
        private int f3332a;

        VideoDuration(int i) {
            this.f3332a = i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public int getValue() {
            return this.f3332a;
        }
    }

    /* loaded from: classes3.dex */
    public enum VideoSize {
        SIZE_16x9(320, 180),
        SIZE_4x3(400, 300);
        

        /* renamed from: a  reason: collision with root package name */
        private int f3333a;

        /* renamed from: b  reason: collision with root package name */
        private int f3334b;

        VideoSize(int i, int i2) {
            this.f3333a = i;
            this.f3334b = i2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public int getWidth() {
            return this.f3333a;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public int getHeight() {
            return this.f3334b;
        }
    }

    public void requestAd(VideoAdRequest videoAdRequest) {
        this.f3329a = new com.baidu.mobads.production.h.b(getContext(), "TODO");
        this.f3329a.setActivity(getContext());
        this.f3329a.setAdSlotBase(this);
        this.f3329a.addEventListener(IXAdEvent.AD_CLICK_THRU, this.f3330b);
        this.f3329a.addEventListener(IXAdEvent.AD_LOADED, this.f3330b);
        this.f3329a.addEventListener(IXAdEvent.AD_STARTED, this.f3330b);
        this.f3329a.addEventListener(IXAdEvent.AD_STOPPED, this.f3330b);
        this.f3329a.addEventListener(IXAdEvent.AD_ERROR, this.f3330b);
        this.f3329a.request();
    }

    public void startVideo() {
        this.f3329a.start();
    }

    public static void setAppSid(Context context, String str) {
        AdView.setAppSid(context, str);
    }

    public void setListener(VideoAdViewListener videoAdViewListener) {
        this.c = videoAdViewListener;
    }
}
