package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes10.dex */
public class BaiduNativeH5AdView extends RelativeLayout {
    private BaiduNativeAdPlacement aOI;
    private com.baidu.mobads.production.c.a aOJ;
    private BaiduNativeH5EventListner aOK;
    private RequestParameters aOL;
    IOAdEventListener aOy;
    private boolean f;
    private boolean g;

    /* loaded from: classes10.dex */
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
        this.aOK = null;
        this.f = false;
        this.g = false;
        this.aOy = new h(this);
        a(context, i);
    }

    public BaiduNativeAdPlacement getAdPlacement() {
        return this.aOI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAdPlacement(BaiduNativeAdPlacement baiduNativeAdPlacement) {
        this.aOI = baiduNativeAdPlacement;
    }

    public void makeRequest(RequestParameters requestParameters) {
        if (this.aOI != null) {
            if (this.aOI.hasValidResponse()) {
                if (this.f) {
                    return;
                }
            } else {
                this.f = false;
                if (!this.aOI.Ed()) {
                    this.aOI.bK(true);
                } else {
                    return;
                }
            }
        }
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        this.aOL = requestParameters;
        if (this.aOJ != null) {
            b();
        }
        this.aOJ = new com.baidu.mobads.production.c.a(getContext(), this);
        this.aOJ.a(requestParameters);
        this.aOJ.addEventListener(IXAdEvent.AD_ERROR, this.aOy);
        this.aOJ.addEventListener(IXAdEvent.AD_STARTED, this.aOy);
        this.aOJ.addEventListener("AdUserClick", this.aOy);
        this.aOJ.addEventListener(IXAdEvent.AD_IMPRESSION, this.aOy);
        this.aOJ.addEventListener("AdLoadData", this.aOy);
        if (this.aOI != null && this.aOI.Ef() != null) {
            this.aOJ.setAdResponseInfo(this.aOI.Ef());
        }
        this.aOJ.b(this.aOI.Ei());
        this.aOJ.c(this.aOI.Ej());
        this.aOJ.d(this.aOI.getSequenceId());
        this.aOJ.request();
    }

    public void recordImpression() {
        if (this.aOI != null && this.aOI.Ef() != null && !this.aOI.Eh()) {
            this.aOJ.a(this, this.aOI.Ef().getPrimaryAdInstanceInfo(), this.aOL);
        }
    }

    private void a() {
        if (this.aOJ != null) {
            this.aOJ.q();
        }
    }

    private void b() {
        a();
        if (this.aOJ != null) {
            this.aOJ.p();
        }
    }

    public void setEventListener(BaiduNativeH5EventListner baiduNativeH5EventListner) {
        this.aOK = baiduNativeH5EventListner;
    }
}
