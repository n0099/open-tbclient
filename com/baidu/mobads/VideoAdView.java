package com.baidu.mobads;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes14.dex */
public class VideoAdView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.mobads.production.h.b f3291a;

    /* renamed from: b  reason: collision with root package name */
    private IOAdEventListener f3292b;
    private VideoAdViewListener c;

    public VideoAdView(Context context) {
        super(context);
        this.f3292b = new v(this);
    }

    public VideoAdView(Context context, String str) {
        super(context, null);
        this.f3292b = new v(this);
    }

    /* loaded from: classes14.dex */
    public enum VideoDuration {
        DURATION_15_SECONDS(15),
        DURATION_30_SECONDS(30),
        DURATION_45_SECONDS(45);
        

        /* renamed from: a  reason: collision with root package name */
        private int f3294a;

        VideoDuration(int i) {
            this.f3294a = i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public int getValue() {
            return this.f3294a;
        }
    }

    /* loaded from: classes14.dex */
    public enum VideoSize {
        SIZE_16x9(320, 180),
        SIZE_4x3(400, 300);
        

        /* renamed from: a  reason: collision with root package name */
        private int f3295a;

        /* renamed from: b  reason: collision with root package name */
        private int f3296b;

        VideoSize(int i, int i2) {
            this.f3295a = i;
            this.f3296b = i2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public int getWidth() {
            return this.f3295a;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public int getHeight() {
            return this.f3296b;
        }
    }

    public void requestAd(VideoAdRequest videoAdRequest) {
        this.f3291a = new com.baidu.mobads.production.h.b(getContext(), "TODO");
        this.f3291a.setActivity(getContext());
        this.f3291a.setAdSlotBase(this);
        this.f3291a.addEventListener(IXAdEvent.AD_CLICK_THRU, this.f3292b);
        this.f3291a.addEventListener(IXAdEvent.AD_LOADED, this.f3292b);
        this.f3291a.addEventListener(IXAdEvent.AD_STARTED, this.f3292b);
        this.f3291a.addEventListener(IXAdEvent.AD_STOPPED, this.f3292b);
        this.f3291a.addEventListener(IXAdEvent.AD_ERROR, this.f3292b);
        this.f3291a.request();
    }

    public void startVideo() {
        this.f3291a.start();
    }

    public static void setAppSid(Context context, String str) {
        AdView.setAppSid(context, str);
    }

    public void setListener(VideoAdViewListener videoAdViewListener) {
        this.c = videoAdViewListener;
    }
}
