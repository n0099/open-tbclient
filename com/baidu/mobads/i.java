package com.baidu.mobads;

import com.baidu.mobads.BaiduNativeH5AdView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes20.dex */
class i implements Runnable {
    final /* synthetic */ IOAdEvent bCQ;
    final /* synthetic */ h bDC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, IOAdEvent iOAdEvent) {
        this.bDC = hVar;
        this.bCQ = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner;
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner2;
        BaiduNativeAdPlacement baiduNativeAdPlacement;
        BaiduNativeAdPlacement baiduNativeAdPlacement2;
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner3;
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner4;
        BaiduNativeAdPlacement baiduNativeAdPlacement3;
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner5;
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner6;
        BaiduNativeAdPlacement baiduNativeAdPlacement4;
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner7;
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner8;
        if (IXAdEvent.AD_STARTED.equals(this.bCQ.getType())) {
            this.bDC.bDB.f = true;
            baiduNativeAdPlacement4 = this.bDC.bDB.bDh;
            baiduNativeAdPlacement4.db(false);
            this.bDC.bDB.recordImpression();
            baiduNativeH5EventListner7 = this.bDC.bDB.bDj;
            if (baiduNativeH5EventListner7 != null) {
                baiduNativeH5EventListner8 = this.bDC.bDB.bDj;
                baiduNativeH5EventListner8.onAdShow();
            }
        } else if (IXAdEvent.AD_ERROR.equals(this.bCQ.getType())) {
            baiduNativeAdPlacement3 = this.bDC.bDB.bDh;
            baiduNativeAdPlacement3.db(false);
            baiduNativeH5EventListner5 = this.bDC.bDB.bDj;
            if (baiduNativeH5EventListner5 != null) {
                baiduNativeH5EventListner6 = this.bDC.bDB.bDj;
                baiduNativeH5EventListner6.onAdFail(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.bCQ.getData()));
            }
        } else if ("AdUserClick".equals(this.bCQ.getType())) {
            baiduNativeAdPlacement2 = this.bDC.bDB.bDh;
            baiduNativeAdPlacement2.dc(true);
            baiduNativeH5EventListner3 = this.bDC.bDB.bDj;
            if (baiduNativeH5EventListner3 != null) {
                baiduNativeH5EventListner4 = this.bDC.bDB.bDj;
                baiduNativeH5EventListner4.onAdClick();
            }
        } else if (IXAdEvent.AD_IMPRESSION.equals(this.bCQ.getType())) {
            baiduNativeAdPlacement = this.bDC.bDB.bDh;
            baiduNativeAdPlacement.dd(true);
        } else if ("AdLoadData".equals(this.bCQ.getType())) {
            this.bDC.bDB.g = true;
            baiduNativeH5EventListner = this.bDC.bDB.bDj;
            if (baiduNativeH5EventListner != null) {
                baiduNativeH5EventListner2 = this.bDC.bDB.bDj;
                baiduNativeH5EventListner2.onAdDataLoaded();
            }
        }
    }
}
