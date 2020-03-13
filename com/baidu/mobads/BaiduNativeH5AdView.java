package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes10.dex */
public class BaiduNativeH5AdView extends RelativeLayout {
    IOAdEventListener aOA;
    private BaiduNativeAdPlacement aOK;
    private com.baidu.mobads.production.c.a aOL;
    private BaiduNativeH5EventListner aOM;
    private RequestParameters aON;
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
        this.aOM = null;
        this.f = false;
        this.g = false;
        this.aOA = new h(this);
        a(context, i);
    }

    public BaiduNativeAdPlacement getAdPlacement() {
        return this.aOK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAdPlacement(BaiduNativeAdPlacement baiduNativeAdPlacement) {
        this.aOK = baiduNativeAdPlacement;
    }

    public void makeRequest(RequestParameters requestParameters) {
        if (this.aOK != null) {
            if (this.aOK.hasValidResponse()) {
                if (this.f) {
                    return;
                }
            } else {
                this.f = false;
                if (!this.aOK.Ef()) {
                    this.aOK.bK(true);
                } else {
                    return;
                }
            }
        }
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        this.aON = requestParameters;
        if (this.aOL != null) {
            b();
        }
        this.aOL = new com.baidu.mobads.production.c.a(getContext(), this);
        this.aOL.a(requestParameters);
        this.aOL.addEventListener(IXAdEvent.AD_ERROR, this.aOA);
        this.aOL.addEventListener(IXAdEvent.AD_STARTED, this.aOA);
        this.aOL.addEventListener("AdUserClick", this.aOA);
        this.aOL.addEventListener(IXAdEvent.AD_IMPRESSION, this.aOA);
        this.aOL.addEventListener("AdLoadData", this.aOA);
        if (this.aOK != null && this.aOK.Eh() != null) {
            this.aOL.setAdResponseInfo(this.aOK.Eh());
        }
        this.aOL.b(this.aOK.Ek());
        this.aOL.c(this.aOK.El());
        this.aOL.d(this.aOK.getSequenceId());
        this.aOL.request();
    }

    public void recordImpression() {
        if (this.aOK != null && this.aOK.Eh() != null && !this.aOK.Ej()) {
            this.aOL.a(this, this.aOK.Eh().getPrimaryAdInstanceInfo(), this.aON);
        }
    }

    private void a() {
        if (this.aOL != null) {
            this.aOL.q();
        }
    }

    private void b() {
        a();
        if (this.aOL != null) {
            this.aOL.p();
        }
    }

    public void setEventListener(BaiduNativeH5EventListner baiduNativeH5EventListner) {
        this.aOM = baiduNativeH5EventListner;
    }
}
