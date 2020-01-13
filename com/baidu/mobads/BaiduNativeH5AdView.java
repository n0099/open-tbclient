package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes8.dex */
public class BaiduNativeH5AdView extends RelativeLayout {
    private BaiduNativeAdPlacement aKE;
    private com.baidu.mobads.production.c.a aKF;
    private BaiduNativeH5EventListner aKG;
    private RequestParameters aKH;
    IOAdEventListener aKu;
    private boolean f;
    private boolean g;

    /* loaded from: classes8.dex */
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
        this.aKG = null;
        this.f = false;
        this.g = false;
        this.aKu = new h(this);
        a(context, i);
    }

    public BaiduNativeAdPlacement getAdPlacement() {
        return this.aKE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAdPlacement(BaiduNativeAdPlacement baiduNativeAdPlacement) {
        this.aKE = baiduNativeAdPlacement;
    }

    public void makeRequest(RequestParameters requestParameters) {
        if (this.aKE != null) {
            if (this.aKE.hasValidResponse()) {
                if (this.f) {
                    return;
                }
            } else {
                this.f = false;
                if (!this.aKE.BN()) {
                    this.aKE.bC(true);
                } else {
                    return;
                }
            }
        }
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        this.aKH = requestParameters;
        if (this.aKF != null) {
            b();
        }
        this.aKF = new com.baidu.mobads.production.c.a(getContext(), this);
        this.aKF.a(requestParameters);
        this.aKF.addEventListener(IXAdEvent.AD_ERROR, this.aKu);
        this.aKF.addEventListener(IXAdEvent.AD_STARTED, this.aKu);
        this.aKF.addEventListener("AdUserClick", this.aKu);
        this.aKF.addEventListener(IXAdEvent.AD_IMPRESSION, this.aKu);
        this.aKF.addEventListener("AdLoadData", this.aKu);
        if (this.aKE != null && this.aKE.BP() != null) {
            this.aKF.setAdResponseInfo(this.aKE.BP());
        }
        this.aKF.b(this.aKE.BS());
        this.aKF.c(this.aKE.BT());
        this.aKF.d(this.aKE.getSequenceId());
        this.aKF.request();
    }

    public void recordImpression() {
        if (this.aKE != null && this.aKE.BP() != null && !this.aKE.BR()) {
            this.aKF.a(this, this.aKE.BP().getPrimaryAdInstanceInfo(), this.aKH);
        }
    }

    private void a() {
        if (this.aKF != null) {
            this.aKF.q();
        }
    }

    private void b() {
        a();
        if (this.aKF != null) {
            this.aKF.p();
        }
    }

    public void setEventListener(BaiduNativeH5EventListner baiduNativeH5EventListner) {
        this.aKG = baiduNativeH5EventListner;
    }
}
