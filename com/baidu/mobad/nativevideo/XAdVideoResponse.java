package com.baidu.mobad.nativevideo;

import android.view.View;
import com.baidu.mobad.feeds.NativeResponse;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
/* loaded from: classes2.dex */
public class XAdVideoResponse implements e {

    /* renamed from: a  reason: collision with root package name */
    public NativeResponse f8055a;

    /* renamed from: b  reason: collision with root package name */
    public IXAdContainer f8056b;

    /* renamed from: c  reason: collision with root package name */
    public IXAdInstanceInfo f8057c;

    public XAdVideoResponse(NativeResponse nativeResponse, IXAdInstanceInfo iXAdInstanceInfo, IXAdContainer iXAdContainer) {
        this.f8055a = nativeResponse;
        this.f8056b = iXAdContainer;
        this.f8057c = iXAdInstanceInfo;
    }

    public String getAdLogoUrl() {
        NativeResponse nativeResponse = this.f8055a;
        if (nativeResponse != null) {
            return nativeResponse.getAdLogoUrl();
        }
        return null;
    }

    public String getBaiduLogoUrl() {
        NativeResponse nativeResponse = this.f8055a;
        if (nativeResponse != null) {
            return nativeResponse.getBaiduLogoUrl();
        }
        return null;
    }

    public String getDesc() {
        NativeResponse nativeResponse = this.f8055a;
        if (nativeResponse != null) {
            return nativeResponse.getDesc();
        }
        return null;
    }

    public String getIconUrl() {
        NativeResponse nativeResponse = this.f8055a;
        if (nativeResponse != null) {
            return nativeResponse.getIconUrl();
        }
        return null;
    }

    public String getImageUrl() {
        NativeResponse nativeResponse = this.f8055a;
        if (nativeResponse != null) {
            return nativeResponse.getImageUrl();
        }
        return null;
    }

    @Override // com.baidu.mobad.nativevideo.e
    public String getMaterialType() {
        NativeResponse nativeResponse = this.f8055a;
        if (nativeResponse != null) {
            int i = f.f8064a[nativeResponse.getMaterialType().ordinal()];
            if (i == 1) {
                return "video";
            }
            if (i == 2 && this.f8055a.getImageUrl().endsWith(".gif")) {
                return "gif";
            }
        }
        return "normal";
    }

    public String getTitle() {
        NativeResponse nativeResponse = this.f8055a;
        if (nativeResponse != null) {
            return nativeResponse.getTitle();
        }
        return null;
    }

    public String getVideoUrl() {
        NativeResponse nativeResponse = this.f8055a;
        if (nativeResponse != null) {
            return nativeResponse.getVideoUrl();
        }
        return null;
    }

    public void handleClick(View view) {
        NativeResponse nativeResponse = this.f8055a;
        if (nativeResponse != null) {
            nativeResponse.handleClick(view);
        }
    }

    public void recordImpression(View view) {
        NativeResponse nativeResponse = this.f8055a;
        if (nativeResponse != null) {
            nativeResponse.recordImpression(view);
        }
    }

    public void handleClick(View view, int i) {
        NativeResponse nativeResponse = this.f8055a;
        if (nativeResponse != null) {
            nativeResponse.handleClick(view, i);
        }
    }
}
