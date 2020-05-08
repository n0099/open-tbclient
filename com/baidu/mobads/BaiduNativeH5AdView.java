package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes10.dex */
public class BaiduNativeH5AdView extends RelativeLayout {
    IOAdEventListener bkK;
    private BaiduNativeAdPlacement bkU;
    private com.baidu.mobads.production.c.a bkV;
    private BaiduNativeH5EventListner bkW;
    private RequestParameters bkX;
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
        this.bkW = null;
        this.f = false;
        this.g = false;
        this.bkK = new h(this);
        a(context, i);
    }

    public BaiduNativeAdPlacement getAdPlacement() {
        return this.bkU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAdPlacement(BaiduNativeAdPlacement baiduNativeAdPlacement) {
        this.bkU = baiduNativeAdPlacement;
    }

    public void makeRequest(RequestParameters requestParameters) {
        if (this.bkU != null) {
            if (this.bkU.hasValidResponse()) {
                if (this.f) {
                    return;
                }
            } else {
                this.f = false;
                if (!this.bkU.Km()) {
                    this.bkU.cA(true);
                } else {
                    return;
                }
            }
        }
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        this.bkX = requestParameters;
        if (this.bkV != null) {
            b();
        }
        this.bkV = new com.baidu.mobads.production.c.a(getContext(), this);
        this.bkV.a(requestParameters);
        this.bkV.addEventListener(IXAdEvent.AD_ERROR, this.bkK);
        this.bkV.addEventListener(IXAdEvent.AD_STARTED, this.bkK);
        this.bkV.addEventListener("AdUserClick", this.bkK);
        this.bkV.addEventListener(IXAdEvent.AD_IMPRESSION, this.bkK);
        this.bkV.addEventListener("AdLoadData", this.bkK);
        if (this.bkU != null && this.bkU.Ko() != null) {
            this.bkV.setAdResponseInfo(this.bkU.Ko());
        }
        this.bkV.b(this.bkU.Kr());
        this.bkV.c(this.bkU.Ks());
        this.bkV.d(this.bkU.getSequenceId());
        this.bkV.request();
    }

    public void recordImpression() {
        if (this.bkU != null && this.bkU.Ko() != null && !this.bkU.Kq()) {
            this.bkV.a(this, this.bkU.Ko().getPrimaryAdInstanceInfo(), this.bkX);
        }
    }

    private void a() {
        if (this.bkV != null) {
            this.bkV.q();
        }
    }

    private void b() {
        a();
        if (this.bkV != null) {
            this.bkV.p();
        }
    }

    public void setEventListener(BaiduNativeH5EventListner baiduNativeH5EventListner) {
        this.bkW = baiduNativeH5EventListner;
    }
}
