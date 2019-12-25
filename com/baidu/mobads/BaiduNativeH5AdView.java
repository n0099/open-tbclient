package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes7.dex */
public class BaiduNativeH5AdView extends RelativeLayout {
    IOAdEventListener aJC;
    private BaiduNativeAdPlacement aJM;
    private com.baidu.mobads.production.c.a aJN;
    private BaiduNativeH5EventListner aJO;
    private RequestParameters aJP;
    private boolean f;
    private boolean g;

    /* loaded from: classes7.dex */
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
        this.aJO = null;
        this.f = false;
        this.g = false;
        this.aJC = new h(this);
        a(context, i);
    }

    public BaiduNativeAdPlacement getAdPlacement() {
        return this.aJM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAdPlacement(BaiduNativeAdPlacement baiduNativeAdPlacement) {
        this.aJM = baiduNativeAdPlacement;
    }

    public void makeRequest(RequestParameters requestParameters) {
        if (this.aJM != null) {
            if (this.aJM.hasValidResponse()) {
                if (this.f) {
                    return;
                }
            } else {
                this.f = false;
                if (!this.aJM.Br()) {
                    this.aJM.bx(true);
                } else {
                    return;
                }
            }
        }
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        this.aJP = requestParameters;
        if (this.aJN != null) {
            b();
        }
        this.aJN = new com.baidu.mobads.production.c.a(getContext(), this);
        this.aJN.a(requestParameters);
        this.aJN.addEventListener(IXAdEvent.AD_ERROR, this.aJC);
        this.aJN.addEventListener(IXAdEvent.AD_STARTED, this.aJC);
        this.aJN.addEventListener("AdUserClick", this.aJC);
        this.aJN.addEventListener(IXAdEvent.AD_IMPRESSION, this.aJC);
        this.aJN.addEventListener("AdLoadData", this.aJC);
        if (this.aJM != null && this.aJM.Bt() != null) {
            this.aJN.setAdResponseInfo(this.aJM.Bt());
        }
        this.aJN.b(this.aJM.Bw());
        this.aJN.c(this.aJM.Bx());
        this.aJN.d(this.aJM.getSequenceId());
        this.aJN.request();
    }

    public void recordImpression() {
        if (this.aJM != null && this.aJM.Bt() != null && !this.aJM.Bv()) {
            this.aJN.a(this, this.aJM.Bt().getPrimaryAdInstanceInfo(), this.aJP);
        }
    }

    private void a() {
        if (this.aJN != null) {
            this.aJN.q();
        }
    }

    private void b() {
        a();
        if (this.aJN != null) {
            this.aJN.p();
        }
    }

    public void setEventListener(BaiduNativeH5EventListner baiduNativeH5EventListner) {
        this.aJO = baiduNativeH5EventListner;
    }
}
