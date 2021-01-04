package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes3.dex */
public class BaiduNativeH5AdView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    IOAdEventListener f3314a;

    /* renamed from: b  reason: collision with root package name */
    private BaiduNativeAdPlacement f3315b;
    private com.baidu.mobads.production.c.a c;
    private BaiduNativeH5EventListner d;
    private RequestParameters e;
    private boolean f;
    private boolean g;

    /* loaded from: classes3.dex */
    public interface BaiduNativeH5EventListner {
        void onAdClick();

        void onAdDataLoaded();

        void onAdFail(String str);

        void onAdShow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isAdDataLoaded() {
        return this.g;
    }

    @SuppressLint({"NewApi"})
    private void a(Context context, int i) {
        if (i != 0) {
            setBackgroundResource(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaiduNativeH5AdView(Context context, int i) {
        super(context);
        this.d = null;
        this.f = false;
        this.g = false;
        this.f3314a = new h(this);
        a(context, i);
    }

    protected BaiduNativeH5AdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = null;
        this.f = false;
        this.g = false;
        this.f3314a = new h(this);
        a(context, 0);
    }

    protected BaiduNativeH5AdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = null;
        this.f = false;
        this.g = false;
        this.f3314a = new h(this);
        a(context, 0);
    }

    public BaiduNativeAdPlacement getAdPlacement() {
        return this.f3315b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAdPlacement(BaiduNativeAdPlacement baiduNativeAdPlacement) {
        this.f3315b = baiduNativeAdPlacement;
    }

    public void makeRequest(RequestParameters requestParameters) {
        if (this.f3315b != null) {
            if (this.f3315b.hasValidResponse()) {
                if (this.f) {
                    return;
                }
            } else {
                this.f = false;
                if (!this.f3315b.getRequestStarted()) {
                    this.f3315b.setRequestStarted(true);
                } else {
                    return;
                }
            }
        }
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        this.e = requestParameters;
        if (this.c != null) {
            b();
        }
        this.c = new com.baidu.mobads.production.c.a(getContext(), this);
        this.c.a(requestParameters);
        this.c.addEventListener(IXAdEvent.AD_ERROR, this.f3314a);
        this.c.addEventListener(IXAdEvent.AD_STARTED, this.f3314a);
        this.c.addEventListener("AdUserClick", this.f3314a);
        this.c.addEventListener(IXAdEvent.AD_IMPRESSION, this.f3314a);
        this.c.addEventListener("AdLoadData", this.f3314a);
        if (this.f3315b != null && this.f3315b.getAdResponse() != null) {
            this.c.setAdResponseInfo(this.f3315b.getAdResponse());
        }
        this.c.b(this.f3315b.getSessionId());
        this.c.c(this.f3315b.getPosistionId());
        this.c.d(this.f3315b.getSequenceId());
        this.c.request();
    }

    public void recordImpression() {
        if (this.f3315b != null && this.f3315b.getAdResponse() != null && !this.f3315b.isWinSended()) {
            this.c.a(this, this.f3315b.getAdResponse().getPrimaryAdInstanceInfo(), this.e);
        }
    }

    private void a() {
        if (this.c != null) {
            this.c.q();
        }
    }

    private void b() {
        a();
        if (this.c != null) {
            this.c.p();
        }
    }

    public void setEventListener(BaiduNativeH5EventListner baiduNativeH5EventListner) {
        this.d = baiduNativeH5EventListner;
    }
}
