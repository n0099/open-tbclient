package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes20.dex */
public class BaiduNativeH5AdView extends RelativeLayout {
    private com.baidu.mobads.production.c.a bxA;
    private BaiduNativeH5EventListner bxB;
    private RequestParameters bxC;
    IOAdEventListener bxp;
    private BaiduNativeAdPlacement bxz;
    private boolean f;
    private boolean g;

    /* loaded from: classes20.dex */
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
        this.bxB = null;
        this.f = false;
        this.g = false;
        this.bxp = new h(this);
        a(context, i);
    }

    public BaiduNativeAdPlacement getAdPlacement() {
        return this.bxz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAdPlacement(BaiduNativeAdPlacement baiduNativeAdPlacement) {
        this.bxz = baiduNativeAdPlacement;
    }

    public void makeRequest(RequestParameters requestParameters) {
        if (this.bxz != null) {
            if (this.bxz.hasValidResponse()) {
                if (this.f) {
                    return;
                }
            } else {
                this.f = false;
                if (!this.bxz.Nt()) {
                    this.bxz.cT(true);
                } else {
                    return;
                }
            }
        }
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        this.bxC = requestParameters;
        if (this.bxA != null) {
            b();
        }
        this.bxA = new com.baidu.mobads.production.c.a(getContext(), this);
        this.bxA.a(requestParameters);
        this.bxA.addEventListener(IXAdEvent.AD_ERROR, this.bxp);
        this.bxA.addEventListener(IXAdEvent.AD_STARTED, this.bxp);
        this.bxA.addEventListener("AdUserClick", this.bxp);
        this.bxA.addEventListener(IXAdEvent.AD_IMPRESSION, this.bxp);
        this.bxA.addEventListener("AdLoadData", this.bxp);
        if (this.bxz != null && this.bxz.Nv() != null) {
            this.bxA.setAdResponseInfo(this.bxz.Nv());
        }
        this.bxA.b(this.bxz.Ny());
        this.bxA.c(this.bxz.Nz());
        this.bxA.d(this.bxz.getSequenceId());
        this.bxA.request();
    }

    public void recordImpression() {
        if (this.bxz != null && this.bxz.Nv() != null && !this.bxz.Nx()) {
            this.bxA.a(this, this.bxz.Nv().getPrimaryAdInstanceInfo(), this.bxC);
        }
    }

    private void a() {
        if (this.bxA != null) {
            this.bxA.q();
        }
    }

    private void b() {
        a();
        if (this.bxA != null) {
            this.bxA.p();
        }
    }

    public void setEventListener(BaiduNativeH5EventListner baiduNativeH5EventListner) {
        this.bxB = baiduNativeH5EventListner;
    }
}
