package com.baidu.mobads;

import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class BaiduNativeAdPlacement {

    /* renamed from: a  reason: collision with root package name */
    public String f8119a;

    /* renamed from: b  reason: collision with root package name */
    public IXAdResponseInfo f8120b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8121c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8122d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8123e = false;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<BaiduNativeH5AdView> f8124f = null;

    /* renamed from: g  reason: collision with root package name */
    public int f8125g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f8126h = 1;
    public int i = 1;

    public static void setAppSid(String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    public IXAdResponseInfo getAdResponse() {
        return this.f8120b;
    }

    public BaiduNativeH5AdView getAdView() {
        WeakReference<BaiduNativeH5AdView> weakReference = this.f8124f;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public String getApId() {
        return this.f8119a;
    }

    public int getPosistionId() {
        return this.f8126h;
    }

    public boolean getRequestStarted() {
        return this.f8123e;
    }

    public int getSequenceId() {
        return this.i;
    }

    public int getSessionId() {
        return this.f8125g;
    }

    public boolean hasValidResponse() {
        return this.f8120b != null && isAdAvailable();
    }

    public boolean isAdAvailable() {
        IXAdResponseInfo iXAdResponseInfo = this.f8120b;
        return (iXAdResponseInfo != null && iXAdResponseInfo.getPrimaryAdInstanceInfo() != null && ((System.currentTimeMillis() - this.f8120b.getPrimaryAdInstanceInfo().getCreateTime()) > 1800000L ? 1 : ((System.currentTimeMillis() - this.f8120b.getPrimaryAdInstanceInfo().getCreateTime()) == 1800000L ? 0 : -1)) <= 0) && !this.f8121c;
    }

    public boolean isAdDataLoaded() {
        BaiduNativeH5AdView adView = getAdView();
        if (adView != null) {
            return adView.isAdDataLoaded();
        }
        return false;
    }

    public boolean isWinSended() {
        return this.f8122d;
    }

    public void setAdResponse(IXAdResponseInfo iXAdResponseInfo) {
        this.f8122d = false;
        this.f8120b = iXAdResponseInfo;
    }

    public void setAdView(BaiduNativeH5AdView baiduNativeH5AdView) {
        this.f8124f = new WeakReference<>(baiduNativeH5AdView);
    }

    public void setApId(String str) {
        this.f8119a = str;
    }

    public void setClicked(boolean z) {
        this.f8121c = z;
    }

    public void setPositionId(int i) {
        if (i < 1) {
            return;
        }
        this.f8126h = i;
    }

    public void setRequestStarted(boolean z) {
        this.f8123e = z;
    }

    public void setSessionId(int i) {
        if (i < 1) {
            return;
        }
        this.f8125g = i;
        this.i = g.a().a(i);
    }

    public void setWinSended(boolean z) {
        this.f8122d = z;
    }
}
