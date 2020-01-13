package com.baidu.mobads;

import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class BaiduNativeAdPlacement {
    private String a;
    private IXAdResponseInfo aKD;
    private boolean c;
    private boolean d;
    private boolean e = false;
    private WeakReference<BaiduNativeH5AdView> f = null;
    private int g = 0;
    private int h = 1;
    private int i = 1;

    /* JADX INFO: Access modifiers changed from: protected */
    public void bC(boolean z) {
        this.e = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean BN() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(BaiduNativeH5AdView baiduNativeH5AdView) {
        this.f = new WeakReference<>(baiduNativeH5AdView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaiduNativeH5AdView BO() {
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
        this.aKD = iXAdResponseInfo;
    }

    public boolean hasValidResponse() {
        return this.aKD != null && BQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IXAdResponseInfo BP() {
        return this.aKD;
    }

    protected boolean BQ() {
        boolean z;
        if (this.aKD == null || this.aKD.getPrimaryAdInstanceInfo() == null) {
            z = false;
        } else {
            z = System.currentTimeMillis() - this.aKD.getPrimaryAdInstanceInfo().getCreateTime() <= 1800000;
        }
        return z && !this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean BR() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bD(boolean z) {
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bE(boolean z) {
        this.d = z;
    }

    public boolean isAdDataLoaded() {
        BaiduNativeH5AdView BO = BO();
        if (BO != null) {
            return BO.isAdDataLoaded();
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
    public int BS() {
        return this.g;
    }

    public void setPositionId(int i) {
        if (i >= 1) {
            this.h = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int BT() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSequenceId() {
        return this.i;
    }
}
