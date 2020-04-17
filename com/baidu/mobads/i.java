package com.baidu.mobads;

import com.baidu.mobads.BaiduNativeH5AdView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes10.dex */
class i implements Runnable {
    final /* synthetic */ IOAdEvent bkx;
    final /* synthetic */ h blk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, IOAdEvent iOAdEvent) {
        this.blk = hVar;
        this.bkx = iOAdEvent;
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
        if (IXAdEvent.AD_STARTED.equals(this.bkx.getType())) {
            this.blk.blj.f = true;
            baiduNativeAdPlacement4 = this.blk.blj.bkP;
            baiduNativeAdPlacement4.cA(false);
            this.blk.blj.recordImpression();
            baiduNativeH5EventListner7 = this.blk.blj.bkR;
            if (baiduNativeH5EventListner7 != null) {
                baiduNativeH5EventListner8 = this.blk.blj.bkR;
                baiduNativeH5EventListner8.onAdShow();
            }
        } else if (IXAdEvent.AD_ERROR.equals(this.bkx.getType())) {
            baiduNativeAdPlacement3 = this.blk.blj.bkP;
            baiduNativeAdPlacement3.cA(false);
            baiduNativeH5EventListner5 = this.blk.blj.bkR;
            if (baiduNativeH5EventListner5 != null) {
                baiduNativeH5EventListner6 = this.blk.blj.bkR;
                baiduNativeH5EventListner6.onAdFail(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.bkx.getData()));
            }
        } else if ("AdUserClick".equals(this.bkx.getType())) {
            baiduNativeAdPlacement2 = this.blk.blj.bkP;
            baiduNativeAdPlacement2.cB(true);
            baiduNativeH5EventListner3 = this.blk.blj.bkR;
            if (baiduNativeH5EventListner3 != null) {
                baiduNativeH5EventListner4 = this.blk.blj.bkR;
                baiduNativeH5EventListner4.onAdClick();
            }
        } else if (IXAdEvent.AD_IMPRESSION.equals(this.bkx.getType())) {
            baiduNativeAdPlacement = this.blk.blj.bkP;
            baiduNativeAdPlacement.cC(true);
        } else if ("AdLoadData".equals(this.bkx.getType())) {
            this.blk.blj.g = true;
            baiduNativeH5EventListner = this.blk.blj.bkR;
            if (baiduNativeH5EventListner != null) {
                baiduNativeH5EventListner2 = this.blk.blj.bkR;
                baiduNativeH5EventListner2.onAdDataLoaded();
            }
        }
    }
}
