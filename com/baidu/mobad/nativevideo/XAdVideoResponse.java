package com.baidu.mobad.nativevideo;

import android.view.View;
import com.baidu.mobad.feeds.NativeResponse;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
/* loaded from: classes4.dex */
public class XAdVideoResponse implements e {

    /* renamed from: a  reason: collision with root package name */
    NativeResponse f2329a;
    private IXAdContainer b;
    private IXAdInstanceInfo c;

    public XAdVideoResponse(NativeResponse nativeResponse, IXAdInstanceInfo iXAdInstanceInfo, IXAdContainer iXAdContainer) {
        this.f2329a = nativeResponse;
        this.b = iXAdContainer;
        this.c = iXAdInstanceInfo;
    }

    public void recordImpression(View view) {
        if (this.f2329a != null) {
            this.f2329a.recordImpression(view);
        }
    }

    public void handleClick(View view) {
        if (this.f2329a != null) {
            this.f2329a.handleClick(view);
        }
    }

    public void handleClick(View view, int i) {
        if (this.f2329a != null) {
            this.f2329a.handleClick(view, i);
        }
    }

    @Override // com.baidu.mobad.nativevideo.e
    public String getMaterialType() {
        if (this.f2329a == null) {
            return "normal";
        }
        switch (this.f2329a.getMaterialType()) {
            case VIDEO:
                return "video";
            case NORMAL:
                if (!this.f2329a.getImageUrl().endsWith(".gif")) {
                    return "normal";
                }
                return "gif";
            default:
                return "normal";
        }
    }

    public String getAdLogoUrl() {
        if (this.f2329a != null) {
            return this.f2329a.getAdLogoUrl();
        }
        return null;
    }

    public String getBaiduLogoUrl() {
        if (this.f2329a != null) {
            return this.f2329a.getBaiduLogoUrl();
        }
        return null;
    }

    public String getImageUrl() {
        if (this.f2329a != null) {
            return this.f2329a.getImageUrl();
        }
        return null;
    }

    public String getIconUrl() {
        if (this.f2329a != null) {
            return this.f2329a.getIconUrl();
        }
        return null;
    }

    public String getTitle() {
        if (this.f2329a != null) {
            return this.f2329a.getTitle();
        }
        return null;
    }

    public String getDesc() {
        if (this.f2329a != null) {
            return this.f2329a.getDesc();
        }
        return null;
    }

    public String getVideoUrl() {
        if (this.f2329a != null) {
            return this.f2329a.getVideoUrl();
        }
        return null;
    }
}
