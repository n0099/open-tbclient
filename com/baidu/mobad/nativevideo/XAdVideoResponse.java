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

    /* renamed from: a  reason: collision with root package name */
    NativeResponse f3275a;

    public XAdVideoResponse(IXAdInstanceInfo iXAdInstanceInfo, BaiduNative baiduNative, IXAdFeedsRequestParameters iXAdFeedsRequestParameters, IXAdContainer iXAdContainer) {
        this.f3275a = new XAdNativeResponse(iXAdInstanceInfo, baiduNative, iXAdFeedsRequestParameters, iXAdContainer);
    }

    public XAdVideoResponse(NativeResponse nativeResponse) {
        this.f3275a = nativeResponse;
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public void recordImpression(View view) {
        this.f3275a.recordImpression(view);
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public void handleClick(View view) {
        this.f3275a.handleClick(view);
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public void handleClick(View view, int i) {
        this.f3275a.handleClick(view, i);
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public void onStart(Context context) {
        this.f3275a.onStart(context);
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public void onError(Context context, int i, int i2) {
        this.f3275a.onError(context, i, i2);
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public void onComplete(Context context) {
        this.f3275a.onComplete(context);
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public void onClose(Context context, int i) {
        this.f3275a.onClose(context, i);
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public void onClickAd(Context context) {
        this.f3275a.onClickAd(context);
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public void onFullScreen(Context context, int i) {
        this.f3275a.onFullScreen(context, i);
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public String getVideoUrl() {
        return this.f3275a.getVideoUrl();
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public int getDuration() {
        return this.f3275a.getDuration();
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public BaiduVideoResponse.PrerollMaterialType getMaterialType() {
        BaiduVideoResponse.PrerollMaterialType prerollMaterialType = BaiduVideoResponse.PrerollMaterialType.NORMAL;
        switch (this.f3275a.getMaterialType()) {
            case VIDEO:
                return BaiduVideoResponse.PrerollMaterialType.VIDEO;
            case NORMAL:
                if (this.f3275a.getImageUrl().endsWith(".gif")) {
                    return BaiduVideoResponse.PrerollMaterialType.GIF;
                }
                return prerollMaterialType;
            default:
                return prerollMaterialType;
        }
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public String getImageUrl() {
        return this.f3275a.getImageUrl();
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public boolean isDownloadApp() {
        return this.f3275a.isDownloadApp();
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public String getAdLogoUrl() {
        return this.f3275a.getAdLogoUrl();
    }

    @Override // com.baidu.mobad.nativevideo.BaiduVideoResponse
    public String getBaiduLogoUrl() {
        return this.f3275a.getBaiduLogoUrl();
    }
}
