package com.baidu.mobads.production.b;

import com.baidu.mobad.feeds.BaiduNative;
import com.baidu.mobad.feeds.BaiduNativeManager;
import com.baidu.mobad.feeds.NativeErrorCode;
import com.baidu.mobad.feeds.NativeResponse;
import com.baidu.mobad.feeds.XAdNativeResponse;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements BaiduNative.BaiduNativeLoadAdListener {

    /* renamed from: a  reason: collision with root package name */
    public BaiduNativeManager.FeedAdListener f8443a;

    public a(BaiduNativeManager.FeedAdListener feedAdListener) {
        this.f8443a = feedAdListener;
    }

    @Override // com.baidu.mobad.feeds.BaiduNative.NativeADEventListener
    public void onADExposed(NativeResponse nativeResponse) {
        if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).onADExposed();
        }
    }

    @Override // com.baidu.mobad.feeds.BaiduNative.FeedLpCloseListener
    public void onAdClick(NativeResponse nativeResponse) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f8443a;
        if (feedAdListener != null && (feedAdListener instanceof BaiduNativeManager.PortraitVideoAdListener)) {
            ((BaiduNativeManager.PortraitVideoAdListener) feedAdListener).onAdClick();
        } else if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).onAdClick();
        }
    }

    @Override // com.baidu.mobad.feeds.BaiduNative.BaiduNativeLoadAdListener
    public void onLoadFail(String str, String str2) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f8443a;
        if (feedAdListener instanceof BaiduNativeManager.NativeLoadListener) {
            ((BaiduNativeManager.NativeLoadListener) feedAdListener).onLoadFail(str, str2);
        }
    }

    @Override // com.baidu.mobad.feeds.BaiduNative.FeedLpCloseListener
    public void onLpClosed() {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f8443a;
        if (feedAdListener != null) {
            feedAdListener.onLpClosed();
        }
    }

    @Override // com.baidu.mobad.feeds.BaiduNative.BaiduNativeNetworkListener
    public void onNativeFail(NativeErrorCode nativeErrorCode) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f8443a;
        if (feedAdListener != null) {
            feedAdListener.onNativeFail(nativeErrorCode);
        }
    }

    @Override // com.baidu.mobad.feeds.BaiduNative.BaiduNativeNetworkListener
    public void onNativeLoad(List<NativeResponse> list) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f8443a;
        if (feedAdListener != null) {
            feedAdListener.onNativeLoad(list);
        }
    }

    @Override // com.baidu.mobad.feeds.BaiduNative.VideoCacheListener
    public void onVideoDownloadFailed() {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f8443a;
        if (feedAdListener != null) {
            feedAdListener.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobad.feeds.BaiduNative.VideoCacheListener
    public void onVideoDownloadSuccess() {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f8443a;
        if (feedAdListener != null) {
            feedAdListener.onVideoDownloadSuccess();
        }
    }
}
