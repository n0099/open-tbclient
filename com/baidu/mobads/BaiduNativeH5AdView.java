package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes10.dex */
public class BaiduNativeH5AdView extends RelativeLayout {
    IOAdEventListener bkF;
    private BaiduNativeAdPlacement bkP;
    private com.baidu.mobads.production.c.a bkQ;
    private BaiduNativeH5EventListner bkR;
    private RequestParameters bkS;
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
        this.bkR = null;
        this.f = false;
        this.g = false;
        this.bkF = new h(this);
        a(context, i);
    }

    public BaiduNativeAdPlacement getAdPlacement() {
        return this.bkP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAdPlacement(BaiduNativeAdPlacement baiduNativeAdPlacement) {
        this.bkP = baiduNativeAdPlacement;
    }

    public void makeRequest(RequestParameters requestParameters) {
        if (this.bkP != null) {
            if (this.bkP.hasValidResponse()) {
                if (this.f) {
                    return;
                }
            } else {
                this.f = false;
                if (!this.bkP.Kn()) {
                    this.bkP.cA(true);
                } else {
                    return;
                }
            }
        }
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        this.bkS = requestParameters;
        if (this.bkQ != null) {
            b();
        }
        this.bkQ = new com.baidu.mobads.production.c.a(getContext(), this);
        this.bkQ.a(requestParameters);
        this.bkQ.addEventListener(IXAdEvent.AD_ERROR, this.bkF);
        this.bkQ.addEventListener(IXAdEvent.AD_STARTED, this.bkF);
        this.bkQ.addEventListener("AdUserClick", this.bkF);
        this.bkQ.addEventListener(IXAdEvent.AD_IMPRESSION, this.bkF);
        this.bkQ.addEventListener("AdLoadData", this.bkF);
        if (this.bkP != null && this.bkP.Kp() != null) {
            this.bkQ.setAdResponseInfo(this.bkP.Kp());
        }
        this.bkQ.b(this.bkP.Ks());
        this.bkQ.c(this.bkP.Kt());
        this.bkQ.d(this.bkP.getSequenceId());
        this.bkQ.request();
    }

    public void recordImpression() {
        if (this.bkP != null && this.bkP.Kp() != null && !this.bkP.Kr()) {
            this.bkQ.a(this, this.bkP.Kp().getPrimaryAdInstanceInfo(), this.bkS);
        }
    }

    private void a() {
        if (this.bkQ != null) {
            this.bkQ.q();
        }
    }

    private void b() {
        a();
        if (this.bkQ != null) {
            this.bkQ.p();
        }
    }

    public void setEventListener(BaiduNativeH5EventListner baiduNativeH5EventListner) {
        this.bkR = baiduNativeH5EventListner;
    }
}
