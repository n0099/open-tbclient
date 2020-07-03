package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes10.dex */
public class BaiduNativeH5AdView extends RelativeLayout {
    IOAdEventListener bxa;
    private BaiduNativeAdPlacement bxk;
    private com.baidu.mobads.production.c.a bxl;
    private BaiduNativeH5EventListner bxm;
    private RequestParameters bxn;
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
        this.bxm = null;
        this.f = false;
        this.g = false;
        this.bxa = new h(this);
        a(context, i);
    }

    public BaiduNativeAdPlacement getAdPlacement() {
        return this.bxk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAdPlacement(BaiduNativeAdPlacement baiduNativeAdPlacement) {
        this.bxk = baiduNativeAdPlacement;
    }

    public void makeRequest(RequestParameters requestParameters) {
        if (this.bxk != null) {
            if (this.bxk.hasValidResponse()) {
                if (this.f) {
                    return;
                }
            } else {
                this.f = false;
                if (!this.bxk.No()) {
                    this.bxk.cR(true);
                } else {
                    return;
                }
            }
        }
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        this.bxn = requestParameters;
        if (this.bxl != null) {
            b();
        }
        this.bxl = new com.baidu.mobads.production.c.a(getContext(), this);
        this.bxl.a(requestParameters);
        this.bxl.addEventListener(IXAdEvent.AD_ERROR, this.bxa);
        this.bxl.addEventListener(IXAdEvent.AD_STARTED, this.bxa);
        this.bxl.addEventListener("AdUserClick", this.bxa);
        this.bxl.addEventListener(IXAdEvent.AD_IMPRESSION, this.bxa);
        this.bxl.addEventListener("AdLoadData", this.bxa);
        if (this.bxk != null && this.bxk.Nq() != null) {
            this.bxl.setAdResponseInfo(this.bxk.Nq());
        }
        this.bxl.b(this.bxk.Nt());
        this.bxl.c(this.bxk.Nu());
        this.bxl.d(this.bxk.getSequenceId());
        this.bxl.request();
    }

    public void recordImpression() {
        if (this.bxk != null && this.bxk.Nq() != null && !this.bxk.Ns()) {
            this.bxl.a(this, this.bxk.Nq().getPrimaryAdInstanceInfo(), this.bxn);
        }
    }

    private void a() {
        if (this.bxl != null) {
            this.bxl.q();
        }
    }

    private void b() {
        a();
        if (this.bxl != null) {
            this.bxl.p();
        }
    }

    public void setEventListener(BaiduNativeH5EventListner baiduNativeH5EventListner) {
        this.bxm = baiduNativeH5EventListner;
    }
}
