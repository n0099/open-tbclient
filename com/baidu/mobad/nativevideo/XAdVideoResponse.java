package com.baidu.mobad.nativevideo;

import android.view.View;
import com.baidu.mobad.feeds.NativeResponse;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
/* loaded from: classes5.dex */
public class XAdVideoResponse implements e {

    /* renamed from: a  reason: collision with root package name */
    NativeResponse f3243a;

    /* renamed from: b  reason: collision with root package name */
    private IXAdContainer f3244b;
    private IXAdInstanceInfo c;

    public XAdVideoResponse(NativeResponse nativeResponse, IXAdInstanceInfo iXAdInstanceInfo, IXAdContainer iXAdContainer) {
        this.f3243a = nativeResponse;
        this.f3244b = iXAdContainer;
        this.c = iXAdInstanceInfo;
    }

    public void recordImpression(View view) {
        if (this.f3243a != null) {
            this.f3243a.recordImpression(view);
        }
    }

    public void handleClick(View view) {
        if (this.f3243a != null) {
            this.f3243a.handleClick(view);
        }
    }

    public void handleClick(View view, int i) {
        if (this.f3243a != null) {
            this.f3243a.handleClick(view, i);
        }
    }

    @Override // com.baidu.mobad.nativevideo.e
    public String getMaterialType() {
        if (this.f3243a == null) {
            return "normal";
        }
        switch (this.f3243a.getMaterialType()) {
            case VIDEO:
                return "video";
            case NORMAL:
                if (!this.f3243a.getImageUrl().endsWith(".gif")) {
                    return "normal";
                }
                return "gif";
            default:
                return "normal";
        }
    }

    public String getAdLogoUrl() {
        if (this.f3243a != null) {
            return this.f3243a.getAdLogoUrl();
        }
        return null;
    }

    public String getBaiduLogoUrl() {
        if (this.f3243a != null) {
            return this.f3243a.getBaiduLogoUrl();
        }
        return null;
    }

    public String getImageUrl() {
        if (this.f3243a != null) {
            return this.f3243a.getImageUrl();
        }
        return null;
    }

    public String getIconUrl() {
        if (this.f3243a != null) {
            return this.f3243a.getIconUrl();
        }
        return null;
    }

    public String getTitle() {
        if (this.f3243a != null) {
            return this.f3243a.getTitle();
        }
        return null;
    }

    public String getDesc() {
        if (this.f3243a != null) {
            return this.f3243a.getDesc();
        }
        return null;
    }

    public String getVideoUrl() {
        if (this.f3243a != null) {
            return this.f3243a.getVideoUrl();
        }
        return null;
    }
}
