package com.baidu.lbsapi.model;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class BaiduPoiPanoData extends BaiduPanoData {

    /* renamed from: d  reason: collision with root package name */
    public float f6396d;

    /* renamed from: c  reason: collision with root package name */
    public float f6395c = 0.0f;

    /* renamed from: a  reason: collision with root package name */
    public String f6393a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f6394b = "";

    /* renamed from: e  reason: collision with root package name */
    public String f6397e = "";

    public double getHeading() {
        return this.f6395c;
    }

    public String getIid() {
        return this.f6393a;
    }

    public String getPanoTag() {
        return this.f6397e;
    }

    public float getPitch() {
        return this.f6396d;
    }

    public String getUid() {
        return this.f6394b;
    }

    public boolean hasInnerPano() {
        return !TextUtils.isEmpty(this.f6393a);
    }

    public void setHeading(float f2) {
        this.f6395c = f2;
    }

    public void setIid(String str) {
        this.f6393a = str;
    }

    public void setPanoTag(String str) {
        this.f6397e = str;
    }

    public void setPitch(float f2) {
        this.f6396d = f2;
    }

    public void setUid(String str) {
        this.f6394b = str;
    }

    @Override // com.baidu.lbsapi.model.BaiduPanoData
    public String toString() {
        return super.toString() + "\n BaiduPoiPanoData [heading=" + this.f6395c + ", pitch=" + this.f6396d + ", iid=" + this.f6393a + ",  uid=" + this.f6394b + ", panoTag=" + this.f6397e + ", hasInnerPano=" + hasInnerPano() + "]";
    }
}
