package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes2.dex */
public class BaiduNativeH5AdView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public IOAdEventListener f8128a;

    /* renamed from: b  reason: collision with root package name */
    public BaiduNativeAdPlacement f8129b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.mobads.production.b.c f8130c;

    /* renamed from: d  reason: collision with root package name */
    public BaiduNativeH5EventListner f8131d;

    /* renamed from: e  reason: collision with root package name */
    public RequestParameters f8132e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f8133f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f8134g;

    /* loaded from: classes2.dex */
    public interface BaiduNativeH5EventListner {
        void onAdClick();

        void onAdDataLoaded();

        void onAdFail(String str);

        void onAdShow();
    }

    public BaiduNativeH5AdView(Context context, int i) {
        super(context);
        this.f8131d = null;
        this.f8133f = false;
        this.f8134g = false;
        this.f8128a = new h(this);
        a(context, i);
    }

    public BaiduNativeAdPlacement getAdPlacement() {
        return this.f8129b;
    }

    public boolean isAdDataLoaded() {
        return this.f8134g;
    }

    public void makeRequest(RequestParameters requestParameters) {
        BaiduNativeAdPlacement baiduNativeAdPlacement = this.f8129b;
        if (baiduNativeAdPlacement != null) {
            if (baiduNativeAdPlacement.hasValidResponse()) {
                if (this.f8133f) {
                    return;
                }
            } else {
                this.f8133f = false;
                if (this.f8129b.getRequestStarted()) {
                    return;
                }
                this.f8129b.setRequestStarted(true);
            }
        }
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        this.f8132e = requestParameters;
        if (this.f8130c != null) {
            b();
        }
        com.baidu.mobads.production.b.c cVar = new com.baidu.mobads.production.b.c(getContext(), this);
        this.f8130c = cVar;
        cVar.a(requestParameters);
        this.f8130c.addEventListener(IXAdEvent.AD_ERROR, this.f8128a);
        this.f8130c.addEventListener(IXAdEvent.AD_STARTED, this.f8128a);
        this.f8130c.addEventListener("AdUserClick", this.f8128a);
        this.f8130c.addEventListener(IXAdEvent.AD_IMPRESSION, this.f8128a);
        this.f8130c.addEventListener("AdLoadData", this.f8128a);
        BaiduNativeAdPlacement baiduNativeAdPlacement2 = this.f8129b;
        if (baiduNativeAdPlacement2 != null && baiduNativeAdPlacement2.getAdResponse() != null) {
            this.f8130c.setAdResponseInfo(this.f8129b.getAdResponse());
        }
        this.f8130c.a(this.f8129b.getSessionId());
        this.f8130c.c(this.f8129b.getPosistionId());
        this.f8130c.d(this.f8129b.getSequenceId());
        this.f8130c.request();
    }

    public void recordImpression() {
        BaiduNativeAdPlacement baiduNativeAdPlacement = this.f8129b;
        if (baiduNativeAdPlacement == null || baiduNativeAdPlacement.getAdResponse() == null || this.f8129b.isWinSended()) {
            return;
        }
        this.f8130c.a(this, this.f8129b.getAdResponse().getPrimaryAdInstanceInfo(), this.f8132e);
    }

    public void setAdPlacement(BaiduNativeAdPlacement baiduNativeAdPlacement) {
        this.f8129b = baiduNativeAdPlacement;
    }

    public void setAdPlacementData(Object obj) {
        BaiduNativeAdPlacement baiduNativeAdPlacement = new BaiduNativeAdPlacement();
        baiduNativeAdPlacement.setApId((String) r.a(obj, "getApId", new Class[0], new Object[0]));
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId((String) r.a(obj, "getAppSid", new Class[0], new Object[0]));
        this.f8129b = baiduNativeAdPlacement;
    }

    public void setEventListener(BaiduNativeH5EventListner baiduNativeH5EventListner) {
        this.f8131d = baiduNativeH5EventListner;
    }

    @SuppressLint({"NewApi"})
    private void a(Context context, int i) {
        if (i != 0) {
            setBackgroundResource(i);
        }
    }

    private void b() {
        a();
        com.baidu.mobads.production.b.c cVar = this.f8130c;
        if (cVar != null) {
            cVar.p();
        }
    }

    private void a() {
        com.baidu.mobads.production.b.c cVar = this.f8130c;
        if (cVar != null) {
            cVar.a();
        }
    }

    public BaiduNativeH5AdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8131d = null;
        this.f8133f = false;
        this.f8134g = false;
        this.f8128a = new h(this);
        a(context, 0);
    }

    public BaiduNativeH5AdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8131d = null;
        this.f8133f = false;
        this.f8134g = false;
        this.f8128a = new h(this);
        a(context, 0);
    }
}
