package com.baidu.lbsapi.model;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class BaiduPoiPanoData extends BaiduPanoData {

    /* renamed from: d  reason: collision with root package name */
    public float f6360d;

    /* renamed from: c  reason: collision with root package name */
    public float f6359c = 0.0f;

    /* renamed from: a  reason: collision with root package name */
    public String f6357a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f6358b = "";

    /* renamed from: e  reason: collision with root package name */
    public String f6361e = "";

    public double getHeading() {
        return this.f6359c;
    }

    public String getIid() {
        return this.f6357a;
    }

    public String getPanoTag() {
        return this.f6361e;
    }

    public float getPitch() {
        return this.f6360d;
    }

    public String getUid() {
        return this.f6358b;
    }

    public boolean hasInnerPano() {
        return !TextUtils.isEmpty(this.f6357a);
    }

    public void setHeading(float f2) {
        this.f6359c = f2;
    }

    public void setIid(String str) {
        this.f6357a = str;
    }

    public void setPanoTag(String str) {
        this.f6361e = str;
    }

    public void setPitch(float f2) {
        this.f6360d = f2;
    }

    public void setUid(String str) {
        this.f6358b = str;
    }

    @Override // com.baidu.lbsapi.model.BaiduPanoData
    public String toString() {
        return super.toString() + "\n BaiduPoiPanoData [heading=" + this.f6359c + ", pitch=" + this.f6360d + ", iid=" + this.f6357a + ",  uid=" + this.f6358b + ", panoTag=" + this.f6361e + ", hasInnerPano=" + hasInnerPano() + "]";
    }
}
