package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes10.dex */
public class BaiduNativeH5AdView extends RelativeLayout {
    private BaiduNativeAdPlacement aOJ;
    private com.baidu.mobads.production.c.a aOK;
    private BaiduNativeH5EventListner aOL;
    private RequestParameters aOM;
    IOAdEventListener aOz;
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
        this.aOL = null;
        this.f = false;
        this.g = false;
        this.aOz = new h(this);
        a(context, i);
    }

    public BaiduNativeAdPlacement getAdPlacement() {
        return this.aOJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAdPlacement(BaiduNativeAdPlacement baiduNativeAdPlacement) {
        this.aOJ = baiduNativeAdPlacement;
    }

    public void makeRequest(RequestParameters requestParameters) {
        if (this.aOJ != null) {
            if (this.aOJ.hasValidResponse()) {
                if (this.f) {
                    return;
                }
            } else {
                this.f = false;
                if (!this.aOJ.Ef()) {
                    this.aOJ.bK(true);
                } else {
                    return;
                }
            }
        }
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        this.aOM = requestParameters;
        if (this.aOK != null) {
            b();
        }
        this.aOK = new com.baidu.mobads.production.c.a(getContext(), this);
        this.aOK.a(requestParameters);
        this.aOK.addEventListener(IXAdEvent.AD_ERROR, this.aOz);
        this.aOK.addEventListener(IXAdEvent.AD_STARTED, this.aOz);
        this.aOK.addEventListener("AdUserClick", this.aOz);
        this.aOK.addEventListener(IXAdEvent.AD_IMPRESSION, this.aOz);
        this.aOK.addEventListener("AdLoadData", this.aOz);
        if (this.aOJ != null && this.aOJ.Eh() != null) {
            this.aOK.setAdResponseInfo(this.aOJ.Eh());
        }
        this.aOK.b(this.aOJ.Ek());
        this.aOK.c(this.aOJ.El());
        this.aOK.d(this.aOJ.getSequenceId());
        this.aOK.request();
    }

    public void recordImpression() {
        if (this.aOJ != null && this.aOJ.Eh() != null && !this.aOJ.Ej()) {
            this.aOK.a(this, this.aOJ.Eh().getPrimaryAdInstanceInfo(), this.aOM);
        }
    }

    private void a() {
        if (this.aOK != null) {
            this.aOK.q();
        }
    }

    private void b() {
        a();
        if (this.aOK != null) {
            this.aOK.p();
        }
    }

    public void setEventListener(BaiduNativeH5EventListner baiduNativeH5EventListner) {
        this.aOL = baiduNativeH5EventListner;
    }
}
