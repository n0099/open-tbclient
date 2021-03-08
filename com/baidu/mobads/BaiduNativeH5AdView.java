package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes4.dex */
public class BaiduNativeH5AdView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    IOAdEventListener f2347a;
    private BaiduNativeAdPlacement b;
    private com.baidu.mobads.production.b.c c;
    private BaiduNativeH5EventListner d;
    private RequestParameters e;
    private boolean f;
    private boolean g;

    /* loaded from: classes4.dex */
    public interface BaiduNativeH5EventListner {
        void onAdClick();

        void onAdDataLoaded();

        void onAdFail(String str);

        void onAdShow();
    }

    public boolean isAdDataLoaded() {
        return this.g;
    }

    @SuppressLint({"NewApi"})
    private void a(Context context, int i) {
        if (i != 0) {
            setBackgroundResource(i);
        }
    }

    public BaiduNativeH5AdView(Context context, int i) {
        super(context);
        this.d = null;
        this.f = false;
        this.g = false;
        this.f2347a = new h(this);
        a(context, i);
    }

    public BaiduNativeH5AdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = null;
        this.f = false;
        this.g = false;
        this.f2347a = new h(this);
        a(context, 0);
    }

    public BaiduNativeH5AdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = null;
        this.f = false;
        this.g = false;
        this.f2347a = new h(this);
        a(context, 0);
    }

    public BaiduNativeAdPlacement getAdPlacement() {
        return this.b;
    }

    public void setAdPlacement(BaiduNativeAdPlacement baiduNativeAdPlacement) {
        this.b = baiduNativeAdPlacement;
    }

    public void makeRequest(RequestParameters requestParameters) {
        if (this.b != null) {
            if (this.b.hasValidResponse()) {
                if (this.f) {
                    return;
                }
            } else {
                this.f = false;
                if (!this.b.getRequestStarted()) {
                    this.b.setRequestStarted(true);
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
        this.c = new com.baidu.mobads.production.b.c(getContext(), this);
        this.c.a(requestParameters);
        this.c.addEventListener(IXAdEvent.AD_ERROR, this.f2347a);
        this.c.addEventListener(IXAdEvent.AD_STARTED, this.f2347a);
        this.c.addEventListener("AdUserClick", this.f2347a);
        this.c.addEventListener(IXAdEvent.AD_IMPRESSION, this.f2347a);
        this.c.addEventListener("AdLoadData", this.f2347a);
        if (this.b != null && this.b.getAdResponse() != null) {
            this.c.setAdResponseInfo(this.b.getAdResponse());
        }
        this.c.a(this.b.getSessionId());
        this.c.c(this.b.getPosistionId());
        this.c.d(this.b.getSequenceId());
        this.c.request();
    }

    public void recordImpression() {
        if (this.b != null && this.b.getAdResponse() != null && !this.b.isWinSended()) {
            this.c.a(this, this.b.getAdResponse().getPrimaryAdInstanceInfo(), this.e);
        }
    }

    private void a() {
        if (this.c != null) {
            this.c.a();
        }
    }

    private void b() {
        a();
        if (this.c != null) {
            this.c.p();
        }
    }

    public void setAdPlacementData(Object obj) {
        BaiduNativeAdPlacement baiduNativeAdPlacement = new BaiduNativeAdPlacement();
        baiduNativeAdPlacement.setApId((String) r.a(obj, "getApId", new Class[0], new Object[0]));
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId((String) r.a(obj, "getAppSid", new Class[0], new Object[0]));
        this.b = baiduNativeAdPlacement;
    }

    public void setEventListener(BaiduNativeH5EventListner baiduNativeH5EventListner) {
        this.d = baiduNativeH5EventListner;
    }
}
