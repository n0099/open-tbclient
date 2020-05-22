package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes10.dex */
public class BaiduNativeH5AdView extends RelativeLayout {
    IOAdEventListener bsg;
    private BaiduNativeAdPlacement bsq;
    private com.baidu.mobads.production.c.a bsr;
    private BaiduNativeH5EventListner bss;
    private RequestParameters bst;
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
        this.bss = null;
        this.f = false;
        this.g = false;
        this.bsg = new h(this);
        a(context, i);
    }

    public BaiduNativeAdPlacement getAdPlacement() {
        return this.bsq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAdPlacement(BaiduNativeAdPlacement baiduNativeAdPlacement) {
        this.bsq = baiduNativeAdPlacement;
    }

    public void makeRequest(RequestParameters requestParameters) {
        if (this.bsq != null) {
            if (this.bsq.hasValidResponse()) {
                if (this.f) {
                    return;
                }
            } else {
                this.f = false;
                if (!this.bsq.Mf()) {
                    this.bsq.cM(true);
                } else {
                    return;
                }
            }
        }
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        this.bst = requestParameters;
        if (this.bsr != null) {
            b();
        }
        this.bsr = new com.baidu.mobads.production.c.a(getContext(), this);
        this.bsr.a(requestParameters);
        this.bsr.addEventListener(IXAdEvent.AD_ERROR, this.bsg);
        this.bsr.addEventListener(IXAdEvent.AD_STARTED, this.bsg);
        this.bsr.addEventListener("AdUserClick", this.bsg);
        this.bsr.addEventListener(IXAdEvent.AD_IMPRESSION, this.bsg);
        this.bsr.addEventListener("AdLoadData", this.bsg);
        if (this.bsq != null && this.bsq.Mh() != null) {
            this.bsr.setAdResponseInfo(this.bsq.Mh());
        }
        this.bsr.b(this.bsq.Mk());
        this.bsr.c(this.bsq.Ml());
        this.bsr.d(this.bsq.getSequenceId());
        this.bsr.request();
    }

    public void recordImpression() {
        if (this.bsq != null && this.bsq.Mh() != null && !this.bsq.Mj()) {
            this.bsr.a(this, this.bsq.Mh().getPrimaryAdInstanceInfo(), this.bst);
        }
    }

    private void a() {
        if (this.bsr != null) {
            this.bsr.q();
        }
    }

    private void b() {
        a();
        if (this.bsr != null) {
            this.bsr.p();
        }
    }

    public void setEventListener(BaiduNativeH5EventListner baiduNativeH5EventListner) {
        this.bss = baiduNativeH5EventListner;
    }
}
