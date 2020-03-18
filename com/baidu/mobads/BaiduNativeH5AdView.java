package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes10.dex */
public class BaiduNativeH5AdView extends RelativeLayout {
    IOAdEventListener aOO;
    private BaiduNativeAdPlacement aOY;
    private com.baidu.mobads.production.c.a aOZ;
    private BaiduNativeH5EventListner aPa;
    private RequestParameters aPb;
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
        this.aPa = null;
        this.f = false;
        this.g = false;
        this.aOO = new h(this);
        a(context, i);
    }

    public BaiduNativeAdPlacement getAdPlacement() {
        return this.aOY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAdPlacement(BaiduNativeAdPlacement baiduNativeAdPlacement) {
        this.aOY = baiduNativeAdPlacement;
    }

    public void makeRequest(RequestParameters requestParameters) {
        if (this.aOY != null) {
            if (this.aOY.hasValidResponse()) {
                if (this.f) {
                    return;
                }
            } else {
                this.f = false;
                if (!this.aOY.Em()) {
                    this.aOY.bL(true);
                } else {
                    return;
                }
            }
        }
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        this.aPb = requestParameters;
        if (this.aOZ != null) {
            b();
        }
        this.aOZ = new com.baidu.mobads.production.c.a(getContext(), this);
        this.aOZ.a(requestParameters);
        this.aOZ.addEventListener(IXAdEvent.AD_ERROR, this.aOO);
        this.aOZ.addEventListener(IXAdEvent.AD_STARTED, this.aOO);
        this.aOZ.addEventListener("AdUserClick", this.aOO);
        this.aOZ.addEventListener(IXAdEvent.AD_IMPRESSION, this.aOO);
        this.aOZ.addEventListener("AdLoadData", this.aOO);
        if (this.aOY != null && this.aOY.Eo() != null) {
            this.aOZ.setAdResponseInfo(this.aOY.Eo());
        }
        this.aOZ.b(this.aOY.Er());
        this.aOZ.c(this.aOY.Es());
        this.aOZ.d(this.aOY.getSequenceId());
        this.aOZ.request();
    }

    public void recordImpression() {
        if (this.aOY != null && this.aOY.Eo() != null && !this.aOY.Eq()) {
            this.aOZ.a(this, this.aOY.Eo().getPrimaryAdInstanceInfo(), this.aPb);
        }
    }

    private void a() {
        if (this.aOZ != null) {
            this.aOZ.q();
        }
    }

    private void b() {
        a();
        if (this.aOZ != null) {
            this.aOZ.p();
        }
    }

    public void setEventListener(BaiduNativeH5EventListner baiduNativeH5EventListner) {
        this.aPa = baiduNativeH5EventListner;
    }
}
