package com.baidu.mobads;

import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class BaiduNativeAdPlacement {

    /* renamed from: a  reason: collision with root package name */
    public String f8120a;

    /* renamed from: b  reason: collision with root package name */
    public IXAdResponseInfo f8121b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8122c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8123d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8124e = false;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<BaiduNativeH5AdView> f8125f = null;

    /* renamed from: g  reason: collision with root package name */
    public int f8126g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f8127h = 1;
    public int i = 1;

    public static void setAppSid(String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    public IXAdResponseInfo getAdResponse() {
        return this.f8121b;
    }

    public BaiduNativeH5AdView getAdView() {
        WeakReference<BaiduNativeH5AdView> weakReference = this.f8125f;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public String getApId() {
        return this.f8120a;
    }

    public int getPosistionId() {
        return this.f8127h;
    }

    public boolean getRequestStarted() {
        return this.f8124e;
    }

    public int getSequenceId() {
        return this.i;
    }

    public int getSessionId() {
        return this.f8126g;
    }

    public boolean hasValidResponse() {
        return this.f8121b != null && isAdAvailable();
    }

    public boolean isAdAvailable() {
        IXAdResponseInfo iXAdResponseInfo = this.f8121b;
        return (iXAdResponseInfo != null && iXAdResponseInfo.getPrimaryAdInstanceInfo() != null && ((System.currentTimeMillis() - this.f8121b.getPrimaryAdInstanceInfo().getCreateTime()) > 1800000L ? 1 : ((System.currentTimeMillis() - this.f8121b.getPrimaryAdInstanceInfo().getCreateTime()) == 1800000L ? 0 : -1)) <= 0) && !this.f8122c;
    }

    public boolean isAdDataLoaded() {
        BaiduNativeH5AdView adView = getAdView();
        if (adView != null) {
            return adView.isAdDataLoaded();
        }
        return false;
    }

    public boolean isWinSended() {
        return this.f8123d;
    }

    public void setAdResponse(IXAdResponseInfo iXAdResponseInfo) {
        this.f8123d = false;
        this.f8121b = iXAdResponseInfo;
    }

    public void setAdView(BaiduNativeH5AdView baiduNativeH5AdView) {
        this.f8125f = new WeakReference<>(baiduNativeH5AdView);
    }

    public void setApId(String str) {
        this.f8120a = str;
    }

    public void setClicked(boolean z) {
        this.f8122c = z;
    }

    public void setPositionId(int i) {
        if (i < 1) {
            return;
        }
        this.f8127h = i;
    }

    public void setRequestStarted(boolean z) {
        this.f8124e = z;
    }

    public void setSessionId(int i) {
        if (i < 1) {
            return;
        }
        this.f8126g = i;
        this.i = g.a().a(i);
    }

    public void setWinSended(boolean z) {
        this.f8123d = z;
    }
}
