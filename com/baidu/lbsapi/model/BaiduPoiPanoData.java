package com.baidu.lbsapi.model;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class BaiduPoiPanoData extends BaiduPanoData {

    /* renamed from: d  reason: collision with root package name */
    public float f6581d;

    /* renamed from: c  reason: collision with root package name */
    public float f6580c = 0.0f;

    /* renamed from: a  reason: collision with root package name */
    public String f6578a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f6579b = "";

    /* renamed from: e  reason: collision with root package name */
    public String f6582e = "";

    public double getHeading() {
        return this.f6580c;
    }

    public String getIid() {
        return this.f6578a;
    }

    public String getPanoTag() {
        return this.f6582e;
    }

    public float getPitch() {
        return this.f6581d;
    }

    public String getUid() {
        return this.f6579b;
    }

    public boolean hasInnerPano() {
        return !TextUtils.isEmpty(this.f6578a);
    }

    public void setHeading(float f2) {
        this.f6580c = f2;
    }

    public void setIid(String str) {
        this.f6578a = str;
    }

    public void setPanoTag(String str) {
        this.f6582e = str;
    }

    public void setPitch(float f2) {
        this.f6581d = f2;
    }

    public void setUid(String str) {
        this.f6579b = str;
    }

    @Override // com.baidu.lbsapi.model.BaiduPanoData
    public String toString() {
        return super.toString() + "\n BaiduPoiPanoData [heading=" + this.f6580c + ", pitch=" + this.f6581d + ", iid=" + this.f6578a + ",  uid=" + this.f6579b + ", panoTag=" + this.f6582e + ", hasInnerPano=" + hasInnerPano() + "]";
    }
}
