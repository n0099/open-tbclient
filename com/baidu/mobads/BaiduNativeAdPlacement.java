package com.baidu.mobads;

import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.lang.ref.WeakReference;
/* loaded from: classes20.dex */
public class BaiduNativeAdPlacement {
    private String a;
    private IXAdResponseInfo bxy;
    private boolean c;
    private boolean d;
    private boolean e = false;
    private WeakReference<BaiduNativeH5AdView> f = null;
    private int g = 0;
    private int h = 1;
    private int i = 1;

    /* JADX INFO: Access modifiers changed from: protected */
    public void cT(boolean z) {
        this.e = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Nt() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(BaiduNativeH5AdView baiduNativeH5AdView) {
        this.f = new WeakReference<>(baiduNativeH5AdView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaiduNativeH5AdView Nu() {
        if (this.f == null) {
            return null;
        }
        return this.f.get();
    }

    public void setApId(String str) {
        this.a = str;
    }

    public String getApId() {
        return this.a;
    }

    public static void setAppSid(String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    public void setAdResponse(IXAdResponseInfo iXAdResponseInfo) {
        this.d = false;
        this.bxy = iXAdResponseInfo;
    }

    public boolean hasValidResponse() {
        return this.bxy != null && Nw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IXAdResponseInfo Nv() {
        return this.bxy;
    }

    protected boolean Nw() {
        boolean z;
        if (this.bxy == null || this.bxy.getPrimaryAdInstanceInfo() == null) {
            z = false;
        } else {
            z = System.currentTimeMillis() - this.bxy.getPrimaryAdInstanceInfo().getCreateTime() <= 1800000;
        }
        return z && !this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Nx() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cU(boolean z) {
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cV(boolean z) {
        this.d = z;
    }

    public boolean isAdDataLoaded() {
        BaiduNativeH5AdView Nu = Nu();
        if (Nu != null) {
            return Nu.isAdDataLoaded();
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
    public int Ny() {
        return this.g;
    }

    public void setPositionId(int i) {
        if (i >= 1) {
            this.h = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int Nz() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSequenceId() {
        return this.i;
    }
}
