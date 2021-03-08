package com.baidu.mobads.production.b;

import com.baidu.mobad.feeds.BaiduNative;
import com.baidu.mobad.feeds.BaiduNativeManager;
import com.baidu.mobad.feeds.NativeErrorCode;
import com.baidu.mobad.feeds.NativeResponse;
import com.baidu.mobad.feeds.XAdNativeResponse;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements BaiduNative.BaiduNativeLoadAdListener {

    /* renamed from: a  reason: collision with root package name */
    private BaiduNativeManager.FeedAdListener f2446a;

    public a(BaiduNativeManager.FeedAdListener feedAdListener) {
        this.f2446a = feedAdListener;
    }

    @Override // com.baidu.mobad.feeds.BaiduNative.BaiduNativeNetworkListener
    public void onNativeLoad(List<NativeResponse> list) {
        if (this.f2446a != null) {
            this.f2446a.onNativeLoad(list);
        }
    }

    @Override // com.baidu.mobad.feeds.BaiduNative.BaiduNativeNetworkListener
    public void onNativeFail(NativeErrorCode nativeErrorCode) {
        if (this.f2446a != null) {
            this.f2446a.onNativeFail(nativeErrorCode);
        }
    }

    @Override // com.baidu.mobad.feeds.BaiduNative.NativeADEventListener
    public void onADExposed(NativeResponse nativeResponse) {
        if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).onADExposed();
        }
    }

    @Override // com.baidu.mobad.feeds.BaiduNative.FeedLpCloseListener
    public void onAdClick(NativeResponse nativeResponse) {
        if (this.f2446a != null && (this.f2446a instanceof BaiduNativeManager.PortraitVideoAdListener)) {
            ((BaiduNativeManager.PortraitVideoAdListener) this.f2446a).onAdClick();
        } else if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).onAdClick();
        }
    }

    @Override // com.baidu.mobad.feeds.BaiduNative.FeedLpCloseListener
    public void onLpClosed() {
        if (this.f2446a != null) {
            this.f2446a.onLpClosed();
        }
    }

    @Override // com.baidu.mobad.feeds.BaiduNative.VideoCacheListener
    public void onVideoDownloadSuccess() {
        if (this.f2446a != null) {
            this.f2446a.onVideoDownloadSuccess();
        }
    }

    @Override // com.baidu.mobad.feeds.BaiduNative.VideoCacheListener
    public void onVideoDownloadFailed() {
        if (this.f2446a != null) {
            this.f2446a.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobad.feeds.BaiduNative.BaiduNativeLoadAdListener
    public void onLoadFail(String str, String str2) {
        if (this.f2446a instanceof BaiduNativeManager.NativeLoadListener) {
            ((BaiduNativeManager.NativeLoadListener) this.f2446a).onLoadFail(str, str2);
        }
    }
}
