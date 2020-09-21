package com.baidu.mobad.nativevideo;

import android.content.Context;
import android.view.View;
import com.baidu.mobad.feeds.BaiduNative;
import com.baidu.mobad.feeds.NativeResponse;
import com.baidu.mobad.feeds.XAdNativeResponse;
import com.baidu.mobad.nativevideo.BaiduVideoResponse;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
/* loaded from: classes3.dex */
class XAdVideoResponse implements BaiduVideoResponse {
    NativeResponse a;

    public XAdVideoResponse(IXAdInstanceInfo iXAdInstanceInfo, BaiduNative baiduNative, IXAdFeedsRequestParameters iXAdFeedsRequestParameters, IXAdContainer iXAdContainer) {
        this.a = new XAdNativeResponse(iXAdInstanceInfo, baiduNative, iXAdFeedsRequestParameters, iXAdContainer);
    }

    public XAdVideoResponse(NativeResponse nativeResponse) {
        this.a = nativeResponse;
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public void recordImpression(View view) {
        this.a.recordImpression(view);
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public void handleClick(View view) {
        this.a.handleClick(view);
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public void handleClick(View view, int i) {
        this.a.handleClick(view, i);
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public void onStart(Context context) {
        this.a.onStart(context);
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public void onError(Context context, int i, int i2) {
        this.a.onError(context, i, i2);
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public void onComplete(Context context) {
        this.a.onComplete(context);
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public void onClose(Context context, int i) {
        this.a.onClose(context, i);
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public void onClickAd(Context context) {
        this.a.onClickAd(context);
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public void onFullScreen(Context context, int i) {
        this.a.onFullScreen(context, i);
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public String getVideoUrl() {
        return this.a.getVideoUrl();
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public int getDuration() {
        return this.a.getDuration();
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public BaiduVideoResponse.PrerollMaterialType getMaterialType() {
        BaiduVideoResponse.PrerollMaterialType prerollMaterialType = BaiduVideoResponse.PrerollMaterialType.NORMAL;
        switch (this.a.getMaterialType()) {
            case VIDEO:
                return BaiduVideoResponse.PrerollMaterialType.VIDEO;
            case NORMAL:
                if (this.a.getImageUrl().endsWith(".gif")) {
                    return BaiduVideoResponse.PrerollMaterialType.GIF;
                }
                return prerollMaterialType;
            default:
                return prerollMaterialType;
        }
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public String getImageUrl() {
        return this.a.getImageUrl();
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public boolean isDownloadApp() {
        return this.a.isDownloadApp();
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public String getAdLogoUrl() {
        return this.a.getAdLogoUrl();
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public String getBaiduLogoUrl() {
        return this.a.getBaiduLogoUrl();
    }
}
