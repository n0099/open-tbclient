package com.baidu.lbsapi.model;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class BaiduPoiPanoData extends BaiduPanoData {

    /* renamed from: d  reason: collision with root package name */
    public float f6361d;

    /* renamed from: c  reason: collision with root package name */
    public float f6360c = 0.0f;

    /* renamed from: a  reason: collision with root package name */
    public String f6358a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f6359b = "";

    /* renamed from: e  reason: collision with root package name */
    public String f6362e = "";

    public double getHeading() {
        return this.f6360c;
    }

    public String getIid() {
        return this.f6358a;
    }

    public String getPanoTag() {
        return this.f6362e;
    }

    public float getPitch() {
        return this.f6361d;
    }

    public String getUid() {
        return this.f6359b;
    }

    public boolean hasInnerPano() {
        return !TextUtils.isEmpty(this.f6358a);
    }

    public void setHeading(float f2) {
        this.f6360c = f2;
    }

    public void setIid(String str) {
        this.f6358a = str;
    }

    public void setPanoTag(String str) {
        this.f6362e = str;
    }

    public void setPitch(float f2) {
        this.f6361d = f2;
    }

    public void setUid(String str) {
        this.f6359b = str;
    }

    @Override // com.baidu.lbsapi.model.BaiduPanoData
    public String toString() {
        return super.toString() + "\n BaiduPoiPanoData [heading=" + this.f6360c + ", pitch=" + this.f6361d + ", iid=" + this.f6358a + ",  uid=" + this.f6359b + ", panoTag=" + this.f6362e + ", hasInnerPano=" + hasInnerPano() + "]";
    }
}
