package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes20.dex */
public class BaiduNativeH5AdView extends RelativeLayout {
    IOAdEventListener bDa;
    private BaiduNativeAdPlacement bDk;
    private com.baidu.mobads.production.c.a bDl;
    private BaiduNativeH5EventListner bDm;
    private RequestParameters bDn;
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
        this.bDm = null;
        this.f = false;
        this.g = false;
        this.bDa = new h(this);
        a(context, i);
    }

    public BaiduNativeAdPlacement getAdPlacement() {
        return this.bDk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAdPlacement(BaiduNativeAdPlacement baiduNativeAdPlacement) {
        this.bDk = baiduNativeAdPlacement;
    }

    public void makeRequest(RequestParameters requestParameters) {
        if (this.bDk != null) {
            if (this.bDk.hasValidResponse()) {
                if (this.f) {
                    return;
                }
            } else {
                this.f = false;
                if (!this.bDk.Tn()) {
                    this.bDk.dc(true);
                } else {
                    return;
                }
            }
        }
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        this.bDn = requestParameters;
        if (this.bDl != null) {
            b();
        }
        this.bDl = new com.baidu.mobads.production.c.a(getContext(), this);
        this.bDl.a(requestParameters);
        this.bDl.addEventListener(IXAdEvent.AD_ERROR, this.bDa);
        this.bDl.addEventListener(IXAdEvent.AD_STARTED, this.bDa);
        this.bDl.addEventListener("AdUserClick", this.bDa);
        this.bDl.addEventListener(IXAdEvent.AD_IMPRESSION, this.bDa);
        this.bDl.addEventListener("AdLoadData", this.bDa);
        if (this.bDk != null && this.bDk.Tp() != null) {
            this.bDl.setAdResponseInfo(this.bDk.Tp());
        }
        this.bDl.b(this.bDk.Ts());
        this.bDl.c(this.bDk.Tt());
        this.bDl.d(this.bDk.getSequenceId());
        this.bDl.request();
    }

    public void recordImpression() {
        if (this.bDk != null && this.bDk.Tp() != null && !this.bDk.Tr()) {
            this.bDl.a(this, this.bDk.Tp().getPrimaryAdInstanceInfo(), this.bDn);
        }
    }

    private void a() {
        if (this.bDl != null) {
            this.bDl.q();
        }
    }

    private void b() {
        a();
        if (this.bDl != null) {
            this.bDl.p();
        }
    }

    public void setEventListener(BaiduNativeH5EventListner baiduNativeH5EventListner) {
        this.bDm = baiduNativeH5EventListner;
    }
}
