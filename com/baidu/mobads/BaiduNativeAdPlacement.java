package com.baidu.mobads;

import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class BaiduNativeAdPlacement {

    /* renamed from: a  reason: collision with root package name */
    private String f2301a;
    private IXAdResponseInfo b;
    private boolean c;
    private boolean d;
    private boolean e = false;
    private WeakReference<BaiduNativeH5AdView> f = null;
    private int g = 0;
    private int h = 1;
    private int i = 1;

    /* JADX INFO: Access modifiers changed from: protected */
    public void setRequestStarted(boolean z) {
        this.e = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean getRequestStarted() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAdView(BaiduNativeH5AdView baiduNativeH5AdView) {
        this.f = new WeakReference<>(baiduNativeH5AdView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaiduNativeH5AdView getAdView() {
        if (this.f == null) {
            return null;
        }
        return this.f.get();
    }

    public void setApId(String str) {
        this.f2301a = str;
    }

    public String getApId() {
        return this.f2301a;
    }

    public static void setAppSid(String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    public void setAdResponse(IXAdResponseInfo iXAdResponseInfo) {
        this.d = false;
        this.b = iXAdResponseInfo;
    }

    public boolean hasValidResponse() {
        return this.b != null && isAdAvailable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IXAdResponseInfo getAdResponse() {
        return this.b;
    }

    protected boolean isAdAvailable() {
        boolean z;
        if (this.b == null || this.b.getPrimaryAdInstanceInfo() == null) {
            z = false;
        } else {
            z = System.currentTimeMillis() - this.b.getPrimaryAdInstanceInfo().getCreateTime() <= 1800000;
        }
        return z && !this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isWinSended() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setClicked(boolean z) {
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setWinSended(boolean z) {
        this.d = z;
    }

    public boolean isAdDataLoaded() {
        BaiduNativeH5AdView adView = getAdView();
        if (adView != null) {
            return adView.isAdDataLoaded();
        }
        return false;
    }

    public void setSessionId(int i) {
        if (i >= 1) {
            this.g = i;
            this.i = g.a().a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSessionId() {
        return this.g;
    }

    public void setPositionId(int i) {
        if (i >= 1) {
            this.h = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getPosistionId() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSequenceId() {
        return this.i;
    }
}
