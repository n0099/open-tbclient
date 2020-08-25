package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes20.dex */
public class BaiduNativeH5AdView extends RelativeLayout {
    IOAdEventListener bCX;
    private BaiduNativeAdPlacement bDh;
    private com.baidu.mobads.production.c.a bDi;
    private BaiduNativeH5EventListner bDj;
    private RequestParameters bDk;
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
        this.bDj = null;
        this.f = false;
        this.g = false;
        this.bCX = new h(this);
        a(context, i);
    }

    public BaiduNativeAdPlacement getAdPlacement() {
        return this.bDh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAdPlacement(BaiduNativeAdPlacement baiduNativeAdPlacement) {
        this.bDh = baiduNativeAdPlacement;
    }

    public void makeRequest(RequestParameters requestParameters) {
        if (this.bDh != null) {
            if (this.bDh.hasValidResponse()) {
                if (this.f) {
                    return;
                }
            } else {
                this.f = false;
                if (!this.bDh.Tn()) {
                    this.bDh.db(true);
                } else {
                    return;
                }
            }
        }
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        this.bDk = requestParameters;
        if (this.bDi != null) {
            b();
        }
        this.bDi = new com.baidu.mobads.production.c.a(getContext(), this);
        this.bDi.a(requestParameters);
        this.bDi.addEventListener(IXAdEvent.AD_ERROR, this.bCX);
        this.bDi.addEventListener(IXAdEvent.AD_STARTED, this.bCX);
        this.bDi.addEventListener("AdUserClick", this.bCX);
        this.bDi.addEventListener(IXAdEvent.AD_IMPRESSION, this.bCX);
        this.bDi.addEventListener("AdLoadData", this.bCX);
        if (this.bDh != null && this.bDh.Tp() != null) {
            this.bDi.setAdResponseInfo(this.bDh.Tp());
        }
        this.bDi.b(this.bDh.Ts());
        this.bDi.c(this.bDh.Tt());
        this.bDi.d(this.bDh.getSequenceId());
        this.bDi.request();
    }

    public void recordImpression() {
        if (this.bDh != null && this.bDh.Tp() != null && !this.bDh.Tr()) {
            this.bDi.a(this, this.bDh.Tp().getPrimaryAdInstanceInfo(), this.bDk);
        }
    }

    private void a() {
        if (this.bDi != null) {
            this.bDi.q();
        }
    }

    private void b() {
        a();
        if (this.bDi != null) {
            this.bDi.p();
        }
    }

    public void setEventListener(BaiduNativeH5EventListner baiduNativeH5EventListner) {
        this.bDj = baiduNativeH5EventListner;
    }
}
